<template>
  <div id="login">
      <span>Username: </span><input type="text" name="username" placeholder="Please enter your username" v-model="username"/> <br><br>
      <span>Password: </span><input type="password" name="password" v-model="password"/> <br><br>
      <button @click="login">Log in</button> <button @click="testRedirect">Redirect</button>
  </div>
</template>
<script>
export default {
  name: 'Login',
  data: function () {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    login: function () {
      console.log('inside login function')
      let postObj = {
        method: 'post',
        baseUrl: '/',
        url: 'rest/login',
        params: {
          username: this.username,
          password: this.password
        }
      }

      this.$axios(postObj).then(response => {
        console.log('output the response')
        console.log(response)
        // window.location.replace('/index')
        if (response.data.ok) {
          window.location.replace('#/home')
        } else {
          window.location.replace('#/login')
        }
      })
    },
    testRedirect: function () {
      window.location.replace('#/home')
    }
  }
}
</script>
