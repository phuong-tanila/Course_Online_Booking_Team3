package fa.training.backend.services;

import fa.training.backend.entities.Course;
import fa.training.backend.entities.Feedback;
import fa.training.backend.entities.User;
import fa.training.backend.mapper.FeedbackMapper;
import fa.training.backend.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

	public List<Feedback> getFeedbackByCourse(Course course) {
		return feedbackRepository.findFeedbackByCourse(course);
	}
	public List<Feedback> sortFeedbackByCourse(Course course) {
		Sort ratingSort = Sort.by("rating").descending();
		return feedbackRepository.findFeedbackByCourse(course, ratingSort);
	}
	public List<Feedback> getFeedbackByUser(User user) {
		return feedbackRepository.findFeedbackByUser(user);
	}

//	public long countFeedbackByCourse(Course course) {
//		List<Feedback> feedbacks = feedbackRepository.findFeedbackByCourse(course);
//		long count = 0;
//		for (Feedback feedback : feedbacks) {
//			count = count + 1;
//		}
//		return count;
//	}
}
