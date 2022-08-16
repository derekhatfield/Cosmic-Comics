<template>
  <div class="Cosmic Comics">
    <h1 class="Comics">Comics</h1>
    <navigation-bar />

    <input
      class="search-bar-tool"
      type="text"
      name="search"
      placeholder=""
      src="@/assets/Search Tool.png"
      v-model="userInput"
      v-on:keyup.enter="searchComics"
    />

    <div class="grid-container" id="comicBody">
      <div
        class="grid-item"
        id="comicCover"
        v-for="comic in sortComicsByUserInput"
        v-bind:key="comic.marvelId"
      >
        <img :src="comic.imageURL" alt="" />
        <h2>{{ comic.comicTitle }}</h2>
      </div>
    </div>
  </div>
</template>


<script>
import NavigationBar from "@/components/NavigationBar";
import MarvelService from "@/services/MarvelService";

export default {
  name: "Comics",
  components: {
    NavigationBar,
  },

  data() {
    return {
      userInput: "",
      apiComic: {
        comicId: 0,
        marvelId: 0,
        comicTitle: "0",
        author: null,
        imageURL: "",
        releaseDate: null,
        creatorId: 0,
        seriesId: 0,
        description: "",
        extension: "jpg",
      },

      apiComics: [],
    };
  },

  computed: {
    sortComicsByUserInput() {
      return this.apiComics.filter((comic) =>
        comic.comicTitle.toLowerCase().includes(this.userInput.toLowerCase())
      );
    },
  },

  methods: {
    searchComics() {
      MarvelService.searchByComics(this.userInput).then((response) => {
        this.apiComics = response.data;
      });
    },
  },

  created() {
    MarvelService.searchByComics("A").then((response) => {
      this.apiComics = response.data;
    });
  },
};
</script>

<style scoped>
/* This is the overall comic display list */
#comicCover {
  display: inline-block;
  font-family: "Contrail One", "Franklin Gothic Medium Extended", "sans-serif";
  letter-spacing: 1px;
  word-spacing: 2px;
  
}

.grid-container {
  display: grid;
  grid-template-columns: 300px 300px 300px 300px 300px;
  justify-content: center;
}

h1 /* Title */ {
  border: 0;
  padding: 0;
  margin-top: 20px;
  margin-bottom: 100px;
  width: auto;
  height: auto;
  text-align: center;
  font-size: 130px;
  color: #4bd668;
  font-family: "Bangers";
  letter-spacing: 11px;
  word-spacing: 20px;
  text-shadow: 2px 2px 0 black, 2px -2px 0 black, -2px 2px 0 black,
    -2px -2px 0 black, 5px 5px 0 black, 7px 7px 0 #2adda7, 8px 8px 0 #d890ff;
}

/* This is the title for each comic */
h2 {
  color: white;
  text-align: center;
  font-size: 20px;
  margin-right: 22px;
  margin-left: 22px;
  margin-bottom: 50px;
  padding-bottom: 40px;
  padding-top: 0;
  margin-top: 0px;
}

/* This is the comic cover images */
img {
  height: 356.25px;
  width: 255.796872px;
  margin: 20px;
  border:2px solid white;
}

/* 

before
height: 267.1875px;
width: 191.84766px;
margin: 20px;

1/4 
w: 63.94922188
h: 89.0625

whole
width: 255.796875px;
  height: 356.25px;


1/2
height: 178.125px;
  width: 127.898438px; */

/* Search Bar */
.search-bar-tool[type="text"] {
  width: 25%;
  height: 65px;
  font-family: "Contrail One";
  text-align: center;
  border: 4px solid;
  border-radius: 16px;
  border-image: linear-gradient(#f9722b, #d890ff) 1;
  border-style: double;
  background-color: transparent;
  color: white;
  -webkit-transition: width 0.4s ease-in-out;
  transition: width 0.4s ease-in-out;
  padding: 5.5px;
  background-image: url(https://i.postimg.cc/Z5X14FjF/untitled-design-Transparent.png);
  background-size: contain;
  background-repeat: no-repeat;
  outline: 0;
  background-size: 50px;
  background-position: 12px;
  flex-direction: row;
  display: flex;
  align-self: center;
  justify-content: center;
  margin: auto;
  margin-top: 3%;
  margin-bottom: 5%;
}

/* Search Bar */
/* When the input field gets focus, change its width to 100% */
.search-bar-tool[type="text"]:focus {
  width: 50%;
  font-family: "Contrail One", "Franklin Gothic Medium Extended", "sans-serif";
  text-align: center;
  border: 5px solid #5ecade;
  border-style: inset;
  border-radius: 16px;
  background-color: transparent;

  color: white;
}

::placeholder {
  /* "Search Cosmic Comics"*/
  color: white;
  font-family: "Bangers";
  letter-spacing: 2px;
}
</style>