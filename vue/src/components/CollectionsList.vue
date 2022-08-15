<template>
  <div class="comic-container">
    <comic-card />
    <div v-for="collection in collections" v-bind:key="collection.name" class="collectionsDiv">
      <h1>{{collection.name}}</h1>
    </div>
    
  </div>
</template>

<script>
import ComicCard from "./ComicCard.vue";
import CollectionService from "@/services/CollectionService.js";

export default {
  components: {
    ComicCard,
  },
  data() {
    return {
      username: '',
      collections: [],
      results: {
        data: {
          results: []
        }
      },
      showForm: false
    };
  },
  created() {
    CollectionService.getAllCollections().then((response) => {
      this.collections = response.data;
      console.log(this.collections);
    });
  },
};
</script>

<style>
</style>