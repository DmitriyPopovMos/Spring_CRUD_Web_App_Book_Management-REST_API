package org.example.filter;

import org.example.dto.RequestDto;
import org.example.entity.Book;
import org.example.repository.BookRepository;
import org.example.service.FiltersSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController                                              // @RestController - Обрабатывает ВСЕ входящие HTTP запросы (например от Postman).
@RequestMapping("/filter")                                // @RequestMapping("/filter) - сопоставляет конкретный метод HTTP-запроса определённому методу Java в веб-приложении.
public class RestApiBookFilter {

    @Autowired                                                // @Autowired — аннотация отмечает конструктор, поле, метод установки или метод конфигурации для автоматического связывания с помощью средств внедрения зависимостей Spring (dependency injection)
    private BookRepository bookRepository;

    @Autowired                                                // @Autowired — аннотация отмечает конструктор, поле, метод установки или метод конфигурации для автоматического связывания с помощью средств внедрения зависимостей Spring (dependency injection)
    private FiltersSpecification<Book> bookFiltersSpecification;


    @PostMapping("/book/Specification")                                          // @PostMapping("/Путь") — Обрабатывает HTTP POST-запросы и возвращает ответ (Аналог INSERT INTO)
    public List<Book> getProductBook(@RequestBody RequestDto requestDto) {          // @RequestBody - извлекает данные ВСЕГО ТЕЛА HTTP-запроса (часто в формате JSON или XML), для десериализации их в объект Java (в объект entity)
        Specification<Book> searchSpecification = bookFiltersSpecification
                .getSearchSpecification(requestDto.getSearchRequestDto(), requestDto.getGlobalOperator());

        System.out.println(bookRepository.findAll(searchSpecification));

        return bookRepository.findAll(searchSpecification);
    }
}
