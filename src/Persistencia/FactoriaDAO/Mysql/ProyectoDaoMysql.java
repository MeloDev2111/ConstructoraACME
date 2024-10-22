package Persistencia.FactoriaDAO.Mysql;

import Modelo.Organizacion.Proyecto;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Persistencia.FactoriaDAO.IProyectoDao;

public class ProyectoDaoMysql implements IProyectoDao{
    private Connection conexion;

    public ProyectoDaoMysql(Connection con) {
        conexion=con;
    }

    
    @Override
    public ArrayList<Proyecto> listado() {
        String sql ="SELECT * FROM Proyectos";
        ArrayList<Proyecto> lista =null;
        
        EmpleadoDaoMysql daoEmp = new EmpleadoDaoMysql(conexion);
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql); 
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            while (rs.next()) {
                Proyecto pro = new Proyecto();
                pro.setIdProyecto(rs.getString("idProyecto"));
                pro.setNombreProyecto(rs.getString("nombreProyecto"));
                pro.setEmpleado(daoEmp.buscar(rs.getString("idEmpleado")));
                lista.add(pro);
            }
            rs.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return lista;
    }
    
    
    
    
    @Override
    public ArrayList<Proyecto> listarProyectosxEmpleado(String idEmpleado) {
        
        ArrayList<Proyecto> lista =listado();
        
        ArrayList<Proyecto> listaFiltrada = new ArrayList();
            
        for (Proyecto p : lista) {
            
            if (p.getEmpleado()!=null) {
                if ( p.getEmpleado().getIdEmpleado().equals(idEmpleado) ) {
                    listaFiltrada.add(p);
                }
            }
            
        }
        
        return listaFiltrada;

    }
    
    
    @Override
    public Proyecto buscar(String idProyecto) {
        String sql ="SELECT * FROM Proyectos WHERE idProyecto=?";
        Proyecto pro =null;
        
        EmpleadoDaoMysql daoEmp = new EmpleadoDaoMysql(conexion);
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, idProyecto);   
            
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            pro = new Proyecto();
            while (rs.next()) {
                pro.setIdProyecto(rs.getString("idProyecto"));
                pro.setNombreProyecto(rs.getString("nombreProyecto"));
                pro.setEmpleado(daoEmp.buscar(rs.getString("idEmpleado")));
            }
            
            rs.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return pro;
    }
    
    @Override
    public Proyecto registrar(Proyecto obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Proyecto actualizar(Proyecto obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Proyecto eliminar(Proyecto obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
