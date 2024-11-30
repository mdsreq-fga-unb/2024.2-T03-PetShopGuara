# Requisitos de Software

## **Lista de Requisitos Funcionais**

Os requisitos funcionais detalham as funcionalidades específicas que o sistema deve oferecer para atender às demandas do Pet Shop Guará. Abaixo, está apresentado o conjunto inicial desses requisitos.

### Requisitos do Cliente do Petshop
1. **Cadastrar Usuários**: Permitir o cadastro de clientes, incluindo informações como nome e telefone.
2. **Cadstrar Pets**: Permitir que o cliente faça o cadstro de seus pets com informações como nome, idade e raça.
3. **Agendar Serviços**: Permitir que o cliente agende serviços de banho e tosa para seus animais, escolhendo entre os serviços disponíveis e adicionando especificações sobre o serviço.
4. **Exibir Horários Disponíveis**: Mostrar ao cliente os horários disponíveis para agendamentos, com base na disponibilidade do pet shop e dos funcionários.
5. **Cancelar agendamentos**: Permitir que o cliente cancele ou reagende serviços, seguindo uma política de tempo de antecedência definida pelo pet shop.
6. **Consultar Histórico de Serviços**: Oferecer ao cliente acesso ao histórico dos serviços realizados, incluindo data, serviços prestados, e valores cobrados.
7. **Redirecionar para as Redes Sociais**: Permitir que o cliente seja redirecionado para a rede social do pet shop, no caso o Instagram.
8. **Fazer Upload de Fotos**: Permitir que o cliente envie fotos do seu animal para cadastro ou para referências de tosas.
9. **Fornecer Feedback sobre o Serviço**: Permitir que o cliente avalie o serviço prestado com uma nota de 1 a 5 estrelas e comentários adicionais.

### Requisitos do Dono do Negócio
10. **Consultar Dados dos Clientes**: Permitir que o dono do pet shop acesse os dados cadastrais dos clientes, incluindo informações de contato e histórico de agendamentos.
11. **Consultar Informações dos Pets**: Permitir que o dono acesse informações dos pets cadastrados, como nome, idade e raça.
12. **Alterar os Preços dos Serviços**: Permitir que o dono modifique os preços dos serviços com base em diferentes critérios como custo ou promoções.
13. **Vizualizar Calendário com Agendamentos**: Permitir que o dono visualize todos os agendamentos em um calendário, com horários e datas organizados.
14. **Alterar o Calendário**: Permitir que o dono mova ou reagende horários e configure datas sem atendimento ou com horários especiais.
15. **Cancelar Agendamentos**:Permitir que o dono cancele agendamentos com o envio de notificações adequadas aos clientes.
16. **Consultar Dados Financeiro**: Permitir que o dono acesse relatórios financeiros detalhados sobre os serviços prestados.
17. **Consultar os Feedbacks Forncecidos**: Permitir que o dono veja e analise os feedbacks dos clientes para identificar áreas de melhoria.

### Requisitos dos Funcionários
18. **Consultar Dados dos Clientes**: Permitir que os funcionários acessem os dados cadastrais dos clientes, incluindo informações de contato, para casos onde o contato direto com o cliente seja necessário.
19. **Consultar Informações dos Pets**: Permitir que os funcionários acessem as informações dos pets cadastrados, como nome, idade e raça.
20. **Vizualizar Calendário com Agendamentos**: Permitir que os funcionários vejam todos os agendamentos em um calendário, com horários e datas organizados.

## **Lista de Requisitos Não Funcionais**

Os requisitos não funcionais especificam as qualidades e restrições do sistema, como desempenho, segurança e usabilidade. Abaixo, os requisitos não funcionais são classificados com o modelo URPS+.

### **Usabilidade (Usability)**
1. **Interface Instintiva**: O sistema deve possuir uma interface amigável, permitindo que clientes e funcionários usem as funcionalidades sem a necessidade de treinamento avançado.
2. **Feedback Visual**: O sistema deve fornecer mensagens claras de erro, sucesso ou validação para todas as ações realizadas pelos usuários.

### **Confiabilidade (Reliability)**
3. **Disponibilidade**: O sistema deve ter uma taxa de disponibilidade de 99,9%, garantindo que fique em funcionamento durante a maior parte do tempo.
4. **Recuperação de Falhas**: Em caso de falha, o sistema deve ser capaz de se recuperar e retornar ao estado funcional sem perda de dados.

### **Desempenho (Performance)**
5. **Processamento**: O sistema deve ser capaz de processar até 10 requisições simultâneas sem sofrer degradação significativa de desempenho.
6. **Eficiência**: As funcionalidades principais (ex.: agendamento, consulta de calendário) devem ter um tempo de resposta inferior a 3 segundos.

### **Suportabilidade (Supportability)**
7. **Compatibilidade**: Deve ser acessível em dispositivos móveis e navegadores modernos, como o Google Chrome e Safari, garantindo boa experiência para todos os usuários. ???

### **Requisitos de Implementação**
8. **Linguagem de Programação**: O sistema deve ser desenvolvido utilizando Java, com o framework Spring Boot. 
9. **Banco de Dados**: O sistema deve utilizar PostgreSQL como banco de dados relacional.

### **Requisitos de Interface**
10. **Integração com Redes Sociais**: Deve permitir redirecionamentos para a rede social do pet shop, o Instagram.