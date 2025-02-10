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

## 1. Caso de Uso: Cadastrar Refugiado  

### 1.1 Breve Descrição  
Este caso de uso permite que um refugiado realize seu cadastro na plataforma *HopeBridge*, informando seus dados pessoais, localização e necessidades específicas.  

### 1.2 Atores  
- Refugiado  

### 2. Fluxo de Eventos  

#### 2.1 Fluxo Principal  
1. O usuário acessa a tela de cadastro.  
2. O sistema exibe um formulário de registro.  
3. O usuário preenche os campos obrigatórios.
4. O usuário confirma o cadastro[RN02] [FE01].  
5. O sistema valida os dados informados[RN01] [FE02].  
6. O sistema cria a conta e exibe uma mensagem de sucesso[FE03].  
7. O caso de uso é encerrado.  

#### 2.2 Fluxos de Exceção  
- **[FE01] Campos obrigatórios não preenchidos**: O sistema informa quais campos são obrigatórios e retorna ao passo 3.  
- **[FE02] Formato inválido de dados**: O sistema alerta o usuário e permite correção antes de enviar o cadastro.  
- **[FE03] Erro de conexão**: O sistema informa o usuário e permite tentar novamente mais tarde.  

### 3. Requisitos Especiais  
- O cadastro deve ser acessível via dispositivos móveis. 

### 4. Regras de Negócio  
- **[RN01] Validação de Informações**: 
- O e-mail ou número de telefone deve ser único no sistema.    
- A data de nascimento deve estar em um formato válido (DD/MM/AAAA).   

- **[RN02] Campos preenchidos**:
- Os campos com dados pessoais, localização, tamanho da família, necessidades específicas e capacitação profissional precisam ser preenchidos.

---

## 2. Caso de Uso: Localizar Serviços Essenciais  

### 1.1 Breve Descrição  
Este caso de uso permite que o refugiado busque por serviços essenciais próximos, como abrigos, assistência médica e distribuição de alimentos.  

### 1.2 Atores  
- Refugiado  

### 2. Fluxo de Eventos  

#### 2.1 Fluxo Principal  
1. O usuário acessa a opção de localizar serviços essenciais.  
2. O sistema solicita acesso a localização atual do usuário.  
3. O usuário informa sua localização atual ou permite o acesso via GPS.  
4. O sistema exibe uma lista de serviços disponíveis na região[FE01].  
5. O caso de uso é encerrado.  

#### 2.2 Fluxos de Exceção  
- **[FE01] Falha no GPS**: Se o GPS não estiver disponível, o usuário pode inserir a localização manualmente ao voltar para o passo 3.  

### 3. Requisitos Especiais  
- A busca deve funcionar offline com dados previamente carregados.
- A busca deve ser acessível via dispositivos móveis.  

---

## 3. Caso de Uso: Solicitar Abrigo  

### 1.1 Breve Descrição  
Este caso de uso permite que um refugiado solicite uma vaga em um abrigo disponível.  

### 1.2 Atores  
- Refugiado  

### 2. Fluxo de Eventos  

#### 2.1 Fluxo Principal
1. O refugiado seleciona a opção de abrigos disponíveis.
2. O sistema solicita a localização atual do usuário.
3. O refugiado informa sua localização atual ou permite o acesso via GPS.  
4. O sistema apresenta os abrigos diponíveis e suas localizações.  
5. O usuário seleciona um abrigo e verifica seus detalhes.
6. O sistema apresenta os detalhes do abrigo.  
7. O usuário solicita uma vaga[FE01].  
8. O sistema confirma a solicitação e exibe uma mensagem de sucesso.  
9. O caso de uso é encerrado.   

#### 2.2 Fluxos de Exceção  
- **[FE01] Erro de conexão**: O sistema permite que a solicitação seja registrada offline para envio posterior.  

### 3. Requisitos Especiais  
- O sistema deve permitir reservas de abrigo com antecedência.
- A solicitação deve ser acessível via dispositivos móveis.  

### 4. Precondições
- Para utilizar este caso de uso é necessário que o refugiado esteja *logado* na plataforma.

---

## 4. Caso de Uso: Buscar Oportunidades de Trabalho  

### 1.1 Breve Descrição  
Este caso de uso permite que refugiados acessem vagas de emprego compatíveis com seu perfil.  

### 1.2 Atores  
- Refugiado  

### 2. Fluxo de Eventos  

#### 2.1 Fluxo Principal  
1. O usuário seleciona a opção de vagas de emprego.
2. O sistema solicita a localização atual do usuário.
3. O refugiado informa sua localização atual ou permite o acesso via GPS.  
4. O sistema exibe uma lista de vagas disponíveis baseadas no perfil do usuário[RN01].  
5. O usuário pode visualizar os detalhes de uma vaga e se inscrever.
6. O sistema confirma a inscrição e exibe uma mensagem de sucesso.  
6. O caso de uso é encerrado.   

#### 2.2 Fluxos de Exceção  
- **[FE01] Falha na busca**: Se houver erro ao carregar as vagas, o usuário pode tentar novamente mais tarde.  

### 3. Requisitos Especiais  
- Esse caso de uso deve ser acessível em dispositivos móveis. 

### 4. Regras de Negócio
- **[RN01] Capacitação técnica**: A busca de vagas deve considerar as habilidades do usuário.  

### 5. Precondições
- Para utilizar este caso de uso é necessário que o refugiado esteja *logado* na plataforma.

---

## 5. Caso de Uso: Gerenciar Alocação de Recursos humanitários 

### 1.1 Breve Descrição  
Este caso de uso permite que agências humanitárias monitorem e distribuam recursos de forma eficiente.  

### 1.2 Atores  
- Agência Humanitária  

### 2. Fluxo de Eventos  

#### 2.1 Fluxo Principal  
1. A agência seleciona a opção de gestão de recursos.  
2. O sistema exibe uma lista de demandas registradas por refugiados.  
3. A agência seleciona uma demanda para atendimento[FE01].  
4. O sistema registra a alocação do recurso[FA01]. 
5. O sistema exibe uma mensagem confirmando a alocação de recursos. 
6. O caso de uso é encerrado.  

#### 2.2 Fluxos Alternativos  
- **[FA01] Estoque insuficiente**: No passo 4 do fluxo principal, se o estoque for insuficiente, o sistema alerta a agência e sugere remanejamento de recursos.  

#### 2.3 Fluxos de Exceção  
- **[FE01] Erro no registro**: Se houver falha na atualização do sistema, o processo volta ao passo 2 e pode ser tentado novamente.  

### 3. Requisitos Especiais  
- O sistema deve permitir acesso a relatórios de alocação de recursos. 

### 4. Precondições
- Para utilizar este caso de uso é necessário que a agência esteja *logada* na plataforma.
