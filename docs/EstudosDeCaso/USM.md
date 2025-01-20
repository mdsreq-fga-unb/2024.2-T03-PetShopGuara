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

- Eu, como coordenador pedagógico, gostaria de definir objetivos pedagógicos para alinhar o projeto aos resultados esperados.
    - Dado que estou no painel de planejamento, quando acessar a seção de objetivos pedagógicos, então devo visualizar um formulário para preenchimento.
    - Dado que preencho os objetivos, quando salvar, então eles devem ser associados ao projeto.
    - Dado que quero revisar os objetivos, quando acessar novamente a seção, então devo poder editá-los.
- Eu, como professor coordenador, gostaria de definir objetivos pedagógicos para alinhar o projeto aos resultados esperados.
- Eu, como professor participante, quero compreender os objetivos pedagógicos para guiar minhas atividades durante o projeto.
- Eu, como coordenador pedagógico, desejo definir competências para garantir que os alunos desenvolvam habilidades específicas ao longo do projeto.
- Eu, como professor coordenador, desejo definir competências para garantir que os alunos desenvolvam habilidades específicas ao longo do projeto.
- Eu, como coordenador pedagógico, gostaria de definir critérios de avaliação para medir o sucesso das atividades e o progresso dos alunos.
    - Dado que acesso a seção de critérios de avaliação, quando crio novos critérios, então eles devem ser associados às atividades do projeto.
- Eu, como professor coordenador, gostaria de definir critérios de avaliação para medir o sucesso das atividades e o progresso dos alunos.
- Eu, como coordenador pedagógico, desejo distribuir papéis para os membros da equipe para garantir que todos saibam suas responsabilidades e colaborem de maneira eficiente.
    - Dado que acesso o painel de papéis, quando distribuo responsabilidades, então cada membro deve ser notificado sobre seu papel.
- Eu, como coordenador pedagógico, gostaria de planejar os recursos necessários para evitar problemas de logística durante o projeto.

### Backbone: Bb02

- Eu, como professor participante, quero construir um roteiro de atividades para planejar as tarefas diárias com os alunos.
- Eu, como professor coordenador, quero adaptar o planejamento para lidar com situações imprevistas sem prejudicar o andamento do projeto.
    - Dado que acesso o cronograma, quando altero o planejamento, então as mudanças devem ser notificadas aos envolvidos.
- Eu, como coordenador pedagógico, quero adaptar o planejamento para lidar com situações imprevistas sem prejudicar o andamento do projeto.

### Backbone: Bb03

- Eu, como aluno, gostaria de receber informações iniciais do projeto para entender o que será esperado de mim.
    - Dado que recebo acesso ao portal do projeto, quando entro na página inicial, então devo visualizar um resumo das informações do projeto.
- Eu, como aluno, quero acessar os materiais didáticos para me preparar para as atividades do projeto.

### Backbone: Bb04

- Eu, como aluno, desejo me inscrever nas atividades do projeto para participar das atividades planejadas.
- Eu, como aluno, gostaria de formar grupos para trabalhar em equipe durante o projeto.
    - Dado que acesso a seção de grupos, quando seleciono um grupo, então minha inscrição no grupo deve ser confirmada.

### Backbone: Bb05

- Eu, como coordenador pedagógico, gostaria de enviar documentos de autorização aos pais para garantir a participação formal dos alunos no projeto.
    - Dado que estou no painel de autorizações, quando envio documentos para os pais, então os pais devem receber uma notificação com o documento anexado.
    - Dado que envio documentos, quando os pais acessam o link, então eles devem conseguir visualizar e assinar digitalmente.
- Eu, como pai/responsável, desejo registrar minha assinatura digital para autorizar a participação do meu filho no projeto.
    - Dado que recebo um documento de autorização, quando clico no link, então devo ser direcionado a uma página segura para assinar.
    - Dado que registro minha assinatura, quando confirmo, então a autorização deve ser vinculada ao perfil do meu filho.

### Backbone: Bb06

- Eu, como coordenador pedagógico, gostaria de enviar comunicados aos pais para mantê-los atualizados sobre o andamento do projeto.
    - Dado que acesso o painel de comunicação, quando envio um comunicado, então todos os pais devem ser notificados por e-mail ou mensagem no sistema.
    - Dado que visualizo os comunicados enviados, quando acesso o histórico, então devo ver uma lista dos comunicados enviados.
- Eu, como pai/responsável, desejo me comunicar com os educadores para esclarecer dúvidas.
    - Dado que acesso o portal do projeto, quando seleciono a opção de mensagem, então devo conseguir enviar uma mensagem para o educador responsável.
    - Dado que envio uma mensagem, quando o educador responde, então devo receber uma notificação.

### Backbone: Bb07

- Eu, como professor participante, quero avaliar o desempenho dos alunos para identificar pontos de melhoria.
    - Dado que acesso o painel de avaliação, quando seleciono um aluno, então devo poder dar uma nota de 1 a 5 em cada critério de avaliação.
    - Dado que preencho uma avaliação, quando salvo, então ela deve ser registrada e vinculada ao perfil do aluno.
- Eu, como aluno, quero visualizar os feedbacks fornecidos pelos professores para melhorar minhas habilidades.
    - Dado que acesso a seção de feedbacks, quando escolho um comentário, então devo visualizar as observações completas.
- Eu, como aluno, gostaria de realizar uma autoavaliação para refletir sobre meu desempenho e aprendizado.
    - Dado que acesso o painel de autoavaliação, quando seleciono uma das competências, então devo poder dar uma nota de 1 a 5.
    - Dado que acesso o formulário de autoavaliação, quando preencho os campos, então as respostas devem ser salvas no sistema.
- Eu, como professor participante, desejo registrar evidências de aprendizagem para acompanhar o progresso dos alunos.
- Eu, como coordenador pedagógico, quero avaliar o impacto das contribuições dos especialistas para ajustar o planejamento e agregar valor ao projeto.
- Eu, como professor coordenador, quero avaliar o impacto das contribuições dos especialistas para ajustar o planejamento e agregar valor ao projeto.
- Eu, como especialista externo, desejo avaliar o impacto das minhas contribuições no projeto para entender como elas ajudam os participantes e melhorar minha abordagem em futuras colaborações.

### Backbone: Bb08

- Eu, como professor participante, desejo documentar o desenvolvimento do projeto para analisar os resultados e compartilhar experiências.
    - Dado que acesso a seção de documentação, quando insiro entradas, então elas devem ser salvas e associadas ao projeto.
- Eu, como professor coordenador, desejo documentar o desenvolvimento do projeto para analisar os resultados e compartilhar experiências.
- Eu, como coordenador pedagógico, gostaria de documentar o desenvolvimento para garantir a melhoria contínua dos processos.
- Eu, como professor participante, quero documentar as lições aprendidas para aprimorar futuros projetos.
- Eu, como aluno, quero documentar as lições aprendidas para aprimorar futuros projetos.
    - Dado que acesso a seção de lições aprendidas, quando insiro minhas percepções, então elas devem ser salvas e associadas ao meu perfil.
- Eu, como coordenador pedagógico, desejo planejar melhorias para futuras iterações com base nas lições aprendidas.



