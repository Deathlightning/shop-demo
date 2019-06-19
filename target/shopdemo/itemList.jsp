<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--index.jsp-->
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/page.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/notify.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/notify.js"></script>
    <style>
        * {
            padding: 0;
            margin: 0;
        }

        .good-box {
            height: 250px;
            overflow: hidden;
            margin-top: 15px;
        }

        .img-box {
            text-align: center;
            cursor: pointer;
        }

        .good-title {
            margin-top: 10px;
            font-size: 18px;
            text-align: center;
        }

        .wrapper {
            display: flex;
        }

        .nav {
            margin-top: 30px;
            margin-left: 15px;
            padding-left: 10px;
            padding-right: 10px;
            border-right: 1px solid red;
        }
    </style>
</head>

<body>
<%@ include file="commonHeader.jsp" %>
<div class="notify-position" hidden>
    <div style="display: flex;justify-content: center;" id="notify">
        <div class="notify-style">
            <div class="glyphicon glyphicon-ok"></div>
            <div style="margin-left: 30px;font-size: 18px;word-wrap: break-word;word-break: break-all;overflow: hidden;text-align: left">
                加入购物车成功
            </div>
        </div>
    </div>
</div>
<div class="wrapper">
    <div class="nav">
        <%@ include file="nav.jsp" %>
    </div>
    <div class="container" style="margin-left: 200px;">
        <div class="row" style="border-bottom: 1px solid #14D1D4;padding-bottom: 5px;">
            <div class="col-md-5">
                <form method="post" action="${pageContext.request.contextPath}/search">
                    <input type="text" id="search" name="name"/>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>
            </div>
            <div class="col-md-4"></div>
            <div class="col-md-3" style="cursor: pointer;font-size: 18px;margin-top: 8px;display: flex">
                <div onclick="toShoppingCart()">我的购物车</div>
            </div>
        </div>
        <div class="row">
            <c:forEach items="${requestScope.goodList}" var="item">
                <div class="col-md-3 good-box">
                    <div class="img-box" onclick="goodInfo(${item.id})">
                        <img src="${item.photos[0]}?imageView2/1/w/180/h/180" alt="" width="180px"/>
                    </div>
                    <div class="good-title">${item.name}</div>
                    <button style="margin-left: 80px;" class="btn btn-info" onclick="insertShopCart(${item.id},this)">
                        加入购物车
                    </button>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<div class="page-wrapper">
    <ul class="page-pagination">
        <li><a href="#">1</a></li>
    </ul>
    <label style="padding-top: 3px;font-size: 15px;" for="pageNum">每页展示 </label>
    <select id="pageNum">
        <option value="1">1</option>
    </select>
    <div style="margin-left: 15px;padding-top: 3px">
        <input type="number" min="1" value="1" style="width: 40px">
        <span style="cursor: pointer">提交</span>
    </div>
</div>
</body>
<script>
    function insertShopCart(id, event) {
        const url = '${pageContext.request.contextPath}/insertShoppingCartController';
        $.ajax({
            url: url,
            type: "post",
            data: {goodId: id},
            success: function (data) {
                window.console.log(data);
                notify('success', '加入购物车成功');
                window.console.log('success');
                event.disabled = true;
            },
            error: function (error) {
                window.console.log(error)
            }
        });
    }

    function toShoppingCart() {
        window.location.href = '${pageContext.request.contextPath}/shoppingCartController'
    }

    function goodInfo(id) {
        window.location.href = '${pageContext.request.contextPath}/good/goodInfoController?goodId=' + id;
    }
</script>
</html>