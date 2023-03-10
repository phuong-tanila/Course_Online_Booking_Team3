package fa.training.backend.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Users extends BaseEntity{
	public Users() {
	}

	public Users(String fullname, String password, String phone, String email, String role) {
		this.fullname = fullname;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.role = role;
	}

	@Column
	private String fullname;

	@Column
	private String password;

	@Column
	private String phone;
	@Column
	private String email;
	@Column
	private String role;
	@Column
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
	private Set<Course> courses;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
	private Set<Order> orders;


}
