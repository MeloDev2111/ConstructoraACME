package Persistencia.FactoriaDAO.Mysql;

import Modelo.Compras.OrdenCompra;
import Persistencia.FactoriaDAO.IOrdenCompraDao;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrdenCompraDaoMysql implements IOrdenCompraDao{
    private Connection conexion;

    public OrdenCompraDaoMysql(Connection con) {
        conexion=con;
    }

    @Override
    public ArrayList<OrdenCompra> listado() {
        String sql ="SELECT * FROM OrdenCompra";
        ArrayList<OrdenCompra> lista =null;
        
        ProveedorDaoMysql daoPro = new ProveedorDaoMysql(conexion);
        CentroCostoDaoMysql daoCen = new CentroCostoDaoMysql(conexion);
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql); 
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            while (rs.next()) {
                OrdenCompra ord = new OrdenCompra();
                ord.setIdOrden(rs.getString("idOrden"));
                ord.setCentro( daoCen.buscar( rs.getString("idCentroCosto") ) );
                ord.setTipoPago( rs.getString("tipoPago") );
                ord.setFormaPago( rs.getString("formaPago") );
                ord.setProveedor( daoPro.buscar( rs.getString("idProveedor") ) );
                ord.setEstado(rs.getString("estado"));
                lista.add(ord);
            }
            rs.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return lista;
    }    
    
    
    @Override
    public OrdenCompra buscar(String id) {
        ArrayList<OrdenCompra> lista =listado();

            OrdenCompra orden = null;

            for (OrdenCompra ord : lista) {
                if ( ord.getIdOrden().equals(id) ) {
                    orden = ord;
                    return orden;
                }
            }

            return orden;
    }

    
    
    @Override
    public OrdenCompra registrar(OrdenCompra obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OrdenCompra actualizar(OrdenCompra obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OrdenCompra eliminar(OrdenCompra obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }  

}
