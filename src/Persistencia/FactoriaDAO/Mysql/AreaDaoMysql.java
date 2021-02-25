package Persistencia.FactoriaDAO.Mysql;

import Modelo.Area;
import Modelo.Empleado;
import Modelo.Proyecto;
import Persistencia.FactoriaDAO.IAreaDao;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AreaDaoMysql implements IAreaDao{
    private Connection conexion;

    public AreaDaoMysql(Connection con) {
        conexion=con;
    }

    @Override
    public Area buscar(String idArea) {
        String sql ="SELECT * FROM Areas WHERE idArea=?";
        Area area =null;
        
        EmpleadoDaoMysql daoEmp = new EmpleadoDaoMysql(conexion);
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, idArea);   
            
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            area = new Area();
            while (rs.next()) {
                area.setIdArea( rs.getString("idArea") );
                area.setNombreArea( rs.getString("NombreArea") );
                area.setPrefijo( rs.getString("prefijo") );
            }
            
            rs.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return area;
    }
    
    @Override
    public Area buscarxEmpleado(Empleado emp) {
        String sql ="SELECT * FROM Areas WHERE idEmpleadoResponsable=?";
        Area area =null;
        
        EmpleadoDaoMysql daoEmp = new EmpleadoDaoMysql(conexion);
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, emp.getIdEmpleado());   
            
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            area = new Area();
            while (rs.next()) {
                area.setIdArea( rs.getString("idArea") );
                area.setNombreArea( rs.getString("NombreArea") );
                area.setPrefijo( rs.getString("prefijo") );
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return area;
    }
    
    @Override
    public Area registrar(Area obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Area> listado() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Area actualizar(Area obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Area eliminar(Area obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
