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
├── docker/
│   └── docker-compose.yaml
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

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/stockFlow
spring.datasource.username=stockFlow
spring.datasource.password=stockFlow88

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```


El archivo **application-local.properties** es necesario para que la aplicación Spring Boot se conecte a la base de datos



### Docker y base de datos

>**⚠️IMPORTANTE: Todos los comandos deben ejecutarse desde la dirección`StockFlow-Backend/docker`** 

El archivo `docker/docker-compose.yaml` levanta un contenedor MySQL:

- Nombre del contenedor: `stockflow-db`
- Puerto expuesto: `3306`
- Base de datos: `stockFlow`
- Usuario: `stockFlow`
- Contraseña: `stockFlow88`

### Levantar el contenedor


**En Windows**
```bash
docker-compose up -d
```


**En Linux**
```bash
podman-compose up -d
```

> En caso de fallar en linux utilizar : podman-compose -f docker-compose.yaml up -d

### Verificar que se haya activado el contenedor correctamente

**En Windows**
```bash
docker ps
```

**En Linux**
```bash
podman ps
```
>El contenedor debe aparecer en la lista y estar en estado `Up`.

### Detener servicios del contenedor (Útil para detener el contenedor cuando terminas de trabajar)

**En Windows**
```bash
docker-compose stop
```

**En Linux**
```bash
podman-compose stop
```



### Iniciar servicios del contenedor (Útil para iniciar el contenedor sin crearlo de nuevo)

**En Windows**
```bash
docker-compose start
```
**En Linux**
```bash
podman-compose start
```

