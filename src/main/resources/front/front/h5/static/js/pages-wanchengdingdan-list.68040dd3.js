(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-wanchengdingdan-list"],{"0d87":function(t,e,i){"use strict";var n=i("4ea4");Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0,i("c5f6"),i("386d"),i("55dd"),i("96cf");var r=n(i("3b8d")),a={data:function(){return{btnColor:["#409eff","#67c23a","#909399","#e6a23c","#f56c6c","#356c6c","#351c6c","#f093a9","#a7c23a","#104eff","#10441f","#a21233","#503319"],queryList:[{queryName:"物品名称"}],queryIndex:0,list:[],lists:[],userid:"",mescroll:null,downOption:{auto:!1},upOption:{noMoreSize:5,textNoMore:"~ 没有更多了 ~"},hasNext:!0,searchForm:{},CustomBar:"0",listSort:"id",listOrder:"desc"}},watch:{},mounted:function(){},computed:{baseUrl:function(){return this.$base.url}},onShow:function(){var t=(0,r.default)(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:this.btnColor=this.btnColor.sort((function(){return.5-Math.random()})),this.hasNext=!0,this.mescroll&&this.mescroll.resetUpScroll();case 3:case"end":return t.stop()}}),t,this)})));function e(){return t.apply(this,arguments)}return e}(),onLoad:function(t){t.userid?this.userid=t.userid:this.userid="",this.hasNext=!0,this.mescroll&&this.mescroll.resetUpScroll()},components:{},methods:{uGetRect:function(t,e){var i=this;return new Promise((function(n){uni.createSelectorQuery().in(i)[e?"selectAll":"select"](t).boundingClientRect((function(t){e&&Array.isArray(t)&&t.length&&n(t),!e&&t&&n(t)})).exec()}))},cloneData:function(t){return JSON.parse(JSON.stringify(t))},sortClick:function(t){this.listSort==t?"desc"==this.listOrder?this.listOrder="asc":this.listOrder="desc":(this.listSort=t,this.listOrder="desc"),this.search()},priceChange:function(t){return Number(t).toFixed(2)},preHttp:function(t){return t&&"http"==t.substr(0,4)},queryChange:function(t){this.queryIndex=t.detail.value,this.searchForm.wupinmingcheng=""},mescrollInit:function(t){this.mescroll=t},downCallback:function(t){this.hasNext=!0,t.resetUpScroll()},upCallback:function(){var t=(0,r.default)(regeneratorRuntime.mark((function t(e){var i,n,r,a,s;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(i={page:e.num,limit:e.size},i["sort"]=this.listSort,i["order"]=this.listOrder,this.searchForm.wupinmingcheng&&(i["wupinmingcheng"]="%"+this.searchForm.wupinmingcheng+"%"),uni.getStorageSync("appUserid")?JSON.parse(uni.getStorageSync("userSession")):{},n={},!this.userid){t.next=12;break}return t.next=9,this.$api.page("wanchengdingdan",i);case 9:n=t.sent,t.next=15;break;case 12:return t.next=14,this.$api.list("wanchengdingdan",i);case 14:n=t.sent;case 15:for(1==e.num&&(this.list=[]),this.list=this.list.concat(n.data.list),this.$forceUpdate(),r=Math.ceil(this.list.length/6),a=[],s=0;s<r;s++)a[s]=this.list.slice(6*s,6*(s+1));this.lists=a,0==n.data.list.length&&(this.hasNext=!1),e.endSuccess(e.size,this.hasNext);case 24:case"end":return t.stop()}}),t,this)})));function e(e){return t.apply(this,arguments)}return e}(),onDetailTap:function(t){uni.setStorageSync("useridTag",this.userid),this.$utils.jump("./detail?id=".concat(t.id,"&userid=")+this.userid)},onUpdate:function(t){this.onUpdateTap(t.currentTarget.dataset.row)},onUpdateTap:function(t){uni.setStorageSync("useridTag",this.userid),this.$utils.jump("./add-or-update?id=".concat(t.id))},onAddTap:function(){uni.setStorageSync("useridTag",this.userid),this.$utils.jump("./add-or-update")},onDelete:function(t){this.onDeleteTap(t.currentTarget.dataset.row.id)},onDeleteTap:function(t){var e=this;uni.showModal({title:"提示",content:"是否确认删除",success:function(){var i=(0,r.default)(regeneratorRuntime.mark((function i(n){return regeneratorRuntime.wrap((function(i){while(1)switch(i.prev=i.next){case 0:if(!n.confirm){i.next=6;break}return i.next=3,e.$api.del("wanchengdingdan",JSON.stringify([t]));case 3:e.$utils.msg("删除成功"),e.hasNext=!0,e.search();case 6:case"end":return i.stop()}}),i)})));function n(t){return i.apply(this,arguments)}return n}()})},search:function(){var t=(0,r.default)(regeneratorRuntime.mark((function t(){var e,i,n,r,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(this.mescroll.num=1,e={page:this.mescroll.num,limit:this.mescroll.size},e["sort"]=this.listSort,e["order"]=this.listOrder,this.searchForm.wupinmingcheng&&(e["wupinmingcheng"]="%"+this.searchForm.wupinmingcheng+"%"),i={},!this.userid){t.next=12;break}return t.next=9,this.$api.page("wanchengdingdan",e);case 9:i=t.sent,t.next=15;break;case 12:return t.next=14,this.$api.list("wanchengdingdan",e);case 14:i=t.sent;case 15:for(1==this.mescroll.num&&(this.list=[]),this.list=this.list.concat(i.data.list),n=Math.ceil(this.list.length/6),r=[],a=0;a<n;a++)r[a]=this.list.slice(6*a,6*(a+1));this.lists=r,0==i.data.list.length&&(this.hasNext=!1),this.mescroll.endSuccess(this.mescroll.size,this.hasNext);case 23:case"end":return t.stop()}}),t,this)})));function e(){return t.apply(this,arguments)}return e}()}};e.default=a},"2b98":function(t,e,i){"use strict";var n=i("f13d"),r=i.n(n);r.a},"943f":function(t,e,i){"use strict";i.r(e);var n=i("0d87"),r=i.n(n);for(var a in n)"default"!==a&&function(t){i.d(e,t,(function(){return n[t]}))}(a);e["default"]=r.a},b2bf:function(t,e,i){var n=i("24fb");e=n(!1),e.push([t.i,'@charset "UTF-8";\n/**\r\n * 这里是uni-app内置的常用样式变量\r\n *\r\n * uni-app 官方扩展插件及插件市场（https://ext.dcloud.net.cn）上很多三方插件均使用了这些样式变量\r\n * 如果你是插件开发者，建议你使用scss预处理，并在插件代码中直接使用这些变量（无需 import 这个文件），方便用户通过搭积木的方式开发整体风格一致的App\r\n *\r\n */\n/**\r\n * 如果你是App开发者（插件使用者），你可以通过修改这些变量来定制自己的插件主题，实现自定义主题功能\r\n *\r\n * 如果你的项目同样使用了scss预处理，你也可以直接在你的 scss 代码中使用如下变量，同时无需 import 这个文件\r\n */\n/* 颜色变量 */\n/* 行为相关颜色 */\n/* 文字基本颜色 */\n/* 背景颜色 */\n/* 边框颜色 */\n/* 尺寸变量 */\n/* 文字尺寸 */\n/* 图片尺寸 */\n/* Border Radius */\n/* 水平间距 */\n/* 垂直间距 */\n/* 透明度 */\n/* 文章场景相关 */.content[data-v-d4ab15f0]{min-height:calc(100vh - 44px);box-sizing:border-box}.category-one .tab[data-v-d4ab15f0]{cursor:pointer;border-radius:%?40?%;padding:0 %?20?%;margin:0 %?20?%;color:#959595;background:#f2f2f2;display:inline-block;width:auto;font-size:%?28?%;line-height:%?60?%}.category-one .tab.active[data-v-d4ab15f0]{cursor:pointer;border-radius:%?40?%;padding:0 %?20?%;margin:0 %?20?%;color:#fff;background:#ffbc1d;display:inline-block;width:auto;font-size:%?28?%;line-height:%?60?%}.category-two .tab[data-v-d4ab15f0]{cursor:pointer;padding:0;color:#fff;background:#00f;display:inline-block;width:100%;font-size:%?28?%;line-height:%?80?%;text-align:center}.category-two .tab.active[data-v-d4ab15f0]{cursor:pointer;padding:0;color:#fff;background:#000;display:inline-block;width:100%;font-size:%?28?%;line-height:%?80?%;text-align:center}.category-three .tab[data-v-d4ab15f0]{cursor:pointer;padding:0;color:#fff;background:#deb887;display:inline-block;width:100%;font-size:%?28?%;line-height:%?80?%;text-align:center}.category-three .tab.active[data-v-d4ab15f0]{cursor:pointer;padding:0;color:#fff;background:#000;display:inline-block;width:100%;font-size:%?28?%;line-height:%?80?%;text-align:center}',""]),t.exports=e},d6f0:function(t,e,i){"use strict";i.r(e);var n=i("d8e1"),r=i("943f");for(var a in r)"default"!==a&&function(t){i.d(e,t,(function(){return r[t]}))}(a);i("2b98");var s,o=i("f0c5"),l=Object(o["a"])(r["default"],n["b"],n["c"],!1,null,"d4ab15f0",null,!1,n["a"],s);e["default"]=l.exports},d8e1:function(t,e,i){"use strict";var n={"mescroll-uni":i("f05e").default},r=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("mescroll-uni",{attrs:{up:t.upOption,down:t.downOption},on:{init:function(e){arguments[0]=e=t.$handleEvent(e),t.mescrollInit.apply(void 0,arguments)},down:function(e){arguments[0]=e=t.$handleEvent(e),t.downCallback.apply(void 0,arguments)},up:function(e){arguments[0]=e=t.$handleEvent(e),t.upCallback.apply(void 0,arguments)}}},[i("v-uni-view",{staticClass:"content"},[i("v-uni-view",{style:{width:"100%",padding:"0",position:"relative",background:"#fff",height:"100%"}},[i("v-uni-view",{staticClass:"cu-bar bg-white search",style:{width:"100%",padding:"20rpx 24rpx",background:"#fff",display:"flex",height:"auto"}},[t.queryList.length>1?i("v-uni-picker",{attrs:{mode:"selector",range:t.queryList,"range-key":"queryName",value:t.queryIndex},on:{change:function(e){arguments[0]=e=t.$handleEvent(e),t.queryChange.apply(void 0,arguments)}}},[i("v-uni-view",{style:{width:"40rpx",height:"auto"}},[i("v-uni-text",{staticClass:"icon iconfont icon-jiantou18",style:{width:"40rpx",fontSize:"40rpx",lineHeight:"80rpx",color:"#A1A1A1"}})],1)],1):t._e(),0==t.queryIndex?i("v-uni-view",{staticClass:"search-form round",style:{margin:"0 12rpx",flex:"1",position:"relative"}},[i("v-uni-text",{staticClass:"icon iconfont icon-fangdajing07",style:{color:"#A1A1A1",left:"0px",textAlign:"center",width:"80rpx",fontSize:"40rpx",lineHeight:"80rpx",position:"absolute",right:"0px"}}),i("v-uni-input",{style:{border:"2rpx solid #A1A1A1",padding:"12rpx 20rpx 12rpx 80rpx",color:"#000",borderRadius:"10rpx",background:"#fff",width:"100%",lineHeight:"56rpx",fontSize:"28rpx",height:"80rpx"},attrs:{type:"text",placeholder:"物品名称"},model:{value:t.searchForm.wupinmingcheng,callback:function(e){t.$set(t.searchForm,"wupinmingcheng",e)},expression:"searchForm.wupinmingcheng"}})],1):t._e(),i("v-uni-button",{staticClass:"cu-btn shadow-blur round",style:{border:"0",padding:"0px",margin:"0 0 0 -40rpx",color:"#fff",borderRadius:"10rpx",background:"#FFBC1D",width:"136rpx",lineHeight:"80rpx",fontSize:"28rpx",height:"80rpx",zIndex:"1"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.search.apply(void 0,arguments)}}},[t._v("搜索")])],1),i("v-uni-view",{style:{padding:"0px 20rpx",margin:"0 0 20rpx",flexWrap:"wrap",background:"linear-gradient(90deg, #FFF6E0 0%, rgba(255,253,248,0.81) 100%)",justifyContent:"space-between",display:"flex"}},[i("v-uni-view",{style:{border:"0",padding:"0 12rpx",margin:"0 8rpx 0 0",outline:"0",borderRadius:"0",background:"none",display:"flex",width:"30%",justifyContent:"center"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.sortClick("addtime")}}},[i("v-uni-text",{style:{margin:"0 8rpx 0 0",lineHeight:"60rpx",fontSize:"24rpx",color:"#333"}},[t._v("按日期")]),"addtime"!=t.listSort?i("v-uni-text",{staticClass:"icon iconfont icon-liulan12",style:{margin:"0 4rpx 0 0",lineHeight:"60rpx",fontSize:"24rpx",color:"#333"}}):"addtime"==t.listSort&&"asc"==t.listOrder?i("v-uni-text",{staticClass:"icon iconfont icon-jiantou28",style:{margin:"0 4rpx 0 0",lineHeight:"60rpx",fontSize:"24rpx",color:"#333"}}):"addtime"==t.listSort&&"desc"==t.listOrder?i("v-uni-text",{staticClass:"icon iconfont icon-jiantou32",style:{margin:"0 4rpx 0 0",lineHeight:"60rpx",fontSize:"24rpx",color:"#333"}}):t._e()],1)],1),i("v-uni-view",{style:{width:"100%",background:"#fff",height:"auto"}},[i("v-uni-view",{staticClass:"list",style:{width:"100%",padding:"24rpx",margin:"0",height:"auto"}},t._l(t.list,(function(e,n){return i("v-uni-view",{key:n,staticClass:"listm flex flex-between",style:{boxShadow:"0 2rpx 12rpx rgba(0,0,0,.3)",padding:"20rpx 0 20rpx 20rpx",margin:"0 0 20rpx",overflow:"hidden",borderRadius:"10rpx",flexWrap:"wrap",flexDirection:"column",display:"flex",width:"100%",height:"340rpx"},on:{click:function(i){arguments[0]=i=t.$handleEvent(i),t.onDetailTap(e)}}},[t.preHttp(e.zhaopian)?i("v-uni-image",{staticClass:"listmpic",style:{width:"260rpx",objectFit:"cover",borderRadius:"10rpx",display:"block",height:"300rpx"},attrs:{mode:"aspectFill",src:e.zhaopian.split(",")[0]}}):i("v-uni-image",{staticClass:"listmpic",style:{width:"260rpx",objectFit:"cover",borderRadius:"10rpx",display:"block",height:"300rpx"},attrs:{mode:"aspectFill",src:e.zhaopian?t.baseUrl+e.zhaopian.split(",")[0]:""}}),i("v-uni-view",{staticClass:"listmr",style:{width:"calc(100% - 260rpx)",padding:"0 20rpx",margin:"0",flexWrap:"wrap",display:"flex",height:"auto"}},[i("v-uni-view",{staticClass:"col3 f30 elip mb15",style:{padding:"0 0 12rpx",margin:"0",whiteSpace:"nowrap",overflow:"hidden",color:"#000",width:"100%",lineHeight:"48rpx",fontSize:"28rpx",textOverflow:"ellipsis",order:"1"}},[t._v(t._s(e.wupinmingcheng))]),i("v-uni-view",{staticClass:"col3 f30 elip mb15",style:{padding:"0 0 12rpx",margin:"0",whiteSpace:"nowrap",overflow:"hidden",color:"#000",width:"100%",lineHeight:"48rpx",fontSize:"28rpx",textOverflow:"ellipsis",order:"1"}},[t._v(t._s(e.zhuangtai))]),i("v-uni-view",{staticClass:"col3 f30 elip mb15",style:{padding:"0 0 12rpx",margin:"0",whiteSpace:"nowrap",overflow:"hidden",color:"#000",width:"100%",lineHeight:"48rpx",fontSize:"28rpx",textOverflow:"ellipsis",order:"1"}},[t._v("本单收入:"+t._s(e.yue))]),i("v-uni-view",{style:{width:"100%",padding:"0 0",lineHeight:"48rpx",order:"2"}},[i("v-uni-text",{staticClass:"icon iconfont icon-shijian21",style:{margin:"0 4rpx 0 0",lineHeight:"1.5",fontSize:"24rpx",color:"#000"}}),i("v-uni-text",{style:{color:"#000",lineHeight:"1.5",fontSize:"24rpx"}},[t._v(t._s(e.addtime))])],1),i("v-uni-view",{style:{padding:"0",display:"inline-block",order:"6"}},[i("v-uni-text",{staticClass:"icon iconfont icon-geren16",style:{margin:"0 4rpx 0 0",lineHeight:"1.5",fontSize:"24rpx",color:"#000"}}),i("v-uni-text",{style:{color:"#000",lineHeight:"1.5",fontSize:"24rpx"}},[t._v(t._s(e.qishouzhanghao))])],1)],1),i("v-uni-view",{style:{width:"calc(100% - 260rpx)",padding:"20rpx",justifyContent:"space-between",display:"flex",height:"auto"}},[t.userid&&t.isAuth("wanchengdingdan","修改")||!t.userid&&t.isAuthFront("wanchengdingdan","修改")?i("v-uni-view",{style:{border:"2rpx solid #000",padding:"4rpx 20rpx",borderRadius:"40rpx",display:"flex"},on:{click:function(i){if(!i.type.indexOf("key")&&t._k(i.keyCode,"proevent",void 0,i.key,void 0))return null;i.stopPropagation(),arguments[0]=i=t.$handleEvent(i),t.onUpdateTap(e)}}},[i("v-uni-text",{staticClass:"cuIcon-edit",style:{margin:"0 8rpx 0 0",fontSize:"28rpx",lineHeight:"1",color:"#000",display:"inline-block"}}),i("v-uni-text",{style:{fontSize:"28rpx",lineHeight:"1",color:"#000",display:"inline-block"}},[t._v("修改")])],1):t._e(),t.userid&&t.isAuth("wanchengdingdan","删除")||!t.userid&&t.isAuthFront("wanchengdingdan","删除")?i("v-uni-view",{style:{border:"2rpx solid #000",padding:"4rpx 20rpx",borderRadius:"40rpx",display:"flex"},on:{click:function(i){if(!i.type.indexOf("key")&&t._k(i.keyCode,"proevent",void 0,i.key,void 0))return null;i.stopPropagation(),arguments[0]=i=t.$handleEvent(i),t.onDeleteTap(e.id)}}},[i("v-uni-text",{staticClass:"cuIcon-delete",style:{margin:"0 8rpx 0 0",fontSize:"28rpx",lineHeight:"1",color:"#000",display:"inline-block"}}),i("v-uni-text",{style:{fontSize:"28rpx",lineHeight:"1",color:"#000",display:"inline-block"}},[t._v("删除")])],1):t._e()],1)],1)})),1)],1)],1),t.userid&&t.isAuth("wanchengdingdan","新增")?i("v-uni-button",{staticClass:"add-btn",style:{border:"0",boxShadow:"0 2rpx 12rpx rgba(0,0,0,.3)",color:"rgb(255, 255, 255)",bottom:"40rpx",right:"8rpx",outline:"none",borderRadius:"100%",background:"rgb(255, 170, 51)",width:"80rpx",lineHeight:"80rpx",fontSize:"28rpx",position:"absolute",height:"80rpx",zIndex:"999"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.onAddTap()}}},[t._v("新增")]):t._e(),!t.userid&&t.isAuthFront("wanchengdingdan","新增")?i("v-uni-button",{staticClass:"add-btn",style:{border:"0",boxShadow:"0 2rpx 12rpx rgba(0,0,0,.3)",color:"rgb(255, 255, 255)",bottom:"40rpx",right:"8rpx",outline:"none",borderRadius:"100%",background:"rgb(255, 170, 51)",width:"80rpx",lineHeight:"80rpx",fontSize:"28rpx",position:"absolute",height:"80rpx",zIndex:"999"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.onAddTap()}}},[t._v("新增")]):t._e()],1)],1)},a=[];i.d(e,"b",(function(){return r})),i.d(e,"c",(function(){return a})),i.d(e,"a",(function(){return n}))},f13d:function(t,e,i){var n=i("b2bf");"string"===typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);var r=i("4f06").default;r("cfe3b574",n,!0,{sourceMap:!1,shadowMode:!1})}}]);