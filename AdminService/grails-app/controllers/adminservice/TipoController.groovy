package adminservice

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TipoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Tipo.list(params), model:[tipoCount: Tipo.count()]
    }

    def show(Tipo tipo) {
        respond tipo
    }

    def create() {
        respond new Tipo(params)
    }

    @Transactional
    def save(Tipo tipo) {
        if (tipo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tipo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tipo.errors, view:'create'
            return
        }

        tipo.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipo.label', default: 'Tipo'), tipo.id])
                redirect tipo
            }
            '*' { respond tipo, [status: CREATED] }
        }
    }

    def edit(Tipo tipo) {
        respond tipo
    }

    @Transactional
    def update(Tipo tipo) {
        if (tipo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tipo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tipo.errors, view:'edit'
            return
        }

        tipo.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tipo.label', default: 'Tipo'), tipo.id])
                redirect tipo
            }
            '*'{ respond tipo, [status: OK] }
        }
    }

    @Transactional
    def delete(Tipo tipo) {

        if (tipo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        tipo.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tipo.label', default: 'Tipo'), tipo.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipo.label', default: 'Tipo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
