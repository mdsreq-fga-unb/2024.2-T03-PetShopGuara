# Requisitos de Software

## **Lista de Requisitos Funcionais**

Os requisitos funcionais detalham as funcionalidades específicas que o sistema deve oferecer para atender às demandas do Pet Shop Guará. Abaixo, está apresentado o conjunto inicial desses requisitos.

### Aba do Cliente
1. **Cadastro**: O sistema deve permitir que o usuário faça cadastro, incluindo informações como nome e telefone.
2. **Cadstro dos Pets**: O cliente deve poder cadastrar informações sobre seus animais, como nome, idade, raça e peso.
3. **Agendamento de Serviços**: O cliente deve ser capaz de agendar serviços de banho e tosa para seus animais, escolhendo entre os serviços disponíveis e poder optar por colocar alguma especificação sobre o serviço que será prestado.
4. **Mostrar Horários Disponíveis**: O sistema deve exibir os horários disponíveis para agendamentos, com base na disponibilidade do pet shop e dos funcionários.
5. **Cancelar agendamentos**: O cliente deve poder cancelar ou reagendar os serviços, desde que dentro de uma política de tempo de antecedência definida pelo pet shop.
6. **Histórico de Serviços**: O cliente deve poder acessar um histórico dos serviços realizados, incluindo data, serviços prestados, e valores cobrados.
7. **Redirecionamento para as redes**: O cliente deve ser capaz de ser redirecionado para a rede social do pet shop, no caso o Instagram.
8. **Upload de fotos**: O cliente pode fazer upload de fotos do seu animal, tanto para ter salvo em seu cadastro quanto para mostrar referências de tosas.
9. **Feedback sobre o serviço**: O cliente deve poder fornecer um feedback sobre os serviços prestados, com uma avaliação de 1 a 5 estrelas e comentários adicionais.

### Aba do Dono do Negócio
10. **Consultar dados dos clientes**: O dono do pet shop deve poder consultar os dados cadastrais dos clientes, incluindo informações de contato e histórico de agendamentos.
11. **Consultar informações dos pets**: O dono pode consultar as informações dos pets cadastrados pelos clientes, como nome, idade, raça, e histórico de serviços realizados.
12. **Alterar os preços dos serviços**: O dono pode modificar os preços dos serviços, com base em diferentes critérios como custo ou promoções.
13. **Calendário com Agendamentos**: O dono deve visualizar todos os agendamentos de serviços em um calendário, permitindo a visualização de horários e datas para o controle da agenda.
14. **Alteração do Calendário**: O dono pode alterar a programação de agendamentos, movendo ou reagendando horários conforme necessário e especificar datas sem atendimento ou com atendimento em horários não usuais, no caso de feriados, por exemplo.
15. **Cancelar Agendamentos**: O dono pode cancelar agendamentos de clientes, caso haja necessidade, com o envio de notificações adequadas.
16. **Controle Financeiro**: O dono pode acessar relatórios financeiros detalhados, incluindo valores e quantidade de serviços prestados.
17. **Consultar os Feedbacks Forncecidos**: O dono pode acessar e analisar os feedbacks dos clientes sobre os serviços prestados, ajudando a identificar áreas de melhoria.

### Aba dos Funcionários
18. **Consultar dados dos clientes**: Os funcionários do pet shop devem poder consultar os dados cadastrais dos clientes, incluindo informações de contato, para casos onde o contato direto com o cliente seja necessário.
19. **Consultar informações dos pets**: Os funcionários podem consultar as informações dos pets cadastrados pelos clientes, como nome, idade, raça, e histórico de serviços realizados.
20. **Calendário com Agendamentos**: Os funcionários devem visualizar todos os agendamentos de serviços em um calendário, permitindo a visualização de horários e datas para o controle da agenda.

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