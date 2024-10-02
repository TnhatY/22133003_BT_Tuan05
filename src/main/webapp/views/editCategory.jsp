<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container1">
        <h2>Chỉnh sửa thông tin sản phẩm</h2>
        <form action="/WebJDBC/profile" method="POST">
            <input type="text" name="tensp" value="${sessionScope.account.getFullName()}" placeholder="Tên sản phẩm" required>
            <input type="text" name="giaban" value="${sessionScope.account.getEmail()}" placeholder="Giá cũ" required>
            <input type="text" name="giahientai" value="${sessionScope.account.getEmail()}" placeholder="Giá bán" required>
            <input type="text" name="tinhtrang" value="${sessionScope.account.getPhone()}" placeholder="Tình trạng" required>
            <h3>Chọn ảnh</h3> 
            <input type="file" name="uploadFile" value="${sessionScope.account.getAvatar()}"/><br/>
            <button type="submit" name="submit" class="btn">Cập nhật</button>
        </form>
       
    </div>