<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-url code="investor.investmentRound.form.label.ticker" path="ticker"/>
	<acme:form-url code="investor.investmentRound.form.label.moment" path="moment"/>
	<acme:form-url code="investor.investmentRound.form.label.kindRound" path="kindRound"/>
	<acme:form-url code="investor.investmentRound.form.label.title" path="title"/>
	<acme:form-url code="investor.investmentRound.form.label.description" path="description"/>
	<acme:form-url code="investor.investmentRound.form.label.amountMoney" path="amountMoney"/>
	<acme:form-url code="investor.investmentRound.form.label.link" path="link"/>
	
	
	<!--<acme:form-submit test="${app == null}" code="investor.application.create"
		action="/investor/application/create?investId=${id}" />  -->
	
	<jstl:if test="${app ==null}">
		<a href=/acme-incubator/investor/application/create?investId=${id}><acme:message code="investor.application.create"/></a>
	</jstl:if>
	<jstl:if test="${app !=null}">
	<p>Usted ya ha solicitado este weon</p>
	</jstl:if>
	
	<acme:form-return code="investor.investmentRound.form.button.return"/>
</acme:form>