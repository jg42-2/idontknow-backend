# **📰 IDontKnow Backend**

**Curso:** CS 2031 \- Desarrollo Basado en Plataforma

**Período:** 2026-2

**Institución:** Universidad de Ingeniería y Tecnología (UTEC)

## **📋 Índice**

1. Portada e Integrantes  
2. [Introducción](#bookmark=id.wjz6f11rxbeo)  
   * [Contexto](#bookmark=id.e5y0t7btf89k)  
   * [Objetivos del Proyecto](#bookmark=id.unryz53xx0i3)  
3. [Identificación del Problema o Necesidad](#bookmark=id.e7d44gcah0ak)  
   * [Descripción del Problema](#bookmark=id.v65w1gjvv007)  
   * [Justificación](#bookmark=id.n7gsoybgzme)  
4. [Descripción de la Solución](#bookmark=id.ov5d9qvyztqs)  
   * [Funcionalidades Principales](#bookmark=id.elb4tjrgz8pk)  
   * [Tecnologías y Herramientas Utilizadas](#bookmark=id.s9nstci2pu4b)  
5. [Modelo de Entidades y Arquitectura de Datos](#bookmark=id.cily7dfw8e6e)  
   * [Diagrama de Entidades](#bookmark=id.ravcmyqmlilj)  
   * [Descripción de Entidades y Relaciones](#bookmark=id.6jf7urg29oh5)  
   * [Constraints y Validaciones](#bookmark=id.ju5ru9l7gt39)  
6. [Manejo de Errores y Excepciones Globales](#bookmark=id.dpv7ws1oza9a)  
7. [Medidas de Seguridad e Implementación JWT](#bookmark=id.ilne9ryatez1)  
   * [Autenticación y Autorización](#bookmark=id.xggsqdpenui7)  
   * [Prevención de Vulnerabilidades](#bookmark=id.n8gsf1lxojl9)  
8. [Eventos y Asincronía](#bookmark=id.xtv0y4o97i4g)  
   * [Eventos Personalizados](#bookmark=id.u0racd433gig)  
   * [Procesamiento Asíncrono y Servicio de Email](#bookmark=id.a2hateqjyh1f)  
9. [Instalación, Configuración y Variables de Entorno](#bookmark=id.d86dycwqiim6)  
10. [Documentación de API y Colección de Postman](#bookmark=id.deyranka3145)  
11. [Gestión del Proyecto, GitHub & CI/CD](#bookmark=id.g0ilwme3a7oy)  
12. [Conclusión y Trabajo Futuro](#bookmark=id.qmaxzwx9t624)  
13. [Apéndices y Licencia](#bookmark=id.1d8oihiofwj7)

## **👥 Portada e Integrantes**

* **Título del Proyecto:** IDontKnow \- Plataforma Agregadora y Analítica de Mercados de Predicción  
* **Curso:** CS 2031 Desarrollo Basado en Plataforma  
* **Integrantes del Equipo:**  
  * Estudiante 1 (Nombre Completo) \- correo1@utec.edu.pe  
  * Estudiante 2 (Nombre Completo) \- correo2@utec.edu.pe  
  * Estudiante 3 (Nombre Completo) \- correo3@utec.edu.pe  
  * Estudiante 4 (Nombre Completo) \- correo4@utec.edu.pe

## **💡 Introducción**

### **Contexto**

En la actualidad, los mercados de predicción (tales como Polymarket) se han consolidado como herramientas eficaces para la agregación de expectativas probabilísticas globales sobre eventos políticos, económicos, sociales y tecnológicos. Sin embargo, el volumen de información y la velocidad con la que cambian las probabilidades hacen que sea complejo para el usuario promedio procesar de forma ordenada los movimientos críticos del mercado y su impacto mediático.

### **Objetivos del Proyecto**

* **General:** Construir un backend escalable, seguro y reactivo capaz de ingerir, traducir, categorizar y analizar datos de mercados de predicción en tiempo real.  
* **Específicos:**  
  1. Diseñar e implementar una arquitectura en capas RESTful robusta bajo Spring Boot.  
  2. Integrar servicios externos mediante cliente HTTP para la ingesta de Polymarket y traducción procesada con el modelo Groq LLM.  
  3. Implementar un motor de análisis probabilístico y eventos asíncronos para notificar cruces de umbrales en mercados guardados.  
  4. Garantizar altos estándares de seguridad mediante Spring Security, tokens JWT y cifrado de credenciales.

## **🎯 Identificación del Problema o Necesidad**

### **Descripción del Problema**

Los usuarios interesados en tendencias globales enfrentan fragmentación de datos y barreras de lenguaje/contexto al consultar plataformas de mercados de predicción internacionales. Además, la falta de historización de titulares y snapshots probabilísticos impide analizar la evolución temporal de la percepción pública respecto a una noticia dada.

### **Justificación**

Centralizar estos datos en una plataforma en español que genere portadas informativas dinámicas, categorice titulares y notifique fluctuaciones drásticas mediante un sistema de cálculo de *scores* algorítmicos otorga una ventaja estratégica analítica tanto a investigadores como a entusiastas del sector financiero y de noticias.

## **🛠️ Descripción de la Solución**

### **Funcionalidades Principales**

1. **Módulo de Autenticación y Usuarios:** Registro, inicio de sesión seguro, gestión de perfiles y asignación de roles (USER, ADMIN).  
2. **Ingesta y Sincronización Automática (Polymarket & Groq):** *Scheduler* periódico que extrae información de Polymarket, traduce titulares y análisis contextuales vía Groq API.  
3. **Gestión de Mercados y Snapshots:** Almacenamiento histórico de probabilidad en puntos específicos del tiempo (*snapshots*) para realizar trazabilidad de la tendencia.  
4. **Módulo de Ediciones y Portadas (Edicion & PortadaBuilder):** Generación automática de resúmenes de prensa y portadas basadas en eventos destacados y puntuaciones calculadas (ScoreCalculator).  
5. **Guardado y Sistema de Alertas por Umbral:** Los usuarios pueden guardar mercados de interés. Si un mercado cruza un umbral de probabilidad configurado, se dispara un evento asíncrono de notificación por email.  
6. **Módulo de Categorías y Titulares:** Agrupación temática de noticias y consulta detallada mediante DTOs especializados.

### **Tecnologías y Herramientas Utilizadas**

* **Lenguaje & Framework:** Java 17, Spring Boot 3.x (Spring Web, Spring Data JPA, Spring Security, Spring Mail).  
* **Base de Datos:** PostgreSQL (Producción / Desarrollo) / H2 (Pruebas).  
* **Mapeo y Utilidades:** Lombok, ModelMapper.  
* **Integración IA & APIs Externas:** Groq Client (Traducción/Procesamiento de Lenguaje Natural) y Polymarket REST API.  
* **Documentación & Swagger:** OpenAPI 3 / Springdoc.  
* **Contenedores:** Dockerfile para despliegue e integración continua.

## **📐 Modelo de Entidades y Arquitectura de Datos**

### **Diagrama de Entidades**

 \+--------------+       1..N       \+--------------+  
 |   Usuario    |------------------|   Guardado   |  
 \+--------------+                  \+--------------+  
        | 1                               | N  
        |                                 |  
        | N                               | 1  
 \+--------------+       1..N       \+--------------+       1..N       \+--------------+  
 |   Edicion    |------------------|   Mercado    |------------------|   Snapshot   |  
 \+--------------+                  \+--------------+                  \+--------------+  
        | N                               | N  
        |                                 |  
        | 1                               | 1  
 \+--------------+                  \+--------------+  
 |  Categoria   |                  |   Titular    |  
 \+--------------+                  \+--------------+

### **Descripción de Entidades y Relaciones**

El modelo abarca 7 entidades principales para representar toda la lógica del negocio:

1. **Usuario:** Contiene id, email, password cifrado con BCrypt, nombre, rol (Role) y fecha de registro.  
2. **Categoria:** Agrupa mercados por temas (Ej: Política, Tecnología, Economía). Relación @OneToMany con Mercado.  
3. **Mercado:** Entidad central que representa el mercado de predicción. Posee atributos como título, probabilidad, volumen, umbral de notificación. Relaciones con Categoria, Titular y Snapshot.  
4. **Snapshot:** Captura histórica del estado del mercado (probabilidad y timestamp) para análisis temporal. Relación @ManyToOne con Mercado (FetchType.LAZY).  
5. **Titular:** Información mediática asociada a los cambios del mercado. Relación @ManyToOne con Mercado.  
6. **Edicion:** Agrupación editorial/diaria que reúne los titulares y mercados más relevantes del día mediante cálculo de puntuaciones.  
7. **Guardado:** Entidad intermedia que representa la relación entre un Usuario y los Mercados que sigue para recibir notificaciones de umbral cruzado.

### **Constraints y Validaciones**

* **A nivel de BD:** @Column(nullable \= false, unique \= true) para el email de usuarios; llaves foráneas indexadas y restricciones de unicidad compuestas en la tabla de guardados.  
* **A nivel de Aplicación:** Uso estricto de @Valid, @NotBlank, @Email, @Size en todos los DTOs de petición (RegisterRequestDTO, CategoriaRequestDTO, GuardadoRequestDTO, etc.).

## **✖️ Manejo de Errores y Excepciones Globales**

El sistema implementa una arquitectura centralizada de manejo de errores utilizando un @ControllerAdvice (GlobalExceptionHandler), asegurando respuestas con código HTTP semántico y una estructura JSON estándar (ErrorResponse).

### **Jerarquía de Excepciones Personalizadas:**

* ResourceNotFoundException (HTTP 404): Entidad no encontrada por ID o criterio.  
* DuplicateResourceException (HTTP 409): Intento de duplicar un email o un mercado guardado.  
* InvalidCredentialsException (HTTP 401): Fallo de autenticación en login.  
* TokenExpiredException (HTTP 401): JWT expirado o con firma inválida.  
* UnauthorizedOperationException (HTTP 403): Intento de acceder a recursos sin los permisos de rol adecuados.  
* InvalidOperationException (HTTP 400): Inconsistencia en la lógica de negocio recibida.  
* ExternalServiceException (HTTP 502/503): Errores en las llamadas a Polymarket o Groq API.  
* EmailSendingException (HTTP 500): Fallos en el servidor SMTP/servicio de correo.

## **🔒 Medidas de Seguridad e Implementación JWT**

### **Autenticación y Autorización**

La seguridad está gestionada por **Spring Security** y **JWT (JSON Web Tokens)**:

* **JwtService:** Se encarga de la generación, extracción de *claims* (userId, email, roles) y validación de tokens con clave secreta leída de variables de entorno.  
* **JwtFilter:** Intercepta cada solicitud HTTP, extrae el token del encabezado Authorization: Bearer \<token\>, valida su autenticidad y establece el SecurityContext.  
* **Control de Acceso por Roles:** Anotaciones @PreAuthorize("hasRole('ADMIN')") en métodos críticos y reglas por URL configuradas en SecurityConfig.

### **Prevención de Vulnerabilidades**

* **Inyección SQL:** Prevenida mediante el uso de Spring Data JPA y consultas parametrizadas (JPQL).  
* **Cifrado de Contraseñas:** Algoritmo **BCryptPasswordEncoder** para el hashing seguro de contraseñas.  
* **CORS:** Configuración explícita en SecurityConfig restringiendo orígenes no autorizados.  
* **Protección CSRF:** Deshabilitado de forma segura debido a que la API es estrictamente *stateless* (basada en JWT).

## **⚡ Eventos y Asincronía**

Para evitar acoplamiento rígido y optimizar los tiempos de respuesta de la API, la aplicación utiliza el motor de eventos de Spring con @EventListener y procesamiento asíncrono habilitado vía @EnableAsync.

### **Eventos Personalizados:**

1. **UsuarioRegistradoEvent:** Disparado tras el registro exitoso de un usuario. Activa el envío asíncrono del correo de bienvenida.  
2. **MercadoUmbralCruzadoEvent:** Se dispara durante la ingesta/sincronización cuando un mercado supera o cae por debajo del umbral establecido.  
3. **PortadaGeneradaEvent:** Notifica la creación y consolidación de una nueva edición diaria.

### **Procesamiento Asíncrono y Servicio de Email**

* **AsyncConfig:** Configura un ThreadPoolTaskExecutor optimizado para tareas en segundo plano.  
* **EmailService:** Utiliza JavaMailSender con plantillas HTML renderizadas en Thymeleaf (welcome-email.html y umbral-cruzado-email.html), ejecutándose dentro de métodos @Async para no bloquear el hilo de ejecución principal.

## **⚙️ Instalación, Configuración y Variables de Entorno**

### **Prerrequisitos**

* Java 17 JDK  
* Maven 3.8+  
* PostgreSQL o Docker para base de datos

### **Variables de Entorno Requeridas (application.properties / .env)**

SPRING\_DATASOURCE\_URL=jdbc:postgresql://localhost:5432/idontknow\_db  
SPRING\_DATASOURCE\_USERNAME=postgres  
SPRING\_DATASOURCE\_PASSWORD=tu\_password  
JWT\_SECRET\_KEY=tu\_clave\_secreta\_jwt\_muy\_larga\_y\_segura\_2026  
GROQ\_API\_KEY=tu\_api\_key\_de\_groq  
SPRING\_MAIL\_HOST=smtp.gmail.com  
SPRING\_MAIL\_PORT=587  
SPRING\_MAIL\_USERNAME=tu\_correo@gmail.com  
SPRING\_MAIL\_PASSWORD=tu\_app\_password

### **Ejecución Local**

\# Clonar repositorio  
git clone https://github.com/tu-usuario/idontknow-backend.git  
cd idontknow-backend

\# Compilar y ejecutar  
./mvnw clean spring-boot:run

## **📄 Documentación de API y Colección de Postman**

La documentación completa de los endpoints de la API REST se encuentra disponible en formato JSON en la raíz del proyecto:

* **Archivo Postman:** postman\_collection.json (incluye variables de entorno, tokens JWT automáticos y ejemplos de payload para todos los controladores: Auth, Usuario, Mercado, Categoria, Edicion, Titular, Guardado y Snapshot).  
* **Swagger UI / OpenAPI:** Accesible en modo ejecutable mediante /swagger-ui.html.

## **📊 Gestión del Proyecto, GitHub & CI/CD**

* **GitHub Projects:** Control de tareas mediante tablero Kanban, asignación de *issues*, etiquetas (feature, bug, documentation) y *milestones* semanales.  
* **GitFlow & Branching:** Desarrollo estructurado sobre ramas main, develop y ramas de características feature/\*.  
* **GitHub Actions (CI/CD):** Flujo de integración continua configurado para ejecutar compilación con Maven y suite de pruebas unitarias (IdontknowBackendApplicationTests) en cada *Pull Request* hacia la rama principal.

## **📝 Conclusión y Trabajo Futuro**

### **Logros Alcanzados**

Se logró construir una arquitectura backend sólida, desacoplada y orientada a eventos en Spring Boot, integrando con éxito procesamiento de lenguaje natural (Groq), ingesta en tiempo real (Polymarket), autenticación robusta mediante JWT y notificaciones por correo asíncronas.

### **Aprendizajes Clave**

* Implementación avanzada de patrones de diseño, segregación de DTOs y manejo eficiente de relaciones Lazy en JPA.  
* Desacoplamiento de componentes de negocio mediante ApplicationEventPublisher.  
* Integración limpia de APIs externas e IA en un flujo de trabajo RESTful.

### **Trabajo Futuro**

* Incorporar caché distribuido con Redis para acelerar las consultas de mercados y portadas.  
* Desplegar la infraestructura utilizando contenedores AWS ECS/RDS con soporte para WebSockets para actualización de probabilidades en tiempo real.

## **📜 Apéndices y Licencia**

* **Licencia:** Distribuido bajo la Licencia **MIT**. Consulte LICENSE para más información.  
* **Referencias:**  
  1. Documentación Oficial de Spring Boot & Spring Security.  
  2. Documentación API de Polymarket & Groq Cloud.  
  3. Rúbrica de Evaluación del Proyecto CS 2031 (UTEC 2026-2).