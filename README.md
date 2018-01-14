# xy-inc
Project Developed to XY Inc.

Pre-requisitos
- maven
- jdk1.8

Para compilar
    (na raiz do projeto)
> mvn clean install

Para iniciar
    (na raiz do projeto)
> java -jar target/xy-inc.jar


####Api

#####Busca pontos próximos, utilize POST

> http://localhost:8080/xy-inc/nearPoints (POST)

Request:
```
{
	"coordinateX": 20,
	"coordinateY": 10,
	"distance": 10
}
```
Response:
```
[
    "Lanchonete",
    "Joalheria",
    "Pub",
    "Supermercado"
]
```


#####Busca todos os pontos, paginada utilize os parametros(?page,size,sort})

> http://localhost:8080/xy-inc/interestPointsEntities (GET)

Response:
``` {
      "_embedded": {
          "interestPointsEntities": [
              {
                  "name": "teste",
                  "coordinateX": 10,
                  "coordinateY": 20,
                  "_links": {
                      "self": {
                          "href": "http://localhost:8080/xy-inc/interestPointsEntities/4"
                      },
                      "interestPointsEntity": {
                          "href": "http://localhost:8080/xy-inc/interestPointsEntities/4"
                      }
                  }
              }
          ]
      },
      "_links": {
          "self": {
              "href": "http://localhost:8080/xy-inc/interestPointsEntities{?page,size,sort}",
              "templated": true
          },
          "profile": {
              "href": "http://localhost:8080/xy-inc/profile/interestPointsEntities"
          }
      },
      "page": {
          "size": 20,
          "totalElements": 1,
          "totalPages": 1,
          "number": 0
      }
  }
```

#####Adicionar pontos, utilize POST

> http://localhost:8080/xy-inc/interestPointsEntities (POST)

Request:
```
{
	"name": "teste",
	"coordinateX": 10,
	"coordinateY": 20
}
```
Response:
```
{
    "name": "teste",
    "coordinateX": 10,
    "coordinateY": 20,
    "_links": {
        "self": {
            "href": "http://localhost:8080/xy-inc/interestPointsEntities/4"
        },
        "interestPointsEntity": {
            "href": "http://localhost:8080/xy-inc/interestPointsEntities/4"
        }
    }
}
```


#####Remover pontos, utilize DELETE e passe o ID

> http://localhost:8080/xy-inc/interestPointsEntities/{id} (DELETE)


#####Atualizar pontos, utilize PATCH ou PUT

> http://localhost:8080/xy-inc/interestPointsEntities/{id} (PATCH, PUT)

Request:
```
ex: PATCH
{
	"name": "rafao"
}
ex: PUT
{
	"name": "rafao2",
	"coordinateX": 10,
	"coordinateY": 20
}
```
Response:
```
{
    "name": "rafao2",
    "coordinateX": 10,
    "coordinateY": 20,
    "_links": {
        "self": {
            "href": "http://localhost:8080/xy-inc/interestPointsEntities/6"
        },
        "interestPointsEntity": {
            "href": "http://localhost:8080/xy-inc/interestPointsEntities/6"
        }
    }
}
```


####UTIL

{
	"name": "Lanchonete",
	"coordinateX": 27,
	"coordinateY": 12
}

{
	"name": "Posto",
	"coordinateX": 31,
	"coordinateY": 18
}

{
	"name": "Joalheria",
	"coordinateX": 15,
	"coordinateY": 12
}

{
	"name": "Floricultura",
	"coordinateX": 19,
	"coordinateY": 21
}

{
	"name": "Pub",
	"coordinateX": 12,
	"coordinateY": 8
}

{
	"name": "Supermercado",
	"coordinateX": 23,
	"coordinateY": 6
}

{
	"name": "Churrascaria",
	"coordinateX": 28,
	"coordinateY": 2
}