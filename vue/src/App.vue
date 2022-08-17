<template>
  <div id="app">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Bangers"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Contrail One"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway"/>

    <div id="nav">
        <router-link v-bind:to="{ name: 'home' }">
          <img class="logo" src="@/assets/Cosmic Comics.png"/>
        </router-link>
      <div class="header-box">
        <router-link v-bind:to="{ name: 'home' }" tag="p">Home</router-link>
      </div>
      <div class="header-box" v-if="this.$store.state.token != ''">
        <router-link v-bind:to="{ name: 'logout' }"  v-on:click="setViewStatusLoggedIn()"  tag="p">Logout</router-link>
      </div>      
      <div class="header-box" v-if="this.$store.state.token == ''">
        <router-link v-bind:to="{ name: 'login' }"  v-on:click="setViewStatusLoggedOut()" tag="p">Login</router-link>
      </div>
      <div class="header-box" v-if="this.$store.state.token == ''">
        <router-link v-bind:to="{ name: 'register' }"  v-on:click="setViewStatusLoggedOut()" tag="p">Join Now</router-link>
      </div>
      
      <span v-if="this.$store.state.user.username"> Welcome,<br> {{ this.$store.state.user.username}} </span>
      
    </div>

    <router-view />

    <footer>
      <p>Data provided by Marvel. ⓒ 2022 Marvel</p>
    </footer>
  </div>
</template>

<script>

export default {
  name: "app",
  data() {
    return {
      isLoggedIn: false,
      isLoggedOut: true
    }
  },
  methods: {
    setViewStatusLoggedIn() {
      this.isLoggedIn = true;
      this.isLoggedOut = false;
    },
    setViewStatusLoggedOut() {
      this.isLoggedIn = false;
      this.isLoggedOut = true;
    }
  }
}

</script>



<style>

body { /* Thor Cursor */
  cursor: url(https://64.media.tumblr.com/9c3614e3a555d94e0547732afc46b5e6/a02dfc418c2b33f7-65/s100x200/77b98e48aff7c67333405a4e3dcbda2743446b12.png), auto
};

/* The WHITE BORDER IS BACKKKK but this thing below originally fixed it */
* {
  margin: 0;
  padding: 0;
  min-height: 100vh;
}

p {
  display: inline-block;
  vertical-align: middle;
  margin: 0;
  width: auto;
  padding: auto;
}
#app {
  background-image: url("assets/CC Wallpaper.png");
  background-attachment: scroll;
  background-size: 100%;
  min-height: 100vh;
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
  background-image: linear-gradient(navy, rgb(65, 65, 184), navy);
  background-color: navy;
  border-radius: 10px;
  margin: 10px;
  padding: 1.5% 1% 1.5% 1%;
  text-align: center;
  color: #5ecade;
  font-family: "Contrail One", "Raleway", "Franklin Gothic Medium Extended";
  letter-spacing: 0.5px;
  word-spacing: 1px;
  font-weight: bold;
  font-size: 150%;
  justify-content: right;
  width: auto;
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
  margin-top: 30vmin;
  /*margin-bottom: auto;
  margin-right: auto;
  margin-left: auto;*/
  background-image: none;
  position: relative;
}

.logo {
  width: 100%;
  height: 100%;
  margin: 7px;
  border: transparent;
}

span {
  margin: 10px 20px 10px 10px;
  line-height: 20px;
  text-align: center;

  border: 3px solid #4bd668;
  border-style: inset;
  background-image: linear-gradient(navy, rgb(65, 65, 184), navy);
  background-color: navy;
  border-radius: 10px;
  padding: 8px 3px 8px 3px;
  color: #5ecade;
  font-family: "Contrail One", "Raleway", "Franklin Gothic Medium Extended";
  letter-spacing: 0.5px;
  word-spacing: 1px;

  font-size: auto;
  justify-content: right;
  width: auto;
  block-size: fit-content;
  display: inline-block;
}
</style>
