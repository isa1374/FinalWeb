<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'lugar.label', default: 'Lugar')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-lugar" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-lugar" class="content scaffold-list lugar-s" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <div class="container">
            <br>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <table class="table table-condensed ">
             <thead>
                <tr>
                     <th>Nombre</th>
                     <th>Municipio</th>
                     <th>Dirección</th>
                     <th>Actividades</th>
                </tr>
                </thead>
                <g:each var="lugar" in="${lugarList}">
                <tr>
                <td>${lugar.nombre}</td>
                <td>${lugar.municipio}</td>
                <td>${lugar.direccion}</td>
                <td> <g:each var="actividad" in="${lugar.actividades}">
                    <li>${actividad.nombre}</li>
                    </g:each>
                </td>
                </tr>
                </g:each>
            </table>
        </div>
            </div>
    </body>
</html>