package fa.training.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetail extends BaseEntity{
	@Column
	private int price;
	@ManyToOne
	@JoinColumn(name = "orderId", referencedColumnName = "id")
	private Order order;
	@OneToOne(mappedBy = "orderDetail")
	private Feedback feedback;
	@ManyToOne
	@JoinColumn(name = "courseId", referencedColumnName = "id")
	private Course course;
}
