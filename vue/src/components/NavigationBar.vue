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
        >Create A Collection</router-link>      
    </div>
  </div>
</template>


<script>
export default {
  name: "navigation-bar",
};
</script>

<style>

.navigation-container {
  background-image: none;
  background-color: transparent;
  flex-direction: row;
  display: flex;
  align-self: center;
  justify-content: center;
  vertical-align: middle;
  height: fit-content; /* Change this when we properly have everything fit on the page */
}

/* button {
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
  padding: 1% 1% 1% 1%;
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
 */
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
  padding: 1% 1% 1% 1%;
  line-height: fit-content;
  width: auto;
  height: auto;
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
  height: auto;
}

img {
  width: 50px;
  height: 50px;
}
</style>