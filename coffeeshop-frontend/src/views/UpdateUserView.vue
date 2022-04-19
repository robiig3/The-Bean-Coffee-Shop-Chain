<template>
  <v-app id="inspire">
    <v-content>
      <v-container fluid fill-height>
        <v-layout align-center justify-center>
          <v-flex xs12 sm8 md4>
            <v-card class="elevation-12" color="brown lighten-3">
              <v-toolbar dark color="brown darken-4">
                <v-toolbar-title>Update user </v-toolbar-title>
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
                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn
                  color="brown darken-3"
                  @click="edit"
                >
                Update
                </v-btn>
                <v-btn color="secondary" 
                @click="$router.push({ name: 'home' })"
                > 
                Cancel operation 
                </v-btn>
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
  name: "HomeView",
  data() {
    return {
      userId: this.$route.params.id,
      name: "",
      surname: ""
    };
  },
  methods: {
    async edit() {
      try {
        await axios.put(`http://localhost:8082/user/${this.userId}`, {name: this.name, surname: this.surname});
        this.$router.push({ name: "home" });
      } catch (e) {
        alert("Cannot edit!" + this.userId);
      }
    }
  },
};
</script>