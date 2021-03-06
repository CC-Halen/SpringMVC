<%--
  Created by IntelliJ IDEA.
  User: cdw
  Date: 2021/12/5
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <title>首页</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            //添加省份信息
            getProvinceList();
            //查询按钮的单击事件
            $("#queryCity").click(function () {
                //选中的下拉列表的值
                let pid = $("#province>option:selected").val();
                $.get("city/queryCity.do",{pid:pid},function (response) {
                    if (response.code==1){


                        $("#cityInfo").empty();
                        $.each(response.data,function (i,n) {
                            $("#cityInfo").append("<tr><td>"+n.id+"</td><td>"+n.name+"</td></tr>")
                        })
                    }else
                        alert(response.msg);
                },"json")
            })

            //添加城市
            $("#addCity").click(function () {
                let pid = $("#province>option:selected").val();
                let name = $(":text").val();
                $.post("city/addCity.do",{name:name,provinceId:pid},function (response) {
                    if (response.code==1){
                        alert(response.msg);
                    }else{
                        alert(response.msg);

                    }
                },"json")
            })
        })


        function getProvinceList() {
            $.ajax({
                url: "queryProvince.do",
                dataType: "json",
                success: function (response) {
                    $("#province").empty();
                    $.each(response.data, function (i, n) {
                        $("#province").append("<option value='" + n.id + "'>" + n.name + "</option>")
                    })
                }
            })
        }
    </script>
</head>
<body>
<div align="center">
    <table>
        <tr>
            <td>省份列表&nbsp;</td>
            <td>
                <select id="province">
                    <option value="0">请选择省份</option>
                </select>
            </td>
        </tr>

        <tr>
            <td>城市名称&nbsp;</td>
            <td>
                <input type="text" id="cityName">
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" id="addCity" value="添加城市">
            </td>

            <td>
                <input type="button" id="queryCity" value="查询省份的城市">
            </td>
        </tr>
    </table>
    <br/>
    <div id="dataDiv">
        <table>
            <thead>
            <tr>
                <th>城市id&nbsp;&nbsp;&nbsp;</th>
                <th>城市名称&nbsp;&nbsp;&nbsp;</th>
            </tr>
            </thead>
            <tbody id="cityInfo">
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
