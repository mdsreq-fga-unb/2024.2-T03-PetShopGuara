# Construção de Backlog usando USM - EduConnect

Utilizamos o **User Story Mapping (USM)** para construir o Product Backlog da EduConnect, uma empresa que visa desenvolver uma plataforma digital que facilite a criação, gestão e avaliação de projetos educacionais interdisciplinares e atividades extracurriculares.

<iframe width="100%" height="600" src="https://miro.com/app/live-embed/uXjVLroMiqM=/?moveToViewport=-2798,-10444,15654,16348&embedId=786667926552" frameborder="0" scrolling="no" allow="fullscreen; clipboard-read; clipboard-write" allowfullscreen></iframe>

## Usuários

| **ID**   | **Descrição**          |
|----------|------------------------|
| Us01     | Professor Coordenador  |
| Us02     | Professor Participante |
| Us03     | Aluno                  | 
| Us04     | Pais/Responsáveis      | 
| Us05     | Especialista Externo   | 
| Us06     | Coordenador Pedagógico | 

## Atividades

| **ID**   | **Descrição**                                   | **Usuário**  |
|----------|-------------------------------------------------|--------------|
| At01     | Planejamento do projeto interdisciplinar        | Us01, Us02, Us06         |
| At02     | Receber recursos para a participação no projeto | Us03         |
| At03     | Garantir informação a todos os envolvidos       | Us04,  Us06         |
| At04     | Monitorar andamento do projeto                  | Us01, Us02, Us03, Us05        |

## Backbone

| **ID**   | **Descrição**                                    | **Atividade** |
|----------|--------------------------------------------------|--------------|
| Bb01     | Definir escopo do projeto                        | At01         |
| Bb02     | Criar cronograma de atividades                   | At01         |
| Bb03     | Acessar os materiais do projeto                  | At02         |
| Bb04     | Inscrever participantes                          | At02         |
| Bb05     | Solicitar autorização                            | At03         |
| Bb06     | Comunicar atualizações e detalhes das atividades | At03         |
| Bb07     | Avaliar desempenho dos participantes             | At04         |
| Bb08     | Documentar o projeto                             | At04         |

## Tarefas do Usuário

## - MVP -

| **ID**   | **Descrição**                                | **Backbone** |
|----------|----------------------------------------------|--------------|
| Ta01     | Definir objetivos pedagógicos                   | Bb01         |
| Ta02     | Definir competências                            | Bb01         |
| Ta03     | Definir critérios de avaliação                  | Bb01         |
| Ta04     | Distribuir papéis para os membros da equipe     | Bb01         |
| Ta05     | Construir roteiro de atividades                 | Bb02         |
| Ta06     | Receber informações iniciais do projeto         | Bb03         |
| Ta07     | Acessar materiais didáticos                     | Bb03         |
| Ta08     | Fazer inscrição nas atividades                  | Bb04         |
| Ta09     | Enviar documento de autorização aos pais        | Bb05         |
| Ta10     | Registrar a assinatura digital                  | Bb05         |
| Ta11     | Enviar comunicados aos pais ao longo do projeto | Bb06         |
| Ta12     | Avaliar o desempenho do aluno                   | Bb07         |
| Ta13     | Visualizar feedbacks fornecidos                 | Bb07         |
| Ta14     | Fazer autoavaliação                             | Bb07         |

## - Backlog -

| **ID**   | **Descrição**                                             | **Backbone** |
|----------|-----------------------------------------------------------|--------------|
| Ta15     | Estipular recursos necessários para realizar o projeto    | Bb01         |
| Ta16     | Adaptar planejamento diante de circunstâncias inesperadas | Bb02         |
| Ta17     | Formar grupos                                             | Bb04         |
| Ta18     | Ter comunicação entre responsáveis e educadores           | Bb06         |
| Ta19     | Registrar evidências de aprendizagem                      | Bb07         |
| Ta20     | Avaliar impacto das contribuições dos especialistas       | Bb07         |
| Ta21     | Documentar o desenvolvimento do projeto                   | Bb08         |
| Ta22     | Documentar lições aprendidas                              | Bb08         |
| Ta23     | Planejar melhorias para futuras iterações                 | Bb08         |

