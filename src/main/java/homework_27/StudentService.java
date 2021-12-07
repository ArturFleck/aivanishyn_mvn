package homework_27;

import java.sql.*;

public class StudentService {


    Students getStudentByID(int id) throws SQLException {
        Connection connection = ConnectionUtil.getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from students where id=" + id);
        Students stud = null;
        stud = getData(rs, stud);   // going to DB
        connection.close();
        return stud;
    }

    Students getStudenByLastName(String lastName) throws SQLException {
        Connection connection = ConnectionUtil.getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from students where last_name='" + lastName + "'");
        Students stud = null;
        stud = getData(rs, stud);   // going to DB
        connection.close();
        return stud;
    }

    // take from DB what needed at resultSet
    private Students getData(ResultSet rs, Students stud) throws SQLException {
        while (rs.next()) {
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            int groupId = rs.getInt("groupId");
            int yearOfAdmission = rs.getInt("yearOfAdmission");
            stud = new Students(id, firstName, lastName, groupId, yearOfAdmission);
        }
        return stud;
    }
}
