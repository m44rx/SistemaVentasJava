package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements CRUD {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public EntidadCliente listarID(String dni) {
        EntidadCliente ec = new EntidadCliente();
        String sql = "select * from cliente where Dni = ?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            while ( rs.next()){
                ec.setId(rs.getInt(1));
                ec.setDni(rs.getString(2));
                ec.setNombres(rs.getString(3));
                ec.setDireccion(rs.getString(4));
                ec.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return ec;
    }

    @Override
    public List listar() {
        List<EntidadCliente> lista = new ArrayList<>();
        String sql = "select * from cliente";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EntidadCliente ec = new EntidadCliente();
                ec.setId(rs.getInt(1));
                ec.setDni(rs.getString(2));
                ec.setNombres(rs.getString(3));
                ec.setDireccion(rs.getString(4));
                ec.setEstado(rs.getString(5));
                lista.add(ec);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "insert into cliente (Dni, Nombres, Direccion, Estado) values (?,?,?,?)";
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
        String sql = "update cliente set Dni=?, Nombres=?, Direccion=?, Estado=? where IdCliente=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate();
            System.out.println("Objeto" + o[4]);
        } catch (Exception e) {
        }
        return r;

    }

    @Override
    public void eliminar(int id) {
        String sql = "delete from cliente where IdCliente = ?";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
