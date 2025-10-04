# Auth-JWT Spring Boot

## Descripción
Proyecto de ejemplo para la autenticación de usuarios utilizando **Spring Boot**, **Spring Security** y **JWT (JSON Web Token)**. Permite registrar usuarios, asignarles roles y autenticar con tokens JWT para proteger endpoints según roles.

## Qué hace
- Registro de usuarios con roles (`USER` o `ADMIN`).
- Login de usuarios generando un **token JWT**.
- Validación de tokens para proteger rutas según roles.
- Endpoints de prueba:
  - `/auth/register` → Registrar usuario
  - `/auth/login` → Autenticación y obtención de token JWT
  - `/admin/**` → Endpoints solo accesibles para ADMIN
  - `/user/**` → Endpoints accesibles para USER y ADMIN

## Dependencias / Librerías
- Spring Boot Web
- Spring Security
- Spring Data JPA
- H2 / MySQL (según configuración)
- JWT: `io.jsonwebtoken:jjwt-api`, `jjwt-impl`, `jjwt-jackson`
- Lombok (opcional)
