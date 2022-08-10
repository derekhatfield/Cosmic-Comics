<template>
  <div class="home">
    <!-- <div>
    <p>test</p>
  </div> -->
    <h1>Cosmic Comics</h1>
    <h2>Tagline opportunity or introduction to what this site is</h2>
    <!-- <p>You must be authenticated to see this</p> -->
    <body>
      <div class="main-display">
        <div class="main-box">Main</div>
      </div>
      <div class="promo-display">
        <div class="promo-box">promo 1</div>
        <div class="promo-box">promo 2</div>
        <div class="promo-box">promo 3</div>
        <div class="promo-box">promo 4</div>
        <div class="promo-box">promo 5</div>
      </div>
    </body>

    <!--TODO: DO WE NEED TO KEEP THIS AUTHENTICATION LINE UP ABOVE? -->
  </div>
</template>

<script>
export default {
  name: "home",
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
  color: white;
  font-family: "franklin gothic";
  text-align: center;
  font-size: 100px;
}

h2 {
  color: white;
  font-family: "trade gothic";
  text-align: center;
}

body {
  background-image: none;
  border: 2px solid white;
  width: auto;
  height: auto;
  margin: 10px 10px 10px;
}
.main-box {
  color: aquamarine;
}
.promo-display {
  background-color: transparent;
  flex-direction: row;
  display: flex;
  align-self: center;
  justify-content: space-around;
  background-image: none;
  width: auto;
  height: auto;
}
.promo-box {
  color: white;
  text-align: center;
  font-size: 175%;
  background-image: none;
  border: 2px solid black;
  border-radius: 10px;
  background-color: black;
  padding: 1% 2% 1% 2%;
  width: 12%;
}
</style>