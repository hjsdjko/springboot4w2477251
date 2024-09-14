<template>
	<uni-popup ref="popup" type="bottom" :safe-area="safeArea" @change="popChange">
		<view class="date-time-picker" v-if="showPopPicker">
			<!-- <view class="date-time-mask" @click.stop="hide"></view> -->
			<view class="date-time-container" :class="{'safe-area-padding':!safeArea}" @click.stop="handleEvent">
				<view class="time-picker-tool">
					<view class="cancel-base" :class="[cancelButtonClass]" @click.stop="close">
						<text>{{cancelButtonText}}</text>
					</view>
					<view :class="[toolBarTitleClass]">
						<text>{{toolBarTitle}}</text>
					</view>
					<view class="confirm-base" :class="[confirmButtonClass]" @click.stop="confirm">
						<text>{{confirmButtonText}}</text>
					</view>
				</view>
				<view class="picker-tab" v-if="isShowRange">
					<view @click="dateTabChange(1)" class="picker-tab-item" :style="[rangeBtnStyle,dateTab==1?rangeBtnActiveStyle:'']"
					>{{pickerData.startTime}}</view>
					至
					<view @click="dateTabChange(2)" class="picker-tab-item" :style="[rangeBtnStyle,dateTab==2?rangeBtnActiveStyle:'']"
					>{{pickerData.endTime}}</view>
				</view>
				<picker-view class="picker-view" :indicator-style="popupIndicatorStyleString" :value="dateTime" @change="dateTimePickerChange" @pickstart="dateTimePickerStart" @touchstart="dateTimePickerStart">
					<picker-view-column data-id='year' v-if='isShowYear'>
						<view class="item" v-for="(item,index) in years" :key="index">{{item}}年</view>
					</picker-view-column>
					<picker-view-column data-id='month' v-if='isShowMonth'>
						<view class="item" v-for="(item,index) in months" :key="index">{{item}}月</view>
					</picker-view-column>
					<picker-view-column data-id='day' v-if='isShowDay'>
						<view class="item" v-for="(item,index) in days" :key="index">{{item}}日</view>
					</picker-view-column>
					<picker-view-column data-id='hour' v-if='isShowHour'>
						<view class="item" v-for="(item,index) in hours" :key="index">{{item}}时</view>
					</picker-view-column>
					<picker-view-column data-id='minute' v-if='isShowMinute'>
						<view class="item" v-for="(item,index) in minutes" :key="index">{{item}}分</view>
					</picker-view-column>
					<picker-view-column data-id='second' v-if='isShowSecond'>
						<view class="item" v-for="(item,index) in seconds" :key="index">{{item}}秒</view>
					</picker-view-column>
					<picker-view-column data-id='week' v-if='isShowWeek'>
						<view class="item" v-for="(item,index) in weeks" :key="index">{{item}}</view>
					</picker-view-column>
					<picker-view-column data-id='quarter' v-if='isShowQuarter'>
						<view class="item" v-for="(item,index) in quarters" :key="index">{{item}}</view>
					</picker-view-column>
				</picker-view>
			</view>
		</view>
	</uni-popup>
</template>

