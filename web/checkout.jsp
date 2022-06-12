<%-- 
    Document   : checkout
    Created on : Mar 18, 2022, 12:20:07 AM
    Author     : Tra My
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    <jsp:include page="Menu.jsp"></jsp:include>
        <!--Product section-->
        <section class="py-5">
            <div class="container" style="min-height: 500px"">
                <div class="row">
                    <h1>Check Out</h1>
                    
                <div class="col-md-5" style="border: 1px solid #ccc; border-radius: 5px; padding: 1rem">
                    <h3>Information</h3>
                    <form action="checkout" method="post">
                        <div class="mb-3">
                            <label for="name" class="form-label">Your name</label>
                            <input type="text" class="form-control" id="name" name="name" aria-describedby="emailHelp">
                            <!--<div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>-->
                        </div>
                        <div class="mb-3">
                            <label for="phone" class="form-label">Your phone number</label>
                            <input type="text" class="form-control" id="phone" name="phone" aria-describedby="emailHelp">                           
                        </div>
                        <div class="mb-3">
                            <label for="address" class="form-label">Your address</label>
                            <input type="text" class="form-control" id="address" name="address" aria-describedby="emailHelp">                           
                        </div>
                        <div class="mb-3">
                            <label for="note" class="form-label">Note:</label>
                            <textarea class="form-control" id="note" name="note" rows="3"></textarea>
                        </div>
                        <button type="submit" class="btn w-100" style="background-color:  #66BB6A; color: white">Order</button>
                    </form>
                </div>
                    <div class="col-md-7" style="border: 1px solid #ccc; border-radius: 5px; padding: 1rem">
                        <h3>Your order</h3>
                        <table class="table" >
                            <thead class="table" style="background-color: #66BB6A; color: white">
                            <th scope="col">#</th>
                            <th scope="col">Image</th>
                            <th scope="col">Name</th>
                            <th scope="col">Price</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Total Price</th>

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

                                </tr>
                            </form>
                        </c:forEach>
                        </tbody>
                    </table>
                    <h3>Total Bill: ${totalMoney}00</h3>

                </div>
            </div>
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


