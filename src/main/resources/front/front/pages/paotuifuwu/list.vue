<template>
<!-- category 1 -->
<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
	<view class="content">
		<view :style='{"width":"100%","padding":"0","position":"relative","background":"#fff","height":"100%"}'>
			<view class="cu-bar bg-white search" :style='{"width":"100%","padding":"20rpx 24rpx","background":"#fff","display":"flex","height":"auto"}'>
				<picker v-if="queryList.length>1" mode="selector" :range="queryList" range-key="queryName" :value="queryIndex" @change="queryChange">
					<view :style='{"width":"40rpx","height":"auto"}'>
						<text class="icon iconfont icon-jiantou18" :style='{"width":"40rpx","fontSize":"40rpx","lineHeight":"80rpx","color":"#A1A1A1"}'></text>
					</view>
				</picker>
				<view :style='{"margin":"0 12rpx","flex":"1","position":"relative"}' v-if="queryIndex==0" class="search-form round">
					<text class="icon iconfont icon-fangdajing07" :style='{"color":"#A1A1A1","left":"0px","textAlign":"center","width":"80rpx","fontSize":"40rpx","lineHeight":"80rpx","position":"absolute","right":"0px"}'></text>
					<input :style='{"border":"2rpx solid #A1A1A1","padding":"12rpx 20rpx 12rpx 80rpx","color":"#000","borderRadius":"10rpx","background":"#fff","width":"100%","lineHeight":"56rpx","fontSize":"28rpx","height":"80rpx"}' v-model="searchForm.paotuifuwu" type="text" placeholder="跑腿服务" ></input>
				</view>
				<button :style='{"border":"0","padding":"0px","margin":"0 0 0 -40rpx","color":"#fff","borderRadius":"10rpx","background":"#FFBC1D","width":"136rpx","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx","zIndex":"1"}' @tap="search" class="cu-btn shadow-blur round">搜索</button>
			</view>
			

			<view :style='{"padding":"0px 20rpx","margin":"0 0 20rpx","flexWrap":"wrap","background":"linear-gradient(90deg, #FFF6E0 0%, rgba(255,253,248,0.81) 100%)","justifyContent":"space-between","display":"flex"}'>
				<view @click="sortClick('addtime')" :style='{"border":"0","padding":"0 12rpx","margin":"0 8rpx 0 0","outline":"0","borderRadius":"0","background":"none","display":"flex","width":"30%","justifyContent":"center"}'>
					<text :style='{"margin":"0 8rpx 0 0","lineHeight":"60rpx","fontSize":"24rpx","color":"#333"}'>按日期</text>
					<text v-if="listSort!='addtime'" class="icon iconfont icon-liulan12" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"24rpx","color":"#333"}'></text>
					<text v-else-if="listSort=='addtime'&&listOrder=='asc'" class="icon iconfont icon-jiantou28" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"24rpx","color":"#333"}'></text>
					<text v-else-if="listSort=='addtime'&&listOrder=='desc'" class="icon iconfont icon-jiantou32" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"24rpx","color":"#333"}'></text>
				</view>
			</view>
			<view :style='{"width":"100%","background":"#fff","height":"auto"}'>
			<!-- 样式2 -->
			<view class="list" :style='{"width":"100%","padding":"24rpx","margin":"0","height":"auto"}'>
				<view @tap="onDetailTap(product)" class="listm flex flex-between" :style='{"boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","padding":"20rpx 0 20rpx 20rpx","margin":"0 0 20rpx","overflow":"hidden","borderRadius":"10rpx","flexWrap":"wrap","flexDirection":"column","display":"flex","width":"100%","height":"340rpx"}' v-for="(product,index) in list" :key="index">

					<view class="listmr" :style='{"width":"calc(100% - 260rpx)","padding":"0 20rpx","margin":"0","flexWrap":"wrap","display":"flex","height":"auto"}'>
						<view class="col3 f30 elip mb15" :style='{"padding":"0 0 12rpx","margin":"0","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"1"}'>跑腿服务:{{product.paotuifuwu}}</view>
						<view class="col3 f30 elip mb15" :style='{"padding":"0 0 12rpx","margin":"0","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"1"}'>物品价格:{{product.wupinjiage}}</view>
						<view class="col3 f30 elip mb15" :style='{"padding":"0 0 12rpx","margin":"0","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis","order":"1"}'>距离/公里:{{product.peisongjuli}}</view>
						<view :style='{"width":"100%","padding":"0 0","lineHeight":"48rpx","order":"2"}'>
							<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#000"}'></text>
							<text :style='{"color":"#000","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.addtime}}</text>
						</view>
					</view>
					<!-- #ifdef MP-WEIXIN -->
					<view :style='{"width":"calc(100% - 260rpx)","padding":"20rpx","justifyContent":"space-between","display":"flex","height":"auto"}'>
						<view :style='{"border":"2rpx solid #000","padding":"4rpx 20rpx","borderRadius":"40rpx","display":"flex"}' v-if="(userid && isAuth('paotuifuwu','修改')) || (!userid && isAuthFront('paotuifuwu','修改'))" @tap.stop.proevent="onUpdate" :data-row="product">
							<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#000","display":"inline-block"}' class="cuIcon-edit"></text>
							<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#000","display":"inline-block"}'>修改</text>
						</view>
						<view :style='{"border":"2rpx solid #000","padding":"4rpx 20rpx","borderRadius":"40rpx","display":"flex"}' v-if="(userid && isAuth('paotuifuwu','删除')) || (!userid && isAuthFront('paotuifuwu','删除'))" @tap.stop.proevent="onDelete" :data-row="product">
							<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#000","display":"inline-block"}' class="cuIcon-delete"></text>
							<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#000","display":"inline-block"}'>删除</text>
						</view>
					</view>
					<!-- #endif -->
					<!-- #ifndef MP-WEIXIN -->
					<view :style='{"width":"calc(100% - 260rpx)","padding":"20rpx","justifyContent":"space-between","display":"flex","height":"auto"}'>
						<view :style='{"border":"2rpx solid #000","padding":"4rpx 20rpx","borderRadius":"40rpx","display":"flex"}' v-if="(userid && isAuth('paotuifuwu','修改')) || (!userid && isAuthFront('paotuifuwu','修改'))" @tap.stop.proevent="onUpdateTap(product)">
							<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#000","display":"inline-block"}' class="cuIcon-edit"></text>
							<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#000","display":"inline-block"}'>修改</text>
						</view>
						<view :style='{"border":"2rpx solid #000","padding":"4rpx 20rpx","borderRadius":"40rpx","display":"flex"}' v-if="(userid && isAuth('paotuifuwu','删除')) || (!userid && isAuthFront('paotuifuwu','删除'))" @tap.stop.proevent="onDeleteTap(product.id)">
							<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#000","display":"inline-block"}' class="cuIcon-delete"></text>
							<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#000","display":"inline-block"}'>删除</text>
						</view>
					</view>
					<!-- #endif -->
				</view>
			</view>
			
			
			

			

			</view>
			
			
			
		</view>

		<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","color":"rgb(255, 255, 255)","bottom":"40rpx","right":"8rpx","outline":"none","borderRadius":"100%","background":"rgb(255, 170, 51)","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"absolute","height":"80rpx","zIndex":"999"}' v-if="userid && isAuth('paotuifuwu','新增')" class="add-btn" @click="onAddTap()">新增</button>
		<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","color":"rgb(255, 255, 255)","bottom":"40rpx","right":"8rpx","outline":"none","borderRadius":"100%","background":"rgb(255, 170, 51)","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"absolute","height":"80rpx","zIndex":"999"}' v-if="!userid && isAuthFront('paotuifuwu','新增')" class="add-btn" @click="onAddTap()">新增</button>
	</view>
