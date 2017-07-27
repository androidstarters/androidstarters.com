// css
import './main.scss';

// js
import Vue from 'vue';
import Sticky from 'sticky-js';
import {getFile} from './utils.js';
import * as repos from './repos.js';

// sticky download part
var sticky = new Sticky('.box-therapy');

// vue init
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
        this.selected = e;
        this.building = false;
        this.build_text = 'Build';
        this.templateName = e.templateName;
      },
    
      buildNow: function(e){
        console.log('Buidling ..');
        this.fetchPost(this.selected);
        this.building = true;
        this.build_text = '';
      }
    },
  });