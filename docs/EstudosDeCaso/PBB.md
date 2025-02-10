# Construção de Backlog usando PBB - TechFix  

Utilizamos o **Product Backlog Building (PBB)** para construir o Product Backlog da TechFix, uma empresa consolidada no mercado, especializada em suporte técnico e manutenção de equipamentos para clientes corporativos e residenciais.  

<iframe width="100%" height="600" src="https://miro.com/app/live-embed/uXjVLs5Zk7U=/?moveToViewport=-3211,3313,4484,2341&embedId=593095248277" frameborder="0" scrolling="no" allow="fullscreen; clipboard-read; clipboard-write" allowfullscreen></iframe>

## Priorização dos PBI's
Após a decisão dos PBIs, foi realizada a priorização deles por meio do **COORG**. Os PBI's de prioridade mais alta ficam mais em cima, e os de prioridade baixa, em baixo.  

### Classificar o Backlog  

#### Frequência de Uso  
Classifica a frequência com que o usuário utiliza um PBI.  

*Escala de Valores:*  

- **HORA A HORA (5)**: utilizado mais de uma vez no dia.
- **DIÁRIO (4)**: utilizado uma vez ao dia, pelo menos.
- **SEMANAL (3)**: utilizado uma, duas ou três vezes na semana.  
- **MENSAL (2)**: utilizado uma vez no mês ou um pouco mais de uma vez.  
- **TRIMESTRAL (1)**: utilizado, pelo menos, uma vez a cada três meses 

#### Valor de Negócio  
Representa o valor de negócio gerado quando o usuário utiliza o PBI.  

*Escala de Valores:*

- **ALTO (3)**: muito importante, principal, algo com um valor de negócio alto
- **MÉDIO (2)**: algo que tem relevância, um valor de negócio médio.
- **BAIXO (1)**: algo que faz sentido, mas que não agrega muito valor no
momento atual, um valor de negócio baixo.

#### PRIORIDADE: FREQUÊNCIA DE USO + VALOR DE NEGÓCIO
*Registrar serviços em tempo real:*

- Registrar data e hora do serviço: 5 + 3 = 8 
- Descrever o problema encontrado: 5 + 2 = 7
- Descrever o serviço realizado: 5 + 2 + 7
- Fazer upload de imagens e anexos: 5 + 1 = 6
- Vincular registro ao histórico do cliente: 5 + 3 = 8

*Consultar guias de diagnóstico:*

- Selecionar o equipamento: 5 + 2 = 7
- Visualizar guias técnicos: 5 + 3 = 8
- Ter acesso offline aos guias mais usados: 5 + 1 = 6
- Pesquisar soluções por palavra-chave: 5 + 2 = 7
- Consultar histórico do equipamento: 5 + 3 = 8

*Gerenciar agendamentos:*

- Criar novo agendamento: 5 + 3 = 8
- Alterar agendamento existente: 5 + 2 = 7
- Cancelar agendamento: 5 + 3 = 8
- Visualizar agenda: 5 + 3 = 8
- Receber alertas de conflitos de horário: 5 + 2 = 7

*Acompanhar solicitações em tempo real:*

- Visualizar status da solicitação: 2 + 3 = 5
- Receber notificações de atualizações: 2 + 1 = 3
- Consultar prazo de conclusão: 2 + 2 = 4
- Enviar perguntas sobre a solicitação: 2 + 1 = 3

*Receber relatórios detalhados:*

- Visualizar relatório do serviço prestado: 2 + 3 = 5
- Acessar histórico de serviços: 1 + 2 = 3
- Baixar relatório de serviços em pdf: 2 + 2 = 4
- Baixar relatório de serviços em excel: 2 + 2 = 4
- Filtrar informações por período: 2 + 1 = 3
- Verificar informações financeiras: 2 + 3 = 5

*Fornecer feedback:*

- Avaliar a qualidade do serviço: 2 + 3 = 5
- Adicionar comentário sobre o serviço: 2 + 3 = 5
- Visualizar histórico de feedbacks enviados: 1 + 2 = 3
- Editar feedback enviado: 2 + 2 = 4

*Monitorar equipe em tempo real:*

