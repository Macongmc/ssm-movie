<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script>
	var ctx = "${ctx}";
    <%  request.getSession().setAttribute("loginUser", "789");
    request.getRequestDispatcher("mainPage.jsp").forward(request,response);
%>
</script>