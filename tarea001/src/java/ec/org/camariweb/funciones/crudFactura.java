package ec.org.camariweb.funciones;

import ec.org.camariweb.accesodatos.AccesoDatos;
import ec.org.camariweb.accesodatos.Parametro;
import ec.org.camariweb.accesodatos.ConjuntoResultado;
import ec.org.camariweb.entidades.clsFactura;
import ec.org.camariweb.funciones.crudCliente;
import java.util.ArrayList;

public class crudFactura {
    public static boolean save(clsFactura factura){
        boolean resultado = false;
        String sql = "INSERT INTO public.factura(clienteid,fecha,iva,subtotal,total)"
                + " VALUES(?,?,?,?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, factura.getClienteid().getId_cliente()));
        lstPar.add(new Parametro(2, factura.getFecha()));
        lstPar.add(new Parametro(3, factura.getIva()));   
        lstPar.add(new Parametro(4, factura.getSubtotal()));
        lstPar.add(new Parametro(5, factura.getTotal())); 
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    
    public static boolean delete(clsFactura factura) {
        boolean res=false;
        String sql = "DELETE FROM public.factura WHERE numero_factura=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,factura.getNumero_factura()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }

    public static boolean update(clsFactura factura) {
        boolean res = false;
        String sql = "UPDATE public.factura " +
                "SET clienteid=?, fecha=?, iva=?, subtotal=?, total=? " + 
                "WHERE numero_factura=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1, factura.getClienteid()));
        lstPar.add(new Parametro(2, factura.getFecha()));
        lstPar.add(new Parametro(3, factura.getIva()));   
        lstPar.add(new Parametro(4, factura.getSubtotal()));
        lstPar.add(new Parametro(5, factura.getTotal()));  
        lstPar.add(new Parametro(6,factura.getNumero_factura()));
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }

    public static ArrayList<clsFactura> findbyAll() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT numero_factura, clienteid, fecha, iva, subtotal, total "+
                "FROM public.factura";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura factura = null;
            while (cres.next())
            {
                factura = new clsFactura();
                factura.setNumero_factura(cres.getInt("numero_factura"));
                factura.setClienteid(crudCliente.findbyId(cres.getInt("clienteid")));
                factura.setFecha(cres.getDate("fecha"));
                factura.setIva(cres.getDouble("iva"));
                factura.setSubtotal(cres.getDouble("subtotal"));
                factura.setTotal(cres.getDouble("total"));
                listado.add((factura));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public static clsFactura findbyId(clsFactura ins) {
        clsFactura factura = null;
        String sql = "SELECT numero_factura, clienteid, fecha, iva, subtotal, total FROM"
                + " public.factura WHERE numero_factura=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, ins.getNumero_factura()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                factura = new clsFactura();
                factura.setNumero_factura(cres.getInt("numero_factura"));
                factura.setClienteid(crudCliente.findbyId(cres.getInt("clienteid")));
                factura.setFecha(cres.getDate("fecha"));
                factura.setIva(cres.getDouble("iva"));
                factura.setSubtotal(cres.getDouble("subtotal"));
                factura.setTotal(cres.getDouble("total"));               
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return factura;
    }
    public static clsFactura findbyId(int ide) {
        clsFactura factura = null;
        String sql = "SELECT numero_factura, clienteid, fecha, iva, subtotal, total FROM"
                + " public.factura WHERE numero_factura=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,ide));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                factura = new clsFactura();
                factura = new clsFactura();
                factura.setNumero_factura(cres.getInt("numero_factura"));
                factura.setClienteid(crudCliente.findbyId(cres.getInt("clienteid")));
                factura.setFecha(cres.getDate("fecha"));
                factura.setIva(cres.getDouble("iva"));
                factura.setSubtotal(cres.getDouble("subtotal"));
                factura.setTotal(cres.getDouble("total")); 
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return factura;
    }
}
