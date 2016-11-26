<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'actividad.label', default: 'Actividad')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-actividad" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-actividad" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            
            <table class="table table-condensed">
             <thead>
                <tr>
                     <th>ID</th>
                     <th>Nombre</th>
                     <th>Fecha</th>
                     <th>Activo</th>
                     <th>Programa</th>
                     <th>Tipo</th>
                     <th>Público</th>
                     <th>Lugar</th>
                </tr>
                </thead>
                <g:each var="actividad" in="${actividadList}">
                <tr>
                <td>${actividad.id}</td>
                <td>${actividad.nombre}</td>
                <td>${actividad.fecha}</td>
                <td>${actividad.activo}</td>
                <td>${actividad.programa.nombre}</td>
                <td>${actividad.tipo.nombre}</td>
                <td>${actividad.publico.nombre}</td>
                <td>${actividad.lugar.nombre}</td>
               
                </tr>
                </g:each>

            </table>

            <div class="pagination">
                <g:paginate total="${actividadCount ?: 0}" />
            </div>
        </div>
    </body>
</html>