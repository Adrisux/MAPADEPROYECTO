package ec.org.camariweb.entidades;
import java.util.Date;

public class clsFactura {
     private int _numero_factura;
     private clsCliente _clienteid;
     private Date _fecha;
     private double _subtotal;
     private double _iva;
     private double _total;

    public clsFactura() {
    }

    public clsFactura(int _numero_factura, clsCliente _clienteid, Date _fecha, double _subtotal, double _iva, double _total) {
        this._numero_factura = _numero_factura;
        this._clienteid = _clienteid;
        this._fecha = _fecha;
        this._subtotal = _subtotal;
        this._iva = _iva;
        this._total = _total;
    }

    public int getNumero_factura() {
        return _numero_factura;
    }

    public void setNumero_factura(int _numero_factura) {
        this._numero_factura = _numero_factura;
    }

    public clsCliente getClienteid() {
        return _clienteid;
    }

    public void setClienteid(clsCliente _clienteid) {
        this._clienteid = _clienteid;
    }

    public Date getFecha() {
        return _fecha;
    }

    public void setFecha(Date _fecha) {
        this._fecha = _fecha;
    }

    public double getSubtotal() {
        return _subtotal;
    }

    public void setSubtotal(double _subtotal) {
        this._subtotal = _subtotal;
    }

    public double getIva() {
        return _iva;
    }

    public void setIva(double _iva) {
        this._iva = _iva;
    }

    public double getTotal() {
        return _total;
    }

    public void setTotal(double _total) {
        this._total = _total;
    }

    @Override
    public String toString() {
        return "clsFactura{" + "_numero_factura=" + _numero_factura + ", _clienteid=" + _clienteid + ", _fecha=" + _fecha + ", _subtotal=" + _subtotal + ", _iva=" + _iva + ", _total=" + _total + '}';
    }

    
          
}
