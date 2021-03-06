// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import installAxios from './installAxios'

Vue.config.productionTip = false
Vue.prototype.$axios = axios
installAxios()

/* eslint-disable no-new */
console.log(router.routes)
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
  // render: h => h(App)
})
