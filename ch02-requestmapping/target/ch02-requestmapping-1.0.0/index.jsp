<%--
  Created by IntelliJ IDEA.
  User: cdw
  Date: 2021/11/25
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>first spring mvc</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btnAjax").on("click", function () {
                $.ajax({
                    // url: "doStudentJson.do",
                    // url: "doStudentJsonArray.do",
                    url: "doStringData.do",
                    data: {
                        name: "赵四",
                        age: 35
                    },
                    // dataType: "json",
                    dataType: "text",
                    success: function (resp) {
                        // alert("resp====" + resp.name + resp.age)
                        // $.each(resp, function (i, n) {
                        //     alert("n name=" + n.name + "====age=" + n.age);
                        // })

                        alert("resp==="+resp)
                    }
                })

            })

        })
    </script>
</head>
<body>

<a href="some.do">发起some.do请求</a>
<br>
<a href="some1.do">发起some.do请求</a>
<br>
<%--<a href="other.do">发起other.do请求</a>--%>
<br/>
<form action="other.do" method="post">
    <input type="submit" value="post请求">
</form>
<br/>

<form action="doParam.do" method="post">
    <input type="text" name="name" value="刘能"><br/>
    <input type="text" name="age" value="65"><br/>
    <input type="submit" value="提交">
</form>
<br/>
<form action="doParam1.do" method="post">
    <input type="text" name="rname" value="刘能"><br/>
    <input type="text" name="rage" value="65"><br/>
    <input type="submit" value="提交">
</form>
<br/>

<form action="receive-object.do" method="post">
    <input type="text" name="name" value="刘能"><br/>
    <input type="text" name="age" value="65"><br/>
    <input type="submit" value="对象接收">
</form>
<br/>


<button id="btnAjax">发起ajax请求</button>

</body>
</html>
