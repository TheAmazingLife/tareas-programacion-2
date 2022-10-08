package tarea1;

import java.time.LocalDate;
import java.util.ArrayList;

class OrdenCompra {

    private final Cliente cliente;
    private String estado;
    protected LocalDate fecha;
    protected ArrayList<DetalleOrden> pedido;

    public OrdenCompra(String estado, Cliente cliente, int doc) {
        this.fecha = LocalDate.now();
        this.estado = estado;
        this.fecha = LocalDate.now();
        this.cliente = cliente;
        pedido = new ArrayList();

        DocTributario docTributario = null;

        switch (doc) {
            case 1:
                docTributario = new Boleta("111", cliente.getRut(), fecha, cliente.getDireccion());
                break;
            case 2:
                docTributario = new Factura("111", cliente.getRut(), fecha, cliente.getDireccion());
                break;
        }
    }

    public void anadirDetalle(int n, Articulo articulo) {
        DetalleOrden detalleOrden = new DetalleOrden(n, articulo);
        pedido.add(detalleOrden);
    }

    public float calcPrecioSinIVA() {
        float ans = 0;
        for (int i = 0; i < pedido.size(); i++) {
            ans += pedido.get(i).calcPrecioSinIVA();
        }
        return ans;
    }

    public float calcIVA() {
        float ans = 0;
        for (int i = 0; i < pedido.size(); i++) {
            ans += pedido.get(i).calcIVA();
        }
        return ans;
    }

    public float calcPrecio() {
        float ans = 0;
        for (int i = 0; i < pedido.size(); i++) {
            ans += pedido.get(i).calcPrecio();
        }
        return ans;
    }

    public float calcPeso() {
        float ans = 0;
        for (int i = 0; i < pedido.size(); i++) {
            ans += pedido.get(i).calcPeso();
        }
        return ans;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String ToString() {
        String string = cliente.toString();
        string += pedido.toString();
        return string;
    }
}

/*
OrdenCompra TERMINAR LA COMPRA
arreglar DetalleOrden a favor

 */
