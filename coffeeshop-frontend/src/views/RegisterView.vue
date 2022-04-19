<template>
  <v-app id="inspire">
    <span class="bg"></span>
    <v-content>
      <v-container fluid fill-height>
        <v-layout align-center justify-center>
          <v-flex xs12 sm8 md4>
            <v-card class="elevation-12" color="brown lighten-3">
              <v-toolbar dark color="brown darken-4">
                <v-toolbar-title>Register</v-toolbar-title>
              </v-toolbar>
              <v-card-text>
                <v-form>
                  <v-text-field
                    v-model="name"
                    label="Name"
                    type="text"
                  ></v-text-field>
                  <v-text-field
                    v-model="surname"
                    label="Surname"
                    type="text"
                  ></v-text-field>
                  <v-text-field
                    v-model="username"
                    label="Username"
                    type="text"
                  ></v-text-field>
                  <v-text-field
                    v-model="password"
                    label="Password"
                    type="password"
                    required
                  ></v-text-field>
                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn
                  color="brown darken-3"
                  @click="$router.push({ name: 'login' })"
                >
                  Login
                </v-btn>
                <v-btn color="secondary" @click="register"> Register </v-btn>
              </v-card-actions>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
  </v-app>
</template>


<script>
import axios from "axios";
export default {
  name: "RegisterView",
  data() {
    return {
      name: "",
      surname: "",
      username: "",
      password: "",
    };
  },
  methods: {
    async register() {
      var body = {
        name: this.name,
        surname: this.surname,
        username: this.username,
        password: this.password,
      };
      try {
        var result = await axios.post("http://localhost:8082/user/add", body);
        window.localStorage.setItem("userId", result.data);
        this.$router.push({ name: "login" });
      } catch (e) {
        alert("Credentiale incorecte!");
      }
    },
  },
};
</script>

<style>
.bg {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
  background: url("https://images.unsplash.com/photo-1481833761820-0509d3217039?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80")
    no-repeat center center;
  background-size: cover;
  background-color: red;
  transform: scale(1.1);
}
</style>