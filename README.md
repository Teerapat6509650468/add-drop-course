# Course Add/Drop Request System

A Spring Boot application for managing course add/drop requests in a university setting. The system allows students to submit requests for adding or dropping courses, with proper validation and data persistence.

## Features

- Submit course add/drop requests
- View all course requests
- Delete course requests
- Bilingual support (Thai/English)
- Form validation
- Database persistence using MS SQL Server
- RESTful API endpoints

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- MS SQL Server
- Git

## Database Setup

1. Create a new database named `CourseRegistration` in MS SQL Server
2. Run the initialization script located at `src/main/resources/db/init.sql`

## Configuration

Update the database configuration in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=CourseRegistration;encrypt=true;trustServerCertificate=true
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## Building and Running

1. Clone the repository:
```bash
git clone https://github.com/Teerapat6509650468/add-drop-course.git
cd add-drop-course
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring:boot run
```

The application will be available at `http://localhost:8080`

## API Endpoints

- `POST /api/course-requests` - Create a new course request
- `GET /api/course-requests` - Get all course requests
- `GET /api/course-requests/{id}` - Get a specific course request
- `DELETE /api/course-requests/{id}` - Delete a course request

## Project Structure

```
src/main/java/ker/teerapat/adddropcourse/
├── config/
│   └── WebConfig.java
├── controller/
│   └── CourseRequestController.java
├── model/
│   ├── CourseRequest.java
│   └── Subject.java
├── repository/
│   ├── CourseRequestRepository.java
│   └── SubjectRepository.java
├── service/
│   └── CourseRequestService.java
└── AddDropCourseApplication.java
```

## Technologies Used

- Spring Boot 3.4.4
- Spring Data JPA
- MS SQL Server
- HTML/CSS/JavaScript
- Maven

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- Spring Boot team for the excellent framework
- All contributors who have helped with this project 
