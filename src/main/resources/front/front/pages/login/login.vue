<template>
	<view class="content">
		<view class="box" :style='{"padding":"24rpx","alignItems":"flex-end","background":"url(http://codegen.caihongy.cn/20231204/e2ddfa85341f475b8135741b962ec087.gif)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","height":"100%"}'>
			<view :style='{"padding":"24rpx 0","alignItems":"center","flexDirection":"column","display":"flex","width":"100%","position":"relative","justifyContent":"space-around","height":"70%"}'>
				<image :style='{"width":"160rpx","margin":"0 auto 24rpx auto","borderRadius":"8rpx","display":"none","height":"160rpx"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" mode="aspectFill"></image>
				<view v-if="loginType==1" :style='{"width":"100%","margin":"0 0 24rpx 0","alignItems":"center","display":"flex","height":"auto"}' class="uni-form-item uni-column">
					<view :style='{"color":"#A1A1A1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"160rpx","lineHeight":"88rpx","fontSize":"28rpx","height":"88rpx"}' class="label">账号：</view>
					<input v-model="username" :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0 60rpx 60rpx 0","flex":"1","background":"#F0F3FC","width":"calc(100% - 320rpx)","fontSize":"28rpx","height":"88rpx"}' type="text" class="uni-input" name="" placeholder="请输入账号" />
				</view>
				<view v-if="loginType==1" :style='{"width":"100%","margin":"0 0 24rpx 0","alignItems":"center","display":"flex","height":"auto"}' class="uni-form-item uni-column">
					<view :style='{"color":"#A1A1A1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"160rpx","lineHeight":"88rpx","fontSize":"28rpx","height":"88rpx"}' class="label">密码：</view>
					<input v-model="password" :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0 60rpx 60rpx 0","flex":"1","background":"#F0F3FC","width":"calc(100% - 320rpx)","fontSize":"28rpx","height":"88rpx"}' type="password" class="uni-input" name="" placeholder="请输入密码" />
				</view>
				<view v-if="true && loginType==1" class="code" :style='{"width":"100%","margin":"0 0 24rpx 0","display":"flex","height":"auto"}'>
					<view :style='{"color":"#A1A1A1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"160rpx","lineHeight":"88rpx","fontSize":"28rpx","height":"88rpx"}' class="label">验证码：</view>
					<input :style='{"border":"none","padding":"0 24rpx","margin":"0","color":"rgb(0, 0, 0)","borderRadius":"0","background":"#F0F3FC","width":"calc(100% - 320rpx)","fontSize":"28rpx","height":"88rpx"}' type="text" v-model="inputCode" placeholder="请输入验证码" />
					<view class="getCodeBt" :style='{"border":"none","padding":"0px","margin":"0px","alignItems":"center","borderRadius":"0 60rpx 60rpx 0","background":"#F0F3FC","display":"flex","width":"160rpx","justifyContent":"center","height":"88rpx"}' @click="randomString(4)">
						<view v-for="(item, index) in codes" :key="index" :style="{color:item.color,transform:item.rotate,fontSize:item.size,padding: '0 3px',display:'inline-block'}">{{ item.num }}</view>
					</view>
				</view>
				<view v-if="roleNum>1" :style='{"width":"100%","margin":"0 0 24rpx 0","display":"flex","height":"auto"}'>
					<view :style='{"color":"#A1A1A1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"160rpx","lineHeight":"88rpx","fontSize":"28rpx","height":"88rpx"}' class="label">用户类型：</view>
					<picker @change="optionsChange" :value="index" :range="options" :style='{"padding":"0 20rpx","color":"#FFBC1D","borderRadius":"0 60rpx 60rpx 0","flex":"1","background":"#F0F3FC","width":"calc(100% - 160rpx)","lineHeight":"88rpx","fontSize":"28rpx"}'>
						<view class="uni-picker-type">{{options[index]}}</view>
					</picker>
				</view>
				

				
				<button v-if="loginType==1" class="btn-submit" @tap="onLoginTap" type="primary" :style='{"border":"0","padding":"0px","margin":"0 0 24rpx auto","color":"rgb(255, 255, 255)","borderRadius":"30rpx 60rpx 60rpx 0","background":"#FFBC1D","width":"calc(100% - 0px)","lineHeight":"88rpx","fontSize":"32rpx","height":"88rpx"}'>登陆</button>
				<!-- #ifdef MP-WEIXIN -->
				<button v-if="loginType==1" class="btn-submit" open-type="getUserInfo" @getuserinfo="getUserInfo" type="primary" :style='{"border":"0","padding":"0px","margin":"0 0 24rpx auto","color":"rgb(255, 255, 255)","borderRadius":"30rpx 60rpx 60rpx 0","background":"#FFBC1D","width":"calc(100% - 0px)","lineHeight":"88rpx","fontSize":"32rpx","height":"88rpx"}'>微信登录</button>
				<!-- #endif -->
				<button v-if="loginType==2" class="btn-submit" @tap="onFaceLoginTap" type="primary" :style='{"border":"0","padding":"0px","margin":"0 0 24rpx auto","color":"rgb(255, 255, 255)","borderRadius":"30rpx 60rpx 60rpx 0","background":"#FFBC1D","width":"calc(100% - 0px)","lineHeight":"88rpx","fontSize":"32rpx","height":"88rpx"}'>人脸识别登录</button>
				<view class="links" :style='{"width":"100%","margin":"0 0 24rpx 0","flexWrap":"wrap","display":"flex","height":"auto"}'>
					<view class="link-highlight" @tap="onRegisterTap('yonghu')" :style='{"width":"25%","padding":"0 0","fontSize":"28rpx","lineHeight":"2","color":"#999","textAlign":"center"}'>注册用户</view>
					<view class="link-highlight" @tap="onRegisterTap('qishou')" :style='{"width":"25%","padding":"0 0","fontSize":"28rpx","lineHeight":"2","color":"#999","textAlign":"center"}'>注册骑手</view>
					<view @tap="onForgetTap" :style='{"width":"25%","padding":"0 0","fontSize":"28rpx","lineHeight":"2","color":"#999"}'>忘记密码？</view>
				</view>
				
				<view class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea1</view>
				<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
				<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
			</view>
		</view>
	</view>
