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

          <div class="flip-card-front-1" v-if="isShownOne">
            <img
              class="image1"
              src="@/assets/Hulk Home.jpeg"
              alt="The Immortal Hulk"
              style="width: 511.9375px; height: 712.5px"
            />
          </div>
          <div class="flip-card-back-1" v-if="isShownOne">
            <h3>The Immortal Hulk</h3>
            <p>Vol. 4 (Hardcover)</p>
            <br>
            <p>Published: November 17, 2021</p>
          </div>

          <div class="flip-card-front-2" v-if="isShownTwo">
            <img
              class="image2"
              src="@/assets/Spiderman Home.jpeg"
              alt="The Amazing Spider-Man"
              style="width: 511.9375px; height: 712.5px"
            />
          </div>
          <div class="flip-card-back-2" v-if="isShownTwo">
            <h3>The Amazing Spider-Man</h3>
            <p>(2018) #70</p>
            <br>
            <p>Published: July 07, 2021</p>
          </div>

          <div class="flip-card-front-3" v-if="isShownThree">
            <img
              class="image3"
              src="@/assets/Thor Home.jpeg"
              alt="Thor: Lightning and Lament"
              style="width: 511.9375px; height: 712.5px"
            />
          </div>
          <div class="flip-card-back-3" v-if="isShownThree">
            <h3>Thor: Lightning and Lament</h3>
            <p>(2022) #1</p>
            <br>
            <p>Published: June 29, 2022</p>
          </div>

          <div class="flip-card-front-4" v-if="isShownFour">
            <img
              class="image4"
              src="@/assets/Thanos Home.jpeg"
              alt="Thanos: Zero Sanctuary"
              style="width: 511.9375px; height: 712.5px"
            />
          </div>
          <div class="flip-card-back-4" v-if="isShownFour">
            <h3>Thanos: Zero Sanctuary</h3>
            <p>(Trade Paperback)</p>
            <br>
            <p>Published: November 27, 2019</p>
          </div>

          <div class="flip-card-front-5" v-if="isShownFive">
            <img
              class="image5"
              src="@/assets/Avengers Home.jpeg"
              alt="Avengers"
              style="width: 511.9375px; height: 712.5px"
            />
          </div>
          <div class="flip-card-back-5" v-if="isShownFive">
            <h3>Avengers</h3>
            <p>(2018) #57</p>
            <br>
            <p>Published: July 13, 2022</p>
          </div>
        </div>
      </div>

      <div class="promo-display">
        <button class="promo-box" v-on:click="setViewStatusOne(true)">Hulk</button>
        <button class="promo-box" v-on:click="setViewStatusTwo(true)">Spider-Man</button>
        <button class="promo-box" v-on:click="setViewStatusThree(true)">Thor</button>
        <button class="promo-box" v-on:click="setViewStatusFour(true)">Thanos</button>
        <button class="promo-box" v-on:click="setViewStatusFive(true)">The Avengers</button>
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
  data() {
    return {
      isShownOne: true,
      isShownTwo: false,
      isShownThree: false,
      isShownFour: false,
      isShownFive: false
    }
  },
  methods: {
    setViewStatusOne(value) {
      this.isShownOne = value;
      this.isShownTwo = false;
      this.isShownThree = false;
      this.isShownFour = false;
      this.isShownFive = false;
    },
    setViewStatusTwo(value) {
      this.isShownOne = false;
      this.isShownTwo = value;
      this.isShownThree = false;
      this.isShownFour = false;
      this.isShownFive = false;
    },
    setViewStatusThree(value) {
      this.isShownOne = false;
      this.isShownTwo = false;
      this.isShownThree = value;
      this.isShownFour = false;
      this.isShownFive = false;
    },
    setViewStatusFour(value) {
      this.isShownOne = false;
      this.isShownTwo = false;
      this.isShownThree = false;
      this.isShownFour = value;
      this.isShownFive = false;
    },
    setViewStatusFive(value) {
      this.isShownOne = false;
      this.isShownTwo = false;
      this.isShownThree = false;
      this.isShownFour = false;
      this.isShownFive = value;
    }
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

h3 { /* This is adjusting the text on flip-card-back */
  color: #e671da;
  font-family: "Bangers";
  letter-spacing: 11px;
  line-height: 150%;
  word-spacing: 30px;
  text-shadow: 2px 2px 0 black, 2px -2px 0 black, -2px 2px 0 black,
    -2px -2px 0 black, 7px 7px 0 black, 9px 9px 0 #2adda7;
  text-align: center;
  text-decoration-color: solid black;
  font-size: 70px;
  margin-left: 15px;
  margin-right: 15px;
  margin-top: 10px;
  margin-bottom: 10px;
}

p {
  color: white;
  font-family: "trade gothic";
  text-align: center;
  font-size: 30px;
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
.flip-card-front-1,
.flip-card-back-1,
.flip-card-front-2,
.flip-card-back-2,
.flip-card-front-3,
.flip-card-back-3,
.flip-card-front-4,
.flip-card-back-4,
.flip-card-front-5,
.flip-card-back-5 {
  position: absolute;
  width: 100%;
  height: 100%;
  -webkit-backface-visibility: hidden; /* Safari */
  backface-visibility: hidden;

  /* margin-top: 0px;
  margin-bottom: 50px;
  margin-right: auto;
  margin-left: auto; */
}

/* Style the front side (fallback if image is missing) */
.flip-card-front-1,
.flip-card-front-2,
.flip-card-front-3,
.flip-card-front-4,
.flip-card-front-5 {
  position: absolute;
  
}

/* Style the back side */
.flip-card-back-1,
.flip-card-back-2,
.flip-card-back-3,
.flip-card-back-4,
.flip-card-back-5 {
  position: absolute;
  background-color: transparent;
  transform: rotateY(180deg);
  margin-top: 25%;
  margin-bottom: 25%;
  
}

.alt {
  font-family: "Contrail One"
}

.promo-display {
  background-color: transparent;
  flex-direction: row;
  display: flex;
  align-self: center;
  background-image: none;
  width: auto;
  font-family: "Raleway", "Contrail One", "Franklin Gothic Medium Extended";
  justify-content: center;
  vertical-align: middle;
  height: fit-content; /* Change this when we properly have everything fit on the page */
  margin-bottom: 100px;

}

.promo-box {
  text-align: center;
  font-size: 200%;
  border-radius: 10px;
  padding: 12px;
  width: fit-content;
  border: 3px solid #2adda7;
  border-style: inset;
  background-image: none;
  background-color: #f9722b;
  color: white;
  transition: all 0.5s;
  cursor: pointer;
  margin-left: 10px;
  margin-right: 10px;
	-webkit-text-stroke-width: 0.2px;
    -webkit-text-stroke-color: black;
    font-family: "Bangers", "Contrail One", "Franklin Gothic Medium Extended";

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

img {
  margin: 0px;
  border: transparent;
}
</style>