package Persistencia.FactoriaDAO.Mysql;

import Modelo.Area;
import Modelo.Empleado;
import Modelo.Proyecto;
import Modelo.Requerimiento;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Persistencia.FactoriaDAO.IRequerimientoDao;

public class RequerimientoDaoMysql implements IRequerimientoDao{
    private Connection conexion;

    public RequerimientoDaoMysql(Connection con) {
        conexion=con;
    }

    @Override
    public ArrayList<Requerimiento> listarRequerimientosxProyecto(String idProyecto) {
        String sql ="SELECT * FROM Requerimientos WHERE idProyecto = ? AND estado != 'APROBADO' AND estado != 'CERRADO'";
        ArrayList<Requerimiento> lista =null;
        
        AreaDaoMysql daoArea = new AreaDaoMysql(conexion);
        ProyectoDaoMysql daoProy = new ProyectoDaoMysql(conexion);
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, idProyecto);   
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            

            while (rs.next()) {
                Requerimiento req = new Requerimiento();
                
                req.setIdRequerimiento( rs.getString("idRequerimiento") );
                req.setEtapa(rs.getString("etapa") );
                req.setProyecto( daoProy.buscar( idProyecto ) );
                req.setArea( daoArea.buscar( rs.getString("idArea") ) );
                req.setEstado(rs.getString("estado"));
                lista.add(req);
            }
            rs.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println("AQUI");
            System.out.println(e.getMessage());
        } 
        
        return lista;
    }
    
    @Override
    public ArrayList<Requerimiento> listarRequerimientosxArea(String idArea) {
        String sql ="SELECT * FROM Requerimientos WHERE idArea = ? AND estado='PENDIENTE' ";
        ArrayList<Requerimiento> lista =null;
        
        AreaDaoMysql daoArea = new AreaDaoMysql(conexion);
        ProyectoDaoMysql daoProy = new ProyectoDaoMysql(conexion);
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, idArea);   
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            

            while (rs.next()) {
                Requerimiento req = new Requerimiento();
                
                req.setIdRequerimiento( rs.getString("idRequerimiento") );
                req.setEtapa(rs.getString("etapa") );
                req.setProyecto( daoProy.buscar( idArea ) );
                req.setArea( daoArea.buscar( rs.getString("idArea") ) );
                req.setEstado(rs.getString("estado"));
                lista.add(req);
            }
            rs.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println("AQUI");
            System.out.println(e.getMessage());
        } 
        
        return lista;
    }
    
    @Override
    public Requerimiento buscar(String idRequerimiento) {
        String sql ="SELECT * FROM Requerimientos WHERE idRequerimiento=?";
        Requerimiento req =null;
        
        AreaDaoMysql daoArea = new AreaDaoMysql(conexion);
        ProyectoDaoMysql daoProy = new ProyectoDaoMysql(conexion);
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, idRequerimiento);   
            
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            req = new Requerimiento();
            while (rs.next()) {
                
                req.setIdRequerimiento( rs.getString("idRequerimiento") );
                req.setEtapa(rs.getString("etapa") );
                req.setProyecto( daoProy.buscar( rs.getString("idProyecto")  ) );
                req.setArea( daoArea.buscar( rs.getString("idArea") ) );
                req.setEstado(rs.getString("estado"));
            }
            rs.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println("AQUI");
            System.out.println(e.getMessage());
        } 
        
        return req;
    }
    
    @Override
    public Requerimiento registrar(Requerimiento obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Requerimiento> listado() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Requerimiento actualizar(Requerimiento obj) {
       
         String sql ="update Requerimientos set idProyecto=?, etapa=?,idArea=?,estado=? where idRequerimiento=?";
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, obj.getProyecto().getIdProyecto());
            st.setString(2, obj.getEtapa());
            st.setString(3, obj.getArea().getIdArea());
            st.setString(4, obj.getNombreEstado());
            st.setString(5, obj.getIdRequerimiento()); 
            st.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return obj;
        
    }

    @Override
    public Requerimiento eliminar(Requerimiento obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
