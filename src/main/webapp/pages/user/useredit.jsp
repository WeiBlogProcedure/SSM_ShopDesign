<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>员工 </title>
    <!-- Bootstrap -->
	    	<script src="<%=path %>/js/jquery.min.js"></script>
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/css/my.css" rel="stylesheet">
	<script src="<%=path %>/js/bootstrap.min.js"></script>
<script src="<%=path %>/js/laydate/laydate.js"></script>
 <script src="<%=path %>/ueditor/ueditor.config.js"></script>
       <script src="<%=path %>/ueditor/ueditor.all.js"></script>
  <script src="<%=path %>/layer/layer.js"></script>


</head>
<body>  
<div class="container">


<script>
function check()
{

 if (document.formAdd.username.value=="")
  {
    alert("用户名不能为空！");
    document.formAdd.username.focus();
    return false;
  }

 if (document.formAdd.pwd.value=="")
     {
      alert("密码不能为空！")
           return false;
     }
	  if (document.formAdd.pwd.value!=document.formAdd.repwd.value)
     {
      alert("输入的密码不一致！");
          return false;
     }

 if (document.formAdd.name.value=="")
  {
    alert("姓名不能为空！");
    document.formAdd.name.focus();
    return false;
  }

 if (document.formAdd.position.value=="")
  {
    alert("职位不能为空！");
    document.formAdd.position.focus();
    return false;
  }

 if (document.formAdd.telephone.value=="")
  {
    alert("手机不能为空！");
    document.formAdd.telephone.focus();
    return false;
  }

 if (document.formAdd.limits.value=="")
  {
    alert("权限不能为空！");
    document.formAdd.limits.focus();
    return false;
  }

document.formAdd.submit();
}
</script><form name="formAdd" method="post" action="userupdate" class="form-horizontal" role="form">
<fieldset> <legend>修改员工</legend>

<input type="hidden" name="id" value="${c.id}"/>


<div class="form-group">
    <label class="col-sm-2 control-label" for="username">用户名</label>
      <div class="col-sm-4">
<input name="username" type="text" id="username" class="form-control"  value="${c.username}" >
 </div>
	</div>

<div class="form-group">
             <label class="col-sm-2 control-label" for="pwd">登录密码</label>
              <div class="col-sm-4">
<input name="pwd" type="password" id="pwd" class="form-control" placeholder="输入密码" >
 </div>
	</div>
<div class="form-group">
             <label class="col-sm-2 control-label" for="repwd">确认密码</label>
              <div class="col-sm-4">
<input name="repwd" type="password" id="repwd" class="form-control" placeholder="确认密码" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="name">姓名</label>
      <div class="col-sm-4">
<input name="name" type="text" id="name" class="form-control"  value="${c.name}" >
 </div>
	</div>

<div class="form-group">
 <label class="col-sm-2 control-label" for="sex">性别</label>
   <div class="col-sm-4 radio" id="sex">
    <label>  <input type="radio" name="sex"  value="男" <c:if test="${c.sex=='男'}"> checked </c:if>> 男 </label>
    <label>  <input type="radio" name="sex"  value="女" <c:if test="${c.sex=='女'}"> checked </c:if>> 女 </label>

   </div>
</div>

<div class="form-group">
    <label class="col-sm-2 control-label" for="position">职位</label>
      <div class="col-sm-4">
<input name="position" type="text" id="position" class="form-control"  value="${c.position}" >
 </div>
	</div>


   <div class="form-group">
   <label for="store"  class="col-sm-2 control-label">所属门店</label>
       <div class="col-sm-2">
       <select name="store" id="store" class="form-control">
   <c:forEach items="${store}" var="s"  varStatus="ss">
   <option value="${s.id}">${s.name}</option>
</c:forEach>
		 </select>
		 </div>
   </div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="telephone">手机</label>
      <div class="col-sm-4">
<input name="telephone" type="text" id="telephone" class="form-control"  value="${c.telephone}" >
 </div>
	</div>

<div class="form-group">
             <label class="col-sm-2 control-label" for="limits">权限</label>
              <div class="col-sm-4">
   <select class="form-control" id="limits" name="limits">
      <option value="经理">经理</option>
  <option value="普通员工" selected="selected">普通员工</option>
 
    </select>

 </div>
	</div>

	</fieldset>  
   <fieldset>
     <legend></legend>
		<div class="form-group">
            <div class="col-sm-10 col-sm-offset-2">
			 <input name="forword" type="hidden" value="${param.forword}"/>
           <button type="button" class="btn  btn-primary" onclick="check()">保存数据</button>
	 <button type="button" class="btn btn-default" onClick="history.back(-1)">返回</button>

    </div>
</div>
	 </fieldset>
</form>
</div>
    </body>
 </html>  
  