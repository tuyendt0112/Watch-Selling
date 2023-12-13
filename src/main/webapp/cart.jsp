<%-- 
    Document   : cart
    Created on : Nov 25, 2022, 10:34:44 PM
    Author     : Legion
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zxx">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>DeBugBoy Shop</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="manifest" href="site.webmanifest">
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

        <!-- CSS here -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/css/flaticon.css">
        <link rel="stylesheet" href="assets/css/slicknav.css">
        <link rel="stylesheet" href="assets/css/animate.min.css">
        <link rel="stylesheet" href="assets/css/magnific-popup.css">
        <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
        <link rel="stylesheet" href="assets/css/themify-icons.css">
        <link rel="stylesheet" href="assets/css/slick.css">
        <link rel="stylesheet" href="assets/css/nice-select.css">
        <link rel="stylesheet" href="assets/css/style.css">
    </head>

    <body>
        <jsp:include page = "header.jsp" ></jsp:include>
            <main>
                <!-- Hero Area Start-->
                <div class="slider-area ">
                    <div class="single-slider slider-height2 d-flex align-items-center">
                        <div class="container">
                            <div class="row">
                                <div class="col-xl-12">
                                    <div class="hero-cap text-center">
                                        <h2>Cart List</h2>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--================Cart Area =================-->
                <section class="cart_area section_padding">
                    <div class="container">
                        <div class="cart_inner">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">Number</th>
                                            <th scope="col">Product</th>
                                            <th scope="col">Price</th>
                                            <th scope="col">Quantity</th>
                                            <th scope="col">Total</th>
                                            <th scope ="col">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                    <c:set var = "d" value = "${sessionScope.cart}"/>
                                    <c:set var = "tt" value="0" />
                                    <c:forEach items = "${d.items}" var = "i">
                                        <c:set var = "tt" value = "${tt+1}"/>
                                        <tr>
                                            <td>${tt}</td>
                                            <td>
                                                <div class="media">
                                                    <div class="d-flex">
                                                        <img src= ${i.product.image} alt="" />
                                                    </div>
                                                    <div class="media-body">
                                                        <p>${i.product.name}</p>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <h5>$<fmt:formatNumber pattern="##.#" value = "${i.price}"/> </h5>
                                            </td>
                                            <td>
                                                <div class="product_count">
                                                    <button><a href= "process?num=-1&id=${i.product.id}" >-</a> </button>
                                                    ${i.quantity}
                                                    <button> <a href= "process?num=1&id=${i.product.id}" >+</a> </button>
                                                </div>
                                            </td>
                                            <td>
                                                <h5>$<fmt:formatNumber pattern="##.#" value = "${(i.price*i.quantity)}"/></h5>
                                            </td>
                                            <td>
                                                <form action ="process" method ="post">
                                                    <input type ="hidden" name ="id" value ="${i.product.id}"/>
                                                    <input type ="submit" value ="Remove"/>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td>
                                            <h5>Subtotal</h5>
                                        </td>
                                        <td>
                                            <h5>$<fmt:formatNumber pattern="##.#" value = "${d.totalMoney}"/> </h5>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <div class="checkout_btn_inner float-right">
                                <a class="btn_1" href="index.jsp">Continue Shopping</a>
                                <a class="btn_1 checkout_btn_1" href="checkout">Proceed to checkout</a>
                            </div>
                        </div>
                    </div>
            </section>
            <!--================End Cart Area =================-->
        </main>>
        <jsp:include page = "footer.jsp" ></jsp:include>
        <!--? Search model Begin -->
        <div class="search-model-box">
            <div class="h-100 d-flex align-items-center justify-content-center">
                <div class="search-close-btn">+</div>
                <form class="search-model-form">
                    <input type="text" id="search-input" placeholder="Searching key.....">
                </form>
            </div>
        </div>
        <!-- Search model end -->

        <!-- JS here -->

        <script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>
        <!-- Jquery, Popper, Bootstrap -->
        <script src="./assets/js/vendor/jquery-1.12.4.min.js"></script>
        <script src="./assets/js/popper.min.js"></script>
        <script src="./assets/js/bootstrap.min.js"></script>
        <!-- Jquery Mobile Menu -->
        <script src="./assets/js/jquery.slicknav.min.js"></script>

        <!-- Jquery Slick , Owl-Carousel Plugins -->
        <script src="./assets/js/owl.carousel.min.js"></script>
        <script src="./assets/js/slick.min.js"></script>

        <!-- One Page, Animated-HeadLin -->
        <script src="./assets/js/wow.min.js"></script>
        <script src="./assets/js/animated.headline.js"></script>

        <!-- Scrollup, nice-select, sticky -->
        <script src="./assets/js/jquery.scrollUp.min.js"></script>
        <script src="./assets/js/jquery.nice-select.min.js"></script>
        <script src="./assets/js/jquery.sticky.js"></script>
        <script src="./assets/js/jquery.magnific-popup.js"></script>

        <!-- contact js -->
        <script src="./assets/js/contact.js"></script>
        <script src="./assets/js/jquery.form.js"></script>
        <script src="./assets/js/jquery.validate.min.js"></script>
        <script src="./assets/js/mail-script.js"></script>
        <script src="./assets/js/jquery.ajaxchimp.min.js"></script>

        <!-- Jquery Plugins, main Jquery -->	
        <script src="./assets/js/plugins.js"></script>
        <script src="./assets/js/main.js"></script>

    </body>
</html>