</template>

<script>
	import menu from '@/utils/menu'
	export default {
		data() {
			return {
				username: '',
				password: '',
                loginType:1,
				codes: [{
				  num: 1,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 2,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 3,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}, {
				  num: 4,
				  color: '#000',
				  rotate: '10deg',
				  size: '16px'
				}],
				options: [
					'请选择登录用户类型',
				],
                optionsValues: [
					'',
                    'yonghu',
                    'qishou',
				],
                inputCode: '',
                validateCode:'',
				index: 0,
				roleNum:0,

				// #ifdef MP-WEIXIN
				code: '',
				// #endif
			}
		},
		onLoad() {
			let options = ['请选择登录用户类型'];
			let menus = menu.list();
			this.menuList = menus;
			for(let i=0;i<this.menuList.length;i++){
				if(this.menuList[i].hasFrontLogin=='是'){
					options.push(this.menuList[i].roleName);
					this.roleNum++;
				}
			}
			if(this.roleNum==1) {
				this.index = 1;
			}	
			this.options = options;
			this.randomString(4)
			this.styleChange()
		},
		onShow() {
			// #ifdef MP-WEIXIN
			let that = this
			uni.login({
				provider: 'weixin',
				success(res) {
					that.code = res.code
				}
			})
			// #endif
		},
		mounted() {
		},
		methods: {
			// #ifdef MP-WEIXIN
			async getUserInfo(e) {
				let that = this
				if (!this.optionsValues[this.index]) {
					this.$utils.msg('请选择登录用户类型')
					return
				}
				if (e.detail.errMsg === "getUserInfo:ok") {
					uni.showModal({
						content:'是否使用微信授权登录？',
						success:async (rs)=> {
							if(rs.confirm){
								let params = {
									code: that.code,
									encryptedData: e.detail.encryptedData,
									iv: e.detail.iv,
									rawData: e.detail.rawData,
									signature: e.detail.signature
								}
								let res = await that.$api.wxlogin(that.optionsValues[that.index], params)
								uni.removeStorageSync("useridTag");
								uni.setStorageSync("appToken", res.token);
								uni.setStorageSync("nickname", that.username);
								uni.setStorageSync("nowTable", `${that.optionsValues[that.index]}`);
								res = await that.$api.session(`${that.optionsValues[that.index]}`);
								if (res.data.touxiang) {
									uni.setStorageSync('headportrait', res.data.touxiang);
								} else if (res.data.headportrait) {
									uni.setStorageSync('headportrait', res.data.headportrait);
								}
								uni.setStorageSync('userSession',JSON.stringify(res.data))
								// 保存用户id
								uni.setStorageSync("appUserid", res.data.id);
								if (res.data.vip) {
									uni.setStorageSync("vip", res.data.vip);
								}
								uni.setStorageSync("appRole", `${that.options[that.index]}`);
								that.$utils.tab('../index/index');
							}
						}
					})
					
				}
			},
			// #endif
			randomString(len = 4) {
			  const chars = [
			    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			    'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			    'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			    'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			    'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
			    '3', '4', '5', '6', '7', '8', '9'
			  ]
			  const colors = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']
			  const sizes = ['28', '30', '32', '34', '36']
			
              this.validateCode = ''
			  for (let i = 0; i < len; i++) {
			    // 随机验证码
			    const key = Math.floor(Math.random() * chars.length)
			    this.codes[i].num = chars[key]
                this.validateCode = this.validateCode+chars[key]
			    // 随机验证码颜色
			    let code = '#'
			    for (let j = 0; j < 6; j++) {
			      const key = Math.floor(Math.random() * colors.length)
			      code += colors[key]
			    }
			    this.codes[i].color = code
			    // 随机验证码方向
			    let rotate = Math.floor(Math.random() * 30)
			    const plus = Math.floor(Math.random() * 2)
			    if (plus == 1) rotate = '-' + rotate
			    this.codes[i].rotate = 'rotate(' + rotate + 'deg)'
			    // 随机验证码字体大小
			    const size = Math.floor(Math.random() * sizes.length)
			    this.codes[i].size = sizes[size] +'rpx'
			  }
			},
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.loginFrom.content.input.backgroundColor
					// })
				})
			},
			onRegisterTap(tableName) {
                uni.setStorageSync("loginTable", tableName);
				this.$utils.jump('../register/register')
			},
			onForgetTap() {
				this.$utils.jump('../forget/forget')
			},
			async onLoginTap() {
                if (!this.username) {
					this.$utils.msg('请输入用户名')
					return
				}
                if (!this.password) {
					this.$utils.msg('请输入用户密码')
					return
				}
                if (!this.optionsValues[this.index]) {
					this.$utils.msg('请选择登录用户类型')
					return
				}
                let inputCodeLower = JSON.parse(JSON.stringify(this.inputCode)).toLowerCase()
                let validateCodeLower = JSON.parse(JSON.stringify(this.validateCode)).toLowerCase()
                if(inputCodeLower!=validateCodeLower && true) {
                    this.$utils.msg('请输入正确的验证码')
                    return
                }

				this.loginPost()

			},
			async loginPost() {
				
				let res = await this.$api.login(`${this.optionsValues[this.index]}`, {
					username: this.username,
					password: this.password
				});
				uni.removeStorageSync("useridTag");
				uni.setStorageSync("appToken", res.token);
				uni.setStorageSync("nickname",this.username);
				uni.setStorageSync("nowTable", `${this.optionsValues[this.index]}`);
				res = await this.$api.session(`${this.optionsValues[this.index]}`);
				if(res.data.touxiang) {
				    uni.setStorageSync('headportrait', res.data.touxiang);
				} else if(res.data.headportrait) {
				    uni.setStorageSync('headportrait', res.data.headportrait);
				}
				uni.setStorageSync('userSession',JSON.stringify(res.data))
				// 保存用户id
				uni.setStorageSync("appUserid", res.data.id);
				if(res.data.vip) {
					uni.setStorageSync("vip", res.data.vip);
				}
				uni.setStorageSync("appRole", `${this.options[this.index]}`);
				this.$utils.tab('../index/index');
			},
			optionsChange(e) {
				this.index = e.target.value
			}
		}
	}
</script>

<style lang="scss" scoped>
	page {
		height: 100%;
	}
	
	.content {
		height: 100%;
		box-sizing: border-box;
	}
	
</style>