## Tarefas em Histórias de Usuário

### Backbone: Bb01

- **Definir objetivos pedagógicos**  
  **•** Deve ser possível preencher e salvar os objetivos pedagógicos no painel de planejamento.  
  **•** Os objetivos salvos devem ser associados ao projeto e permitir edição futura.  

- **Definir competências**  
  **•** Deve ser possível definir e salvar as competências que os alunos devem desenvolver durante o projeto.  

- **Definir critérios de avaliação**  
  **•** Deve ser possível criar critérios de avaliação e associá-los às atividades do projeto.  

- **Distribuir papéis para os membros da equipe**  
  **•** Deve ser possível atribuir papéis e responsabilidades aos membros da equipe.  
  **•** Cada membro deve ser notificado sobre seu papel atribuído.  

- **Planejar recursos necessários**  
  **•** Deve ser possível listar e planejar os recursos necessários para a execução do projeto.  

### Backbone: Bb02

- **Construir roteiro de atividades**  
  **•** Deve ser possível criar e visualizar um cronograma de atividades para o projeto.  

- **Adaptar planejamento diante de circunstâncias inesperadas**  
  **•** Deve ser possível alterar o cronograma e notificar automaticamente os envolvidos sobre as mudanças.  

### Backbone: Bb03

- **Receber informações iniciais do projeto**  
  **•** O aluno deve visualizar um resumo das informações do projeto ao acessar o portal.  

- **Acessar materiais didáticos**  
  **•** O aluno deve poder acessar e baixar os materiais didáticos disponíveis para o projeto.  

### Backbone: Bb04

- **Inscrever-se nas atividades do projeto**  
  **•** O aluno deve poder se inscrever nas atividades disponíveis.  

- **Formar grupos**  
  **•** O aluno deve poder selecionar ou ser alocado em um grupo, com confirmação automática da inscrição.  

### Backbone: Bb05

- **Enviar documentos de autorização aos pais**  
  **•** Deve ser possível enviar documentos de autorização aos pais, com notificação automática por e-mail ou sistema.  

- **Registrar assinatura digital**  
  **•** O responsável deve poder clicar no documento de autorização e ser direcionado a uma página segura para assinar.  
  **•** Após a assinatura, a autorização deve ser vinculada ao perfil do aluno.  

### Backbone: Bb06

- **Enviar comunicados aos pais**  
  **•** Deve ser possível enviar comunicados aos pais, com notificação automática por e-mail ou sistema.  
  **•** Deve haver um histórico de comunicados enviados para consulta.  

- **Comunicação entre responsáveis e educadores**  
  **•** O responsável deve poder enviar mensagens aos educadores pelo sistema.  
  **•** O educador deve poder responder, e o responsável deve receber notificação da resposta.  

### Backbone: Bb07

- **Avaliar desempenho dos alunos**  
  **•** O professor deve poder avaliar o desempenho dos alunos com base nos critérios de avaliação definidos.  
  **•** As avaliações devem ser salvas e vinculadas ao perfil do aluno.  

- **Visualizar feedbacks**  
  **•** O aluno deve poder visualizar os feedbacks fornecidos pelos professores.  

- **Realizar autoavaliação**  
  **•** O aluno deve poder preencher uma autoavaliação com base nas competências definidas.  
  **•** As respostas da autoavaliação devem ser salvas no sistema.  

- **Registrar evidências de aprendizagem**  
  **•** O professor deve poder registrar evidências de aprendizagem dos alunos.  

- **Avaliar impacto das contribuições dos especialistas**  
  **•** O coordenador e professores devem poder avaliar o impacto das contribuições dos especialistas no projeto.  

### Backbone: Bb08

- **Documentar o desenvolvimento do projeto**  
  **•** Deve ser possível registrar entradas sobre o desenvolvimento do projeto.  
  **•** As entradas devem ser salvas e associadas ao projeto.  

- **Documentar lições aprendidas**  
  **•** Professores e alunos devem poder registrar lições aprendidas durante o projeto.  
  **•** As lições aprendidas devem ser salvas e associadas ao perfil do usuário.  

- **Planejar melhorias para futuras iterações**  
  **•** Deve ser possível criar um plano de melhorias com base nas lições aprendidas.  