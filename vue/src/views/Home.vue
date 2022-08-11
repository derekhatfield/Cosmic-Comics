<template>
  <div class="home">
    <h1>Cosmic Comics</h1>
    <navigation-bar/>
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
  </div>
</template>

<script>
import NavigationBar from '@/components/NavigationBar';
export default {
  name: "home",
  components: {
    NavigationBar
  }
};
</script>

<style scoped>

div {
  border: 0;
  padding: 0;
  margin: 0;
  width: auto;
  height: auto;
}

h1 {
  color: #f9722b;
  font-family: "Bangers";
  letter-spacing: 11px;
  word-spacing: 20px;
  text-shadow: 2px 2px 0 black,
              2px -2px 0 black,
              -2px 2px 0 black,
              -2px -2px 0 black,
              7px 7px 0 black,
              9px 9px 0 #3db656;
  text-align: center;
  text-decoration-color: solid black;
  font-size: 100px;
  margin: 10px auto 20px auto;
}

h2 {
  color: white;
  font-family: "trade gothic";
  text-align: center;
}

body {
  background-image: none;
  background-color: transparent;
  width: auto;
  height: auto;
  margin: 10px 10px 10px;
}

.main-display {
  width: 255.796875px;
  height: 356.25px;
  border: 7px solid #5ecade;
  border-style: inset;
  background-image: none;

  text-align: center;
  
  font-family:'Franklin Gothic Medium Extended', 'Arial Narrow', Arial, sans-serif;
  font-weight:bold;
  font-size: 175%;
  border-radius: 10px;
  margin-top: 0px;
  margin-bottom: 10px;
  margin-right: auto;
  margin-left: auto;

  padding: 2% 2% 2% 2%;
  
}
.main-box {
  color: #3DB656;
  display: flex;
  align-self: center;
  justify-content: space-around;
  background-color: transparent;
  background-image: none;

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
  color: #5ecade;
  text-align: center;
  font-size: 175%;
  border: 2px solid black;
  border-radius: 10px;
  padding: 1% 2% 1% 2%;
  width: 12%;
  border: 3px solid #D890FF;
  border-style: inset;
  background-image: none;
  background-color: #3DB656;
  color: white;
}
</style>