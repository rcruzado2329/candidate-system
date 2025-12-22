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
- **Java 17** o superior.
- **Spring Boot 3.x** (Spring Data JPA, Spring Security, Spring Web).
- **Maven** (Gestor de dependencias).
- **Lombok** (opcional).
- **MySQL** (Base de datos).
- **Swagger/OpenAPI** (Documentación de API).
- **JUnit 5** (Testing/pruebas).

---
## ⚙️ Arquitectura

Este proyecto sigue una arquitectura de capas estándar para facilitar el mantenimiento y la escalabilidad:

- **Controller:** Puntos de entrada de la API (REST endpoints).
- **Service:** Lógica de negocio.
- **Repository:** Interacción con la base de datos (Spring Data JPA).
- **Entity/DTO:** Modelos de datos y objetos de transferencia.
- **Config:** Configuración de seguridad.
- **Mapper:** Mapeo de entidades
- **Exception:** Manejo de errores y excepciones.
- **Security:** Autenticación y JWT.
- **Util:** Config. y generación token.


---
## ⚙️ Instalación y Configuración

### 0. Requisitos previos
* JDK 17 o superior instalado.
* Maven instalado (o usa el wrapper `./mvnw`).
* Tu IDE favorito (IntelliJ IDEA, VS Code, Eclipse).

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

Edita el archivo src/main/resources/application.properties (o .yml) con tus credenciales:
spring.datasource.url=jdbc:mysql://localhost:3306/candidate_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update


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








