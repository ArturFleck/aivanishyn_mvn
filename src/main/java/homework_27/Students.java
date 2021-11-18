package homework_27;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Data
public class Students {
    private int id;
    private String firstName;
    private String lastName;
    private int groupID;
    private int yearOfAdmission;


    @Override
    public String toString() {
        String result = "id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", groupID=" + groupID +
                ", yearOfAdmission=" + yearOfAdmission +
                "}\n";
        return result;
    }
}
