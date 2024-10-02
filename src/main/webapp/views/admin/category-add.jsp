<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container1">
        <h2>Chỉnh sửa thông tin sản phẩm</h2>
        <form action="${pageContext.request.contextPath}/admin/sanpham/add" method="POST">
            <input type="text" name="tensp"  placeholder="Tên sản phẩm" required>
            <input type="text" name="giaban"  placeholder="Giá cũ" required>
            <input type="text" name="giahientai"  placeholder="Giá bán" required>
            <h3>Chọn ảnh</h3> 
            <input type="file" name="uploadFile" value=""/><br/>
            <button type="submit" name="submit" class="btn">Thêm sản phẩm</button>
        </form>
       
    </div>