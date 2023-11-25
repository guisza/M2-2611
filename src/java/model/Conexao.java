package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
     //aqui temos a função getConexão() que passa os parametros de acesso ao banco
    public static Connection getConexao() throws ClassNotFoundException, SQLException {
 
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpg","root", "");
        
        //estabelece a comunicação
        return con;
    }
}
