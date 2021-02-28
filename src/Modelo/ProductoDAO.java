package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements CRUD {
    
    int r;
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public int actualizarStock(int cant, int idp){
        String sql = "update producto set Stock = ? where IdProducto = ?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setInt(2, idp);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public EntidadProducto listarID(int id){
        EntidadProducto ep = new EntidadProducto();
        String sql = "select * from producto where IdProducto = ?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while ( rs.next()){
                ep.setId(rs.getInt(1));
                ep.setNombres(rs.getString(2));
                ep.setPrecio(rs.getDouble(3));
                ep.setStock(rs.getInt(4));
                ep.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return ep;
    }
    
    
    @Override
    public List listar() {
        List<EntidadProducto> lista = new ArrayList<>();
        String sql = "select * from producto";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EntidadProducto ep = new EntidadProducto();
                ep.setId(rs.getInt(1));
                ep.setNombres(rs.getString(2));
                ep.setPrecio(rs.getDouble(3));
                ep.setStock(rs.getInt(4));
                ep.setEstado(rs.getString(5));
                lista.add(ep);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "insert into producto (Nombres, Precio, Stock, Estado) values (?, ?, ?, ?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);

            r = ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "update producto set Nombres = ?, Precio = ?, Stock = ?, Estado = ? where IdProducto = ?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);

            r = ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "delete from producto where IdProducto = ?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);   //config el tipo variable que ingresaremos para ?, con setInt**
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
