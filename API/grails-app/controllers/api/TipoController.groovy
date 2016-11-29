package api

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController

@Secured(['ROLE_ADMIN'])

@Transactional(readOnly = true)
class TipoController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Tipo.list(params), model:[tipoCount: Tipo.count()]
    }

    def show(Tipo tipo) {
        respond tipo
    }

    @Transactional
    def save(Tipo tipo) {
        if (tipo == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (tipo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tipo.errors, view:'create'
            return
        }

        tipo.save flush:true

        respond tipo, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Tipo tipo) {
        if (tipo == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (tipo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tipo.errors, view:'edit'
            return
        }

        tipo.save flush:true

        respond tipo, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Tipo tipo) {

        if (tipo == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        tipo.delete flush:true

        render status: NO_CONTENT
    }
}
