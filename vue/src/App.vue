<template>
  <div id="app">
    <div id="nav">
      <div class="header-box">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>
      </div>
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''">Logout</router-link>
      <div class="header-box">
        <router-link v-bind:to="{ name: 'login' }" tag="p">Login</router-link>
      </div>
      <div class="header-box">
        <router-link v-bind:to="{ name: 'register' }" tag="p">Join Now</router-link>
      </div>
    </div>
    <router-view />
    <div class="navigation-container">
      <div class="nav-box">Collections</div>
      <div class="nav-box">Add a Comic</div>
      <div class="nav-box">Create a Collection</div>
      <div class="nav-box">
        <img src="/assets/Search Tool.png" alt="Search Tool" class="Search Tool Image" height="50px" width="50px"/>
      </div>
    </div>
    <!-- make the body go here -->
    <footer>
      <p>Data provided by Marvel. ⓒ 2014 Marvel</p>
    </footer>
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

.header-box {
  border: 2px solid black;
  background-image: none;
  background-color: navy;
  border-radius: 10px;
  width: 100px;
  height: 20px;
  margin: 10px;
  padding: 2% 2% 2% 2%;
}
.header-box:nth-child(1) {
  margin-right: auto;
}
.navigation-container {
  background-image: none;
  background-color: transparent;
  flex-direction: row;
  display: flex;
  align-self: center;
  justify-content: space-around;
  border: 3px solid lawngreen;
  height: 100px;
  padding: 2px;
}

.nav-box {
  border: 2px solid black;
  background-image: none;
  background-color: navy;
  color: white;
  text-align: center;
  vertical-align: middle;
  /* line-height: 90px; */
  font-size: 175%;
  border-radius: 10px;
  width: 20%;
  height: 50px;
  margin: 10px;
  padding: 2% 2% 2% 2%;
}
.nav-box:nth-child(4) {
  background-image: none;
  border: 2px solid black;
  border-radius: 10px;
  width: auto;
  height: auto;
  margin: 10px 10px 10px;
}

footer {
  width: 100%;
  color: white;
  text-align: center;
  position: fixed;
  bottom: 0;
}
</style>
