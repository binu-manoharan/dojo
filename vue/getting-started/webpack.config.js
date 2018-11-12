const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CleanWebpackPlugin = require('clean-webpack-plugin');
const ManifestPlugin = require('webpack-manifest-plugin');
const webpack = require('webpack');

module.exports = {
    mode: 'development',
    entry: { 
        app: './src/index.js'
    },
    devtool: 'inline-source-map',
    devServer: {
        contentBase: './dist',
        port: 9000,
        compress: true,
        hot: true
    },
    plugins: [
        new CleanWebpackPlugin(['dist']),
        new ManifestPlugin(),
        new HtmlWebpackPlugin({
            title: 'Hot module replacement'
        }),
        new webpack.HotModuleReplacementPlugin()
    ],
    output: {
        filename: '[name].bundle.js',
        path: path.resolve(__dirname, 'dist')
    }
};