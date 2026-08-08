# 2026-ar-ba-alojate-web
## DOMINIO
### Esta aplicación web intenta emular el funcionamiento de reconocidas plataformas de alquileres temporales tales como Airbnb, Booking, Despegar, etc. El objetivo principal es que un usuario pueda registrarse y reservar un alojamiento en las fechas disponibles. En este repositorio se encuentran todos los componentes relacionados al backend. En el siguiente enlace https://github.com/manugomezp/2026-ar-ba-aloj-frontend se encuentra todo lo vinculado al frontend.
## ARQUITECTURA Y TECNOLOGÍA
### Backend de microservicios con Java y SpringBoot, usando Spring Cloud para la configuración de los microservicios y del Gateway y Eureka para el Service Discovery. 
### RabbitMQ para comunicar de manera asincrónica a los microservicios a través de una cola de mensajes. La comunicación entre los microservicios Reservas y Publicaciones se realiza mediante este mecanismo; Cuando un usuario efectúa una reserva, la solicitud llega al microservicio de Reservas y es este el que se integra con la cola de mensajes para depositar un mensaje que Publicaciones debe consumir para no ofrecer dicho alojamiento en el período de tiempo reservado.
### Single Web Application con React para el desarrollo del frontend; Vite como herramienta de compilación. 
### El manejo de los usuarios es delegado en Auth0, admitiendo SSO y gestión de los tokens para cada sesión.
### Persistencia apoyada en el ORM Hibernate con gestión de los datos en MySQL Workbench. 
