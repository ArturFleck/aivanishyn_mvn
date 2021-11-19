package homework_27;

import java.sql.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentService {
    private static final String DBName = "university";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DBName;
    private static final String USER = "root";
    private static final String pass = "root";
    private Connection connection = DriverManager.getConnection(URL, USER, pass);
    private Statement st = connection.createStatement();

    public StudentService() throws SQLException {
    }

    Students getStudentByID(int id) throws SQLException {

            ResultSet rs = st.executeQuery("select * from students where id="+id);
            Students stud = null;
            while (rs.next()) {
                int id2 = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int groupId = rs.getInt("groupId");
                int yearOfAdmission = rs.getInt("yearOfAdmission");
                 stud = new Students(id2,firstName,lastName,groupId,yearOfAdmission);
            }
            connection.close();
            return stud;
        }

    List<Students> getStudentListByLastName( String lastName){

        return students.stream()
                .filter(w-> Objects.equals(w.getLastName(), lastName))
                .collect(Collectors.toList());
    }
}
