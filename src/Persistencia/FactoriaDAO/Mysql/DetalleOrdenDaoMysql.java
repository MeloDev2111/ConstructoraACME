package Persistencia.FactoriaDAO.Mysql;

import Modelo.Compras.DetalleOrden;
import Persistencia.FactoriaDAO.IDetalleOrdenDao;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DetalleOrdenDaoMysql implements IDetalleOrdenDao{
    private Connection conexion;

    public DetalleOrdenDaoMysql(Connection con) {
        conexion=con;
    }

    @Override
    public ArrayList<DetalleOrden> listado() {
        String sql ="SELECT * FROM DetalleOrden";
        ArrayList<DetalleOrden> lista =null;
        
        PedidoDaoMysql daoPed = new PedidoDaoMysql(conexion);
        OrdenCompraDaoMysql daoOrden = new OrdenCompraDaoMysql(conexion);
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql); 
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            while (rs.next()) {
                DetalleOrden det = new DetalleOrden();
                det.setIdDetalle(rs.getString("idDetalle"));
                det.setOrden(daoOrden.buscar( rs.getString("idOrden") ) );
                det.setPedido(daoPed.buscar( rs.getString("idPedido") ) );
                det.setCantidadCompra(rs.getInt("cantidadComprar") );
                det.setPrecioUnidad(rs.getDouble("precioUnidad") );
                lista.add(det);
            }
            rs.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return lista;
    }
    
        @Override
    public DetalleOrden buscar(String id) {
        ArrayList<DetalleOrden> lista =listado();

        DetalleOrden detalle = null;

        for (DetalleOrden ord : lista) {
            if ( ord.getIdDetalle().equals(id) ) {
                detalle = ord;
                return detalle;
            }
        }

        return detalle;
    }

    @Override
    public DetalleOrden registrar(DetalleOrden obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public DetalleOrden actualizar(DetalleOrden obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public DetalleOrden eliminar(DetalleOrden obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
   

}
