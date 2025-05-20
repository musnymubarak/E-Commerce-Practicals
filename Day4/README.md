# IT3232 E-Commerce Practicals - Day 4 - 2025-04-04

## Project Overview

The project follows a standard Spring Boot application structure with the following key components:

### Models
- `Student.java`: Represents a student entity with attributes like name, age, department, registration number, and GPA.
- `Course.java`: Represents a course entity with attributes like name, code, description, duration, and year.

### Controllers
- `MapController.java`: Handles CRUD operations for student entities.
- `CourseController.java`: Handles CRUD operations for course entities.

## API Endpoints

### Student Management (`/app`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/app/mapstudent/{id}` | Get a student by registration number |
| GET | `/app/mapstudentAll` | Get all students |
| POST | `/app/add` | Add a new student |
| DELETE | `/app/delStu/{reg}` | Delete a student by registration number |
| PUT | `/app/update/{reg}` | Update a student by registration number |

### Course Management (`/appCourse`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/appCourse/coursebyCode/{c}` | Get a course by course code |
| GET | `/appCourse/allCourses` | Get all courses |
| POST | `/appCourse/add` | Add a new course |
| DELETE | `/appCourse/delStu/{c}` | Delete a course by course code |
| PUT | `/appCourse/updateCourse/{cd}` | Update a course by course code |

## Data Storage

The application uses in-memory storage with `HashMap` to store the data:
- Students are stored with registration number as the key
- Courses are stored with course code as the key

