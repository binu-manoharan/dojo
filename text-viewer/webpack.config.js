const path = require('path')

module.exports = {
    entry: './src/greeter.ts',
    module: {
        rules: [
            {
                use: 'ts-loader',
                exclude: '/node_modules/'
            }
        ]
    },
    output: {
        path: path.resolve(__dirname, 'dist'),
        filename: 'bundle.js'
    }
}