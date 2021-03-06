<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'lugar.label', default: 'Lugar')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-lugar" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-lugar" class="content scaffold-edit lugar-s" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.lugar}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.lugar}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.lugar}" method="PUT">
                <g:hiddenField name="version" value="${this.lugar?.version}" />
                <fieldset class="form">
                   <label>Nombre</label>  <g:textField name= "nombre" id="nombre" value="${lugar.nombre}" class="form-control"/>
                  <br>
                    <label>Municipio</label>  <g:textField name= "municipio" id="municipio" value="${lugar.municipio}" class="form-control"/>
                   <br>
                    <label>Dirección</label>  <g:textField name= "direccion" id="direccion" value="${lugar.direccion}" class="form-control"/>
                    <br>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
