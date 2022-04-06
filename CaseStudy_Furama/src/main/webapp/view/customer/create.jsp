<%--
  Created by IntelliJ IDEA.
  User: Phuong Nhi
  Date: 4/2/2022
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới khách hàng</title>
    <script src="jquery/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="bootstrap-5.1.3-dist/css/bootstrap.css">
    <script src="bootstrap-5.1.3-dist/js/bootstrap.js"></script>
    <style>
        a {
            text-decoration: none;
        }

        .a-color {
            color: dimgray;
        }

        .a1-color {
            color: white;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #f7c500">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" style="padding-left: 20px" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="navbar-brand" href="#">
                        <img src="Images/Asset1.png" width="100" height="75"
                             class="d-inline-block align-text-top"/>
                    </a>
                </li>
                <li class="nav-item mt-3 fs-5">
                    <a class="nav-link " href="/index.jsp">Home</a>
                </li>
                <li class="nav-item mt-3 fs-5">
                    <a class="nav-link" href="/employees">Employee</a>
                </li>
                <li class="nav-item mt-3 fs-5">
                    <a class="nav-link active" aria-current="page" href="/customers">Customer</a>
                </li>
                <li class="nav-item mt-3 fs-5">
                    <a class="nav-link" href="/services">Service</a>
                </li>
                <li class="nav-item mt-3 fs-5">
                    <a class="nav-link" href="#">Contract</a>
                </li>
            </ul>
            <form class="d-flex mt-3" style="padding-right: 70px">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2 mt-3 bg-gradient" style="background-color: #FADA5C">
            <ul class="nav flex-column">
                <li class="nav-item">
                    <a class="nav-link a1-color fs-5" href="/customers">Back to CustomerList</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link a1-color fs-5" href="#">Item Two</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link a1-color fs-5" href="#">Item Three</a>
                </li>
            </ul>
        </div>
        <div class="col-md-1 mt-3" style="width: 70px">

        </div>
        <div class="col-md-9 mt-3" style="background-color: #FDF9E4">
            <form action="/customers?action=add" method="post">
                <div class="mb-3">
                    <c:if test="${mess!=null}">
                        <label style="color: red">${mess}</label>
                    </c:if>
                </div>
                <div class="mb-3">
                    <label class="form-label">Customer Type: </label>
                    <select class="form-select" name="customer_type_id">
                        <c:forEach items="${customerTypeList}" var="customerType">
                            <option value="${customerType.getCustomer_type_id()}">${customerType.getCustomer_type()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Full name: </label>
                    <input type="text" class="form-control" name="name" placeholder="Enter name">
                </div>
                <div class="mb-3 w-50">
                    <label class="form-label">Birthday: </label>
                    <input type="date" class="form-control" name="birthday">
                </div>
                <div class="mb-3">
                    <label class="form-label">Gender: </label>
                    <input class="form-check-input" type="radio" name="gender" value="true">Male
                    <input class="form-check-input" type="radio" name="gender" value="false">Female
                </div>
                <div class="mb-3">
                    <label class="form-label">Id_Card: </label>
                    <input type="text" class="form-control" name="id_card" placeholder="Enter Id_Card">
                </div>
                <div class="mb-3">
                    <label class="form-label">Phone: </label>
                    <input type="text" class="form-control" name="phone" placeholder="Enter phone number">
                </div>
                <div class="mb-3">
                    <label class="form-label">Email: </label>
                    <input type="text" class="form-control" name="email" placeholder="Enter email">
                </div>
                <div class="mb-3">
                    <label class="form-label">Address: </label>
                    <input type="text" class="form-control" name="address" placeholder="Enter address">
                </div>
                <button class="btn btn-warning">Save</button>
            </form>
        </div>
    </div>
</div>

<!-- Footer -->
<footer class="text-center text-lg-start bg-light text-muted">
    <!-- Section: Social media -->
    <section
            class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
        <!-- Left -->
        <div class="me-5 d-none d-lg-block" style="padding-left: 40px">
            <span>Follow us:</span>
        </div>
        <!-- Left -->

        <!-- Right -->
        <div style="padding-right: 50px">
            <a href="#" class="me-4 text-reset">
                <img src="https://img.icons8.com/windows/30/000000/facebook-f--v1.png">
            </a>
            <a href="#" class="me-4 text-reset">
                <img src="https://img.icons8.com/ios-glyphs/30/000000/twitter--v1.png">
            </a>
            <a href="#" class="me-4 text-reset">
                <img src="https://img.icons8.com/material-outlined/30/000000/instagram-new--v1.png">
            </a>
        </div>
        <!-- Right -->
    </section>
    <!-- Section: Social media -->

    <!-- Section: Links  -->
    <section class="">
        <div class="container text-center text-md-start mt-5">
            <!-- Grid row -->
            <div class="row mt-3">
                <!-- Grid column -->
                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Content -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        Help
                    </h6>
                    <p><a class="a-color" href="#">Help center</a></p>
                    <p><a class="a-color" href="#">FAQs</a></p>
                    <p><a class="a-color" href="#">Privacy policy</a></p>
                    <p><a class="a-color" href="#">Cookie policy</a></p>
                    <p><a class="a-color" href="#">Terms of use</a></p>


                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">About us
                    </h6>
                    <p>
                        <a class="a-color" href="#">PointsMAX</a>
                    <p>
                        <a class="a-color" href="#">Careers</a>
                    </p>
                    <p>
                        <a class="a-color" href="#">Press</a>
                    </p>
                    <p>
                        <a class="a-color" href="#">Blog</a>
                    </p>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">Destinations
                    </h6>
                    <p>
                        <a class="a-color" href="#">Countries/ Territories</a>
                    </p>
                    <p>
                        <a class="a-color" href="#">Cities</a>
                    </p>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">Partner with us
                    </h6>
                    <p>
                        <a class="a-color" href="#">YCS Partner portal</a>
                    </p>
                    <p>
                        <a class="a-color" href="#">Partner Hub</a>
                    </p>
                    <p>
                        <a class="a-color" href="#">Advertise on Agoda</a>
                    </p>
                    <p>
                        <a class="a-color" href="#">Affiliates</a>
                    </p>
                    <p>
                        <a class="a-color" href="#">Connectivity partners</a>
                    </p>
                </div>
                <!-- Grid column -->
                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">Get the app
                    </h6>
                    <p>
                        <a class="a-color" href="#">iOS app</a>
                    </p>
                    <p>
                        <a class="a-color" href="#">Android app</a>
                    </p>
                </div>
            </div>
            <!-- Grid row -->
        </div>
    </section>
    <!-- Section: Links  -->

    <!-- Copyright -->
    <div class="text-center p-4" style="background-color: #F9D133">
        © 2022 Copyright:
        <a class="text-reset" href="view/index.jsp">furamaresort.vn</a>
    </div>
    <!-- Copyright -->
</footer>
<!-- Footer -->
</body>
</html>