- Visualizar status da equipe: 5 + 3 = 8 
- Receber alertas de atraso: 5 + 2 = 7
- Adicionar métricas de desempenho: 1 + 3 = 4
- Visualizar histórico de performance das equipes: 2 + 3 = 5 
- Visualizar histórico de performance individual: 2 + 3 = 5
- Filtrar dados por período: 2 + 1 = 3

*Gerar relatórios automáticos:*

- Gerar relatório de desempenho geral: 2 + 3 = 5
- Selecionar período para o relatório: 2 + 2 = 4
- Exportar relatório em pdf: 2 + 1 = 3
- Exportar relatório em excel: 2 + 1 = 3
- Acessar relatórios financeiros: 2 + 3 = 5
- Filtrar relatórios de desempenho por área da empresa: 2 + 2 = 4

### Ordenar o Backlog

As funcionalidades foram organizadas e associadas diretamente às personas identificadas no projeto.

### Organizar o Backlog

Os PBIs de cada funcionalidade foram organizados verticalmente, com base em sua prioridade. Os itens de maior pontuação foram posicionados nas primeiras linhas, enquanto os de menor valor ficaram mais abaixo. Essa organização permite uma visualização clara do que é mais crítico para o produto.

## Histórias de Usuário e BDD

### Registrar serviços em tempo real
- Como técnico de campo, posso registrar data e hora do serviço, para registrar informações no local

    - O sistema permite selecionar data e hora em um calendário interativo
        - **Dado que** o técnico está no local do serviço as 13 horas e 50 minutos
        - **Quando** ele abrir o calendário interativo
        - **Então** ele deve poder selecionar o serviço as 14 horas
    - O registro só pode ser salvo se todos os campos obrigatórios forem preenchidos
        - **Dado** que o técnico preencheu parcialmente o formulário de registro, mas esqueceu de preencher a data
        - **Quando** ele tentar salvar o registro
        - **Então** o sistema deve exibir uma mensagem indicando que a data está pendente

- Como técnico de campo, posso vincular registro ao histórico do cliente, para registrar informações no local

- Como técnico de campo, posso descrever o problema encontrado, para eliminar a necessidade de anotações manuais e retrabalhos

    - O sistema aceita descrições textuais de até 2000 caracteres
    - O técnico pode salvar a descrição em rascunho antes de finalizar o registro
    - O sistema verifica que o campo de descrição não está vazio antes de salvar

- Como técnico de campo, posso descrever o serviço realizado, para eliminar a necessidade de anotações manuais e retrabalhos

- Como técnico de campo, posso fazer upload de imagens e anexos, para registrar informações no local

    - O sistema permite upload de arquivos nos formatos JPG, PNG e PDF
    - O técnico pode visualizar e excluir anexos antes de salvar o registro
    - O tamanho máximo permitido por arquivo é de 50 MB

### Consultar guias de diagnóstico
- Como técnico de campo, posso visualizar guias técnicos, para aumentar precisão e agilidade do serviço

- Como técnico de campo, posso consultar histórico do equipamento, para ver detalhes técnicos e histórico do equipamento

    - O sistema exibe os últimos 10 registros do histórico do equipamento, com opção de carregar mais
    - O técnico pode filtrar o histórico por data ou tipo de serviço
    - Cada registro exibe data, descrição do serviço e técnico responsável

- Como técnico de campo, posso selecionar o equipamento, para ter acesso imediato aos guias de diagnóstico

    - O sistema permite busca por nome, modelo ou número de série do equipamento
    - O equipamento selecionado aparece destacado e as informações associadas são carregadas automaticamente
    - O sistema salva automaticamente a seleção do equipamento para consultas futuras

- Como técnico de campo, posso pesquisar soluções por palavra-chave, para ter acesso imediato aos guias de diagnóstico

    - O sistema aceita termos de busca com até 100 caracteres
    - O técnico pode refinar a busca aplicando filtros adicionais, como categoria ou data

- Como técnico de campo, posso ter acesso offline aos guias mais usados, para ter acesso imediato aos guias de diagnóstico

