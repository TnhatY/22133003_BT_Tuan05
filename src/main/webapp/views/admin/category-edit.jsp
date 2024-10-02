<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file ="/common/taglib.jsp" %>
<div class="container1">
        <h2>Chỉnh sửa thông tin sản phẩm</h2>
        <form action="${pageContext.request.contextPath}/admin/sanpham/edit" method="POST">
        	<input type="text" name="id" value="${sp.id}" hidden="hidden">
            <input type="text" name="tensp" value="${sp.ten}" placeholder="Tên sản phẩm" required>
            <input type="text" name="giaban" value="${sp.giaban}" placeholder="Giá cũ" required>
            <input type="text" name="giahientai" value="${sp.giahtai}" placeholder="Giá bán" required>
            
            <c:if test="${sp.hinhanh.substring(0,5) !='https' }">
            	<c:url value ="/image?fname=${sp.hinhanh }" var="imgUrl"></c:url>
            	
            </c:if>
             <c:if test="${sp.hinhanh.substring(0,5) =='https' }">
            	<c:url value ="${sp.hinhanh }" var="imgUrl"></c:url>
            	
            </c:if>
            <img height="200" width="200" src="${sp.hinhanh}">
            <h3>Chọn ảnh</h3> 
            <input type="file" name="uploadFile" value="${sp.hinhanh }"/><br/>
            <button type="submit" name="submit" class="btn">Cập nhật</button>
        </form>
       
    </div>