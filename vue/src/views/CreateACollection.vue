<template>
  <div class="Cosmic Create A Collection">
    <h1 class="Create A Collection">Create A Collection</h1>
    <navigation-bar />
    <div class="form-div">
      <form v-on:submit.prevent="addCollection" class="add-collection-form">
        <div class="form-collection-name">
          <label for="collection-name-input"
            >Name <br />
            your <br />
            Collection:
          </label>
          <input
            id="collection-name-input"
            type="text"
            v-model="collection.name"
          />
        </div>
        <div class="action-buttons">
          <button class="Create Collection" type="submit">
            Create Collection
          </button>
        </div>
      </form>
    </div>
  </div>
</template>


<script>
import NavigationBar from "@/components/NavigationBar";
import CollectionService from "@/services/CollectionService.js";

export default {
  name: "CreateACollection",
  components: {
    NavigationBar,
  },
  data() {
    return {
      collection: {
        comics: [],
        name: "",
        userId: this.$store.state.user.id,
      },
    };
  },
  methods: {
    addCollection() {
      CollectionService.addCollection(this.collection).then((response) => {
        if (response.status === 201) {
          this.collection = {
            name: this.collection.name,
            userId: this.$store.state.user.id,
          };
        }
        this.$router.push({ name: "collections" });
      });
    },
  },
};
</script>

<style scoped>
h1 /* Title */ {
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
  font-family: "Raleway", "Contrail One", "Franklin Gothic Medium Extended";
  font-size: 40px;
  margin: 75px auto auto auto;
  display: flex;
  width: fit-content;
  flex-direction: column;
  padding: 50px;
  letter-spacing: 1px;
  word-spacing: 0;
  text-decoration: none;
  text-align: center;
}

button {
  color: white;
  -webkit-text-stroke-width: 0.2px;
  -webkit-text-stroke-color: black;
  text-align: center;
  font-size: 200%;
  border-radius: 10px;
  width: fit-content;
  border: 3px solid #2adda7;
  border-style: inset;
  background-image: none;
  background-color: #f9722b;
  cursor: pointer;

  margin: 10px 34% 10px 42.8%; 
  font-family: "Bangers", "Contrail One", "Franklin Gothic Medium Extended";


  flex-direction: row;
  padding-left: 30px;
  padding-right: 30px;
  padding-top: 4.5%;
  padding-bottom: 4.5%;
  letter-spacing: 1px;
  padding: 12px;
  text-align: center;
  word-spacing: 1px;
  block-size: fit-content;
  text-decoration: none;

  display: inline-block;


  
  
}

input {
  margin-top: 20px;
}
</style>