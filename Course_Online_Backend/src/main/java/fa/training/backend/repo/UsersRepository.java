package fa.training.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fa.training.backend.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{
	 @Query("SELECT u FROM Users u WHERE u.email = :searchKey OR u.phone = :searchKey")
	    Users findByEmailOrPhone(String searchKey);
}
