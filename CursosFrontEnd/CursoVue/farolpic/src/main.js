import Vue from 'vue'
import App from './App.vue'
import VueResource from 'vue-resource';
import VueRouter from 'vue-router';
import { routes } from './routes';
import './directives/Transform';
import VeeValidate from 'vee-validate';
import msg from './pt_BR';
// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyAzAbflQVpgKHTgl9iYocpcLFLhwPFw-RY",
  authDomain: "testefirebird-61b89.firebaseapp.com",
  projectId: "testefirebird-61b89",
  storageBucket: "testefirebird-61b89.appspot.com",
  messagingSenderId: "562557737479",
  appId: "1:562557737479:web:27ce40ede534a04dd7e8a2",
  measurementId: "G-106NSC8035"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);

firebase.initializeApp(firebaseConfig)

Vue.use(VueResource);
Vue.http.options.root = 'http://localhost:3000';

Vue.use(VueRouter);

const router = new VueRouter({ 
  routes,
  mode: 'history'
});

Vue.use(VeeValidate, {
  locale: 'pt_BR',
  dictionary: {
    pt_BR:{
      messages: msg
    }
  }
});

new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
