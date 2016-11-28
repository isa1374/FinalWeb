<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'lugar.label', default: 'Lugar')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-lugar" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-lugar" class="content scaffold-show lugar-s" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div class="row">
                <div class="col-md-5"></div>
                <div class="col-md-1"><label>Nombre</label></div>
                <div class="col-md-4">${lugar.nombre}</div>
            </div>
             <div class="row">
                <div class="col-md-5"></div>
                <div class="col-md-1"><label>Municipio</label></div>
                <div class="col-md-4">${lugar.municipio}</div>
            </div>
             <div class="row">
                <div class="col-md-5"></div>
                <div class="col-md-1"><label>Dirección</label></div>
                <div class="col-md-4">${lugar.direccion}</div>
            </div>
            <g:form resource="${this.lugar}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.lugar}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
