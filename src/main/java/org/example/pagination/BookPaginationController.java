package org.example.pagination;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.example.entity.Book;
import org.example.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController                                        // @RestController - Обрабатывает ВСЕ входящие HTTP запросы (например от Postman).
@RequiredArgsConstructor                               // @RequiredArgsConstructor — ГЕНЕРИРУЕТ конструктор для класса с полями final. НЕ ГЕНЕРИРУЕТ конструктор ДЛЯ НЕ ФИНАЛЬНЫХ полей.
public class BookPaginationController {

    private final BookRepository bookRepository;

    // Возврат постраничных данных   (http://localhost:8080/api/book?page=1&size=10)
    @GetMapping ("/api/book")                                            // @GetMapping("/Путь") - Обрабатывает HTTP GET-запросы и возвращает ответ (Аналог SELECT)
    public Page<Book> getBooks(                                          // @RequestParam(name = "name") - извлекает ОТДЕЛЬНЫЕ параметры из HTTP-запроса БЕЗ обработки всего тела запроса.
        @RequestParam(defaultValue = "0") @Min(0) int page,              // номер страницы (page)
        @RequestParam(defaultValue = "10") @Min(1) @Max(10) int size) {  // количество элементов на странице (size)
                                                                         // @Min(value = , message = "") — указывает минимальное значение для числового поля и сообщение для отображения при ошибке проверки.
        Pageable pageable = PageRequest.of(page, size);                  // @Max(value = , message = "") — указывает максимальное значение для числового поля и сообщение для отображения при ошибке проверки.
        return bookRepository.findAll(pageable);                         // PageRequest - создает объект пагинации Pageable
    }


    // Обработка ошибок  (http://localhost:8080/api/book?page=1&size=10)
//    @GetMapping("/api/book")
//    public ResponseEntity<?> getBooks(                                     // ResponseEntity — это класс в Spring Framework, который представляет полный HTTP-ответ, включая код статуса, заголовки и тело.
//            @RequestParam(defaultValue = "0") int page,                    // @RequestParam(name = "name") - извлекает ОТДЕЛЬНЫЕ параметры из HTTP-запроса БЕЗ обработки всего тела запроса.
//            @RequestParam(defaultValue = "10") int size) {                 // @RequestParam(name = "name") - извлекает ОТДЕЛЬНЫЕ параметры из HTTP-запроса БЕЗ обработки всего тела запроса.
//
//        if (page < 0) {                                                                            // ResponseEntity — это класс в Spring Framework, который представляет полный HTTP-ответ, включая код статуса, заголовки и тело.
//            return ResponseEntity.badRequest().body("Номер страницы не может быть отрицательным"); // badRequest().body - возвращает тело ответа с кодом состояния 400 «Плохой запрос» (Bad Request)
//        }
//        Pageable pageable = PageRequest.of(page, size);                     // Pageable - Параметры для постраничного вывода.
//        Page<Book> bookPage = bookRepository.findAll(pageable);             // PageRequest — указывает какую страницу извлекать и сколько записей включать в эту страницу
//
//        if (bookPage.isEmpty()) {
//            return ResponseEntity.notFound().build();                       // ResponseEntity.notFound().build() - возвращает объект ResponseEntity с кодом состояния 404 Not Found (не найдено).
//        }
//        return ResponseEntity.ok(bookPage);                                 // ResponseEntity.ok - означает, что запрос был успешным и сервер возвращает 200 Ок
//    }


    // Сортировка             (http://localhost:8080/api/book?title)
//    @GetMapping( "/api/book" )                                                      // @GetMapping("/Путь") - Обрабатывает HTTP GET-запросы и возвращает ответ (Аналог SELECT)
//    public List<Book> getBooks(
//            @SortDefault(sort = "title", direction = Sort.Direction.ASC) Sort sort) {  // @SortDefault - определяет поведение сортировки по умолчанию для методов репозитория
//        return bookRepository.findAll(sort);                                           // Sort.by(Sort.Direction.ASC, "title") - устанавливает сортировку в порядке возрастания по полю "title"
//    }
}
