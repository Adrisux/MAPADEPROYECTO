//package ec.org.camariweb.logneg;
//
//import ec.org.camariweb.accesodatos.AccesoDatos;
//import ec.org.camariweb.accesodatos.ConjuntoResultado;
//import ec.org.camariweb.accesodatos.Parametro;
//import ec.org.camariweb.entidades.clsProducto;
//import ec.org.camariweb.funciones.crudProducto;
//import java.util.ArrayList;
//
//public class clslnProducto {
//    public boolean actualizastock(int idproducto, int nuevostock){
//        boolean resultado= false;
//        clsProducto pro=new clsProducto();
//        pro= crudProducto.findbyId(idproducto);
//        pro.setStock(pro.getStock()-nuevostock);
//        resultado= crudProducto.update(pro);
//        
//        return resultado;
//    }
//    public boolean actualizaprecio(int idproducto, double porcentaje){
//        boolean resultado=false;
//        clsProducto pro=new clsProducto();
//        pro= crudProducto.findbyId(idproducto);
//        pro.setPrecioventa(pro.getPrecioventa() + (pro.getPrecioventa() * (porcentaje/100)));
//        resultado = crudProducto.update(pro);
//        return resultado;
//    }
//    public boolean actualizarprecios(double porcentaje){
//        boolean resultado=false;
//        ArrayList<clsProducto> pro = new ArrayList<>();
//        pro=crudProducto.findbyAll();
//        for (clsProducto pro1 : pro) {
//                pro1.setPrecioventa(pro1.getPrecioventa() + pro1.getPrecioventa() * porcentaje/100);
//                resultado=crudProducto.update(pro1);
//            }           
//        return resultado;
//    }
//    public ArrayList<clsProducto> alerta(double porcentaje){
//        ArrayList<clsProducto> alerta=new ArrayList<>();
//        ArrayList<clsProducto> pro = new ArrayList<>();
//        pro=crudProducto.findbyAll();
//        for (clsProducto pro1 : pro) {
//                if (pro1.getStock()<5) {
//                    alerta.add(pro1);
//                }
//            }           
//        return alerta;
//    }
//    
//    
//}
