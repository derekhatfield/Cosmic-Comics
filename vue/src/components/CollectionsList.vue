<template>
  <div class="comic-container">
    <comic-card />
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
      collections: [],
    };
  },
  created() {
    CollectionService.getAllCollections().then((response) => {
      this.collections = response.data;
    });
  },
};
</script>

<style>
</style>