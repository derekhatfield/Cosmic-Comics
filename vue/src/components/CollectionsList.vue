<template>
  <div>
    <div class="grid-container">
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
          class="individualComicDiv"
        >
          <div class="grid-item">
            <h2>
              <img :src="comic.imageURL" alt="" />
              {{ comic.comicTitle }}
            </h2>
          </div>
        </div>
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
  margin-top: 10%;
  place-items: center;
  align-items: center;
  justify-content: center;
}

/*Grid containing name & images */
.grid-container.individualComicDiv {
  display: flex;
  grid-template-columns: 300px 300px 300px 300px 300px;
  justify-content: center;
  /*   flex-direction: row-reverse; */
  flex-wrap: wrap;
  flex-grow: 4;


  /* .grid-container.collection-name {
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
  margin-right: 50%;
  margin-left: 50%;
  margin-bottom: 50px;
  margin-top: 0px;
  place-items: center;
 /* align-items: center;
  justify-content: center;  */
}

.grid-container {
  justify-content: center;

  display: flex;
  grid-template-columns: 300px 300px 300px 300px 300px;
  /*   flex-direction: row-reverse; */
  flex-wrap: wrap;

}
.grid-item {
  justify-content: center;
  margin-right: 22px;
  margin-left: 22px;
  margin-bottom: 50px;
  margin-top: 0px;
}

/* This is each comic's title */
h2 {
  color: white;
  text-align: center;
  font-size: 20px;
  /* margin-right: 22px;
  margin-left: 22px;
  margin-bottom: 50px;
  margin-top: 0px; */
  padding-bottom: 40px;
  padding-top: 0;
}

.individualComicDiv {
  display: inline-block;
  font-family: "Contrail One", "Franklin Gothic Medium Extended", "sans-serif";
  letter-spacing: 1px;
  word-spacing: 2px;
  display: grid;
  grid-template-columns: 300px 300px 300px 300px 300px;
  justify-content: center;
  color: green;
}

/* Comic cover imgs */
img {
  height: 356.25px;
  width: 255.796872px;
  border: 2px solid white;
  justify-content: center;
}
</style>