
<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form >
<input id="investmentRoundId" name="investmentRoundId" type="hidden" value="${param.investmentRoundId}"/>
<jstl:if test="${command !='create' }">

	<acme:form-textbox code="bookkeeper.accounting-record.form.label.title" path="title"/>
	<acme:form-moment code="bookkeeper.accounting-record.form.label.creationMoment" path="creationMoment" readonly="true"/>
	<acme:form-textbox code="bookkeeper.accounting-record.form.label.body" path="body"/>	
	<acme:form-select code="bookkeeper.accounting-record.form.label.finalMode" path="finalMode" >
			<acme:form-option code="bookkeeper.accounting-record.form.label.finalMode.accepted" value="true" />
			<acme:form-option code="bookkeeper.accounting-record.form.label.finalMode.rejected" value="false" />
		</acme:form-select>
	<acme:form-return  code="bookkeeper.accounting-record.form.button.return"/>
	<jstl:if test="${!finalMode }">
	<acme:form-submit test="${idbookkeeper==idprincipal}" code="bookkeeper.accounting-record.form.button.update" action="/bookkeeper/accountingRecord/update?id=${id}" />
	</jstl:if>
	</jstl:if>
	
	<jstl:if test="${command=='create' }">
	
	<acme:form-textbox code="bookkeeper.accounting-record.form.label.title" path="title"/>
	<acme:form-textbox code="bookkeeper.accounting-record.form.label.body" path="body"/>	
	<acme:form-select code="bookkeeper.accounting-record.form.label.finalMode" path="finalMode" >
			<acme:form-option code="bookkeeper.accounting-record.form.label.finalMode.accepted" value="true" />
			<acme:form-option code="bookkeeper.accounting-record.form.label.finalMode.rejected" value="false" />
		</acme:form-select>
	<acme:form-submit code="bookkeeper.accounting-record.form.button.create" action="/bookkeeper/accountingRecord/create"/>
	<acme:form-return  code="bookkeeper.accounting-record.form.button.return"/>

	</jstl:if>
	</acme:form>


