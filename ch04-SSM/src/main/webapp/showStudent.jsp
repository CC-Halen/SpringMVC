<%--
  Created by IntelliJ IDEA.
  User: cdw
  Date: 2021/11/27
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showStudent</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            //页面加载之后执行ajax
            getStudentInfo()
            $("#doAjax").click(function () {
                getStudentInfo()

            })
        })

        function getStudentInfo() {
            $.ajax({
                url: "student/queryStudent.do",
                dataType: "json",
                success: function (resp) {
                    // alert("resp=" + resp)
                    $("#stuInfo").empty();
                    $.each(resp, function (i, n) {
                        $("#stuInfo").append("<tr><td>" + n.id + "</td><td>"
                            + n.name + "</td><td>" + n.age + "</td></tr>")
                    })

                }
            })
        }
    </script>
</head>
<body>

<div align="center">
    <p>浏览学生
        <button id="doAjax">获取学生数据</button>
    </p>
    <table>
        <thead>
        <tr>
            <td>id</td>
            <td>姓名</td>
            <td>年龄</td>
        </tr>
        </thead>
        <tbody id="stuInfo">

        </tbody>
    </table>
</div>
</body>
</html>
