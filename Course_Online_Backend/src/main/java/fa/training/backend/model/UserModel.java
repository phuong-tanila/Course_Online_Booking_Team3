package fa.training.backend.model;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import fa.training.backend.entities.Course;
import lombok.Data;

import javax.persistence.Column;
import java.util.Set;

@Data
public class UserModel {
    @JsonProperty
    public int id;
    public String password;
    public String fullname;
    public String phone;
    public String email;
    public String role;
    public String description;
=======
public class UserModel {
    private int id;
    private String fullname;
    private String email;

>>>>>>> proj1/main
}
