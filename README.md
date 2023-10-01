# Último desafio Bootcamp Santander

Esta Java RESTful API criada com o domínio de produtos em estoque.

## Técnologias Utilizadas:
### Java 17
### Spring Boot 3
### Spring Data JPA
### H2 Database
### OpenAPI (Swagger)
### Railway
### Postgres

## Dagrama de classes:

```mermaid
classDiagram
    class Product {
        -productName: String
        -description: Description
        -priceComposition: PriceComposition
        -storage: Storage
        -images: Image[]
    }

    class Description {
        -manufacturer: String
        -features: Features
        -ncmCode: String
        -barcode: String
        -salePrice: BigDecimal
    }

    class Features {
        -nameFeature
        -descriptionFeature
    }
    class PriceComposition {
        -costPrice: BigDecimal
        -profitInPercent: Double
        -tax: Double
    }

    class Storage {
        -locationShelf: String
        -levelShelf: int
        -drawer: Int
        -quantity: Double
        -meterUnity: String
    }

    class Image {
        -iconUrl: String
        -iconDescription: String
    }

    Product "1" *-- "1" Description
    Product "1" *-- "N" Features
    Product "1" *-- "1" PriceComposition
    Product "1" *-- "1" Storage
    Product "1" *-- "N" Image
```
## IMPORTANTE

Este projeto foi construído com um viés totalmente educacional para a DIO.

Adicionei alguns tratamentos de exceções e uma classe que faz o cálculo do preço de custo.