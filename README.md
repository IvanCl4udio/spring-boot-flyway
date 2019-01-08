# spring-boot-flyway

Exemplo do uso do Flyway em conjunto com o Spring-Data JPA para aplicar as alterações no banco de Dados.

## Dependencias utilizadas ##

- Spring-Data-JPA - Controla e gerencia as rotinas com o banco de dados.

- Flyway-Core - Aplica as alterações diretamente no banco de dados caso existam.

- MySQL Connector - Biblioteca JDBC para conexão com o banco de dados MySQL.

- Jasypt - Encriptografa a senha do banco de dados para diminuir a exposição.

## Uso ##

```bash
mvn spring-boot:run -D"jasypt.encryptor.password"=password
```

Para definir a senha do usuário que será utilizada no comando acima você tem duas opções: baixar do site Jasypt o pacote para uso com comando de linha ou, utilizar a dependencia baixada pelo maven existente no diretório .m2 do usuário.

### Jasypt via comando de linha ###

- Acesse o site do [Jasypt](http://www.jasypt.org/) e então baixe o pacote de [comando de linha](http://sourceforge.net/project/showfiles.php?group_id=183612).

- Descompate o conteudo do arquivo em um diretório.

- Abra um prompt de comandos vá para o diretório onde o arquivo foi descompactado e em seguida acesse o subdiretório ```bin```.

- Execute o comando abaixo para encriptar o texto: ```abcdef``` , utilizando como senha de encryptação ```123456```.

```bash
encrypt.bat input="abcdef" password="123456"
```

- Após a execução localize a saida ```OUTPUT```. Será essa informação que deve ser inserida na propriedade ```spring.datasource.password``` do ```application.properties```. Esse conteúdo deve ser inserido no lugar do texto entre ```ENC()```.

### Jasypt via dependência do Maven ###

- Abra um prompt de comandos e execute o comando abaixo:

```bash
java -cp ~/.m2/repository/org/jasypt/jasypt/1.9.2/jasypt-1.9.2.jar  org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="abcdef" password=123456 algorithm=PBEWithMD5AndDES
```

## Flyway ##

Os scripts que serão executados pelo ```flyway``` devem ser colocados no seguinte diretório:

```bash
src/main/resources/db/migration
```
