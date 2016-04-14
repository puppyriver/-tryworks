// app.js
var http = require('http');
var koa = require('koa');
var serve = require('koa-static');
//var path = '.';
var app = koa();
var debug = process.env.NODE_ENV !== 'production';
// 开发环境和生产环境对应不同的目录
var viewDir = debug ? 'src' : 'assets';

// 处理静态资源和入口文件
//app.use(serve(path.resolve(__dirname, viewDir), {
 //   maxage: 0
//}));

app = http.createServer(app.callback());

app.listen(3005, '0.0.0.0', function() {
    console.log('app listen success.');
});