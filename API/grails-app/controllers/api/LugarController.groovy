package api

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LugarController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Lugar.list(params), model:[lugarCount: Lugar.count()]
    }

    def show(Lugar lugar) {
        respond lugar
    }

    @Transactional
    def save(Lugar lugar) {
        if (lugar == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (lugar.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond lugar.errors, view:'create'
            return
        }

        lugar.save flush:true

        respond lugar, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Lugar lugar) {
        if (lugar == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (lugar.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond lugar.errors, view:'edit'
            return
        }

        lugar.save flush:true

        respond lugar, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Lugar lugar) {

        if (lugar == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        lugar.delete flush:true

        render status: NO_CONTENT
    }
}
