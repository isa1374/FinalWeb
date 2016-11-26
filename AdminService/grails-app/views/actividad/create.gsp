<%@ page import="adminservice.Lugar" %>
<%@ page import="adminservice.Tipo" %>
<%@ page import="adminservice.Publico" %>
<%@ page import="adminservice.Programa" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'actividad.label', default: 'Actividad')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-actividad" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-actividad" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.actividad}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.actividad}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action="save">
                <fieldset class="form">
                    <label>Nombre</label>  <g:textField name= "nombre" id="nombre" value="${actividad.nombre}" class="form-control"/>
                    <label>Fecha</label>  <g:textField name="fecha" id="fecha" value="${actividad.fecha}" class="form-control"/>
                    <label>Horario</label><g:textField name="horario" id="horario" value="${actividad.horario}" class="form-control"/>
                    <label>Activo</label><g:checkBox  name="activo" value="${actividad?.activo}"/>
                   <label>Programa</label> <g:select class="sel" name="programa" from ="${Programa.list()}"  optionKey="id" optionValue="nombre"/>
                   <label>Tipo</label> <g:select class="sel" name="tipo" from ="${Tipo.list()}"  optionKey="id" optionValue="nombre"/>
                    <label>Público</label> <g:select class="sel" name="publico" from ="${Publico.list()}"  optionKey="id" optionValue="nombre"/>
                    <label>Lugar</label> <g:select class="sel" name="lugar" from ="${Lugar.list()}"  optionKey="id" optionValue="nombre"/>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
