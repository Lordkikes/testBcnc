# TEST - BCNC

### Candidato Enrique Navarro Castro

# Description
Realizar un microservicio en SpringBoot que tenga 3 endpoints:

1. ejecute un algoritmo que enriquezca unos datos obtenidos a través de un API (2 endpoints), para posteriormente guardarlos en una base de
datos en memoria H2.
2. ejecute un algoritmo que enriquezca unos datos obtenidos a través de un API (2 endpoints) sin posibilidad de utilizar base de datos y los
devuelva en la petición.
3. GET de la base de datos en memoria H2.

• Por una parte tenemos “albums” y por otra las “photos”.

• Tenemos que obtener los “albums” en este endpoint: https://jsonplaceholder.typicode.com/albums

• Tenemos que obtener las “photos” en este endpoint: https://jsonplaceholder.typicode.com/photos

• Debemos enriquecer cada “álbum” para que tenga todas las “photos”.

• Realizar al menos un test unitario por funcionalidad.

• Realizar al menos un test de integración.

• IMPORTANTE: la eficiencia es lo más importante (elegir las estructuras de datos correctamente).

## Prerrequisitos

* Tener Instalado JDK 21
* Habilitar y/o configurar Lombok segun se requiera en el IDE

## Tecnologías

- Java 21
- Spring (Core + Boot + Data + Web )
- Hibernate + H2 en memoria
- Lombok

# Como iniciar la aplicacion:
- **Maven install:**  `mvn install`
- **Web App:** `mvn spring-boot:run`.

```sh
 Probando la aplicación
  
 Test endpoint 1:
  curl -XPOST -H "Content-type: application/json" 'http://localhost:8080/api/v1/albums'
  
 Test endpoint 2:
  curl -XGET -H "Content-type: application/json" 'http://localhost:8080/api/v1/external/albums' 
  
 Test endpoint 3:
   curl -XGET -H "Content-type: application/json" 'http://localhost:8080/api/v1/internal/albums'
```
