# DESIGN PATTERN CHAINOFRESPONSIBILITY
***
## PROBLEMA:
A aplicação pode tentar autenticar um usuário ao sistema sempre que receber um pedido que contêm as credencias do usuário.
Contudo, se essas credenciais não estão corretas e a autenticação falha, não há razão para continuar com outras checagens.

## SOLUÇÃO:
Como muitos outros padrões de projeto comportamental

Chain of Responsibility se baseia na ideia de transformar comportamentos em objetos independentes denominados handlers.

Assim as verificações são extraídas para sua própia classe com um unico método que faz a checagem. O pedido, junto com seus dados, é passado para esse metodo como um argumento.

O padrão sugere que os handlers sejam ligados como em uma corrente.

Cada handler ligado tem um campo para armazenar uma referência ao proximo handler da corrente. Além dde processar o pedido, os handlers também o passam adiante na corrente.

O pedido viaja através da corrente até que todos os handlers tiveram uma chance de processá-lo.

E aqiu está a melhor parte: **um handler pode decidir não passar o pedido adiante na corrente e efetivamente interromper um proximo processamento**
