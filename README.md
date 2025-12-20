# Candidate System 🧑‍💼

Proyecto desarrollado en **Spring Boot** para la gestión de métricas de clientes.  
Incluye cálculo de **total de clientes**, **edad promedio** y **desviación estándar de edades**.

---

## 📋 Características
- API REST construida con **Spring Boot**.
- DTO `ClientMetricsResponse` para exponer métricas de clientes.
- Cálculo de:
  - Total de clientes.
  - Promedio de edad.
  - Desviación estándar de edad.
- Arquitectura modular y escalable.

---

## 🛠️ Tecnologías utilizadas
- **Java 17**
- **Spring Boot 3.x**
- **Maven**
- **Lombok** (opcional)
- **JUnit 5** para pruebas

---

## ⚙️ Instalación

### 1. Clonar el repositorio
```bash
git clone https://github.com/tuusuario/candidate-system.git
cd candidate-system

### 2. Compilar el proyecto
mvn clean install

### 3. Ejecutar la aplicación
mvn spring-boot:run

Nota:
A nivel local, la aplicación quedará disponible en:
👉 http://localhost:8080
---

### Repositorio Github
https://github.com/rcruzado2329/candidate-system

### Documentación de los endpoints en Swagger
http://localhost:8080/swagger-ui/index.html

### Colección del API en Postman
La colección en Postman con las llamadas a cada una de las APIs, incluyendo un par de casos ya grabados (uno con HTTP Status 200, exitoso y uno con 500, para caso de error, 422 para errores de negocio) por cada endpoint, se encuentra en la siguiente ruta del proyecto:

https://github.com/rcruzado2329/candidate-system/tree/main/src/main/resources/collection

Nombre del archivo: API_V1_Candidates.postman_collection.json
---

### Base de Datos
La base de datos llamada candidate_db, se encuentra en la siguiente ruta del proyecto:

https://github.com/rcruzado2329/candidate-system/tree/main/src/main/resources/db.migration

Nombre del archivo: V1__create_clients_table.sql

---

## ⚙️ Diagrama Visual de arquitectura de tu proyecto Spring Boot

                ┌───────────────────────┐
                │       Controller      │
                │  (REST Endpoints)     │
                └───────────┬───────────┘
                            │
                            ▼
                ┌───────────────────────┐
                │        Service        │
                │ (Business Logic Layer)│
                └───────────┬───────────┘
                            │
                            ▼
                ┌───────────────────────┐
                │          DTO          │
                │ (ClientMetricsResponse)│
                └───────────┬───────────┘
                            │
                            ▼
                ┌───────────────────────┐
                │       Repository      │
                │ (Data Access Layer)   │
                └───────────┬───────────┘
                            │
                            ▼
                ┌───────────────────────┐
                │       Database        │
                │ (MySQL/MongoDB (opc)  │
                └───────────────────────┘



## 👨‍💻 Autor
Richar Cruzado
Aspiring Cloud Engineer & Backend Developer Senior & IT Business Analyst
Especializado en AWS, Azure, Java, Node.js, NestJS, Python, MongoDB, Java/Spring Boot.

---