<script>
	import {
		getOneMonthDays,
		getTimeArray,
		addZero,
		removeZero,
		getIndexOfArray,
		getQuarterArray,
		isOnlyTime,
		isRange,
		getTotalWeeks,
		getFirstAndLastDate
	} from './uitls/util.js'
	const [year, month, date, hour, minute, second]=getTimeArray(new Date());
	export default {
		name: 'TimePicker',
		props: {
			minDate: { //最小选择时间 
				type: Object,
				default: function() {
					return {
						year: 1970,
						month: 1,
						date: 1,
						hour:0,
						minute:0,
						second:0
					}
				}
			},
			maxDate: { //最大选择时间 
				type: Object,
				default: function() {
					return {
						year,
						month,
						date,
						hour:23,
						minute:59,
						second:59
					}
				}
			},
			type: {
				/**
				 * date 年月日
				 * year-month 年月
				 * year 年
				 * datetime 年月日 时分
				 * datetime-all 年月日 时分秒
				 * time 时分秒
				 * hour-minute 时分
				 * week 周
				 * quarter 季度
				 * year-range 年-范围
				 * year-month-range 年月-范围
				 * date-range 年月日-范围
				 * datetime-range 年月日 时分-范围
				 * datetime-all-range 年月日 时分秒-范围
				 * time-range 时分秒-范围
				 */
				type: String,
				default: 'date'
			},
			defaultData: {
				type: Object,
				default: function() {
					return {
						startTime: "", //默认开始日期/时间 yyyy-mm-dd (HH:MM:SS)
						endTime: "", //默认结束日期/时间 yyyy-mm-dd (HH:MM:SS)
						year: "", //默认年份		yyyy		
						month: "", //默认年-月份 yyyy-mm
						week: "", //默认周 2020 第1周
						quarter: "", //默认季度 2020 一季度
					}
				}
			},
			popIindicatorStyle:{
				type: Object,
				default: null
			},
			rangeBtnStyle: { // 范围选择按钮样式
				type: Object,
				default: function(){
					return {
						color:'#666'
					}
				}
			},
			rangeBtnActiveStyle: { // 范围选择按钮激活样式
				type: Object,
				default: function(){
					return {
						color:'#049bff',
						borderColor:'#049bff'
					}
				}
			},
			cancelButtonText: {
				type: String,
				default: '取消'
			},
			cancelButtonClass: {
				type: String,
				default: 'cancel-btn'
			},
			toolBarTitle: {
				type: String,
				default: ''
			},
			toolBarTitleClass: {
				type: String,
				default: 'tool-title'
			},
			confirmButtonText: {
				type: String,
				default: '确定'
			},
			confirmButtonClass: {
				type: String,
				default: 'confirm-btn'
			},
			safeArea: {
				type: Boolean,
				default: true
			},
			en: {
				type: Boolean,
				default: false
			},
			weekType:{
				type:String,
				default:'firstWeek' // firstWeek fullWeek firstDay
			}
		},
		data() {
			return {
				isPickend: true,
				showPopPicker: false,
				dateTab: 1,
				popupIndicatorStyleString:"",
				dateTime: [],//picker-view-column 选中的值
				lastDateTime: [],//选中的时间,小于10的数不加0
				days: [],//可选的日列表
				months: [],//可选的月列表
				quarters: getQuarterArray(1, 12),//可选的季度列表
				weeks: [], //可选的周列表
				hours: [], //可选的时列表
				minutes: [], //可选的分列表
				seconds: [], //可选的秒列表
				datestring: "",//选中的时间,格式化后的展示
				allQuarter: [{
						name: "一季度",
						start: "01-01",
						end: "03-31"
					},
					{
						name: "二季度",
						start: "04-01",
						end: "06-30"
					},
					{
						name: "三季度",
						start: "07-01",
						end: "09-30"
					},
					{
						name: "四季度",
						start: "10-01",
						end: "12-31"
					}
				],
				pickerData: {
					startTime: "",
					endTime: "",
					month: "",
					quarter: "",
					year: ""
				}
			};
		},
		methods: {
			showPop() {
				this.dateTab = 1;
				this.getPopIndicatorStyle();
				this.showPopPicker = true;
				this.tempTime = new Date().getTime();
				this.$refs.popup.open();
			},
			close() {
				this.$emit('close');
				this.showPopPicker = false;
				this.$refs.popup.close();
				this.pickerData={
					startTime: "",
					endTime: "",
					month: "",
					quarter: "",
					year: ""
				}
				this.lastDateTime=[];
			},
			dateTabChange(i) {
				if (this.dateTab == i) {
					return;
				}
				this.dateTab = i;
				this.datestring = i == 2 ? this.pickerData.endTime : this.pickerData.startTime;
				this.initDateTime();
				this.tempTime = new Date().getTime();
			},
			dateTimePickerStart() {
				this.isPickend = false;
			},
			dateTimePickerChange(e) {
				if(new Date().getTime()-this.tempTime < 100){
					//dateTimePickerChange 小程序端有时点击dateTabChange就触发了change
					// console.log("无效滚动")
					return;
				}
				this.tempTime = new Date().getTime();
				let columns = [...e.target.value];
				let currentDateList=[];

				if (isOnlyTime(this.type)) {
					currentDateList = [this.hours[columns[0]],this.minutes[columns[1]],this.seconds[columns[2]]];
					let tag = 2;
					if(currentDateList[1]!=this.lastDateTime[1]){
						tag = 3;
					}
					let minTag = currentDateList[0] == this.realMinDate.hour;
					let maxTag = currentDateList[0] == this.realMaxDate.hour;
					if(tag > 2) {
						minTag = minTag && currentDateList[1] == this.realMinDate.minute;
						maxTag = maxTag && currentDateList[1] == this.realMaxDate.minute;
					}
					
					this.getHMSColumnsData(currentDateList, this.lastDateTime, tag, minTag, maxTag);
				} else if (this.type === "week") {
					if (this.lastDateTime[0] != this.years[columns[0]]) {
						this.getWeeks(this.years[columns[0]]);	
					}
				} else if (this.type === "quarter") {
					if (this.lastDateTime[0] != this.years[columns[0]]) {
						if (columns[0] == 0) {
							this.quarters = getQuarterArray(this.realMinDate.month, 12);
						} else if (columns[0] == this.years.length - 1) {
							this.quarters = getQuarterArray(1, this.realMaxDate.month);
						} else {
							this.quarters = getQuarterArray(1, 12);
						}
					}
				} else {
					currentDateList=[this.years[columns[0]],this.months[columns[1]],this.days[columns[2]],this.hours[columns[3]],this.minutes[columns[4]],this.seconds[columns[5]]];
					this.getColumnsData(currentDateList, this.lastDateTime);
				}
				setTimeout(() => {
					if (this.type === "week") {
						if (this.lastDateTime[0] != this.years[columns[0]]) {
							let index = columns[1];
							index = this.weeks.findIndex(val => val == this.lastDateTime[1]);
							if (index < 0) {
								index = columns[0] == 0 ? 0 : this.weeks.length - 1;
							}
							columns.splice(1, 1, index)
						}
					} else if (this.type === "quarter") {
						if (this.lastDateTime[0] != this.years[columns[0]]) {
							let index = columns[1];
							index = this.quarters.findIndex(val => val == this.lastDateTime[1]);
							if (index < 0) {
								index = columns[0] == 0 ? 0 : this.quarters.length - 1;
							}
							columns.splice(1, 1, index)
						}
					} else {
						let names = ['year', 'month', 'day', 'hour', 'minute', 'second'];
						if (isOnlyTime(this.type)){
							names=names.slice(3);
						}
						const arr = [];
						let i = 1;
						while(i < currentDateList.length && currentDateList[i] != undefined) {
							const colName = names[i] + 's';
							let index = this[colName].findIndex(val => val == currentDateList[i]);
							if (index < 0) {
								index = currentDateList[i] <= this[colName][0] ? 0 : this[colName].length - 1;
							}
							arr.push(index);
							i++;
						}
						columns.splice(1, columns.length-1, ...arr);
					}
					columns.forEach((column, index) => {
						this.dateTime.splice(index, 1, column);
					})
					this.formatDate();
				},50)
			},
			formatDate() {//选中的时间记录 及格式化
				let names = ['year', 'month', 'day', 'hour', 'minute', 'second'];
				let dateString, formatDateArray = [];
				if (['date','year','year-month','year-range','year-month-range','date-range'].includes(this.type)) {
					formatDateArray = this.dateTime.map((item, index) => {
						let num=this[names[index] + 's'][item] ? this[names[index] + 's'][item] : this[names[index] + 's'][this[names[index] + 's'].length-1];
						return  addZero(num);
					})
					dateString = formatDateArray.join('-');
				} else if (isOnlyTime(this.type)) {
					names = names.splice(3);
					formatDateArray = this.dateTime.map((item, index) => {
						return addZero(this[names[index] + 's'][item]);
					})
					dateString = formatDateArray.join(':');
				} else if (this.type === "week") {
					dateString = this.years[this.dateTime[0]] + " " + this.weeks[this.dateTime[1]];
				} else if (this.type === "quarter") {
					dateString = this.years[this.dateTime[0]] + " " + this.quarters[this.dateTime[1]];
				} else {
					let name1 = names.splice(0, 3);
					formatDateArray = this.dateTime.map((item, index) => {
						if (index > 2) {
							return addZero(this[names[index - 3] + 's'][item]);
						} else {
							return addZero(this[name1[index] + 's'][item]);
						}
					})
					dateString = formatDateArray.splice(0, 3).join('-') + ' ' + formatDateArray.join(':');
				}
				if(['week','quarter'].includes(this.type)){
					this.lastDateTime = dateString.split(/[-: ]/);
				}else{
					let tempDate = [];
					dateString.split(/[-: ]/).forEach((val) => {
						tempDate.push(parseInt(removeZero(val)));
					})
					this.lastDateTime = tempDate;
				}
				
				switch (this.type) {
					case "date":
					case "datetime":
					case "datetime-all":
					case "time":
					case "hour-minute":
					case "year-range":
					case "year-month-range":
					case "date-range":
					case "datetime-range":
					case "datetime-all-range":
					case "time-range":
						if (this.dateTab == 2) {
							this.pickerData.endTime = dateString;
						} else {
							this.pickerData.startTime = dateString;
						};
						break;
					case "year-month":
						this.pickerData.month = dateString;
						break;
					case "year":
						this.pickerData.year = dateString;
						break;
					case "week":
						this.pickerData.week = dateString;
						break;
					case "quarter":
						this.pickerData.quarter = dateString;
						break;
				}
				this.isPickend = true;
				// this.$emit('change', dateString)
			},
			getPopIndicatorStyle() {
				if (this.popIindicatorStyle) {
					for (let key in this.popIindicatorStyle) {
						this.popupIndicatorStyleString += `${key}:${this.popIindicatorStyle[key]};`
					}
				}
			},
			initDefaultDate() {//初始化起始时间
				const pickerData = {};
				Object.keys(this.defaultData).forEach(key=>{
					pickerData[key] = this.defaultData[key];
				})
				let [y, m, d] = getTimeArray(new Date());
				if (this.type === 'year') {
					pickerData.year=pickerData.year||y;
					this.datestring = this.getDefaultYearMonth(pickerData.year,this.type);
				} else if (this.type === 'year-month') {
					pickerData.month=pickerData.month||(y+'-'+addZero(m));
					this.datestring = this.getDefaultYearMonth(pickerData.month,this.type);
				} else if (this.type === 'year-range') {
					pickerData.startTime=pickerData.startTime||y;
					pickerData.endTime=pickerData.endTime||y;
					this.datestring = this.getDefaultYearMonth(pickerData.startTime,this.type);
				} else if (this.type === 'year-month-range') {
					pickerData.startTime=pickerData.startTime||(y+'-'+addZero(m));
					pickerData.endTime=pickerData.endTime||(y+'-'+addZero(m));
					this.datestring = this.getDefaultYearMonth(pickerData.startTime,this.type);
				} else if (this.type === 'quarter') {
					this.datestring = pickerData.quarter;
				} else if (this.type === 'week') {
					this.datestring = pickerData.week;
				} else {
					// 处理默认开始时间和结束时间
					let startTime=isOnlyTime(this.type) ? y + "/" + m + "/" + d + " " + pickerData.startTime : pickerData.startTime;
					startTime=this.getMinDate(startTime).replace(/-/g,"/");
					pickerData.startTime = isNaN(Date.parse(startTime)) ? this.formatPickerData(new Date(),this.type) : this.formatPickerData(startTime,this.type);
					if(isRange(this.type)){
						let endTime=isOnlyTime(this.type) ? y + "/" + m + "/" + d + " " + pickerData.endTime : pickerData.endTime;
						endTime=this.getMinDate(endTime).replace(/-/g,"/");
						pickerData.endTime = isNaN(Date.parse(endTime)) ? this.formatPickerData(new Date(),this.type) : this.formatPickerData(endTime,this.type);						
					}
					this.datestring = pickerData.startTime;
				}
				
				this.$nextTick(()=>{
					Object.keys(pickerData).forEach(key=>{
						this.pickerData[key] = pickerData[key];
					})					
				})
			},
			initDateTime() {//初始化picker-view选择的时间
				let value;
				if (this.datestring && this.datestring.length > 0) {
					if (['year','year-range'].includes(this.type)) {
						value = new Date(this.datestring, 0);
					} else if (isOnlyTime(this.type)) {
						let date = new Date();
						let ary = this.datestring.split(':');
						ary.forEach((item, index) => {
							if (index == 0) {
								date.setHours(item)
							} else if (index == 1) {
								date.setMinutes(item)
							} else if (index == 2) {
								date.setSeconds(item)
							}
						})
						value = date;
						const currentHMS = getTimeArray(value).slice(3);
						const lastHMS = [-1, -1, -1];
						this.getHMSColumnsData(currentHMS, lastHMS, 1, true, true);
					} else if(['year-month','year-month-range'].includes(this.type)){
						let datestring = this.datestring.replace(/-/g, '/');
						value = isNaN(Date.parse(datestring)) ? new Date(datestring+'/01') : new Date(datestring);
					} else {
						value = new Date(this.datestring.replace(/-/g, '/'));
					}
				} else {
					value = new Date();
				}
				let len, timeArray, index;
				let array = ['week','quarter'].includes(this.type) ? this.datestring.split(" ") : getTimeArray(value);
				let [year, month, day, hour, minute, second] = array;
				if (this.isShowWeek) {
					this.getWeeks(year?year:this.realMinDate.year);	
				} else if(!isOnlyTime(this.type)){
					this.getColumnsData(array);
				}
				let names = ['year', 'month', 'day', 'hour', 'minute', 'second'];
				switch (this.type) {
					case "date":
					case "time":
					case "date-range":
					case "time-range":
						len = 3;
						break;
					case "year-month":
					case "year-month-range":
					case "hour-minute":
					case "week":
					case "quarter":
						len = 2;
						break;
					case "year":
					case "year-range":
						len = 1;
						break;
					case "datetime":
					case "datetime-range":
						len = 5;
						break;
					case "datetime-all":
					case "datetime-all-range":
						len = 6;
						break;
				}
				timeArray = new Array(len).fill(0);
				if (isOnlyTime(this.type)) {
					names = names.slice(3);
					array = array.slice(3);
				} else if (this.type === "week") {
					names = ["year", "week"];
				} else if (this.type === "quarter") {
					names = ["year", "quarter"];
				} else {
					names = names.slice(0,len);
					array = array.slice(0,len);
				}
				// setTimeout(() => {
					timeArray = timeArray.map((item, index) => {
						const name = names[index];
						return getIndexOfArray(array[index], this[name + 's'])
					})
					this.dateTime = timeArray;
					this.lastDateTime = array;
					this.formatDate();
				// },100)
			},
			initTimeData(end, start) {//设置最大最小值
				let timeArray = [];
				while (start <= end) {
					timeArray.push(start);
					start++;
				}
				return timeArray;
			},
			getColumnsData(currentDateList, lastDateTime=[-1,-1,-1,-1,-1,-1]){
				let min='';
				let max='';
				let minTag=false;
				let maxTag=false;
				let currentYear=currentDateList[0];
				let currentMonth=currentDateList[1];
				let currentDate=currentDateList[2];
				let currentHMS=currentDateList.slice(3);
				let lastHMS=lastDateTime.slice(3);
				if(this.isShowMonth || this.isShowQuarter){
					if(currentYear==this.realMinDate.year){
						minTag=true;
					}
					if (currentYear == this.realMaxDate.year){
						maxTag=true;
					}
					if(currentYear!=lastDateTime[0]){
						min=1;
						max=12;
						if (minTag){
							min=this.realMinDate.month;
							currentMonth=currentMonth<min?min:currentMonth;
						}
						if (maxTag){
							max=this.realMaxDate.month;
							currentMonth=currentMonth>max?max:currentMonth;
						}
						this.isShowMonth && (this.months = this.initTimeData(max, min));
						this.isShowQuarter && (this.quarters = getQuarterArray(min, max));
					}				
				}
				if(this.isShowDay){
					minTag=minTag&&currentMonth == this.realMinDate.month;
					maxTag=maxTag&&currentMonth == this.realMaxDate.month;
					if(currentMonth!=lastDateTime[1]||max){
						min=1;
						max=getOneMonthDays(currentYear, currentMonth-1);
						if (minTag){
							min=this.realMinDate.date;
							currentDate=currentDate<min?min:currentDate;
						}
						if (maxTag){
							max=this.realMaxDate.date;
							currentDate=currentDate>max?max:currentDate;
						}
						this.days = this.initTimeData(max, min);
					}				
				}
				if(this.isShowHour){
					// 判断时分秒列表是否需要重新赋值
					let tag=0;
					if(currentHMS[1]!=lastDateTime[4]){
						tag=3;
					}
					if(currentHMS[0]!=lastDateTime[3]){
						tag=2;
					}
					if(max||currentDate!=lastDateTime[2]){
						tag=1;
					}
					minTag=minTag&&currentDate==this.realMinDate.date;
					maxTag=maxTag&&currentDate==this.realMaxDate.date;
					if(tag>1){
						minTag=minTag&&currentHMS[0]==this.realMinDate.hour;
						maxTag=maxTag&&currentHMS[0]==this.realMaxDate.hour;	
					}
					if(tag>2){
						minTag=minTag&&currentHMS[1]==this.realMinDate.minute;
						maxTag=maxTag&&currentHMS[1]==this.realMaxDate.minute;	
					}
					this.getHMSColumnsData(currentHMS, lastHMS, tag, minTag, maxTag);
				}
			},
			
			getHMSColumnsData(currentHMS, lastHMS, tag, minTag, maxTag){
				let [currentHour, currentMinute, currentSecond] = currentHMS;
				let min="";
				let max="";
				if(tag==1){
					min=0;
					max=23;
					if(minTag){
						min=this.realMinDate.hour;
						currentHour=currentHour<min?min:currentHour;
					}
					if(maxTag){
						max=this.realMaxDate.hour;
						currentHour=currentHour>max?max:currentHour;
					}
					this.hours = this.initTimeData(max, min);
					tag=2;
				}
				
				if(tag==2){
					minTag=minTag&&currentHour==this.realMinDate.hour;
					maxTag=maxTag&&currentHour==this.realMaxDate.hour;
					min=0;
					max=59;
					if(minTag){
						min=this.realMinDate.minute;
						currentMinute=currentMinute<min?min:currentMinute;
					}
					if(maxTag){
						max=this.realMaxDate.minute;
						currentMinute=currentMinute>max?max:currentMinute;
					}
					this.minutes = this.initTimeData(max, min);
					tag=3;
				} 
				
				if(tag=3){
					minTag=minTag&&currentMinute==this.realMinDate.minute;
					maxTag=maxTag&&currentMinute==this.realMaxDate.minute;
					min=0;
					max=59;
					if(minTag){
						min=this.realMinDate.second;
					}
					if(maxTag){
						max=this.realMaxDate.second;
					}
					this.seconds = this.initTimeData(max, min);
				}	
			},
			getWeeks(year){
				let startDate = year + '/01/01', endDate = year + '/12/31';
				if(year<=this.realMinDate.year){
					startDate = this.realMinDate.year + '/' + addZero(this.realMinDate.month) + '/' + addZero(this.realMinDate.date);
				}
				if(year>=this.realMaxDate.year){
					endDate = this.realMaxDate.year + '/' + addZero(this.realMaxDate.month) + '/' + addZero(this.realMaxDate.date);
				}
				const [start, end] = getTotalWeeks(startDate, endDate, this.en, this.weekType);
				this.weeks = this.initTimeData(end, start).map(item=>`第${item}周`);
			},
			getWeekDate(){
				let [year, w] = this.pickerData.week.split(" ");
				let week = w.slice(1, - 1);
				let { start, end } = getFirstAndLastDate(year, week, this.en, this.weekType);
				start = this.formatPickerData(this.getMinDate(start),'date');
				end = this.formatPickerData(this.getMAxDate(end),'date');
				return [this.pickerData.week, start, end];
			},
			getQuarterDate(){
				let [y, q] = this.pickerData.quarter.split(" ");
				let index = getIndexOfArray(q, this.allQuarter, "name");
				let start = y + "-" + this.allQuarter[index].start;
				let end = y + "-" + this.allQuarter[index].end;
				start = this.formatPickerData(this.getMinDate(start),'date');
				end = this.formatPickerData(this.getMAxDate(end),'date');
				return [this.pickerData.quarter,start, end];
			},
			getMinDate(date){
				let defaultMInArr=[1970,1,1,0,0,0];
				let minDate = `${this.realMinDate.year||defaultMInArr[0]}/${this.realMinDate.month||defaultMInArr[1]}/${this.realMinDate.date||defaultMInArr[2]} ${this.realMinDate.hour||defaultMInArr[3]}:${this.realMinDate.minute||defaultMInArr[4]}:${this.realMinDate.second||defaultMInArr[5]}`;
				let repDate=date.replace(/-/g,"/");
				let datetime=isNaN(Date.parse(repDate))?new Date().getTime():new Date(repDate).getTime();
				return datetime>new Date(minDate).getTime()?date:minDate.replace(/\//g,"-");
			},
			getMAxDate(date){
				let maxDate = `${this.realMaxDate.year}/${this.realMaxDate.month}/${this.realMaxDate.date} ${this.realMaxDate.hour}:${this.realMaxDate.minute}:${this.realMaxDate.second}`;
				let repDate=date.replace(/-/g,"/");
				let datetime=isNaN(Date.parse(repDate))?new Date().getTime():new Date(repDate).getTime();
				return datetime<new Date(maxDate).getTime()?date:maxDate;
			},
			getDefaultYearMonth(date,type){
				let minDate=['year','year-range'].includes(this.type)?this.realMinDate.year:(this.realMinDate.year+"-"+addZero(this.realMinDate.month));
				let maxDate=['year','year-range'].includes(this.type)?this.realMaxDate.year:(this.realMaxDate.year+"-"+addZero(this.realMaxDate.month));
				return date<minDate?minDate:date>maxDate?maxDate:date;
			},
			//popup
			show(){
				this.$nextTick(()=>{
					this.initDefaultDate();
					this.initDateTime();
					this.showPop();					
				})
			},
			handleEvent() {
				return;
			},
			confirm() {
				if (this.confirm.target) {
					return ;
				}
				this.confirm.target = true;
				if (!this.isPickend) {
					return ;
				}
				this.confirm.target = null;
				let val;
				switch (this.type){
					case "date":
					case "datetime":
					case "datetime-all":
					case "time":
					case "hour-minute":
						val = this.pickerData.startTime;
						break;
					case "year":
						val = this.pickerData.year;
						break;
					case "year-month":
						val = this.pickerData.month;
						break;
					case "week":
						val = this.getWeekDate();
						break;
					case "quarter":
						val = this.getQuarterDate();
						break;
					case "year-range":
					case "year-month-range":
					case "date-range":
					case "datetime-range":
					case "datetime-all-range":
					case "time-range":
						let start=this.pickerData.startTime;
						let end=this.pickerData.endTime;
						if(start>end){
							val=[end,start];
						}else{
							val=[start,end];
						}
						break;
					default:
						break;
				}
				this.$emit("change",val)
				this.close();
			},
			popChange(val){
				if(!val.show){
					this.$emit("close");
					this.showPopPicker = false;
					this.$parent.pageScrollFlag=true;
				}
			},
			formatPickerData(date,type){
				let [y, m, d, HH, MM, SS] = getTimeArray(new Date(date));
				m=addZero(m);
				d=addZero(d);
				HH=addZero(HH);
				MM=addZero(MM);
				SS=addZero(SS);
				switch (type){
					case "date":
					case "date-range":
						return y + "-" + m + "-" + d;
					case "datetime":
					case "datetime-range":
						return y + "-" + m + "-" + d + " " + HH + ":" + MM;
					case "datetime-all":
					case "datetime-all-range":
						return y + "-" + m + "-" + d + " " + HH + ":" + MM + ":" + SS;
					case "time":
					case "time-range":
						return HH + ":" + MM + ":" + SS;
					case "hour-minute":
						return HH + ":" + MM;
					default:
						return "";
						break;
				}
				
			}
		},
		computed: {
			years() {//可选的年列表
				return this.initTimeData(this.realMaxDate.year, this.realMinDate.year);
			},
			isShowYear() {
				return !['time','hour-minute','time-range'].includes(this.type);
			},
			isShowMonth() {
				return !['year','time','hour-minute','week','quarter','year-range','time-range'].includes(this.type);
			},
			isShowDay() {
				return ['date','datetime','datetime-all','date-range','datetime-range','datetime-all-range'].includes(this.type);
			},
			isShowHour() {
				return !['date','year-month','year','week','quarter','year-range','year-month-range','date-range'].includes(this.type);
			},
			isShowRange() {
				return isRange(this.type);
			},
			isShowMinute() {
				return !['date','year-month','year','week','quarter','year-range','year-month-range','date-range'].includes(this.type);
			},
			isShowSecond() {
				return ['time','datetime-all','datetime-all-range','time-range'].includes(this.type);
			},
			isShowQuarter() {
				return this.type === 'quarter';
			},
			isShowWeek() {
				return this.type === 'week';
			},
			realMinDate(){
				return {
					year: 1970,
					month: 1,
					date: 1,
					hour:0,
					minute:0,
					second:0,
					...this.minDate
				}
			},
			realMaxDate(){
				return {
					year,
					month,
					date,
					hour:23,
					minute:59,
					second:59,
					...this.maxDate
				}
			}
		},
		watch: {
			isPickend(val) {
				if (val && this.confirm.target) {
					this.confirm.target = null;
					this.confirm();
				}
			}
		}
	}
</script>

<style lang="scss">
	// popup
	.date-time-picker {
		width: 100%;
		height: 40vh;
		border-top-right-radius: 10rpx;
		border-top-left-radius: 10rpx;
		.date-time-mask {
			position: fixed;
			top: 0;
			bottom: 0;
			left: 0;
			right: 0;
			background-color: rgba($color: #000000, $alpha: .5);
			z-index: 998;
		}

		.date-time-container {
			width: 100%;
			height: 100%;
			border-top-right-radius: 10rpx;
			border-top-left-radius: 10rpx;
			box-sizing: border-box;
			padding-bottom: 20rpx;
			background-color: #f6f6f6;
			display: flex;
			flex-direction: column;

			.time-picker-tool {
				height: 80rpx;
				display: flex;
				align-items: center;
				justify-content: space-between;
				font-size: 32rpx;

				.cancel-base {
					padding: 0 32rpx;
					box-sizing: border-box;					
				}
				.cancel-btn {
					color: #969799;
				}

				.tool-title {
					font-weight: 500;
					font-size: 32rpx;
					max-width: 50%;
					overflow: hidden;
					white-space: nowrap;
					text-overflow: ellipsis;
				}
				.confirm-base {
					padding: 0 32rpx;
					box-sizing: border-box;					
				}
				.confirm-btn {
					color: #049bff;
				}
			}

			.picker-view {
				width: 100%;
				flex: 1;

				.item {
					font-size: 34rpx;
					display: flex;
					align-items: center;
					justify-content: center;
				}
			}
		}
		.safe-area-padding{
			padding-bottom: constant(safe-area-inset-bottom);
			padding-bottom: env(safe-area-inset-bottom);
		}
	}
	.picker-tab{
		display: flex;
		justify-content: space-around;
		align-items: center;
		margin: 20rpx 0;
	}
	.picker-tab-item{
		box-sizing: border-box;
		width: 260rpx;
		text-align: center;
		padding: 4rpx 30rpx;
		border:2rpx solid #666;
		border-radius: 20rpx;
		font-size: 30rpx;
	}
	
</style>
