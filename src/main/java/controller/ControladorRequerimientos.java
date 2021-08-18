package controller;

//Estructuras de datos (colecciones)
import java.util.ArrayList;

//Modelos (acceso y objetos contenedores)
import model.dao.LiderPorNombreDao;
import model.dao.LiderPorSalarioDao;
import model.dao.ProyectosPorTipoDao;

import model.vo.LiderPorNombre;
import model.vo.LiderPorSalario;
import model.vo.ProyectosPorTipo;


//Librerías para bases de datos
import java.sql.SQLException;

public class ControladorRequerimientos {  
    private final LiderPorSalarioDao liderPorSalarioDao;
    private final ProyectosPorTipoDao proyectosPorTipoDao;     
    private final LiderPorNombreDao liderPorNombreDao;
    
    public ControladorRequerimientos(){ 
        this.liderPorSalarioDao = new LiderPorSalarioDao();
        this.proyectosPorTipoDao = new ProyectosPorTipoDao();
        this.liderPorNombreDao = new LiderPorNombreDao();

    }

    public ArrayList<LiderPorSalario> consultarLiderPorSalario() throws SQLException {
        return this.liderPorSalarioDao.rankingLiderPorSalario();
    }

    public ArrayList<ProyectosPorTipo> consultarProyectosPorTipo() throws SQLException {
        return this.proyectosPorTipoDao.rankingProyectosPorTipo();
    }

    public ArrayList<LiderPorNombre> consultarLiderPorNombre() throws SQLException {
        return this.liderPorNombreDao.rankingLiderPorNombre();
    }

}
