package lesson_26;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Employee {

    private int id;
    private String FirstName;
    private String LastName;
    private int DepartmentID;

    @Override
    public String toString() {
        return "\nEmployee{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", DepartmentID=" + DepartmentID +
                '}';
    }
}
