# 🎥 Movie Repository API

¡Bienvenido a tu **API REST de películas**! Esta aplicación te permite gestionar un repositorio de películas conectado a bases de datos MySQL y PostgreSQL, con todas las operaciones CRUD disponibles y probadas con Postman.

---

## 📖 Descripción

- **Tipo de API**: RESTful  
- **Funcionalidad**:  
  - Crear, Leer, Actualizar y Borrar películas  
  - Campos de cada película: `titulo`, `director`, `anio`, `puntuacionImdb`, `genero`  
- **Bases de datos**:  
  - MySQL (inicial)  
  - PostgreSQL (migración efectiva)  
- **Testing**: pruebas de todos los endpoints con Postman  

---

## 🛠 Tecnologías

- **Lenguaje y framework**: Java / Spring Boot *(o el que uses)*  
- **Base de datos primaria**: MySQL  
- **Base de datos secundaria**: PostgreSQL  
- **Herramienta de pruebas**: Postman  

## 📐 Entity-Relationship Diagram

> A continuación, se muestra el **diagrama Entidad-Relación** de nuestra base de datos de películas.

<figure align="center">
  <img src="exports/ER-Esquema.png" alt="ER Diagram" width="700">
  <figcaption><em>Figura 1.</em> Diagrama ER de la base de datos.</figcaption>
</figure>
