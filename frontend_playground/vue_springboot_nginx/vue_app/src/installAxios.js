import axios from 'axios'

function addInterceptor () {
  axios.interceptors.request.use(config => {
    console.log('============= interceptors start ========')
    console.log(config.method + ' : ' + config.url)
    console.log(config)
    return config
  }, error => {
    return Promise.reject(error)
  })
  axios.interceptors.response.use(response => {
    console.log(response)
    console.log('============= interceptors end ============')
  })
}

export default function () {
  addInterceptor()
}
