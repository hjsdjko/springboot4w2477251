(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-wentifankui-add-or-update"],{"1f5c":function(e,t,r){var i=r("9ab9");"string"===typeof i&&(i=[[e.i,i,""]]),i.locals&&(e.exports=i.locals);var n=r("4f06").default;n("4cc227a6",i,!0,{sourceMap:!1,shadowMode:!1})},5450:function(e,t,r){"use strict";var i=r("1f5c"),n=r.n(i);n.a},6001:function(e,t,r){"use strict";r.r(t);var i=r("c604"),n=r("98a06");for(var a in n)"default"!==a&&function(e){r.d(t,e,(function(){return n[e]}))}(a);r("5450");var o,s=r("f0c5"),u=Object(s["a"])(n["default"],i["b"],i["c"],!1,null,"d969abcc",null,!1,i["a"],o);t["default"]=u.exports},"648f":function(e,t,r){"use strict";var i=r("4ea4");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,r("a481"),r("f559"),r("ac6a"),r("28a5"),r("c5f6"),r("96cf");var n=i(r("3b8d")),a=i(r("e2b1")),o=i(r("064f")),s=i(r("bd56")),u={data:function(){return{cross:"",ruleForm:{zhanghao:"",xingming:"",shouji:"",dingdanbianhao:"",wentifankui:"",touxiang:"",shhf:""},user:{},ro:{zhanghao:!1,xingming:!1,shouji:!1,dingdanbianhao:!1,wentifankui:!1,touxiang:!1,sfsh:!1,shhf:!1}}},components:{wPicker:a.default,xiaEditor:o.default,multipleSelect:s.default},computed:{baseUrl:function(){return this.$base.url}},onLoad:function(){var e=(0,n.default)(regeneratorRuntime.mark((function e(t){var r,i,n,a,o=this;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return r=uni.getStorageSync("nowTable"),e.next=3,this.$api.session(r);case 3:if(i=e.sent,this.user=i.data,this.ruleForm.zhanghao=this.user.zhanghao,this.ro.zhanghao=!0,this.ruleForm.xingming=this.user.xingming,this.ro.xingming=!0,this.ruleForm.shouji=this.user.shouji,this.ro.shouji=!0,this.ruleForm.touxiang=this.user.touxiang,this.ro.touxiang=!0,this.ruleForm.userid=uni.getStorageSync("appUserid"),t.refid&&(this.ruleForm.refid=Number(t.refid),this.ruleForm.nickname=uni.getStorageSync("nickname")),!t.id){e.next=21;break}return this.ruleForm.id=t.id,e.next=19,this.$api.info("wentifankui",this.ruleForm.id);case 19:i=e.sent,this.ruleForm=i.data;case 21:if(this.cross=t.cross,!t.cross){e.next=53;break}n=uni.getStorageSync("crossObj"),e.t0=regeneratorRuntime.keys(n);case 25:if((e.t1=e.t0()).done){e.next=53;break}if(a=e.t1.value,"zhanghao"!=a){e.next=31;break}return this.ruleForm.zhanghao=n[a],this.ro.zhanghao=!0,e.abrupt("continue",25);case 31:if("xingming"!=a){e.next=35;break}return this.ruleForm.xingming=n[a],this.ro.xingming=!0,e.abrupt("continue",25);case 35:if("shouji"!=a){e.next=39;break}return this.ruleForm.shouji=n[a],this.ro.shouji=!0,e.abrupt("continue",25);case 39:if("dingdanbianhao"!=a){e.next=43;break}return this.ruleForm.dingdanbianhao=n[a],this.ro.dingdanbianhao=!0,e.abrupt("continue",25);case 43:if("wentifankui"!=a){e.next=47;break}return this.ruleForm.wentifankui=n[a],this.ro.wentifankui=!0,e.abrupt("continue",25);case 47:if("touxiang"!=a){e.next=51;break}return this.ruleForm.touxiang=n[a].split(",")[0],this.ro.touxiang=!0,e.abrupt("continue",25);case 51:e.next=25;break;case 53:this.styleChange(),this.$forceUpdate(),uni.getStorageSync("raffleType")&&null!=uni.getStorageSync("raffleType")&&(uni.removeStorageSync("raffleType"),setTimeout((function(){o.onSubmitTap()}),300));case 56:case"end":return e.stop()}}),e,this)})));function t(t){return e.apply(this,arguments)}return t}(),methods:{wentifankuiChange:function(e){this.ruleForm.wentifankui=e},styleChange:function(){this.$nextTick((function(){}))},touxiangTap:function(){var e=this;this.$api.upload((function(t){e.ruleForm.touxiang="upload/"+t.file,e.$forceUpdate(),e.$nextTick((function(){e.styleChange()}))}))},getUUID:function(){return(new Date).getTime()},onSubmitTap:function(){var e=(0,n.default)(regeneratorRuntime.mark((function e(){var t,r,i,n,a,o,s,u,l,d;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(!this.cross){e.next=17;break}if(uni.setStorageSync("crossCleanType",!0),a=uni.getStorageSync("statusColumnName"),o=uni.getStorageSync("statusColumnValue"),""==a){e.next=17;break}if(t||(t=uni.getStorageSync("crossObj")),a.startsWith("[")){e.next=13;break}for(s in t)s==a&&(t[s]=o);return u=uni.getStorageSync("crossTable"),e.next=11,this.$api.update("".concat(u),t);case 11:e.next=17;break;case 13:r=Number(uni.getStorageSync("appUserid")),i=t["id"],n=uni.getStorageSync("statusColumnName"),n=n.replace(/\[/,"").replace(/\]/,"");case 17:if(!i||!r){e.next=40;break}return this.ruleForm.crossuserid=r,this.ruleForm.crossrefid=i,l={page:1,limit:10,crossuserid:r,crossrefid:i},e.next=23,this.$api.list("wentifankui",l);case 23:if(d=e.sent,!(d.data.total>=n)){e.next=30;break}return this.$utils.msg(uni.getStorageSync("tips")),uni.removeStorageSync("crossCleanType"),e.abrupt("return",!1);case 30:if(!this.ruleForm.id){e.next=35;break}return e.next=33,this.$api.update("wentifankui",this.ruleForm);case 33:e.next=37;break;case 35:return e.next=37,this.$api.add("wentifankui",this.ruleForm);case 37:this.$utils.msgBack("提交成功");case 38:e.next=48;break;case 40:if(!this.ruleForm.id){e.next=45;break}return e.next=43,this.$api.update("wentifankui",this.ruleForm);case 43:e.next=47;break;case 45:return e.next=47,this.$api.add("wentifankui",this.ruleForm);case 47:this.$utils.msgBack("提交成功");case 48:case"end":return e.stop()}}),e,this)})));function t(){return e.apply(this,arguments)}return t}(),optionsChange:function(e){this.index=e.target.value},bindDateChange:function(e){this.date=e.target.value},getDate:function(e){var t=new Date,r=t.getFullYear(),i=t.getMonth()+1,n=t.getDate();return"start"===e?r-=60:"end"===e&&(r+=2),i=i>9?i:"0"+i,n=n>9?n:"0"+n,"".concat(r,"-").concat(i,"-").concat(n)},toggleTab:function(e){if(this.ro[e])return!1;this.$refs[e].show()}}};t.default=u},"98a06":function(e,t,r){"use strict";r.r(t);var i=r("648f"),n=r.n(i);for(var a in i)"default"!==a&&function(e){r.d(t,e,(function(){return i[e]}))}(a);t["default"]=n.a},"9ab9":function(e,t,r){var i=r("24fb");t=i(!1),t.push([e.i,'@charset "UTF-8";\n/**\r\n * 这里是uni-app内置的常用样式变量\r\n *\r\n * uni-app 官方扩展插件及插件市场（https://ext.dcloud.net.cn）上很多三方插件均使用了这些样式变量\r\n * 如果你是插件开发者，建议你使用scss预处理，并在插件代码中直接使用这些变量（无需 import 这个文件），方便用户通过搭积木的方式开发整体风格一致的App\r\n *\r\n */\n/**\r\n * 如果你是App开发者（插件使用者），你可以通过修改这些变量来定制自己的插件主题，实现自定义主题功能\r\n *\r\n * 如果你的项目同样使用了scss预处理，你也可以直接在你的 scss 代码中使用如下变量，同时无需 import 这个文件\r\n */\n/* 颜色变量 */\n/* 行为相关颜色 */\n/* 文字基本颜色 */\n/* 背景颜色 */\n/* 边框颜色 */\n/* 尺寸变量 */\n/* 文字尺寸 */\n/* 图片尺寸 */\n/* Border Radius */\n/* 水平间距 */\n/* 垂直间距 */\n/* 透明度 */\n/* 文章场景相关 */.content[data-v-d969abcc]{min-height:calc(100vh - 44px);box-sizing:border-box}',""]),e.exports=t},c604:function(e,t,r){"use strict";var i={"xia-editor":r("064f").default},n=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("v-uni-view",{staticClass:"content"},[r("v-uni-view",{style:{width:"100%",padding:"0",position:"relative",background:"#fff",height:"100%"}},[r("v-uni-form",{staticClass:"app-update-pv",style:{width:"100%",padding:"24rpx",background:"#fff",display:"block",height:"auto"}},[r("v-uni-view",{style:{padding:"4rpx 0",margin:"0 0 24rpx 0",borderColor:"#ccc",alignItems:"center",borderRadius:"30rpx 60rpx 60rpx 0",borderWidth:"0",background:"#F0F3FC",display:"flex",width:"100%",borderStyle:"solid",height:"auto"}},[r("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",lineHeight:"80rpx",fontSize:"28rpx",color:"#9E9E9E",textAlign:"center"}},[e._v("账号")]),r("v-uni-input",{style:{border:"0",padding:"0px 24rpx",margin:"0px",color:"rgb(0, 0, 0)",borderRadius:"8rpx",flex:"1",background:"rgba(255, 255, 255, 0)",fontSize:"28rpx",height:"80rpx"},attrs:{disabled:e.ro.zhanghao,placeholder:"账号",type:"text"},model:{value:e.ruleForm.zhanghao,callback:function(t){e.$set(e.ruleForm,"zhanghao",t)},expression:"ruleForm.zhanghao"}})],1),r("v-uni-view",{style:{padding:"4rpx 0",margin:"0 0 24rpx 0",borderColor:"#ccc",alignItems:"center",borderRadius:"30rpx 60rpx 60rpx 0",borderWidth:"0",background:"#F0F3FC",display:"flex",width:"100%",borderStyle:"solid",height:"auto"}},[r("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",lineHeight:"80rpx",fontSize:"28rpx",color:"#9E9E9E",textAlign:"center"}},[e._v("姓名")]),r("v-uni-input",{style:{border:"0",padding:"0px 24rpx",margin:"0px",color:"rgb(0, 0, 0)",borderRadius:"8rpx",flex:"1",background:"rgba(255, 255, 255, 0)",fontSize:"28rpx",height:"80rpx"},attrs:{disabled:e.ro.xingming,placeholder:"姓名",type:"text"},model:{value:e.ruleForm.xingming,callback:function(t){e.$set(e.ruleForm,"xingming",t)},expression:"ruleForm.xingming"}})],1),r("v-uni-view",{style:{padding:"4rpx 0",margin:"0 0 24rpx 0",borderColor:"#ccc",alignItems:"center",borderRadius:"30rpx 60rpx 60rpx 0",borderWidth:"0",background:"#F0F3FC",display:"flex",width:"100%",borderStyle:"solid",height:"auto"}},[r("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",lineHeight:"80rpx",fontSize:"28rpx",color:"#9E9E9E",textAlign:"center"}},[e._v("手机")]),r("v-uni-input",{style:{border:"0",padding:"0px 24rpx",margin:"0px",color:"rgb(0, 0, 0)",borderRadius:"8rpx",flex:"1",background:"rgba(255, 255, 255, 0)",fontSize:"28rpx",height:"80rpx"},attrs:{disabled:e.ro.shouji,placeholder:"手机",type:"text"},model:{value:e.ruleForm.shouji,callback:function(t){e.$set(e.ruleForm,"shouji",t)},expression:"ruleForm.shouji"}})],1),r("v-uni-view",{style:{padding:"4rpx 0",margin:"0 0 24rpx 0",borderColor:"#ccc",alignItems:"center",borderRadius:"30rpx 60rpx 60rpx 0",borderWidth:"0",background:"#F0F3FC",display:"flex",width:"100%",borderStyle:"solid",height:"auto"}},[r("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",lineHeight:"80rpx",fontSize:"28rpx",color:"#9E9E9E",textAlign:"center"}},[e._v("订单编号")]),r("v-uni-input",{style:{border:"0",padding:"0px 24rpx",margin:"0px",color:"rgb(0, 0, 0)",borderRadius:"8rpx",flex:"1",background:"rgba(255, 255, 255, 0)",fontSize:"28rpx",height:"80rpx"},attrs:{disabled:e.ro.dingdanbianhao,placeholder:"订单编号",type:"text"},model:{value:e.ruleForm.dingdanbianhao,callback:function(t){e.$set(e.ruleForm,"dingdanbianhao",t)},expression:"ruleForm.dingdanbianhao"}})],1),r("v-uni-view",{style:{padding:"4rpx 0",margin:"0 0 24rpx 0",borderColor:"#ccc",alignItems:"center",borderRadius:"30rpx 60rpx 60rpx 0",borderWidth:"0",background:"#F0F3FC",display:"flex",width:"100%",borderStyle:"solid",height:"auto"},on:{click:function(t){arguments[0]=t=e.$handleEvent(t),e.touxiangTap.apply(void 0,arguments)}}},[r("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",lineHeight:"80rpx",fontSize:"28rpx",color:"#9E9E9E",textAlign:"center"}},[e._v("头像")]),e.ruleForm.touxiang?r("v-uni-image",{staticClass:"avator",style:{width:"80rpx",margin:"12rpx 0",borderRadius:"100%",objectFit:"cover",display:"block",height:"80rpx"},attrs:{src:e.baseUrl+e.ruleForm.touxiang.split(",")[0],mode:"aspectFill"}}):r("v-uni-image",{staticClass:"avator",style:{width:"80rpx",margin:"12rpx 0",borderRadius:"100%",objectFit:"cover",display:"block",height:"80rpx"},attrs:{src:"../../static/gen/upload.png",mode:"aspectFill"}})],1),r("v-uni-view",{style:{padding:"20rpx",margin:"0 0 24rpx 0",borderColor:"#ccc",borderRadius:"30rpx 60rpx 60rpx 0",borderWidth:"0 0 2rpx 0",background:"#F0F3FC",display:"flex",width:"100%",borderStyle:"solid",height:"auto"}},[r("v-uni-view",{staticClass:"title",style:{width:"160rpx",lineHeight:"80rpx",fontSize:"28rpx",color:"#9e9e9e",textAlign:"center",fontWeight:"500"}},[e._v("问题反馈")]),r("xia-editor",{ref:"editor",style:{minHeight:"300rpx",border:"2rpx solid #efefef",padding:"12rpx",borderRadius:"10rpx",background:"#fff",width:"calc(100% - 160rpx)",height:"auto"},attrs:{placeholder:"问题反馈"},on:{editorChange:function(t){arguments[0]=t=e.$handleEvent(t),e.wentifankuiChange.apply(void 0,arguments)}},model:{value:e.ruleForm.wentifankui,callback:function(t){e.$set(e.ruleForm,"wentifankui",t)},expression:"ruleForm.wentifankui"}})],1),r("v-uni-view",{staticClass:"btn",style:{width:"100%",flexWrap:"wrap",justifyContent:"center",display:"flex",height:"auto"}},[r("v-uni-button",{staticClass:"bg-red",style:{border:"0",padding:"0px",margin:"0 0 20rpx",color:"rgb(255, 255, 255)",borderRadius:"60rpx",background:"#FFBC1D",width:"100%",lineHeight:"80rpx",fontSize:"40rpx",height:"80rpx"},on:{click:function(t){arguments[0]=t=e.$handleEvent(t),e.onSubmitTap.apply(void 0,arguments)}}},[e._v("提交")])],1)],1)],1)],1)},a=[];r.d(t,"b",(function(){return n})),r.d(t,"c",(function(){return a})),r.d(t,"a",(function(){return i}))}}]);