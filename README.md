# Hospital Management System (HMS)

A Java-based **Hospital Management System** developed to manage essential hospital operations through an organized and user-friendly application. The system applies **Object-Oriented Programming (OOP)** principles to manage hospital records, including doctors, patients, medical supplies, laboratories, facilities, and administrative staff.

Designed using Java and Eclipse IDE, the application provides a centralized menu-driven interface that allows users to view existing records, register new entries, and navigate between different management sections.

## 🚀 Key Engineering Features

* **Object-Oriented Architecture** — Organizes hospital operations into separate classes based on their responsibilities.
* **Patient Management** — Maintains patient records, including personal information, disease details, age, and admission status.
* **Doctor Management** — Stores doctor information, specialization, qualifications, working hours, and room assignments.
* **Staff Management** — Manages administrative staff details, designations, gender, and salary information.
* **Medical Inventory Management** — Maintains medical records, manufacturers, expiry dates, costs, and available quantities.
* **Laboratory Management** — Organizes laboratory information and associated service costs.
* **Facility Management** — Maintains a list of available hospital facilities.
* **Dynamic Record Management** — Allows users to add new records and display existing information.
* **Menu-Driven Navigation** — Provides structured navigation between different hospital management sections.

## 🛠️ Technical Stack

* **Java** — Core programming language
* **Object-Oriented Programming (OOP)** — Application architecture and class design
* **Java Collections / Arrays** — Record storage and management
* **Eclipse IDE** — Development environment
* **Exception Handling** — Runtime error handling
* **UML Class Diagram** — Object-oriented system design documentation
* **Git / GitHub** — Version control and project hosting

## 🏗️ System Architecture

The application follows an object-oriented structure in which each class represents a specific hospital entity and manages its corresponding data and operations.

### Core Classes

| Class                | Responsibility                                               |
| -------------------- | ------------------------------------------------------------ |
| `HospitalManagement` | Controls application flow, main menu, and user interactions. |
| `Doctor`             | Manages doctor profiles and professional information.        |
| `Patient`            | Maintains patient records and admission information.         |
| `Staff`              | Manages administrative staff information.                    |
| `Medical`            | Handles medical inventory records.                           |
| `Lab`                | Maintains laboratory information and service costs.          |
| `Facility`           | Manages available hospital facilities.                       |

### Object-Oriented Design Principles

* **Encapsulation** — Groups related data and methods within individual classes.
* **Single Responsibility Principle** — Assigns specific management responsibilities to individual classes.
* **Open/Closed Principle** — Structures the application to support additional functionality with minimal changes to existing components.
* **Modularity** — Separates hospital entities from the main application control logic to improve code organization and maintainability.

## 🖥️ Hospital Management Operations

The application provides six main management sections:

**Doctor Management**

* Display existing doctor records.
* Register new doctors.
* View doctor specialization, qualification, working hours, and room assignments.

**Patient Management**

* Display existing patient records.
* Register new patients.
* View patient information and admission status.

**Staff Management**

* Display existing staff records.
* Register new staff members.
* View staff designation and salary information.

**Medical Inventory**

* Display available medical records.
* Register new medical items.
* View manufacturer, expiry date, cost, and quantity.

**Laboratory Management**

* Display available laboratories.
* Register new laboratory entries.
* View laboratory service costs.

**Facility Management**

* Display available hospital facilities.
* Register new facilities.
* View the list of hospital facilities.

## 📊 Application Workflow

The application follows a structured menu-driven workflow:

1. Display the hospital welcome message and current date and time.
2. Present the main menu containing six hospital management categories.
3. Allow users to select a management section.
4. Display existing records or accept information for new entries.
5. Return users to the previous section or main menu.

## 💻 Project Structure

```text
HospitalManagementSystem/
│
├── src/
│   ├── HospitalManagement.java
│   ├── Doctor.java
│   ├── Patient.java
│   ├── Staff.java
│   ├── Medical.java
│   ├── Lab.java
│   └── Facility.java
│
├── UML/
│   └── ClassDiagram.pdf
│
└── README.md
```

## 🎯 Learning Outcomes

This project demonstrates practical experience in:

* Java programming
* Object-Oriented Programming
* Class and object implementation
* Encapsulation and modular design
* Array and ArrayList management
* Menu-driven application development
* User input processing
* Exception handling
* UML class diagram design
* Software development and teamwork

## 📌 Project Context

* **Project:** Hospital Management System
* **Programming Language:** Java
* **Development Environment:** Eclipse IDE
* **Application Type:** Hospital Management Application
* **Architecture:** Object-Oriented Design
