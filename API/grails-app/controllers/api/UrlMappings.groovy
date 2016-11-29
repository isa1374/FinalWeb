package api

class UrlMappings {

    static mappings = {
        "/api/actividades"(resources:"actividades")
        "/api/lugares"(resources:"lugares")
        "/api/prpgramas"(resources:"programas")
        "/api/publicos"(resources:"publicos")
        "/api/tipos"(resources:"tipos")
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")
        
        "/activas"(controller:"activas", action:"consultar")
        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
        "/myapi" (controller: "api")
    }
}
