<script type="text/javascript" src="${ctx}/cm/static/js/common.js"></script>

<h2>Admin Login</h2>
<form action="loginform.html"  name="login" commandName="loginForm">
    <center>
        <table>
            <tr>
                <td>User Name:<FONT color="red"><form:errors
                path="userName"   /></FONT></td>
            </tr>
            <tr>
                <td>
                    <input type="text" name="username" id="username" color="red"><br>
                </td>

            </tr>
            <tr>
                <td>Password:<FONT color="red"><form:errors
                path="password" /></FONT></td>
            </tr>
            <tr>
                <td><input type="text" color="red" name="password" id="password"><br></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit" onclick="javascript:doesMemberExist('login')"> </td>

            </tr>
        </table>
    </center>
</form >