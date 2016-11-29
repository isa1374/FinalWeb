package api

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController

@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class PublicoController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Publico.list(params), model:[publicoCount: Publico.count()]
    }

    def show(Publico publico) {
        respond publico
    }

    @Transactional
    def save(Publico publico) {
        if (publico == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (publico.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond publico.errors, view:'create'
            return
        }

        publico.save flush:true

        respond publico, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Publico publico) {
        if (publico == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (publico.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond publico.errors, view:'edit'
            return
        }

        publico.save flush:true

        respond publico, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Publico publico) {

        if (publico == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        publico.delete flush:true

        render status: NO_CONTENT
    }
}
