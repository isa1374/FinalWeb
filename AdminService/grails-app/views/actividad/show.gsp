<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'actividad.label', default: 'Actividad')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-actividad" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-actividad" class="content scaffold-show actividad-s" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
           <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div class="row">
                <div class="col-md-5"></div>
                <div class="col-md-1"><label>Nombre</label></div>
                <div class="col-md-4">${actividad.nombre}</div>
            </div>
            <div class="row">
                <div class="col-md-5"></div>
                <div class="col-md-1"><label>Fecha</label></div>
                <div class="col-md-4">${actividad.fecha}</div>
            </div>
            <div class="row">
                <div class="col-md-5"></div>
                <div class="col-md-1"><label>Horario</label></div>
                <div class="col-md-4">${actividad.horario}</div>
            </div>
            <div class="row">
                 <div class="col-md-5"></div>
                <div class="col-md-1"><label>Activo</label></div>
                <div class="col-md-4">${actividad.activo}</div>
            </div>
            <div class="row">
                 <div class="col-md-5"></div>
                <div class="col-md-1"><label>Programa</label></div>
                <div class="col-md-4">${actividad.programa.nombre}</div>
            </div>
             <div class="row">
                 <div class="col-md-5"></div>
                <div class="col-md-1"><label>Tipo</label></div>
                <div class="col-md-4">${actividad.tipo.nombre}</div>
            </div>
             <div class="row">
                 <div class="col-md-5"></div>
                <div class="col-md-1"><label>Lugar</label></div>
                <div class="col-md-4">${actividad.lugar.nombre}</div>
            </div>
            <div class="row">
                 <div class="col-md-5"></div>
                <div class="col-md-1"><label>Público</label></div>
                <div class="col-md-4">${actividad.publico.nombre}</div>
            </div>
            <g:form resource="${this.actividad}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.actividad}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
