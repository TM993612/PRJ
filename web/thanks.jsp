<%-- 
    Document   : checkout
    Created on : Mar 18, 2022, 12:20:07 AM
    Author     : Tra My
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="Menu.jsp"></jsp:include>

            <!--    <div class="container " style="min-height: 500px">
                <div class="alert alert-warning" role="alert" >
                        Order successfully! Thanks for ordering!
                        <div class="text-center mt-5 ">
                        <a class="btn btn-outline-primary" href="home">Continue Shopping</a>
                        </div>
                    </div>
            </div>-->

            <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,400i,700,900&display=swap" rel="stylesheet">

        </head>

        <style>
            .thanks {
                text-align: center;
                padding: 40px 0;
                background: #EBF0F5;
            }
            .sucess {
                color: #88B04B;
                font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
                font-weight: 900;
                font-size: 40px;
                margin-bottom: 10px;
            }
            .mess {
                color: #404F5E;
                font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
                font-size:20px;
                margin: 0;
            }
            .checkmark {
                color: #9ABC66;
                font-size: 100px;
                line-height: 200px;
                margin-left:-15px;
            }
            .card {
                background: white;
                padding: 60px;
                border-radius: 4px;
                box-shadow: 0 2px 3px #C8D0D8;
                display: inline-block;
                margin: 0 auto;
            }
        </style>
        <body class="thanks">

            <div class="card">
                <div style="border-radius:200px; height:200px; width:200px; background: #F8FAF5; margin:0 auto;">
                    <i class="checkmark">✓</i>
                </div>
                <h1 class="sucess">Order successfully!</h1> 
                <p class="mess">Thank you very much</p>
                <a class="btn btn-outline-success" href="home">Continue to Buy</a>
            </div>
            <div class="text-center w-100 ">

            </div>




            <!-- Footer-->
        <jsp:include page="Footer.jsp"></jsp:include>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>


