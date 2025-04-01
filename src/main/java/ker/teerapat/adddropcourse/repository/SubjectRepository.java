package ker.teerapat.adddropcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ker.teerapat.adddropcourse.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
} 