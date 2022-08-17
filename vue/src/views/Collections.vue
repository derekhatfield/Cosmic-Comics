<template>
  <div class="CosmicCollections">
    <h1 class="Collections">Cosmic Collections</h1>
    <navigation-bar />
    <div class="grid-container"></div>

    <!--
    This is for the filter by button that doesn't work but looks really good!


    <div class="dropdown">
      <button onclick="myFunction()" class="dropButton">Filter By</button>
      <div id="filterDropdown" class="dropdown-content">
        <input
          type="text"
          placeholder="Search Cosmic Comics"
          id="myInput"
          onkeyup="filterFunction()"
        />
        <a href="#author">Author</a>
        <a href="#character">Character</a>
        <a href="#collection">Collection</a>
      </div>
    </div>
  -->

    <collections-list />
  </div>
</template>

<script>
import CollectionsList from "@/components/CollectionsList";
import NavigationBar from "@/components/NavigationBar";

export default {
  name: "Collections",
  components: {
    NavigationBar,
    CollectionsList,
  },

  data() {
    return {};
  },

  methods: {
    myFunction() {
      document.getElementById("filterDropdown").classList.toggle("show");
    },
  },

  created() {},
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

.dropButton {
  /* Filter By Dropdown Button */
  background-color: navy;
  border: 4px solid #4bd668;
  border-style: double;
  border-radius: 10px;
  font-family: "Contrail One";
  letter-spacing: 3px;
  color: white;
  padding: 16px;
  font-size: 16px;
  cursor: pointer;
  background-image: linear-gradient(navy, #0b7285);
  margin-left: auto;
  margin-right: 10%; /* This can be adjusted once we have comics in the webpage, it'll move the "Filter By" button */
  margin-top: 2%;
  display: flex;
}

.dropButton:hover,
.dropButton:focus {
  /* Changes color of "Filter By" button when you hover */
  background-color: #c863ff;
}

#myInput {
  box-sizing: border-box;
  font-size: 20px;
  padding: 12px 20px 12px 20px;
  border: transparent;
  background-image: linear-gradient(#d890ff, #0b7285);
  font-family: "Contrail One";
  color: white;
  /*   -webkit-transition: width 0.4s ease-in-out;
  transition: width 0.4s ease-in-out; */
}

::placeholder {
  /* "Search Cosmic Comics"*/
  color: white;
  font-family: "Bangers";
  letter-spacing: 2px;
}

#myInput:focus {
  /* When search field is clicked */
  outline: 2px solid #4bd668;
}

.dropdown {
  /* The container <div> - needed to position the dropdown content */
  position: relative;
  margin-left: auto;
  display: block;
}

.dropdown-content {
  /* Dropdown Content (Hidden by Default) */
  display: none; /* Commanding this on/off seems to bring up the dropdown display */
  position: fixed;
  background-color: #0b7285;
  min-width: 230px;
  border: 1px solid #2adda7;
  font-family: "Contrail One";
  letter-spacing: 3px;
  z-index: 1;
  text-align: center;
  font-size: 16px;
  background-image: linear-gradient(#0b7285, #2adda7);
  margin-left: 80%;
  margin-right: auto; /* This can be adjusted once we have comics in the webpage, it'll move the "Filter By" button */
  margin-top: 0;
}

.dropdown-content a {
  /* Links inside the dropdown */
  color: white;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  font-size: 20px;
}

.dropdown:hover .dropdown-content {
  display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {
  background-image: linear-gradient(#0b7285, #2adda7);
}

/* Show the dropdown menu (use JS to add this class to the .dropdown-content container when the user clicks on the dropdown button) */
.show {
  display: block;
}

.grid-container {
  display: grid;
  grid-template-columns: 300px 300px 300px 300px 300px;
  justify-content: center;
}
</style>