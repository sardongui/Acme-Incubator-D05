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

	<acme:form-url code="patron.banner.form.label.picture" path="picture" />
	<acme:form-textbox code="patron.banner.form.label.slogan" path="slogan" />
	<acme:form-url code="patron.banner.form.label.url" path="url" />
	<acme:form-textbox code="patron.banner.form.label.holderName" path="holderName" />
	<acme:form-textbox code="patron.banner.form.label.number" path="number" placeholder="1111 2222 3333 4444"/>
	<acme:form-textbox code="patron.banner.form.label.brand" path="brand" />
	<acme:form-integer code="patron.banner.form.label.monthExpiration" path="monthExpiration" placeholder="1 - 12"/>
	<acme:form-integer code="patron.banner.form.label.yearExpiration" path="yearExpiration" placeholder="2021"/>
	<acme:form-textbox code="patron.banner.form.label.cvv" path="cvv" placeholder="123"/>
	
	
	<acme:form-submit test="${command == 'create'}" code="patron.banner.form.button.create" action="create" />
	<acme:form-submit test="${command != 'create'}" code="patron.banner.form.button.update" action="update" />
	<acme:form-submit test="${command != 'create'}" code="patron.banner.form.button.delete" action="delete" />
	
	
	<acme:form-return code="patron.banner.form.button.return" />
	
</acme:form>