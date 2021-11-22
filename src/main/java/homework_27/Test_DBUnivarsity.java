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
        System.out.println("---------- Task1");
        int studId = 12;

        StudentService studentServ = new StudentService();
        System.out.println(studentServ.getStudentByID(studId));    // from StudentService

        System.out.println(getStudentById(students, studId).toString().replace("[", "").replace("]", ""));

        // Task 2
        System.out.println("---------- Task2");

        System.out.println(deleteStudentById(1));

        createNewStudent(1, "Max", "Brenth", 3, 2009);
        createNewStudent("Petr", "Petrov", 1, 2003);
        readDB(students);

        // Task 3
        System.out.println("\n----------  Task3");
        getAllStudents();

        // Task 4
        System.out.println("\n---------- Task4");
        System.out.println(studentServ.getStudenByLastName("Smith"));    // from StudentService
        System.out.println(getStudentListByLastName(students, "Petrov").toString().replace("[", "").replace("]", ""));
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

    public static List<Students> getStudentById(List<Students> students, int id) {
        return students.stream()
                .filter(w -> w.getId() == id)
                .collect(Collectors.toList());
    }

    public static List<Students> getStudentListByLastName(List<Students> students, String lastName) {
        return students.stream()
                .filter(w -> Objects.equals(w.getLastName(), lastName))
                .collect(Collectors.toList());
    }

    public static void getAllStudents() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, pass);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from students");

        while (rs.next()) {
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            int groupId = rs.getInt("groupId");
            int yearOfAdmission = rs.getInt("yearOfAdmission");
            System.out.println("ID: "+id + " \tFirstName: "+firstName+" \tLast Name: "+lastName+" \tgroupID: "+groupId+" \tyearOfAdmission: "+yearOfAdmission);
        }
        connection.close();
    }

    public static boolean deleteStudentById(int id) throws SQLException {
        boolean val = false;
        StudentService studentServ = new StudentService();
        if (studentServ.getStudentByID(id) == null) {
            System.out.println("The record about student with id:" + id + " doesn't exist in DataBase");
            return false;
        } else {
            Connection connection = DriverManager.getConnection(URL, USER, pass);
            PreparedStatement st1 = connection.prepareStatement("DELETE FROM rates WHERE studentId = " + id);
            PreparedStatement st2 = connection.prepareStatement("DELETE FROM students WHERE id = " + id);
            st1.executeUpdate();
            st2.executeUpdate();
            connection.close();
            System.out.println("The record was deleted from DataBase successfully");
            val = true;
        }
        return val;
    }

    public static void createNewStudent(int id, String firstName, String lastName, int groupId, int yearOfAdmission) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, pass);
        PreparedStatement st = connection.prepareStatement("insert into students (id, first_Name,last_Name,groupId,yearOfAdmission) value(" + id + ",'" + firstName + "','" + lastName + "'," + groupId + "," + yearOfAdmission + ")");
        st.executeUpdate();
        connection.close();
        System.out.println("New student was added to DB");
    }

    public static void createNewStudent(String firstName, String lastName, int groupId, int yearOfAdmission) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, pass);
        PreparedStatement st = connection.prepareStatement("insert into students (first_Name,last_Name,groupId,yearOfAdmission) value('" + firstName + "','" + lastName + "'," + groupId + "," + yearOfAdmission + ")");
        st.executeUpdate();
        connection.close();
        System.out.println("New student was added to DB");
    }
}
