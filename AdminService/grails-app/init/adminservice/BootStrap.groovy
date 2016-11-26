package adminservice
import adminservice.*
    
class BootStrap {

    def init = { servletContext ->
        new Tipo(nombre:"deportivo").save();
        new Tipo(nombre:"teatro").save();
        new Tipo(nombre:"musical").save();
        new Tipo(nombre:"cultural").save();
        
        new Publico(nombre:"niños").save();
        new Publico(nombre:"adultos").save();
        new Publico(nombre:"familiar").save();
        new Publico(nombre:"mujeres").save();
        new Publico(nombre:"adultos mayores").save();
        
        new Programa(nombre:"cultural").save();
        new Programa(nombre:"paseo histórico").save();
        new Programa(nombre:"comunitario").save();
        new Lugar(nombre:"Casa de la cultura de Tlalpan",municipio:"Tlalpan", direccion:"Yunque 123").save();
    }
    def destroy = {
    }
}
