# StockMasters
Inventory Management Platform for Multi-Location Warehouses

## Overview

StockMasters is a web-based inventory management application designed for businesses that operate multiple warehouse locations. The system allows staff to manage products, track inventory across distribution centers, and monitor stock levels through a centralized interface.

The application is built using:

- Spring Boot
- Spring Data JPA
- Thymeleaf
- Bootstrap
- H2 Database

The goal of the project is to demonstrate a full-stack web application where users can interact with a database through a browser interface. The system supports product management, filtering, sorting, and inventory tracking.

---

## Features

### Product Management

Users can create and manage products in the system.

Each product includes:
- Product name
- Price
- Quantity
- Brand
- Category

The system validates input data to ensure required fields are provided and values are within valid ranges.

---

### Inventory Browsing

The products page displays a list of products stored in the database.

Users can:

- View product information
- Filter products by brand
- Filter products by category
- Sort products by name, price, or quantity
- Navigate results using server-side pagination

---

### Data Persistence

Product data is stored in a relational database using Spring Data JPA.

The database is automatically seeded with sample data at application startup using a `data.sql` file. This allows users to run the application and immediately see example products without needing to add data manually.

---

## Warehouse Context

The application models a real-world inventory system that includes:

- Products
- Brands
- Categories
- Distribution Centers
- Inventory quantities

This structure reflects how companies manage inventory across multiple locations.

---

## Technology Stack

Backend: Spring Boot  
ORM: Spring Data JPA  
Frontend: Thymeleaf  
UI Styling: Bootstrap  
Database: H2  
Build Tool: Maven  

---

## Application Architecture

The project follows a standard Spring Boot MVC structure.

Controller → Service → Repository → Database

Controllers handle HTTP requests and return Thymeleaf views.

Services contain application logic such as searching and filtering products.

Repositories use Spring Data JPA to interact with the database.

Templates render dynamic HTML pages using Thymeleaf.

---

## How to Run the Application

### 1. Clone the Repository

git clone https://github.com/NesliHumber/stockmasters.git  
cd stockmasters

### 2. Run the Application

Using the Maven wrapper included in the repository.

Mac / Linux:

./mvnw spring-boot:run

Windows:

mvnw.cmd spring-boot:run

### 3. Open the Application

Once the application starts, open a browser and go to:

http://localhost:8080

### 4. Sample Data

When the application starts, the database is automatically populated with sample data using `data.sql`.

This allows users to immediately view products and test filtering and sorting features.

---

## Project Pages

### Home
The entry page describing the purpose of the application.

### Products
Displays a list of products with filtering, sorting, and pagination.

### Inventory
Shows product inventory across distribution centers.

### Distribution Centers
Displays warehouse locations and related inventory data.

### Analytics
Provides visual summaries of inventory trends and metrics.

---

## Team Members and Contributions

### Veevek Auckloo
- Implemented core Java application logic
- Contributed to service layer and feature planning
- Assisted with backend functionality

### Aakarshan Sharma
- Implemented user interface design
- Developed CRUD pages
- Assisted with frontend integration

### Neslihan Ustaoglu
- Implemented core Spring Framework logic
- Supported UI development
- Assisted backend integration
- Implemented Spring Security: authentication, password encoding, role-based access control, admin pages
- Conducted quality assurance and testing

### Xia Wang
- Designed database structure
- Implemented entity relationships
- Managed database configuration and integration
- Contributed improvements to product filtering and sorting functionality


