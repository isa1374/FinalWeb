package api


import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class Publico {
    String nombre

}