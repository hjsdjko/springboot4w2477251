<template>
<view class="content">
	<view class="box" :style='{"padding":"24rpx","alignItems":"flex-end","background":"url(http://codegen.caihongy.cn/20231204/9183e06d975e4c669a8462ada5c8f631.gif)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center  center","backgroundRepeat":"no-repeat","height":"100%"}'>
		<view :style='{"padding":"24rpx 0 0","alignItems":"center","flexDirection":"column","display":"flex","width":"100%","position":"relative","height":"auto"}'>
			<image :style='{"width":"160rpx","margin":"0 auto 24rpx auto","borderRadius":"8rpx","display":"none","height":"160rpx"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" mode="aspectFill"></image>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"30rpx 60rpx 60rpx 60rpx","background":"#F0F3FC","display":"flex","height":"88rpx"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#a1a1a1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"auto","lineHeight":"88rpx","fontSize":"28rpx","minWidth":"220rpx","height":"88rpx"}' class="label">账号：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0 60rpx 60rpx 0","flex":"1","background":"#F0F3FC","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.zhanghao"  type="text"  class="uni-input" name="" placeholder="账号" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"30rpx 60rpx 60rpx 60rpx","background":"#F0F3FC","display":"flex","height":"88rpx"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#a1a1a1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"auto","lineHeight":"88rpx","fontSize":"28rpx","minWidth":"220rpx","height":"88rpx"}' class="label">密码：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0 60rpx 60rpx 0","flex":"1","background":"#F0F3FC","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"30rpx 60rpx 60rpx 60rpx","background":"#F0F3FC","display":"flex","height":"88rpx"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#a1a1a1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"auto","lineHeight":"88rpx","fontSize":"28rpx","minWidth":"220rpx","height":"88rpx"}' class="label">确认密码：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0 60rpx 60rpx 0","flex":"1","background":"#F0F3FC","fontSize":"28rpx","height":"88rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"30rpx 60rpx 60rpx 60rpx","background":"#F0F3FC","display":"flex","height":"88rpx"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#a1a1a1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"auto","lineHeight":"88rpx","fontSize":"28rpx","minWidth":"220rpx","height":"88rpx"}' class="label">姓名：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0 60rpx 60rpx 0","flex":"1","background":"#F0F3FC","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.xingming"  type="text"  class="uni-input" name="" placeholder="姓名" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"30rpx 60rpx 60rpx 60rpx","background":"#F0F3FC","display":"flex","height":"88rpx"}' v-if="tableName=='yonghu'" class="">
				<view :style='{"color":"#a1a1a1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"auto","lineHeight":"88rpx","fontSize":"28rpx","minWidth":"220rpx","height":"88rpx"}' class="label">性别：</view>
				<picker :style='{"width":"100%","margin":"0 0 24rpx 0","flex":"1","display":"flex","height":"auto"}' v-if="tableName=='yonghu'"  @change="yonghuxingbieChange" :value="yonghuxingbieIndex" :range="yonghuxingbieOptions">
					<view>
						<view :style='{"padding":"0 20rpx","color":"#FFBC1D","borderRadius":"0 60rpx 60rpx 0","flex":"1","background":"#F0F3FC","lineHeight":"88rpx","fontSize":"28rpx"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"30rpx 60rpx 60rpx 60rpx","background":"#F0F3FC","display":"flex","height":"88rpx"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#a1a1a1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"auto","lineHeight":"88rpx","fontSize":"28rpx","minWidth":"220rpx","height":"88rpx"}' class="label">手机：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0 60rpx 60rpx 0","flex":"1","background":"#F0F3FC","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.shouji"  type="text"  class="uni-input" name="" placeholder="手机" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"30rpx 60rpx 60rpx 60rpx","background":"#F0F3FC","display":"flex","height":"88rpx"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#a1a1a1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"auto","lineHeight":"88rpx","fontSize":"28rpx","minWidth":"220rpx","height":"88rpx"}' class="label">邮箱：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0 60rpx 60rpx 0","flex":"1","background":"#F0F3FC","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.youxiang"  type="text"  class="uni-input" name="" placeholder="邮箱" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"30rpx 60rpx 60rpx 60rpx","background":"#F0F3FC","display":"flex","height":"88rpx"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#a1a1a1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"auto","lineHeight":"88rpx","fontSize":"28rpx","minWidth":"220rpx","height":"88rpx"}' class="label">身份证：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0 60rpx 60rpx 0","flex":"1","background":"#F0F3FC","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.shenfenzheng"  type="text"  class="uni-input" name="" placeholder="身份证" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"30rpx 60rpx 60rpx 60rpx","background":"#F0F3FC","display":"flex","height":"88rpx"}' v-if="tableName=='yonghu'" @tap="yonghutouxiangTap" class="">
				<view :style='{"color":"#a1a1a1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"auto","lineHeight":"88rpx","fontSize":"28rpx","minWidth":"220rpx","height":"88rpx"}' class="label">头像：</view>
				<image :style='{"width":"128rpx","borderRadius":"0px","objectFit":"cover","display":"block","height":"88rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"128rpx","borderRadius":"0px","objectFit":"cover","display":"block","height":"88rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"30rpx 60rpx 60rpx 60rpx","background":"#F0F3FC","display":"flex","height":"88rpx"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#a1a1a1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"auto","lineHeight":"88rpx","fontSize":"28rpx","minWidth":"220rpx","height":"88rpx"}' class="label">密保问题：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0 60rpx 60rpx 0","flex":"1","background":"#F0F3FC","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.pquestion"  type="text"  class="uni-input" name="" placeholder="密保问题" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"30rpx 60rpx 60rpx 60rpx","background":"#F0F3FC","display":"flex","height":"88rpx"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#a1a1a1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"auto","lineHeight":"88rpx","fontSize":"28rpx","minWidth":"220rpx","height":"88rpx"}' class="label">密保答案：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0 60rpx 60rpx 0","flex":"1","background":"#F0F3FC","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.panswer"  type="text"  class="uni-input" name="" placeholder="密保答案" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"30rpx 60rpx 60rpx 60rpx","background":"#F0F3FC","display":"flex","height":"88rpx"}' v-if="tableName=='qishou'" class="uni-form-item uni-column">
				<view :style='{"color":"#a1a1a1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"auto","lineHeight":"88rpx","fontSize":"28rpx","minWidth":"220rpx","height":"88rpx"}' class="label">骑手账号：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0 60rpx 60rpx 0","flex":"1","background":"#F0F3FC","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.qishouzhanghao"  type="text"  class="uni-input" name="" placeholder="骑手账号" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"30rpx 60rpx 60rpx 60rpx","background":"#F0F3FC","display":"flex","height":"88rpx"}' v-if="tableName=='qishou'" class="uni-form-item uni-column">
				<view :style='{"color":"#a1a1a1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"auto","lineHeight":"88rpx","fontSize":"28rpx","minWidth":"220rpx","height":"88rpx"}' class="label">骑手姓名：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0 60rpx 60rpx 0","flex":"1","background":"#F0F3FC","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.qishouxingming"  type="text"  class="uni-input" name="" placeholder="骑手姓名" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"30rpx 60rpx 60rpx 60rpx","background":"#F0F3FC","display":"flex","height":"88rpx"}' v-if="tableName=='qishou'" class="uni-form-item uni-column">
				<view :style='{"color":"#a1a1a1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"auto","lineHeight":"88rpx","fontSize":"28rpx","minWidth":"220rpx","height":"88rpx"}' class="label">密码：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0 60rpx 60rpx 0","flex":"1","background":"#F0F3FC","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"30rpx 60rpx 60rpx 60rpx","background":"#F0F3FC","display":"flex","height":"88rpx"}' v-if="tableName=='qishou'" class="uni-form-item uni-column">
				<view :style='{"color":"#a1a1a1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"auto","lineHeight":"88rpx","fontSize":"28rpx","minWidth":"220rpx","height":"88rpx"}' class="label">确认密码：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0 60rpx 60rpx 0","flex":"1","background":"#F0F3FC","fontSize":"28rpx","height":"88rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"30rpx 60rpx 60rpx 60rpx","background":"#F0F3FC","display":"flex","height":"88rpx"}' v-if="tableName=='qishou'" class="">
				<view :style='{"color":"#a1a1a1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"auto","lineHeight":"88rpx","fontSize":"28rpx","minWidth":"220rpx","height":"88rpx"}' class="label">性别：</view>
				<picker :style='{"width":"100%","margin":"0 0 24rpx 0","flex":"1","display":"flex","height":"auto"}' v-if="tableName=='qishou'"  @change="qishouxingbieChange" :value="qishouxingbieIndex" :range="qishouxingbieOptions">
					<view>
						<view :style='{"padding":"0 20rpx","color":"#FFBC1D","borderRadius":"0 60rpx 60rpx 0","flex":"1","background":"#F0F3FC","lineHeight":"88rpx","fontSize":"28rpx"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"30rpx 60rpx 60rpx 60rpx","background":"#F0F3FC","display":"flex","height":"88rpx"}' v-if="tableName=='qishou'" class="uni-form-item uni-column">
				<view :style='{"color":"#a1a1a1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"auto","lineHeight":"88rpx","fontSize":"28rpx","minWidth":"220rpx","height":"88rpx"}' class="label">联系电话：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0 60rpx 60rpx 0","flex":"1","background":"#F0F3FC","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.lianxidianhua"  type="text"  class="uni-input" name="" placeholder="联系电话" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"30rpx 60rpx 60rpx 60rpx","background":"#F0F3FC","display":"flex","height":"88rpx"}' v-if="tableName=='qishou'" @tap="qishouzhaopianTap" class="">
				<view :style='{"color":"#a1a1a1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"auto","lineHeight":"88rpx","fontSize":"28rpx","minWidth":"220rpx","height":"88rpx"}' class="label">照片：</view>
				<image :style='{"width":"128rpx","borderRadius":"0px","objectFit":"cover","display":"block","height":"88rpx"}' v-if="ruleForm.zhaopian" class="avator" :src="baseUrl+ruleForm.zhaopian" mode=""></image>
                <image :style='{"width":"128rpx","borderRadius":"0px","objectFit":"cover","display":"block","height":"88rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","borderRadius":"30rpx 60rpx 60rpx 60rpx","background":"#F0F3FC","display":"flex","height":"88rpx"}' v-if="tableName=='qishou'" @tap="qishoutijiaorenzhengTap" class="">
				<view :style='{"color":"#a1a1a1","borderRadius":"30rpx 0 0 0","textAlign":"right","background":"#F0F3FC","width":"auto","lineHeight":"88rpx","fontSize":"28rpx","minWidth":"220rpx","height":"88rpx"}' class="label">提交认证：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0 60rpx 60rpx 0","flex":"1","background":"#F0F3FC","fontSize":"28rpx","height":"88rpx"}' v-if="ruleForm.tijiaorenzheng"  v-model="baseUrl+ruleForm.tijiaorenzheng" placeholder="提交认证"></input>
                <image :style='{"width":"128rpx","borderRadius":"0px","objectFit":"cover","display":"block","height":"88rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<button :style='{"border":"0","padding":"0px","margin":"0 auto 24rpx auto","color":"rgb(255, 255, 255)","borderRadius":"30rpx 60rpx 60rpx 0","background":"#FFBC1D","width":"calc(100% - 0px)","lineHeight":"88rpx","fontSize":"32rpx","height":"88rpx"}' class="btn-submit" @tap="register" type="primary">注册</button>
			
			<view class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea1</view>
			<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
			<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
                yonghuxingbieOptions: [],
                yonghuxingbieIndex: 0,
                qishouxingbieOptions: [],
                qishouxingbieIndex: 0,
                qishougongzuozhuangtaiOptions: [],
                qishougongzuozhuangtaiIndex: 0,
				ruleForm: {
                zhanghao: '',
                mima: '',
                xingming: '',
                xingbie: '',
                shouji: '',
                youxiang: '',
                shenfenzheng: '',
                touxiang: '',
                pquestion: '',
                panswer: '',
                openid: '',
                nickname: '',
                avatarurl: '',
                qishouzhanghao: '',
                qishouxingming: '',
                mima: '',
                xingbie: '',
                lianxidianhua: '',
                gongzuozhuangtai: '',
                zhaopian: '',
                yue: '0',
                tijiaorenzheng: '',
                yonghuxieyi: '',
                shhf: '',
                discussnum: '',
                openid: '',
                nickname: '',
                avatarurl: '',
				},
				tableName:""
			}
		},
        components: {
            multipleSelect
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

                        // 自定义下拉框值
			if(this.tableName=='yonghu'){
                this.yonghuxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.yonghuxingbieOptions[0]
			}
                        // 自定义下拉框值
			if(this.tableName=='qishou'){
                this.qishouxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.qishouxingbieOptions[0]
			}
                        // 自定义下拉框值
			if(this.tableName=='qishou'){
                this.qishougongzuozhuangtaiOptions = "空闲,忙碌".split(',');
				this.ruleForm.gongzuozhuangtai=this.qishougongzuozhuangtaiOptions[0]
			}
            if(`qishou` == this.tableName){
                this.ruleForm.yue='0'
            }
			
			this.styleChange()
		},
		methods: {

            // 下拉变化
            yonghuxingbieChange(e) {
                    this.yonghuxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.yonghuxingbieOptions[this.yonghuxingbieIndex]
            },
            yonghutouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
                });
            },
            // 下拉变化
            qishouxingbieChange(e) {
                    this.qishouxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.qishouxingbieOptions[this.qishouxingbieIndex]
            },
            // 下拉变化
            qishougongzuozhuangtaiChange(e) {
                    this.qishougongzuozhuangtaiIndex = e.target.value
                    this.ruleForm.gongzuozhuangtai = this.qishougongzuozhuangtaiOptions[this.qishougongzuozhuangtaiIndex]
            },
            qishouzhaopianTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.zhaopian = 'upload/' + res.file;
					_this.$forceUpdate();
                });
            },
            qishoutijiaorenzhengTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.tijiaorenzheng = 'upload/' + res.file;
					_this.$forceUpdate();
                });
            },
            yonghuxieyiChange(e) {
                this.ruleForm.yonghuxieyi = e
            },

            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				
				if((!this.ruleForm.zhanghao) && `yonghu` == this.tableName){
					this.$utils.msg(`账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `yonghu` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`yonghu` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if(`yonghu` == this.tableName && this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
					this.$utils.msg(`手机应输入手机格式`);
					return
				}
				if(`yonghu` == this.tableName && this.ruleForm.pquestion==''){
				    this.$utils.msg(`密保问题不能为空`);
				    return
				}
				if(`yonghu` == this.tableName && this.ruleForm.panswer==''){
				    this.$utils.msg(`密保答案不能为空`);
				    return
				}
				if((!this.ruleForm.qishouzhanghao) && `qishou` == this.tableName){
					this.$utils.msg(`骑手账号不能为空`);
					return
				}
				if((!this.ruleForm.qishouxingming) && `qishou` == this.tableName){
					this.$utils.msg(`骑手姓名不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `qishou` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`qishou` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if(`qishou` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
					this.$utils.msg(`联系电话应输入手机格式`);
					return
				}
				if(`qishou` == this.tableName && this.ruleForm.yue&&(!this.$validate.isNumber(this.ruleForm.yue))){
					this.$utils.msg(`余额应输入数字`);
					return
				}
				if(`qishou` == this.tableName && this.ruleForm.discussnum&&(!this.$validate.isIntNumer(this.ruleForm.discussnum))){
					this.$utils.msg(`评论数应输入整数`);
					return
				}
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
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
