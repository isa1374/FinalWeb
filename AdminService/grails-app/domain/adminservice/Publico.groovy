package adminservice

class Publico {
    String nombre;
    static constraints = {
         nombre nullable: false, unique: true, blank:false
    }
}
