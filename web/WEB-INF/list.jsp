<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/11/2020
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <a href="/list?action=add">Add new Product</a>
    <table>
        <tr>
            <th>#</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Amount</th>
            <th>Color</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${listProduct}" var="product">
            <tr>
                <td>${product.getProductId}</td>
                <td>${product.getProductName}</td>
                <td>${product.getPrice}</td>
                <td>${product.getAmount}</td>
                <td>${product.getColor}</td>
                <td>${product.getCategory}</td>
                <td>
                    <a href="/list?action=delete&&id=${product.getpId}"><button type="button" value="delete"></button></a>
                    <a href="/list?action=edit&&id=${product.getpId}"><button type="button" value="edit"></button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
