<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-url code="entrepreneur.investmentRound.form.label.ticker" path="ticker"/>
	<acme:form-url code="entrepreneur.investmentRound.form.label.moment" path="moment"/>
	<acme:form-url code="entrepreneur.investmentRound.form.label.kindRound" path="kindRound"/>
	<acme:form-url code="entrepreneur.investmentRound.form.label.title" path="title"/>
	<acme:form-url code="entrepreneur.investmentRound.form.label.description" path="description"/>
	<acme:form-url code="entrepreneur.investmentRound.form.label.amountMoney" path="amountMoney"/>
	<acme:form-url code="entrepreneur.investmentRound.form.label.link" path="link"/>
	
	<a href=/acme-incubator/entrepreneur/work-programme/list?id=${id}><acme:message code="entrepreneur.workProgramme.list"/></a>
	
	<p></p>
	
	<acme:form-return code="entrepreneur.investmentRound.form.button.return"/>
</acme:form>