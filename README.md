# softbrainTest

## Technologies applied for the Books project
1. Spring boot version 2.4.4
2. Mysql
3. Spring data jpa
4. Gradle to manage dependency and build project

## Structure of the book project
```
\---src
+---main
|   +---java
|   |   \---org
|   |       \---softbrain
|   |           \---books
|   |               |   BooksApplication.java
|   |               |
|   |               +---apis
|   |               |   |   AuthorApi.java
|   |               |   |   BookApi.java
|   |               |   |
|   |               |   \---impl
|   |               |           AuthorApiImpl.java
|   |               |           BookApiImpl.java
|   |               |
|   |               +---converter
|   |               |       AuthorConverter.java
|   |               |       BookConverter.java
|   |               |
|   |               +---dtos
|   |               |       AppResponse.java
|   |               |       AuthorDto.java
|   |               |       BookDto.java
|   |               |
|   |               +---enums
|   |               |       AppMessageEnum.java
|   |               |       LogicMessageEnum.java
|   |               |
|   |               +---models
|   |               |       Author.java
|   |               |       Book.java
|   |               |
|   |               +---repositories
|   |               |       AuthorRepository.java
|   |               |       BookRepository.java
|   |               |
|   |               \---services
|   |                   |   AuthorService.java
|   |                   |   BookService.java
|   |                   |
|   |                   \---impl
|   |                           AuthorServiceImpl.java
|   |                           BookServiceImpl.java
|   |
|   \---resources
|           application.properties
|           application.yml
|
\---test
\---java
\---org
\---softbrain
\---books
BooksApplicationTests.java
```

## Build and prepare environment
- Mysql is required
- Step 1: gradlew clean build
- Step 2: Accept to /build/lib and run java -jar books-0.0.1-SNAPSHOT.jar

# API LIST EXPOSE
1. Book
- GET /api/v1/books: Get all books applied paginate
- GET /api/v1/book/{bookId}: Get book by ID
- POST /api/v1/book: add new book
- PUT /api/v1/book: update book
- DELETE /api/v1/book : Delete logical book
2. Author
- GET /api/v1/authors: Get all books applied paginate
- GET /api/v1/author/{authorId}: Get book by ID
- POST /api/v1/author: add new book
- PUT /api/v1/author: update book
- DELETE /api/v1/author : Delete logical book
