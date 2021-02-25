package Persistencia.FactoriaDAO.Mysql;

import Modelo.Suministros.Grupo;
import Persistencia.FactoriaDAO.IGrupoDao;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GrupoDaoMysql implements IGrupoDao{
    private Connection conexion;

    public GrupoDaoMysql(Connection con) {
        conexion=con;
    }

    @Override
    public Grupo buscar(String id) {
        String sql ="SELECT * FROM Grupos WHERE idGrupo=?";
        Grupo gru =null;
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, id);   
            
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            gru = new Grupo();
            while (rs.next()) {
                gru.setIdGrupo(rs.getString("idGrupo"));
                gru.setNombreGrupo(rs.getString("nombreGrupo"));
            }
            
            rs.close();
            st.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return gru;
    }

    @Override
    public Grupo registrar(Grupo obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Grupo> listado() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Grupo actualizar(Grupo obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Grupo eliminar(Grupo obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
