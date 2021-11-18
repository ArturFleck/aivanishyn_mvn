package homework_27;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test_DBUnivarsity {

    private static final String DBName = "university";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DBName;
    private static final String USER = "root";
    private static final String pass = "root";

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(URL, USER, pass);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from students");
        System.out.println(rs.getMetaData().getTableName(1));
        System.out.println(rs.getMetaData().getColumnCount());

        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
            System.out.print("Column name: " + rs.getMetaData().getColumnName(i) + "  ");
            System.out.print("Column size: " + rs.getMetaData().getColumnDisplaySize(i) + "  ");
            System.out.println("Column type: " + rs.getMetaData().getColumnTypeName(i) + "  ");
        }
        List<Students> students = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt("id");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            int groupId = rs.getInt("groupId");
            int yearOfAdmission = rs.getInt("yearOfAdmission");

            Students studentN = new Students(id, first_name, last_name, groupId, yearOfAdmission);
            students.add(studentN);
        }
        connection.close();

        // Task 1
        System.out.println( getStudentById(students,13));

        //String alterDep = "update department set name='QA' where id=7";
        //System.out.println(st.executeUpdate(alterDep));


    }


    public static List<Students> getStudentById(List<Students> students , int id){
        return students.stream()
                    .filter(w->w.getId()==id)
                    .collect(Collectors.toList());
    }
}
