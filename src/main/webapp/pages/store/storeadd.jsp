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
    <title>门店 </title>
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

 if (document.formAdd.name.value=="")
  {
    alert("门店名称不能为空！");
    document.formAdd.name.focus();
    return false;
  }

 if (document.formAdd.address.value=="")
  {
    alert("门店地址不能为空！");
    document.formAdd.address.focus();
    return false;
  }

 if (document.formAdd.telephone.value=="")
  {
    alert("联系电话不能为空！");
    document.formAdd.telephone.focus();
    return false;
  }

 if (document.formAdd.tname.value=="")
  {
    alert("店长姓名不能为空！");
    document.formAdd.tname.focus();
    return false;
  }

document.formAdd.submit();
}
</script><form name="formAdd" method="post" action="<%=path %>/storeinsert" class="form-horizontal" role="form">
	<fieldset> <legend>添加门店</legend>	

<div class="form-group">
             <label class="col-sm-2 control-label" for="name">门店名称</label>
              <div class="col-sm-4">
<input name="name" type="text" id="name" class="form-control" placeholder="" >
 

 </div>
	</div>

<div class="form-group">
             <label class="col-sm-2 control-label" for="address">门店地址</label>
              <div class="col-sm-4">
<input name="address" type="text" id="address" class="form-control" placeholder="" >
 

 </div>
	</div>

<div class="form-group">
             <label class="col-sm-2 control-label" for="telephone">联系电话</label>
              <div class="col-sm-4">
<input name="telephone" type="text" id="telephone" class="form-control" placeholder="" >
 

 </div>
	</div>

<div class="form-group">
             <label class="col-sm-2 control-label" for="tname">店长姓名</label>
              <div class="col-sm-4">
<input name="tname" type="text" id="tname" class="form-control" placeholder="" >
 

 </div>
	</div>

	</fieldset>  
   <fieldset>
     <legend></legend>
		<div class="form-group">
            <div class="col-sm-10 col-sm-offset-2">
			       <input name="forword" type="hidden" value="storelist"/>
           <button type="button" class="btn  btn-primary" onclick="check()">保存</button>
	 <button type="button" class="btn btn-default" onClick="history.back(-1)">返回</button>
    </div>
</div>
	 </fieldset>
</form>
</div>
    </body>
 </html>  
  