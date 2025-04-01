package ker.teerapat.adddropcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ker.teerapat.adddropcourse.model.CourseRequest;
import ker.teerapat.adddropcourse.service.CourseRequestService;

import java.util.List;

@RestController
@RequestMapping("/api/course-requests")
@CrossOrigin(origins = "*")
public class CourseRequestController {

    @Autowired
    private CourseRequestService courseRequestService;

    @PostMapping
    public ResponseEntity<CourseRequest> createCourseRequest(@RequestBody CourseRequest courseRequest) {
        return ResponseEntity.ok(courseRequestService.createCourseRequest(courseRequest));
    }

    @GetMapping
    public ResponseEntity<List<CourseRequest>> getAllCourseRequests() {
        return ResponseEntity.ok(courseRequestService.getAllCourseRequests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseRequest> getCourseRequestById(@PathVariable Long id) {
        return ResponseEntity.ok(courseRequestService.getCourseRequestById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseRequest(@PathVariable Long id) {
        courseRequestService.deleteCourseRequest(id);
        return ResponseEntity.ok().build();
    }
} 