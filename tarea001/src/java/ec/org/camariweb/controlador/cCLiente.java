package ec.org.camariweb.controlador;

import ec.org.camariweb.entidades.clsCliente;
import ec.org.camariweb.funciones.crudCliente;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class cCLiente {
    private List<clsCliente> lista;
    private clsCliente newCliente;
    private clsCliente selectedCliente;
   
    public cCLiente() {
        newCliente = new clsCliente();
        cargarDatos();        
    }
    private void cargarDatos() {
        lista= crudCliente.findbyAll();
    }

    public void insertar(){
        if (crudCliente.save(newCliente)) { //linea guarda el cliente 
           newCliente = new clsCliente();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje de guardar 
        }else{
        //TODO:mostrar mensaje de no guardardo 
        }
    }
    public void eliminar(){
        if (crudCliente.delete(selectedCliente)) {
            newCliente = new clsCliente();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje deeliminar 
        }else{
        //TODO:mostrar mensaje de no eliminado
        }
    }
    public void actualizar(){
        if (crudCliente.update(selectedCliente)) {
            newCliente = new clsCliente();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje de actualizar
        }else{
        //TODO:mostrar mensaje de no actualizar
        }
    }
    public List<clsCliente> getLista() {
        return lista;
    }
     
    

    public clsCliente getNewCliente() {
        return newCliente;
    }

    public void setNewCliente(clsCliente newCliente) {
        this.newCliente = newCliente;
    }

    public clsCliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(clsCliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }  
}
