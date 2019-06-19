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
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/page.css">
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
            width: 200px;
        }

        .good-title {
            margin-top: 10px;
            font-size: 18px;
            text-align: center;
        }

        .wrapper {
            display: flex;
        }

        .shopping-cart-row {
            display: flex;
            align-items: center;
            margin-top: 15px;
            border-bottom: 1px gray solid;
            padding-bottom: 10px;
        }
    </style>
</head>

<body>
<%@ include file="commonHeader.jsp" %>
<div class="wrapper">
    <%@ include file="nav.jsp" %>
    <div class="container" style="margin-left: 200px;">
        <div class="row" style="border-bottom: 1px solid #14D1D4;padding-bottom: 5px;">
            <div class="col-md-5">
                <form>
                    <input type="text" id="search" name="goodName"/>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>
            </div>
            <div class="col-md-4"></div>
            <div class="col-md-3" style="cursor: pointer;font-size: 18px;margin-top: 8px;display: flex">
                <div onclick="toShoppingCart()">我的购物车</div>
            </div>
        </div>
        <form action="">
        <c:forEach var="item" items="${requestScope.goodsList}">
            <div class="row shopping-cart-row">
                <div class="col-md-3">
                    <div class="img-box" onclick="goodInfo(${item.id})">
                        <img src="${item.photos[0]}" alt="" style="width: 100%"/>
                    </div>
                </div>
                <div class="col-md-3">
                    <div style="font-size: 20px;">${item.name}</div>
                </div>
                <div class="col-md-3">
                    <div style="font-size: 20px;">
                        <label for="nums">数量</label>
                        <input type="number" name="nums" id="nums" value="1" min="1" max="${item.number}"
                               onchange="sum(${item.price},this.value)"
                               style="width: 100px">
                    </div>
                </div>
                <div class="col-md-3">
                    <button class="btn btn-danger" type="submit" onclick="deleteById(${item.id})">删除</button>
                </div>
            </div>
        </c:forEach>
        </form>
        <div style="display: flex;justify-content: flex-end;align-items: center">
            <div style="font-size: 18px;margin-top: 15px;">共计：<c:out value="${requestScope.sumPrice}" default="0"/>￥
            </div>
            <button class="btn btn-default" style="margin-top: 15px;width: 100px;margin-left: 15px;">结算</button>
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
    function deleteById(id) {
        const url = '${pageContext.request.contextPath}/deleteShoppingCartController';
        $.ajax({
            url: url,
            type: "post",
            data: {goodId: id},
            success: function (data) {
                window.console.log(data);
                window.location.reload()
            },
            error: function (error) {
                window.console.log(error)
            }
        });
    }

    function sum(price, number) {
        console.log(price + " " + number);
    }

</script>
</html>