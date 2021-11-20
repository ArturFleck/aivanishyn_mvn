package homework_27;

import java.sql.*;

public class StudentService {
    private static final String DBName = "university";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DBName;
    private static final String USER = "root";
    private static final String pass = "root";


    public StudentService() throws SQLException {
    }

    Students getStudentByID(int id) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, pass);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from students where id=" + id);
        Students stud = null;
        stud=getData(rs, stud);
        connection.close();
        return stud;
    }

    Students getStudenByLastName(String lastName) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, pass);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from students where last_name='" + lastName+"'");
        Students stud = null;
        stud=getData(rs, stud);
        connection.close();
        return stud;
    }

    public static Students getData(ResultSet rs, Students stud) throws SQLException {
        while (rs.next()) {
            int id2 = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            int groupId = rs.getInt("groupId");
            int yearOfAdmission = rs.getInt("yearOfAdmission");
            stud = new Students(id2, firstName, lastName, groupId, yearOfAdmission);
        }
        return stud;
    }
}
