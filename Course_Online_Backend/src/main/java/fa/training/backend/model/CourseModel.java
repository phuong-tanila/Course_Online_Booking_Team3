package fa.training.backend.model;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CourseModel {
	@JsonProperty
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
	public UserModel createBy;
	public UserModel teacher;
	public UserModel lastUpdateUser;
	public Set<FeedbackModel> feedbacks;
	
}
