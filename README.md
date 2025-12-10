# ⏰ Relógio Digital com Timer

Aplicação desktop desenvolvida em JavaFX que combina um relógio digital em tempo real com um timer configurável. Implementa o padrão de arquitetura MVC (Model-View-Controller) com gerenciamento robusto de estados e validações.

## 📋 Descrição

Sistema de cronometragem desenvolvido em Java 21 com Maven, oferecendo interface gráfica moderna através do JavaFX. O projeto demonstra boas práticas de arquitetura de software, incluindo separação de responsabilidades, testes unitários e controle preciso de estados da aplicação.

## ✨ Funcionalidades

### Relógio Digital
- Exibição da hora atual do sistema em tempo real (formato HH:MM:SS)
- Atualização automática a cada segundo
- Interface limpa e de fácil leitura

### Timer Configurável
- Configuração de tempo através de spinners (horas: 0-99, minutos: 0-59, segundos: 0-59)
- **Iniciar**: Inicia a contagem regressiva com os valores definidos
- **Pausar/Continuar**: Alterna entre pausar e retomar a contagem
- **Parar**: Interrompe o timer e reseta todos os valores para zero
- Bloqueio automático de spinners durante execução
- Proteção contra múltiplas timelines concorrentes
- Desabilitação inteligente de controles para prevenir estados inválidos

## 🛠️ Tecnologias Utilizadas

- **Java 21** - Linguagem de programação
- **JavaFX 20** - Framework para interface gráfica
- **Maven 3.8+** - Gerenciamento de dependências e build
- **FXML** - Declaração de interface
- **JUnit** - Framework de testes unitários
- **Timeline API** - Controle de animações e atualizações temporais

## 📁 Estrutura do Projeto

```
relogio-timer/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── relogio/
│   │   │           ├── Controller/
│   │   │           │   └── FuncionamentoRelogio.java
│   │   │           ├── Model/
│   │   │           │   └── TimerModel.java
│   │   │           └── Main.java
│   │   └── resources/
│   │       └── Relogio.fxml
│   └── test/
│       └── java/
│           └── com/
│               └── relogio/
│                   └── Model/
│                       └── TimerModelTest.java
├── pom.xml
└── README.md
```

### Arquitetura MVC

- **Model** (`TimerModel.java`): Encapsula a lógica de negócio do timer, incluindo conversões entre formatos de tempo, validações e controle da contagem regressiva
- **View** (`Relogio.fxml`): Define a interface gráfica utilizando componentes JavaFX (Labels, Spinners, Buttons) com layout responsivo
- **Controller** (`FuncionamentoRelogio.java`): Gerencia a comunicação entre Model e View, controla eventos de usuário e orquestra as atualizações da interface

## 🚀 Como Executar

### Pré-requisitos

- **JDK 21** ou superior instalado
- **Maven 3.8+** configurado no PATH
- IDE compatível (IntelliJ IDEA, Eclipse, VS Code com extensões Java)

### Instalação

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/relogio-digital-timer.git
cd relogio-digital-timer
```

2. Compile o projeto:
```bash
mvn clean package
```

### Execução

Execute via plugin JavaFX do Maven:
```bash
mvn javafx:run
```

**Nota**: Se houver warnings sobre acesso nativo, configure as opções da JVM:
```bash
mvn javafx:run -Djavafx.args="--enable-native-access=javafx.graphics"
```

### Executar Testes

```bash
mvn test
```

Para executar testes com relatório detalhado:
```bash
mvn -DskipTests=false test
```

## ⚙️ Configuração (pom.xml)

O projeto utiliza as seguintes propriedades configuradas no Maven:

```xml
<properties>
    <java.version>21</java.version>
    <javafx.version>20</javafx.version>
    <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
</properties>
```

### Dependências Principais

- `org.openjfx:javafx-controls:20`
- `org.openjfx:javafx-fxml:20`
- `junit:junit:4.13.2` (escopo de teste)

## 🧪 Testes

O projeto inclui testes unitários para validar a lógica do `TimerModel`:

- Conversão de horas/minutos/segundos para segundos totais
- Funcionamento correto do método `diminuir()`
- Verificação de condição de término (`isTempoEsgotado()`)
- Formatação correta do tempo (HH:MM:SS)

Localização: `src/test/java/com/relogio/Model/TimerModelTest.java`

## 🔧 Solução de Problemas Comuns

### Erro: "Error resolving onAction='#pausarTimer'"
**Causa**: Método não encontrado no controller ou configuração FXML incorreta.

**Solução**:
1. Verifique se `fx:controller="com.relogio.Controller.FuncionamentoRelogio"` está presente no FXML
2. Confirme que o método existe e está anotado com `@FXML`
3. Execute `mvn clean` e reconstrua o projeto

### Aviso: "Loading FXML with JavaFX API version X by runtime version Y"
**Causa**: Incompatibilidade entre versões do JavaFX no IDE e no runtime.

**Solução**: Alinhe as versões no `pom.xml` e na configuração da IDE (File → Project Structure → Libraries)

### Spinners mostrando valores inesperados
**Causa**: `SpinnerValueFactory` não inicializado corretamente.

**Solução**: Verifique se os spinners são configurados no método `initialize()` do controller antes do uso

## 💡 Conceitos Aplicados

- **Padrão MVC**: Separação clara entre camadas de apresentação, lógica e dados
- **Programação Orientada a Eventos**: Manipulação de eventos de interface (ActionEvent)
- **Gerenciamento de Estado**: Controle de estados da aplicação com transições válidas
- **Proteção contra Race Conditions**: Validações para prevenir múltiplas timelines simultâneas
- **Testes Unitários**: Cobertura de lógica crítica com JUnit
- **Princípio DRY**: Métodos auxiliares para evitar duplicação de código
- **Validação de Entrada**: Spinners com intervalos limitados para prevenir valores inválidos

## 📈 Melhorias Futuras

- [ ] Notificação sonora ao término do timer
- [ ] Presets de tempo rápido (1min, 5min, 10min, 15min)
- [ ] Persistência de última configuração utilizada
- [ ] Tema escuro/claro alternável
- [ ] Histórico de timers executados
- [ ] Suporte a múltiplos timers simultâneos
- [ ] Notificação do sistema operacional ao término

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👤 Autor

Desenvolvido como projeto de estudo para consolidação de conhecimentos em JavaFX, arquitetura de software e boas práticas de desenvolvimento Java.

---

⭐ **Se este projeto foi útil para você, considere deixar uma estrela no repositório!**
