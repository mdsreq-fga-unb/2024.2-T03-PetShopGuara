# Estudo de Caso: "HopeBridge - Reconstruindo Vidas e Comunidades de Refugiados Palestinos"

Utilizamos um **Diagrama de Casos de Uso** para apresentar uma visão externa das funções e serviços oferecidas aos usuários da plataforma da HopeBridge, que foi criada para conectar os refugiados palestinos aos serviços essenciais, oportunidades de trabalho e redes de apoio, promovendo a recosntrução de vidas e comunidades de forma integrada e sustentável.

<iframe width="768" height="432" src="https://miro.com/app/live-embed/uXjVLiQds4g=/?moveToViewport=-1553,-575,3162,1570&embedId=332323807868" frameborder="0" scrolling="no" allow="fullscreen; clipboard-read; clipboard-write" allowfullscreen></iframe>

| Atores                           | Descrição                                                             |
|----------------------------------|-----------------------------------------------------------------------|
| **Refugiado**                    | Usuário que busca serviços essenciais, emprego e capacitação.         |
| **Agência Humanitária**          | Organizações que distribuem recursos e monitoram necessidades.        |
| **Empregadores Parceiros**       | Empresas ou parceiros que oferecem vagas de trabalho e treinamentos.  |
| **Administrador do Sistema**     | Responsável por gerenciar usuários, métricas e relatórios do sistema. |

# Resumo dos Casos de Uso - HopeBridge

## 1. Refugiado  
| Caso de Uso              | Objetivo                                                 | Resultado Observável                            |
|--------------------------|----------------------------------------------------------|-----------------------------------------------|
| Cadastrar refugiado      | Criar um perfil na plataforma.                           | Perfil ativo com informações registradas.     |
| Localizar serviços essenciais       | Encontrar abrigos, alimentos e assistência médica.       | Lista de serviços disponíveis na região.      |
| Solicitar abrigo         | Reservar um local para estadia temporária.               | Confirmação da reserva de abrigo.             |
| Agendar atendimento médico  | Conseguir atendimento médico para si ou familiares.      | Consulta médica agendada.                     |
| Solicitar vouchers de alimentos e itens básicos       | Obter alimentos e itens essenciais.                      | Voucher gerado e pronto para uso.             |
| Visualizar mapas interativos    | Visualizar rotas para serviços essenciais.               | Direções exibidas no mapa interativo.         |
| Buscar oportunidades de capacitação profissional       | Encontrar cursos de qualificação profissional.           | Lista de cursos compatíveis com o perfil.     |
| Buscar vagas de emprego           | Identificar oportunidades de trabalho disponíveis.       | Exibição de vagas disponíveis.                |
| Inscrever em vagas de emprego    | Se inscrever para empregos compatíveis.                  | Candidatura enviada ao empregador.            |

## 2. Agência Humanitária  
| Caso de Uso              | Objetivo                                                 | Resultado Observável                            |
|--------------------------|----------------------------------------------------------|------------------------------------------------|
| Cadastrar agência        | Criar um perfil de organização humanitária.              | Agência cadastrada no sistema.                 |
| Gerenciar alocação de recursos humanitários       | Administrar a alocação de ajuda humanitária.             | Distribuição eficiente de recursos.            |
| Monitorar distribuição de recursos   | Acompanhar estatísticas sobre entrega de suprimentos.    | Relatórios atualizados sobre distribuição.     |
| Gerar relatórios         | Criar documentos sobre impacto e eficiência.             | Relatórios detalhados são gerados, permitindo que organizações avaliem o impacto das ações realizadas.           |

## 3. Empregadores Parceiros  
| Caso de Uso              | Objetivo                                                 | Resultado Observável                            |
|--------------------------|----------------------------------------------------------|------------------------------------------------|
| Cadastrar empregador     | Criar um perfil de empresa ou organização contratante.   | Conta registrada na plataforma.                |
| Cadastrar vagas de emprego e programas de capacitação        | Divulgar oportunidades de trabalho.                      | Vagas visíveis para refugiados.                |
| Gerenciar candidatos a vagas de emprego    | Visualizar e selecionar candidatos para entrevistas.     | Lista de candidatos com opções de seleção.     |

## 4. Administrador do Sistema
| Caso de Uso              | Objetivo                                                 | Resultado Observável                            |
|--------------------------|----------------------------------------------------------|------------------------------------------------|
| Cadastrar administrador  | Criar um perfil de administrador da plataforma.          | Conta ativada com permissões especiais.        |
| Acompanhar impacto e métricas do sistema     | Monitorar estatísticas de uso da plataforma.             | Relatórios de desempenho disponíveis.          |
| Ajustar funcionalidades da plataforma     | Modificar e otimizar recursos e ferramentas conforme as necessidades dos usuários.               | Funcionalidades atualizadas e adaptadas às demandas.              |
| Gerenciar usuários da plataforma      | Controlar permissões e acessos dos atores.               | Usuários gerenciados conforme necessidade.     |

# Especificação de Casos de Uso – HopeBridge  

## 1. Caso de Uso: Registrar Usuário  

### 1.1 Breve Descrição  
Este caso de uso permite que um usuário (refugiado) realize seu cadastro na plataforma *HopeBridge*, informando seus dados pessoais, localização e necessidades específicas.  

