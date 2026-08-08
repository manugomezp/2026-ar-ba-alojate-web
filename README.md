# 2026-ar-ba-alojate-web
## DOMINIO
### Esta aplicación web intenta emular el funcionamiento de reconocidas plataformas de alquileres temporales tales como Airbnb, Booking, Despegar, etc. El objetivo principal es que un usuario pueda registrarse y reservar un alojamiento en las fechas disponibles. En este repositorio se encuentran todos los componentes relacionados al backend. En el siguiente enlace https://github.com/manugomezp/2026-ar-ba-aloj-frontend se encuentra todo lo vinculado al frontend.
## ARQUITECTURA Y TECNOLOGÍA
### Java y Spring Boot para el desarrollo del backend , usando Spring Cloud para la configuración de los microservicios y del Gateway y Eureka para el Service Discovery. 
### RabbitMQ para comunicar de manera asincrónica a los microservicios a través de una cola de mensajes. La comunicación entre los microservicios Reservas y Publicaciones se realiza mediante este mecanismo; cuando un usuario efectúa una reserva, la solicitud llega al microservicio de Reservas y es este el que se integra con la cola de mensajes para depositar un mensaje que Publicaciones debe consumir para no ofrecer dicho alojamiento en el período de tiempo reservado.
### React para el desarrollo del frontend mediante una Single Web Application; Vite como herramienta de compilación. 
### Auth0 para la implementación de sesiones de usuario, admitiendo SSO y gestionando los tokens de cada sesión.
### MySQL Workbench para visualizar los elementos persistidos mediante el ORM Hibernate.
