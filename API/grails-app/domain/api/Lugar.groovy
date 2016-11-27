package api


import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class Lugar {
    String nombre
    String direccion 
    String municipio 

}