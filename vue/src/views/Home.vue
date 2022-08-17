<template>
  <div class="home">
    <h1>Cosmic Comics</h1>
    <navigation-bar />
    <body>
      <!-- <div class="main-display">
        <div class="main-box">Main</div>
      </div> -->

      <div class="flip-card">
        <div class="flip-card-inner">
          <div class="flip-card-front">
            <img
              class="image1"
              src="@/assets/Hulk Home.jpeg"
              alt="The Immortal Hulk"
              style="width: 511.9375px; height: 712.5px"
            />
          </div>
          <div class="flip-card-back">
            <h1>The Immortal Hulk</h1>
            <p>Vol. 4 (Hardcover)</p>
            <p>Published: November 17, 2021</p>
          </div>

          <div class="flip-card-front">
            <img
              class="image2"
              src="@/assets/Spiderman Home.jpeg"
              alt="The Amazing Spider-Man"
              style="width: 511.9375px; height: 712.5px"
            />
          </div>
          <div class="flip-card-back">
            <h1>The Amazing Spider-Man</h1>
            <p>(2018) #70</p>
            <p>Published: July 07, 2021</p>
          </div>

          <div class="flip-card-front">
            <img
              class="image3"
              src="@/assets/Thor Home.jpeg"
              alt="THOR: LIGHTNING AND LAMENT"
              style="width: 511.9375px; height: 712.5px"
            />
          </div>
          <div class="flip-card-back">
            <h1>THOR: LIGHTNING AND LAMENT</h1>
            <p>(2022) #1</p>
            <p>Published: June 29, 2022</p>
          </div>

          <div class="flip-card-front">
            <img
              class="image4"
              src="@/assets/Thanos Home.jpeg"
              alt="Thanos: Zero Sanctuary"
              style="width: 511.9375px; height: 712.5px"
            />
          </div>
          <div class="flip-card-back">
            <h1>Thanos: Zero Sanctuary</h1>
            <p>(Trade Paperback)</p>
            <p>Published: November 27, 2019</p>
          </div>

          <div class="flip-card-front">
            <img
              class="image5"
              src="@/assets/Avengers Home.jpeg"
              alt="Avengers"
              style="width: 511.9375px; height: 712.5px"
            />
          </div>
          <div class="flip-card-back">
            <h1>Avengers</h1>
            <p>(2018) #57</p>
            <p>Published: July 13, 2022</p>
          </div>
        </div>
      </div>

      <div class="promo-display">
        <button class="promo-box">promo 1</button>
        <button class="promo-box">promo 2</button>
        <button class="promo-box">promo 3</button>
        <button class="promo-box">promo 4</button>
        <button class="promo-box">promo 5</button>
      </div>
    </body>
  </div>
</template>

<script>
import NavigationBar from "@/components/NavigationBar";
export default {
  name: "home",
  components: {
    NavigationBar,
  },
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
  text-shadow: 2px 2px 0 black, 2px -2px 0 black, -2px 2px 0 black,
    -2px -2px 0 black, 7px 7px 0 black, 9px 9px 0 #3db656;
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
  margin: 10px 10px;
}

.flip-card { /* parent class */
  background-color: transparent;
  width: 511.9375px;
  height: 712.5px;
  perspective: 1000px; /* Remove this if you don't want the 3D effect */
  /* justify-content: center;
 */
  border: 7px solid white;
  background-image: none;

  text-align: center;

  font-family: "Contrail One", "Raleway", "Franklin Gothic Medium Extended";
  font-weight: bold;
  font-size: 175%;
  border-radius: 10px;
  margin-top: 50px;
  margin-bottom: 50px;
  margin-right: auto;
  margin-left: auto;
}



/* This container is needed to position the front and back side */
.flip-card-inner {
  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
  transition: transform 0.8s;
  transform-style: preserve-3d;
}

/* Do an horizontal flip when you move the mouse over the flip box container */
.flip-card:hover .flip-card-inner {
  transform: rotateY(180deg);
}

/* Position the front and back side */
.flip-card-front,
.flip-card-back {
  position: absolute;
  width: 100%;
  height: 100%;
  -webkit-backface-visibility: hidden; /* Safari */
  backface-visibility: hidden;
}

/* Style the front side (fallback if image is missing) */
.flip-card-front {
  background-color: #bbb;
  color: black;
}

/* Style the back side */
.flip-card-back {
  background-color: transparent;
  color: white;
  transform: rotateY(180deg);
}

/* .flip-card {
  width: 255.796875px;
  height: 356.25px;
  border: 7px solid #5ecade;
  border-style: inset;
  background-image: none;

  text-align: center;

  font-family: "Contrail One", "Raleway", "Franklin Gothic Medium Extended";
  font-weight: bold;
  font-size: 175%;
  border-radius: 10px;
  margin-top: 0px;
  margin-bottom: 10px;
  margin-right: auto;
  margin-left: auto;

  padding: 2% 2% 2% 2%;
}
.flip-card-inner {
  color: #3db656;
  display: flex;
  align-self: center;
  justify-content: space-around;
  background-color: transparent;
  background-image: none;
} */
.promo-display {
  background-color: transparent;
  flex-direction: row;
  display: flex;
  align-self: center;
  justify-content: space-around;
  background-image: none;
  width: auto;
  height: auto;
  font-family: "Raleway", "Contrail One", "Franklin Gothic Medium Extended";
}
.promo-box {
  color: #5ecade;
  text-align: center;
  font-size: 175%;
  border: 2px solid black;
  border-radius: 10px;
  padding: 1% 2% 1% 2%;
  width: 12%;
  border: 3px solid #d890ff;
  border-style: inset;
  background-image: none;
  background-color: #3db656;
  color: white;

  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.promo-box span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}
.promo-box span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}
.promo-box:hover span {
  padding-right: 25px;
}
.promo-box:hover span:after {
  opacity: 1;
  right: 0;
}

.image1 {
  display: none;
}

.image2 {
  display: none;
}

.image3 {
  display: none;
}

.image4 {
  display: none;
}

.image5 {
  display: none;
}
</style>