package adminservice

class Programa {
    String nombre;
    static constraints = {
         nombre nullable: false, unique: true, blank:false
    }
}
