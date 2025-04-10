package org.example.controller.RestApi;

import lombok.AllArgsConstructor;
import org.example.dto.BookDTO;
import org.example.entity.Book;
import org.example.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController                                                                      // @RestController - Обрабатывает ВСЕ входящие HTTP запросы (например от Postman).
@AllArgsConstructor                                                                  // @AllArgsConstructor - заменяет Конструктор со всеми параметрами (библиотека lombok)
public class RestApiBookController {

    private final BookService bookService;

    @PostMapping("/api/books")                                                     // @PostMapping("/Путь") — Обрабатывает HTTP POST-запросы и возвращает ответ (Аналог INSERT INTO)
    public ResponseEntity<Book> createBook(@RequestBody BookDTO bookDTO) {            // ResponseEntity — это класс в Spring Framework, который представляет полный HTTP-ответ, включая код статуса, заголовки и тело.
        return new ResponseEntity<>(bookService.create(bookDTO), HttpStatus.OK);      // создать новую Book в БД
    }                                                                                 // HttpStatus.OK — это код HTTP, означающий, что запрос выполнен успешно (200 OK)
                                                                                      // @RequestBody - извлекает данные ВСЕГО ТЕЛА HTTP-запроса (часто в формате JSON или XML), для десериализации их в объект Java (в объект entity)

    @GetMapping("/api/books")                                                       // @GetMapping("/Путь") - Обрабатывает HTTP GET-запросы и возвращает ответ (Аналог SELECT)
    public ResponseEntity<List<Book>> findAll() {                                      // ResponseEntity — это класс в Spring Framework, который представляет полный HTTP-ответ, включая код статуса, заголовки и тело.
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);             // возвращает список всех Book из БД
    }                                                                                  // HttpStatus.OK — это код HTTP, означающий, что запрос выполнен успешно (200 OK)

    @PutMapping("/api/books/{id}")                                                   // @PutMapping ("/Путь") - Обрабатывает HTTP PUT-запросы и Обновляет существующие ресурсы (Аналог UPDATE)
    public ResponseEntity<Book> updateBook(@PathVariable(name = "id") Long id, @RequestBody Book book) {    // ResponseEntity — это класс в Spring Framework, который представляет полный HTTP-ответ, включая код статуса, заголовки и тело.
        return new ResponseEntity<>(bookService.updateBook(id, book), HttpStatus.OK);   // обновляем данные REST API Book в БД
    }                                                                                   // @PathVariable(name = "имя_переменной") - Переменная пути. Извлекает ОТДЕЛЬНЫЕ значения из переменных шаблона URI в URL-адресе запроса.
                                                                                        // @RequestBody - извлекает данные ВСЕГО ТЕЛА HTTP-запроса (часто в формате JSON или XML), для десериализации их в объект Java (в объект entity)

    @DeleteMapping("/api/books/{id}")                                      // @DeleteMapping ("/Путь") - Обрабатывает HTTP DELETE-запросы и Удаляет существующие ресурсы (Аналог DELETE)
    public HttpStatus deleteBook(@PathVariable("id") Long id) {               // @PathVariable(name = "имя_переменной") - Переменная пути. Извлекает ОТДЕЛЬНЫЕ значения из переменных шаблона URI в URL-адресе запроса.
        bookService.delete(id);                                               // удаляем Book из таблицы по id
        return HttpStatus.OK;                                                 // HttpStatus.OK — это код HTTP, означающий, что запрос выполнен успешно (200 OK)
    }
}


