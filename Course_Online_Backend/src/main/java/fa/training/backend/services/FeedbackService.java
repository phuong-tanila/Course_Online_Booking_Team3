package fa.training.backend.services;

import fa.training.backend.entities.Feedback;
import fa.training.backend.mapper.FeedbackMapper;
import fa.training.backend.model.FeedbackModel;
import fa.training.backend.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {
	@Autowired
	FeedbackRepository feedbackRepository;
	@Autowired
	FeedbackMapper feedbackMapper;
//	public List<Feedback> getAllFeedbacks(int courseId, Integer pageNo, Integer pageSize, String sortBy, String direction) {
//		Sort sort;
//		if (direction.equalsIgnoreCase("desc")) {
//			sort = Sort.by(Sort.Direction.DESC, sortBy);
//		} else {
//			sort = Sort.by(Sort.Direction.ASC, sortBy);
//		}
//		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
//
//		Page<Feedback> pagedResult = feedbackRepository.findAllByCourseId(courseId, pageable);
//		if (pagedResult.hasContent()) {
//			return pagedResult.getContent();
//		} else {
//			return new ArrayList<Feedback>();
//		}
//	}
	public List<Feedback> findAll() {
		return feedbackRepository.findAll();
	}

	public List<FeedbackModel> getAllFeedback(){
		Sort ratingSort = Sort.by("rating").descending();
		List<Feedback>  feedbacks= feedbackRepository.findAll(ratingSort);
		List<FeedbackModel> modelList= new ArrayList<>();
		for (Feedback feedback : feedbacks) {
			FeedbackModel feedbackCourseModel = feedbackMapper.toModel(feedback);
			modelList.add(feedbackCourseModel);
		}
		return modelList;
	}

}
