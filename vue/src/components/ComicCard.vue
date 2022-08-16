<template>
  <div class="card">
      <div class="button">
          <button class="add-a-comic">Add A comic</button>
      </div>
      <h2 class="title">Title</h2>
      <img class="thumbnail_url" src="" alt="">
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
    border-style: solid rgb(111, 218, 111);
    width: 200px;
    height: 200px;
}

</style>