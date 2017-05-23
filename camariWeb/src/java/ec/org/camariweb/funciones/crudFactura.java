
package ec.org.camariweb.funciones;

import ec.org.camariweb.accesoDatos.AccesoDatos;
import ec.org.camariweb.accesoDatos.ConjuntoResultado;
import ec.org.camariweb.accesoDatos.Parametro;
import ec.org.camariweb.entidades.clsFactura;
import java.util.ArrayList;

public class crudFactura {
    public static boolean save(clsFactura factura){
        boolean resultado = false;
        String sql = "INSERT INTO public.factura(id_cliente, fecha, subtotal, total, iva )"
                + "VALUES(?,?,?,?,?)";    
        
        
        ArrayList<Parametro> lstPar = new ArrayList<>();
        
        lstPar.add(new Parametro(1, factura.getCliente().getId_cliente()));
        lstPar.add(new Parametro(2, factura.getFecha()));
        lstPar.add(new Parametro(3, factura.getSubtotal()));
        lstPar.add(new Parametro(4, factura.getTotal()));
        lstPar.add(new Parametro(5, factura.getIva()));
        
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    
     public boolean delete(clsFactura fac) {
        boolean res=false;
        String sql = "DELETE FROM public.factura WHERE numero_factura=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,fac.getNumero_factura()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }

    public boolean update(clsFactura f) {
        boolean res = false;
        String sql = "UPDATE public.factura " +
                "SET id_cliente=?, fecha=?, subtotal=?, total=?, iva=?" + 
                "WHERE numero_factura=?";
        
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1, f.getCliente().getId_cliente()));
        lstPar.add(new Parametro(2, f.getFecha()));
        lstPar.add(new Parametro(3, f.getSubtotal()));
        lstPar.add(new Parametro(4, f.getTotal()));
        lstPar.add(new Parametro(5, f.getIva()));
        lstPar.add(new Parametro(9,f.getNumero_factura()));
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }

    public ArrayList<clsFactura> findbyAll() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT numero_factura, id_cliente, fecha, subtotal, total, iva "+
                "FROM public.factura";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura factura = null;
            while (cres.next())
            {
                factura = new clsFactura();
                factura.setNumero_factura(cres.getInt("numero factura"));
//              factura.setCliente(crudCliente("idCliente")));
                factura.setFecha(cres.getDate("fecha"));
                factura.setSubtotal(cres.getInt("subtotal"));
                factura.setTotal(cres.getInt("total"));
                factura.setIva(cres.getInt("iva"));
                
                listado.add((factura));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }


////    public clsFactura findbyId(clsFactura fa) {
////        clsFactura factura = null;
////        String sql = "SELECT id, idCliente, fecha, subtotal, iva, total, garantia, anulado, reimpresion "+
////                "FROM public.factura WHERE id=?";
////        ArrayList<Parametro> lstPar = new ArrayList<>();
////        lstPar.add(new Parametro(1, fa.getId()));
////        try {
////            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
////            while (cres.next()) {
////                factura = new clsFactura();
////                factura.setId(cres.getInt("id"));
////                factura.setId(cres.getInt("idCliente"));
////                factura.setFecha(cres.getDate("fecha"));
////                factura.setSubtotal(cres.getInt("subtotal"));
////                factura.setIva(cres.getInt("iva"));
////                factura.setTotal(cres.getInt("total"));
////                factura.setGarantia(cres.getString("garantia"));
////                factura.setAnulado(cres.getBoolean("anulado"));
////                factura.setReimpresion(cres.getBoolean("reimpresion"));
////            }
////        } catch (Exception e) {
////            System.out.println(e.getMessage());
////        }
////        return factura;
////    
////}
    public static clsFactura findbyId(int id) {
        clsFactura factura = null;
        String sql = "SELECT numero_factura, id_cliente, fecha, subtotal, total, iva  "+
                "FROM public.factura WHERE numero_factura=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                factura = new clsFactura();
                factura.setNumero_factura(cres.getInt("numero factura"));
                factura.getCliente();
                factura.setFecha(cres.getDate("fecha"));
                factura.setSubtotal(cres.getInt("subtotal"));
                factura.setTotal(cres.getInt("total"));
                factura.setIva(cres.getInt("iva"));
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return factura;
}
}
