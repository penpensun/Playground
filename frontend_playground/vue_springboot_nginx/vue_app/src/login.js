import Vue from 'vue'
import Login from './Login'
import router from './router'
/* eslint-disable no-new */
new Vue({
  el: '#login',
  router,
  components: {Login},
  template: '<Login/>'
})
