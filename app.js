/**
 * Module dependencies.
 */
const express = require('express');
const bodyParser = require('body-parser');
const logger = require('morgan');
const chalk = require('chalk');
const dotenv = require('dotenv');
const sass = require('node-sass-middleware');
const path = require('path');
const androidstarters = require('androidstarters');
const merge = require('lodash.merge');
const rimraf = require('rimraf');
const Mixpanel = require('mixpanel');
const mixpanel = Mixpanel.init(process.env.MIXPANEL_API_KEY);



/**
 * Load environment variables from .env file, where API keys and passwords are configured.
 */
dotenv.load({
	path: '.env.example'
});

/**
 * Controllers (route handlers).
 */

/**
 * Create Express server.
 */
const app = express();

/**
 * Express configuration.
 */
app.set('port', process.env.PORT || 3000);
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');
app.use(sass({
	src: path.join(__dirname, 'public'),
	dest: path.join(__dirname, 'public')
}));
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
	extended: true
}));
app.use(express.static(path.join(__dirname, 'public'), {
	maxAge: 31557600000
}));

/**
 * Primary app routes.
 */
app.get('/', (req, res) => {
	res.render('home', {
		title: 'Home'
	});
});

app.post('/download', (req, res) => {

	var config = {
		appName: req.body.appName,
		packageName: req.body.packageName,
		templateName: req.body.templateName,
		props: {
			appPackage: req.body.packageName
		}
	};

	mixpanel.track("Download", config);

	const templateConfig = require('./config/' + config.templateName + '.json');

	config.packageDir = config.packageName.replace(/\./g, '/');
	config.templatePath = process.env.PWD + '/templates/' + config.templateName + '/';
	config = merge(config, templateConfig);
	config.appPath = path.join(__dirname, config.appName + '/');

	androidstarters(config, function(filePath) {
		var file = path.join(__dirname, filePath);
		res.download(file, function(err) {
			if (err) {
				console.log("Error");
				console.log(err);
			} else {
				console.log("Success");
				rimraf.sync(file);
			}
		});
	});
});

/**
 * Start Express server.
 */
app.listen(app.get('port'), () => {
	console.log('%s App is running at http://localhost:%d in %s mode', chalk.green('✓'), app.get('port'), app.get('env')); 
	console.log('  Press CTRL-C to stop\n');
});

module.exports = app;