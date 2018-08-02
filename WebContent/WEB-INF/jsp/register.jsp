<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register</title>
</head>
<body>
<h3>Register</h3>
<br>
<form action="doRegister" method="post">
    <table>
        <tr>
            <td><label>userID：</label></td>
            <td><input type="text" id="userId" name="userId"></td>
        </tr>
        <tr>
            <td><label>Fname：</label></td>
            <td><input type="text" id="fName" name="fName"></td>
        </tr>
        <tr>
            <td><label>Lname：</label></td>
            <td><input type="text" id="lName" name="lName"></td>
        </tr>
        <tr>
            <td><label>Gender：</label></td>
            <td><input type="text" id="gender" name="gender"></td>
        </tr>
        <tr>
            <td><label>DOB：</label></td>
            <td><input type="text" id="dob" name="dob"></td>
        </tr>
        <tr>
            <td><label>Qualification：</label></td>
            <td><input type="text" id="qualification" name="qualification"></td>
        </tr>
        <tr>
            <td><label>Address：</label></td>
            <td><input type="text" id="address" name="address"></td>
        </tr>
        <tr>
            <td><label>PhoneNo：</label></td>
            <td><input type="text" id="phoneNumber" name="phoneNumber"></td>
        </tr>
        <tr>
            <td><label>MobileNo：</label></td>
            <td><input type="text" id="mobile" name="mobile"></td>
        </tr>
        <tr>
            <td><label>EmailID：</label></td>
            <td><input type="text" id="emailId" name="emailId"></td>
        </tr>
        <tr>
            <td><label>DOJ：</label></td>
            <td><input type="text" id="doj" name="doj"></td>
        </tr>
        <tr>
            <td><label>Designation：</label></td>
            <td><input type="text" id="designation" name="designation"></td>
        </tr>
        <tr>
            <td><label>MaritalStatus：</label></td>
            <td><input type="text" id="maritalStatus" name="maritalStatus"></td>
        </tr>
        <tr>
            <td><label>Password：</label></td>
            <td><input type="password" id="password" name="password"></td>
        </tr>
        <tr>
            <td><label>HintQuestion：</label></td>
            <td><input type="text" id="hintQuestion" name="hintQuestion"></td>
        </tr>
        <tr>
            <td><label>HintAnswer：</label></td>
            <td><input type="text" id="hintAnswer" name="hintAnswer"></td>
        </tr>
        <tr>
            <td><input id="submit" type="submit" value="register"></td>
        </tr>
    </table>
</form>
</body>
</html>
