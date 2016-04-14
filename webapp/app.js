// app.js
var http = require('http');
var koa = require('koa');
var serve = require('koa-static');
//var path = '.';
var app = koa();
var debug = process.env.NODE_ENV !== 'production';
// ��������������������Ӧ��ͬ��Ŀ¼
var viewDir = debug ? 'src' : 'assets';

// ����̬��Դ������ļ�
//app.use(serve(path.resolve(__dirname, viewDir), {
 //   maxage: 0
//}));

app = http.createServer(app.callback());

app.listen(3005, '0.0.0.0', function() {
    console.log('app listen success.');
});