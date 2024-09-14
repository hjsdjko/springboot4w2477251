import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import discussxinxifuwuliulan from '@/views/modules/discussxinxifuwuliulan/list'
    import news from '@/views/modules/news/list'
    import aboutus from '@/views/modules/aboutus/list'
    import qishou from '@/views/modules/qishou/list'
    import discussqishou from '@/views/modules/discussqishou/list'
    import fabudingdan from '@/views/modules/fabudingdan/list'
    import storeup from '@/views/modules/storeup/list'
    import fuwuleixing from '@/views/modules/fuwuleixing/list'
    import yijiedingdan from '@/views/modules/yijiedingdan/list'
    import paotuifuwu from '@/views/modules/paotuifuwu/list'
    import systemintro from '@/views/modules/systemintro/list'
    import quyu from '@/views/modules/quyu/list'
    import xinxifuwuliulan from '@/views/modules/xinxifuwuliulan/list'
    import yonghu from '@/views/modules/yonghu/list'
    import messages from '@/views/modules/messages/list'
    import wanchengdingdan from '@/views/modules/wanchengdingdan/list'
    import config from '@/views/modules/config/list'
    import wentifankui from '@/views/modules/wentifankui/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/discussxinxifuwuliulan',
        name: '信息服务浏览评论',
        component: discussxinxifuwuliulan
      }
      ,{
	path: '/news',
        name: '公告',
        component: news
      }
      ,{
	path: '/aboutus',
        name: '关于我们',
        component: aboutus
      }
      ,{
	path: '/qishou',
        name: '骑手',
        component: qishou
      }
      ,{
	path: '/discussqishou',
        name: '骑手评论',
        component: discussqishou
      }
      ,{
	path: '/fabudingdan',
        name: '发布订单',
        component: fabudingdan
      }
      ,{
	path: '/storeup',
        name: '我的收藏',
        component: storeup
      }
      ,{
	path: '/fuwuleixing',
        name: '服务类型',
        component: fuwuleixing
      }
      ,{
	path: '/yijiedingdan',
        name: '已接订单',
        component: yijiedingdan
      }
      ,{
	path: '/paotuifuwu',
        name: '跑腿服务',
        component: paotuifuwu
      }
      ,{
	path: '/systemintro',
        name: '系统简介',
        component: systemintro
      }
      ,{
	path: '/quyu',
        name: '区域',
        component: quyu
      }
      ,{
	path: '/xinxifuwuliulan',
        name: '信息服务浏览',
        component: xinxifuwuliulan
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/messages',
        name: '留言板管理',
        component: messages
      }
      ,{
	path: '/wanchengdingdan',
        name: '完成订单',
        component: wanchengdingdan
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/wentifankui',
        name: '问题反馈',
        component: wentifankui
      }
      ,{
	path: '/newstype',
        name: '公告分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
