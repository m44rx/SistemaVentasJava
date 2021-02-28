package Modelo;

public class EntidadVenta {
    int id;
    int idCliente;
    int idVendedor;
    String numeroSerie;
    String fecha;
    double monto;
    String estado;

    public EntidadVenta() {
    }

    public EntidadVenta(int id, int idcliente, int idvendedor, String numeroserie, String fecha, double monto, String estado) {
        this.id = id;
        this.idCliente = idcliente;
        this.idVendedor = idvendedor;
        this.numeroSerie = numeroserie;
        this.fecha = fecha;
        this.monto = monto;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
