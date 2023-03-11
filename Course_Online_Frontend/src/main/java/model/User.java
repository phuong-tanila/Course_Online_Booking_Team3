package model;

import lombok.*;

import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    public int id;
    public String password;
    public String fullname;
    public String phone;
    public String email;
    public String role;
    public String description;
    public Set<Course> coursesCreateBy;
    public Set<Course> coursesTeacher;
    public Set<Course> coursesLastUpdateUser;
    public Set<Order> orders;
    public Set<Feedback> feedbacks;
}
