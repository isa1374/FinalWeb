package adminservice

class Lugar {
    String nombre
    String direccion
    String municipio
    static hasMany = [actividades: Actividad]
    static constraints = {
        nombre nullable: false, unique: true, blank:false
    }
}
