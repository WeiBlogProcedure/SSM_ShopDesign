<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <title>标题</title>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <link href="./css/css.css" rel="stylesheet" type="text/css">
 <script type="text/javascript" src="./js/jquery.js"></script>
 <script type="text/javascript">
  $(function() {
   $('p').each(function(i) {
    $(this).click(function() {
     $('p:not(:eq('+i+'))').next().hide();
     $('p:not(:eq('+i+'))').find('span').text("+");
     $(this).next().show();
     $(this).find('span').text("-");
    })
   })
  })
 </script>

 <script type="text/javascript">
  function logout() {
   if(confirm("确定要退出本系统吗??")) {
    window.parent.location="<%=path %>/userLogout";
   }
  }
 </script>
</head>


<body class="admin_left">
<div class="admin_nav">
 <!--开始-->
 <c:if test="${sessionScope.userType==0}">
 <!--开始-->
 <p><span>+</span> 库存管理</p>
 <div>
  <a target="manFrame" href="<%=path %>/productlist">产品管理</a>
  <a target="manFrame" href="<%=path %>/productadd">产品添加</a>
 </div>
 <!--结束-->
 <p><span>+</span> 门店调货查询</p>
 <div>
  <a target="manFrame" href="<%=path %>/transferAll">门店调货查询</a>
 </div>
 <!--结束-->

 <!--开始-->
 <p><span>+</span> 门店订货</p>
 <div>
  <a target="manFrame" href="<%=path %>/ordergoodsAll">门店订货查询</a>
 </div>
 <!--结束-->

 <!--开始-->
 <p><span>+</span> 退货管理</p>
 <div>
  <a target="manFrame" href="<%=path %>/returngoodsAll">退货查询</a>
 </div>
 <!--结束-->

 <!--开始-->
 <p><span>+</span> 产品分类管理</p>
 <div>
  <a target="manFrame" href="<%=path %>/sortlist">产品分类管理</a>
  <a target="manFrame" href="<%=path %>/sortadd">产品分类添加</a>
 </div>
 <!--结束-->

 <!--开始-->
 <p><span>+</span> 门店管理</p>
 <div>
  <a target="manFrame" href="<%=path %>/storelist">门店管理</a>
  <a target="manFrame" href="<%=path %>/storeadd">门店添加</a>
 </div>
 <!--结束-->

 <!--开始-->
 <p><span>+</span> 员工管理</p>
 <div>
  <a target="manFrame" href="<%=path %>/userlist">员工管理</a>
  <a target="manFrame" href="<%=path %>/useradd">员工添加</a>
 </div>
 <!--结束-->

 <p><span>+</span> 管理员管理</p>
 <div>
  <a target="manFrame" href="<%=path %>/adminlist">管理员管理</a>
  <a target="manFrame" href="<%=path %>/adminadd">管理员添加</a>
 </div>
 <!--结束-->
 </c:if>
 <c:if test="${sessionScope.userType==1}">

 <!--开始-->
 <p><span>+</span> 门店调货管理</p>
 <div>
  <a target="manFrame" href="<%=path %>/transfermy">门店调货管理</a>
  <a target="manFrame" href="<%=path %>/transferadd">门店调货</a>
 </div>
 <!--结束-->

 <!--开始-->
 <p><span>+</span> 门店订货管理</p>
 <div>
  <a target="manFrame" href="<%=path %>/ordergoodsmy">门店订货管理</a>
  <a target="manFrame" href="<%=path %>/ordergoodsadd">门店订货添加</a>
 </div>
 <!--结束-->

 <!--开始-->
 <p><span>+</span> 退货管理</p>
 <div>
  <a target="manFrame" href="<%=path %>/returngoodsmy">退货管理</a>
  <a target="manFrame" href="<%=path %>/returngoodsadd">退货添加</a>
 </div>
 <!--结束-->

 <!--开始-->
 <p><span>+</span>修改个人资料</p>
 <div>
  <a target="manFrame" href="<%=path %>/userinfo?id=${sessionScope.loginid}">修改</a>
 </div><!--结束-->
 </c:if>
 <c:if test="${sessionScope.userType==2}">
 <p><span>+</span> 门店调货</p>
 <div>
  <a target="manFrame" href="<%=path %>/transferlist">门店调货审核</a>
 </div>
 <!--结束-->

 <!--开始-->
 <p><span>+</span> 门店订货</p>
 <div>
  <a target="manFrame" href="<%=path %>/ordergoodslist">门店订货审核</a>
 </div>
 <!--结束-->

 <!--开始-->
 <p><span>+</span> 退货管理</p>
 <div>
  <a target="manFrame" href="<%=path %>/returngoodslist">退货审核</a>
 </div>
 <!--结束-->

 <!--开始-->
 <p><span>+</span>修改个人资料</p>
 <div>
  <a target="manFrame" href="<%=path %>/userinfo?id=${sessionScope.loginid}">修改</a>
 </div>
 <!--结束-->
 </c:if>

<!--结束-->
</body>
</html>