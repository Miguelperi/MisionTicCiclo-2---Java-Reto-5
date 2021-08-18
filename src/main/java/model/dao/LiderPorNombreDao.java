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
import model.vo.LiderPorNombre;

public class LiderPorNombreDao {
    
    public ArrayList<LiderPorNombre> rankingLiderPorNombre() throws SQLException {
        ArrayList<LiderPorNombre> respuesta = new ArrayList<LiderPorNombre>();
        Connection conexion = JDBCUtilities.getConnection();

        try {

            String consulta = "SELECT ID_Lider , Nombre , Primer_Apellido FROM Lider l WHERE Primer_Apellido LIKE '%z' ORDER BY Nombre";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            // Recorrer los registros en los VO específicos
            while (resultSet.next()) {
                LiderPorNombre liderPorNombre = new LiderPorNombre();
                liderPorNombre.setIdLider(resultSet.getInt("Id_Lider"));
                liderPorNombre.setNombre(resultSet.getString("Nombre"));
                liderPorNombre.setPrimerApellido(resultSet.getString("Primer_Apellido"));

                // Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(liderPorNombre);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.err.println("Error consultando lideres por nombre: " + e);
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
        // Retornar la colección de vo's
        return respuesta;
    }
    
}
