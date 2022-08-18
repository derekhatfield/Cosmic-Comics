<template>
  <div id="login" class="text-center">
    <navigation-bar />
    <form class="form-login" @submit.prevent="login">
      <body>
        <h1 class="login-in">Please Login</h1>
        <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        </div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >
        </div>

        <section>
          <div class="login-section">
            <form action="/action_page.php">
              <label for="username" class="username-tag">Username</label>
              <input
                type="username"
                id="Username"
                class="username-form-control"
                placeholder="Username"
                v-model="user.username"
                required
                autofocus
              />

              <label for="password" class="password-tag">Password</label>
              <input
                type="password"
                id="password"
                class="password-form-control"
                placeholder="Password"
                v-model="user.password"
                required
              />
            </form>
          </div>

          <div class="need-account-clickable">
            <button class="submit" type="submit">Login</button>
            <router-link :to="{ name: 'register' }"
              ><button class="register" type="Register">
                Need an account?
              </button></router-link
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

.login-in {
  /* Please Login Button */
  font-family: "Raleway";
  letter-spacing: 11px;
  color: white;
  border: 0;
  padding: 0;
  margin-top: 100px;
  margin-bottom: 135px;
  margin-right: 100px;
  margin-left: 100px;
  width: auto;
  height: auto;
  text-align: center;
  font-size: 125px;
  color: #4bd668;
  font-family: "Bangers";
  word-spacing: 20px;
  text-shadow: 2px 2px 0 black, 2px -2px 0 black, -2px 2px 0 black,
    -2px -2px 0 black, 5px 5px 0 black, 7px 7px 0 #2adda7, 8px 8px 0 #d890ff;
}

.username-tag {
  color: white;
  margin: 0px;
  font-family: "Raleway", "Contrail One", "Franklin Gothic Medium Extended";
  font-size: 40px;
  margin-right: 36px;
  margin-left: 25%;
}

.password-tag {
  color: white;
  margin: 0px;
  font-family: "Raleway", "Contrail One", "Franklin Gothic Medium Extended";
  font-size: 40px;
  margin-right: 50px;
  margin-left: 25%;
}

button.submit {
  /* "Login" Button */
  color: #3db656;
  display: inline-block;
  background-color: transparent;
  background-image: none;
  border-style: inset;
  font-family: "Raleway", "Contrail One", "Franklin Gothic Medium Extended";
  font-size: 24px;
  border: 3px solid #d890ff;
  background-color: navy;
  border-radius: 10px;
  margin: auto;
  padding-right: 5%;
  padding-left: 5%;
  padding-top: 6%;
  padding-bottom: 6%;
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

.need-account-clickable {
  /* Ranges from "Login" & "Need an Account?" buttons */
  display: flex;
  margin: auto;
  width: fit-content;
  flex-direction: column;
  padding: 50px;
  letter-spacing: 1px;
  word-spacing: 0;
  text-decoration: none;
}

button.register {
  /* "Need an Account?" Button */
  margin: 10px;
  width: fit-content;
  flex-direction: row;
  padding-left: 30px;
  padding-right: 30px;
  padding-top: 4.5%;
  padding-bottom: 4.5%;
  letter-spacing: 1px;
  font-family: "Raleway", "Contrail One", "Franklin Gothic Medium Extended";
  color: #3db656;
  background-color: transparent;
  border: none;
  background-image: none;
  padding: 0;
  text-align: center;
  word-spacing: 1px;
  block-size: fit-content;
  text-decoration: none;
  display: inline-block;
  font-size: 24px;
  font-weight: bold;
}

/* Style inputs */
input[type="text"],
select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  font-family: "Raleway", "Contrail One", "Franklin Gothic Medium Extended";
  font-size: 25px;
}

/* Style the submit button */
input[type="submit"] {
  width: 100%;
  background-color: #04aa6d;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}


</style>