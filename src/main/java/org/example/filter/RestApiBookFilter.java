package org.example.filter;

import lombok.AllArgsConstructor;
import org.example.dto.RequestDto;
import org.example.entity.Book;
import org.example.repository.BookRepository;
import org.example.service.FiltersSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController                                              // @RestController - Обрабатывает ВСЕ входящие HTTP запросы (например от Postman).
@AllArgsConstructor                                          // @AllArgsConstructor - заменяет Конструктор со всеми параметрами (библиотека lombok)
@RequestMapping("/filter")                                 // @RequestMapping("/filter) - сопоставляет конкретный метод HTTP-запроса определённому методу Java в веб-приложении.
public class RestApiBookFilter {

    private BookRepository bookRepository;
    private FiltersSpecification<Book> bookFiltersSpecification;


    @PostMapping("/book/Specification")                                          // @PostMapping("/Путь") — Обрабатывает HTTP POST-запросы и возвращает ответ (Аналог INSERT INTO)
    public List<Book> getProductBook(@RequestBody RequestDto requestDto) {          // @RequestBody - извлекает данные ВСЕГО ТЕЛА HTTP-запроса (часто в формате JSON или XML), для десериализации их в объект Java (в объект entity)
        Specification<Book> searchSpecification = bookFiltersSpecification
                .getSearchSpecification(requestDto.getSearchRequestDto(), requestDto.getGlobalOperator());

        return bookRepository.findAll(searchSpecification);
    }
}
