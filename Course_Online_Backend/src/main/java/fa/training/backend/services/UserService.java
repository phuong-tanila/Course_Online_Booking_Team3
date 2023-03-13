package fa.training.backend.services;

import java.util.List;
import java.util.Optional;

import fa.training.backend.entities.Course;
import fa.training.backend.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fa.training.backend.entities.User;
import fa.training.backend.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAllUser(){
		return userRepository.findAll();
	}
	public User findById(int id) throws RecordNotFoundException {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new RecordNotFoundException("No course exist for given id");
		}
	}
	public List<User> findAllByFullnameIgnoreCaseContaining(Integer pageNo, Integer pageSize, String fullName){
        Sort sort = Sort.by(Sort.Direction.ASC, "fullName");
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        return userRepository.findAllByFullnameIgnoreCaseContaining(fullName, pageable);
    }

}
