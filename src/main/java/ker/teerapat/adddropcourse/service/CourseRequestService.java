package ker.teerapat.adddropcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ker.teerapat.adddropcourse.model.CourseRequest;
import ker.teerapat.adddropcourse.repository.CourseRequestRepository;

import java.util.List;

@Service
public class CourseRequestService {

    @Autowired
    private CourseRequestRepository courseRequestRepository;

    @Transactional
    public CourseRequest createCourseRequest(CourseRequest courseRequest) {
        validateCourseRequest(courseRequest);
        return courseRequestRepository.save(courseRequest);
    }

    public List<CourseRequest> getAllCourseRequests() {
        return courseRequestRepository.findAll();
    }

    public CourseRequest getCourseRequestById(Long id) {
        return courseRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course request not found with id: " + id));
    }

    @Transactional
    public void deleteCourseRequest(Long id) {
        CourseRequest courseRequest = getCourseRequestById(id);
        courseRequestRepository.delete(courseRequest);
    }

    private void validateCourseRequest(CourseRequest courseRequest) {
        // Validate that at least one list is not empty
        if ((courseRequest.getAddSubjectList() == null || courseRequest.getAddSubjectList().isEmpty()) &&
            (courseRequest.getDropSubjectList() == null || courseRequest.getDropSubjectList().isEmpty())) {
            throw new IllegalArgumentException("At least one subject list (add or drop) must not be empty");
        }

        // Validate list sizes
        if (courseRequest.getAddSubjectList() != null && courseRequest.getAddSubjectList().size() > 10) {
            throw new IllegalArgumentException("Cannot add more than 10 courses");
        }

        if (courseRequest.getDropSubjectList() != null && courseRequest.getDropSubjectList().size() > 10) {
            throw new IllegalArgumentException("Cannot drop more than 10 courses");
        }

        // Set the course request reference for all subjects
        if (courseRequest.getAddSubjectList() != null) {
            courseRequest.getAddSubjectList().forEach(subject -> subject.setCourseRequest(courseRequest));
        }

        if (courseRequest.getDropSubjectList() != null) {
            courseRequest.getDropSubjectList().forEach(subject -> subject.setCourseRequest(courseRequest));
        }
    }
} 