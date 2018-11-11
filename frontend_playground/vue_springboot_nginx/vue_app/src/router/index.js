import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import TreeView from '@/components/TreeView.vue'
import Login from '@/components/Login.vue'
import Index from '@/components/Index.vue'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/home',
      component: TreeView
    },
    {
      path: '/login',
      component: Login
    },
    {
      path: '/index',
      component: Index
    }
  ]
})
