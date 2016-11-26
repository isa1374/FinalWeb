package adminservice

class Tipo {
    String nombre;
    static constraints = {
         nombre nullable: false, unique: true, blank:false
    }
}
