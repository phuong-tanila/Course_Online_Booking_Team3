package fa.training.backend.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback extends BaseEntity {
	@Column
	private int comment;
	@Column
	private int rating;
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "orderDetail_id")
	private OrderDetail orderDetail;

}
