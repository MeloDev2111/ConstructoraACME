package Persistencia.FactoriaDAO.Mysql;

import Modelo.Compras.CentroCosto;
import Persistencia.FactoriaDAO.ICentroCostoDao;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CentroCostoDaoMysql implements ICentroCostoDao{
    private Connection conexion;

    public CentroCostoDaoMysql(Connection con) {
        conexion=con;
    }

    @Override
    public ArrayList<CentroCosto> listado() {
        String sql ="SELECT * FROM CentrosCosto";
        ArrayList<CentroCosto> lista =null;
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql); 
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            while (rs.next()) {
                CentroCosto cen = new CentroCosto();
                cen.setIdCentro(rs.getString("idCentro"));
                cen.setCodigo(rs.getString("codigo") );
                cen.setNombreCosto(rs.getString("nombreCentro") );
                lista.add(cen);
            }
            rs.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return lista;
    }  
    
        @Override
    public CentroCosto buscar(String id) {
        ArrayList<CentroCosto> lista =listado();
        
        CentroCosto centro = null;
            
        for (CentroCosto c : lista) {
            if ( c.getIdCentro().equals(id) ) {
                centro = c;
                return centro;
            }
        }
        
        return centro;
    }
   
    @Override
    public CentroCosto registrar(CentroCosto obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CentroCosto actualizar(CentroCosto obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CentroCosto eliminar(CentroCosto obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
