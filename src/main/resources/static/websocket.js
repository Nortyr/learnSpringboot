//创建 WebSocket 对象
//var Socket = new WebSocket(url, [protocol] );
var websocket=null;

if('WebSocket' in window){
    websocket=new WebSocket("ws://localhost:8080/ws");
}else{
    alert('No support websocket')
}

websocket.onerror=function () {
    appendMessage('error')
}

websocket.onopen=function (event) {
    appendMessage("open");
}

websocket.onmessage=function (ev) {
    appendMessage(ev.data)
}

websocket.onclose=function () {
    appendMessage('close')
}

window.onbeforeunload=function () {
    websocket.close();
}

function appendMessage(message) {
    var context=$("#context").html()+"<br/>"+message;
    $("#context").html(context);
}

function closeWebSocket() {
    websocket.close();
}

function sendMessage() {
    var message=$("#message").val();
    websocket.send(message);
}