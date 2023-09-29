# Proyecto TO DO APP

Este es un proyecto de una aplicación de gestión de tareas que te permite crear, ver, editar y eliminar tareas, así como administrar etiquetas asociadas a las tareas. La aplicación está diseñada utilizando Java y Spring Boot para el backend.

## Características

- Creación de tareas con título, fecha límite y etiquetas.
- Edición del estado de las tareas (completado/no completado).
- Asociación de etiquetas a tareas.
- Edicion de las etiquetas.
- Obtención de tareas por usuario.
- Obtención de etiquetas por usuario.
- Autenticación de usuarios.

## Tecnologías Utilizadas

- Java
- Spring Boot
- PostgreSQL (Base de datos)
- DataGrip (para pruebas de la base de datos)
- IDE (Visual Studio Code)

## Estructura del Proyecto

- `src/main/java/bo.edu.ucb.tasks` contiene el código fuente de la aplicación.
  - `api` contiene los controladores API.
  - `bl` contiene la lógica de negocio.
  - `dao` contiene los repositorios de datos.
  - `dto` contiene los objetos de transferencia de datos.
  - `entity` contiene las entidades JPA.

