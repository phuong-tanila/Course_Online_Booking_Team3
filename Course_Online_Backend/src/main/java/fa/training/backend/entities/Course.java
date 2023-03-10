package fa.training.backend.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.bytebuddy.utility.nullability.MaybeNull;

@Entity
@Table(name = "course")
public class Course extends BaseEntity {
	@Column
	private String courseName;
	@Column
	private String description;
	@Column
	private String objective;
	@Column
	private String suitable;
	@Column
	private int slot;
	@Column
	private int tuitionFee;
	@Column
	private String imageUrl;
	@Column
	private Date starDate;
	@Column
	private Date endDate;
	@Column
	private boolean status;
	@Column
	private Date lastUpdateDate;

	@ManyToOne
	@JoinColumn(name = "createBy", referencedColumnName = "id")
	private Users users;
	@ManyToOne
	@JoinColumn(name = "teacher_id", referencedColumnName = "id")
	private Users teacher;
	@ManyToOne
	@JoinColumn(name = "lastUpdateUser", referencedColumnName = "id")
	private Users admin;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
	private Set<OrderDetail> orderDetail;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CategoryCourse", joinColumns = {@JoinColumn(referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
	private Set<Category> categories;
}
