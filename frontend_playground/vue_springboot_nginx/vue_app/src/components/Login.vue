<template>
<div>
  <title>Login Page </title>

  <span>Username: </span><input type="text" name="username" placeholder="Please enter your username" v-model="username"/> <br><br>
  <span>Password: </span><input type="password" name="password" v-model="password"/> <br><br>
  <button @click="login">Log in</button>

</div>
</template>
<script>
export default {
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
      })
    }
  }
}
</script>
