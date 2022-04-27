import Vue from 'vue'
import App from './App.vue'
import VueResource from 'vue-resource';
import VueRouter from 'vue-router';
import { routes } from './routes';
import './directives/Transform';
import VeeValidade from 'vee-validade';

Vue.use(VueResource);
Vue.http.options.root = 'http://localhost:3000';

Vue.use(VueRouter);

const router = new VueRouter({ 
  routes,
  mode: 'history'
});

Vue.use(VeeValidade);

new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
