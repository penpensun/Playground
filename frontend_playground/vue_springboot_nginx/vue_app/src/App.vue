<template>
  <div id="app">
    <img src="./assets/logo.png">
    <router-view></router-view>
    <div>Check is logged in: {{isLoggedIn}}</div>
    <button @click="getIsLogin">is logged in?</button>
  </div>
</template>

<script>
export default {
  name: 'App',
  data: function () {
    return {
      isLoggedIn: false
    }
  },
  mounted: function () {
    setInterval(() => {
      this.checkIsLogin()
    }, 1000 * 60)
  },
  methods: {
    checkIsLogin () {
      this.$axios.get('rest/login_status', response => {
        console.log(response.data)
        if (typeof response === 'undefined') { // If response is undefined.
          window.location.replace('#/login')
        } else if (!response.data.ok) { // If not logged in
          window.location.replace('#/login')
        } else { // if yes logged in
          window.location.replace('#/home')
        }
      })
    },
    getIsLogin () {
      this.$axios.get('rest/login_status', response => {
        console.log('inside getIsLogin')
        this.isLoggedIn = response.data.ok
        console.log(response.data)
      })
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
