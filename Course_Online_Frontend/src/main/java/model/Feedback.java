package model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class Feedback implements Serializable {
    public int id;
    public String comment;
    public int rating;
    public OrderDetail orderDetail;
    public Course course;
    public User user;
}
