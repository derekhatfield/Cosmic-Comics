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
        <span v-on:click="myFunction(comic.marvelId); getComicIdToAdd(comic.marvelId)">
          Add Comic to a Collection            
            <button v-show="getComicIdToAdd !== 0" :id="`myPopup${comic.marvelId}`" v-for="collection in userCollections" v-bind:key="collection.collectionId" 
            v-on:click="getComicIdToAdd(comic.marvelId); addComicToCollection(comic, collection.collectionId)">{{collection.name}}</button>          
        </span>        
        <img :src="comic.imageURL" alt="" class="comic-img" />
        <h2>{{ comic.comicTitle }}</h2>
      </div>
    </div>

  </div>
</template>


<script>
import NavigationBar from "@/components/NavigationBar";
import MarvelService from "@/services/MarvelService";
import CollectionService from "@/services/CollectionService"

export default {
  name: "Comics",
  components: {
    NavigationBar,
  },
  props: ["collectionId"],
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
      userCollections: [],
      comicIdToAdd: 0
    }
  },

  computed: {
    sortComicsByUserInput() {
      return this.apiComics.filter((comic) =>
        comic.comicTitle.toLowerCase().includes(this.userInput.toLowerCase())
      );
    }
  },

  methods: {
    searchComics() {
      MarvelService.searchByComics(this.userInput).then((response) => {
        this.apiComics = response.data;
      });
    },
    addComicToCollection(comic, collectionId) {
      CollectionService.addComicToCollection(comic, collectionId, this.comicIdToAdd).then((response) => {
        if (response.status === 200) {
          this.comic = {
            marvelId: this.comicIdToAdd.comicId,
            comicTitle: this.api,
            imageURL: this.imageUrl
          }
          this.$router.push({name: "collections"})
        }
      });
    },
    myFunction(marvelId) {
      var popup = document.getElementById("myPopup" + marvelId);
      popup.classList.toggle("show");
    },

    getComicIdToAdd(comicId) {
      this.comicIdToAdd = comicId;
    }

  },

  created() {
    MarvelService.searchByComics("A").then((response) => {
      this.apiComics = response.data;
    }),

    CollectionService.getMyCollections(this.$store.state.user.username).then((response) =>{
      this.userCollections = response.data;
    })
  }
}

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
  margin-top: 0px;
  padding-bottom: 40px;
  padding-top: 0;
  
}

/* This is the comic cover images */
.comic-img {
  height: 356.25px;
  width: 255.796872px;
  margin: 10px 20px 20px 20px;
  border: 2px solid white;
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
  font-size: 40px;
  color: orange;
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

span {
  color: orange;
  width: 260px;
}

button {
  text-justify: center;
  color: #d890ff;
  font-family: "Bangers";
  font-size: 20px;
  border: #5ecade;
  background-color: navy;
  border-style: solid;
  border-radius: 5px;
  padding: 5px 15px;
  margin: 5px;
}

/*.popup {
  position: relative;
  display: inline-block;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  z-index: 4;
  
}

.popuptext {
  visibility: hidden;
  width: 160px;
  background-color: #555;
  color: #fff;
  text-align: center;
  border-radius: 6px;
  padding: 8px 0;
  position: sticky;
  z-index: 1;
  bottom: 125%;
  left: 50%;
  margin-left: -80px;
}

.popuptext::after {
  top: 100%;
  left: 50%;
  margin-left: -5px;
  border-width: 5px;
  border-style: solid;
  border-color: #555 transparent transparent transparent;
}

.popup .show {
  visibility: visible;
  -webkit-animation: fadeIn 1s;
  animation: fadeIn 1s;
}*/

@-webkit-keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

@keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

/* .grid-item {
  position: relative;
  z-index: -1;
} */
</style>