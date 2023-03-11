package fa.training.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fa.training.backend.entities.User;

public interface UsersRepository extends JpaRepository<User, Integer>{
	
	//Function findByEmailOrPhone
	 @Query("SELECT u FROM Users u WHERE u.email = :searchKey OR u.phone = :searchKey")
	    User findByEmailOrPhone(String searchKey);
}
