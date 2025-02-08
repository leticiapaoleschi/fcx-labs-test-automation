# FCx Labs Test Automation

## 📌 Sobre o Desafio
Este repositório contém os cenários de teste escritos em Gherkin e a automação do fluxo de checkout do e-commerce *Advantage Online Shopping*.

## 📋 Pré-requisitos

1. **Java 11 instalado**:
    - Baixe e instale o Java no [site oficial](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
    - Para verificar a instalação, execute no terminal:
      ```bash
      java -version
      ```

2. **Maven instalado**:
    - O Maven é usado para gerenciar as dependências do projeto.
    - Para verificar se está instalado, execute:
      ```bash
      mvn -version
      ```
    - Se não estiver instalado, veja [como instalar o Maven](https://maven.apache.org/install.html).

3. **Google Chrome e WebDriver compatível**:
    - Baixe a versão do ChromeDriver correspondente à sua versão do Chrome em [ChromeDriver](https://googlechromelabs.github.io/chrome-for-testing/).
    - Adicione o WebDriver ao PATH do sistema.

## 👨‍💻 Como instalar e rodar o projeto

1. **Clone este repositório**:
   ```bash
   git clone https://github.com/leticiapaoleschi/fcx-labs-test-automation.git
   cd fcx-labs-test-automation
   Utilize uma IDE de sua preferência (ex: IntelliJ IDEA, Eclipse, VS Code)
   ```
2. **Execução dos Testes**:
    ```bash
    mvn test -Dcucumber.options="--tags @checkout"
    ```

4. **Relatórios**: 
      ```plaintext
      target/cucumber-reports/
      ```

## 📝 Cenários de Teste

Os arquivos `.feature` estão na pasta `/src/test/resources/features/`, cobrindo casos como:

✅ Valida o registro de um novo usuário com dados válidos  
✅ Testa a adição de um produto ao carrinho e verifica se o item é incluído corretamente  
✅ Valida o preenchimento das credenciais do SafePay durante o checkout  
✅ Testa o fluxo completo de checkout, desde a adição do produto até a confirmação do pagamento

📄 **Documentação dos cenários de teste**:  
A documentação detalhada dos cenários de teste em Gherkin está disponível na pasta:
```plaintext
src/test/resources/cenários-de-testes-em-Gherkin/
```
Além disso, o arquivo `QA_Challenge_Ecommerce_Test_Scenarios.pdf` contém a descrição completa dos cenários propostos.


## 🤖 Automação

Este projeto utiliza **Cucumber** para definir cenários de teste em linguagem natural (Gherkin) e **Selenium WebDriver** para automatizar a interação com o navegador. Abaixo estão os detalhes sobre como a automação foi implementada e como você pode configurá-la.


### ⚙️ **Configuração da Automação**

1. **ChromeDriver**:
    - O ChromeDriver é necessário para executar os testes no navegador Chrome.
    - Certifique-se de que o ChromeDriver está na pasta correta:
      ```plaintext
      src/test/resources/chromedriver-win64/chromedriver.exe
      ```
    - Verifique se a versão do ChromeDriver é compatível com a versão do seu navegador Chrome.

2. **Ambiente de Teste**:
    - O projeto utiliza **Maven** para gerenciar dependências. Certifique-se de que o `pom.xml` está configurado corretamente.
    - As dependências principais incluem:
        - Selenium WebDriver
        - Cucumber
        - JUnit

### 🌊 **Fluxo de Execução**

1. **Inicialização**:
    - O `Hooks.java` configura o WebDriver antes de cada teste e o encerra após a execução.

2. **Step Definitions**:
    - Os passos descritos nos arquivos `.feature` são mapeados para métodos em `CheckoutSteps.java` e `RegisterSteps.java`.

3. **Interação com a Página**:
    - As classes `BasePage`, `CheckoutPage` e `RegisterPage` contêm métodos para interagir com os elementos da página web.

4. **Validações**:
    - As validações são feitas utilizando assertions do JUnit para garantir que o comportamento esperado foi alcançado.



## 📑 Cenário de Checkout

Cenário descrito no arquivo `checkout.feature`:

```gherkin
Feature: Checkout Process

  Scenario Outline: Successful checkout as a registered user
    Given The user completes the registration form with "<Username>", "<Email>", "<Password>", "<First Name>", "<Last Name>", "<Phone Number>", "<Country>", "<City>", "<Address>", "<State>", and "<Postal Code>"
    And Agrees to the terms and submits the registration
    And The user adds items to the cart
    And The user proceeds to checkout
    When The user enters SafePay credentials "<safePayUsername>" and "<safePayPassword>"
    Then The checkout process should be successful

    Examples:
      | Username  | Email                | Password  | First Name | Last Name | Phone Number | Country | City   | Address         | State | Postal Code | safePayUsername | safePayPassword |
      | JohnDoe   | john.doe@example.com | #Root@123 | John       | Doe       | 1234567890   | Brazil  | Olinda | 123 Main Street | PE    | 53080000    | JohnDoe         | #Root@123       |

```

## 📁 Estrutura do Projeto

```plaintext
fcx-labs-test-automation/
├── .idea/                     # Configurações do IntelliJ IDEA
├── src/
│   ├── main/                  # Código-fonte principal
│   └── test/                  # Testes e recursos de teste
│       ├── java/
│       │   ├── page/          # Classes de páginas
│       │   │   ├── BasePage.java
│       │   │   ├── CheckoutPage.java
│       │   │   └── RegisterPage.java
│       │   ├── runners/       # Runners para execução de testes
│       │   │   └── TestRunner.java
│       │   ├── stepDefinitions/ # Step definitions para Cucumber
│       │   │   ├── CheckoutSteps.java
│       │   │   ├── Hooks.java
│       │   │   └── RegisterSteps.java
│       └── resources/         # Recursos de teste
│           ├── cenários-de-testes-em-Gherkin/ # Pasta com cenários de teste em Gherkin
│           ├── QA_Challenge_Ecommerce_Test_Scenarios.pdf # Documentação dos cenários
│           ├── chromedriver-win64/ # Pasta do ChromeDriver
│           │   ├── chromedriver.exe
│           │   ├── LICENSE.chromedriver
│           │   └── THIRD_PARTY_NOTICES.chromedriver
│           ├── features/      # Arquivos de feature do Cucumber
│           │   └── checkout.feature
│           └── testeupload.txt # Arquivo de exemplo
├── target/                    # Diretório de saída do Maven
│   └── classes/               # Classes compiladas
├── .gitignore                 # Arquivo para ignorar arquivos no Git
├── LICENSE                    # Licença do projeto
├── pom.xml                    # Configuração do Maven
└── README.md                  # Documentação do projeto
```

## 🛠️ Contribuindo

1. Faça um fork deste repositório.
2. Crie uma branch com sua feature ou correção:
   ```bash
   git checkout -b minha-feature
   ```
3. Commit suas alterações:
   ```bash
   git commit -m "Minha nova feature"
   ```
4. Faça o push para a branch:
   ```bash
   git push origin minha-feature
   ```
5. Abra um Pull Request!
---

Made with :hearts: by Letícia Paoleschi :wave: [Get in touch!](https://www.linkedin.com/in/leticiapaoleschi/)
