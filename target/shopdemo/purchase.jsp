<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--index.jsp-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="commonHeader.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <%--    <link rel="stylesheet" href="css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="css/page.css">
    <link rel="stylesheet" href="css/notify.css">
    <script src="js/jquery-3.3.1.min.js"></script>
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

        .nav-title {
            margin-top: 5px;
            font-size: 18px;
            cursor: pointer;
        }
    </style>
</head>

<body>
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
        <c:forEach items="${requestScope.classifyList}" var="item">
            <div class="nav-title">${item}</div>
        </c:forEach>
    </div>
    <div class="container" style="margin-left: 200px;">
        <div class="row" style="border-bottom: 1px solid #14D1D4;padding-bottom: 5px;">
            <div class="col-md-5">
                <form>
                    <input type="text" id="search" name="goodName"/>
                    <%--                    <select name="type" id="" style="height: 26px;">--%>
                    <%--                        <option value="1">商品类别一</option>--%>
                    <%--                        <option value="1">商品类别一</option>--%>
                    <%--                        <option value="1">商品类别一</option>--%>
                    <%--                        <option value="1">商品类别一</option>--%>
                    <%--                    </select>--%>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>
            </div>
            <div class="col-md-4"></div>
            <div class="col-md-3" style="cursor: pointer;font-size: 18px;margin-top: 8px;display: flex">
                <div onclick="toShoppingCart()">我的购物车</div>
                <div style="margin-left: 15px">游客</div>
            </div>
        </div>
        <div class="row">
            <c:forEach items="${requestScope.goodList}" var="item">
                <div class="col-md-3 good-box">
                    <div class="img-box">
                        <img src="${item.imgUrl}" alt=""/>
                    </div>
                    <div class="good-title">${item.name}</div>
                    <button style="margin-left: 80px;" class="btn btn-info" onclick="insertShopCart(${item.id})">加入购物车
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
    function insertShopCart(id) {
        var url = '${pageContext.request.contextPath}/insertShoppingCartController';
        $.ajax({
            url: url,
            type: "post",
            data: {goodId: id},
            success: function (data) {
                window.console.log(data);
                notifyMe();
                window.console.log('success');
            },
            error: function (error) {
                window.console.log(error)
            }
        });
    }

    function toShoppingCart() {
        window.location.href = '${pageContext.request.contextPath}/shoppingCartController'
    }

    function notifyMe() {
        var dom = document.getElementById('notify');
        dom.parentElement.hidden = false;
        dom.classList.add('notify');
        window.setTimeout(function () {
            dom.parentElement.hidden = true;
            dom.classList.remove('notify');
        }, 1000);
    }
</script>
</html>