# ShopSphere – Multi-Vendor E-Commerce Platform  
A production-grade, scalable **Multi-Vendor E-Commerce Web Application** built using **Spring Boot (Backend)** and **React (Frontend)**.  
This project follows **industry-standard GitHub Flow**, clean architecture, modular backend structure, and a complete multi-vendor marketplace model.

---

##  Current Project Status  
###  Completed Till Now
- Project repository initialized using **GitHub Flow**  
- Local folder structured as:
  
###  Folder strucuture
```java
ShopSphere_MultiVendor/
├── backend/
├── frontend/ (to be added later)
└── .idea/
```
---

##  Technologies Used

### **Backend**
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL 
- Maven

### **Frontend**
- React + Vite
- Tailwind CSS
- Redux js
- axios
- chart js

### **Tools**
- IntelliJ IDEA
- Git & GitHub
- Postman (testing)

---
## API Endpoints Implemented

### **GET /**  
**Description:** API welcome endpoint to verify backend is running.  
**Response Example:**
```json
{
  "success": true,
  "message": "Welcome to ShopSphere Multi-Vendor E-Commerce API",
  "data": "API Running Successfully"
}
```
#  User Model

The **User Model** defines the structure and representation of user data in the application.  
It is responsible for storing user identity, credentials, and role information.  
This model forms the backbone of authentication and authorization in the system.

---

## Key Responsibilities
- Store essential user information  
- Support secure authentication  
- Enable role-based access  
- Map user data to the database using JPA/Hibernate  
- Maintain consistent structure for all user-related operations  

---

##  User Model (With Lombok)

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    private String role;
}
