<template>
  <div class="Cosmic Comics">
    <h1 class="Comics">Comics</h1>
    <navigation-bar/>
    <div id="comicBody"> 

      <div id="comicCover" v-for="comic in apiComics" v-bind:key="comic.marvelId">
        <img :src="comic.imageURL" alt="">     
      </div>
    
    </div>
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
     
     apiComic: {
       "comicId":0,
       "marvelId":0,
       "comicTitle":"0",
       "author":null,
       "imageURL":"",
       "releaseDate":null,
       "creatorId":0,
       "seriesId":0,
       "description":"",
       "extension":"jpg"
       },
      
      apiComics: []

    }
  },

  created(){

    MarvelService.searchByComics("hulk").then((response) => {
      this.apiComics = response.data;
    })
  }
};
</script>

<style scoped>

#comicCover {
  display: inline-block;
}

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