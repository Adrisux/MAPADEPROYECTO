
package ec.org.camariweb.funciones;

import ec.org.camariweb.accesoDatos.AccesoDatos;
import ec.org.camariweb.accesoDatos.ConjuntoResultado;
import ec.org.camariweb.accesoDatos.Parametro;
import ec.org.camariweb.entidades.clsFactura;
//import ec.org.camariweb.entidades.clsFacturaProducto;
import java.util.ArrayList;


public class clsReportes {
    //listado de todos los clientes con compras mayores a $1000
    //mostrar el numero de factura,  fecha, factura y el nombre del cliente
    
    
    public ArrayList<clsFactura> clienteFacturaMayorMil() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT \n"
                + "  factura.numero_factura, \n"
                + "  factura.fecha, \n"
                + "  factura.total, \n"
                + "  cliente.nombre, \n"
                + "  cliente.ruc, \n"
                //+ "  factura.clienteid, \n"
                + "  cliente.id_cliente\n"
                + "FROM \n"
                + "  public.cliente  INNER JOIN, \n"
                + "  public.factura\n"
                + "ON \n"
                + "  cliente.id_cliente = factura.clienteid;"
                + " ORDER BY \n"
                + " cliente.nombre ABC";
        
        
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura factura = null;
            while (cres.next())
            {
                factura = new clsFactura();
                factura.setNumero_factura(cres.getInt("Numero"));
                factura.setFecha(cres.getDate("fecha"));
                factura.setTotal(cres.getDouble("total"));
                
                listado.add((factura));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    
    return listado;
}
}