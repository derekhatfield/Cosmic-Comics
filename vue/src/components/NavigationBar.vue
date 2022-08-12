<template>
  <div class="navigation-container">
    <div class="nav-box">
      <router-link v-bind:to="{ name: 'Comics' }" tag="p"
        >Comics</router-link
      >
    </div>
    <div class="nav-box">
      <router-link v-bind:to="{ name: 'Collections' }" tag="p"
        >Collections</router-link
      >
    </div>
    <div class="nav-box">
      <router-link v-bind:to="{ name: 'CreateACollection' }" tag="p">Create A Collection</router-link>




    </div>
    <div class="nav-box">
      <button type="button">
        <img
          src="@/assets/Search Tool.png"
          alt="Search Tool"
          class="Search Tool Image"
          height="50px"
          width="50px"
          onclick="Search();"
        />
      </button>
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
  width: fit-content;
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
  width: 22%;
  height: 20px;
}

.nav-box:nth-child(4) {
  background-image: none;
  border: transparent;
  background-color: transparent;
  border-radius: 10px;
  width: auto;
  height: auto;
  margin-bottom: 0px;
  padding-top: 6px;
}

img {
  width: 50px;
  height: 50px;
}


</style>