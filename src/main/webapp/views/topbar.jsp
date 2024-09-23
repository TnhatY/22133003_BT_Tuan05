<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        .admin-box, .edit-box {
            padding: 20px;
            border-radius: 10px;
            text-align: center;
            width: 300px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .admin-box {
            background-color: #e0f7fa;
        }

        .admin-box h1 {
            font-size: 24px;
            color: #00796b;
        }

        .admin-box button {
            background-color: #00796b;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        .edit-box {
            background-color: #fff3e0;
        }

        .edit-box h1 {
            font-size: 20px;
            color: #e65100;
        }

        .edit-box button {
            background-color: #e65100;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        .admin-box button:hover, .edit-box button:hover {
            opacity: 0.9;
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="admin-box">
            <h1>Chào mừng đến trang Admin</h1>
            <button>Đăng xuất</button>
        </div>

        <div class="edit-box">
            <h1>Chỉnh sửa thông tin</h1>
            <button>Chỉnh sửa</button>
        </div>
    </div>
</body>
</html>