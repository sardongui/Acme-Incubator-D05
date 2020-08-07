<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<input id="forumId" name="forumId" type="hidden" value="${param.forumId}"/>
	<acme:form-textbox code="authenticated.forum.form.label.title" path="title"/>
	<acme:form-textbox code="authenticated.forum.form.label.users" path="users"/>
	<acme:form-textbox code="authenticated.forum.form.label.investmentTitle" path="investmentRound.title"/>
	
	<acme:form-submit code="authenticated.forum.form.buttom.messages" action="/authenticated/message/list-mine?forumId=${id}" method="get" />
	<acme:form-return code="authenticated.forum.form.button.return"/>
</acme:form>