package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.BookDTO;
import org.example.entity.Book;
import org.example.repository.BookRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;


@Service                                                 // @Service - указывает, что класс реализует бизнес-логику, относящуюся к определённому домену приложения.
@RequiredArgsConstructor                                 // @RequiredArgsConstructor — ГЕНЕРИРУЕТ конструктор для класса с полями final. НЕ ГЕНЕРИРУЕТ конструктор ДЛЯ НЕ ФИНАЛЬНЫХ полей.
public class BookService {

    private final BookRepository bookRepository;

    public Book create(BookDTO dto) {                    // создать новую Book в БД
        Book book = Book.builder()
                .vendorCode(dto.getVendorCode())
                .title(dto.getTitle())
                .year(dto.getYear())
                .brand(dto.getBrand())
                .stock(dto.getStock())
                .price(dto.getPrice())
                .build();
        return bookRepository.save(book);
    }

    public List<Book>findAll() {                                                     // возвращает список всех Book из БД
        return bookRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));  // Sort.by(Sort.Direction.ASC, "id") - устанавливает сортировку в порядке возрастания по полю "id"
    }

    public Book findById(Long id) {                      // поиск Book по id
        return bookRepository.getById(id);
    }

    public Book update(Book book) {                      // обновляем данные Book в БД
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {         // обновляем данные REST API Book в БД
        book.setId(id);                                  // Where id = id
        return bookRepository.save(book);
    }

    public void delete(Long id) {                        // удаляем Book из таблицы по id
        bookRepository.deleteById(id);
    }

    // Фильтры поиска:
    public List<Book> searchBooksTitle(String query) {   // собственный фильтр iLIKE '%title%'
        return bookRepository.searchBooksTitle(query);
    }

    public List<Book> searchBooksBrand(String query) {   // собственный фильтр iLIKE '%brand%'
        return bookRepository.searchBooksBrand(query);
    }

    public List<Book> searchBooksYear(String query) {   // собственный фильтр = year
        return bookRepository.searchBooksYear(query);
    }
}
