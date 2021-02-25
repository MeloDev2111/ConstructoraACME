package Persistencia.FactoriaDAO.Mysql;

import Modelo.Suministros.Unidad;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Persistencia.FactoriaDAO.IUnidadDao;

public class UnidadDaoMysql implements IUnidadDao{
    private Connection conexion;

    public UnidadDaoMysql(Connection con) {
        conexion=con;
    }
    @Override
    public Unidad buscar(String id) {
        String sql ="SELECT * FROM Unidades WHERE idUnidad=?";
        Unidad uni =null;
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, id);   
            
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            uni = new Unidad();
            while (rs.next()) {
                uni.setIdUnidad(rs.getString("idUnidad"));
                uni.setNombreUnidad(rs.getString("nombreUnidad"));
                uni.setAbrevUnidad(rs.getString("abrevUnidad"));
            }
            
            rs.close();
            st.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return uni;
    }
    
    @Override
    public Unidad registrar(Unidad obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Unidad> listado() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Unidad actualizar(Unidad obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Unidad eliminar(Unidad obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
   

}
