package adminservice

import grails.test.mixin.*
import spock.lang.*

@TestFor(PublicoController)
@Mock(Publico)
class PublicoControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.publicoList
            model.publicoCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.publico!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def publico = new Publico()
            publico.validate()
            controller.save(publico)

        then:"The create view is rendered again with the correct model"
            model.publico!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            publico = new Publico(params)

            controller.save(publico)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/publico/show/1'
            controller.flash.message != null
            Publico.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def publico = new Publico(params)
            controller.show(publico)

        then:"A model is populated containing the domain instance"
            model.publico == publico
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def publico = new Publico(params)
            controller.edit(publico)

        then:"A model is populated containing the domain instance"
            model.publico == publico
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/publico/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def publico = new Publico()
            publico.validate()
            controller.update(publico)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.publico == publico

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            publico = new Publico(params).save(flush: true)
            controller.update(publico)

        then:"A redirect is issued to the show action"
            publico != null
            response.redirectedUrl == "/publico/show/$publico.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/publico/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def publico = new Publico(params).save(flush: true)

        then:"It exists"
            Publico.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(publico)

        then:"The instance is deleted"
            Publico.count() == 0
            response.redirectedUrl == '/publico/index'
            flash.message != null
    }
}
