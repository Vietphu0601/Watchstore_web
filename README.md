## TimeHub - Your Premier Watch Destination

TimeHub is an e-commerce platform dedicated to offering high-quality watches from top international brands. With a sleek, user-friendly design, TimeHub simplifies the process of finding, comparing, and purchasing watches that match your personal style and preferences.

We provide a curated selection of timepieces, from luxury brands to affordable fashion watches, ensuring there’s something for every wrist. Whether you’re searching for a statement piece or a minimalist design, TimeHub offers comprehensive features, including intelligent filters, trend-based suggestions, and expert guides to help you make the right choice.

Enjoy exclusive deals, fast shipping, and a seamless shopping experience at TimeHub. Every second counts, and we’re here to make sure you’re always on time with the perfect watch.

![Homepage](src/main/resources/images/home.png)
![Homepage2](src/main/resources/images/home2.bmp)

## Installation Guide

Follow the steps below to set up and run the TimeHub web application:

**Step 1**: Clone the repository from GitHub

Clone the repository from the provided GitHub link and navigate to the project directory.

**Step 2**: Set up MySQL Database

Set up a MySQL database, create a new database, and configure the database connection in the project.

**Step 3**: Build the Project and Run the Application by Spring Boot

Build the project using Maven and run the Spring Boot application.

**Step 4**: Access the Application

Once the application is running, open your browser and navigate to `http://localhost:8080` to access the TimeHub website.

## Technologies Used

This project is built using the following technologies:

### Frontend
- **JSP (JavaServer Pages)**: Used for building dynamic web pages with embedded Java code.
- **JSTL (JavaServer Pages Standard Tag Library)**: A tag library used in JSP pages to simplify common tasks like looping, conditionals, and formatting.

### Backend 
- **Java**: The core programming language used to build the backend of the application.
- **Spring Boot**: A framework used to simplify the development of the backend, providing default configurations and a streamlined setup for Spring applications.
- **Spring Data JPA**: A part of the Spring ecosystem that simplifies data access, making it easier to interact with the MySQL database by abstracting SQL queries.
- **Spring Security**: Used to handle authentication and authorization in the application, providing secure access control for different roles.

### Database
- **MySQL**: A relational database management system used to store and manage the application's data.

## Key Features

### 1. User Features:

- **User registration and authentication**:  
  Users can register for an account, log in, and manage their profiles. This includes the ability to reset passwords and update personal information.  
  ![User Registration](src/main/resources/images/users.bmp)

- **Product browsing**:  
  Users can browse the catalog of available watches. Filtering options by brand, price range, and features are available, along with a search function to quickly find specific models.  
  ![Product Browsing](src/main/resources/images/filter.bmp)

- **Product details**:  
  Each watch listing provides detailed information, including images, specifications, customer reviews, and pricing. High-quality images enhance the user experience.  
  ![Product Details](src/main/resources/images/des.bmp)

- **Shopping cart functionality**:  
  Users can add watches to a shopping cart, view their selections, and modify quantities or remove items before proceeding to checkout.  
  ![Shopping Cart](src/main/resources/images/payment.bmp)

- **Checkout process**:  
  A secure and straightforward checkout process is implemented. Users input shipping information, select payment methods, and review their orders before finalizing the purchase.  
  ![Checkout Process](src/main/resources/images/cart.jpg)
  ![Checkout Success](src/main/resources/images/success.jpg)

- **Email support**:  
  Customers can reach out for support or assistance via email, where queries regarding orders, product information, and general feedback can be addressed.  

### 2. Administrative Features:

- **Order management**:  
  Administrators can oversee all customer orders, including the ability to view, modify, and update order statuses. This ensures timely processing and delivery of products to customers.  
  ![Order Management](src/main/resources/images/order.jpg)

- **Product information management**:  
  Administrators can manage product details, including descriptions, pricing, and inventory levels. This functionality helps maintain accurate and up-to-date product information, improving customer satisfaction.  
  ![Product Management](src/main/resources/images/product.jpg)

- **User management**:  
  Administrators have the ability to create, modify, and delete user profiles. This ensures that user data is secure and accessible, while also allowing for the monitoring of user activity.  
  ![User Management](src/main/resources/images/users.bmp)

- **Email support for users**:  
  Administrators can provide assistance to users via email, addressing inquiries, resolving issues, and offering guidance on product-related questions. This enhances customer support and fosters positive user engagement.  
  ![Admin Email Support](src/main/resources/images/statistic.bmp)

- **Invoice generation**:  
  The system can automatically generate and send invoices for each completed order, streamlining the billing process and providing customers with clear records of their purchases.  
  ![Invoice Generation](src/main/resources/images/bill.png)
