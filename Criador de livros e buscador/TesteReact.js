const webpack = require("webpack)
eg
module.exports ={
    entry'./index.jsx',
    output: {
        path:_dirname + '/public',
        filename: './budle.js,
    },
    devServer: {
        port: 8080,
        contenBase: '/public',
    },
    module: {
        loaders:[{
            test: /.jsx?$/,
            loader: 'babel=loader',
            exclude: /node-modules/,
            query: {
                presets:['es2018', 'react']
            }
        }]
    }
}