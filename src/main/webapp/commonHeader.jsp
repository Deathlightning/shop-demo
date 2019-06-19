<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        .header {
            background-color: #32363a;
            display: flex;
            justify-content: space-between;
            margin-bottom: 15px;
        }

        .header .user-info {
            display: flex;
            margin-right: 20px;
        }

        .header .img-box {
            width: 60px;
            height: 60px;
            margin-left: 20px;
        }

        .header .title {
            color: white;
            font-size: 18px;
            padding-top: 20px;
            padding-left: 10px;
            cursor: pointer;
        }

        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 100px;
            box-shadow: 0px 8px 16px 0 rgba(0, 0, 0, 0.2);
            padding: 5px 5px 5px 10px;
            z-index: 1;
            margin-top: 15px;
            right: 15px;
        }

        .dropdown.dropdown:hover .dropdown-content {
            display: block;
        }

        .dropdown .dropdown-item {
            cursor: pointer;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="header">
    <div style="display: flex">
        <div class="img-box">
            <img src="http://kingsword.xyz/1556286028072.png" alt="">
        </div>
        <div class="title" onclick="window.location.href='${pageContext.request.contextPath}/goodList'">购物商城</div>
    </div>
    <div class="user-info">
        <div class="img-box" style="padding-top: 5px"><img src="http://kingsword.xyz/1559742039848.png" alt=""></div>
        <div class="dropdown">
            <div class="title"><c:out value="${user.username}" default="游客"/></div>
            <div class="dropdown-content" style="font-size: 18px">
                <c:choose>
                    <c:when test="${user!=null}">
                        <div class="dropdown-item"
                             onclick="window.location.href='${pageContext.request.contextPath}/resetPassword.html'">修改密码
                        </div>
                        <div class="dropdown-item"
                             onclick="window.location.href='${pageContext.request.contextPath}/logout'">我的地址
                        </div>
                        <div class="dropdown-item"
                             onclick="window.location.href='${pageContext.request.contextPath}/logout'">我的订单
                        </div>
                        <div class="dropdown-item"
                             onclick="window.location.href='${pageContext.request.contextPath}/logout'">退出
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="dropdown-item"
                             onclick="window.location.href='${pageContext.request.contextPath}/login.html'">登录
                        </div>
                        <div class="dropdown-item"
                             onclick="window.location.href='${pageContext.request.contextPath}/register.html'">注册
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>

</body>
</html>