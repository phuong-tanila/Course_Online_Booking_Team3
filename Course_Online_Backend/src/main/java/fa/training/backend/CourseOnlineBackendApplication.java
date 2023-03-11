package fa.training.backend;

<<<<<<< HEAD
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fa.training.backend.entities.Users;
import fa.training.backend.repo.UsersRepository;

=======
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
>>>>>>> test
@SpringBootApplication
public class CourseOnlineBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseOnlineBackendApplication.class, args);
	}

<<<<<<< HEAD
	@Bean
	public CommandLineRunner insertSampleUser(UsersRepository repository) {
		return args -> {

//			repository.save(new Users("user1", "123", "88888881", "abc1@gmail.com", "ROLE_ADMIN"));
//			repository.save(new Users("user2", "123", "88888882", "abc2@gmail.com", "ROLE_USER"));
//			repository.save(new Users("user3", "123", "88888883", "abc3@gmail.com", "ROLE_OTHER"));

		};
	}
}
=======
}
>>>>>>> test
