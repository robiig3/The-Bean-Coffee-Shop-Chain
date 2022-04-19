<template>
  <v-list three-line>
      <v-list-item v-for="(user) in users" :key="user.id">
        <v-list-item-content>
          <v-list-item-title v-html="user.name"></v-list-item-title>
          <v-list-item-subtitle v-html="user.id"></v-list-item-subtitle>
          <v-list-item-subtitle v-html="user.surname"></v-list-item-subtitle>
          <v-list-item-subtitle v-html="user.username"></v-list-item-subtitle>
          <v-list-item-subtitle v-html="user.password"></v-list-item-subtitle>
        </v-list-item-content>

        <v-list-item-action>
          <v-btn icon @click="$router.push({ name: 'updateUser', params: {id: user.id}})">
            <v-icon color="brown darken-3">mdi-pencil</v-icon>
          </v-btn>

          <v-btn icon @click="deleteUser(user.id)">
            <v-icon color="secondary">mdi-delete</v-icon>
          </v-btn>
        </v-list-item-action>
      </v-list-item>
    </v-list>
</template>

<script>
import axios from "axios";
export default {
  name: "HomeView",
  data() {
    return {
      users: [],
    };
  },
  async created() {
    await this.getUsers();
  },
  methods: {
    async getUsers() {
      try {
        var result = await axios.get("http://localhost:8082/user");
        this.users = result.data;
      } catch (e) {
        alert("Cannot read users!");
      }
    },
    async deleteUser(id) {
      await axios.delete(`http://localhost:8082/user/${id}`);
      this.getUsers();
    },
  },
};
</script>
