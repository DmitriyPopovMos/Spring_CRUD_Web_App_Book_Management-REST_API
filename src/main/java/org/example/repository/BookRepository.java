package org.example.repository;

import org.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository                                                             // @Repository — указывает, что аннотированный класс является репозиторием данных, используемым для хранения, извлечения и поиска данных из БД
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {     // JpaRepository<T, ID> — это основной интерфейс Spring Data JPA, предоставляет базовые операции CRUD (Create, Read, Update, Delete) для сущностей.
                                                                        // JpaSpecificationExecutor<T> - подинтерфейс JpaRepository, который поддерживает запрос объектов сущности на основе заданных критериев (Необходим для создания сложных Фильтров)
}
