(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-discussxinxifuwuliulan-add-or-update"],{"69af":function(e,t,r){"use strict";var n=r("4ea4");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,r("f559"),r("a481"),r("3b2b"),r("ac6a"),r("28a5"),r("c5f6"),r("96cf");var i=n(r("3b8d")),a=n(r("e2b1")),u=n(r("064f")),s=n(r("bd56")),o={data:function(){return{cross:"",ruleForm:{refid:"",userid:"",avatarurl:"",nickname:"",content:"",reply:""},user:{},ro:{refid:!1,userid:!1,avatarurl:!1,nickname:!1,content:!1,reply:!1}}},components:{wPicker:a.default,xiaEditor:u.default,multipleSelect:s.default},computed:{baseUrl:function(){return this.$base.url}},onLoad:function(){var e=(0,i.default)(regeneratorRuntime.mark((function e(t){var r,n,i,a,u=this;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return r=uni.getStorageSync("nowTable"),e.next=3,this.$api.session(r);case 3:if(n=e.sent,this.user=n.data,this.ruleForm.userid=uni.getStorageSync("appUserid"),t.refid&&(this.ruleForm.refid=Number(t.refid),this.ruleForm.nickname=uni.getStorageSync("nickname")),!t.id){e.next=13;break}return this.ruleForm.id=t.id,e.next=11,this.$api.info("discussxinxifuwuliulan",this.ruleForm.id);case 11:n=e.sent,this.ruleForm=n.data;case 13:if(this.cross=t.cross,!t.cross){e.next=45;break}i=uni.getStorageSync("crossObj"),e.t0=regeneratorRuntime.keys(i);case 17:if((e.t1=e.t0()).done){e.next=45;break}if(a=e.t1.value,"refid"!=a){e.next=23;break}return this.ruleForm.refid=i[a],this.ro.refid=!0,e.abrupt("continue",17);case 23:if("userid"!=a){e.next=27;break}return this.ruleForm.userid=i[a],this.ro.userid=!0,e.abrupt("continue",17);case 27:if("avatarurl"!=a){e.next=31;break}return this.ruleForm.avatarurl=i[a].split(",")[0],this.ro.avatarurl=!0,e.abrupt("continue",17);case 31:if("nickname"!=a){e.next=35;break}return this.ruleForm.nickname=i[a],this.ro.nickname=!0,e.abrupt("continue",17);case 35:if("content"!=a){e.next=39;break}return this.ruleForm.content=i[a],this.ro.content=!0,e.abrupt("continue",17);case 39:if("reply"!=a){e.next=43;break}return this.ruleForm.reply=i[a],this.ro.reply=!0,e.abrupt("continue",17);case 43:e.next=17;break;case 45:this.styleChange(),this.$forceUpdate(),uni.getStorageSync("raffleType")&&null!=uni.getStorageSync("raffleType")&&(uni.removeStorageSync("raffleType"),setTimeout((function(){u.onSubmitTap()}),300));case 48:case"end":return e.stop()}}),e,this)})));function t(t){return e.apply(this,arguments)}return t}(),methods:{contentChange:function(e){this.ruleForm.content=e},styleChange:function(){this.$nextTick((function(){}))},avatarurlTap:function(){var e=this;this.$api.upload((function(t){e.ruleForm.avatarurl="upload/"+t.file,e.$forceUpdate(),e.$nextTick((function(){e.styleChange()}))}))},getUUID:function(){return(new Date).getTime()},onSubmitTap:function(){var e=(0,i.default)(regeneratorRuntime.mark((function e(){var t,r,n,i,a,u,s,o,c,l,d,f,p,h;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:for(this.ruleForm.avatarurl=uni.getStorageSync("headportrait")?uni.getStorageSync("headportrait"):"",t="",r=[],t&&(r=t.split(",")),n=0;n<r.length;n++)i=new RegExp(r[n],"g"),this.ruleForm.content.indexOf(r[n])>-1&&(this.ruleForm.content=this.ruleForm.content.replace(i,"**"));if(this.ruleForm.refid){e.next=8;break}return this.$utils.msg("关联表id不能为空"),e.abrupt("return");case 8:if(this.ruleForm.userid){e.next=11;break}return this.$utils.msg("用户id不能为空"),e.abrupt("return");case 11:if(this.ruleForm.content){e.next=14;break}return this.$utils.msg("评论内容不能为空"),e.abrupt("return");case 14:if(!this.cross){e.next=31;break}if(uni.setStorageSync("crossCleanType",!0),c=uni.getStorageSync("statusColumnName"),l=uni.getStorageSync("statusColumnValue"),""==c){e.next=31;break}if(a||(a=uni.getStorageSync("crossObj")),c.startsWith("[")){e.next=27;break}for(d in a)d==c&&(a[d]=l);return f=uni.getStorageSync("crossTable"),e.next=25,this.$api.update("".concat(f),a);case 25:e.next=31;break;case 27:u=Number(uni.getStorageSync("appUserid")),s=a["id"],o=uni.getStorageSync("statusColumnName"),o=o.replace(/\[/,"").replace(/\]/,"");case 31:if(!s||!u){e.next=55;break}return this.ruleForm.crossuserid=u,this.ruleForm.crossrefid=s,p={page:1,limit:10,crossuserid:u,crossrefid:s},e.next=37,this.$api.list("discussxinxifuwuliulan",p);case 37:if(h=e.sent,!(h.data.total>=o)){e.next=44;break}return this.$utils.msg(uni.getStorageSync("tips")),uni.removeStorageSync("crossCleanType"),e.abrupt("return",!1);case 44:if(!this.ruleForm.id){e.next=49;break}return e.next=47,this.$api.update("discussxinxifuwuliulan",this.ruleForm);case 47:e.next=51;break;case 49:return e.next=51,this.$api.add("discussxinxifuwuliulan",this.ruleForm);case 51:uni.setStorageSync("discussxinxifuwuliulanCleanType",!0),this.$utils.msgBack("提交成功");case 53:e.next=64;break;case 55:if(!this.ruleForm.id){e.next=60;break}return e.next=58,this.$api.update("discussxinxifuwuliulan",this.ruleForm);case 58:e.next=62;break;case 60:return e.next=62,this.$api.add("discussxinxifuwuliulan",this.ruleForm);case 62:uni.setStorageSync("discussxinxifuwuliulanCleanType",!0),this.$utils.msgBack("提交成功");case 64:case"end":return e.stop()}}),e,this)})));function t(){return e.apply(this,arguments)}return t}(),optionsChange:function(e){this.index=e.target.value},bindDateChange:function(e){this.date=e.target.value},getDate:function(e){var t=new Date,r=t.getFullYear(),n=t.getMonth()+1,i=t.getDate();return"start"===e?r-=60:"end"===e&&(r+=2),n=n>9?n:"0"+n,i=i>9?i:"0"+i,"".concat(r,"-").concat(n,"-").concat(i)},toggleTab:function(e){if(this.ro[e])return!1;this.$refs[e].show()}}};t.default=o},"99d7":function(e,t,r){"use strict";r.r(t);var n=r("69af"),i=r.n(n);for(var a in n)"default"!==a&&function(e){r.d(t,e,(function(){return n[e]}))}(a);t["default"]=i.a},e0bf:function(e,t,r){var n=r("24fb");t=n(!1),t.push([e.i,'@charset "UTF-8";\n/**\r\n * 这里是uni-app内置的常用样式变量\r\n *\r\n * uni-app 官方扩展插件及插件市场（https://ext.dcloud.net.cn）上很多三方插件均使用了这些样式变量\r\n * 如果你是插件开发者，建议你使用scss预处理，并在插件代码中直接使用这些变量（无需 import 这个文件），方便用户通过搭积木的方式开发整体风格一致的App\r\n *\r\n */\n/**\r\n * 如果你是App开发者（插件使用者），你可以通过修改这些变量来定制自己的插件主题，实现自定义主题功能\r\n *\r\n * 如果你的项目同样使用了scss预处理，你也可以直接在你的 scss 代码中使用如下变量，同时无需 import 这个文件\r\n */\n/* 颜色变量 */\n/* 行为相关颜色 */\n/* 文字基本颜色 */\n/* 背景颜色 */\n/* 边框颜色 */\n/* 尺寸变量 */\n/* 文字尺寸 */\n/* 图片尺寸 */\n/* Border Radius */\n/* 水平间距 */\n/* 垂直间距 */\n/* 透明度 */\n/* 文章场景相关 */.content[data-v-0a3fb0ec]{min-height:calc(100vh - 44px);box-sizing:border-box}',""]),e.exports=t},e2d2:function(e,t,r){"use strict";r.r(t);var n=r("f3a3"),i=r("99d7");for(var a in i)"default"!==a&&function(e){r.d(t,e,(function(){return i[e]}))}(a);r("e2dd");var u,s=r("f0c5"),o=Object(s["a"])(i["default"],n["b"],n["c"],!1,null,"0a3fb0ec",null,!1,n["a"],u);t["default"]=o.exports},e2dd:function(e,t,r){"use strict";var n=r("fb97"),i=r.n(n);i.a},f3a3:function(e,t,r){"use strict";var n={"xia-editor":r("064f").default},i=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("v-uni-view",{staticClass:"content"},[r("v-uni-view",{style:{width:"100%",padding:"0",position:"relative",background:"#fff",height:"100%"}},[r("v-uni-form",{staticClass:"app-update-pv",style:{width:"100%",padding:"24rpx",background:"#fff",display:"block",height:"auto"}},[r("v-uni-view",{style:{padding:"20rpx",margin:"0 0 24rpx 0",borderColor:"#ccc",borderRadius:"30rpx 60rpx 60rpx 0",borderWidth:"0 0 2rpx 0",background:"#F0F3FC",display:"flex",width:"100%",borderStyle:"solid",height:"auto"}},[r("v-uni-view",{staticClass:"title",style:{width:"160rpx",lineHeight:"80rpx",fontSize:"28rpx",color:"#9e9e9e",textAlign:"center",fontWeight:"500"}},[e._v("评论内容")]),r("xia-editor",{ref:"editor",style:{minHeight:"300rpx",border:"2rpx solid #efefef",padding:"12rpx",borderRadius:"10rpx",background:"#fff",width:"calc(100% - 160rpx)",height:"auto"},attrs:{placeholder:"评论内容"},on:{editorChange:function(t){arguments[0]=t=e.$handleEvent(t),e.contentChange.apply(void 0,arguments)}},model:{value:e.ruleForm.content,callback:function(t){e.$set(e.ruleForm,"content",t)},expression:"ruleForm.content"}})],1),r("v-uni-view",{staticClass:"btn",style:{width:"100%",flexWrap:"wrap",justifyContent:"center",display:"flex",height:"auto"}},[r("v-uni-button",{staticClass:"bg-red",style:{border:"0",padding:"0px",margin:"0 0 20rpx",color:"rgb(255, 255, 255)",borderRadius:"60rpx",background:"#FFBC1D",width:"100%",lineHeight:"80rpx",fontSize:"40rpx",height:"80rpx"},on:{click:function(t){arguments[0]=t=e.$handleEvent(t),e.onSubmitTap.apply(void 0,arguments)}}},[e._v("提交")])],1)],1)],1)],1)},a=[];r.d(t,"b",(function(){return i})),r.d(t,"c",(function(){return a})),r.d(t,"a",(function(){return n}))},fb97:function(e,t,r){var n=r("e0bf");"string"===typeof n&&(n=[[e.i,n,""]]),n.locals&&(e.exports=n.locals);var i=r("4f06").default;i("085dfa0e",n,!0,{sourceMap:!1,shadowMode:!1})}}]);