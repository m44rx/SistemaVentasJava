package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentasDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;
    
    public String NroSerieVentas(){
        String serie = "";
        String sql = "select max(NumeroSerie) from ventas";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                serie = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return serie;
    }
    
    public String IdVentas(){
        String idv = "";
        String sql = "select max(IdVentas) from ventas";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                idv = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idv;
    }
    
    public int GuardarVentas(EntidadVenta v){
        EntidadVenta venta = new EntidadVenta();
        String sql = "insert into ventas (IdCliente, IdVendedor, NumeroSerie, FechaVentas, Monto, Estado) values (?, ?, ?, ?, ?, ?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getIdCliente());
            ps.setInt(2, v.getIdVendedor());
            ps.setString(3, v.getNumeroSerie());
            ps.setString(4,v.getFecha());
            ps.setDouble(5, v.getMonto());
            ps.setString(6,v.getEstado());
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public int GuardarDetalleVenta(EntidadDetalleVentas edv){
        String sql = "insert into detalle_ventas (IdVentas, IdProducto, Cantidad, PrecioVenta) values(?, ?, ?, ?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, edv.getIdVentas());
            ps.setInt(2, edv.getIdProducto());
            ps.setInt(3, edv.getCantidad());
            ps.setDouble(4, edv.getPrecioVenta());
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        
        return r;
    }
    
    
}
