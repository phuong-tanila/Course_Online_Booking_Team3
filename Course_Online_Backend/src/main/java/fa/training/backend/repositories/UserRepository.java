package fa.training.backend.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import fa.training.backend.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findAll();

	public List<User> findAllByFullnameIgnoreCaseContaining(String fullName, Pageable pageable);

	@Query("SELECT u FROM User u WHERE u.email = :searchKey OR u.phone = :searchKey")
	User findByEmailOrPhone(String searchKey);
}
