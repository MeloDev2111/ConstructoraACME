package Persistencia.FactoriaDAO.Mysql;

import java.sql.Connection;
import Persistencia.ConexionTipo;
import Persistencia.FabricaConexiones;
import Persistencia.FactoriaDAO.FabricaDao;
import Persistencia.FactoriaDAO.IAreaDao;
import Persistencia.FactoriaDAO.ICentroCostoDao;
import Persistencia.FactoriaDAO.IDetalleOrdenDao;
import Persistencia.FactoriaDAO.IEmpleadoDao;
import Persistencia.FactoriaDAO.IGrupoDao;
import Persistencia.FactoriaDAO.IMaterialDao;
import Persistencia.FactoriaDAO.IOrdenCompraDao;
import Persistencia.FactoriaDAO.IPedidoDao;
import Persistencia.FactoriaDAO.IProveedorDao;
import Persistencia.FactoriaDAO.IProyectoDao;
import Persistencia.FactoriaDAO.IRequerimientoDao;
import Persistencia.FactoriaDAO.IUnidadDao;
import Persistencia.FactoriaDAO.IUsuarioDao;

public class FabricaDaoMysql extends FabricaDao{
    private Connection con = FabricaConexiones.getConnection(ConexionTipo.LOCALHOST);

    @Override
    public IUsuarioDao getUsuarioDao() {
        return new UsuarioDaoMysql(con);
    }

    @Override
    public IEmpleadoDao getEmpleadoDao() {
        return new EmpleadoDaoMysql(con);
    }

    @Override
    public IProyectoDao getProyectoDao() {
        return new ProyectoDaoMysql(con);
    }

    @Override
    public IRequerimientoDao getRequerimientoDao() {
        return new RequerimientoDaoMysql(con);
    }

    @Override
    public IAreaDao getAreaDao() {
        return new AreaDaoMysql(con);
    }

    @Override
    public IUnidadDao getUnidadDao() {
        return new UnidadDaoMysql(con);
    }

    @Override
    public IGrupoDao getGrupoDao() {
        return new GrupoDaoMysql(con);
    }

    @Override
    public IMaterialDao getMaterialDao() {
        return new MaterialDaoMysql(con);
    }

    @Override
    public IPedidoDao getPedidoDao() {
        return new PedidoDaoMysql(con);
    }

    @Override
    public ICentroCostoDao getCentroCostoDao() {
        return new CentroCostoDaoMysql(con);
    }

    @Override
    public IProveedorDao getProveedorDao() {
        return new ProveedorDaoMysql(con);
    }

    @Override
    public IOrdenCompraDao getOrdenCompraDao() {
        return new OrdenCompraDaoMysql(con);
    }

    @Override
    public IDetalleOrdenDao getDetalleOrdenDao() {
        return new DetalleOrdenDaoMysql(con);
    }

}