### Gerenciar agendamentos
- Como atendente, posso criar novo agendamento, para prevenir esquecimentos

    - O sistema exibe todos os horários disponíveis ao criar um agendamento
        - **Dado** que o atendente está criando um novo agendamento para o dia 14 de fevereiro
        - **Quando** ele acessar o calendário de agendamentos
        - **Então** o sistema deve exibir todos os horários disponíveis para o dia 14 de fevereiro
    - O agendamento é confirmado apenas após a validação de conflitos
        - **Dado** que o atendente selecionou um horário para um novo agendamento as 16 horas
        - **Quando** ele tentar confirmar o agendamento
        - **Então** o sistema deve validar se há conflitos antes de confirmar o agendamento as 16 horas
    - O cliente recebe uma notificação automática com a confirmação do agendamento

- Como atendente, posso cancelar agendamento, para reduzir conflitos de agenda

    - O sistema solicita confirmação antes de cancelar um agendamento
    - O sistema registra o motivo do cancelamento, se fornecido

- Como atendente, posso visualizar agenda, para prevenir esquecimentos

- Como atendente, posso alterar agendamento existente, para reduzir conflitos de agenda

- Como atendente, posso receber alertas de conflitos de horários, para reduzir conflitos de agenda

### Acompanhar solicitações em tempo real
- Como cliente corporativo, posso visualizar status da solicitação, para obter transparência do processo

    - O cliente consegue visualizar o status atualizado da solicitação (em andamento, concluído, etc.)
    - O sistema atualiza automaticamente o status a cada alteração registrada pelo técnico
    - O sistema exibe um histórico de mudanças no status, com data e hora de cada atualização

- Como cliente corporativo, posso consultar prazo de conclusão, para ter previsibilidade

    - O cliente consegue visualizar o prazo estimado de conclusão no detalhe da solicitação
    - O cliente recebe alertas por e-mail ou notificação sobre alterações no prazo

- Como cliente corporativo, posso receber notificações e atualizações, para obter transparência do processo

- Como cliente corporativo, posso enviar perguntas sobre a solicitação, para ter clareza e agilidade da comunicação

    - O cliente consegue enviar perguntas diretamente ao técnico responsável pela solicitação
    - O sistema registra e exibe as perguntas e respostas no histórico da solicitação
    - O cliente recebe notificações quando uma resposta for enviada pelo técnico

### Receber relatórios detalhados
- Como cliente corporativo, posso visualizar relatório do serviço prestado, para fazer planejamentos futuros

- Como cliente corporativo, posso verificar informações financeiras, para fazer planejamentos futuros

- Como cliente corporativo, posso baixar relatório de serviços em pdf, para ter registro dos atendimentos

- Como cliente corporativo, posso baixar relatório de serviços em excel, para ter registro dos atendimentos

- Como cliente corporativo, posso acessar histórico de serviços, para fazer planejamentos futuros

    - O cliente consegue visualizar o histórico completo de serviços realizados, organizados por data
        - **Dado** que o cliente está acessando o histórico de serviços do mês de março
        - **Quando** ele abrir a seção correspondente
        - **Então** o sistema deve exibir todos os serviços realizados em março organizado por data como 12/03/2024 e 13/03/2024
    - O histórico pode ser filtrado por tipo de serviço ou técnico responsável
        - **Dado** que o cliente está visualizando o histórico de serviços de reparos de servidores
        - **Quando** ele aplicar filtros por técnico responsável
        - **Então** o sistema deve exibir que o técnico Cristiano realizou os serviços

- Como cliente corporativo, posso filtrar informações por período, para fazer planejamentos futuros

    - O cliente pode selecionar um intervalo de datas para visualizar ou baixar relatórios
        - **Dado** que o cliente está acessando relatórios de suporte técnico
        - **Quando** ele selecionar um intervalo de 15 de março até 14 de abril
        - **Então** o sistema deve exibir ou disponibilizar para download os relatórios de suporte técnico entre 15 de março e 14 de abril
    - O sistema exibe o total de serviços realizados e custos associados no período selecionado
        - **Dado** que o cliente selecionou um intervalo entre 15 de abril e 16 de abril
        - **Quando** o sistema carregar as informações do relatório
        - **Então** ele deve exibir o total de 10 serviços realizados e os custos de R$ 500,00
    - O sistema exibe os serviços realizados no período selecionado, junto ao nome do técnico que o realizou
        - **Dado** que o cliente selecionou um intervalo de 10 de junho a 12 de junho
        - **Quando** o sistema carregar as informações detalhadas
        - **Então** ele deve exibir os serviços realizados entre 10 de junho e 12 de junho realizados pelo técnico João

