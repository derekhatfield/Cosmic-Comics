<template>
  <div class="Cosmic Create A Collection">
    <h1 class="Create A Collection">Create A Collection</h1>
    <navigation-bar/>
    <div class="form-div">
      <form v-on:submit.prevent="addCollection" class="add-collection-form">
        <div class="form-collection-name">
          <label for="collection-name-input">Enter the name for your Collection: </label>
          <input id="collection-name-input" type="text" v-model="collection.name">
        </div>
        <div class="action-buttons">
          <button type="submit">Create Collection</button>
        </div>
      </form>
    </div>
  </div>
</template>


<script>
import NavigationBar from '@/components/NavigationBar';
import CollectionService from "@/services/CollectionService.js";

export default {
  name: "CreateACollection",
  components: {
    NavigationBar
  },
  data() {
    return {
      collection: 
        {
          comics: [],
          name: "",
          userId: this.$store.state.user.id
        }
      
    }
  },
  methods: {
    addCollection() {
      CollectionService.addCollection(this.collection).then((response) => {
        if (response.status === 201) {
          this.collection = {
            name: this.collection.name,
            userId: this.$store.state.user.id
          }
          
        } 
        this.$router.push({name: "collections"});     
      });
    }    
  }
}

</script>

<style scoped>

h1 /* Title */ {
font-family: "Raleway";
  letter-spacing: 3px;
  color: white;
  border: 0;
  padding: 0;
  margin-top: 20px;
  margin-bottom: 100px;
  width: auto;
  height: auto;
  text-align: center;
  font-size: 130px;
  color: #4bd668;
  font-family: "Bangers";
  letter-spacing: 11px;
  word-spacing: 20px;
  text-shadow: 2px 2px 0 black, 2px -2px 0 black, -2px 2px 0 black,
    -2px -2px 0 black, 5px 5px 0 black, 7px 7px 0 #2adda7, 8px 8px 0 #d890ff;
}

.form-collection-name {
  color: white;
}

</style>