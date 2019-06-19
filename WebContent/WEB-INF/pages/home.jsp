<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登陆成功</title>
    <script src="resources/js/jquery-3.3.1.js" type="text/javascript"></script>

</head>
<body>
登陆成功！
欢迎~${msg};

<div>
    <h1>Add new employee</h1>
    <form id="submitEmployee" action="" method="post">
        用户名：<input type="text" name="loginId" value="abc"/><br/>
        密码：<input type="password" name="password" value="abc"/><br/>
        email：<input type="text" name="email" value="abc@123.com"/><br/>
        <input type="submit" value="Create"/>
    </form>

</div>
<div>
    <h1>Update employee</h1>
    <form id="updateEmployee" action="" method="post">
        ID: <input type="text" name="id"/><br/>
        用户名：<input type="text" name="loginId"/><br/>
        密码：<input type="password" name="password"/><br/>
        email：<input type="text" name="email"/><br/>
        <input type="submit" value="Update"/>
    </form>
</div>
<script>
    $("#submitEmployee").submit(function (e) {
        console.log('add employee');
        e.preventDefault();
        const data = {};
        let formData = $(this).serializeArray();
        $.each(formData, function () {
            data[this.name] = this.value;
        });
        $.post("emp/", data, function (result) {
            console.log("result from server: ", result)
            let updateForm = $("#updateEmployee");
            $.each(result, function (k, v) {
                let ctrl = $("[name=" + k + "]", updateForm);
                ctrl.val(v);
            })
        }, "json");
    });
    $("#updateEmployee").submit(function (e) {
        e.preventDefault();
        const data = {};
        let formData = $(this).serializeArray();
        $.each(formData, function () {
            data[this.name] = this.value;
        });
        console.log('update employee', data);
        $.ajax({
            url: "emp/" + data.id,
            type: 'PUT',
            data: JSON.stringify(data),
            dataType: 'json',
            contentType: 'application/json'
        }).done(function (data) {
            console.log("update successfully", data);
        }).fail(function (err) {
            console.log("failed to update employee, error: ", err)
        });
    });
</script>
</body>
</html>