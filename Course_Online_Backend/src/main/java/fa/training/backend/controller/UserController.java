package fa.training.backend.controller;

import fa.training.backend.entities.Course;
import fa.training.backend.entities.User;
import fa.training.backend.model.UserModel;
import fa.training.backend.services.CourseService;
import fa.training.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/list-user")
    public ResponseEntity<List<User>> getListUser() {
        return ResponseEntity.ok(userService.findAllUser());
    }
}
