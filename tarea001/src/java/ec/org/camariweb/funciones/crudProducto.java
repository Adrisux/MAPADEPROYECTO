package ec.org.camariweb.funciones;

import ec.org.camariweb.accesodatos.AccesoDatos;
import ec.org.camariweb.accesodatos.Parametro;
import ec.org.camariweb.accesodatos.ConjuntoResultado;
import ec.org.camariweb.entidades.clsProducto;
import java.util.ArrayList;

public  class crudProducto {
    public static boolean save(clsProducto producto){
        boolean resultado = false;
        String sql = "INSERT INTO public.producto(nombre, stock, precio_venta) VALUES(?,?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getNombre()));
        lstPar.add(new Parametro(2, producto.getStock()));
        lstPar.add(new Parametro(3, producto.getPrecio_venta()));        
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    
    public static boolean delete(clsProducto producto) {
        boolean res=false;
        String sql = "DELETE FROM public.producto WHERE id_producto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,producto.getId_producto()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }

    public static boolean update(clsProducto producto) {
        boolean res = false;
        String sql = "UPDATE public.producto " +
                "SET nombre=?,stock=?,precio_venta=? " + 
                "WHERE id_producto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1, producto.getNombre()));
        lstPar.add(new Parametro(2, producto.getStock()));
        lstPar.add(new Parametro(3, producto.getPrecio_venta()));  
        lstPar.add(new Parametro(4,producto.getId_producto()));
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }

    public static ArrayList<clsProducto> findbyAll() {
        ArrayList<clsProducto> listado = new ArrayList<>();
        String sql = "SELECT id_producto,nombre,stock,precio_venta "+
                "FROM public.producto";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsProducto producto = null;
            while (cres.next())
            {
                producto = new clsProducto();
                producto.setId_producto(cres.getInt("id_producto"));
                producto.setNombre(cres.getString("nombre"));
                producto.setStock(cres.getDouble("stock"));
                producto.setPrecio_venta(cres.getDouble("precio_venta"));
                listado.add((producto));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public static clsProducto findbyId(clsProducto ins) {
        clsProducto cliente = null;
        String sql = "SELECT id_producto,nombre,stock,precio_venta FROM public.producto WHERE id_producto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, ins.getId_producto()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                cliente = new clsProducto();
                cliente.setId_producto(cres.getInt("id_producto"));
                cliente.setNombre(cres.getString("nombre"));
                cliente.setStock(cres.getInt("stock"));
                cliente.setPrecio_venta(cres.getDouble("precio_venta"));             
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }
    public static clsProducto findbyId(int ide) {
        clsProducto cliente = null;
        String sql = "SELECT id_producto, nombre, stock, precio_venta FROM public.producto WHERE id_producto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,ide));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                cliente = new clsProducto();
                cliente.setId_producto(cres.getInt("id_producto"));
                cliente.setNombre(cres.getString("nombre"));
                cliente.setStock(cres.getInt("stock"));
                cliente.setPrecio_venta(cres.getDouble("precio_venta"));           
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }
    public static ArrayList<clsProducto> findbyStock(double stock) {
        ArrayList<clsProducto> listado = new ArrayList<>();
        String sql = "SELECT id_producto,nombre,stock,precio_venta "+
                "FROM public.producto WHERE stock < ?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(1, new Parametro (1,stock));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsProducto producto = null;
            while (cres.next())
            {
                producto = new clsProducto();
                producto.setId_producto(cres.getInt("id_producto"));
                producto.setNombre(cres.getString("nombre"));
                producto.setStock(cres.getInt("stock"));
                producto.setPrecio_venta(cres.getDouble("precioventa"));
                listado.add((producto));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
}
