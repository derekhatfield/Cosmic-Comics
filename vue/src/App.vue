<template>
  <div id="app">
    <div id="nav">
      <div class="box"><router-link v-bind:to="{ name: 'home' }">Home</router-link></div>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <div class="box"><router-link v-bind:to="{ name: 'login' }" tag='p'>Login</router-link></div>
      <div class="box"><router-link v-bind:to="{ name: 'register' }" tag='p'>Join Now</router-link></div>
    </div>
    <router-view />
  </div>
</template>

<style>
  * {
    background-image: url("assets/CC Wallpaper.png");
  }
  #nav {
  color: white;
  background-image: none;
  flex-direction: row;
  display: flex;
  align-self: center;
  border: 3px solid lawngreen;
  height: 100px;
  padding: 2px;
}

    .box {
      border: 2px solid black;
      background-image: none;
      background-color: navy;
      border-radius: 10px;
      width: 100px;
      height: 20px;
      margin: 10px;
      padding: 2% 2% 2% 2%;
    }
    .box:nth-child(1) {
      margin-right: auto;
  
    }
</style>
