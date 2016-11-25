import Vue from 'vue'
import App from './App'
import Hello from './components/Hello.vue'

import VueRouter from 'vue-loader'
import VueResource from 'vue-resource'

/* eslint-disable no-new */
new Vue({
  el: '#app',
  template: '<App/>',
  components: { App }
})

//注册两个插件
Vue.use(VueResource)
Vue.use(VueRouter)

const router = new VueRouter()

//路由map
router.map({
  '/hello':{
    component: Hello
  }
})

router.redirect({
  '*':'/hello'
})

router.start(App,'#app')


