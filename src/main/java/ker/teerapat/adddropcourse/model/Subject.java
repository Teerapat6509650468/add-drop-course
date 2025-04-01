package ker.teerapat.adddropcourse.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 10)
    private String subjectCode;

    @NotBlank
    @Size(max = 100)
    private String subjectName;

    @NotBlank
    @Size(max = 10)
    private String subjectSection;

    @NotBlank
    @Size(max = 50)
    private String subjectDate;

    @NotBlank
    @Size(max = 2)
    private String subjectCredit;

    @NotBlank
    @Size(max = 100)
    private String subjectTeacher;

    private boolean subjectTeacherCheck;

    @ManyToOne
    @JoinColumn(name = "course_request_id")
    private CourseRequest courseRequest;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectSection() {
        return subjectSection;
    }

    public void setSubjectSection(String subjectSection) {
        this.subjectSection = subjectSection;
    }

    public String getSubjectDate() {
        return subjectDate;
    }

    public void setSubjectDate(String subjectDate) {
        this.subjectDate = subjectDate;
    }

    public String getSubjectCredit() {
        return subjectCredit;
    }

    public void setSubjectCredit(String subjectCredit) {
        this.subjectCredit = subjectCredit;
    }

    public String getSubjectTeacher() {
        return subjectTeacher;
    }

    public void setSubjectTeacher(String subjectTeacher) {
        this.subjectTeacher = subjectTeacher;
    }

    public boolean isSubjectTeacherCheck() {
        return subjectTeacherCheck;
    }

    public void setSubjectTeacherCheck(boolean subjectTeacherCheck) {
        this.subjectTeacherCheck = subjectTeacherCheck;
    }

    public CourseRequest getCourseRequest() {
        return courseRequest;
    }

    public void setCourseRequest(CourseRequest courseRequest) {
        this.courseRequest = courseRequest;
    }
} 