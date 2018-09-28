<html>
<body>

<h1>Add New User</h1>
<form action="servletSave" method="post">
    <table>
        <tr><td>Name of user :</td><td><input type="text" name="name"/></td></tr>
        <tr><td>Email:</td><td><input type="email" name="email"/></td></tr>
        <tr><td>Country:</td><td>
            <select name="country" style="width:150px">
                <option>Deutschland</option>
                <option>USA</option>
                <option>UK</option>
                <option>Other</option>
            </select>
        </td></tr>
        <tr><td colspan="2"><input type="submit" value="Save User"/></td></tr>
    </table>
</form>

<br/>
<a href="ViewServlet">view Users</a>
</body>
</html>
