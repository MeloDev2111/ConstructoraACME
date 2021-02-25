package Persistencia.FactoriaDAO.Mysql;

import Modelo.Empleado;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Persistencia.FactoriaDAO.IEmpleadoDao;

public class EmpleadoDaoMysql implements IEmpleadoDao{
    private Connection conexion;

    public EmpleadoDaoMysql(Connection con) {
        conexion=con;
    }

    @Override
    public Empleado buscarxIdUsuario(String idUsuario) {
        String sql ="SELECT * FROM Empleados WHERE idUsuario = ?";
        Empleado em = null;
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, idUsuario);
            
            ResultSet rs = st.executeQuery(); 
            em = new Empleado();
            while (rs.next()) {
                em.setIdEmpleado(rs.getString("idEmpleado"));
                em.setNombre(rs.getString("nombre"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return em;
    }
    
    @Override
    public Empleado buscar(String idEmpleado) {
        String sql ="SELECT * FROM Empleados WHERE idEmpleado = ?";
        Empleado em = null;
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, idEmpleado);
            
            ResultSet rs = st.executeQuery(); 
            em = new Empleado();
            while (rs.next()) {
                em.setIdEmpleado(rs.getString("idEmpleado"));
                em.setNombre(rs.getString("nombre"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return em;
    }

    @Override
    public Empleado registrar(Empleado obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado actualizar(Empleado obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado eliminar(Empleado obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Empleado> listado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
