package fa.training.backend.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Transactional
@JsonSerialize
@Table(name = "users")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	public int id;
	
	@Column
	public String password;
	@Column(length = Integer.MAX_VALUE)
	public String fullname;
	@Column
	public String phone;
	@Column(length = Integer.MAX_VALUE)
	public String email;
	
	@Column
	public String role;
	@Column(length = Integer.MAX_VALUE)
	public String description;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "createBy", fetch = FetchType.LAZY)
	public Set<Course> coursesCreateBy;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher", fetch = FetchType.LAZY)
	public Set<Course> coursesTeacher;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "lastUpdateUser", fetch = FetchType.LAZY)
	public Set<Course> coursesLastUpdateUser;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	public Set<Order> orders;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	public Set<Feedback> feedbacks;
}
