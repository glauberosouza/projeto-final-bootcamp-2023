# Api para Cadastro de Clientes

## Pré-requisitos Para Rodar o Projeto:
> - Maven
> - Java Versão 17

## Opcionais:
> - IntelliJ IDEA
> - Postman

> Para cadastrar um cliente envie um POST para: localhost:8080/customers

> Exemplo do body:
> ~~~json
> {
>    "name": "Customer",
>    "email": "customer@gmail.com",
>    "address": [
>        {
>            "street": "Rua customer",
>            "cep": "1234567"
>        }
>    ]
>}
> ~~~

>Para listar todos os clientes envie um GET para: localhost:8080/customers

>Para atualizar um cliente envie um PUT para:localhost:8080/customers/{id}

> Exemplo do body:
> ~~~json
> {
>    "name": "Customer",
>    "email": "customer@gmail.com",
>    "address": [
>        {
>            "street": "Rua customer",
>            "cep": "1234567"
>        }
>    ]
>}
> ~~~

>Para deletar um cliente envie um DELETE para: localhost:8080/customers/{id}

> Para acessar o H2 use o link: localhost:8080/h2-console/
> 
>Não é necessário senha para acessar o console do H2



