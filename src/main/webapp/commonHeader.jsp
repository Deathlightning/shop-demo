<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .commonHeader {
            background-color: #32363a;
            height: 40px;
            padding-left: 15px;
            padding-top: 10px;
        }

        .commonHeader .title {
            color: white;
            font-size: 20px;
        }
    </style>
</head>

<body>
<div class="commonHeader">
    <div class="title" onclick="toIndex()">购物商城</div>
</div>
</body>
<script>
    function toIndex() {
        window.location.href = '<%=request.getContextPath()%>/index.jsp';
    }
</script>
</html>
