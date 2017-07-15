
package ec.org.camariweb.test;

import ec.org.camariweb.entidades.clsCliente;
import ec.org.camariweb.funciones.crudCliente;


public class Pruebacliente {
    
    public static void main(String[] args) {
      clsCliente c = new clsCliente(3, "17044418172", "Ramiro", "Loja");
        //clsCliente d;
        crudCliente cc = new crudCliente();
        
        System.out.println("Prueba de clases");
        System.out.println("=============================================");
        System.out.println("contenido de la clase c");
        System.out.println(c.toString());
        System.out.println("=============================================");
        System.out.println("INSERTANDO");
        if (cc.save(c)) {
            System.out.println("Guardado");
        }else{
            System.out.println("error!!!!");
        }
    
}
}