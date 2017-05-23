/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.org.camariweb.entidades;

/**
 *
 * @author Lis
 */
public class clsFacturaProducto {
    private int _id_dfactura_producto;
    private clsFactura _factura;
    private clsProducto _producto;
    private int _cantidad;
    private double _subtotal;

    public clsFacturaProducto() {
    }

    public clsFacturaProducto(int _id_dfactura_producto, clsFactura _factura, clsProducto _producto, int _cantidad, double _subtotal) {
        this._id_dfactura_producto = _id_dfactura_producto;
        this._factura = _factura;
        this._producto = _producto;
        this._cantidad = _cantidad;
        this._subtotal = _subtotal;
    }

    public int getId_dfactura_producto() {
        return _id_dfactura_producto;
    }

    public void setId_dfactura_producto(int _id_dfactura_producto) {
        this._id_dfactura_producto = _id_dfactura_producto;
    }

    public clsFactura getFactura() {
        return _factura;
    }

    public void setFactura(clsFactura _factura) {
        this._factura = _factura;
    }

    public clsProducto getProducto() {
        return _producto;
    }

    public void setProducto(clsProducto _producto) {
        this._producto = _producto;
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
        return "clsFacturaProducto{" + "_id_dfactura_producto=" + _id_dfactura_producto + ", _factura=" + _factura + ", _producto=" + _producto + ", _cantidad=" + _cantidad + ", _subtotal=" + _subtotal + '}';
    }

    
    
}
