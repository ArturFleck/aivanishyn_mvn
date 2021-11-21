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

        List<Students> students = new ArrayList<>();

        readDB(students);
        //System.out.println(students);

        // Task 1
        int studId = 12;

        StudentService studentServ = new StudentService();
        System.out.println( studentServ.getStudentByID(studId));    // from StudentService

        System.out.println( getStudentById(students,studId).toString().replace("[","").replace("]",""));

        System.out.println("----------");

        System.out.println(studentServ.getStudenByLastName("Petrov"));

        System.out.println( deleteStudentById(1));

        // Task 4
        //System.out.println(studentServ.getStudenByLastName("Smith"));    // from StudentService

        //System.out.println(getStudentListByLastName(students,"Petrov").toString().replace("[","").replace("]",""));


        //connection.close();


        //String alterDep = "update department set name='QA' where id=7";
        //System.out.println(st.executeUpdate(alterDep));

    }

    public static void readDB(List<Students> students) throws SQLException {
        students.clear();

        Connection connection = DriverManager.getConnection(URL, USER, pass);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from students");

        while (rs.next()) {
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            int groupId = rs.getInt("groupId");
            int yearOfAdmission = rs.getInt("yearOfAdmission");

            Students studentN = new Students(id, firstName, lastName, groupId, yearOfAdmission);
            students.add(studentN);
        }
        connection.close();
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


    public static boolean deleteStudentById(int id) {
        boolean val=false;
        try {
            Connection connection = DriverManager.getConnection(URL, USER, pass);
            PreparedStatement st1 = connection.prepareStatement("DELETE FROM rates WHERE studentId = " + id);
            PreparedStatement st2 = connection.prepareStatement("DELETE FROM students WHERE id = " + id);
            st1.executeUpdate();
            st2.executeUpdate();
            val=true;
        } catch(Exception e) {
            System.out.println(e);
            val = false;
        }
        return val;
    }
}
