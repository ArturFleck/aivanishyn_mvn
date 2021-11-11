package lesson_26;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Employee {

    private int id;
    String FirstName;
    String LastName;
    String DepartmentID;

}
