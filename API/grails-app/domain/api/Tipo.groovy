package api


import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class Tipo {
    String nombre 

}