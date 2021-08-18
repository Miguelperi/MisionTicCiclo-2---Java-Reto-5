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
import model.vo.LiderPorSalario;

public class LiderPorSalarioDao {
   
    public ArrayList<LiderPorSalario> rankingLiderPorSalario() throws SQLException {
        
        ArrayList<LiderPorSalario> respuesta = new ArrayList<LiderPorSalario>();
        Connection conexion = JDBCUtilities.getConnection();

        try {

            String consulta = "SELECT Nombre, Primer_Apellido, ID_Lider, Salario FROM Lider l WHERE Salario <= 500000 ORDER BY Salario";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            // Recorrer los registros en los VO específicos
            while (resultSet.next()) {
                LiderPorSalario liderPorSalario = new LiderPorSalario();
                liderPorSalario.setNombre(resultSet.getString("Nombre"));
                liderPorSalario.setPrimerApellido(resultSet.getString("Primer_Apellido"));
                liderPorSalario.setIdLider(resultSet.getInt("Id_Lider"));
                liderPorSalario.setSalario(resultSet.getInt("Salario"));                

                // Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(liderPorSalario);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.err.println("Error consultando lideres por salario: " + e);
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
        // Retornar la colección de vo's
        return respuesta;
    }    
}
