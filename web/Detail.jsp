<%-- 
    Document   : Detail
    Created on : Mar 17, 2022, 8:46:10 PM
    Author     : Tra My
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <jsp:include page="Menu.jsp"></jsp:include>
        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <%--<c:forEach items="${}" var="p">--%>
                        <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="${detail.picture}" alt="..." /></div>
                        <div class="col-md-6">
                            <!--<div class="small mb-1">SKU: BST-498</div>-->
                            <h1 class="display-5 fw-bolder">${detail.productName}</h1>
                            <div class="fs-5 mb-5">
                                <!--<span class="text-decoration-line-through">$45</span>-->
                                <span>${detail.price}.000</span>
                            </div>
                            <p class="lead">${detail.desc}</p>
                            <div class="d-flex">
                                <!--<input class="form-control text-center me-3" id="inputQuantity" type="num" value="1" style="max-width: 3rem" />-->
                                <button class="btn btn-outline-success mt-auto" type="button">
                                    <i class="bi-cart-fill me-1"></i>
                                    <a href="addToCart?productId=${detail.productID}"style=" color: red;"> Add to cart</a>
                                </button>
                            </div>
                        </div>
                    <%--</c:forEach>--%>
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

