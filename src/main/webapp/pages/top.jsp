<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
   String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

	<STYLE type=text/css>
		BODY {PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-TOP: 0px; BACKGROUND-COLOR: #2a8dc8}
		BODY {FONT-SIZE: 12px; COLOR: #003366; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif}
		TD {FONT-SIZE: 12px; COLOR: #003366; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif}
		DIV {FONT-SIZE: 12px; COLOR: #003366; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif}
		P {FONT-SIZE: 12px; COLOR: #003366; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif}
	</STYLE>
	
	<script type="text/javascript">
	    function logout()
		{
		   if(confirm("确定要退出本系统吗??"))
		   {
			   window.parent.location="<%=path %>/userLogout";
		   }
		}
	</script>
  </head>
  
<body>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TR>
    <TD width=2%></TD>
    <TD width=70%>
       <div style="margin-top: 30px;font-family: 微软雅黑;font-size: 33px;margin-left: 9px;">门店补货系统</div>
    </TD>
    <TD width=23%>
	      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
	        <TR><TD align=right height=35></TD></TR>
	        <TR>
	          <TD height=35>&nbsp; 
                        <span style="color: white;font-size: 17px;font-family: 微软雅黑">
                           ${sessionScope.loginname }
         </span>  
	                
	              
	                &nbsp;&nbsp;&nbsp;
	                <a href="#" style="color: white;font-size: 16px;font-family: 微软雅黑" onclick="logout()">注销退出</a>
              </TD>
            </TR>
	      </TABLE>
    </TD>
    <TD width=2%></TD>
  </TR>
</TABLE>
</body>
</html>
