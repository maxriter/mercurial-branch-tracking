const path = require('path');

const OUTPUT_DIR = path.join(__dirname, '../../../target/classes/static');

module.exports = {
    entry: "./index.js",
    output: {
        path: OUTPUT_DIR,
        publicPath: '',
        filename: 'bundle.js'
    },
    module: {
        loaders: [{
            exclude: /node_modules/,
            loader: 'babel'
        }, {
            test: /\.css$/,
            loader: 'style!css'
        }, {
            test: /\.tsx?$/,
            loader: "ts-loader",
            exclude: /node_modules/
        }]
    },
    resolve: {
        extensions: ['', '.js', '.jsx', '.tsx', '.ts']
    }
};
                                                                                                                    