### 1.2 Atores  
- Refugiado  

### 2. Fluxo de Eventos  

#### 2.1 Fluxo Principal  
1. O usuário acessa a tela de registro da plataforma.  
2. O sistema exibe um formulário de cadastro.  
3. O usuário preenche os campos obrigatórios e confirma o registro.  
4. O sistema valida os dados informados.  
5. O sistema cria a conta e exibe uma mensagem de sucesso.  
6. O caso de uso é encerrado.  

#### 2.2 Fluxos Alternativos  
- **[FA01] Dados inválidos**: O sistema exibe uma mensagem de erro caso informações obrigatórias não sejam preenchidas.  

#### 2.3 Fluxos de Exceção  
- **[FE01] Erro de conexão**: Se houver falha na comunicação com o servidor, o sistema informa o usuário e permite tentar novamente.  

### 3. Requisitos Especiais  
- O cadastro deve ser possível via dispositivos móveis.  

### 4. Regras de Negócio  
- O e-mail ou número de telefone deve ser único no sistema.  

---

## 2. Caso de Uso: Localizar Serviços Essenciais  

### 1.1 Breve Descrição  
Este caso de uso permite que o refugiado busque por serviços essenciais próximos, como abrigos, assistência médica e distribuição de alimentos.  

### 1.2 Atores  
- Refugiado  

### 2. Fluxo de Eventos  

#### 2.1 Fluxo Principal  
1. O usuário acessa a opção de busca de serviços.  
2. O sistema solicita a localização do usuário.  
3. O usuário informa sua localização ou permite o acesso via GPS.  
4. O sistema exibe uma lista de serviços disponíveis na região.  
5. O caso de uso é encerrado.  

#### 2.2 Fluxos Alternativos  
- **[FA01] Nenhum serviço encontrado**: O sistema exibe uma mensagem sugerindo áreas próximas com serviços disponíveis.  

#### 2.3 Fluxos de Exceção  
- **[FE01] Falha no GPS**: Se o GPS não estiver disponível, o usuário pode inserir a localização manualmente.  

### 3. Requisitos Especiais  
- A busca deve funcionar offline com dados previamente carregados.  

---

## 3. Caso de Uso: Solicitar Abrigo  

### 1.1 Breve Descrição  
Este caso de uso permite que um refugiado solicite uma vaga em um abrigo disponível.  

### 1.2 Atores  
- Refugiado  

### 2. Fluxo de Eventos  

#### 2.1 Fluxo Principal  
1. O usuário acessa a lista de abrigos disponíveis.  
2. O usuário seleciona um abrigo e verifica os detalhes.  
3. O usuário solicita uma vaga.  
4. O sistema confirma a solicitação e exibe uma mensagem de sucesso.  
5. O caso de uso é encerrado.  

#### 2.2 Fluxos Alternativos  
- **[FA01] Abrigo lotado**: O sistema informa indisponibilidade e sugere alternativas.  

#### 2.3 Fluxos de Exceção  
- **[FE01] Erro de conexão**: O sistema permite que a solicitação seja registrada offline para envio posterior.  

### 3. Requisitos Especiais  
- O sistema deve permitir reservas de abrigo com antecedência.  

---

## 4. Caso de Uso: Buscar Oportunidades de Trabalho  

### 1.1 Breve Descrição  
Este caso de uso permite que refugiados acessem vagas de emprego compatíveis com seu perfil.  

### 1.2 Atores  
- Refugiado  

### 2. Fluxo de Eventos  

#### 2.1 Fluxo Principal  
1. O usuário acessa a opção de busca de empregos.  
2. O sistema solicita dados do perfil profissional do usuário.  
3. O sistema exibe uma lista de vagas disponíveis.  
4. O usuário pode visualizar os detalhes de uma vaga e se candidatar.  
5. O caso de uso é encerrado.  

#### 2.2 Fluxos Alternativos  
- **[FA01] Nenhuma vaga compatível**: O sistema sugere cursos de capacitação relacionados.  

#### 2.3 Fluxos de Exceção  
- **[FE01] Falha na busca**: Se houver erro ao carregar as vagas, o usuário pode tentar novamente mais tarde.  

### 3. Requisitos Especiais  
- A busca de vagas deve considerar as habilidades do usuário.  

---

## 5. Caso de Uso: Gerenciar Alocação de Recursos  

### 1.1 Breve Descrição  
Este caso de uso permite que agências humanitárias monitorem e distribuam recursos de forma eficiente.  

### 1.2 Atores  
- Agência Humanitária  

### 2. Fluxo de Eventos  

#### 2.1 Fluxo Principal  
1. A agência acessa o painel de gestão de recursos.  
2. O sistema exibe uma lista de demandas registradas por refugiados.  
3. A agência seleciona uma demanda para atendimento.  
4. O sistema registra a alocação do recurso.  
5. O caso de uso é encerrado.  

#### 2.2 Fluxos Alternativos  
- **[FA01] Estoque insuficiente**: O sistema alerta a agência e sugere remanejamento de recursos.  

#### 2.3 Fluxos de Exceção  
- **[FE01] Erro no registro**: Se houver falha na atualização do sistema, o processo pode ser tentado novamente.  

### 3. Requisitos Especiais  
- O sistema deve permitir acesso a relatórios de alocação.  
