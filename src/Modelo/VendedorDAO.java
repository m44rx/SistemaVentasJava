package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAO implements CRUD {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;


    public EntidadVendedor ValidarVendedor(String dni, String user) {
        EntidadVendedor ev = new EntidadVendedor();
        String sql = "select * from vendedor where Dni = ? and User = ?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                ev.setId(1);
                ev.setDni(rs.getString(2));
                ev.setNombres(rs.getString(3));
                ev.setTelefono(rs.getString(4));
                ev.setEstado(rs.getString(5));
                ev.setUser(rs.getString(6));
            }

        } catch (Exception e) {
        }

        return ev;
    }

    @Override
    public List listar() {
        List<EntidadVendedor> lista = new ArrayList<>();
        String sql = "select * from vendedor";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EntidadVendedor ev = new EntidadVendedor();
                //ev.setId(rs.getInt(0));
                ev.setId(rs.getInt(1));
                ev.setDni(rs.getString(2));
                ev.setNombres(rs.getString(3));
                ev.setTelefono(rs.getString(4));
                ev.setEstado(rs.getString(5));
                ev.setUser(rs.getString(6));
                lista.add(ev);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "insert into vendedor (Dni, Nombres, Telefono, Estado, User) values (?,?,?,?,?)";
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
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "update vendedor set Dni = ?, Nombres = ?, Telefono = ?, Estado = ?, User = ? where IdVEndedor = ?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);  //esta posición será para el IdVendedor
            r = ps.executeUpdate();
            System.out.println("IdVendedor: " + o[5]);
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "delete from vendedor where IdVendedor = ?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
