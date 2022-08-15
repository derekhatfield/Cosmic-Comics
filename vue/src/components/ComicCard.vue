<template>
  <div class="card">
      <h2 class="title">Title</h2>
      <img class="thumbnail_url" src="" alt="">
      <div class="button">
          <button class="add-a-comic">Add a comic</button>
      </div>
  </div>
</template>

<script>
export default {
    name: 'comic-card',
    props: {
        comic: Object,
    }

}
</script>

<style scoped>
.card {
    background-color: white;
    border: green;
    border-style: solid white;
    width: 200px;
    height: 200px;
}

</style>