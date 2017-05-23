package ec.org.camariweb.test;


import ec.org.camariweb.entidades.clsCliente;
import ec.org.camariweb.funciones.crudCliente;


public class pruebaCliente {
 public static void main(String[] args) {
      clsCliente c = new clsCliente(3, "1600574295001", "KEVIN", "Ambato");
        //clsCliente d;
        crudCliente cc = new crudCliente();
        
//        System.out.println("Prueba de clases");
//        System.out.println("=============================================");
//        System.out.println("contenido de la clase c");
//        System.out.println(c.toString());
//        System.out.println("=============================================");
//        System.out.println("=============================================");
//        System.out.println("INSERTANDO");
//        if (cc.save(c)) {
//            System.out.println("Guardado");
//        }else{
//            System.out.println("error!!!!");
//        }
//        System.out.println("Comprobando si hay datos");
//        System.out.println(cc.findbyAll().toString());
//        System.out.println("=============================================");
//        System.out.println("=============================================");
//        System.out.println("Eliminando");    
//        if (cc.delete(c)) {
//            System.out.println("eliminado");
//        }else{
//            System.out.println("no se ha podido eliminar");
//        }
        
        System.out.println("Comprobando si hay datos");
        System.out.println(cc.findbyAll().toString());
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("Actualizando");    
        if (cc.update(c)) {
            System.out.println("actualizado");
        }else{
            System.out.println("no se ha podido actualizar");
        }        
}
}
   

