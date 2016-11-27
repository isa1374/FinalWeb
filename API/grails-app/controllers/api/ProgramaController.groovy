package api

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProgramaController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Programa.list(params), model:[programaCount: Programa.count()]
    }

    def show(Programa programa) {
        respond programa
    }

    @Transactional
    def save(Programa programa) {
        if (programa == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (programa.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond programa.errors, view:'create'
            return
        }

        programa.save flush:true

        respond programa, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Programa programa) {
        if (programa == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (programa.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond programa.errors, view:'edit'
            return
        }

        programa.save flush:true

        respond programa, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Programa programa) {

        if (programa == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        programa.delete flush:true

        render status: NO_CONTENT
    }
}
