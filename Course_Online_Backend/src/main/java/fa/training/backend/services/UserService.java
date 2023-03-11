package fa.training.backend.services;

import java.util.List;

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

	public List<User> findAllByFullnameIgnoreCaseContaining(Integer pageNo, Integer pageSize, String fullName){
        Sort sort = Sort.by(Sort.Direction.ASC, "fullName");
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        return userRepository.findAllByFullnameIgnoreCaseContaining(fullName, pageable);
    }
}
