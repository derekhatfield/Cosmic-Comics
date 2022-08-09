<template>
  <div class="home">
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
  flex-direction: row;
  display: flex;
  align-self: center;
  justify-content: center;
  border: 3px solid lawngreen;
  height: 100px;
  padding: 2px;
}

    .box:nth-child(1) {
      border: 2px solid black;
      border-radius: 10px;
      width: 100px;
      height: 50px;
      margin: 10px;
      padding: 6% 2% 2% 2%;
    }

    .box:nth-child(2) {
      border: 2px solid black;
      border-radius: 10px;
      width: 100px;
      height: 50px;
      margin: 10px;
      padding: 6% 2% 2% 2%;
    }

    .box:nth-child(3) {
      border: 2px solid black;
      border-radius: 10px;
      width: 150px;
      height: 50px;
      margin: 10px;
      padding: 6% 2% 2% 2%;
    }

    .box:nth-child(4) {
      border: 2px solid black;
      border-radius: 10px;
      width: auto;
      height: auto;
      margin: 10px 10px 10px;
  
    }
</style>