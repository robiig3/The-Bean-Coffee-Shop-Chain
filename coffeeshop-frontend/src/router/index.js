import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import RegisterView from '../views/RegisterView.vue'
import AdminLoginView from '../views/AdminLoginView.vue'
import UpdateUserView from '../views/UpdateUserView.vue'
import NewView from '../views/NewView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/adminLogin',
    name: 'adminLogin',
    component: AdminLoginView
  },
  {
    path: '/register',
    name: 'register',
    component: RegisterView
  },
  {
    path: '/home',
    name: 'home',
    component: HomeView
  },
  {
    path: '/updateUser',
    name: 'updateUser',
    component: UpdateUserView
  },
  {
    path: '/newView',
    name: 'newView',
    component: NewView
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
