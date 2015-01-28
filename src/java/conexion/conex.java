/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fabian
 */
public class conex {
    private static Connection conexion = null;

    private static void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sena", "root", "");
        } catch (SQLException e) {
            System.out.println("Error de MySQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
    private conex() {
    }

    public static Connection getInstance() {
        if (conexion == null) {
            conectar();
        }
        return conexion;
    }
}
