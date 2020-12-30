<%@ page session="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
</body>

<script>

    var url = "ws://" + window.location.host + "/websocket/marco";

    //打开链接
    var socket = new WebSocket(url);
    //sockjs
    // var socket = new SockJS(url);

    //处理连接开启
    socket.onopen = function () {
        console.log("Opening");
        sayMarco();
    }

    //处理消息
    socket.onmessage = function (e) {
        console.log("Received message:" + e.data);
        setTimeout(function () {
            sayMarco()
        }, 2000);
    }

    //处理关闭
    socket.onclose = function () {
        console.log("Closing");
    }

    function sayMarco() {
        console.log("Sending Marco!");
        socket.send("Marco!");
    }
</script>
</html>
