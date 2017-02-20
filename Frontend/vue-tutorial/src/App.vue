<template>
  <!--<div id="app">-->
    <!--<img src="./assets/logo.png">-->
    <!--<hello></hello>-->
  <!--</div>-->
  <div id="wrapper">
    <nav class="navbar navbar-default">
      <div class="container">
        <a>
           <i class="glyphicon glyhicon-time">
             计划板
           </i>
        </a>
        <ul class="nav navbar-nav">
          <li><router-link to="/home">首页</router-link></li>
          <li><router-link to="/time-entries">计划列表</router-link></li>
        </ul>
      </div>
    </nav>
    <div class="container">
      <div class="col-sm-3">

      </div>
      <div class="cols-sm-9">
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>


<script>
import Hello from './components/Hello'

export default {
  name: 'app',
  components: {
    Hello
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
