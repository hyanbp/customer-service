# customer-service

Microsserviço de criação de usuario.

## Técnologias ultilizadas

- Java 8+
- Spring - Framework WebFlux
- Springboot
- MongoDB (Usando um DaaS (Cloud.mongodb))
- Hospedado no Heroku.

### Sobre

customer-service é um serviço de backend para atender a criação cliente, busca e edição

https://customer-servicee.herokuapp.com/swagger-ui.html#/

#### Como usar o serviço

Para cadastrar o cliente basta preencher os campos {name,email,age}. PS: Lembrando que o campo email é um campo unico, logo não podemos ter o mesmo email cadastrado duas vezes.

[Cadastrar um cliente](https://customer-servicee.herokuapp.com/swagger-ui.html#/customer-api/createUsingPOST)

Com o cadastro realizado com sucesso. Você pode realizar a busca pelo cliente, informando apenas o email inserido.

[Buscar um cliente](https://customer-servicee.herokuapp.com/swagger-ui.html#/customer-api/findOneUsingGET)


Com o **email** cadastrado em mãos você também pode editar seu cliente.

[Editar cliente](https://customer-servicee.herokuapp.com/swagger-ui.html#/customer-api/updateAllUsingPUT)


```
