<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-url code="authenticated.investmentRound.form.label.ticker" path="ticker"/>
	<acme:form-url code="authenticated.investmentRound.form.label.moment" path="moment"/>
	<acme:form-url code="authenticated.investmentRound.form.label.kindRound" path="kindRound"/>
	<acme:form-url code="authenticated.investmentRound.form.label.title" path="title"/>
	<acme:form-url code="authenticated.investmentRound.form.label.description" path="description"/>
	<acme:form-url code="authenticated.investmentRound.form.label.amountMoney" path="amountMoney"/>
	<acme:form-url code="authenticated.investmentRound.form.label.link" path="link"/>
	
	<a href=/acme-incubator/authenticated/work-programme/list?id=${id}><acme:message code="authenticated.workProgramme.list"/></a>
	
	<p></p>
	
	<acme:form-return code="authenticated.investmentRound.form.button.return"/>
</acme:form>