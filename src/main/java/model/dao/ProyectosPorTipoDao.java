package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.ProyectosPorTipo;

public class ProyectosPorTipoDao {
    
    public ArrayList<ProyectosPorTipo> rankingProyectosPorTipo() throws SQLException {

        ArrayList<ProyectosPorTipo> respuesta = new ArrayList<ProyectosPorTipo>();
        Connection conexion = JDBCUtilities.getConnection();

        try{       

            String consulta = "SELECT p.ID_Proyecto, p.Constructora, p.Ciudad, t.Estrato FROM Proyecto p NATURAL JOIN Tipo t WHERE Ciudad = 'Cartagena' order by t.Estrato";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            //Recorrer los registros en los VO específicos
            while(resultSet.next()){
                ProyectosPorTipo ProyectosPorTipo = new ProyectosPorTipo();
                ProyectosPorTipo.setId(resultSet.getInt("Id_Proyecto"));
                ProyectosPorTipo.setConstructora(resultSet.getString("Constructora"));
                ProyectosPorTipo.setCiudad(resultSet.getString("Ciudad"));
                ProyectosPorTipo.setEstrato(resultSet.getInt("Estrato"));

                //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(ProyectosPorTipo);
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando los proyectos por tipo de Estrato: "+e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la colección de vo's
        return respuesta;
    }     
}
