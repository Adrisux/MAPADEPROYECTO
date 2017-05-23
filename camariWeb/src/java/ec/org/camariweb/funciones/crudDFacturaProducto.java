
package ec.org.camariweb.funciones;

import ec.org.camariweb.accesoDatos.AccesoDatos;
import ec.org.camariweb.accesoDatos.ConjuntoResultado;
import ec.org.camariweb.accesoDatos.Parametro;
import ec.org.camariweb.entidades.clsFacturaProducto;
import java.util.ArrayList;


public class crudDFacturaProducto {
    
   
    public static boolean save(clsFacturaProducto dFactura){
        boolean resultado = false;
        String sql = "INSERT INTO public.detalleFactura(numero_factura, id_producto, cantidad, subtotal )"
                + "VALUES(?,?,?,?)";    
        
        
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro (1, dFactura.getFactura().getNumero_factura()));
        lstPar.add(new Parametro(2, dFactura.getProducto().getId_producto()));
        lstPar.add(new Parametro(3, dFactura.getCantidad()));
        lstPar.add(new Parametro(4, dFactura.getSubtotal()));
        
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return resultado;
    }
    
    
        public boolean delete(clsFacturaProducto dfac) {
        boolean res=false;
        String sql = "DELETE FROM public.dfacturaproducto WHERE id_dfactura_producto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,dfac.getId_dfactura_producto()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }

    public boolean update(clsFacturaProducto df) {
        boolean res = false;
        String sql = "UPDATE public.detalleFactura " +
                "SET numero_factura=?, id_producto=?, cantidad=?, subtotal=? " + 
                "WHERE id_dfactura_producto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1,df.getFactura().getNumero_factura()));
        lstPar.add(new Parametro(2,df.getProducto().getId_producto()));
        lstPar.add(new Parametro(3,df.getCantidad()));
        lstPar.add(new Parametro(5,df.getSubtotal()));
        
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }

    public ArrayList<clsFacturaProducto> findbyAll() {
        ArrayList<clsFacturaProducto> listado = new ArrayList<>();
        String sql = "SELECT id_dfactura_producto, numero_factura, id_producto, cantidad, subtotal"+
                "FROM public.dfacturaproducto";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFacturaProducto dfactura = null;
            while (cres.next())
            {
                dfactura = new clsFacturaProducto();
                dfactura.setId_dfactura_producto(cres.getInt("id_dfactura_producto"));
                dfactura.setFactura(crudFactura.findbyId(cres.getInt("numero_factura")));
                dfactura.setProducto(crudProducto.findbyId(cres.getInt("id_producto")));
                dfactura.setCantidad(cres.getInt("cantidad"));
                dfactura.setSubtotal(cres.getDouble("subtotal"));
                
                listado.add((dfactura));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
//
//    public clsFacturaProducto findbyId(clsFacturaProducto defa) {
//        clsFacturaProducto detallefactura = null;
//        String sql = "SELECT id, idfactura, idproducto, cantidad, valor, subtotal, estado "+
//                "FROM public.factura WHERE id=?";
//        ArrayList<Parametro> lstPar = new ArrayList<>();
//        lstPar.add(new Parametro(1, defa.getId()));
//        try {
//            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
//            while (cres.next()) {
//                detallefactura = new clsDetalleFactura();
//                detallefactura.setId(cres.getInt("id"));
//                detallefactura.setId(cres.getInt("idfactura"));
//                detallefactura.setId(cres.getInt("idproducto"));
//                detallefactura.setCantidad(cres.getInt("cantidad"));
//                detallefactura.setValor(cres.getInt("valor"));
//                detallefactura.setSubtotal(cres.getInt("subtotal"));
//                detallefactura.setEstado(cres.getString("estado"));
//                
//               
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return detallefactura;
//    
//}
//}
//
//    
//    
}
