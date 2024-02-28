# Upload de arquivos - Spring Boot

## Explicação do projeto

Consiste em uma aplicação simples, que salva um usuário (com nome, e-mail e foto de perfil) no banco.  
Para isso, foram usadas duas entidades principais:

- Usuário (User);
- Foto de perfil (ProfilePicture).

## Formato de um arquivo [MultipartFile](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/multipart/MultipartFile.html)

Contém:

- Nome do arquivo (fineName);
- Tipo do arquivo (contentType);
- Conteúdo do arquivo (bytes);

Além dos atributos citados acima, contem alguns outros. Porém, nesta aplicação só iremos nos preocupar com esses (nome, tipo e conteúdo).  
Por questões de segurança, não foi salvo o nome original do arquivo no banco e sim um nome genérico gerado pelo UUID (`picture.setFileName(randomUUID().toString());`).

## Entidades

- Usar @Lob e byte[] para o base64 (conteúdo do arquivo - _bytes_);

## Services

- Devem receber um arquivo do tipo MultipartFile.

## Controllers

- Devem receber `@RequestPart MultipartFile` como parâmetro no método que declara a requisição;
- Usar `@PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})` na declaração do verbo da requisição;

## Estrutura do projeto

```

📦src
┣ 📂main
┃ ┣ 📂java
┃ ┃ ┗ 📂dev
┃ ┃ ┃ ┗ 📂mayra
┃ ┃ ┃ ┃ ┗ 📂file
┃ ┃ ┃ ┃ ┃ ┣ 📂config
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜OpenApiConfig.java
┃ ┃ ┃ ┃ ┃ ┣ 📂controllers
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserController.java
┃ ┃ ┃ ┃ ┃ ┣ 📂dtos
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ProfilePictureDTO.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserDTO.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserResponseDTO.java
┃ ┃ ┃ ┃ ┃ ┣ 📂entities
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ProfilePicture.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜User.java
┃ ┃ ┃ ┃ ┃ ┣ 📂repositories
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserRepository.java
┃ ┃ ┃ ┃ ┃ ┣ 📂services
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserService.java
┃ ┃ ┃ ┃ ┃ ┗ 📜FileApplication.java
┃ ┗ 📂resources
┃ ┃ ┣ 📂db
┃ ┃ ┃ ┗ 📂migration
┃ ┃ ┃ ┃ ┣ 📜V1**create_tables_user_and_profile_picture.sql
┃ ┃ ┃ ┃ ┣ 📜V2**alter_table_profile_picture_insert_file_name_field.sql
┃ ┃ ┃ ┃ ┗ 📜V3\_\_alter_table_user_insert_id_profile_picture_field.sql
┃ ┃ ┣ 📂static
┃ ┃ ┣ 📂templates
┃ ┃ ┗ 📜application.properties

```

## Referências

- [Springboot File Handling- File Upload (Part -1)](https://medium.com/@samarthgvasist/springboot-file-handling-file-upload-part-1-e2fd7a9364b8);
- [Spring Boot REST API File Upload With JSON Data In Single API Call + @ModelAttribute In Spring Rest API](https://www.springjavatutorial.com/2021/09/spring-boot-rest-api-file-upload-with-json-data.html);
- [How to Create a Spring Boot REST API for Multipart File Uploads: A Comprehensive Guide](https://medium.com/@patelsajal2/how-to-create-a-spring-boot-rest-api-for-multipart-file-uploads-a-comprehensive-guide-b4d95ce3022b);
- [Uploading JSON Data and a File to a Spring RESTful Service](https://copyprogramming.com/howto/posting-a-file-and-json-data-to-spring-rest-service).
