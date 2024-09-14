/**
 * 获取某年某月有多少天
 */
export const getOneMonthDays = (year, month) => {
	month = Number(month);
	const baseMonthsDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
	if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
		if (month === 1) {
			baseMonthsDays[month] = 29;
		}
	}
	return baseMonthsDays[month];
}

/**
 * 获取日期的年月日时分秒
 */
export const getTimeArray = (data) => {
	const year = data.getFullYear();
	const month = data.getMonth() + 1;
	const date = data.getDate();
	const hour = data.getHours();
	const minute = data.getMinutes();
	const second = data.getSeconds();
	return [year, month, date, hour, minute, second];
}
/**
 * 小于10的数字前面补0
 */
export const addZero = (num) => {
	if (num / 1 == 0) {
		return "00";
	}
	num = "" + num;
	return num < 10 ? (num.substr(0, 1) == 0 ? num : ('0' + num)) : num;
}
/**
 * 小于10的数字前面去除0
 */
export const removeZero = (num) => {
	if (num / 1 == 0) {
		return 0
	}
	num = "" + num;
	return num.substr(0, 1) == 0 ? (num.substr(1)) : num;
}
/**
 * 获取当前值在数组中的索引
 */
export const getIndexOfArray = (value, array, key) => {
	let index;
	if (key) {
		index = array.findIndex(item => item[key] == value);
	} else {
		index = array.findIndex(item => item == value);
	}
	return index > -1 ? index : 0;
}

/**
 * 获取季度
 */
export const getQuarterArray = (startMOnth, endMOnth) => {
	let arr = ["一季度", "二季度", "三季度", "四季度"];
	let start = Math.ceil(startMOnth / 3);
	let end = Math.ceil(endMOnth / 3);
	if (end < start) {
		return arr;
	} else {
		return arr.slice(start - 1, end);
	}
}
/**
 * 是否为范围选择
 */
export const isRange = (type) => {
	return type.indexOf("range") > -1;
}
/**
 * 是否仅为时间选择
 */
export const isOnlyTime = (type) => {
	return ["time", "hour-minute", "time-range"].includes(type);
}
/**
 * 获取start,end之间有多少周
 */
export const getTotalWeeks = (start, end, en, weekType) => {
	if (weekType === 'firstDay') {
		return getFirstDayTotalWeeks(start, end, weekType)
	}
	//获取end当前周的第一天
	let endMon = getWeekFirstDate(new Date(end), en);
	//获取start当前周的第一天
	let startMon = getWeekFirstDate(new Date(start), en);
	let year = new Date(start).getFullYear();
	let firMon = getWeekFirstDate(new Date(year + '/01/01'), en);
	if (weekType === 'fullWeek') {
		if (new Date(startMon).getFullYear() != year) {
			let curTime = new Date(startMon);
			startMon = curTime.setDate(curTime.getDate() + 7);
		}
		if (new Date(firMon).getFullYear() != year) {
			let curTime = new Date(firMon);
			firMon = curTime.setDate(curTime.getDate() + 7);
		}
	}
	return getStartAndEndWeek(firMon, startMon, endMon, weekType);
}
/**
 * 获取当前周的第一天
 * 默认周一为第一天，en=true 时周日为第一天
 */
function getWeekFirstDate(date, en = false) {
	let temptTime = new Date(date);
	let weekday = temptTime.getDay() || (en ? 0 : 7);
	return temptTime.setDate(temptTime.getDate() - weekday + (en ? 0 : 1));
}
/**
 * 获取当前年第week周的第一天和最后一天
 * 默认周一为第一天，en=true 时周日为第一天
 */
export const getFirstAndLastDate = (year, week, en, weekType) => {
	let firstDate = new Date(getWeekFirstDate(new Date(year + '/01/01'), en));
	if (weekType === 'fullWeek') {
		if (firstDate.getFullYear() != year) {
			firstDate.setDate(firstDate.getDate() + 7);
		}
	}
	if (weekType === 'firstDay') {
		firstDate = new Date(year + '/01/01');
	}
	firstDate = new Date(firstDate.setDate(firstDate.getDate() + (week - 1) * 7));
	let lastDate = new Date(firstDate);
	lastDate = new Date(lastDate.setDate(lastDate.getDate() + 6));
	const [fy, fm, fd] = getTimeArray(firstDate);
	const [ly, lm, ld] = getTimeArray(lastDate);
	const start = `${fy}-${addZero(fm)}-${addZero(fd)}`;
	const end = `${ly}-${addZero(lm)}-${addZero(ld)}`;
	return {
		start,
		end
	};
}

function getStartAndEndWeek(first, start, end) {
	let d = Math.ceil((end.valueOf() - first.valueOf()) / 8.64e7) + 1;
	let endWeek = Math.ceil(d / 7);
	let startWeek = 1;
	if (start !== first) {
		let d = Math.ceil((start.valueOf() - first.valueOf()) / 8.64e7) + 1;
		startWeek = Math.ceil(d / 7);
	}
	return [startWeek, endWeek];
}

function getFirstDayTotalWeeks(start, end, weekType) {
	let year = new Date(start).getFullYear();
	let startTime = new Date(start).getTime();
	let endTime = new Date(end).getTime();
	let firstTime = new Date(year + '/01/01').getTime();
	return getStartAndEndWeek(firstTime, startTime, endTime, weekType)
}