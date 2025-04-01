package ker.teerapat.adddropcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ker.teerapat.adddropcourse.model.CourseRequest;

@Repository
public interface CourseRequestRepository extends JpaRepository<CourseRequest, Long> {
} 