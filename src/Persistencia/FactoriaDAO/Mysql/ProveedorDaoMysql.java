package Persistencia.FactoriaDAO.Mysql;


import Modelo.Compras.Proveedor;
import Persistencia.FactoriaDAO.IProveedorDao;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProveedorDaoMysql implements IProveedorDao{
    private Connection conexion;

    public ProveedorDaoMysql(Connection con) {
        conexion=con;
    }
    
    @Override
    public ArrayList<Proveedor> listado() {
        String sql ="SELECT * FROM Proveedores";
        ArrayList<Proveedor> lista =null;
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql); 
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            while (rs.next()) {
                Proveedor pro = new Proveedor();
                pro.setIdProveedor(rs.getString("idProveedor"));
                pro.setNombre(rs.getString("nombre") );
                pro.setDireccion(rs.getString("direccion") );
                pro.setNroDocumento(rs.getString("nroDocumento"));
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
    public Proveedor buscar(String id) {
        ArrayList<Proveedor> lista =listado();
        
        Proveedor proveedor = null;
            
        for (Proveedor p : lista) {
            if ( p.getIdProveedor().equals(id) ) {
                proveedor = p;
                return proveedor;
            }
        }
        
        return proveedor;
    }
    
    
    @Override
    public Proveedor registrar(Proveedor obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Proveedor actualizar(Proveedor obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Proveedor eliminar(Proveedor obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
