<%-- 
    Document   : header
    Created on : Nov 19, 2022, 11:07:34 AM
    Author     : Legion
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <header>
        <!-- Header Start -->
        <div class="header-area">
            <div class="main-header header-sticky">
                <div class="container-fluid">
                    <div class="menu-wrapper">
                        <!-- Logo -->
                        <div class="logo">
                            <a href="index"><img src="assets/img/logo/logodebugboy.png" alt="" style="width:100px;height:90px;"></a>
                        </div>
                        <!-- Main-menu -->
                        <div class="main-menu d-none d-lg-block">
                            <nav>                                                
                                <ul id="navigation">  
                                    <li><a href="index.jsp">Trang Chủ</a></li>
                                    <li class="hot"><a href="index">Shop</a></li>
                                    <li><a href="#">Mua Hàng</a>
                                        <ul class="submenu">
                                        <c:if test ="${sessionScope.acc == null}">
                                            <li><a href="login.jsp">Đăng Nhập</a></li>
                                        </c:if>
                                        </ul>
                                    </li>
                                    <c:if test ="${sessionScope.acc.isAdmin == 1}">
                                        <li><a href="#">Quản Lý</a>
                                        <ul class="submenu">
                                            <li><a href="ManagerControl">Quản Lý Tài Khoản</a></li>
                                            <li><a href="ManagerControl">Quản Lý Sản Phẩm</a></li>
                                        </ul>
                                        </li>
                                    </c:if>                                    
                                    <c:if test ="${sessionScope.acc != null}">
                                        <li><a href="#">Hello ${sessionScope.acc.fullname}</a></li>
                                        <li><a href="logout">Đăng Xuất</a></li>
                                    </c:if>
                                </ul>
                            </nav>
                        </div>
                        <!-- Header Right -->
                        <div class="header-right">
                            <ul>
                                <li>
                                <form action="search" method = "post" class = "form-inline my-2 my-lg-0">
                                    <div class="input-group input-group-sm">
                                        <input value="${txtS}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                                        <div class="input-group-append">
                                                <button type="submit" class="btn btn-secondary btn-number"> 
                                                    <i class="fa fa-search"></i>   
                                                </button>
                                        </div>
                                    </div>
                                </form>
                                </li>
                                <li><a href="login.jsp"><span class="flaticon-user"></span></a></li>
                                <li><a href="cart.jsp"><span class="flaticon-shopping-cart"></span></a> </li>
                            </ul>
                        </div>
                    </div>
                    <!-- Mobile Menu -->
                    <div class="col-12">
                        <div class="mobile_menu d-block d-lg-none"></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Header End -->
    </header>

