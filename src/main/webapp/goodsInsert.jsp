<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>商品管理</title>
    <link href="css/common.css">
    <link href="css/bootstrap.min.css">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style>
        * {
            margin: 0;
            padding: 0;
            background-color: #ECEEF1;
        }
    </style>
</head>
<body>
<div class="commonHeader">
    <div style="font-size: 20px;color: black">购物商城</div>
</div>
<form action="${pageContext.request.contextPath}/good/insert" method="post">
    <div class="form-group">
        <label for="username">商品名称</label>
        <input type="text" class="form-control" id="username" name="name" required>
    </div>
    <div class="form-group">
        <label for="goodType">商品分类</label>
        <input type="text" class="form-control" id="goodType" required>
    </div>
    <div class="form-group">
        <label for="number">数量</label>
        <input type="number" class="form-control" id="number" required name="number">
    </div>
    <div class="form-group">
        <label for="price">价格</label>
        <input type="number" class="form-control" id="price" required name="price">
    </div>
    <div class="form-group">
        <label for="description">描述</label>
        <textarea class="form-control" rows="3" id="description" name="description"></textarea>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
</body>
</html>
