import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from "@/layout";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',//根目录路由为/
    component: Layout,//指定使用Layout组件布局
    redirect: '/home',//重定向至/home页面
    children: [{//子菜单信息
      path: '/home',//路径
      name: 'home',
      component: () => import('../views/HomeView.vue')//指定组件
    }]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
