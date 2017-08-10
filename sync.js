var each = require('async-each');
const yeomanSync = require('yeoman-sync');

let config = {
  destination: 'buffer-clean-kotlin',
  rename: [{
    dest: 'gitignore',
    src: '.gitignore'
  }, {
    dest: 'mobile-ui/gitignore',
    src: 'mobile-ui/.gitignore'
  }, {
    dest: 'domain/gitignore',
    src: 'domain/.gitignore'
  }, {
    dest: 'presentation/gitignore',
    src: 'presentation/.gitignore'
  }, {
    dest: 'remote/gitignore',
    src: 'remote/.gitignore'
  }, {
    dest: 'data/gitignore',
    src: 'data/.gitignore'
  }, {
    dest: 'cache/gitignore',
    src: 'cache/.gitignore'
  }],
  replace: [{
    regex: 'org.buffer.android.boilerplate',
    replacement: '<%= appPackage %>'
  }],
  repo: {
    branchName: 'develop',
    url: 'https://github.com/bufferapp/android-clean-architecture-boilerplate.git'
  }
};

yeomanSync(config);