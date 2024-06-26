package webapp.newsletterjdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {
    // Atributos de conexão
    private static final String url = "jdbc:postgresql://localhost:5432/newsletter";
    private static final String usuario = "postgres"; // Nome do ADM no banco
    private static final String senha = "postgres7210"; // Senha do ADM no banco

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter conexão com o banco de dados", e);
        }

    }

    // Criação do metodo de conexão fechada
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Metodo para fecar a conexão e o objeto PreparedStatement
    public static void closeConnection(Connection connection, PreparedStatement stmt) {
        closeConnection(connection);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // TODO: handle exception
        }
    }

}
