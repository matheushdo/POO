# Exercício: Hello Git
Neste exercício o foco principal é introduzir os conceitos principais de git e como funciona os exercícios no github classroom.

## 🎯 Objetivo
Na classe App.java você deve alterar o código para que apareça a mensagem "Hello Git!" no terminal. Siga o guia abaixo para aprender a configurar o git para usar o github e entregar a atividade


## 🚀 Guia Rápido de Git para Estudantes

### 1. Configurações Iniciais

Antes de começar, o Git precisa saber quem você é para registrar a autoria dos seus commits. Substitua os textos entre aspas pelos seus dados:

```bash
git config --global user.name "Seu Nome Completo"
git config --global user.email "seu-email@exemplo.com"

```

> **Dica:** Use o mesmo e-mail que você utiliza na sua conta do GitHub.

---

### 2. Clonando um Repositório

Para baixar um projeto existente do GitHub para o seu computador, utilize o comando `clone` seguido da URL do repositório:

```bash
git clone https://github.com/usuario/nome-do-repositorio.git

```

Após clonar, entre na pasta do projeto:

```bash
cd nome-do-repositorio

```

---

### 3. Fluxo de Trabalho (O Ciclo do Commit)

O fluxo básico consiste em três estados principais: o diretório de trabalho, a área de preparação (staging) e o histórico (repositório).

#### Passo A: Adicionar alterações

Após criar ou editar seus arquivos (ex: um código em Java ou um README), você precisa avisar ao Git quais arquivos devem ser incluídos na próxima "foto" do projeto:

```bash
# Para adicionar um arquivo específico:
git add NomeDoArquivo.java

# Para adicionar todos os arquivos alterados de uma vez:
git add .

```

#### Passo B: Criar um Commit

O commit salva suas alterações localmente com uma mensagem explicativa. Seja claro e breve na mensagem:

```bash
git commit -m "Explicação curta do que foi feito"

```

---

### 4. Enviando para o GitHub

Para que o professor e seus colegas consigam ver seu código, você deve "empurrar" as alterações do seu computador para o servidor remoto:

```bash
git push origin main

```
---

### 🛠️ Comandos de Verificação (Úteis para o dia a dia)

* **Verificar o status:** Veja quais arquivos foram modificados ou estão na área de staging.
```bash
git status

```