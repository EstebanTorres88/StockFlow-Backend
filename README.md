# StockFlow Backend

## Tecnologías necesarias

- Java 25
- Docker Desktop 
- Git

> En Linux se debe verificar que se tenga instalado podman-compose usando: podman-compose --version   


## Estructura del proyecto

```
StockFlow-Backend/
├── .gitignore
├── .mvn/
│   └── wrapper/
├── mvnw
├── mvnw.cmd
├── pom.xml
├──README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/stockflow/stockflow_backend/
│   │   │       ├── controllers/
│   │   │       ├── dtos/
│   │   │       ├── entities/
│   │   │       ├── facade/
│   │   │       ├── models/
│   │   │       ├── repositories/
│   │   │       └── services/
│   │   └── resources/
│   │       ├── application-local.properties
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   └── test/
│       └── java/com/stockflow/stockflow_backend/
└── target/  # generado después de compilar
```



## Comandos Git necesarios

### Clonar repo
```bash
git clone https://github.com/EstebanTorres88/StockFlow-Backend.git
cd StockFlow-Backend
```

### Flujo de trabajo por feature

### Traer los cambios de la rama main para estar al día

```bash
git checkout main
git pull origin main
```


### Crear y cambiar a la rama de feature
```bash
git checkout -b feature/nombre-feature
```

### Guardar los cambios, realizar el commit y subir la rama para su revisión 
```bash
# añadir los archivos modificados
git add .

# crear el commit
git commit -m "Descripción corta de la feature"

# subir la rama para revisión
git push -u origin feature/nombre-feature
```


## **Una vez clonado el repositorio debes seguir los siguientes pasos para realizar correctamente la conexión a la BD**

### Archivo application-local.properties  

El archivo `src/main/resources/application-local.properties` no está registrado en Git. Está en `.gitignore` y debe crearse manualmente después de clonar el repositorio.

Crea el archivo con este contenido exacto:

<details>
<summary>👁 Mostrar credenciales</summary>

```text
Usuario: avnadmin
Contraseña: AVNS_-W1QARfvQtuOHJALpct


```properties
spring.datasource.url= jdbc:mysql://stockflow88-stockflow88.h.aivencloud.com:17879/stockflow?ssl-mode=REQUIRED
spring.datasource.username=avnadmin
spring.datasource.password=AVNS_-W1QARfvQtuOHJALpct

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```


El archivo **application-local.properties** es necesario para que la aplicación Spring Boot se conecte a la base de datos
</details>

### Conexión en Dbeaver
<img width="1220" height="640" alt="image" src="https://github.com/user-attachments/assets/503b7859-605a-4aa0-ac3b-7866b957bbca" />


