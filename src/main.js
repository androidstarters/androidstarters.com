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