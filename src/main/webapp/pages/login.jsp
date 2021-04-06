<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>管理页面</title>
<link href="./css/login.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.min.js"></script>

</head>

<body class="admin_login_warp">
  <div class="admin_login">
    <div class="admin_form">
      <form action="?act=login" method="post" name="ThisForm">
            <table cellpadding="0" cellspacing="0" border="0" class="l_tab">
              <tr>
                <td>身份</td>
                <td>
                    <select name="userType" style="width:150px" id="userType">
                        <option value="0">管理员</option>
                        <option value="2">经理</option>
                        <option value="1">员工</option>
                    </select>
                </td>
              </tr>
              <tr>
                <td>帐号</td>
                <td><input type="text" name="userName" style="width:150px" /></td>
              </tr>
              <tr>
                <td>密码</td>
                <td><input type="password" name="userPw" style="width:150px" /></td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td><input type="button" class="log" value="登录" style="padding:10px 20px" />${param.msg}
				<!--
				<input type="button" value="注册" style="padding:10px 20px" onClick="location.href='userReg.jsp'"/>
				-->
<span id="msg">${msg}</span>
			</td>
              </tr>
            </table>
          </form>
		  <script language="javascript">
$(function(){
$(".log").on('click',function(event) {
var username = $("input[name='userName']").val();
var pwd = $("input[name='userPw']").val();
var userType =  $('#userType').val();
if(username==''){
	alert("用户名不能为空！");
			//$('#msg').addClass('text-danger').text('用户名不能为空！');
			return false;
		}
		if(pwd==''){
				alert("密码不能为空!");

			//$('#msg').addClass('text-danger').text('密码不能为空！');
			return false;
		}
	$.ajax({
			url: '<%=path%>/check',
			type: 'post',
			data: {"username": username,"pwd": pwd,"userType":userType},
			beforeSend: function(){
				$('#msg').addClass('text-success').text('正在登录...');
				//$(".log").attr('disabled',true);
			},
			dataType: 'json',
				success: function(rs){
				var status=rs.status;
				var msg=rs.msg;
			//	alert(msg);
				if(status=="1"){ //登录成功
					alert(msg);
					$('#msg').removeClass('text-danger').addClass('text-success').text('登录成功！');
				
					location.href='<%=path%>/pages/adminindex.jsp';

				}else{
				alert(msg);
					$('#msg').addClass('text-danger').text('用户名或密码错误！');
				}
			},
			error:function(){
				alert("发生登录异常");
			}
		});

});
});
		
		
	    </script>
    </div>
</body>
</html>