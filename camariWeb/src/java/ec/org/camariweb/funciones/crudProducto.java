
package ec.org.camariweb.funciones;

import ec.org.camariweb.accesoDatos.AccesoDatos;
import ec.org.camariweb.accesoDatos.ConjuntoResultado;
import ec.org.camariweb.accesoDatos.Parametro;
import ec.org.camariweb.entidades.clsProducto;
import java.util.ArrayList;


public class crudProducto {
    
    public static boolean save(clsProducto producto){
        boolean resultado = false;
        String sql = "INSERT INTO public.producto(nombre, stock, precio_venta)"
                + "VALUES(?,?,?)";    
        
        
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro (1, producto.getNombre()));
        lstPar.add(new Parametro(2, producto.getStock()));
        lstPar.add(new Parametro(3, producto.getPrecio_venta()));
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    
     public boolean delete(clsProducto pro) {
        boolean res=false;
        String sql = "DELETE FROM public.producto WHERE id_producto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,pro.getId_producto()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }

    public boolean update(clsProducto p) {
        boolean res = false;
        String sql = "UPDATE public.producto " +
                "SET nombre=?, stock=?, precio_venta=? " + 
                "WHERE id_producto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1,p.getNombre()));
        lstPar.add(new Parametro(2,p.getStock()));
        lstPar.add(new Parametro(3,p.getPrecio_venta()));
        lstPar.add(new Parametro(4,p.getId_producto()));
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }

    public ArrayList<clsProducto> findbyAll() {
        ArrayList<clsProducto> listado = new ArrayList<>();
        String sql = "SELECT id_producto, nombre, stock, precio_venta "+
                "FROM public.producto";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsProducto producto = null;
            while (cres.next())
            {
                producto = new clsProducto();
                producto.setId_producto(cres.getInt("id"));
                producto.setNombre(cres.getString("nombre"));
                producto.setStock(cres.getDouble("stock"));
                producto.setPrecio_venta(cres.getDouble("precioventa"));
                
                
                listado.add((producto));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

//
//    public clsProducto findbyId(clsProducto pro) {
//        clsProducto producto = null;
//        String sql = "SELECT id, nombres, descripcion, stock, talla, estado, preciocompra, precioalquiler "+
//                "FROM public.producto WHERE id=?";
//        ArrayList<Parametro> lstPar = new ArrayList<>();
//        lstPar.add(new Parametro(1, pro.getId()));
//        try {
//            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
//            while (cres.next()) {
//                producto = new clsProducto();
//                producto.setId(cres.getInt("id"));
//                producto.setNombres(cres.getString("nombres"));
//                producto.setDescripcion(cres.getString("descripcion"));
//                producto.setStock(cres.getInt("stock"));
//                producto.setTalla(cres.getString("talla"));
//                producto.setEstado(cres.getString("estado"));
//                producto.setPreciocompra(cres.getInt("preciocompra"));
//                producto.setPrecioalquiler(cres.getInt("precioalquiler"));
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return producto;
//    }
//    
    public static clsProducto findbyId(int id) {
        clsProducto producto = null;
        String sql = "SELECT  id_producto, nombre, stock, preciocompra, precio_venta "+
                "FROM public.producto WHERE id_producto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                producto = new clsProducto();
                producto.setId_producto(cres.getInt("id"));
                producto.setNombre(cres.getString("nombre"));
                producto.setStock(cres.getDouble("stock"));
                producto.setPrecio_venta(cres.getDouble("precioventa"));
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return producto;
    }
}
