
package ec.org.camariweb.controlador;

import ec.org.camariweb.entidades.clsDfacturaProducto;
import ec.org.camariweb.funciones.crudDfactura_producto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped

public class cDfacturaProducto {
     private List<clsDfacturaProducto> Lista;
    private clsDfacturaProducto newDFacturaProducto; //Cuando ingrese un producto nuevo 
    private clsDfacturaProducto selectedDFacturapProducto; // cuando selecione un Producto para borrar o actualizar

    public cDfacturaProducto() {
        
        newDFacturaProducto= new clsDfacturaProducto();
        cargarDatos();
    }
    
     private void cargarDatos(){
    
        Lista = crudDfactura_producto.findbyAll();
    }

     private void insertar(){
            if (crudDfactura_producto.save(newDFacturaProducto)){ //esta linea guarda el cliente
                newDFacturaProducto = new clsDfacturaProducto(); //prepara el constructor de un posible nuevo cliente
                cargarDatos();                  //refresca el datagrid con los cambios (Aparece el nuevo cliente)
                //mostrar mensaje
                
            }
            else
            {
                //mostrar mensaje de no guardado
            }
        }
        
        private void eliminar ()
        {
            if(crudDfactura_producto.delete(selectedDFacturapProducto)){
                if (crudDfactura_producto.save(newDFacturaProducto)){
                    
                    newDFacturaProducto = new clsDfacturaProducto();
                    cargarDatos();
                }
            }
        }
        
        
        private void actualizar ()
        {
             if(crudDfactura_producto.update(selectedDFacturapProducto)){
                if (crudDfactura_producto.save(newDFacturaProducto)){
                    
                    newDFacturaProducto = new clsDfacturaProducto();
                    cargarDatos();
                }
            }
        }

    public List<clsDfacturaProducto> getLista() {
        return Lista;
    }

    public void setLista(List<clsDfacturaProducto> Lista) {
        this.Lista = Lista;
    }

    public clsDfacturaProducto getNewDFacturaProducto() {
        return newDFacturaProducto;
    }

    public void setNewDFacturaProducto(clsDfacturaProducto newDFacturaProducto) {
        this.newDFacturaProducto = newDFacturaProducto;
    }

    public clsDfacturaProducto getSelectedDFacturapProducto() {
        return selectedDFacturapProducto;
    }

    public void setSelectedDFacturapProducto(clsDfacturaProducto selectedDFacturapProducto) {
        this.selectedDFacturapProducto = selectedDFacturapProducto;
    }

    @Override
    public String toString() {
        return "cDfacturaproducto{" + "Lista=" + Lista + ", newDFacturaProducto=" + newDFacturaProducto + ", selectedDFacturapProducto=" + selectedDFacturapProducto + '}';
    }
        
        
}
