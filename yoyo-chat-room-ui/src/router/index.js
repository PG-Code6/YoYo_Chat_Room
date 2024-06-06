import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from "@/layout";

Vue.use(VueRouter)

const routes = [
    {
        path: '/login',//根目录路由为/
        name: 'login',
        component: () => import('../views/Login.vue')//指定组件
    },
    {
        path: '/',//根目录路由为/
        redirect: '/goodfriend',
        component: Layout,//指定使用Layout组件布局
        children: [
            {//子菜单信息
                path: '/goodfriend',//路径
                name: 'goodfriend',
                component: () => import('../views/GoodFriendView.vue'),//指定组件
                children: [
                    {
                        path: '/songoodfriend',
                        name: 'songoodfriend',
                        component: () => import('../views/SonGoodFriendView.vue')//指定组件
                    },
                    {
                        path: '/community',
                        name: 'community',
                        component: () => import('../views/CommunityView.vue')//指定组件
                    },
                    {
                        path: '/friendchat',
                        name: 'friendchat',
                        component: () => import('../views/FriendChatView.vue')//指定组件
                    }
                ]
            }
        ]
    }

]

// 防止连续点击多次路由报错
let routerPush = VueRouter.prototype.push;
let routerReplace = VueRouter.prototype.replace;
// push
VueRouter.prototype.push = function push(location) {
    return routerPush.call(this, location).catch(err => err)
}
// replace
VueRouter.prototype.replace = function push(location) {
    return routerReplace.call(this, location).catch(err => err)
}
//


const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})


router.beforeEach((to, from, next) => {
    let user = localStorage.getItem('user');
    if(!user && (from.name !== 'login')){
        if (to.name !== 'login' && !user) next({ name: 'login' })
        else next()
    }else {
        next()
    }
})


export default router