### Fornecer feedback
- Como cliente corporativo, posso avaliar a qualidade do serviço, para propor melhoria na experiência

    - O cliente consegue selecionar uma nota de 1 a 5 estrelas para avaliar o serviço

- Como cliente corporativo, posso adicionar comentário sobre o serviço, para propor melhoria na experiência

    - O cliente consegue adicionar um comentário com até 500 caracteres
    - O sistema exibe os comentários enviados diretamente no histórico da solicitação

- Como cliente corporativo, posso editar feedback enviado, para propor melhoria na experiência

- Como cliente corporativo, posso visualizar histórico de feedbacks enviados, para saber se a empresa está melhorando

    - O cliente consegue visualizar todas as avaliações positivas e negativas enviadas variando de 1 a 5, organizadas por data
    - O sistema exibe gráficos de torre que resumem as notas médias por período ou tipo de serviço

### Acompanhar solicitações em tempo real
- Como diretora de operações, posso visualizar status da equipe, para acompanhar o desemprenho dos funcionários

- Como diretora de operações, posso receber alertas de atraso, para identificar problemas na empresa

- Como diretora de operações, posso visualizar histórico de performance individual, para acompanhar o desemprenho dos funcionários

    - A diretora consegue visualizar gráficos detalhados do desempenho de cada técnico
        - **Dado** que a diretora está analisando o desempenho baixo do Sérgio
        - **Quando** ela acessar a quantidade de serviços dele
        - **Então** o sistema deve exibir gráficos detalhados mostrando que o Sérgio faltou 10 dias por problemas de saúde
    - O sistema exibe comparações de desempenho entre técnicos do mesmo período
        - **Dado** que a diretora está visualizando o desempenho de vários técnicos
        - **Quando** ela selecionar um período para comparação
        - **Então** o sistema deve exibir gráficos comparativos entre os técnicos

- Como diretora de operações, posso visualizar histórico de performance das equipes, para acompanhar o desemprenho dos funcionários

- Como diretora de operações, posso adicionar métricas de desempenho, para alocar de forma eficiente os recursos

- Como diretora de operações, posso filtrar dados por período, para acompanhar o desemprenho dos funcionários

    - A diretora consegue selecionar intervalos de 15 em 15 dias para visualizar dados específicos
    - Os dados filtrados são exibidos em gráficos de pizza e tabelas organizados por área ou técnico apresentando performances individuais como quantos trabalhos foram entregues durante o período

### Gerar relatórios automáticos
- Como diretora de operações, posso gerar relatório de desempenho geral, para analisar o desemprenho da empresa

- Como diretora de operações, posso acessar relatórios financeiros, para analisar o desemprenho da empresa

- Como diretora de operações, posso selecionar o período para o relatório, para analisar o desemprenho da empresa

- Como diretora de operações, posso filtrar relatórios de desempenho por área da empresa, para analisar o desemprenho da empresa

    - A diretora consegue filtrar relatórios por departamentos ou equipes específicas
    - Os relatórios filtrados incluem gráficos comparativos entre as áreas selecionadas

- Como diretora de operações, posso exportar o relatório em pdf, para ter apoio à tomada de decisões estratégicas

    - O sistema permite exportar relatórios completos em PDF com layout corporativo, os relatórios devem possuir data de emissão, total de custos e receitas, total de desempenho de cada área da empresa.
    - Os relatórios incluem cabeçalhos personalizáveis com logotipos e informações da empresa

- Como diretora de operações, posso exportar o relatório em excel, para ter apoio à tomada de decisões estratégicas

    - O sistema permite exportar relatórios detalhados em Excel, organizados por colunas
    - O arquivo Excel inclui fórmulas e filtros pré-configurados para facilitar a análise



