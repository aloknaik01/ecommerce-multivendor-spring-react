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
```
# Product Model

Overview
This document describes the **Product** model used by the project. It defines the schema, example representations (SQL / Java / JSON), validation rules, common queries, and sample API usages so you can copy/paste into your repository.

Schema (fields)
- id — bigint / UUID, primary key
- name — string, required, human-readable product name
- slug — string, unique, URL-friendly version of `name`
- description — text, optional
- price — decimal (precision 10,2), required
- currency — string (ISO 4217), default "USD"
- stock — integer, non-negative (inventory count)
- sku — string, optional, unique (stock keeping unit)
- category_id — bigint / UUID, foreign key to Category
- images — json / text array (URLs)
- attributes — json (key-value product attributes: color, size, weight, etc.)
- is_active — boolean, default true (soft-delete / visibility)
- rating — decimal (precision 2,1) optional (average rating)
- created_at — timestamp
- updated_at — timestamp

SQL example (Postgres)
```sql
CREATE TABLE products (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  slug VARCHAR(255) NOT NULL UNIQUE,
  description TEXT,
  price NUMERIC(10,2) NOT NULL CHECK (price >= 0),
  currency CHAR(3) NOT NULL DEFAULT 'USD',
  stock INTEGER NOT NULL DEFAULT 0 CHECK (stock >= 0),
  sku VARCHAR(100) UNIQUE,
  category_id BIGINT,
  images JSONB,
  attributes JSONB,
  is_active BOOLEAN NOT NULL DEFAULT TRUE,
  rating NUMERIC(2,1),
  created_at TIMESTAMP WITH TIME ZONE DEFAULT now(),
  updated_at TIMESTAMP WITH TIME ZONE DEFAULT now()
);

CREATE INDEX idx_products_name ON products USING gin(to_tsvector('english', name));
CREATE INDEX idx_products_category ON products(category_id);
```
# Address Model — README

## Overview
The **Address** model stores user shipping/billing addresses.  
It is structured for e-commerce systems where one user may have multiple addresses (home, office, etc.).  

This README covers:
- Database schema  
- JPA model (with and without Lombok)  
- JSON examples  
- Validation rules  
- Common queries  
- Example API endpoints  

---

## Schema (Fields)

- `id` — bigint / UUID, primary key  
- `user_id` — foreign key → Users table  
- `full_name` — receiver’s name  
- `phone` — valid phone number  
- `address_line1` — house / flat / street  
- `address_line2` — optional  
- `city` — required  
- `state` — required  
- `postal_code` — required  
- `country` — default `"India"`  
- `landmark` — optional  
- `address_type` — `"HOME"` or `"WORK"`  
- `is_default` — boolean, only one default per user  
- `created_at`  
- `updated_at`  

---

## SQL Example (PostgreSQL)

```sql
CREATE TABLE addresses (
  id BIGSERIAL PRIMARY KEY,
  user_id BIGINT NOT NULL,
  full_name VARCHAR(150) NOT NULL,
  phone VARCHAR(15) NOT NULL,
  address_line1 VARCHAR(255) NOT NULL,
  address_line2 VARCHAR(255),
  city VARCHAR(120) NOT NULL,
  state VARCHAR(120) NOT NULL,
  postal_code VARCHAR(10) NOT NULL,
  country VARCHAR(80) DEFAULT 'India',
  landmark VARCHAR(150),
  address_type VARCHAR(10) DEFAULT 'HOME',
  is_default BOOLEAN DEFAULT FALSE,
  created_at TIMESTAMP DEFAULT now(),
  updated_at TIMESTAMP DEFAULT now()
);

CREATE INDEX idx_addresses_user_id ON addresses(user_id);
```
# Wishlist Model

The `Wishlist` model represents a user's personalized list of products they intend to save for later.  
Each wishlist belongs to a specific user and can contain multiple products.  
It uses JPA for ORM mapping and Lombok to reduce boilerplate code.

## 📌 Features

- Each wishlist has a unique auto-generated ID.
- A **Many-to-One** relationship with the `User` model  
  → One user can have multiple wishlists.
- A **Many-to-Many** relationship with the `Product` model  
  → A wishlist can contain many products, and a product can appear in multiple user wishlists.
- Uses `HashSet` internally to avoid duplicate product entries.
- Powered by **Jakarta Persistence API** and **Lombok** annotations.

##  Entity Structure

```java
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToMany
    private Set<Product> products = new HashSet<>();
}
```
