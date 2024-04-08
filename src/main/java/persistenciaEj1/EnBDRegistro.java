package persistenciaEj1;

import ejercicio1.RegistroInscripcion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnBDRegistro implements RegistroInscripcion {
    private final static String conexion = "jdbc:mysql://localhost:3306/tp-2";
    private final static String usuario = "root";
    private final static String clave = "";

    public EnBDRegistro() {

    }

    @Override
    public void registrar(String data) {

        String insertarPedido = "INSERT INTO pedido (fecha,costo) VALUES (?,?)";
        try (Connection myConexion = DriverManager.getConnection(conexion, usuario, clave);
             PreparedStatement statementInsertar = myConexion.prepareStatement(insertarPedido)) {

            statementInsertar.setString(1, data);
            statementInsertar.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

