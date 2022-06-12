<%-- 
    Document   : Detail
    Created on : Mar 17, 2022, 8:46:10 PM
    Author     : Tra My
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <jsp:include page="Menu.jsp"></jsp:include>
        <!-- Product section-->
        <section class="py-5">
            <div class="container" style="min-height: 500px"">
            <c:choose>
                <c:when test="${sessionScope.carts == null || sessionScope.carts.size()==0}">
                    <h1>Cart is empty, no products</h1>
                    <a class="btn btn-outline-success" href="home">Back to Home</a>
                </c:when>
                <c:otherwise>
                    <h3>Your cart</h3>
                    <table class="table" >
                        <thead class="table" style="background-color: #66BB6A; color: white">
                        <th scope="col">#</th>
                        <th scope="col">Image</th>
                        <th scope="col">Name</th>
                        <th scope="col">Price</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Total Price</th>
                        <th scope="col">Delete</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${carts}" var="c">
                            <form action="updateQuantity">
                                <tr>
                                <input type="hidden" name="productId" value="${c.value.product.productID}"/>
                                    <th scope="row">${c.value.product.productID}</th>
                                    <td><img src = "${c.value.product.picture}" width = "50"/></td>
                                    <td>${c.value.product.productName}</td>
                                    <td>${c.value.product.price}.000</td>
                                    <td><input onchange="this.form.submit()" type="number" name="quantity" value="${c.value.quantity}"/></td>
                                    <td>${c.value.product.price*c.value.quantity}.000</td>
                                    <td><a href="deleteCart?productId=${c.value.product.productID}" class="btn btn-outline-danger"><i class="bi bi-trash-fill"></i></a></td>
                                </tr>
                            </form>
                            </c:forEach>
                        </tbody>
                    </table>
                    <h3 style="">Total Bill: ${totalMoney}00</h3>
                    <a href="checkout" class="btn w-25" style="background-color:  #66BB6A; color: white">Check out</a>
                </c:otherwise>
            </c:choose>


        </div>
    </section>

    <!-- Footer-->
    <jsp:include page="Footer.jsp"></jsp:include>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
</body>
</html>