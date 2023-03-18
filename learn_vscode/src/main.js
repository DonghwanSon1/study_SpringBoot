import {createApp} from 'vue'
import App from './App.vue'
import AppHeader from './components/AppHeader.vue'
import AppNav from './components/AppNav.vue'
import AppView from './components/AppView.vue'
import BookComponent from './components/BookComponent.vue'

const app = createApp (App);
app.component("AppNav", AppNav);
app.component("BookComponent", BookComponent);
app.component("AppView", AppView);
app.component("AppHeader", AppHeader);
app.mount('#app');
 