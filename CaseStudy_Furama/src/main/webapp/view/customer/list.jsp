<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Phuong Nhi
  Date: 4/1/2022
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <script src="jquery/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="bootstrap-5.1.3-dist/css/bootstrap.css">
    <script src="jquery/jquery.dataTables.min.js"></script>
    <script src="jquery/dataTables.bootstrap4.js"></script>
    <script src="bootstrap-5.1.3-dist/js/bootstrap.js"></script>
    <script>
        $(document).ready(function () {
            $('#tableCustomer').dataTable({
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 5
            });
        });
    </script>
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
                    <a class="nav-link" href="/contracts">Contract</a>
                </li>
            </ul>
            <form action="/customers?action=search" method="post" class="d-flex mt-3" style="padding-right: 70px">
                <input class="form-control me-2" type="text" placeholder="Enter name" name="searchName">
                <select class="form-select me-2" name="searchType">
                    <option value="">Choose Type</option>
                    <c:forEach items="${customerTypeList}" var="customerType">
                        <option value="${customerType.getCustomer_type_id()}">${customerType.getCustomer_type()}</option>
                    </c:forEach>
                </select>
                <input class="form-control me-2" type="text" placeholder="Enter address" name="searchAddress">
                <button class="btn btn-outline-success">Search</button>
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row" style="min-height: 100%">
        <div class="col-md-2 mt-3 bg-gradient" style="background-color: #FADA5C">
            <ul class="nav flex-column">
                <li class="nav-item">
                    <a class="nav-link a1-color fs-5" href="/customers?action=add">Add New Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link a1-color fs-5" href="/customerUseServices">Customer Use Service List</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link a1-color fs-5" href="#">Item Three</a>
                </li>
            </ul>
        </div>
        <div class="col-md-1 mt-3" style="width: 70px">
        </div>
        <div class="col-md-9 mt-3" style="background-color: #FDF9E4">
            <div class="mb-3">
                <c:if test="${mess!=null}">
                    <label style="color: red">${mess}</label>
                </c:if>
            </div>
            <table id="tableCustomer" class="table table-warning table-striped border-danger" border="1"
                   style="border-collapse:  collapse">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Id</th>
                    <th>Type</th>
                    <th>Name</th>
                    <th>Birthday</th>
                    <th>Gender</th>
                    <th>Id_card</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${customerList}" var="customer" varStatus="item">
                    <tr>
                        <td>${item.count}</td>
                        <td>${customer.getId()}</td>
                        <c:forEach items="${customerTypeList}" var="customerType">
                            <c:if test="${customerType.getCustomer_type_id() == customer.getCustomer_type_id()}">
                                <td>${customerType.getCustomer_type()}</td>
                            </c:if>
                        </c:forEach>

                        <td>${customer.getName()}</td>
                        <td>${customer.getBirthday()}</td>
                        <c:if test="${customer.isGender()}">
                            <td>Nam</td>
                        </c:if>
                        <c:if test="${!customer.isGender()}">
                            <td>Nữ</td>
                        </c:if>
                        <td>${customer.getId_card()}</td>
                        <td>${customer.getPhone()}</td>
                        <td>${customer.getEmail()}</td>
                        <td>${customer.getCustomer_address()}</td>
                        <td><a href="/customers?action=edit&id=${customer.getId()}"><img
                                src="https://img.icons8.com/bubbles/50/000000/edit.png"/></a>
                        </td>
                        <td>
                            <button type="button" class="btn" style="position:relative; bottom: 6px" onclick="infoDelete('${customer.getId()}','${customer.getName()}')" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                <img src="https://img.icons8.com/bubbles/50/000000/delete-forever.png"/>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Xóa khách hàng</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/customers?action=delete" method="get">
            <div class="modal-body">
                <span>Bạn có muốn xóa khách hàng tên: </span><span style="color: blue" id="customerName"></span>
                <input type="text" id="customerId" name="id" hidden>
                <input type="text" name="action" value="delete" hidden>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Hủy</button>
                <button type="submit" class="btn btn-warning">Xóa</button>
            </div>
            </form>
        </div>
    </div>
</div>
<script>
    function infoDelete(id, name) {
        document.getElementById("customerName").innerText = name;
        document.getElementById("customerId").value = id;
    }
</script>
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
