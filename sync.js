var each = require('async-each');
const yeomanSync = require('yeoman-sync');

let configs = [{
  destination: 'androidstarters-java',
  rename: [{
    dest: 'gitignore',
    src: '.gitignore'
  }, {
    dest: 'app/gitignore',
    src: 'app/.gitignore'
  }],
  replace: [{
    regex: 'io.mvpstarter.sample',
    replacement: '<%= appPackage %>'
  }],
  repo: {
    branchName: 'develop',
    url: 'https://github.com/androidstarters/android-starter.git'
  }
}, {
  destination: 'androidstarters-kotlin',
  rename: [{
    dest: 'gitignore',
    src: '.gitignore'
  }, {
    dest: 'app/gitignore',
    src: 'app/.gitignore'
  }],
  replace: [{
    regex: 'io.mvpstarter.sample',
    replacement: '<%= appPackage %>'
  }],
  repo: {
    branchName: 'develop',
    url: 'https://github.com/androidstarters/kotlin-android-starter.git'
  }
}, {
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
    branchName: 'master',
    url: 'https://github.com/bufferapp/android-clean-architecture-boilerplate'
  }
}, {
  destination: 'buffer-clean-architecture-components-kotlin',
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
    branchName: 'master',
    url: 'https://github.com/bufferapp/clean-architecture-components-boilerplate.git'
  }
}];

each(configs, yeomanSync, function() {
  console.log('Contents for a, b and c:');
});