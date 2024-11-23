
O projeto adota uma arquitetura em camadas, com o frontend em React.js, o backend em Spring Boot com PostgreSQL e a comunicação entre eles feita por meio de uma API RESTful.  Essa estrutura proporciona maior organização, manutenibilidade e escalabilidade.

<center>
![Arquitetura em Camadas](./Arquitetura.jpg)
Autores: [Pedro Henrique Fernandino](https://github.com/PedroHenrique061),  [Kaio Enzo Salgado](https://github.com/kaioenzo), [Enrico  Zoratto](https://github.com/sidts)
</center>


**Frontend (React.js - Camada de Apresentação):**

A camada de apresentação, construída com React.js, é responsável por interagir diretamente com o usuário.  Ela lida com a interface, exibindo informações e capturando as ações do usuário.  O React.js, com sua estrutura baseada em componentes, facilita a criação de interfaces dinâmicas e reutilizáveis.

**Backend (Spring Boot com PostgreSQL - Camadas de Negócio e Dados):**

O backend é dividido em duas camadas principais:

* **Camada de Negócio (Spring Boot):**  Esta camada contém a lógica de negócios da aplicação, processando as requisições do frontend, aplicando regras de negócio e gerenciando as interações com a camada de dados.

* **Camada de Dados (PostgreSQL):**  Responsável pelo armazenamento e recuperação dos dados da aplicação. O PostgreSQL, um sistema de gerenciamento de banco de dados relacional. A camada de negócio interage com a camada de dados por meio de abstrações, permitindo que o banco de dados seja alterado sem impactar a lógica de negócios.

**Comunicação (API REST - Camada de Integração):**

A API REST atua como uma camada de integração entre o frontend e o backend. Ela define um conjunto de endpoints que o frontend pode acessar para interagir com a aplicação.

**Infraestrutura(AWS, Vercel, GitHub Actions):**

O backend e o banco de dados é hospedado na AWS (Amazon Web Services), enquanto o frontend é hospedado na Vercel. A integração contínua e a entrega contínua (CI/CD) são realizadas por meio do GitHub Actions.

## Histórico de Revisão

| Data       | Versão | Descrição                                             | Autor      |
|------------|--------|-------------------------------------------------------|------------|
| 29/10/2024 | 1.0    | Criação do documento | Kaio Enzo    |