package fa.training.backend.controller;

import fa.training.backend.entities.Course;
import fa.training.backend.entities.Feedback;
import fa.training.backend.mapper.FeedbackMapper;
import fa.training.backend.model.FeedbackModel;
import fa.training.backend.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FeedbackController {
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Autowired
    private FeedbackService feedbackService;
//    @GetMapping("/feedbacks/{courseId}")
//
//    public ResponseEntity<List<FeedbackModel>> getAllByUserId(
//            @PathVariable("courseId") Integer courseId,
//            @RequestParam(defaultValue = "0") int pageNo,
//            @RequestParam(defaultValue = "5") Integer pageSize,
//            @RequestParam(defaultValue = "rating") String[] sortBy,
//            @RequestParam(defaultValue = "desc") String[] direction
//    )
//    {
//        List<Feedback> feedbacks = feedbackService.getAllFeedbacks(courseId, pageNo, pageSize, sortBy, direction);
//        List<FeedbackModel> feedbackModels = new ArrayList<>();
//        feedbacks.forEach(f -> feedbackModels.add(mapStructConverter.toModel(f)));
//        return new ResponseEntity<List<FeedbackModel>>(feedbackModels, new HttpHeaders(), HttpStatus.OK);
//    }
}
