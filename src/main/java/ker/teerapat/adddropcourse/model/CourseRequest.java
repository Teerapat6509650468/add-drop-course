package ker.teerapat.adddropcourse.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "course_requests")
public class CourseRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate date;

    @NotBlank
    @Size(max = 100)
    private String studentFirstName;

    @NotBlank
    @Size(max = 100)
    private String studentLastName;

    @NotBlank
    @Size(max = 10)
    private String studentId;

    @NotNull
    @Min(1)
    @Max(4)
    private Integer studentYear;

    @NotBlank
    @Size(max = 100)
    private String studyField;

    @NotBlank
    @Size(max = 100)
    private String advisor;

    @NotBlank
    @Size(max = 50)
    private String addressNumber;

    @NotBlank
    @Size(max = 10)
    private String moo;

    @NotBlank
    @Size(max = 100)
    private String tumbol;

    @NotBlank
    @Size(max = 100)
    private String amphur;

    @NotBlank
    @Size(max = 100)
    private String province;

    @NotBlank
    @Size(max = 10)
    private String postalCode;

    @NotBlank
    @Size(max = 10)
    private String mobilePhone;

    @Size(max = 10)
    private String phone;

    @NotBlank
    @Size(max = 500)
    private String cause;

    @OneToMany(mappedBy = "courseRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    @Size(max = 10)
    private List<Subject> addSubjectList;

    @OneToMany(mappedBy = "courseRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    @Size(max = 10)
    private List<Subject> dropSubjectList;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(Integer studentYear) {
        this.studentYear = studentYear;
    }

    public String getStudyField() {
        return studyField;
    }

    public void setStudyField(String studyField) {
        this.studyField = studyField;
    }

    public String getAdvisor() {
        return advisor;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getMoo() {
        return moo;
    }

    public void setMoo(String moo) {
        this.moo = moo;
    }

    public String getTumbol() {
        return tumbol;
    }

    public void setTumbol(String tumbol) {
        this.tumbol = tumbol;
    }

    public String getAmphur() {
        return amphur;
    }

    public void setAmphur(String amphur) {
        this.amphur = amphur;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public List<Subject> getAddSubjectList() {
        return addSubjectList;
    }

    public void setAddSubjectList(List<Subject> addSubjectList) {
        this.addSubjectList = addSubjectList;
    }

    public List<Subject> getDropSubjectList() {
        return dropSubjectList;
    }

    public void setDropSubjectList(List<Subject> dropSubjectList) {
        this.dropSubjectList = dropSubjectList;
    }
} 