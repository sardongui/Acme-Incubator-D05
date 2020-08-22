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

<acme:form>
	<acme:form-textbox code="investor.application.form.label.ticker" path="ticker" />
	<acme:form-moment code="investor.application.form.label.moment" path="moment" readonly="true"/>
	<acme:form-textarea code="investor.application.form.label.statement" path="statement" />
	<acme:form-money code="investor.application.form.label.moneyOffer" path="moneyOffer" />
	<jstl:if test="${command != 'create'}">
	<acme:form-textarea code="investor.application.form.label.investmentRound.ticker" path="investmentRound.ticker" />
	</jstl:if>
	<acme:form-hidden path="investId"/>
	
	
	<acme:form-submit test="${command == 'create'}" code="investor.application.form.button.create"
		action="/investor/application/create?investId=${investId}" />

	

	<acme:form-return code="investor.application.form.button.return" />
</acme:form>
