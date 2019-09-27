<%@ include file="init.jsp" %>

<p>
	<b><liferay-ui:message key="myfirstmvc.caption"/></b>
</p>

<% 
   String bodystyle = renderRequest.getParameter("bodystyle");
   
%>

<div class="form-group">
    <label for="usr">bodystyle:</label>
  	<input type="text" class="form-control" name="<portlet:namespace />bodystyle" value="<%=bodystyle%>" readonly>
  </div>