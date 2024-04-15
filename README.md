
# Administrador de usuários

## Integrantes
- Luiza Nunes de Jesus - Banco de dados
- Melissa de Oliveira Pecoraro - IA
- Pamella Schimalesky Engholm - Dotnet e QA
- Pedro Marques Pais Pavão  - Devops
- Roberto Menezes dos Santos - Java e mobile


## Getting Started

Primeiro faça o download do projeto:
```
git clone https://github.com/RobertSDM/adm-usuarios
```

Após o download abra a pasta no seu IDE preferido, eu obtarei por usar o *IntelliJ*

Espere todas as dependencias serem baixadas. \
Com todas as depêndencias baixadas, adicione os dados para se conectar ao banco de dados MySQL no caminho:
```
/src/main/resources/application.properties
```

Quando depois executar aplicação pela primeira vez, você poderá comentar o comando
`spring.jpa.hibernate.ddl-auto=create` no application.properties

Agora com todas as configurações necessarias feitas, basta rodar o projeto.

## Diagramas

Diagrama de entidades
![](./images/Diagrama_de_classes.jpeg)

Diagrama de relacionamento
![](./images/Diagrama_relacional.svg)


## Video descrevendo projeto
[Video de apresentação do projeto](https://youtu.be/ntipsKUMlzE)

# Documentação API

### Pricipais rotas
1. [Empresa](#empresa)
2. [Usuario](#usuario)
3. [Logradouro](#logradouro)
4. [Cidade](#cidade)
5. [Estado](#estado)

## <a id="empresa"></a>Empresa

`GET`

#### /find/all
| Código | Descrição                             |
|--------|---------------------------------------|
| 200    | Retorna todas as empresas registradas |
| 204    | Caso a lista de empresas esteja vazia |

#### /find/{id}
| Código | Descrição                                           |
|--------|-----------------------------------------------------|
| 200    | Retorna a empresa com o id enviado                  |
| 404    | Caso a empresa com o id enviado não seja encontrada |

`POST`

#### /create
| Código | Descrição                          |
|--------|------------------------------------|
| 201    | Retorna a empresa com o id enviado |

`PUT`

#### /update/{id}
| Código | Descrição                                           |
|--------|-----------------------------------------------------|
| 200    | Retorna um json com a empresa atualizada            |
| 404    | Caso a empresa com o id enviado não seja encontrada |

`DELETE`

#### /delete/{id}
| Código | Descrição                                                        |
|--------|------------------------------------------------------------------|
| 204    | Caso a empresa seja deletada com sucesso                         |
| 404    | Caso a empresa com o id enviado não seja encontrada              | 

## <a id="usuario"></a>Usuario

`GET`

#### /find/all
| Código | Descrição                             |
|--------|---------------------------------------|
| 200    | Retorna todos os usuarios registradas |
| 204    | Caso a lista de usuarios esteja vazia |

#### /find/{id}
| Código | Descrição                                           |
|--------|-----------------------------------------------------|
| 200    | Retorna o usuario com o id enviado                  |
| 404    | Caso o usuario com o id enviado não seja encontrado |

`PUT`

#### /update/{id}
| Código | Descrição                                           |
|--------|-----------------------------------------------------|
| 200    | Retorna um json com o usuario atualizado            |
| 404    | Caso o usuario com o id enviado não seja encontrado |

## <a id="logradouro"></a>Logradouro

`GET`

#### /find/all
| Código | Descrição                                |
|--------|------------------------------------------|
| 200    | Retorna todos os logradouros registradas |
| 204    | Caso a lista de logradouros esteja vazia |

#### /find/{id}
| Código | Descrição                                              |
|--------|--------------------------------------------------------|
| 200    | Retorna o logradouro com o id enviado                  |
| 404    | Caso o logradouro com o id enviado não seja encontrado |

`PUT`

#### /update/{id}
| Código | Descrição                                              |
|--------|--------------------------------------------------------|
| 200    | Retorna um json com o logradouro atualizado            |
| 404    | Caso o logradouro com o id enviado não seja encontrado |

## <a id="cidade"></a>Cidade

`GET`

#### /find/all
| Código | Descrição                            |
|--------|--------------------------------------|
| 200    | Retorna todas as cidades registradas |
| 204    | Caso a lista de cidades esteja vazia |


#### /find/{id}
| Código | Descrição                                          |
|--------|----------------------------------------------------|
| 200    | Retorna a cidade com o id enviado                  |
| 404    | Caso a cidade com o id enviado não seja encontrada |

`PUT`

#### /update/{id}
| Código | Descrição                                          |
|--------|----------------------------------------------------|
| 200    | Retorna um json com a cidade atualizada            |
| 404    | Caso a cidade com o id enviado não seja encontrada |

## <a id="estado"></a>Estado

`GET`

#### /find/all
| Código | Descrição                            |
|--------|--------------------------------------|
| 200    | Retorna todos os estados registradas |
| 204    | Caso a lista de estados esteja vazia |

#### /find/{id}
| Código | Descrição                                          |
|--------|----------------------------------------------------|
| 200    | Retorna o estado com o id enviado                  |
| 404    | Caso o estado com o id enviado não seja encontrado |

`PUT`

#### /update/{id}
| Código | Descrição                                          |
|--------|----------------------------------------------------|
| 200    | Retorna um json com o estado atualizado            |
| 404    | Caso o estado com o id enviado não seja encontrado |

