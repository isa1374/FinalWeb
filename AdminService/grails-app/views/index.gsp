<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Admin service</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
    <content tag="nav">
    </content>

    <div id="content" role="main">
        <ul>
            <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                <li class="controller">
                    <g:link controller="${c.logicalPropertyName}">${c.fullName.substring(13)}</g:link>
                </li>
            </g:each>
        </ul>
    </div>
</body>
</html>
