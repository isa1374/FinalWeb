package adminservice
import adminservice.*
    
class BootStrap {

    def init = { servletContext ->
        new Tipo(nombre:"deportivo").save();
        new Tipo(nombre:"danza").save();
        new Tipo(nombre:"musical").save();
        new Tipo(nombre:"teatro").save();
        new Tipo(nombre:"educativo").save();
        
        new Publico(nombre:"niños").save();
        new Publico(nombre:"adultos").save();
        new Publico(nombre:"familiar").save();
        new Publico(nombre:"mujeres").save();
        new Publico(nombre:"adultos mayores").save();
        
        new Programa(nombre:"cultural").save();
        new Programa(nombre:"paseo histórico").save();
        new Programa(nombre:"comunitario").save();
        
        new Lugar(nombre:"Museo Soumaya",municipio:"Miguel Hidalgo", direccion:"Boulervard Miguel de Cervantes Saavedra 303, Granada, Miguel Hidalgo, 11529 Ciudad de México, CDMX").save();
        new Lugar(nombre:"Castillo de Chapultepec",municipio:"Miguel Hidalgo", direccion:"Bosque de Chapultepec I, Bosque de Chapultepec I Secc, 11100 Ciudad de México, CDMX").save();
        new Lugar(nombre:"Museo de Antropología",municipio:"Miguel Hidalgo", direccion:"Av Paseo de la Reforma & Calzada Gandhi S/N, Chapultepec Polanco, Miguel Hidalgo, 11560 Ciudad de México, CDMX").save();
        new Lugar(nombre:"Sala Ollin Yoliztli",municipio:"Tlalpan", direccion:"Anillo Periférico Sur 5141, Tlalpan, Isidro Fabela, 14030 Ciudad de México, CDMX").save();
        new Lugar(nombre:"Teatro Sergio Magaña",municipio:"Cuauhtémoc", direccion:"Calle Sor Juana Inés de la Cruz 114, Sta María la Ribera, 06400 Ciudad de México, CDMX").save();
        new Lugar(nombre:"Palacio de Bellas Artes",municipio:"Miguel Hidalgo", direccion:"Boulervard Miguel de Cervantes Saavedra 303, Granada, Miguel Hidalgo, 11529 Ciudad de México, CDMX").save();
        
        new Actividad(nombre:"La inocente inconveniencia",fecha:"Del 18 Noviembre 2016 al 04 Diciembre 2016",horario:"09:00 - 22:00",programa:1,tipo:2,publico:2,activo:true,lugar:5).save();
        new Actividad(nombre:"Orquesta Filarmónica de la Ciudad de México",fecha:"Sábado 3 de Diciembre 2016",horario:"20:00 hrs",programa:1,tipo:3,publico:3,activo:true,lugar:4).save();
        new Actividad(nombre:"Conciertos en el museo",fecha:"Sábado 26 de Noviembre 2016",horario:"12:00 hrs",programa:1,tipo:3,publico:3,activo:true,lugar:3).save();
        new Actividad(nombre:"Imperio",fecha:"Sábados de Diciembre 2016",horario:"20:00 hrs",programa:1,tipo:4,publico:2,activo:true,lugar:2).save();
        new Actividad(nombre:"Taller Abecedario en lengua de señas mexicanas",fecha:"Jueves 1 de Diciembre 2016",horario:"11:00 hrs",programa:3,tipo:5,publico:3,activo:true,lugar:1).save();
        new Actividad(nombre:"Ballet Folklórico de México de Amalia Hernández",fecha:"Miércoles 30 de Noviembre 2016",horario:"20:030 hrs",programa:1,tipo:2,publico:3,activo:true,lugar:6).save();

    }
    def destroy = {
    }
}
