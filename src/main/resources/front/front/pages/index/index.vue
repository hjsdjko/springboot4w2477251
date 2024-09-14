<template>
<view class="content">
	<view :style='{"width":"100%","flexWrap":"wrap","background":"#fff","display":"flex","height":"100%"}'>
		<swiper :style='{"width":"calc(100% - 40rpx)","margin":"0 auto","background":"#fff","height":"360rpx","order":"3"}' class="swiper" :indicator-dots='true' :autoplay='true' :circular='true' indicator-active-color='#FFBC1D' indicator-color='rgba(0, 0, 0, .3)' :duration='500' :interval='5000' :vertical='false'>
			<swiper-item :style='{"width":"100%","background":"#fff","height":"360rpx"}' v-for="(swiper,index) in swiperList" :key="index" @tap="onSwiperTap(swiper)">
				<image :style='{"width":"100%","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"360rpx"}' mode="aspectFill" :src="baseUrl+swiper.img"></image>
				<view v-if="false" :style='{"width":"100%","padding":"0 8rpx","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","background":"#fff"}'>{{ swiper.title }}</view>
			</swiper-item>
		</swiper>
		<!-- menu -->
		<view v-if="true" class="menu" :style='{"padding":"0","margin":"0","flexWrap":"wrap","background":"#f7f7f7","display":"flex","width":"100%","justifyContent":"space-between","height":"auto","order":"2"}'>
            <block v-for="(item,index1) in menuList" v-bind:key="item.roleName">
                <block v-if="index1==0" v-bind:key="index" v-for=" (menu,index) in item.frontMenu">
                    <block v-bind:key="sort" v-for=" (child,sort) in menu.child">
                        <block v-bind:key="sort2" v-for=" (button,sort2) in child.buttons">
                            <view :style='{"width":"23%","padding":"12rpx 0","margin":"10rpx 0","height":"auto"}' class="menu-list" v-if="button=='查看' && child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' " @tap="onPageTap2(child.tableName)">
                                <view class="iconarr" :class="child.appFrontIcon" :style='{"padding":"0","margin":"0px auto","color":"#fff","borderRadius":"100%","textAlign":"center","background":"linear-gradient(180deg, #FC6103 0%, #FFB56E 100%)","display":"block","width":"104rpx","lineHeight":"104rpx","fontSize":"72rpx","height":"104rpx"}'></view>
                                <view :style='{"padding":"0","margin":"12rpx auto 0","color":"#000","textAlign":"center","width":"100%","lineHeight":"28rpx","fontSize":"28rpx"}'>{{child.menu.split("列表")[0]}}</view>
                            </view>
                        </block>
                    </block>
                </block>
            </block>
		</view>
		<!-- menu -->
		<!-- 关于我们 -->
		<view :style='{"padding":"0 24rpx","margin":"20rpx 0 20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","height":"auto","order":"4"}'>
			<view :style='{"border":"2rpx solid #FFBC1D","color":"#FFBC1D","textAlign":"center","borderWidth":"0 0 2rpx","width":"auto","lineHeight":"80rpx","fontSize":"36rpx","fontWeight":"bold","order":"1"}'>{{aboutUsDetail.title}}</view>
			<view :style='{"border":"2rpx solid #D8D8D8","margin":"-80rpx 0 20rpx","color":"#999","textAlign":"center","borderWidth":"0 0 2rpx","width":"100%","lineHeight":"80rpx","fontSize":"0","order":"2"}'>{{aboutUsDetail.subtitle}}</view>
			<view :style='{"width":"100%","padding":"0 0","flexWrap":"wrap","display":"flex","height":"auto","order":"4"}'>
				<img :style='{"margin":"0 10rpx","objectFit":"cover","borderRadius":"10rpx","flex":1,"display":"block","height":"160rpx"}' v-if="aboutUsDetail.picture1" :src="baseUrl+aboutUsDetail.picture1">
				<img :style='{"margin":"0 10rpx","objectFit":"cover","borderRadius":"10rpx","flex":1,"display":"block","height":"160rpx"}' v-if="aboutUsDetail.picture2" :src="baseUrl+aboutUsDetail.picture2">
				<img :style='{"margin":"0 10rpx","objectFit":"cover","borderRadius":"10rpx","flex":1,"display":"block","height":"160rpx"}' v-if="aboutUsDetail.picture3" :src="baseUrl+aboutUsDetail.picture3">
			</view>
			<view :style='{"padding":"0","margin":"0 0 20rpx 0","color":"#363636","width":"100%","lineHeight":"2","fontSize":"28rpx","order":"3"}' v-html="aboutUsDetail.content"></view>
			<view :style='{"border":"0","padding":"0 30rpx","margin":"0 auto","textAlign":"center","background":"#409EFF","display":"none","width":"auto","lineHeight":"56rpx"}'>
			  <text :style='{"color":"#f5f5f5","fontSize":"24rpx"}'>更多</text>
			  <text class="icon iconfont icon-gengduo1" :style='{"color":"#f5f5f5","fontSize":"24rpx"}'></text>
			</view>
			<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
			<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
		</view>
		<!-- 系统简介 -->
		<view :style='{"padding":"0 24rpx","margin":"0 0 20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","height":"auto","order":"6"}'>
			<view :style='{"border":"2rpx solid #FFBC1D","color":"#FFBC1D","textAlign":"center","borderWidth":"0 0 2rpx","width":"auto","lineHeight":"80rpx","fontSize":"36rpx","fontWeight":"bold"}'>{{systemIntroductionDetail.title}}</view>
			<view :style='{"border":"2rpx solid #D8D8D8","margin":"-80rpx 0 20rpx","color":"#999","textAlign":"center","borderWidth":"0 0 2rpx","width":"100%","lineHeight":"80rpx","fontSize":"0"}'>{{systemIntroductionDetail.subtitle}}</view>
			<view :style='{"width":"100%","padding":"10rpx 0","flexWrap":"wrap","display":"flex","height":"auto"}'>
				<img :style='{"margin":"0 0","objectFit":"cover","borderRadius":"10rpx","flex":1,"display":"block","height":"400rpx"}' v-if="systemIntroductionDetail.picture1" :src="baseUrl+systemIntroductionDetail.picture1">
				<img :style='{"margin":"0 10rpx","objectFit":"cover","flex":1,"display":"none","height":"160rpx"}' v-if="systemIntroductionDetail.picture2" :src="baseUrl+systemIntroductionDetail.picture2">
				<img :style='{"margin":"0 10rpx","objectFit":"cover","flex":1,"display":"none","height":"160rpx"}' v-if="systemIntroductionDetail.picture3" :src="baseUrl+systemIntroductionDetail.picture3">
			</view>
			<view :style='{"width":"100%","padding":"20rpx 0","margin":"0 0 20rpx 0","lineHeight":"2","fontSize":"28rpx","color":"#363636"}' v-html="systemIntroductionDetail.content"></view>
			<view :style='{"border":"0","padding":"0 30rpx","margin":"0 auto","textAlign":"center","background":"#409EFF","display":"none","width":"auto","lineHeight":"56rpx"}'>
			  <text :style='{"color":"#f5f5f5","fontSize":"24rpx"}'>更多</text>
			  <text class="icon iconfont icon-gengduo1" :style='{"color":"#f5f5f5","fontSize":"24rpx"}'></text>
			</view>
			<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
			<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
		</view>
		<!-- 商品推荐 -->
		<!-- 商品推荐 -->
		
		<!-- 商品列表 -->
		<!-- 商品列表 -->
		<!-- 新闻资讯 -->
		<view class="listBox news" :style='{"padding":"0 20rpx","margin":"0 0 20rpx","background":"#fff","order":"5"}'>
			<view class="title" :style='{"border":"2rpx solid #D8D8D8","padding":"0 0","margin":"0","background":"none","borderWidth":"0 0 2rpx","display":"flex","width":"100%","justifyContent":"space-between"}'>
				<view :style='{"border":"2rpx solid #FFBC1D","fontSize":"36rpx","lineHeight":"80rpx","color":"#FFBC1D","borderWidth":"0 0 2rpx","fontWeight":"bold"}'>公告</view>
				<view :style='{"alignItems":"center","justifyContent":"center","display":"flex"}' @tap="onPageTap('news')">
				  <text :style='{"color":"#9e9e9e","fontSize":"28rpx"}'>查看更多</text>
				  <text class="icon iconfont icon-gengduo1" :style='{"color":"#9e9e9e","fontSize":"28rpx"}'></text>
				</view>
			</view>
			<!-- 样式1 -->
			<view class="list-box style1" :style='{"padding":"24rpx 0","margin":"0","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
				<view @tap="onNewsDetailTap(item.id)" v-for="(item,index) in news" :key="index" class="list-item" :style='{"border":"2rpx solid #D8D8D8","boxShadow":"none","padding":"20rpx 0","margin":"0 0 20rpx","backgroundColor":"#fff","borderRadius":"20rpx","flexWrap":"wrap","display":"flex","width":"100%","height":"auto"}'>
					<view :style='{"padding":"4rpx 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#000","width":"100%","lineHeight":"1.4","fontSize":"28rpx","textOverflow":"ellipsis","fontWeight":"bold","order":"1"}' class="list-item-title">{{item.title}}</view>
					<image v-if="item.picture" :style='{"width":"100%","padding":"0","margin":"0","objectFit":"cover","display":"none","height":"300rpx"}' class="list-item-image" mode="aspectFill" :src="baseUrl+item.picture"></image>
					<view :style='{"padding":"0 20rpx","overflow":"hidden","color":"#666","maxHeight":"192rpx","width":"100%","lineHeight":"48rpx","fontSize":"26rpx","order":"2"}' class="text">{{item.introduction}}</view>
					<view :style='{"width":"100%","padding":"0 20rpx","order":"6"}'>
					  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"20rpx","color":"#9E9E9E"}'></text>
					  <text :style='{"color":"#9E9E9E","lineHeight":"1.5","fontSize":"20rpx"}'>{{item.addtime}}</text>
					</view>
					<view :style='{"padding":"0 20rpx","display":"none"}'>
					  <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
					  <text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.name}}</text>
					</view>
					<view :style='{"width":"calc(100% / 3)","padding":"0 20rpx 4rpx","order":"3"}'>
					  <text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"20rpx","color":"#9E9E9E"}'></text>
					  <text :style='{"color":"#9E9E9E","lineHeight":"1.5","fontSize":"20rpx"}'>{{item.thumbsupnum}}</text>
					</view>
					<view :style='{"width":"calc(100% / 3)","padding":"0 20rpx 4rpx","order":"4"}'>
					  <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"20rpx","color":"#9E9E9E"}'></text>
					  <text :style='{"color":"#9E9E9E","lineHeight":"1.5","fontSize":"20rpx"}'>{{item.storeupnum}}</text>
					</view>
					<view :style='{"width":"calc(100% / 3)","padding":"0 20rpx 4rpx","order":"5"}'>
					  <text class="icon iconfont icon-chakan9" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"20rpx","color":"#9E9E9E"}'></text>
					  <text :style='{"color":"#9E9E9E","lineHeight":"1.5","fontSize":"20rpx"}'>{{item.clicknum}}</text>
					</view>
				</view>
			</view>
		</view>
		<!-- 新闻资讯 -->
	</view>
