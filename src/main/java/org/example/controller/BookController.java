package org.example.controller;

import org.example.dto.BookDTO;
import org.example.entity.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller                                                // @Controller - определяет классы в качестве контроллеров в Spring MVC. Помогает Spring определить компоненты, которые будут обрабатывать входящие запросы.
public class BookController {

    private final BookService bookService;

    @Autowired                                             // @Autowired — используется для автоматического внедрения зависимостей (dependency injection)
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/showBooks")                           // @GetMapping("/Путь") - Обрабатывает HTTP GET-запросы и возвращает ответ (Аналог SELECT)
    public String findAll(Model model) {                   // Model - интерфейс из фреймворка Spring MVC для добавления атрибутов к модели <KEY, VALUE>. Похож на Map<K, V>
        List<Book> bookList = bookService.findAll();       // возвращает список всех Book из БД
        model.addAttribute("books", bookList); // model.addAttribute(KEY, VALUE) - добавляет атрибут к модели
        return "book-list";
    }

    @GetMapping("/addBookPage")                         // @GetMapping("/Путь") - Обрабатывает HTTP GET-запросы и возвращает ответ (Аналог SELECT)
    public String addBook(Model model) {                   // Model - интерфейс из фреймворка Spring MVC для добавления атрибутов к модели <KEY, VALUE>. Похож на Map<K, V>
        BookDTO bookDTO = new BookDTO();
        model.addAttribute("book", bookDTO);   // model.addAttribute(KEY, VALUE) - добавляет атрибут к модели
        return "add-book";
    }

    @PostMapping("/save-book")                     // @PostMapping("/Путь") — Обрабатывает HTTP POST-запросы и возвращает ответ (Аналог INSERT INTO)
    public String createBook(BookDTO bookDTO) {
        bookService.create(bookDTO);                  // создать новую Book в БД
        return "redirect:/showBooks";                 // redirect:/Путь - переадресация на указанную страницу
    }

    @GetMapping("/book-delete/{id}")               // @GetMapping("/Путь") - Обрабатывает HTTP GET-запросы и возвращает ответ (Аналог SELECT)
    public String deleteBook(@PathVariable(name = "id") Long id) {    // @PathVariable(name = "имя_переменной") - Переменная пути - извлекает ОТДЕЛЬНЫЕ значения из переменных шаблона URI в URL-адресе запроса.
        bookService.delete(id);                       // удаляем Book из таблицы по id
        return "redirect:/showBooks";                 // redirect:/Путь - переадресация на указанную страницу
    }

    @GetMapping("/book-update/{id}")                // @GetMapping("/Путь") - Обрабатывает HTTP GET-запросы и возвращает ответ (Аналог SELECT)
    public String updateBookForm(@PathVariable(name = "id") Long id, Model model) {    // @PathVariable(name = "имя_переменной") - Переменная пути - извлекает ОТДЕЛЬНЫЕ значения из переменных шаблона URI в URL-адресе запроса.
        Book book = bookService.findById(id);          // Model - интерфейс из фреймворка Spring MVC для добавления атрибутов к модели <KEY, VALUE>. Похож на Map<K, V>
        model.addAttribute("book", book);  // model.addAttribute(KEY, VALUE) - добавляет атрибут к модели
        return "/book-update";
    }

    @PostMapping("/book-update")                      // @PostMapping("/Путь") — Обрабатывает HTTP POST-запросы и возвращает ответ (Аналог INSERT INTO)
    public String updateBook(Book book) {
        bookService.update(book);                        // обновляем данные Book в БД
        return "redirect:/showBooks";                    // redirect:/Путь - переадресация на указанную страницу
    }


    // Фильтры поиска:
    @GetMapping("/book/search/title")                                                       // Model - интерфейс из фреймворка Spring MVC для добавления атрибутов к модели <KEY, VALUE>. Похож на Map<K, V>
    public String searchBooksTitle(@RequestParam(name = "query") String query, Model model) {  // @RequestParam(name = "query") - извлекает ОТДЕЛЬНЫЕ параметры из HTTP-запроса БЕЗ обработки всего тела запроса.
        List<Book> books = bookService.searchBooksTitle(query);   // собственный фильтр LIKE '%title%'
        model.addAttribute("books", books);           // model.addAttribute(KEY, VALUE) - добавляет атрибут к модели
        return "book-list-filter";
    }
    @GetMapping("/book/search/brand")                                                       // Model - интерфейс из фреймворка Spring MVC для добавления атрибутов к модели <KEY, VALUE>. Похож на Map<K, V>
    public String searchBooksBrand(@RequestParam(name = "query") String query, Model model) {  // @RequestParam(name = "query") - извлекает ОТДЕЛЬНЫЕ параметры из HTTP-запроса БЕЗ обработки всего тела запроса.
        List<Book> books = bookService.searchBooksBrand(query);    // собственный фильтр LIKE '%title%'
        model.addAttribute("books", books);            // model.addAttribute(KEY, VALUE) - добавляет атрибут к модели
        return "book-list-filter";
    }

    @GetMapping("/book/search/year")                                                       // Model - интерфейс из фреймворка Spring MVC для добавления атрибутов к модели <KEY, VALUE>. Похож на Map<K, V>
    public String searchBooksYear(@RequestParam(name = "query") String query, Model model) {  // @RequestParam(name = "query") - извлекает ОТДЕЛЬНЫЕ параметры из HTTP-запроса БЕЗ обработки всего тела запроса.
        List<Book> books = bookService.searchBooksYear(query);     // собственный фильтр LIKE '%title%'
        model.addAttribute("books", books);            // model.addAttribute(KEY, VALUE) - добавляет атрибут к модели
        return "book-list-filter";
    }
}
