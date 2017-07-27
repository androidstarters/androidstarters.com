var path = require('path');
var webpack = require('webpack');
const ExtractTextPlugin = require('extract-text-webpack-plugin');

const extractSass = new ExtractTextPlugin({
    filename: "css/[name].css",
    disable: process.env.NODE_ENV === "development"
});

var HtmlWebpackPlugin = require('html-webpack-plugin');
var BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin;

module.exports = {
    entry: './src/main.js',
    output: {
        filename: 'js/main.js',
        path: path.resolve(__dirname, 'public')
    },
    plugins: [
        new BundleAnalyzerPlugin(),
        new webpack.LoaderOptionsPlugin({
          minimize: true,
          debug: false
        }),
        new webpack.optimize.UglifyJsPlugin({
          beautify: false,
          pure_getters: true,
          mangle: {
            screw_ie8: true,
            keep_fnames: true
          },
          compress: {
            screw_ie8: true
          },
          comments: false,
          exclude: [/\.min\.js$/gi] // skip pre-minified libs
        })
    ],
    module: {

        loaders: [
          {
            test: /\.scss$/,
            exclude: /(node_modules|bower_components)/,
            use: extractSass.extract({
                use: [{
                    loader: "css-loader?-minimize"
                }, {
                    loader: "sass-loader"
                }]
            })
          },
          {
            test: /\.js$/,
            loader: 'babel-loader',
            query: {
                presets: ['es2015']
            }
          }
        ],
    },
    resolve: {
        extensions: ['js'],
        // fallback: [path.join(__dirname, '../node_modules')],
        alias: {
          'vue': 'vue/dist/vue.common.js'
        }
    },
    plugins: [
        extractSass
    ],
    devtool: 'cheap-module-source-map'
}