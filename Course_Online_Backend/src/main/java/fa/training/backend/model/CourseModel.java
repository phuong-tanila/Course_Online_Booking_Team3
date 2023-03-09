package fa.training.backend.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import fa.training.backend.entities.User;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class CourseModel {
	@JsonProperty
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
	public UserModel teacher;
	public User lastUpdateUser;
	public User createBy;
}
