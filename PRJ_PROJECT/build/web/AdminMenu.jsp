<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Menu Management</title>
    <!-- Add your CSS links or styles here -->
</head>
<body>
    <header>
        <h1>Admin Menu Management</h1>
        <!-- Navigation links if any -->
    </header>

    <section>
        <h2>Add/Edit Menu</h2>
        <form action="ManageMenuServlet" method="post">
            <input type="hidden" name="action" value="addOrUpdateMenu">
            <label for="menuName">Menu Name:</label>
            <input type="text" id="menuName" name="menuName" required><br>
            <!-- Add other fields for menu details -->
            <button type="submit">Add/Update Menu</button>
        </form>
    </section>

    <section>
        <h2>Manage Existing Menus</h2>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Week Number</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <!-- Example loop through menus -->
                <c:forEach var="menu" items="${menus}">
                    <tr>
                        <td>${menu.menuId}</td>
                        <td>${menu.name}</td>
                        <td>${menu.description}</td>
                        <td>${menu.weekNumber}</td>
                        <td>
                            <a href="ManageMenuServlet?action=editMenu&id=${menu.menuId}">Edit</a>
                            <a href="ManageMenuServlet?action=deleteMenu&id=${menu.menuId}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </section>

    <!-- Include any additional sections or scripts as needed -->
</body>
</html>
