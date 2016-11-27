package api


import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class Actividad {
    String nombre
    String fecha
    String horario 
    Programa programa 
    Tipo tipo 
    Publico publico 
    boolean activo 
    Lugar lugar 

}