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
    <title>产品 </title>
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
    alert("名称不能为空！");
    document.formAdd.name.focus();
    return false;
  }

 if (document.formAdd.number.value=="")
  {
    alert("编号不能为空！");
    document.formAdd.number.focus();
    return false;
  }

 if (document.formAdd.price.value=="")
  {
    alert("价格不能为空！");
    document.formAdd.price.focus();
    return false;
  }

 if (document.formAdd.nums.value=="")
  {
    alert("库存不能为空！");
    document.formAdd.nums.focus();
    return false;
  }

 if (document.formAdd.remarks.value=="")
  {
    alert("备注不能为空！");
    document.formAdd.remarks.focus();
    return false;
  }

document.formAdd.submit();
}
</script><form name="formAdd" method="post" action="<%=path %>/productinsert" class="form-horizontal" role="form">
	<fieldset> <legend>添加产品</legend>	

<div class="form-group">
             <label class="col-sm-2 control-label" for="name">名称</label>
              <div class="col-sm-4">
<input name="name" type="text" id="name" class="form-control" placeholder="" >
 

 </div>
	</div>

<div class="form-group">
             <label class="col-sm-2 control-label" for="number">编号</label>
              <div class="col-sm-4">
<input name="number" type="text" id="number" class="form-control" value="<%=String.valueOf(new Date().getTime()) %>" readonly>

 </div>
	</div>


   <div class="form-group">
   <label for="sort"  class="col-sm-2 control-label">分类</label>
       <div class="col-sm-2">
       <select name="sort" class="form-control">
   <c:forEach items="${sort}" var="s"  varStatus="ss">
   <option value="${s.name}">${s.name}</option>
</c:forEach>
		 </select> 
		 </div>
   </div>

<div class="form-group">
             <label class="col-sm-2 control-label" for="price">价格</label>
              <div class="col-sm-4">
<input name="price" type="text" id="price" class="form-control" placeholder="" >
 

 </div>
	</div>

<div class="form-group">
   <label class="col-sm-2 control-label" for="nums">库存</label>
    <div class="col-sm-4">
<input name="nums" type="text" id="nums" value="1"  class="form-control"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" >
</div>
	</div>

<div class="form-group">
             <label class="col-sm-2 control-label" for="remarks">备注</label>
              <div class="col-sm-4">
<input name="remarks" type="text" id="remarks" class="form-control" placeholder="" >
 

 </div>
	</div>

	</fieldset>  
   <fieldset>
     <legend></legend>
		<div class="form-group">
            <div class="col-sm-10 col-sm-offset-2">
			       <input name="forword" type="hidden" value="productlist"/>
           <button type="button" class="btn  btn-primary" onclick="check()">保存</button>
	 <button type="button" class="btn btn-default" onClick="history.back(-1)">返回</button>
    </div>
</div>
	 </fieldset>
</form>
</div>
    </body>
 </html>  
  