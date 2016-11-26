package adminservice

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PublicoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Publico.list(params), model:[publicoCount: Publico.count()]
    }

    def show(Publico publico) {
        respond publico
    }

    def create() {
        respond new Publico(params)
    }

    @Transactional
    def save(Publico publico) {
        if (publico == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (publico.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond publico.errors, view:'create'
            return
        }

        publico.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'publico.label', default: 'Publico'), publico.id])
                redirect publico
            }
            '*' { respond publico, [status: CREATED] }
        }
    }

    def edit(Publico publico) {
        respond publico
    }

    @Transactional
    def update(Publico publico) {
        if (publico == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (publico.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond publico.errors, view:'edit'
            return
        }

        publico.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'publico.label', default: 'Publico'), publico.id])
                redirect publico
            }
            '*'{ respond publico, [status: OK] }
        }
    }

    @Transactional
    def delete(Publico publico) {

        if (publico == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        publico.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'publico.label', default: 'Publico'), publico.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'publico.label', default: 'Publico'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
