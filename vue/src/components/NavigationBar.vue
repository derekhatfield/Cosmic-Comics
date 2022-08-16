<template>
  <div class="navigation-container">
    <div class="nav-box">
      <router-link v-bind:to="{ name: 'comics' }" tag="p">Comics</router-link>
    </div>
    <div class="nav-box">
      <router-link v-bind:to="{ name: 'collections' }" tag="p"
        >Collections</router-link
      >
    </div>
    <div class="nav-box">
      <router-link v-bind:to="{ name: 'createACollection' }" tag="p"
        >Create A Collection</router-link
      >

      
    </div>

    <input
        class="search-bar-tool"
        type="text"
        name="search"
        placeholder=""
        src="@/assets/Search Tool.png"
      />
  </div>
</template>


<script>
export default {
  name: "navigation-bar",
};
</script>

<style>
/* Search Bar */
.search-bar-tool[type="text"] {
  width: 65px;
  height: 65px;
  font-family: "Contrail One";
  text-align: center;
  background-color: transparent;
  color: white;
  -webkit-transition: width 0.4s ease-in-out;
  transition: width 0.4s ease-in-out;
  padding: 5.5px;
  /*   background-image: url("/assets/Search Tool.png"); */
  background-image: url(https://i.postimg.cc/Z5X14FjF/untitled-design-Transparent.png);
  background-size: contain;
  background-repeat: no-repeat;
  outline: 0;
  background-size: 50px;
  background-position: 12px;
  border: none;
  flex-direction: row;
  display: flex;
  align-self: center;
  justify-content: center;

}

/* Search Bar */
/* When the input field gets focus, change its width to 100% */
.search-bar-tool[type="text"]:focus {
  width: 10%;
  font-family: "Contrail One", "Franklin Gothic Medium Extended", "sans-serif";
  text-align: center;
  border: 5px solid #5ecade;
  border-style: inset;
  border-radius: 16px;
  background-color: navy;
  color: white;
}

::placeholder {
  /* "Search Cosmic Comics"*/
  color: white;
  font-family: "Bangers";
  letter-spacing: 2px;
}

.navigation-container {
  background-image: none;
  background-color: transparent;
  flex-direction: row;
  display: flex;
  align-self: center;
  justify-content: center;
  vertical-align: middle;
  height: auto; /* Change this when we properly have everything fit on the page */
}

button {
  border: 5px solid #5ecade;
  border-style: inset;
  background-image: none;
  background-color: navy;
  color: #3db656;
  text-align: center;
  font-family: "Contrail One", "Franklin Gothic Medium Extended", "sans-serif";
  letter-spacing: 1px;
  word-spacing: 0;
  font-weight: bold;
  font-size: 160%;
  border-radius: 10px;
  padding: 1.5% 1% 1.5% 1%;
  line-height: 15px;
  width: fit-content;
  block-size: fit-content;
}

button {
  background-image: none;
  background-color: transparent;
  border: transparent;
  width: fit-content;
}

.nav-box {
  border: 5px solid #5ecade;
  border-style: inset;
  background-image: none;
  background-color: navy;
  color: #3db656;
  text-align: center;
  font-family: "Contrail One", "Franklin Gothic Medium Extended", "sans-serif";
  letter-spacing: 1px;
  word-spacing: 0;
  font-weight: bold;
  font-size: 160%;
  border-radius: 10px;
  padding: 1.5% 1% 1.5% 1%;
  line-height: 15px;
  width: auto;
  block-size: fit-content;
  margin: 0% 1% 0% 1%;
}

.nav-box:nth-child(3) {
  border: 5px solid #5ecade;
  border-style: inset;
  background-image: none;
  background-color: navy;
  color: #3db656;
  letter-spacing: 1px;
  word-spacing: 0;
  font-size: 160%;
  border-radius: 10px;
  width: auto;
  height: 20px;
}

img {
  width: 50px;
  height: 50px;
}
</style>