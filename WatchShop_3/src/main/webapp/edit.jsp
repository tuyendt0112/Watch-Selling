<%-- 
    Document   : edit
    Created on : Dec 7, 2022, 3:27:50 PM
    Author     : sonem
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>DeBug-Boy Watch Shop</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">
        <style>
            img{
                width: 200px;
                height: 200px;
            }
        </style>
    <body>

        <div id="editEmployeeModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="edit" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Chỉnh Sửa Sản Phẩm</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>ID</label>
                                <input value = "${detail.id}" name ="id" type="text" class="form-control" readonly required>
                            </div>
                            <div class="form-group"> 
                                <label>Ảnh Sản Phẩm</label>
                                <input value = "${detail.image}" name ="image"type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Tên Sản Phẩm</label>
                                <input value = "${detail.name}" name ="name" type="text" class="form-control" required>                                
                            </div>
                            <div class="form-group">
                                <label>Giá Sản Phẩm</label>
                                <input value = "${detail.price}" name ="price" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Thông Tin Sản Phẩm</label>
                                <textarea name ="description" class="form-control" required>${detail.description}</textarea>
                            </div>	                            
                        </div>
                        <div class="modal-footer">
                            <input type="submit" class="btn btn-info" value="Save">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="js/manager.js" type="text/javascript"></script>
        <script>               
        </script>                            
    </body>
</html>
