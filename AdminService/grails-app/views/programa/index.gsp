<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'programa.label', default: 'Programa')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-programa" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-programa" class="content scaffold-list prog-s" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div class="container">
            <table class="table table-condensed ">
             <thead>
                <tr>
                     <th>Nombre</th>
                </tr>
                </thead>
                <g:each var="prog" in="${programaList}">
                <tr>
                <td>${prog.nombre}</td>
                </g:each>
            </table>
            </div>
        </div>
    </body>
</html>