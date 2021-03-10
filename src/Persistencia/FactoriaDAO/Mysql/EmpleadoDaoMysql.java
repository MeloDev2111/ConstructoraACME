package Persistencia.FactoriaDAO.Mysql;

import Modelo.Organizacion.Empleado;
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
    public ArrayList<Empleado> listado() {
        String sql ="SELECT * FROM Empleados";
        ArrayList<Empleado> lista = null;
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            
            ResultSet rs = st.executeQuery(); 
            lista = new ArrayList<>();

            UsuarioDaoMysql daoUser = new UsuarioDaoMysql(conexion);
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setIdEmpleado(rs.getString("idEmpleado"));
                em.setNombre(rs.getString("nombre"));
                em.setUser( daoUser.buscar( rs.getString("idUsuario") ) );
                lista.add(em);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return lista;
    }
    
    
    @Override
    public Empleado buscarxIdUsuario(String idUsuario) {
        
        ArrayList<Empleado> lista =listado();
        
        Empleado emp = null;
        for (Empleado p : lista) {
            if ( p.getUser().getIdUsuario().equals(idUsuario) ) {
                emp = p;
                return emp;
            }
        }
        
        return emp;
//        String sql ="SELECT * FROM Empleados WHERE idUsuario = ?";
//        Empleado em = null;
//        try {
//            PreparedStatement st = this.conexion.prepareStatement(sql);
//            st.setString(1, idUsuario);
//            
//            ResultSet rs = st.executeQuery(); 
//            em = new Empleado();
//            while (rs.next()) {
//                em.setIdEmpleado(rs.getString("idEmpleado"));
//                em.setNombre(rs.getString("nombre"));
//                //em.setUser(logi rs.getString(sql));
//            }
//            rs.close();
//            st.close();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } 
//        
//        return em;
    }
    
    @Override
    public Empleado buscar(String idEmpleado) {
        
        ArrayList<Empleado> lista =listado();
        
        Empleado emp = null;
            
        for (Empleado p : lista) {
            if ( p.getIdEmpleado().equals(idEmpleado) ) {
                emp = p;
                return emp;
            }
        }
        
        return emp;
//        
//        String sql ="SELECT * FROM Empleados WHERE idEmpleado = ?";
//        Empleado em = null;
//        try {
//            PreparedStatement st = this.conexion.prepareStatement(sql);
//            st.setString(1, idEmpleado);
//            
//            ResultSet rs = st.executeQuery(); 
//            em = new Empleado();
//            while (rs.next()) {
//                em.setIdEmpleado(rs.getString("idEmpleado"));
//                em.setNombre(rs.getString("nombre"));
//                //em.setUser(logi rs.getString(sql));
//            }
//            rs.close();
//            st.close();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } 
//        
//        return em;
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

}
