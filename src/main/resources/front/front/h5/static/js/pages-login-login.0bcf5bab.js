(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-login-login"],{3285:function(t,e,i){"use strict";i.r(e);var n=i("6263"),r=i.n(n);for(var a in n)"default"!==a&&function(t){i.d(e,t,(function(){return n[t]}))}(a);e["default"]=r.a},6263:function(t,e,i){"use strict";var n=i("4ea4");Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0,i("96cf");var r=n(i("3b8d")),a=n(i("2971")),o={data:function(){return{username:"",password:"",loginType:1,codes:[{num:1,color:"#000",rotate:"10deg",size:"16px"},{num:2,color:"#000",rotate:"10deg",size:"16px"},{num:3,color:"#000",rotate:"10deg",size:"16px"},{num:4,color:"#000",rotate:"10deg",size:"16px"}],options:["请选择登录用户类型"],optionsValues:["","yonghu","qishou"],inputCode:"",validateCode:"",index:0,roleNum:0}},onLoad:function(){var t=["请选择登录用户类型"],e=a.default.list();this.menuList=e;for(var i=0;i<this.menuList.length;i++)"是"==this.menuList[i].hasFrontLogin&&(t.push(this.menuList[i].roleName),this.roleNum++);1==this.roleNum&&(this.index=1),this.options=t,this.randomString(4),this.styleChange()},onShow:function(){},mounted:function(){},methods:{randomString:function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:4,e=["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"],i=["0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"],n=["28","30","32","34","36"];this.validateCode="";for(var r=0;r<t;r++){var a=Math.floor(Math.random()*e.length);this.codes[r].num=e[a],this.validateCode=this.validateCode+e[a];for(var o="#",s=0;s<6;s++){var u=Math.floor(Math.random()*i.length);o+=i[u]}this.codes[r].color=o;var d=Math.floor(30*Math.random()),l=Math.floor(2*Math.random());1==l&&(d="-"+d),this.codes[r].rotate="rotate("+d+"deg)";var p=Math.floor(Math.random()*n.length);this.codes[r].size=n[p]+"rpx"}},styleChange:function(){this.$nextTick((function(){}))},onRegisterTap:function(t){uni.setStorageSync("loginTable",t),this.$utils.jump("../register/register")},onForgetTap:function(){this.$utils.jump("../forget/forget")},onLoginTap:function(){var t=(0,r.default)(regeneratorRuntime.mark((function t(){var e,i;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(this.username){t.next=3;break}return this.$utils.msg("请输入用户名"),t.abrupt("return");case 3:if(this.password){t.next=6;break}return this.$utils.msg("请输入用户密码"),t.abrupt("return");case 6:if(this.optionsValues[this.index]){t.next=9;break}return this.$utils.msg("请选择登录用户类型"),t.abrupt("return");case 9:if(e=JSON.parse(JSON.stringify(this.inputCode)).toLowerCase(),i=JSON.parse(JSON.stringify(this.validateCode)).toLowerCase(),e==i){t.next=14;break}return this.$utils.msg("请输入正确的验证码"),t.abrupt("return");case 14:this.loginPost();case 15:case"end":return t.stop()}}),t,this)})));function e(){return t.apply(this,arguments)}return e}(),loginPost:function(){var t=(0,r.default)(regeneratorRuntime.mark((function t(){var e;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,this.$api.login("".concat(this.optionsValues[this.index]),{username:this.username,password:this.password});case 2:return e=t.sent,uni.removeStorageSync("useridTag"),uni.setStorageSync("appToken",e.token),uni.setStorageSync("nickname",this.username),uni.setStorageSync("nowTable","".concat(this.optionsValues[this.index])),t.next=9,this.$api.session("".concat(this.optionsValues[this.index]));case 9:e=t.sent,e.data.touxiang?uni.setStorageSync("headportrait",e.data.touxiang):e.data.headportrait&&uni.setStorageSync("headportrait",e.data.headportrait),uni.setStorageSync("userSession",JSON.stringify(e.data)),uni.setStorageSync("appUserid",e.data.id),e.data.vip&&uni.setStorageSync("vip",e.data.vip),uni.setStorageSync("appRole","".concat(this.options[this.index])),this.$utils.tab("../index/index");case 16:case"end":return t.stop()}}),t,this)})));function e(){return t.apply(this,arguments)}return e}(),optionsChange:function(t){this.index=t.target.value}}};e.default=o},8206:function(t,e,i){var n=i("24fb");e=n(!1),e.push([t.i,'@charset "UTF-8";\n/**\r\n * 这里是uni-app内置的常用样式变量\r\n *\r\n * uni-app 官方扩展插件及插件市场（https://ext.dcloud.net.cn）上很多三方插件均使用了这些样式变量\r\n * 如果你是插件开发者，建议你使用scss预处理，并在插件代码中直接使用这些变量（无需 import 这个文件），方便用户通过搭积木的方式开发整体风格一致的App\r\n *\r\n */\n/**\r\n * 如果你是App开发者（插件使用者），你可以通过修改这些变量来定制自己的插件主题，实现自定义主题功能\r\n *\r\n * 如果你的项目同样使用了scss预处理，你也可以直接在你的 scss 代码中使用如下变量，同时无需 import 这个文件\r\n */\n/* 颜色变量 */\n/* 行为相关颜色 */\n/* 文字基本颜色 */\n/* 背景颜色 */\n/* 边框颜色 */\n/* 尺寸变量 */\n/* 文字尺寸 */\n/* 图片尺寸 */\n/* Border Radius */\n/* 水平间距 */\n/* 垂直间距 */\n/* 透明度 */\n/* 文章场景相关 */uni-page-body[data-v-52a4c998]{height:100%}.content[data-v-52a4c998]{height:100%;box-sizing:border-box}',""]),t.exports=e},"8d93":function(t,e,i){"use strict";var n=i("a6da"),r=i.n(n);r.a},a6da:function(t,e,i){var n=i("8206");"string"===typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);var r=i("4f06").default;r("ec7e79fe",n,!0,{sourceMap:!1,shadowMode:!1})},a86a:function(t,e,i){"use strict";i.r(e);var n=i("bd8b"),r=i("3285");for(var a in r)"default"!==a&&function(t){i.d(e,t,(function(){return r[t]}))}(a);i("8d93");var o,s=i("f0c5"),u=Object(s["a"])(r["default"],n["b"],n["c"],!1,null,"52a4c998",null,!1,n["a"],o);e["default"]=u.exports},bd8b:function(t,e,i){"use strict";var n,r=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-uni-view",{staticClass:"content"},[i("v-uni-view",{staticClass:"box",style:{padding:"24rpx",alignItems:"flex-end",background:"url(http://codegen.caihongy.cn/20231204/e2ddfa85341f475b8135741b962ec087.gif)",display:"flex",width:"100%",backgroundSize:"cover",backgroundPosition:"center center",backgroundRepeat:"no-repeat",height:"100%"}},[i("v-uni-view",{style:{padding:"24rpx 0",alignItems:"center",flexDirection:"column",display:"flex",width:"100%",position:"relative",justifyContent:"space-around",height:"70%"}},[i("v-uni-image",{style:{width:"160rpx",margin:"0 auto 24rpx auto",borderRadius:"8rpx",display:"none",height:"160rpx"},attrs:{src:"http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg",mode:"aspectFill"}}),1==t.loginType?i("v-uni-view",{staticClass:"uni-form-item uni-column",style:{width:"100%",margin:"0 0 24rpx 0",alignItems:"center",display:"flex",height:"auto"}},[i("v-uni-view",{staticClass:"label",style:{color:"#A1A1A1",borderRadius:"30rpx 0 0 0",textAlign:"right",background:"#F0F3FC",width:"160rpx",lineHeight:"88rpx",fontSize:"28rpx",height:"88rpx"}},[t._v("账号：")]),i("v-uni-input",{staticClass:"uni-input",style:{border:"none",padding:"0px 24rpx",margin:"0px",color:"rgb(0, 0, 0)",borderRadius:"0 60rpx 60rpx 0",flex:"1",background:"#F0F3FC",width:"calc(100% - 320rpx)",fontSize:"28rpx",height:"88rpx"},attrs:{type:"text",name:"",placeholder:"请输入账号"},model:{value:t.username,callback:function(e){t.username=e},expression:"username"}})],1):t._e(),1==t.loginType?i("v-uni-view",{staticClass:"uni-form-item uni-column",style:{width:"100%",margin:"0 0 24rpx 0",alignItems:"center",display:"flex",height:"auto"}},[i("v-uni-view",{staticClass:"label",style:{color:"#A1A1A1",borderRadius:"30rpx 0 0 0",textAlign:"right",background:"#F0F3FC",width:"160rpx",lineHeight:"88rpx",fontSize:"28rpx",height:"88rpx"}},[t._v("密码：")]),i("v-uni-input",{staticClass:"uni-input",style:{border:"none",padding:"0px 24rpx",margin:"0px",color:"rgb(0, 0, 0)",borderRadius:"0 60rpx 60rpx 0",flex:"1",background:"#F0F3FC",width:"calc(100% - 320rpx)",fontSize:"28rpx",height:"88rpx"},attrs:{type:"password",name:"",placeholder:"请输入密码"},model:{value:t.password,callback:function(e){t.password=e},expression:"password"}})],1):t._e(),1==t.loginType?i("v-uni-view",{staticClass:"code",style:{width:"100%",margin:"0 0 24rpx 0",display:"flex",height:"auto"}},[i("v-uni-view",{staticClass:"label",style:{color:"#A1A1A1",borderRadius:"30rpx 0 0 0",textAlign:"right",background:"#F0F3FC",width:"160rpx",lineHeight:"88rpx",fontSize:"28rpx",height:"88rpx"}},[t._v("验证码：")]),i("v-uni-input",{style:{border:"none",padding:"0 24rpx",margin:"0",color:"rgb(0, 0, 0)",borderRadius:"0",background:"#F0F3FC",width:"calc(100% - 320rpx)",fontSize:"28rpx",height:"88rpx"},attrs:{type:"text",placeholder:"请输入验证码"},model:{value:t.inputCode,callback:function(e){t.inputCode=e},expression:"inputCode"}}),i("v-uni-view",{staticClass:"getCodeBt",style:{border:"none",padding:"0px",margin:"0px",alignItems:"center",borderRadius:"0 60rpx 60rpx 0",background:"#F0F3FC",display:"flex",width:"160rpx",justifyContent:"center",height:"88rpx"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.randomString(4)}}},t._l(t.codes,(function(e,n){return i("v-uni-view",{key:n,style:{color:e.color,transform:e.rotate,fontSize:e.size,padding:"0 3px",display:"inline-block"}},[t._v(t._s(e.num))])})),1)],1):t._e(),t.roleNum>1?i("v-uni-view",{style:{width:"100%",margin:"0 0 24rpx 0",display:"flex",height:"auto"}},[i("v-uni-view",{staticClass:"label",style:{color:"#A1A1A1",borderRadius:"30rpx 0 0 0",textAlign:"right",background:"#F0F3FC",width:"160rpx",lineHeight:"88rpx",fontSize:"28rpx",height:"88rpx"}},[t._v("用户类型：")]),i("v-uni-picker",{style:{padding:"0 20rpx",color:"#FFBC1D",borderRadius:"0 60rpx 60rpx 0",flex:"1",background:"#F0F3FC",width:"calc(100% - 160rpx)",lineHeight:"88rpx",fontSize:"28rpx"},attrs:{value:t.index,range:t.options},on:{change:function(e){arguments[0]=e=t.$handleEvent(e),t.optionsChange.apply(void 0,arguments)}}},[i("v-uni-view",{staticClass:"uni-picker-type"},[t._v(t._s(t.options[t.index]))])],1)],1):t._e(),1==t.loginType?i("v-uni-button",{staticClass:"btn-submit",style:{border:"0",padding:"0px",margin:"0 0 24rpx auto",color:"rgb(255, 255, 255)",borderRadius:"30rpx 60rpx 60rpx 0",background:"#FFBC1D",width:"calc(100% - 0px)",lineHeight:"88rpx",fontSize:"32rpx",height:"88rpx"},attrs:{type:"primary"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.onLoginTap.apply(void 0,arguments)}}},[t._v("登陆")]):t._e(),2==t.loginType?i("v-uni-button",{staticClass:"btn-submit",style:{border:"0",padding:"0px",margin:"0 0 24rpx auto",color:"rgb(255, 255, 255)",borderRadius:"30rpx 60rpx 60rpx 0",background:"#FFBC1D",width:"calc(100% - 0px)",lineHeight:"88rpx",fontSize:"32rpx",height:"88rpx"},attrs:{type:"primary"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.onFaceLoginTap.apply(void 0,arguments)}}},[t._v("人脸识别登录")]):t._e(),i("v-uni-view",{staticClass:"links",style:{width:"100%",margin:"0 0 24rpx 0",flexWrap:"wrap",display:"flex",height:"auto"}},[i("v-uni-view",{staticClass:"link-highlight",style:{width:"25%",padding:"0 0",fontSize:"28rpx",lineHeight:"2",color:"#999",textAlign:"center"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.onRegisterTap("yonghu")}}},[t._v("注册用户")]),i("v-uni-view",{staticClass:"link-highlight",style:{width:"25%",padding:"0 0",fontSize:"28rpx",lineHeight:"2",color:"#999",textAlign:"center"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.onRegisterTap("qishou")}}},[t._v("注册骑手")]),i("v-uni-view",{style:{width:"25%",padding:"0 0",fontSize:"28rpx",lineHeight:"2",color:"#999"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.onForgetTap.apply(void 0,arguments)}}},[t._v("忘记密码？")])],1),i("v-uni-view",{staticClass:"idea1",style:{width:"100%",background:"red",display:"none",height:"80rpx"}},[t._v("idea1")]),i("v-uni-view",{staticClass:"idea2",style:{width:"100%",background:"red",display:"none",height:"80rpx"}},[t._v("idea2")]),i("v-uni-view",{staticClass:"idea3",style:{width:"100%",background:"red",display:"none",height:"80rpx"}},[t._v("idea3")])],1)],1)],1)},a=[];i.d(e,"b",(function(){return r})),i.d(e,"c",(function(){return a})),i.d(e,"a",(function(){return n}))}}]);