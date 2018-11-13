import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import TreeView from '@/components/TreeView.vue'
import LoginView from '@/components/LoginView.vue'
import Index from '@/components/Index.vue'
import LogoutView from '@/components/LogoutView.vue'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/home',
      component: TreeView
    },
    {
      path: '/index',
      component: Index
    },
    {
      path: '/login',
      component: LoginView
    },
    {
      path: '/',
      component: Index
    },
    {
      path: '/logout',
      component: LogoutView
    }
  ]
})