</view>
</template>

<script>
    import menu from '@/utils/menu'
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				options2: {
					effect: 'flip',
					loop : true
				},
				options3: {
					effect: 'cube',
					loop : true,
					cubeEffect: {
						shadow: true,
						slideShadows: true,
						shadowOffset: 20,
						shadowScale: 0.94,
					}
				},
				rows: 2,
				column: 4,
				iconArr: [
				  'cuIcon-same',
				  'cuIcon-deliver',
				  'cuIcon-evaluate',
				  'cuIcon-shop',
				  'cuIcon-ticket',
				  'cuIcon-cascades',
				  'cuIcon-discover',
				  'cuIcon-question',
				  'cuIcon-pic',
				  'cuIcon-filter',
				  'cuIcon-footprint',
				  'cuIcon-pulldown',
				  'cuIcon-pullup',
				  'cuIcon-moreandroid',
				  'cuIcon-refund',
				  'cuIcon-qrcode',
				  'cuIcon-remind',
				  'cuIcon-profile',
				  'cuIcon-home',
				  'cuIcon-message',
				  'cuIcon-link',
				  'cuIcon-lock',
				  'cuIcon-unlock',
				  'cuIcon-vip',
				  'cuIcon-weibo',
				  'cuIcon-activity',
				  'cuIcon-friendadd',
				  'cuIcon-friendfamous',
				  'cuIcon-friend',
				  'cuIcon-goods',
				  'cuIcon-selection'
				],
                role : '',
                aboutUsDetail: {},
                systemIntroductionDetail: {},
                menuList: [],
                swiperMenuList:[],
                user: {},
                tableName:'',

				//轮播
				swiperList: [],
				news: [],
			}
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
        async onLoad(){
            
        },
		async onShow() {
			this.swiperMenuList = []
			this.role = uni.getStorageSync("appRole");
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.user = res.data;
			this.tableName = table;
			let menus = menu.list();
			this.menuList = menus;
			this.menuList.forEach((item,key) => {
			    if(key==0) {
			        item.frontMenu.forEach((item2,key2) => {
			            if(item2.child[0].buttons.indexOf("查看")>-1) {
			                this.swiperMenuList.push(item2);
			            }
			        })
			    }
			})
            // let res;
			// 轮播图
			let swiperList = []
			res = await this.$api.list('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					swiperList.push({
						img: item.value,
                        title: item.name,
						url: item.url
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
			

            this.getAboutUs();
            this.getSystemIntroduction();
			this.getRecommendList()
			this.getHomeList()
			this.getNewsList()
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
			newsTabClick2(index){
				this.newsIndex2 = index
				this.getNewsList()
			},
			async getNewsList(){
				let res;
				let params = {
					page: 1,
					limit: 6,
					sort: 'id',
					order: 'desc',
				}
				// 公告
				res = await this.$api.list('news', params)
				this.news = res.data.list
			},
			homeTabClick2(index,name){
				this['home' + name + 'Index2'] = index
				this.getHomeList()
			},
			async getHomeList(){
				let res;
				let params;
			},
			recommendTabClick2(index,name){
				this[name + 'Index2'] = index
				this.getRecommendList()
			},
			async getRecommendList(){
				let res;
				let params;
			},
			//轮播图跳转
			onSwiperTap(e) {
				if(e.url) {
					if (e.url.indexOf('https') != -1) {
						// #ifdef MP-WEIXIN
						uni.navigateTo({
						    url: '../../common/linkOthers/linkOthers?url=' + encodeURIComponent(e.url),
						});
						return false
						// #endif
						window.open(e.url)
					} else {
						this.$utils.jump(e.url)
					}
				}
			},
            async getAboutUs() {
                let res = await this.$api.info('aboutus', 1)
                this.aboutUsDetail = res.data;
            },
            async getSystemIntroduction() {
                let res = await this.$api.info('systemintro', 1)
                this.systemIntroductionDetail = res.data;
            },
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){

				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			},
            onPageTap2(index) {
				let url = '../' + index + '/list'
				if(index=='forum'){
					url = '../forum-index/forum-index'
				}
                uni.setStorageSync("useridTag",0);
                uni.navigateTo({
                    url: url,
                    fail: function() {
                        uni.switchTab({
                            url: url
                        });
                    }
                });
            }
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}

</style>
