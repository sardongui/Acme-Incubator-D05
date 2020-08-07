<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>

	<acme:list-column code="entrepreneur.application.list.label.ticker" path="ticker" width="40%" />
	<acme:list-column code="entrepreneur.application.list.label.moneyOffert" path="moneyOffer" width="40%" />
	
</acme:list>