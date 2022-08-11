<template>
  <div class="CosmicCollections">
    <h1 class="Collections">Cosmic Collections</h1>
    <navigation-bar/>
    <body>
      <div>
      </div>
    </body>
  </div>
</template>

<script>
import NavigationBar from '@/components/NavigationBar';
export default {
  name: "Collections",
  components: {
    NavigationBar
  }
};
</script>

<style scoped>


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
    -2px -2px 0 black, 1px 1px 0 black, 3px 3px 0 #2adda7;

}
</style>