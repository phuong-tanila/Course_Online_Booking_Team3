package fa.training.backend.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "orders")
public class Order extends BaseEntity{
	@Column
	public Date buyDate;
	@Column(length = Integer.MAX_VALUE)
	public String paymentMethod;
	@Column
	public Boolean paymentStatus;
	@Column(length = Integer.MAX_VALUE)
	public String coupon;
	@Column(length = Integer.MAX_VALUE)
	public String paymentId;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	public User user;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
	public Set<OrderDetail> orderDetails;
	
	

}
