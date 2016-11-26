package adminservice

class Actividad {
    String nombre
    String fecha
    String horario
    Programa programa
    Tipo tipo
    Publico publico
    boolean activo
    Lugar lugar
    
    static constraints = {
    	nombre nullable: false
    }
}
