(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-quyu-detail"],{"44cc":function(t,e,n){"use strict";n.r(e);var i=n("7a3a"),a=n.n(i);for(var r in i)"default"!==r&&function(t){n.d(e,t,(function(){return i[t]}))}(r);e["default"]=a.a},"4d02":function(t,e,n){"use strict";var i=n("8268"),a=n.n(i);a.a},"579b":function(t,e,n){"use strict";var i={"mescroll-uni":n("f05e").default},a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("v-uni-view",[n("mescroll-uni",{attrs:{up:t.upOption,down:t.downOption},on:{init:function(e){arguments[0]=e=t.$handleEvent(e),t.mescrollInit.apply(void 0,arguments)},down:function(e){arguments[0]=e=t.$handleEvent(e),t.downCallback.apply(void 0,arguments)},up:function(e){arguments[0]=e=t.$handleEvent(e),t.upCallback.apply(void 0,arguments)}}},[n("v-uni-view",{staticClass:"content"},[n("v-uni-view",{staticClass:"container",style:{width:"100%",padding:"0",position:"relative",background:"#fff",height:"100%"}},[n("v-uni-view",{staticClass:"detail-content",style:{padding:"24rpx",boxShadow:"0 8rpx 20rpx rgba(0,0,0,.3)",margin:"20rpx auto",borderRadius:"20rpx",flexWrap:"wrap",background:"#fff",display:"flex",width:"calc(100% - 40rpx)",height:"auto"}},[n("v-uni-view",{staticClass:"detail-list-item",style:{margin:"0 0 24rpx 0",borderColor:"#D8D8D8",borderWidth:"0 0 2rpx 0",display:"flex",width:"100%",borderStyle:"solid",height:"auto"}},[n("v-uni-view",{staticClass:"lable",style:{width:"auto",padding:"0 20rpx 0 0",lineHeight:"80rpx",fontSize:"28rpx",color:"#000",textAlign:"right"}},[t._v("区域：")]),n("v-uni-view",{staticClass:"text",style:{padding:"0px",margin:"0px",lineHeight:"80rpx",fontSize:"28rpx",color:"rgb(0, 0, 0)"}},[t._v(t._s(t.detail.quyu))])],1),n("v-uni-view",{staticClass:"bottom-content bg-white tabbar border shop",style:{width:"100%",padding:"10rpx 24rpx",flexWrap:"wrap",background:"none",display:"flex",height:"auto"}},[t.userid&&t.isAuth("quyu","私聊")?n("v-uni-button",{style:{border:"0",padding:"0 20rpx",margin:"0 10rpx 10rpx",color:"rgb(255, 255, 255)",borderRadius:"10rpx",background:"rgb(255, 170, 51)",width:"calc(100% / 3 - 20rpx)",fontSize:"26rpx",height:"80rpx"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.chatClick.apply(void 0,arguments)}}},[t._v("联系TA")]):t._e(),!t.userid&&t.isAuthFront("quyu","私聊")?n("v-uni-button",{style:{border:"0",padding:"0 20rpx",margin:"0 10rpx 10rpx",color:"rgb(255, 255, 255)",borderRadius:"10rpx",background:"rgb(255, 170, 51)",width:"calc(100% / 3 - 20rpx)",fontSize:"26rpx",height:"80rpx"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.chatClick.apply(void 0,arguments)}}},[t._v("联系TA")]):t._e()],1)],1)],1)],1)],1)],1)},r=[];n.d(e,"b",(function(){return a})),n.d(e,"c",(function(){return r})),n.d(e,"a",(function(){return i}))},"7a3a":function(t,e,n){"use strict";var i=n("4ea4");Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0,n("a481"),n("ac6a"),n("f559"),n("55dd"),n("96cf");var a=i(n("3b8d")),r={data:function(){return{btnColor:["#409eff","#67c23a","#909399","#e6a23c","#f56c6c","#356c6c","#351c6c","#f093a9","#a7c23a","#104eff","#10441f","#a21233","#503319"],id:"",userid:"",detail:{},swiperList:[],commentList:[],mescroll:null,downOption:{auto:!1},upOption:{noMoreSize:3,textNoMore:"~ 没有更多了 ~"},hasNext:!0,user:{},count:0,timer:null,title:""}},components:{},computed:{baseUrl:function(){return this.$base.url}},onLoad:function(){var t=(0,a.default)(regeneratorRuntime.mark((function t(e){var n,i;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return n=uni.getStorageSync("nowTable"),t.next=3,this.$api.session(n);case 3:i=t.sent,this.user=i.data,this.id=e.id,e.userid&&(this.userid=e.userid),this.init();case 8:case"end":return t.stop()}}),t,this)})));function e(e){return t.apply(this,arguments)}return e}(),onUnload:function(){this.timer&&clearInterval(this.timer)},onShow:function(){var t=(0,a.default)(regeneratorRuntime.mark((function t(e){var n,i,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return n=uni.getStorageSync("nowTable"),t.next=3,this.$api.session(n);case 3:if(i=t.sent,this.user=i.data,this.btnColor=this.btnColor.sort((function(){return.5-Math.random()})),a=uni.getStorageSync("crossCleanType"),!a){t.next=13;break}return uni.removeStorageSync("crossCleanType"),t.next=11,this.$api.info("quyu",this.id);case 11:i=t.sent,this.detail=i.data;case 13:case"end":return t.stop()}}),t,this)})));function e(e){return t.apply(this,arguments)}return e}(),destroyed:function(){},methods:{callClick:function(t){uni.makePhoneCall({phoneNumber:t})},onPayTap:function(){var t=this;if(!this.user)return this.$utils.msg("请先登录"),setTimeout((function(){t.$utils.jump("../login/login")}),1500),!1;uni.setStorageSync("paytable","quyu"),uni.setStorageSync("payObject",this.detail),this.$utils.jump("../pay-confirm/pay-confirm?type=1")},onDetailTap:function(t){uni.setStorageSync("useridTag",this.userid),this.$utils.jump("./detail?id=".concat(t.id,"&userid=")+this.userid)},onAcrossTap:function(){var t=(0,a.default)(regeneratorRuntime.mark((function t(e,n,i,a,r,s){var o,u,c,l=arguments;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(l.length>6&&void 0!==l[6]?l[6]:1,o=this,this.user){t.next=6;break}return this.$utils.msg("请先登录"),setTimeout((function(){o.$utils.jump("../login/login")}),1500),t.abrupt("return",!1);case 6:if(uni.setStorageSync("crossTable","quyu"),uni.setStorageSync("crossObj",this.detail),uni.setStorageSync("statusColumnName",a),uni.setStorageSync("statusColumnValue",s),uni.setStorageSync("tips",r),""==a||a.startsWith("[")){t.next=21;break}u=uni.getStorageSync("crossObj"),t.t0=regeneratorRuntime.keys(u);case 14:if((t.t1=t.t0()).done){t.next=21;break}if(c=t.t1.value,c!=a||u[c]!=s){t.next=19;break}return this.$utils.msg(r),t.abrupt("return");case 19:t.next=14;break;case 21:this.$utils.jump("../".concat(e,"/add-or-update?cross=true"));case 22:case"end":return t.stop()}}),t,this)})));function e(e,n,i,a,r,s){return t.apply(this,arguments)}return e}(),init:function(){var t=(0,a.default)(regeneratorRuntime.mark((function t(){var e,n,i=arguments;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return e=i.length>0&&void 0!==i[0]?i[0]:1,this.timer&&clearInterval(this.timer),t.next=4,this.$api.info("quyu",this.id);case 4:if(n=t.sent,this.detail=n.data,2!=e){t.next=10;break}return this.detail.discussnum++,t.next=10,this.$api.update("quyu",this.detail);case 10:case"end":return t.stop()}}),t,this)})));function e(){return t.apply(this,arguments)}return e}(),mescrollInit:function(t){this.mescroll=t},downCallback:function(t){this.hasNext=!0,t.resetUpScroll()},upCallback:function(){var t=(0,a.default)(regeneratorRuntime.mark((function t(e){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:e.endSuccess(e.size,this.hasNext);case 1:case"end":return t.stop()}}),t,this)})));function e(e){return t.apply(this,arguments)}return e}(),onChatTap:function(){this.$utils.jump("../chat/chat")},download:function(t){var e=this;uni.downloadFile({url:e.$base.url+"file/download?fileName="+t.replace("upload/",""),success:function(n){200===n.statusCode&&(e.$utils.msg("下载成功"),window.open(t))}})},onCartTabTap:function(){this.$utils.tab("../shop-cart/shop-cart")}}};e.default=r},"7e9e":function(t,e,n){var i=n("24fb");e=i(!1),e.push([t.i,'@charset "UTF-8";\n/**\r\n * 这里是uni-app内置的常用样式变量\r\n *\r\n * uni-app 官方扩展插件及插件市场（https://ext.dcloud.net.cn）上很多三方插件均使用了这些样式变量\r\n * 如果你是插件开发者，建议你使用scss预处理，并在插件代码中直接使用这些变量（无需 import 这个文件），方便用户通过搭积木的方式开发整体风格一致的App\r\n *\r\n */\n/**\r\n * 如果你是App开发者（插件使用者），你可以通过修改这些变量来定制自己的插件主题，实现自定义主题功能\r\n *\r\n * 如果你的项目同样使用了scss预处理，你也可以直接在你的 scss 代码中使用如下变量，同时无需 import 这个文件\r\n */\n/* 颜色变量 */\n/* 行为相关颜色 */\n/* 文字基本颜色 */\n/* 背景颜色 */\n/* 边框颜色 */\n/* 尺寸变量 */\n/* 文字尺寸 */\n/* 图片尺寸 */\n/* Border Radius */\n/* 水平间距 */\n/* 垂直间距 */\n/* 透明度 */\n/* 文章场景相关 */uni-page-body[data-v-9a9db806]{--animate-duration:1s;--animate-delay:1s;--animate-repeat:1}.content[data-v-9a9db806]{min-height:calc(100vh - 44px);box-sizing:border-box}.seat-list[data-v-9a9db806]{display:-webkit-box;display:-webkit-flex;display:flex;-webkit-box-align:center;-webkit-align-items:center;align-items:center;-webkit-flex-wrap:wrap;flex-wrap:wrap;background:#fff;margin:%?20?%;border-radius:%?20?%;padding:%?20?%;font-size:%?30?%}.seat-list .seat-item[data-v-9a9db806]{width:33.33%;display:-webkit-box;display:-webkit-flex;display:flex;-webkit-box-align:center;-webkit-align-items:center;align-items:center;-webkit-box-orient:vertical;-webkit-box-direction:normal;-webkit-flex-direction:column;flex-direction:column;margin-bottom:%?20?%}.seat-list .seat-item .seat-icon[data-v-9a9db806]{width:%?50?%;height:%?50?%;margin-bottom:%?10?%}uni-audio[data-v-9a9db806]{display:-webkit-box;display:-webkit-flex;display:flex;-webkit-box-orient:vertical;-webkit-box-direction:normal;-webkit-flex-direction:column;flex-direction:column}.audio[data-v-9a9db806] .uni-audio-default{width:inherit}',""]),t.exports=e},8268:function(t,e,n){var i=n("7e9e");"string"===typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);var a=n("4f06").default;a("34896ed4",i,!0,{sourceMap:!1,shadowMode:!1})},e595:function(t,e,n){"use strict";n.r(e);var i=n("579b"),a=n("44cc");for(var r in a)"default"!==r&&function(t){n.d(e,t,(function(){return a[t]}))}(r);n("4d02");var s,o=n("f0c5"),u=Object(o["a"])(a["default"],i["b"],i["c"],!1,null,"9a9db806",null,!1,i["a"],s);e["default"]=u.exports}}]);