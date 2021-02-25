package Persistencia.FactoriaDAO.Mysql;

import Modelo.Suministros.Material;
import Persistencia.FactoriaDAO.IMaterialDao;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MaterialDaoMysql implements IMaterialDao{
    private Connection conexion;

    public MaterialDaoMysql(Connection con) {
        conexion=con;
    }

    @Override
    public Material buscar(String id) {
        String sql ="SELECT * FROM Materiales WHERE idMaterial=?";
        Material mat =null;
        
        GrupoDaoMysql daoGrupo = new GrupoDaoMysql(conexion);
        UnidadDaoMysql daoUnidad = new UnidadDaoMysql(conexion);
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, id);   
            
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            mat = new Material();
            while (rs.next()) {
                mat.setIdMaterial(rs.getString("idMaterial"));
                mat.setNombreMaterial(rs.getString("nombreMaterial"));
                mat.setGrupo( daoGrupo.buscar( rs.getString("idGrupo") ) );
                mat.setUnidad( daoUnidad.buscar( rs.getString("idUnidad") ) );
                mat.setTipo(rs.getString("tipo"));
            }
            
            rs.close();
            st.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return mat;
    }

    @Override
    public Material registrar(Material obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Material> listado() {
        String sql ="SELECT * FROM Materiales";
        ArrayList<Material> lista =null;
        
        GrupoDaoMysql daoGrupo = new GrupoDaoMysql(conexion);
        UnidadDaoMysql daoUnidad = new UnidadDaoMysql(conexion);
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
             
            while (rs.next()) {
                Material mat = new Material();
                mat.setIdMaterial(rs.getString("idMaterial"));
                mat.setNombreMaterial(rs.getString("nombreMaterial"));
                mat.setGrupo( daoGrupo.buscar( rs.getString("idGrupo") ) );
                mat.setUnidad( daoUnidad.buscar( rs.getString("idUnidad") ) );
                mat.setTipo(rs.getString("tipo"));
                lista.add(mat);
            }
            
            rs.close();
            st.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return lista;
    }

    @Override
    public Material actualizar(Material obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Material eliminar(Material obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
