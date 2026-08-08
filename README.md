# 2026-ar-ba-alojate-web
## DOMINIO
### Esta aplicación web intenta emular el funcionamiento de reconocidas plataformas de alquileres temporales tales como Airbnb, Booking, Despegar, etc. El objetivo principal es que un usuario pueda registrarse y reservar un alojamiento en las fechas disponibles.
## ARQUITECTURA Y TECNOLOGÍA
### Backend de microservicios con Java y SpringBoot, usando Spring Cloud para la configuración de los microservicios y del Gateway y Eureka para el Service Discovery. 
### RabbitMQ para comunicar de manera asincrónica a los microservicios a través de una cola de mensajes.
### Single Web Application con React para el desarrollo del frontend; Vite como herramienta de compilación. 
### El manejo de los usuarios delegado en Auth0.
### Persistencia apoyada en el ORM Hibernate con gestión de los datos en MySQL Workbench.
