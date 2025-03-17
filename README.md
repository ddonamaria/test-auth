# 🔐 Proyecto Test-Auth

## Descripción

Este proyecto es un microservicio desarrollado en Java 21 con Spring Boot 3.4.3, siguiendo una arquitectura hexagonal y Domain-Driven Design (DDD). Su propósito principal es exponer un endpoint para obtener un token de autenticación, utilizando internamente un cliente HTTP basado en Feign para consumir un servicio externo.

## Tecnologías Utilizadas

- **Java 21**
- **Maven**: Construcción y gestión de dependencias.
- **Spring Boot 3.4.3**
- **Spring Cloud OpenFeign**: Cliente HTTP.
- **API-First**: Desarrollo del código partiendo de la especificación OpenAPI.
- **Swagger/OpenAPI**: Documentación de API.
- **JUnit & Mockito**: Test unitarios.
- **Docker**: Contenerización.

## Arquitectura

```bash
com.ddu.authapp
├── application
│   ├── ports.out.TokenClientPort (Define los puertos de salida)
│   ├── usecases.TokenServiceImpl (Contiene los casos de uso)
│
├── domain
│   ├── TokenService 
│
├── infrastructure
│   ├── adapters.in.api (Controladores REST)
│   ├── adapters.out (Clientes externos, Feign, etc.)
│   ├── config (Configuraciones de Swagger, Feign, etc.)
│   ├── exceptions (Manejo de errores globales)
│
├── resources
│   ├── application.yaml (Configuración de la aplicación)
│   ├── api/openapi-specification.yaml (Especificación OpenAPI)
```

## Clonado y ejecución del proyecto

### Clonado

- Clonar el repositorio:
```bash
git clone https://github.com/ddonamaria/test-auth
```
### Compilar proyecto

- Acceder a la raíz del proyecto:
```bash
cd test-auth
```

-  Compilar el proyecto:
```bash
.\mvnw.cmd clean package
```

### Ejecutar proyecto java

- Ejecutar la aplicación:
```bash
java -jar target/book-filter-1.0.0.jar
```

### Ejecutar proyecto en contenedores

- Generación de la imagen docker del proyecto local:
```bash
docker build -t test-auth:1.0.0 .
```

- Ejecutar proyectos en contenedores con docker-compose:
```bash
docker-compose up
```
- Detener proyectos dockerizados:
```bash
docker-compose down
```
## Pruebas unitarias
Las pruebas unitarias están implementadas con JUnit y Mockito.
Para lanzar los test unitarios ejecutar el comando:

```bash
mvn test
```

## Endpoints

El servicio expone el siguiente endpoint a traves de swagger:

URL Swagger: http://localhost:8081/swagger-ui/index.html

### Obtener Token

```
POST /token
```
**Respuesta**
```json
{
"auth-vivelibre-token": "eyJhbGciOiJIUz...",
"date": "2025-02-27T14:00:00Z"
}
```




