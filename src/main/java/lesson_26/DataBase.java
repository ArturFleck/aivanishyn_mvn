package lesson_26;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private static final String URL = "jdbc:mysql://localhost:3306/hillel";
    private static final String USER = "root";
    private static final String pass = "root";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USER, pass);

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from employee");
        System.out.println(rs.getMetaData().getTableName(1));
        System.out.println(rs.getMetaData().getColumnCount());

        while (rs.next()) {
            int id = rs.getInt("ID");
            String first_name = rs.getString("first_name");
            String second_name = rs.getString("last_name");
            int dep_id = rs.getInt("department_id");

            String p = id + " " + first_name + " " + second_name + " " + dep_id;
            System.out.println(p);
        }

        List<Employee> emp = new ArrayList<>();

/*        Employee e = new Employee(2,"asd","asdsd",3);
        emp.add(e);*/

        while (rs.next()) {
            int id = rs.getInt("ID");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            int dep_id = rs.getInt("department_id");

            Employee asd = new Employee(id, first_name, last_name, dep_id);
            emp.add(asd);
        }

        System.out.println("----------");
        System.out.println(emp.size());

        connection.close();

    }
}
