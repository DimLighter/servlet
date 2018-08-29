<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/jerry"  prefix="jerry"%>
<html>
<body>
<h2>Hello World2!</h2>
<form action="${pageContext.request.contextPath}/login" method="post">
    用户名：<input type="text" name="username">
    <br/>
    密码：<input type="text" name="password">
    <br/>
    兴趣：<input type="checkbox" name="inst" value="唱歌">唱歌<br/>
          <input type="checkbox" name="inst" value="游泳">游泳<br/>
          <input type="checkbox" name="inst" value="跳舞">跳舞<br/>
          <input type="checkbox" name="inst" value="编程" checked>编程<br/>
          <input type="checkbox" name="inst" value="上网">上网<br/>
    <input type="submit"/>

    <hr/>
    <%
        //在jsp页面中使用java代码获取客户端IP地址
        String ip = request.getRemoteAddr();
        out.write(ip);
    %>

    <hr/>
    你的IP地址是(使用自定义标签获取输出)：
    <%--使用自定义标签viewIP --%>
    <jerry:myTag/>
</form>


</body>
</html>
