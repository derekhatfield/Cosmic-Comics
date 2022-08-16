<template>
  <div class="Cosmic Comics">
    <h1 class="Comics">Comics</h1>
    <navigation-bar/>
    <body>      
        <div v-for="result in [data.data.results[0]]" v-bind:key="result.title">
          <h2>{{result.title}}</h2>
          <img :src="`${result.thumbnail.path}.${result.thumbnail.extension}`">
        </div>      
    </body>
  </div>
</template>


<script>
import NavigationBar from '@/components/NavigationBar';
import MarvelService from '@/services/MarvelService';

export default {
  name: "Comics",
  components: {
    NavigationBar
  },

  data(){
    return {
      data: {
        data: {
          results: [          
          ]
        }        
      }
    }
  },

  created(){
    /*MarvelService.searchByCharacters("hulk").then((response) => {
      this.data = response.data;
    });*/ 
    MarvelService.searchByComics("hulk").then((response) => {
      this.data = response.data;
    })
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

h2 {
  color: white;
}

img {
  height: 400px;
  width: 400px;
}
</style>