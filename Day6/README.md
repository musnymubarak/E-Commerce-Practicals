# Spring Boot Project: Department and Employee Relationship

## 📦 Dependencies Installed

| Dependency            | Purpose                                                              |
|-----------------------|----------------------------------------------------------------------|
| **Spring Web**        | To create RESTful APIs.                                              |
| **Spring Boot DevTools** | Enables auto-reload of the backend on changes.                   |
| **Spring Data JPA**   | Simplifies interaction with MySQL using Java objects (ORM).          |
| **MySQL Driver**      | Connects the backend to a MySQL database.                            |

---

## 📚 Entity Relationship: Department & Employee

### Relationship Description

- **One Department has many Employees**
- **Each Employee belongs to one Department**

### Implementation in Java

```java
// Department.java
@OneToMany(mappedBy = "department") // mappedBy points to the variable in Employee
private List<Employee> employees;

// Employee.java
@ManyToOne
private Department department;


--OUTPUT
![Screenshot 2025-05-24 232325](https://github.com/user-attachments/assets/553569fb-ad65-4b21-8500-dad625c38aac)
