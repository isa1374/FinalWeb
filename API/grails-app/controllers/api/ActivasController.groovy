package api

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.converters.JSON

@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN'])
class ActivasController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def consultar() {
        def act1=Actividad.where{
            activo==true
        }list()
        
        def valor=[]
        act1.each() {
            def data=[
                nombre:it.nombre,
                fecha:it.fecha,
                horario: it.horario,
                programa: it.programa.nombre,
                tipo:it.tipo.nombre,
                publico:it.publico.nombre,
                lugar:it.lugar.nombre
            ]
            valor.push(data)
        }
        render valor as JSON
    }
}

