## 💱 Conversor de Moedas via Console

Este é um projeto Java de console que permite converter valores entre diferentes moedas ou mesmo filtrar um moeda, com dados em tempo real utilizando a **[ExchangeRate-API](https://www.exchangerate-api.com/)**.  
- O usuário pode escolher a operação desejada, inserir o valor a ser convertido e visualizar o resultado.
- Também é possível salvar as conversões em arquivos `.json` e visualizar o histórico de arquivos.

---
### 📌 Funcionalidades

- ✅ Conversão entre moedas (USD, BRL, EUR, ARS)
- ✅ Exibição de menu interativo via console
- ✅ Requisições em tempo real para a ExchangeRate-API
- ✅ Geração de arquivos JSON com os resultados das conversões
- ✅ Filtro de moedas baseado no código da moeda
- ✅ Histórico de conversões

---
### 🧱 Estrutura de Pacotes

```bash
src/
├── application/               # Classe principal (start da aplicação)
│   └── Main.java
├── controller/                # Lógica de controle
│   └── CurrencyController.java
├── model/                     # Modelos de dados
│   └── CurrencyResponse.java
├── service/                   # Requisições à API, manipulação de arquivos e histórico
│   ├── ConversionHistory.java
│   ├── Converter.java
│   ├── GeneratorFilterJson.java
│   └── GeneratorJson.java
├── view/                      # Interface via console
│   ├── Menu.java
│   └── MenuCoin.java
```
---
### ▶️ Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/Danimmota/Conversor-moedas.git
cd conversor-moedas-java
```
2. Abra sua IDE favorita (utilizei o IntelliJ)

3. Compile o projeto:
```bash
javac src/**/*.java
```
4. Execute o programa:
```bash
java src/main/App
```
---
### 🔧 Dependências

- Java 17 ou superior
- Gson (para serialização JSON)
- ExchangeRate-API (para buscar dados de câmbio)

---
### 📦 Como obter a ExchangeRate-API Key

Acesse: https://www.exchangerate-api.com/

Faça um cadastro gratuito

Copie sua API key

Atualize a variável apiKey no arquivo Converter.java com sua chave:
```java
String apiKey = "SUA_API_KEY";
```

---
### 📄 Exemplo de JSON Gerado na conversão de moedas
```json
{
  "result": "success",
  "base_code": "USD",
  "target_code": "BRL",
  "conversion_result": 5.12
}
```
---
### 📄 Exemplo de JSON Gerado no filtro de moedas
```json
{
  "result": "success",
  "time_last_update_utc": "Wed, 14 May 2025 00:00:02 +0000",
  "base_code": "BRL",
  "conversion_rate": 0.0,
  "conversion_rates": {
    "BRL": 1.0,
    "AED": 0.6483,
    "AFN": 12.3501,
    "ALL": 15.6028,
    "AMD": 68.4363,
    "ANG": 0.316,
    "AOA": 165.2172,
    ...
  },
    "conversion_result": 0.0
}
```
---
### 🧪 Possíveis Melhorias

- Suporte a mais moedas e personalização de favoritos

- Integração com banco de dados para histórico persistente

---
### 🧑‍💻 Autor
Desenvolvido por Daniela Medeiro Mota em realização do Challenge: conversor de moedas do curso ONE - Oracle Next Education

📧 Email: danielamedeiromota@hotmail.com

[🔗 LinkedIn](https://www.linkedin.com/in/danielammota/)