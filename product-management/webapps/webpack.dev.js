const path = require('path');
const merge = require('webpack-merge');
const webpackCommonConfig = require('./webpack.common.js');

// the display name of the war
const app = 'vuetify-webpack-sample';

// add the server path to your server location path
const exoServerPath = "/home/exo/work/binaries/plfent-6.3.x-maintenance-20220404.032442-1760/platform-6.3.x-maintenance-SNAPSHOT";

let config = merge(webpackCommonConfig, {
  output: {
    path: path.resolve(`${exoServerPath}/webapps/${app}/`)
  },
  devtool: 'inline-source-map'
});

module.exports = config;
