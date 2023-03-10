package fa.training.backend.services;

import fa.training.backend.entities.Feedback;
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
	public List<Feedback> getAllFeedbacks(int courseId, Integer pageNo, Integer pageSize, String sortBy, String direction) {
		Sort sort;
		if (direction.equalsIgnoreCase("desc")) {
			sort = Sort.by(Sort.Direction.DESC, sortBy);
		} else {
			sort = Sort.by(Sort.Direction.ASC, sortBy);
		}
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

		Page<Feedback> pagedResult = feedbackRepository.findAllByCourseId(courseId, pageable);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Feedback>();
		}
	}

	public Feedback createFeedback(Feedback f) {
		return feedbackRepository.save(f);
	}

}
