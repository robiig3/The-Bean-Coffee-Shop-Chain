<template>
            <v-container fluid fill-height>
          <v-layout>
            <v-flex xs12 sm8 md4>
              <v-card class="mx-auto" max-width="344">
                <v-img
                  src="https://images.unsplash.com/photo-1491438590914-bc09fcaaf77a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80"
                  height="200px"
                ></v-img>

                <v-card-title> People of The Bean </v-card-title>

                <v-card-subtitle>
                  Here you can see the family of The Bean
                </v-card-subtitle>

                <v-card-actions>
                  <v-btn color="orange lighten-2" text> Explore </v-btn>

                  <v-spacer></v-spacer>

                  <v-btn icon @click="show = !show">
                    <v-icon>{{
                      show ? "mdi-chevron-up" : "mdi-chevron-down"
                    }}</v-icon>
                  </v-btn>
                </v-card-actions>

                <v-expand-transition>
                  <div v-show="show">
                    <v-divider></v-divider>

                    <v-card-text>
                      I'm a thing. But, like most politicians, he promised more
                      than he could deliver. You won't have time for sleeping,
                      soldier, not with all the bed making you'll be doing. Then
                      we'll go with that data file! Hey, you add a one and two
                      zeros to that or we walk! You're going to do his laundry?
                      I've got to find a way to escape.
                    </v-card-text>
                  </div>
                </v-expand-transition>
              </v-card>
            </v-flex>
          </v-layout>
        </v-container>
</template>

<script>
export default {
  name: "HomeView",
  data() {
    return {
      show:false
    };
  },
};
</script>