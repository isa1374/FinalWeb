package api

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController

@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class ActividadController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Actividad.list(params), model:[actividadCount: Actividad.count()]
    }

    def show(Actividad actividad) {
        respond actividad
    }

    @Transactional
    def save(Actividad actividad) {
        if (actividad == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (actividad.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond actividad.errors, view:'create'
            return
        }

        actividad.save flush:true

        respond actividad, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Actividad actividad) {
        if (actividad == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (actividad.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond actividad.errors, view:'edit'
            return
        }

        actividad.save flush:true

        respond actividad, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Actividad actividad) {

        if (actividad == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        actividad.delete flush:true

        render status: NO_CONTENT
    }
}
