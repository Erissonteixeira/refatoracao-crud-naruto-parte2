
## 🚀 Evolução para Spring Boot

O projeto foi evoluído para uma aplicação profissional utilizando **Spring Boot**, aplicando conceitos reais do mercado.

---

## 🧩 Tecnologias Utilizadas

- ☕ Java  
- 🌱 Spring Boot  
- 🧬 Spring Data JPA  
- 🧠 Lombok  
- 🧾 DTO (Request / Response)  
- 📖 Swagger / OpenAPI  
- 🧪 MockMvc e Mockito  
- 🗄️ Banco de Dados (H2 / SQL)  
- 🛠️ Flyway (Versionamento de banco)  

---
## 🔧 Utilização

- Cada personagem possui um `Map<String, Jutsu>`
- A chave é o nome do jutsu
- O valor é a instância da classe `Jutsu`
- O consumo de chakra e o dano são definidos pelo próprio jutsu

---

## ⚔️ Regras de Combate

- Cada ataque consome chakra conforme o jutsu utilizado
- O dano só é aplicado se o ataque não for desviado
- O desvio pode:
  - Evitar completamente o dano
  - Ou receber o dano total do jutsu

> As regras são flexíveis para estimular criatividade e aprendizado.

---

## 📂 Organização do Projeto

A estrutura do projeto foi refatorada para seguir **boas práticas de arquitetura Spring Boot**, garantindo separação clara de responsabilidades e maior legibilidade do código.

### 📁 Estrutura de Pacotes

```text
config/
 └── OpenApiConfig

controller/
 └── NinjaController

service/
 └── NinjaService

repository/
 └── NinjaRepository

domain/
 ├── entity
 │   ├── NinjaEntity
 │   └── JutsuEntity
 │
 ├── behavior
 │   ├── NinjaDeTaijutsu
 │   ├── NinjaDeNinjutsu
 │   └── NinjaDeGenjutsu
 │
 ├── contract
 │   └── Ninja
 │
 ├── dto
 │   ├── NinjaRequestDto
 │   └── NinjaResponseDto
 │
 └── 
```
## 🧪 Testes

- Testes unitários de Controller
- Testes unitários de Entity
- Testes unitários de Service
- Serviços mockados
- Validação de status HTTP

### Objetivos

- Garantir qualidade
- Facilitar manutenção
- Aumentar confiabilidade

---

## 📘 Documentação da API

A documentação da API pode ser acessada via Swagger após subir a aplicação:

```text
/swagger-ui.html
ou
/swagger-ui/index.html
```
## 🏁 Conclusão

Este projeto representa a evolução prática no aprendizado de **Java** e **Programação Orientada a Objetos**, indo além de um exercício simples e aplicando padrões profissionais utilizados no mercado.

Tudo isso utilizando um tema motivador e conhecido: **Naruto** 🌀

---

## ✍️ Autor

**Erisson Teixeira**  
Desenvolvedor Java  
Foco em POO, Spring Boot e boas práticas



