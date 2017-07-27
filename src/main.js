// css
import './main.scss';

// js
import Vue from 'vue';
import VueResource from 'vue-resource';
import Sticky from 'sticky-js';
import {getFile} from './utils.js';
import * as repos from './repos.js';

// connect
Vue.use(VueResource);

var sticky = new Sticky('.box-therapy');

var app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue!',
      items: repos.architectures,
      appName: 'Project Name',
      packageName: 'com.company.project',
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
        this.templateName = e.templateName;
      },
    
      buildNow: function(e){
        console.log('builder at work');
        this.fetchPost(this.selected);
        this.building = true;
        this.build_text = '';
      }
    },
  });