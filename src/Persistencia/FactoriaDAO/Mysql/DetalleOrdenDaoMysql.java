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
    public DetalleOrden registrar(DetalleOrden obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<DetalleOrden> listado() {
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

    @Override
    public DetalleOrden buscar(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   

}
