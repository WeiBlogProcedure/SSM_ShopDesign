<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">

  </head>
  
 <FRAMESET frameSpacing=0 rows=111,* frameBorder=0>
     <FRAME name=top src="top.jsp" frameBorder=0 noResize scrolling=no>
     <FRAMESET frameSpacing=0 frameBorder=0 cols=220,*>
         <FRAME name=menu src="left.jsp" frameBorder=0 noResize>
         <FRAME name=manFrame src="right.jsp" frameBorder=0>
     </FRAMESET>
 </FRAMESET>
 
 
 <NOFRAMES>
        <p></p>
 </NOFRAMES>
</html>
