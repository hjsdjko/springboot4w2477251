<template>
  <div>
    <div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20231112/61b7ca6805d048858264d26fdba7d8cd.jpg)","display":"flex","width":"100%","backgroundSize":"100% 100%","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"flex-end"}'>
      <el-form :style='{"border":"0px solid #f6f6f6","padding":"40px 100px 40px","margin":"0","alignItems":"center","textAlign":"center","flexDirection":"column","display":"flex","justifyContent":"center","minHeight":"100vh","borderRadius":"0px","flexWrap":"wrap","background":"#fff","width":"33%","fontSize":"14px","position":"relative","height":"auto"}'>
        <div v-if="true" :style='{"padding":"0 0 10px","margin":"0 0 0px","borderColor":"#ddd","color":"#53d192","textAlign":"center","display":"inline-block","background":"none","borderWidth":"0 0 0px","width":"100%","lineHeight":"1.2","fontSize":"22px","borderStyle":"solid","fontWeight":"500"}' class="title-container">学生服务平台登录</div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"100%","margin":"0 0 20px","position":"relative","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="true" class="lable" :style='{"color":"#53d192","left":"-100px","textAlign":"right","width":"100px","lineHeight":"44px","fontSize":"inherit","position":"absolute"}'>用户名：</div>
          <input :style='{"padding":"0 10px","borderColor":"#ddd","color":"#666","borderRadius":"0px","background":"none","borderWidth":"0 0 1px","width":"100%","fontSize":"inherit","borderStyle":"solid","height":"40px"}' placeholder="请输入用户名" name="username" type="text" v-model="rulesForm.username">
        </div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"100%","margin":"0 0 20px","position":"relative","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="true" class="lable" :style='{"color":"#53d192","left":"-100px","textAlign":"right","width":"100px","lineHeight":"44px","fontSize":"inherit","position":"absolute"}'>密码：</div>
          <input :style='{"padding":"0 10px","borderColor":"#ddd","color":"#666","borderRadius":"0px","background":"none","borderWidth":"0 0 1px","width":"100%","fontSize":"inherit","borderStyle":"solid","height":"40px"}' placeholder="请输入密码" name="password" type="password" v-model="rulesForm.password">
        </div>

        <div :style='{"width":"100%","margin":"20px auto","fontSize":"inherit","textAlign":"left"}' v-if="roles.length>1" prop="loginInRole" class="list-type">
          <el-radio v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">{{item.roleName}}</el-radio>
        </div>

		
        <div :style='{"margin":"0","alignItems":"center","flexWrap":"wrap","background":"none","display":"inline-block","width":"100%","fontSize":"16px","position":"relative","justifyContent":"flex-start"}'>
          <el-button v-if="loginType==1" :style='{"border":"0px solid #4FA1D9","cursor":"pointer","padding":"0 20px","margin":"0 0 16px","color":"#fff","textAlign":"center","letterSpacing":"4px","float":"right","outline":"none","borderRadius":"6px","background":"#53d192","width":"100%","fontSize":"16px","height":"40px"}' type="primary" @click="login()" class="loginInBt">登录</el-button>
        </div>
      </el-form>

    </div>
  </div>
</template>
<script>
import menu from "@/utils/menu";
export default {
  data() {
    return {
		verifyCheck2: false,
		flag: false,
      baseUrl:this.$base.url,
      loginType: 1,
      rulesForm: {
        username: "",
        password: "",
        role: "",
      },
      menus: [],
      roles: [],
      tableName: "",
    };
  },
  mounted() {
    let menus = menu.list();
    this.menus = menus;

    for (let i = 0; i < this.menus.length; i++) {
      if (this.menus[i].hasBackLogin=='是') {
        this.roles.push(this.menus[i])
      }
    }

  },
  created() {

  },
  destroyed() {
	    },
  components: {
  },
  methods: {

    //注册
    register(tableName){
		this.$storage.set("loginTable", tableName);
		this.$router.push({path:'/register',query:{pageFlag:'register'}})
    },
    // 登陆
    login() {

		if (!this.rulesForm.username) {
			this.$message.error("请输入用户名");
			return;
		}
		if (!this.rulesForm.password) {
			this.$message.error("请输入密码");
			return;
		}
		if(this.roles.length>1) {
			if (!this.rulesForm.role) {
				this.$message.error("请选择角色");
				return;
			}

			let menus = this.menus;
			for (let i = 0; i < menus.length; i++) {
				if (menus[i].roleName == this.rulesForm.role) {
					this.tableName = menus[i].tableName;
				}
			}
		} else {
			this.tableName = this.roles[0].tableName;
			this.rulesForm.role = this.roles[0].roleName;
		}
		
		this.loginPost()
    },
	loginPost() {
		this.$http({
			url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
			method: "post"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.$storage.set("Token", data.token);
				this.$storage.set("role", this.rulesForm.role);
				this.$storage.set("sessionTable", this.tableName);
				this.$storage.set("adminName", this.rulesForm.username);
				this.$router.replace({ path: "/" });
			} else {
				this.$message.error(data.msg);
			}
		});
	},
  }
}
</script>

<style lang="scss" scoped>
.container {
  min-height: 100vh;
  position: relative;
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
      background: url(http://codegen.caihongy.cn/20231112/61b7ca6805d048858264d26fdba7d8cd.jpg);
        
  .list-item /deep/ .el-input .el-input__inner {
		border-radius: 0px;
		padding: 0 10px;
		color: #666;
		background: none;
		width: 100%;
		font-size: inherit;
		border-color: #ddd;
		border-width: 0 0 1px;
		border-style: solid;
		height: 40px;
	  }
  
  .list-item.select /deep/ .el-select .el-input__inner {
		border: 0px solid #afc3ce;
		border-radius: 4px;
		padding: 0 10px;
		margin: 0;
		color: #ccc;
		background: none;
		width: 100%;
		font-size: 14px;
		height: 40px;
	  }
  
  .list-code /deep/ .el-input .el-input__inner {
  	  	border-radius: 0px 0 0 0px;
  	  	padding: 0 10px;
  	  	color: #666;
  	  	background: none;
  	  	width: calc(100% - 80px);
  	  	font-size: inherit;
  	  	border-color: #ddd;
  	  	border-width: 0 0 1px;
  	  	border-style: solid;
  	  	height: 40px;
  	  }

  .list-type /deep/ .el-radio__input .el-radio__inner {
		background: rgba(53, 53, 53, 0);
		border-color: #999;
	  }
  .list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
        background: #53d192;
        border-color: #53d192;
      }
  .list-type /deep/ .el-radio__label {
		color: #999;
		font-size: 14px;
	  }
  .list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
        color: #53d192;
        font-size: 14px;
      }
}

</style>
