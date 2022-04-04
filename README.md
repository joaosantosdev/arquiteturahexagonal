# Arquitetura Hexagonal
___
Esse projeto é um CRUD que tem como objetivo utilizar SDK AWS e arquitetura hexagonal

* DynamodDB para armazenar a pessoa
* Amazon SQS para publicar as operações do CRUD
* Arquitetura Hexagonal (Ports and Adapters) para criar uma aplicação independente
* Api Gateway para o roteamento dinâmico , monitoramento, resiliência e segurança para as aplicações
* Eureka Server para o gerenciamento dinâmico e escalabilidade para as aplicações e o Ribbon para fazer o balanceamento de carga

### Diagrama Versão AWS
![Diagrama AWS](https://user-images.githubusercontent.com/46445331/161456399-59778a93-9443-4efe-9212-baab8319e06a.png)