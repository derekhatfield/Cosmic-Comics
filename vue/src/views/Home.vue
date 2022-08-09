<template>
  <div class="home">
    <!-- <div>
    <p>test</p>
  </div> -->
    <h1>Cosmic Comics</h1>
    <h2>Tagline opportunity or introduction to what this site is</h2>
    <!-- <p>You must be authenticated to see this</p> -->
    <div class="navigation-container">
      <div class="box">Collections</div>
      <div class="box">Add a Comic</div>
      <div class="box">Create a Collection</div>
      <div class="box">
        <img src="../assets/Search Tool.png" alt="Search Tool" class="Search Tool Image" height="50px" width="50px">
      </div>
  </div>
  
<!--TODO: DO WE NEED TO KEEP THIS AUTHENTICATION LINE UP ABOVE? -->
  </div>
    
</template>

<script>
export default {
  name: "home"
};
</script>

<style scoped>

h1 {
  color: white;
}

h2 {
  color: white;
}

 div {
  background-color: pink;
  border: 0;
  padding: 0;
  margin: 0;
  width: auto;
  height: auto;
}

/* TODO: IMPORT FONT FAMILYS INTO VS CODE: FRANKLIN GOTHIC, TRADE GOTHIC, & BADABOOM. */
h1 {
  font-family:'franklin gothic'; 
  text-align: center;
  font-size: 100px;
  }

h2 {
  font-family: 'trade gothic'; 
  text-align: center;
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

    .box {
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
    .box:nth-child(4) {
      background-image: none;
      border: 2px solid black;
      border-radius: 10px;
      width: auto;
      height: auto;
      margin: 10px 10px 10px;
  
    }
</style>