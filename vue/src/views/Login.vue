<template>
  <div id="login" class="text-center">
    <navigation-bar />
    <form class="form-login" @submit.prevent="login">
      <body>
        <h1 class="login-in">Please Login</h1>
        <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >
          Thank you for registering, please login.
        </div>

        <section>

          <div class="login-section">
          <label for="username" class="username-and-password-tag"
            >Username</label
          >
          <input
            type="text"
            id="Username"
            class="form-control"
            placeholder="username"
            v-model="user.username"
            required
            autofocus
          />
          <label for="password" class="username-and-password-tag"
            >Password</label
          >
          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="Password"
            v-model="user.password"
            required
          />
          </div>

          <div class="need-account-clickable">
            <button class="submit" type="submit">Login</button>
            <router-link :to="{ name: 'register' }"
              ><button class="register" type="Register">Need an account?</button></router-link
            >
          </div>
        </section>


      </body>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import NavigationBar from "@/components/NavigationBar";

export default {
  name: "login",
  components: {
    NavigationBar,
  },

  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>
div {
  background-color: transparent;
  border: 0;
  padding: 0;
  margin: 0;
  width: auto;
  height: auto;
}

#login {
  background-size: cover;
}
body {
  background-image: none;
  background-color: transparent;
  width: 100%;
  margin: 75px 10px 100px 10px;
}

.login-in { /* Please Login */
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

.username-and-password-tag {
  color: white;
  margin: 0px;
  font-family: "Raleway", "Contrail One", "Franklin Gothic Medium Extended";
  font-size: 24px;
  margin: 40px;
}

button {
  color: #3db656;
  display: inline-block;
  background-color: transparent;
  background-image: none;
  border-style: inset;
  font-family: "Raleway", "Contrail One", "Franklin Gothic Medium Extended";
  font-size: 24px;
  border: 3px solid #D890FF;
  background-color: navy;
  border-radius: 10px;
  margin: 10px;
  padding: 0;
  text-align: center;
  letter-spacing: 0.5px;
  word-spacing: 1px;
  font-weight: bold;
  width: fit-content;
  block-size: fit-content;
}

.login-section {
  margin: auto;
  width: fit-content;
}

.need-account-clickable
{
  display: flex;
  margin: auto;
  width: fit-content;
  flex-direction: row;
  padding: 50px;
  letter-spacing: 1px;
  word-spacing: 0;
}

.register
{
  display: flex;
  margin: 10px;
  width: fit-content;
  flex-direction: row;
  padding-left: 30px;
  padding-right: 30px;
  padding-top: 4.5%;
  padding-bottom: 4.5%;
  letter-spacing: 1px;
  word-spacing: 0;
  
}

.submit
{
  display: flex;
  margin: 10px;
  width: fit-content;
  flex-direction: row;
  padding-left: 30px;
  padding-right: 30px;
  padding-top: 3%;
  padding-bottom: 3%;
  letter-spacing: 1px;
  word-spacing: 0;
  
}
</style>