
package ec.org.camariweb.test;

import ec.org.camariweb.entidades.clsProducto;
import ec.org.camariweb.funciones.crudProducto;


public class pruebaProducto {
     public static void main(String[] args) {
      clsProducto c = new clsProducto(1, "Laptops", 20, 869.05);
        //clsCliente d;
        crudProducto cc = new crudProducto();
        
        System.out.println("Prueba de clases");
        System.out.println("=============================================");
        System.out.println("contenido de la clase c");
        System.out.println(c.toString());
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("INSERTANDO");
        if (cc.save(c)) {
            System.out.println("Guardado");
        }else{
            System.out.println("error!!!!");
        }
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
//        
//        System.out.println("Comprobando si hay datos");
//        System.out.println(cc.findbyAll().toString());
//        System.out.println("=============================================");
//        System.out.println("=============================================");
//        System.out.println("Actualizando");    
//        if (cc.update(c)) {
//            System.out.println("actualizado");
//        }else{
//            System.out.println("no se ha podido actualizar");
//        }        
//}
}
}
   

