# API Starwars

## Tecnologias utilizadas
 - [X] Springboot
 - [X] Maven
 - [X] Spring Data
 - [X] Swagger
 - [X] Mockito
 - [X] JUnit
 - [X] Docker
 - [X] Docker Compose

***
## Documentação

### Demonstração do uso do endpoint

 - Obs: Os endpoints podem ser utilizados no serviço do Swagger da seguinte URL: http://localhost:8080/swagger-ui.html

#### POST 
- Endpoint: /api/v1/rebeldes

```
{
  "acusacoes": 0,
  "genero": "MASCULINO",
  "idade": 27,
  "inventario": {
    "itemInventario": [ ]
  },
  "localizacao": {
    "base": "TESTE",
    "latitude": "-12.9492282",
    "longitude": "-38.4336117"
  },
  "nome": "Hugo Brendow"
}
```

***


### Deploy com docker

Foi utilizado uma imagem Docker com Alpine, visto que é a imagem mais limpa e mais otimizada para manter 
a aplicação.

Para realizar o deploy da aplicação e execução do projeto via container utilizando docker, será necessário a execução
dos passos abaixo no terminal:

```
./mvnw clean package -DskipTests

docker-compose up -d
```
Após concluir validar se o container estará disponível no endereço: http://localhost:8080/swagger-ui.html

***