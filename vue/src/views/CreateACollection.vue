<template>
  <div class="Cosmic Create A Collection">
    <h1 class="Create A Collection">Create A Collection</h1>
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
  name: "Create A Collection",
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
    -2px -2px 0 black, 5px 5px 0 black, 7px 7px 0 #2adda7, 8px 8px 0 #d890ff;

}
</style>