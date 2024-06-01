import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from "@/layout";
import Login from "@/views/Login.vue";

Vue.use(VueRouter)

const routes = [
  {
    path:'/',
    name:'Login',
    component: Login
  },
  {
    path: '/',//根目录路由为/
    component: Layout,//指定使用Layout组件布局
    redirect: '/home',//重定向至/home页面
    children: [{//子菜单信息
      path: '/home',//路径
      name: 'home',
      component: () => import('../views/HomeView.vue')//指定组件
    }]
  },
  {
    path: '/login',//根目录路由为/
    name: 'login',
    component: () => import('../views/Login.vue')//指定组件
  }
  // {
  //   path: '/register',//根目录路由为/
  //   name: 'register',
  //   component: () => import('../views/RegisterView.vue')//指定组件
  // }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
