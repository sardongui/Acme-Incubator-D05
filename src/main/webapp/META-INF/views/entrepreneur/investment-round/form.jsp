<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-url code="entrepreneur.investmentRound.form.label.ticker" path="ticker"/>
	<acme:form-url code="entrepreneur.investmentRound.form.label.moment" path="moment" readonly = "true"/>
	<acme:form-url code="entrepreneur.investmentRound.form.label.kindRound" path="kindRound"/>
	<acme:form-url code="entrepreneur.investmentRound.form.label.title" path="title"/>
	<acme:form-url code="entrepreneur.investmentRound.form.label.description" path="description"/>
	<acme:form-url code="entrepreneur.investmentRound.form.label.amountMoney" path="amountMoney"/>
	<acme:form-url code="entrepreneur.investmentRound.form.label.link" path="link"/>
	
	<a href=/acme-incubator/entrepreneur/work-programme/list?id=${id}><acme:message code="entrepreneur.workProgramme.list"/></a>
	
	<p></p>

	<acme:form-return code="entrepreneur.work-programme.form.button.create-workProgramme"
		action="/entrepreneur/work-programme/create?investmentRoundId=${id}" />

	<acme:form-submit test="${command == 'show'}" code="entrepreneur.investment-round.form.button.update"
		action="/entrepreneur/investment-round/update" />
	<acme:form-submit test="${command == 'show'}" code="entrepreneur.investment-round.form.button.delete"
		action="/entrepreneur/investment-round/delete" />
	<acme:form-submit test="${command == 'create'}" code="entrepreneur.investment-round.form.button.create"
		action="/entrepreneur/investment-round/create" />
	<acme:form-submit test="${command == 'update'}" code="entrepreneur.investment-round.form.button.update"
		action="/entrepreneur/investment-round/update" />
	<acme:form-submit test="${command == 'delete'}" code="entrepreneur.investment-round.form.button.delete"
		action="/entrepreneur/investment-round/delete" />
	
	<acme:form-return code="entrepreneur.investmentRound.form.button.return"/>
</acme:form>