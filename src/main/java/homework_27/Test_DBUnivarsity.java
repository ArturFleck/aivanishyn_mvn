package homework_27;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        List<Students> students = new ArrayList<>();

        /*System.out.println(rs.getMetaData().getTableName(1));
        System.out.println(rs.getMetaData().getColumnCount());
        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
            System.out.print("Column name: " + rs.getMetaData().getColumnName(i) + "  ");
            System.out.print("Column size: " + rs.getMetaData().getColumnDisplaySize(i) + "  ");
            System.out.println("Column type: " + rs.getMetaData().getColumnTypeName(i) + "  ");
        }*/

        //-----  preparedStatement
        /*String sql = "select * from people where firstname=? and lastname=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "John");
        preparedStatement.setString(2, "Smith");
        ResultSet rest = preparedStatement.executeQuery();*/

        /*while (rest.next()) {
            int id = rest.getInt("id");
            String firstName = rest.getString("first_name");
            String lastName = rest.getString("last_name");
            int groupId = rest.getInt("groupId");
            int yearOfAdmission = rest.getInt("yearOfAdmission");

            Students studentN = new Students(id, firstName, lastName, groupId, yearOfAdmission);
            students.add(studentN);
        }*/
        //-----


        while (rs.next()) {
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            int groupId = rs.getInt("groupId");
            int yearOfAdmission = rs.getInt("yearOfAdmission");

            Students studentN = new Students(id, firstName, lastName, groupId, yearOfAdmission);
            students.add(studentN);
        }

        // Task 1
        int studId = 12;

        StudentService studentServ = new StudentService();
        System.out.println( studentServ.getStudentByID(studId));    // from StudentService

        System.out.println( getStudentById(students,studId).toString().replace("[","").replace("]",""));

        rs = st.executeQuery("select * from students where id=" + studId);
        String res = null;
        while (rs.next()) {
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            int groupId = rs.getInt("groupId");
            int yearOfAdmission = rs.getInt("yearOfAdmission");
            res= "id:" +id+" firstName:" + firstName + " lastName:" +lastName+ " groupId:" +groupId +" yearOfAdmission:" + yearOfAdmission;
        }
        System.out.println(res);

        System.out.println("----------");


        deleteStudentById(1);
        System.out.println(students);


        // Task 4
        System.out.println(studentServ.getStudenByLastName("Smith"));    // from StudentService

        System.out.println(getStudentListByLastName(students,"Petrov").toString().replace("[","").replace("]",""));
        System.out.println(studentServ.getStudenByLastName("Petrov"));

        connection.close();


        //String alterDep = "update department set name='QA' where id=7";
        //System.out.println(st.executeUpdate(alterDep));

    }


    public static List<Students> getStudentById(List<Students> students , int id){
        return students.stream()
                    .filter(w->w.getId()==id)
                    .collect(Collectors.toList());
    }

    public static List<Students> getStudentListByLastName(List<Students> students, String lastName){
        return students.stream()
                .filter(w-> Objects.equals(w.getLastName(), lastName))
                .collect(Collectors.toList());
    }


    public static void deleteStudentById(int id) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, pass);
            PreparedStatement st = connection.prepareStatement("DELETE FROM students WHERE id = " + id);
            st.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
