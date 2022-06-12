<%-- 
    Document   : Home
    Created on : Mar 13, 2022, 10:35:22 PM
    Author     : Tra My
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
 
<!--
    
TemplateMo 559 Zay Shop

https://templatemo.com/tm-559-zay-shop

-->
</head>
<jsp:include page="Menu.jsp"></jsp:include>
<body>
    

     <!-- Start Content -->
    <div class="container py-5">
        <div class="row">

            <div class="col-lg-3">
                <h1 class="h2 pb-4">Categories</h1>
                <ul class="list-unstyled templatemo-accordion">
                <c:forEach items="${listC}" var="c">
                    <ul class="list-group">
                        <li class="list-group-item ${cateID == c.categoryID? "active":""}"><a href="filterByCategory?categoryId=${c.categoryID}">${c.categoryName}</a></li>
                        
                    </li>
                </c:forEach>
                    
                   
                    
                </ul>
                    </ul>
            </div>

            <div class="col-lg-9">
                <div class="row">
                    <div class="col-md-6">
                        <ul class="list-inline shop-top-menu pb-3 pt-1">
                            <li class="list-inline-item">
                                <a class="h3 text-dark text-decoration-none mr-3" href="#">Product</a>
                            </li>
                            
                        </ul>
                    </div>
<!--                    <div class="col-md-6 pb-4">
                        <div class="d-flex">
                            <select class="form-control">
                                <option>Featured</option>
                                <option>A to Z</option>
                                <option>Item</option>
                            </select>
                        </div>
                    </div>-->
                </div>
                <div class="row">
                    <c:forEach items="${listP}" var="p">
                    <div class="col-md-4">
                        <div class="card mb-4 product-wap rounded-0">
                            <div class="card rounded-0">
                                <img class="card-img rounded-0 img-fluid" src="${p.picture}">
                                <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
                                    <ul class="list-unstyled">
                                        <li><a class="btn btn-success text-white mt-2" href="detail?productId=${p.productID}"><i class="far fa-eye"></i></a></li>
                                        <li><a class="btn btn-success text-white mt-2" href="addToCart?productId=${p.productID}"><i class="fas fa-cart-plus"></i></a></li>
                                        <!--<li><a class="btn btn-success text-white mt-2" onclick="addToCartAsync(${p.productID})"><i class="fas fa-cart-plus"></i></a></li>-->
                                    </ul>
                                </div>
                            </div>
                            <div class="card-body">
                                <a href="shop-single.html" class="h3 text-decoration-none">${p.productName}</a>
                                <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
                                    <!--<li>M/L/X/XL</li>-->
                                    <li class="pt-2">
                                        <span class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
                                    </li>
                                </ul>

                                <p class="text-center mb-0">${p.price}.000</p>
                            </div>
                        </div>
                    </div>
                        </c:forEach>
     
                <div div="row">
                     <nav aria-label="Page navigation example " class="d-flex justify-content-center">
                        <ul class="pagination">
                            <c:if test="${tag >1}">

                                <li class="page-item">
                                    <a class="page-link" href="home?index=${tag-1}" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:forEach begin="1" end="${endP}" var="i">
                                <li class="page-item ${tag == i?"active":""}"><a class="page-link" href="home?index=${i}">${i}</a></li>
                                </c:forEach>

                            <c:if test="${tag < endP}">
                                <li class="page-item">
                                    <a class="page-link" href="home?index=${tag+1}" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
            </div>

        </div>
    </div>
    <!-- End Content -->



    

    
    <!-- Start Script -->
    <script src="assets/js/jquery-1.11.0.min.js"></script>
    <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/templatemo.js"></script>
    <script src="assets/js/custom.js"></script>
    <!-- End Script -->
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
    <!--Axios-->
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script>
                                                      function addToCartAsync(productId) {
                                                          axios.get('addToCart-async', {
                                                              params: {
                                                                  productId: productId
                                                              }
                                                          }).then((response) => {
                                                              //lay data thanh cong
                                                              document.getElementById("cart-number").innerHTML = response.data;
                                                              //cap nhat view
                                                          })
                                                      }
    </script>
</body>
<jsp:include page="Footer.jsp"></jsp:include>
</html>
