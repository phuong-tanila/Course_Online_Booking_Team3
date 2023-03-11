package model;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {
    public int id;
    public String courseName;
    public String description;
    public String objective;
    public String suitable;
    public int slot;
    public int tuitionFee;
    public String imageUrl;
    public Date createDate;
    public Date startDate;
    public Date endDate;
    public boolean status;
    public Date lastUpdateDate;
    public User createBy;
    public User teacher;
    public User lastUpdateUser;
    public Set<OrderDetail> orderDetails;
    public Set<Category> categories;
    public Set<Feedback> feedbacks;

}
