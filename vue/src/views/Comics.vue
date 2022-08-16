<template>
  <div class="Cosmic Comics">
    <h1 class="Comics">Comics</h1>
    <navigation-bar/>

    <input
        class="search-bar-tool"
        type="text"
        name="search"
        placeholder=""
        src="@/assets/Search Tool.png"
        v-model="userInput"
        v-on:keyup.enter="searchComics"
      />

    <div id="comicBody">
      <div id="comicCover" v-for="comic in sortComicsByUserInput" v-bind:key="comic.marvelId">
        <h2>{{comic.comicTitle}}</h2>
        <img :src="comic.imageURL" alt="">     
      </div>    
    </div>
  </div>
</template>


<script>
import NavigationBar from '@/components/NavigationBar';
import MarvelService from '@/services/MarvelService';

export default {
  name: "Comics",
  components: {
    NavigationBar
  },

  data(){
    return {
     userInput: "",
     apiComic: {
       "comicId":0,
       "marvelId":0,
       "comicTitle":"0",
       "author":null,
       "imageURL":"",
       "releaseDate":null,
       "creatorId":0,
       "seriesId":0,
       "description":"",
       "extension":"jpg"
       },
      
      apiComics: []

    }
  },

  computed: {
    sortComicsByUserInput() {
      return this.apiComics.filter(comic => comic.comicTitle.toLowerCase().includes(this.userInput.toLowerCase()));
    }
  },

  methods: {
    searchComics() {
      MarvelService.searchByComics(this.userInput).then((response) => {
      this.apiComics = response.data;
    })
    
    }
  },

  created(){

    MarvelService.searchByComics("A").then((response) => {
      this.apiComics = response.data;
    })
  }
};
</script>

<style scoped>

/* This is the overall comic display list */
#comicCover {
  display: inline-block;
}

h1 /* Title */ {
font-family: "Raleway";
  letter-spacing: 3px;
  color: white;
  border: 0;
  padding: 0;
  margin: 30px;
  width: auto;
  height: auto;
  text-align: center;
  font-size: 100px;
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
}

/* This is the comic cover images */
img {
  height: 400px;
  width: 400px;
}

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
</style>