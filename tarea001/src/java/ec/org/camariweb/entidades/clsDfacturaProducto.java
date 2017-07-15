package ec.org.camariweb.entidades;

public class clsDfacturaProducto {
    private int _id_dfactura_producto;
    private clsFactura _numero_factura;
    private clsProducto _id_producto;
    private int _cantidad;
    private double _subtotal;

    public clsDfacturaProducto() {
    }

    public clsDfacturaProducto(int _id_dfactura_producto, clsFactura _numero_factura, clsProducto _id_producto, int _cantidad, double _subtotal) {
        this._id_dfactura_producto = _id_dfactura_producto;
        this._numero_factura = _numero_factura;
        this._id_producto = _id_producto;
        this._cantidad = _cantidad;
        this._subtotal = _subtotal;
    }

    public int getId_dfactura_producto() {
        return _id_dfactura_producto;
    }

    public void setId_dfactura_producto(int _id_dfactura_producto) {
        this._id_dfactura_producto = _id_dfactura_producto;
    }

    public clsFactura getNumero_factura() {
        return _numero_factura;
    }

    public void setNumero_factura(clsFactura _numero_factura) {
        this._numero_factura = _numero_factura;
    }

    public clsProducto getId_producto() {
        return _id_producto;
    }

    public void setId_producto(clsProducto _id_producto) {
        this._id_producto = _id_producto;
    }

    public int getCantidad() {
        return _cantidad;
    }

    public void setCantidad(int _cantidad) {
        this._cantidad = _cantidad;
    }

    public double getSubtotal() {
        return _subtotal;
    }

    public void setSubtotal(double _subtotal) {
        this._subtotal = _subtotal;
    }

    @Override
    public String toString() {
        return "clsDfacturaProducto{" + "_id_dfactura_producto=" + _id_dfactura_producto + ", _numero_factura=" + _numero_factura + ", _id_producto=" + _id_producto + ", _cantidad=" + _cantidad + ", _subtotal=" + _subtotal + '}';
    }

   
}
