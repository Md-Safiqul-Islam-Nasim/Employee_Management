package employee_management;

import java.sql.*;

public class conn {

    static PreparedStatement preparestatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Connection c;
    Statement s;

    public conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management", "root", "");
            s = c.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
