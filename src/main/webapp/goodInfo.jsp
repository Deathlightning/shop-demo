<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商品详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/notify.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/notify.js"></script>
    <style>
        body {
            margin: 0;
            padding: 0;
            height: 100%;
            width: 100%;
        }

        .img-box {
            width: 180px;
            height: 180px;
            cursor: pointer;
        }

        table {
            margin: 0 auto;
        }

        .bottom {
            display: flex;
            margin-top: 20px;
            justify-content: center;
        }
    </style>
</head>
<body>
<div style="text-align: center">header</div>
<div>
    <div style="display: flex;justify-content: space-around;margin-top: 20px;">
        <div class="img-box">
            <img src="${good.photos[0]}?imageView2/1/w/180/h/180" alt="">
        </div>
        <div class="img-box">
            <img src="${good.photos[1]}?imageView2/1/w/180/h/180" alt="">
        </div>
        <div class="img-box">
            <img src="${good.photos[2]}?imageView2/1/w/180/h/180" alt="">
        </div>
        <div class="img-box">
            <img src="${good.photos[3]}?imageView2/1/w/180/h/180" alt="">
        </div>
    </div>
    <div style="display: flex;justify-content: space-around;margin-top: 15px;font-size: 18px">
        <div>主图</div>
        <div>侧图1</div>
        <div>侧图2</div>
        <div>侧图3</div>
    </div>
    <hr>
</div>
<div style="display: flex;padding-left: 20px">
    <button class="btn btn-primary" onclick="insertShopCart(${good.id})">&nbsp;加入购物车&nbsp;</button>&nbsp;&nbsp;
    <button class="btn btn-primary" onclick="window.location.href='${pageContext.request.contextPath}/goodList'">
        &nbsp;返回&nbsp;
    </button>
</div>
<div class="bottom">
    <div style="width: 50%;padding-left: 20px">
        <table class="table" id="table">
            <tr>
                <td>属性</td>
                <td>属性值</td>
            </tr>
            <tr>
                <td>商品名称</td>
                <td>${good.name}</td>
            </tr>
            <tr>
                <td>商品类别</td>
                <td>${good.classify}</td>
            </tr>
            <tr>
                <td>商品库存</td>
                <td>${good.number}</td>
            </tr>
            <tr>
                <td>商品价格</td>
                <td>${good.price}</td>
            </tr>
            <c:forEach items="${good.attribuesMap}" var="item">
                <tr>
                    <td>${item.key}</td>
                    <td>${item.value}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>
</body>
<script>
    function insertShopCart(id) {
        const url = '${pageContext.request.contextPath}/insertShoppingCartController';
        $.ajax({
            url: url,
            type: "post",
            data: {goodId: id},
            success: function (data) {
                window.console.log(data);
                notify('success', '加入购物车成功');
                window.console.log('success');
            },
            error: function (error) {
                window.console.log(error)
            }
        });
    }

</script>
</html>

