var each = require('async-each');
const yeomanSync = require('yeoman-sync');

let configs = [{
  destination: 'googlesamples-mvp',
  rename: [{
    dest: 'gitignore',
    src: 'todoapp/.gitignore'
  }, {
    dest: 'app/gitignore',
    src: 'todoapp/app/.gitignore'
  }],
  replace: [{
    regex: 'com.example.android.architecture.blueprints.todoapp',
    replacement: '<%= appPackage %>'
  }],
  repo: {
    branchName: 'todo-mvp',
    url: 'https://github.com/googlesamples/android-architecture'
  }
}, {
  destination: 'googlesamples-mvp-dagger',
  rename: [{
    dest: 'gitignore',
    src: 'todoapp/.gitignore'
  }, {
    dest: 'app/gitignore',
    src: 'todoapp/app/.gitignore'
  }],
  replace: [{
    regex: 'com.example.android.architecture.blueprints.todoapp',
    replacement: '<%= appPackage %>'
  }],
  repo: {
    branchName: 'todo-mvp-dagger',
    url: 'https://github.com/googlesamples/android-architecture'
  }
}, {
  destination: 'googlesamples-mvp-clean',
  rename: [{
    dest: 'gitignore',
    src: 'todoapp/.gitignore'
  }, {
    dest: 'app/gitignore',
    src: 'todoapp/app/.gitignore'
  }],
  replace: [{
    regex: 'com.example.android.architecture.blueprints.todoapp',
    replacement: '<%= appPackage %>'
  }],
  repo: {
    branchName: 'todo-mvp-clean',
    url: 'https://github.com/googlesamples/android-architecture'
  }
}, {
  destination: 'googlesamples-mvp-rxjava',
  rename: [{
    dest: 'gitignore',
    src: 'todoapp/.gitignore'
  }, {
    dest: 'app/gitignore',
    src: 'todoapp/app/.gitignore'
  }],
  replace: [{
    regex: 'com.example.android.architecture.blueprints.todoapp',
    replacement: '<%= appPackage %>'
  }],
  repo: {
    branchName: 'todo-mvp-rxjava',
    url: 'https://github.com/googlesamples/android-architecture'
  }
}, {
  destination: 'googlesamples-mvvm-databinding',
  rename: [{
    dest: 'gitignore',
    src: 'todoapp/.gitignore'
  }, {
    dest: 'app/gitignore',
    src: 'todoapp/app/.gitignore'
  }],
  replace: [{
    regex: 'com.example.android.architecture.blueprints.todoapp',
    replacement: '<%= appPackage %>'
  }],
  repo: {
    branchName: 'todo-mvvm-databinding',
    url: 'https://github.com/googlesamples/android-architecture'
  }
}, {
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
  destination: 'mvp-arms',
  rename: [{
    dest: 'gitignore',
    src: '.gitignore'
  }, {
    dest: 'app/gitignore',
    src: 'app/.gitignore'
  }],
  replace: [{
    regex: 'me.jessyan.mvparms.demo',
    replacement: '<%= appPackage %>'
  }],
  repo: {
    branchName: 'master',
    url: 'https://github.com/JessYanCoding/MVPArms.git'
  }
}, {
  destination: 'mvvm-arms',
  rename: [{
    dest: 'gitignore',
    src: '.gitignore'
  }, {
    dest: 'arms/gitignore',
    src: 'arms/.gitignore'
  }, {
    dest: 'lifecycle/gitignore',
    src: 'lifecycle/.gitignore'
  }, {
    dest: 'repository/gitignore',
    src: 'repository/.gitignore'
  }, {
    dest: 'weather/gitignore',
    src: 'weather/.gitignore'
  }],
  replace: [{
    regex: 'me.xiaobailong24.mvvmarms',
    replacement: '<%= appPackage %>'
  }],
  repo: {
    branchName: 'master',
    url: 'https://github.com/xiaobailong24/MVVMArms.git'
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
  destination: 'mindorks-mvp',
  rename: [{
    dest: 'gitignore',
    src: '.gitignore'
  }, {
    dest: 'app/gitignore',
    src: 'app/.gitignore'
  }],
  replace: [{
    regex: 'com.mindorks.framework.mvp',
    replacement: '<%= appPackage %>'
  }],
  repo: {
    branchName: 'master',
    url: 'https://github.com/MindorksOpenSource/android-mvp-architecture'
  }
}, {
  destination: 'jshvarts-offline',
  rename: [{
    dest: 'gitignore',
    src: '.gitignore'
  }, {
    dest: 'app/gitignore',
    src: 'app/.gitignore'
  }],
  replace: [{
    regex: 'com.example.offline',
    replacement: '<%= appPackage %>'
  }],
  repo: {
    branchName: 'master',
    url: 'https://github.com/jshvarts/OfflineSampleApp'
  }
}, {
  destination: 'mindorks-mvp-interactor',
  rename: [{
    dest: 'gitignore',
    src: '.gitignore'
  }, {
    dest: 'app/gitignore',
    src: 'app/.gitignore'
  }],
  replace: [{
    regex: 'com.mindorks.framework.mvp',
    replacement: '<%= appPackage %>'
  }],
  repo: {
    branchName: 'master',
    url: 'https://github.com/MindorksOpenSource/android-mvp-interactor-architecture'
  }
}, {
  destination: 'mindorks-mvvm',
  rename: [{
    dest: 'gitignore',
    src: '.gitignore'
  }, {
    dest: 'app/gitignore',
    src: 'app/.gitignore'
  }],
  replace: [{
    regex: 'com.mindorks.framework.mvvm',
    replacement: '<%= appPackage %>'
  }],
  repo: {
    branchName: 'master',
    url: 'https://github.com/MindorksOpenSource/android-mvvm-architecture'
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