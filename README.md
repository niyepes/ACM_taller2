# ACM Taller 2

Taller N°2 - Gestión Hotelera BD

Nicolás Andrés Yepes Cortés - 20222020004

---

### Requisitos para la ejecución

* Java 17
* Spring Boot 3.5
* PostgreSQL en funcionamiento en local
* Maven

### Para correr el proyecto

```bash
mvn clean compile
```

```bash
mvn spring-boot:run
```

La API está configurada con el cliente de Swagger UI `http://localhost:8080/doc/swagger-ui/index.html#`

---

---

## Ejemplo con JSON

### Crear hotel

Request Body:

```json
{
  "id": 9,
  "nombre": "Sheraton",
  "ciudad": "Bogotá",
  "telefono": "123456789",
  "correo": "123@gmail.com",
  "direccion": "Calle 14",
  "habitaciones": []
}
```

Response: Code 200 OK

### Buscar un hotel

Request: `http://localhost:8080/hoteles/9`

Response Body:

```json
{
  "id": 9,
  "nombre": "Sheraton",
  "ciudad": "Bogotá",
  "telefono": "123456789",
  "correo": "123@gmail.com",
  "direccion": "Calle 14",
  "habitaciones": []
}
```

---

Para ver la documentación completa de los endpoints, revisar la UI de Swagger

---
