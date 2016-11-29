package api

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.converters.JSON
import com.github.rahulsom.swaggydoc.*
import com.wordnik.swagger.annotations.*
import grails.converters.*;
@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN'])
@Api(value="Actividades activas")
class ActivasController {
     @ApiOperation(value = 'Listar actividades activas', httpMethod = "GET")

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

