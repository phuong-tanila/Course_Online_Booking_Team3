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
	@JsonIgnore
	@Column
	public String password;
	@Column(length = Integer.MAX_VALUE)
	public String fullname;
	@Column
	public String phone;
	@Column(length = Integer.MAX_VALUE)
	public String email;
	@JsonIgnore
	@Column
	public String role;
	@Column(length = Integer.MAX_VALUE)
	public String description;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "createBy", fetch = FetchType.LAZY)
	public Set<Course> coursesCreateBy;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher", fetch = FetchType.LAZY)
	public Set<Course> coursesTeacher;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "lastUpdateUser", fetch = FetchType.LAZY)
	public Set<Course> coursesLastUpdateUser;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	public Set<Order> orders;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	public Set<Feedback> feedbacks;
}
