<template>
  <div id="app">
    <!-- <div class="cursor">
      <link
      href="http://www.rw-designer.com/cursor-set/superheroes-marvel"/>
    </div> -->
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Bangers"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Contrail One"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Raleway"
    />
    <div id="nav">
        <router-link v-bind:to="{ name: 'home' }"
          ><img class="logo" src="@/assets/Cosmic Comics.png"
        /></router-link>
      <div class="header-box">
        <router-link v-bind:to="{ name: 'home' }" tag="p">Home</router-link>
      </div>
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
      <div class="header-box">
        <router-link v-bind:to="{ name: 'login' }" tag="p">Login</router-link>
      </div>
      <div class="header-box">
        <router-link v-bind:to="{ name: 'register' }" tag="p"
          >Join Now</router-link
        >
      </div>
    </div>
    <router-view />

    <footer>
      <p>Data provided by Marvel. ⓒ 2014 Marvel</p>
    </footer>
  </div>
</template>

<style>

/* .cursor {
  width: 200px;
  height: 200px;
  cursor: url(http://www.rw-designer.com/cursor-extern.php?id=118271), auto;
} */

* {
  margin: 0;
  padding: 0;
}

p {
  display: inline-block;
  vertical-align: middle;
  margin: 0 0 0 0;
  width: auto;
}
#app {
  background-image: url("assets/CC Wallpaper.png");
  background-attachment: scroll;
  background-size: cover;
}

#nav {
  color: white;
  background-image: none;
  flex-direction: row;
  display: flex;
  align-self: center;
  height: 100px;
  line-height: 0;
  padding: 2px;
}

.header-box {
  border: 3px solid #d890ff;
  border-style: inset;
  background-image: none;
  background-color: navy;
  border-radius: 10px;
  margin: 10px;
  padding: 2%;
  text-align: center;
  color: #5ecade;
  font-family: "Contrail One", "Raleway", "Franklin Gothic Medium Extended";
  letter-spacing: 0.5px;
  word-spacing: 1px;
  font-weight: bold;
  font-size: 150%;
  justify-content: right;
  width: fit-content;
  block-size: fit-content;
  display: inline-block;
}
.header-box:nth-child(2) {
  margin-left: auto;
}

footer {
  width: 100%;
  color: white;
  text-align: center;
  bottom: 0;
  margin: 0;
  margin-top: auto;
  margin-bottom: auto;
  margin-right: auto;
  margin-left: auto;
  background-image: none;
}

.logo {
  width: 100%;
  height: 100%;
}
</style>
