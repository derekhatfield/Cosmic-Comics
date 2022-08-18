<template>
  <div>
    <div class="">
      <div
        v-for="collection in collections"
        v-bind:key="collection.id"
        class="collectionsDiv"
      >
        <div class="collectionsDiv-to-collection-name">
          <h1 class="collection-name">{{ collection.name }}</h1>
        </div>
        <div
          v-for="comic in collection.comics"
          v-bind:key="comic.comicId"
          class="grid-container"
        >
          <div class="grid-item">
            <img :src="comic.imageURL" alt="" />
            <h2>
              
              {{ comic.comicTitle }}
            </h2>
          </div>
        </div>
      </div>
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
        collectionId: 6,
        comics: [
          {
            comicId: 1,
            marvelId: 0,
            comicTitle: "testTitle",
            author: null,
            imageURL: "google.com",
            releaseDate: null,
            creatorId: 0,
            seriesId: 0,
            description: null,
            extension: null,
          },
        ],
        name: "testName5",
      },
    };
  },

  created() {
    CollectionService.getMyCollections(this.$store.state.user.username).then(
      (response) => {
        this.collections = response.data;
      }
    );
  },
};
</script>

<style scoped>
/* This is each collection's name*/
.collectionsDiv > .collectionsDiv-to-collection-name > .collection-name {
  color: #e671da;
  font-family: "Bangers";
  letter-spacing: 11px;
  line-height: 150%;
  word-spacing: 30px;
  text-shadow: 2px 2px 0 black, 2px -2px 0 black, -2px 2px 0 black,
    -2px -2px 0 black, 7px 7px 0 black, 9px 9px 0 #2adda7;
  text-align: center;
  text-decoration-color: solid black;
  font-size: 50px;
  margin-bottom: 50px;
  margin-top: 50px;
  place-items: center;
  align-items: center;
  justify-content: center;
}

/*Grid containing name & images 
.individualComicDiv {
  justify-content: center;
  display: grid;
  font-family: "Contrail One", "Franklin Gothic Medium Extended", "sans-serif";
  letter-spacing: 1px;
  word-spacing: 2px;
  grid-template-columns: 300px 300px 300px 300px 300px;
  justify-content: center;
  color: green;
  margin-left: 300px;
  margin-right: 300px;
}*/

.grid-container {
  display: inline-block;
  grid-template-columns: 300px 300px 300px 300px 300px;
  justify-content: center;
}

.grid-item {
  margin-right: 22px;
  margin-left: 22px;
  margin-bottom: 50px;
  margin-top: 0px;
  align-content: center;

}

/* This is each comic's title */
h2 {
  color: white;
  text-align: center;
  font-size: 20px;
  padding-bottom: 50px;
  padding-top: 5px;
  margin-right: auto;
  margin-left: auto;
  margin-bottom: 50px;
  margin-top: 0px;
  width: 200px;
}

/* Comic cover imgs */
img {
  height: 356.25px;
  width: 255.796872px;
  border: 2px solid white;
}
</style>