package Persistencia.FactoriaDAO.Mysql;

import Modelo.Pedido;
import Modelo.Proyecto;
import Persistencia.FactoriaDAO.IPedidoDao;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PedidoDaoMysql implements IPedidoDao{
    private Connection conexion;

    public PedidoDaoMysql(Connection con) {
        conexion=con;
    }
    @Override
    public Pedido buscar(String id) {
        String sql ="SELECT * FROM Pedidos WHERE idPedido=?";
        Pedido ped =null;
        
        MaterialDaoMysql daoMat = new MaterialDaoMysql(conexion);
        RequerimientoDaoMysql daoReq = new RequerimientoDaoMysql(conexion);
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, id);   
            
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            ped = new Pedido();
            while (rs.next()) {
                ped.setIdPedido(rs.getString("idPedido"));
                ped.setMaterial( daoMat.buscar( rs.getString("idMaterial") ) );
                ped.setCantidadTotal(rs.getDouble("cantidadTotal"));
                ped.setCantidadRestante(rs.getDouble("cantidadRestante"));
                ped.setObservaciones(rs.getString("observaciones"));
                ped.setRequerimiento(daoReq.buscar(rs.getString("idRequerimiento")));
            }
            
            rs.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return ped;
    }

    @Override
    public ArrayList<Pedido> listarPedidosxRequerimiento(String idRequerimiento) {
        String sql ="SELECT * FROM Pedidos WHERE idRequerimiento=?";
        
        ArrayList<Pedido> lista =null;
        MaterialDaoMysql daoMat = new MaterialDaoMysql(conexion);
        RequerimientoDaoMysql daoReq = new RequerimientoDaoMysql(conexion);
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, idRequerimiento);   
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
       
            while (rs.next()) {
                Pedido ped = new Pedido();
                ped.setIdPedido(rs.getString("idPedido"));
                ped.setMaterial( daoMat.buscar( rs.getString("idMaterial") ) );
                ped.setCantidadTotal(rs.getDouble("cantidadTotal"));
                ped.setCantidadRestante(rs.getDouble("cantidadRestante"));
                ped.setObservaciones(rs.getString("observaciones"));
                ped.setRequerimiento(daoReq.buscar(rs.getString("idRequerimiento")));
                lista.add(ped);
            }
            
            rs.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return lista;
    }

    @Override
    public Pedido registrar(Pedido obj) {
        String sql ="insert into Pedidos (idRequerimiento,idMaterial,cantidadTotal,cantidadRestante) values (?,?,?,?)";
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);//Codigo sql
            st.setString(1, obj.getRequerimiento().getIdRequerimiento());
            st.setString(2, obj.getMaterial().getIdMaterial());
            st.setDouble(3, obj.getCantidadTotal());
            st.setDouble(4, obj.getCantidadRestante());
            st.executeUpdate();//Ejectura codigo sql cuando este tiene parametros
            
        } catch (Exception e) {
            System.out.println("error en registrar Usuario");
            System.out.println(e.getMessage());
        } 
        
        return obj;
    }

    @Override
    public ArrayList<Pedido> listado() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Pedido actualizar(Pedido obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Pedido eliminar(Pedido obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
