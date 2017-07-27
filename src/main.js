// css
import './main.scss';

// js
import Vue from 'vue';
import VueResource from 'vue-resource';
import Sticky from 'sticky-js';
import {getFile} from './utils.js';

// connect
Vue.use(VueResource);

var list = [{
    name: 'Android Starters Java',
    templateName: 'androidstarters-java',
    license: 'MIT',
    desc: 'Android starter based on MVP/Dagger2/RxJava2/Robolectric/Espresso/Mockito. It provides a generator to fast create a Android template projec',
    gh: 'https://github.com/androidstarters/android-starter'
}, {
    name: 'Android Starters Kotlin',
    templateName: 'androidstarters-kotlin',
    license: 'MIT',
    desc: 'Kotlin Android starter based MVP/Dagger2/RxJava2/Robolectric/Espresso/Mockito. It provides a generator to fast create a Kotlin Android projec',
    gh: 'https://github.com/androidstarters/kotlin-android-starter'
}, {
    name: 'Google Samples MVP',
    templateName: 'googlesamples-mvp',
    license: 'MIT',
    desc: 'Demonstrates a basic Model‑View‑Presenter (MVP) architecture and provides a foundation on which the other samples are built. This sample also acts as a reference point for comparing and contrasting the other samples in this project.',
    gh: 'https://github.com/googlesamples/android-architecture/tree/todo-mvp/'
}, {
    name: 'Google Samples Databinding',
    templateName: 'googlesamples-databinding',
    license: 'MIT',
    desc: 'Uses the Data Binding Library.',
    gh: 'https://github.com/googlesamples/android-architecture/tree/todo-databinding/'
}, {
    name: 'Google Samples MVP Clean',
    templateName: 'googlesamples-mvp-clean',
    license: 'MIT',
    desc: 'Uses concepts from Clean Architecture.',
    gh: 'https://github.com/googlesamples/android-architecture/tree/todo-mvp-clean/'
}, {
    name: 'Google Samples MVP Dagger',
    templateName: 'googlesamples-mvp-dagger',
    license: 'MIT',
    desc: 'Uses Dagger2 to add support for dependency injection.',
    gh: 'https://github.com/googlesamples/android-architecture/tree/todo-mvp-dagger/'
}, {
    name: 'Google Samples MVP RxJava',
    templateName: 'googlesamples-mvp-rxjava',
    license: 'MIT',
    desc: 'Uses RxJava to implement concurrency, and abstract the data layer.',
    gh: 'https://github.com/googlesamples/android-architecture/tree/todo-mvp-rxjava/'
}, {
    name: 'Google Samples MVVM Databinding',
    templateName: 'googlesamples-mvvm-databinding',
    license: 'MIT',
    desc: 'Based on the todo-databinding sample, this version incorporates the Model‑View‑ViewModel pattern.',
    gh: 'https://github.com/googlesamples/android-architecture/tree/todo-mvvm-databinding/'
}, {
    name: 'Google Samples MVP Loaders',
    templateName: 'googlesamples-mvp-loaders',
    license: 'MIT',
    desc: 'Fetches data using the Loaders API.',
    gh: 'https://github.com/googlesamples/android-architecture/tree/todo-mvp-loaders/'
}, {
    name: 'Google Samples MVP Contentproviders',
    templateName: 'googlesamples-mvp-contentproviders',
    license: 'MIT',
    desc: 'Based on the todo-mvp-loaders sample, this version fetches data using the Loaders API, and also makes use of content providers.',
    gh: 'https://github.com/googlesamples/android-architecture/tree/todo-mvp-contentproviders/'
}];

var sticky = new Sticky('.box-therapy');

var app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue!',
      items: list,
      project: 'Project Name',
      package: 'com.company.project',
      selected: {},
      building: false,
      build_text: 'Download'
    },
    methods: {
      selectPackage: function(e){
        console.log('selected');
        console.log(e);
        this.selected = e;
        this.building = false;
        this.build_text = 'Build';
      },
      
      fetchPost: function(config) {
        var config = {
          appName: this.project,
          packageName: this.package,
          templateName: config.templateName,
          props: {
            appPackage: this.package
          }
        };
        
        this.$http.post('/download', config, {responseType: 'arraybuffer' })
          .then(getFile)
          .then((response) => {            
            response.click(); 
          }, response => {
            console.log('Error downloading...');
          });
      },
    
      buildNow: function(e){
        console.log('builder at work');
        this.fetchPost(this.selected);
        this.building = true;
        this.build_text = '';
      }
    },
  });