package Persistencia.FactoriaDAO.Mysql;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Persistencia.FactoriaDAO.IUsuarioDao;
import Negocio.Usuario;

public class UsuarioDaoMysql implements IUsuarioDao{
    private Connection conexion;

    public UsuarioDaoMysql(Connection con) {
        conexion=con;
    }
    


    @Override
    public Usuario registrar(Usuario usuario) {
        String sql ="INSERT INTO Usuarios(nombreCuenta,contraseña,tipoCuenta) VALUES(?,?,?)";
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);//Codigo sql
            st.setString(1, usuario.getNombreUsuario());// replace ? número 1 con el nombre
            st.setString(2, usuario.getContraseña());
            st.setString(3, usuario.getTipoUsuario());
            st.executeUpdate();//Ejectura codigo sql cuando este tiene parametros
            
        } catch (Exception e) {
            System.out.println("error en registrar Usuario");
            System.out.println(e.getMessage());
        } 
        
        return usuario;
    }

    @Override
    public ArrayList<Usuario> listado() {
        String sql ="SELECT * FROM Usuarios";
        ArrayList<Usuario> lista =null;
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getString("idUsuario"));//parametro del nombre de la columna en la bd
                usuario.setNombreUsuario(rs.getString("nombreCuenta"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setTipoUsuario(rs.getString("tipoCuenta"));
                lista.add(usuario);
            }
            rs.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return lista;
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
        String sql ="UPDATE Usuarios set nombreCuenta=?, contraseña=?,tipoCuenta=? where idUsuario=? ";
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, usuario.getNombreUsuario());
            st.setString(2, usuario.getContraseña());
            st.setString(3, usuario.getTipoUsuario());
            st.setString(4, usuario.getIdUsuario());
            
            st.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return usuario;
    }

    @Override
    public Usuario eliminar(Usuario usuario) {
        String sql ="DELETE FROM Usuarios WHERE idUsuario=?";
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, usuario.getIdUsuario());
            st.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return usuario;
    }

    @Override
    public Usuario buscarxID(String idUsuario) {
        Usuario usuario = null;
        String sql ="SELECT * FROM Usuarios WHERE idUsuario = ?";
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, idUsuario);
            
            ResultSet rs = st.executeQuery(); 
            usuario = new Usuario();
            while (rs.next()) {
                usuario.setIdUsuario(rs.getString("idUsuario"));
                usuario.setNombreUsuario(rs.getString("nombreCuenta"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setTipoUsuario(rs.getString("tipoCuenta"));
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return usuario;
    }

    @Override
    public Usuario buscarxNombre(String nombreUsuario) {
                Usuario usuario = null;
        
        String sql ="SELECT * FROM Usuarios WHERE nombreCuenta=?";
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, nombreUsuario);
            
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO?
            usuario = new Usuario();
            while (rs.next()) {
                usuario.setIdUsuario(rs.getString("idUsuario"));
                usuario.setNombreUsuario(rs.getString("nombreCuenta"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setTipoUsuario(rs.getString("tipoCuenta"));
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return usuario;
    }

    @Override
    public ArrayList<Usuario> filtrar(String palabraClave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
