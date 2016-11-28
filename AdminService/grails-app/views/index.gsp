<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Admin service</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
    <div id="content" role="main" class="container">
            <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                <div class="mainB">
                    <g:link controller="${c.logicalPropertyName}">${c.fullName.substring(13)}</g:link>
                </div>
            </g:each>
    </div>
</body>
</html>
