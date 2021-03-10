package Persistencia.FactoriaDAO.Mysql;

import Modelo.Organizacion.Area;
import Modelo.Organizacion.Empleado;
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
    public ArrayList<Area> listado() {
        String sql ="SELECT * FROM Areas";
        ArrayList<Area> lista =null;
        
        EmpleadoDaoMysql daoEmp = new EmpleadoDaoMysql(conexion);
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            
            while (rs.next()) {
                Area area = new Area();
                area.setIdArea( rs.getString("idArea") );
                area.setNombreArea( rs.getString("NombreArea") );
                area.setPrefijo( rs.getString("prefijo") );
                area.setEmpleadoResp( daoEmp.buscar( rs.getString("idEmpleadoResponsable") ) );
                lista.add(area);
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return lista;
    }

    @Override
    public Area buscar(String idArea) {
        ArrayList<Area> lista =listado();
        
        Area area = null;
            
        for (Area p : lista) {
            if ( p.getIdArea().equals(idArea) ) {
                area = p;
                return area;
            }
        }
        
        return area;
    }
    
    
    @Override
    public Area buscarxEmpleado(Empleado emp) {
        ArrayList<Area> lista =listado();
        
        Area ar = null;
            
        for (Area a : lista) {
            
            if (a.getEmpleadoResp()!=null) {
                if ( a.getEmpleadoResp().getIdEmpleado().equals(emp.getIdEmpleado()) ) {
                    return a;
                }
            }
            
        }
        
        return ar;
    }
    
    @Override
    public Area registrar(Area obj) {
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