</mescroll-uni>
</template>

<script>
	export default {
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				queryList:[
					{
						queryName:"跑腿服务",
					},
				],
				queryIndex: 0,
				list: [],
				lists: [],
                userid: '',
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 5, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				searchForm:{},
				CustomBar: '0',
				listSort: 'id',
				listOrder: 'desc',
			};
		},
		watch: {
		},
		mounted() {
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onShow() {
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		onLoad(options) {
            if(options.userid) {
                this.userid=options.userid;
            } else {
                this.userid = "";
            }
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		components: {
		},
		methods: {
			uGetRect(selector, all) {
				return new Promise(resolve => {
					uni.createSelectorQuery()
					.in(this)
					[all ? 'selectAll' : 'select'](selector)
					.boundingClientRect(rect => {
						if (all && Array.isArray(rect) && rect.length) {
							resolve(rect);
						}
						if (!all && rect) {
							resolve(rect);
						}
					})
					.exec();
				});
			},
			cloneData(data) {
				return JSON.parse(JSON.stringify(data));
			},
			sortClick(type){
				if(this.listSort==type){
					if(this.listOrder == 'desc'){
						this.listOrder = 'asc'
					}else{
						this.listOrder = 'desc'
					}
				}else{
					this.listSort = type
					this.listOrder = 'desc'
				}
				this.search()
			},
            priceChange(price) {
                return Number(price).toFixed(2);
            },
            preHttp(str) {
                return str && str.substr(0,4)=='http';
            },
			//查询条件切换
			queryChange(e) {
				this.queryIndex=e.detail.value;
				this.searchForm.paotuifuwu="";
			},
			//类别搜索
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},
			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				// 重置分页参数页数为1
				mescroll.resetUpScroll()
			},
			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let params = {
					page: mescroll.num,
					limit: mescroll.size
				}
				params['sort'] = this.listSort;
				params['order'] = this.listOrder;

				if(this.searchForm.paotuifuwu){
					params['paotuifuwu'] = '%' + this.searchForm.paotuifuwu + '%'
				}
				let user = uni.getStorageSync("appUserid")?JSON.parse(uni.getStorageSync('userSession')):{}
                let res = {}
                if(this.userid) {
                    res = await this.$api.page(`paotuifuwu`, params);
                } else {
                    res = await this.$api.list(`paotuifuwu`, params);
                }

				// 如果是第一页数据置空
				if (mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				this.$forceUpdate()
				
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);
			},
			// 详情
			onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
			},
			onUpdate(e){
				this.onUpdateTap(e.currentTarget.dataset.row)
			},
			// 修改
			onUpdateTap(row){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update?id=${row.id}`)
			},
			// 添加
			onAddTap(){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update`)
			},
			onDelete(e){
				this.onDeleteTap(e.currentTarget.dataset.row.id)
			},
			onDeleteTap(id){
				var _this = this;
				uni.showModal({
					title: '提示',
					content: '是否确认删除',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.del('paotuifuwu', JSON.stringify([id]));
							_this.$utils.msg('删除成功');
							_this.hasNext = true
							// 重置分页参数页数为1
							_this.search()
						}
					}
				});
			},
			// 搜索
			async search(){
				this.mescroll.num = 1
				let searchForm = {
					page: this.mescroll.num,
					limit: this.mescroll.size
				}
				searchForm['sort'] = this.listSort;
				searchForm['order'] = this.listOrder;

				if(this.searchForm.paotuifuwu){
					searchForm['paotuifuwu'] = '%' + this.searchForm.paotuifuwu + '%'
				}
                let res = {};
                if(this.userid) {
                    res = await this.$api.page(`paotuifuwu`, searchForm);
                } else {
                    res = await this.$api.list(`paotuifuwu`, searchForm);
                }
				// 如果是第一页数据置空
				if (this.mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				this.mescroll.endSuccess(this.mescroll.size, this.hasNext);
			}
		}
	};
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	
	.category-one .tab {
		cursor: pointer;
		border-radius: 40rpx;
		padding: 0 20rpx;
		margin: 0 20rpx;
		color: #959595;
		background: #F2F2F2;
		display: inline-block;
		width: auto;
		font-size: 28rpx;
		line-height: 60rpx;
	}
	
	.category-one .tab.active {
		cursor: pointer;
		border-radius: 40rpx;
		padding: 0 20rpx;
		margin: 0 20rpx;
		color: #fff;
		background: #FFBC1D;
		display: inline-block;
		width: auto;
		font-size: 28rpx;
		line-height: 60rpx;
	}
	
	.category-two .tab {
		cursor: pointer;
		padding: 0;
		color: #fff;
		background: blue;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 80rpx;
		text-align: center;
	}
	
	.category-two .tab.active {
		cursor: pointer;
		padding: 0;
		color: #fff;
		background: #000;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 80rpx;
		text-align: center;
	}
	
	.category-three .tab {
		cursor: pointer;
		padding: 0;
		color: #fff;
		background: burlywood;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 80rpx;
		text-align: center;
	}
	
	.category-three .tab.active {
		cursor: pointer;
		padding: 0;
		color: #fff;
		background: #000;
		display: inline-block;
		width: 100%;
		font-size: 28rpx;
		line-height: 80rpx;
		text-align: center;
	}
</style>
