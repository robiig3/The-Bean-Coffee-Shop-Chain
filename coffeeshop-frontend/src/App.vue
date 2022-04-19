<template>
  <v-app>
    <v-app-bar
      app
      color="brown darken-4"
      dark
    >
      <div class="d-flex align-center">
        <v-img
          alt="The Bean Coffeeshop Logo"
          class="shrink mr-2"
          contain
          src="../src/assets/logo.png"
          transition="scale-transition"
          width="40"
        />
        <v-toolbar-title>The Bean Coffeeshop</v-toolbar-title>
      </div>

      <v-spacer></v-spacer>

    </v-app-bar>

    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    //
  }),
};
</script>
