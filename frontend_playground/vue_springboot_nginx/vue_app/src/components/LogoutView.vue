<template>
  <div id="logout">
    <span><h2> You are successfully logged out, will be redirected to <router-link to="/login"></router-link> in <b>{{redirectToLogin}}</b> seconds</h2></span>
  </div>
</template>
<script>
export default {
  name: 'Logout',
  data: function () {
    return {
      redirectToLogin: 5
    }
  },
  mounted: function () {
    this.redirectToLogin = 5
    let redirectCountdown = setInterval(() => {
      this.redirectToLogin = this.redirectToLogin - 1
      if (this.redirectToLogin === 0) {
        clearInterval(redirectCountdown)
        window.location.replace('#/login')
      }
    }, 1000)
  }
}
</script>
