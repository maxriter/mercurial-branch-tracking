const path = require('path');

const OUTPUT_DIR = path.join(__dirname, '../../../target/classes/static');

module.exports = {
    entry: "./components/MainComponent",
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
        }]
    },
    resolve: {
        extensions: ['', '.js', '.jsx']
    }
};
                                                                                                                    
