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

	<acme:form-textbox code="entrepreneur.application.form.label.ticker" path="ticker" readonly="true"/>
	<acme:menu-separator />
	<acme:form-textbox code="entrepreneur.application.form.label.referenceInvestmentRound" path="referenceInvestmentRound" readonly="true"/>
	<acme:form-textbox code="entrepreneur.application.form.label.InvestmentRoundEntrepreneur" path="InvestmentRoundEntrepreneur" readonly="true"/>
	<acme:menu-separator />
	<acme:form-moment code="entrepreneur.application.form.label.moment" path="moment" readonly="true"/>
	<acme:form-textbox code="entrepreneur.application.form.label.statement" path="statement" readonly="true"/>
	<acme:form-money code="entrepreneur.application.form.label.moneyOffer" path="moneyOffer"/>
	

	
	<acme:form-return code="entrepreneur.investmentRound.form.button.return" />
		
</acme:form>