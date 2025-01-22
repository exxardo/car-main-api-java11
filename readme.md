# Car Store Project

Este projeto faz parte de uma arquitetura divida em 3 projetos:
- [Projeto 2: Car Store](https://github.com/exxardo/store-car-java11)
- [Projeto 3: Car Analytics](https://github.com/exxardo/car-analytics-java11)

## Descrição do Projeto
O Car Store é um sistema distribuído baseado em microserviços para gerenciar o cadastro, alteração, exclusão e análise de carros disponíveis para venda. Ele utiliza uma arquitetura orientada a eventos com Kafka para comunicação assíncrona entre os serviços, garantindo escalabilidade e desacoplamento.

## Problema Resolvido
O projeto resolve a necessidade de gerenciar grandes volumes de dados sobre carros à venda, permitindo operações como cadastro, alteração e exclusão de forma eficiente. Além disso, fornece análises sobre os dados registrados, promovendo insights para os usuários.

## Arquitetura

![Arquitetura proposta](https://github.com/exxardo/car-main-api-java11/blob/b65ac3f74180d7f07b051bfdc89721b0a2cb1e52/Car%20Store%20Arquitetura.png)

A arquitetura é composta por três serviços principais:

1. **Main API**: Recebe as requisições do cliente e publica mensagens no Kafka.
2. **Car Store**: Consome mensagens do Kafka e realiza operações no banco de dados relacionadas ao cadastro, alteração ou exclusão de carros.
3. **Car Analytics**: Consome mensagens do Kafka para registrar informações analíticas no banco de dados.

### Por que essa arquitetura?
- **Desacoplamento**: A comunicação via Kafka permite que os serviços sejam independentes.
- **Escalabilidade**: Cada serviço pode ser escalado individualmente conforme a demanda.
- **Resiliência**: O uso de mensageria garante que mensagens não sejam perdidas em caso de falhas temporárias nos serviços.

### Função do Microserviço Main Api

Este microsserviço tem como principal objetivo gerenciar os dados de proprietários e carros. Ele é responsável por:
Registrar novos proprietários de veículos.
Cadastrar carros disponíveis para venda.
Alterar informações de veículos cadastrados.
Remover carros do sistema.
Fornecer uma interface REST para interação com os dados.
Esse serviço atua como o núcleo das operações relacionadas ao gerenciamento de carros e seus proprietários, centralizando a lógica de negócios e garantindo que os dados sejam manipulados corretamente.

## Principais Features
- Cadastro, alteração e exclusão de informações de carros.
- Registro analítico dos dados para insights futuros.
- Comunicação assíncrona via Kafka.
- Persistência dos dados em bancos PostgreSQL.

## Padrões Adotados
- **DTO (Data Transfer Object)**: Para transferir dados entre camadas sem expor modelos internos.
- **Service Layer**: Centraliza a lógica de negócios, facilitando manutenção e testes.
- **Mensageria com Kafka**: Garante comunicação eficiente e desacoplada entre os serviços.

## Style Guide
O projeto segue as convenções do Java com Spring Boot:
- Código limpo e legível (Clean Code).
- Nomes descritivos para classes, métodos e variáveis.
- Documentação com Javadoc para métodos públicos.

## Endpoints da API

### Main API
| Método | Endpoint     | Descrição                       |
|--------|--------------|---------------------------------|
| POST   | /owners      | Cadastra um novo proprietário   |
| GET    | /cars        | Lista todos os carros disponíveis |
| PUT    | /cars/{id}   | Atualiza informações de um carro |
| DELETE | /cars/{id}   | Remove um carro da lista        |

### Car Analytics
| Método | Endpoint     | Descrição                       |
|--------|--------------|---------------------------------|
| GET    | /analytics   | Retorna dados analíticos dos carros |

## Como Instalar e Executar

### Pré-requisitos
- Java 11
- Apache Kafka (Provisionado através do Conduktor)
- PostgreSQL (Provisionado através do Docker Desktop)
- Maven
- 

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-repositorio/car-store.git
   cd car-store
   ```

2. Configure o banco de dados PostgreSQL:
    - Crie dois bancos: `car_store_db` e `car_analytics_db`.
    - Atualize as credenciais no arquivo `application.properties` dos serviços.

3. Inicie o Kafka localmente ou configure um servidor Kafka.

4. Compile o projeto:
   ```bash
   mvn clean install
   ```

5. Execute cada serviço:
   ```bash
   java -jar target/main-api.jar
   java -jar target/car-store.jar
   java -jar target/car-analytics.jar
   ```

## Como Contribuir

1. Faça um fork do repositório.
2. Crie uma branch para sua feature ou correção:
   ```bash
   git checkout -b minha-feature
   ```
3. Faça commit das alterações:
   ```bash
   git commit -m "Minha nova feature"
   ```
4. Envie sua branch:
   ```bash
   git push origin minha-feature
   ```
5. Abra um pull request no repositório original.

## Exemplo de Consumo da API

### Cadastro de Proprietário (POST /owners)

**Request:**
```json
{
  "name": "João Silva",
  "type": "Pessoa Física",
  "contactNumber": "+55 11 99999-9999"
}
```

**Resposta:**
```json
{
  "id": "12345",
  "message": "Proprietário cadastrado com sucesso!"
}
```

## Aprendizados
Este projeto proporcionou experiência prática com:
- Arquitetura orientada a eventos usando Kafka.
- Desenvolvimento baseado em microserviços com Spring Boot.
- Gerenciamento de bancos PostgreSQL em sistemas distribuídos.

## Contato

Para dúvidas ou sugestões, entre em contato através do meu [LinkedIn](https://www.linkedin.com/in/eduardoramiro).
