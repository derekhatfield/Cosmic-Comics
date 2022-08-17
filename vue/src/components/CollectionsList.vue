<template>
  <div>    
    <div v-for="collection in collections" v-bind:key="collection.id" class="collectionsDiv">
      <h1>{{collection.name}}</h1>
      <div v-for="comic in collection.comics" v-bind:key="comic.comicId" class="individualComicDiv">        
        <img :src="comic.imageURL" alt="" />
        <h2>{{comic.comicTitle}}</h2>
      </div>
    </div>
    <div class="comicContainer">
      <!--<comic-card />-->
    </div>
       
  </div>
</template>

<script>
//import ComicCard from "./ComicCard.vue";
import CollectionService from "@/services/CollectionService.js";
//import Comics from "@/views/Comics.vue";

export default {
  components: {
    //ComicCard
  },

  data() {
    return {
      collections: [],

      collectionExample: {
        "collectionId":6,
        "comics":[
          {
            "comicId":1,
            "marvelId":0,
            "comicTitle":"testTitle",
            "author":null,
            "imageURL":"google.com",
            "releaseDate":null,
            "creatorId":0,
            "seriesId":0,
            "description":null,
            "extension":null
          }
        ],
        "name":"testName5"
      }
    }
  },

  created() {
      CollectionService.getMyCollections(this.$store.state.user.username).then((response) => {
        this.collections = response.data;
      });
  }
}
</script>

<style>
/* This is each collection's name*/
h1 { 
  color:white;
  font-size: 60px;
  font-family: "Contrail One", "Franklin Gothic Medium Extended", "sans-serif";
}

/* This is each comic's title */
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

.individualComicDiv {
  display: inline-block;
  font-family: "Contrail One", "Franklin Gothic Medium Extended", "sans-serif";
  letter-spacing: 1px;
  word-spacing: 2px;
}

/* Comic cover imgs */
img {
  height: 356.25px;
  width: 255.796872px;
  margin: 20px;
  border:2px solid white;
}

</style>