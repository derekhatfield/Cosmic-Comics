<template>
  <div id="register" class="text-center">
    <navigation-bar />
    <form class="form-register" @submit.prevent="register">
      <body>
        <h1 class="create-account">Create Account</h1>
        <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>

        <section>
          <div class="register-section">
            <form action="/action_page.php">
              <label for="username" class="username-tag">Username</label>
              <input
                type="username"
                id="username"
                class="username-form-control"
                placeholder="Username"
                v-model="user.username"
                required
                autofocus
              />
              <br />

              <label for="password" class="password-tag">Password</label>
              <input
                type="password"
                id="password"
                class="password-form-control"
                placeholder="Password"
                v-model="user.password"
                required
              />
              <label for="confirm Password" class="confirm-password-tag"
                >Password</label
              >
              <input
                type="confirmPassword"
                id="confirmPassword"
                class="confirm-password-form-control"
                placeholder="Confirm Password"
                v-model="user.confirmPassword"
                required
              />
            </form>
          </div>

          <div class="have-account-clickable">
            <router-link :to="{ name: 'login' }">Have an account?</router-link>
            <button class="submit" type="submit">Create Account</button>
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
  name: "register",
  components: {
    NavigationBar,
  },
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
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

#register {
  background-size: cover;
}

body {
  background-image: none;
  background-color: transparent;
  width: 100%;
  margin: 75px 10px 100px 10px;
}

.create-account {
  /* Create Account Title*/
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

.confirm-password-tag {
  color: transparent;
  margin: 0px;
  font-family: "Raleway", "Contrail One", "Franklin Gothic Medium Extended";
  font-size: 40px;
  margin-right: 50px;
  margin-left: 25%;
}
button.submit {
  /* "Create Account" Button*/
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
  margin: 10px;
  padding-top: 6%;
  padding-bottom: 6%;
  text-align: center;
  letter-spacing: 0.5px;
  word-spacing: 1px;
  font-weight: bold;
  width: fit-content;
  block-size: fit-content;
  flex-direction: row;
  padding-left: 30px;
  padding-right: 30px;
}

a {
  /* "Have an Account?" Button */
  color: #3db656;
  display: inline-block;
  background-color: transparent;
  background-image: none;
  font-family: "Raleway", "Contrail One", "Franklin Gothic Medium Extended";
  font-size: 24px;
  font-weight: bold;
  margin: auto;
  padding: 0;
  text-align: center;
  letter-spacing: 0.5px;
  word-spacing: 1px;
  width: fit-content;
  block-size: fit-content;
  text-decoration: none;
}

.register-section {
  margin: auto;
  width: fit-content;
}

.have-account-clickable {
  display: flex;
  margin: auto;
  width: fit-content;
  flex-direction: column-reverse;
  padding: 50px;
  letter-spacing: 1px;
  word-spacing: 0;
}

.login {
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
