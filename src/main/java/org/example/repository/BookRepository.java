package org.example.repository;

import org.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository                                                             // @Repository — указывает, что аннотированный класс является репозиторием данных, используемым для хранения, извлечения и поиска данных из БД
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {     // JpaRepository<T, ID> — это основной интерфейс Spring Data JPA, предоставляет базовые операции CRUD (Create, Read, Update, Delete) для сущностей.
                                                                        // JpaSpecificationExecutor<T> - подинтерфейс JpaRepository, который поддерживает запрос объектов сущности на основе заданных критериев (Необходим для создания сложных Фильтров)


    // Фильтры поиска:

    @Query("SELECT b FROM Book b WHERE b.title iLIKE CONCAT('%', :query, '%') " +   // собственный фильтр iLIKE '%TitleBrandYear%'
            "OR b.brand iLIKE CONCAT('%', :query, '%')" +
            " OR b.year = :query")
    List<Book> searchBooksTitleBrandYear(String query);
//                                                                        // @Query("sql_запрос_к_БД") - позволяет выполнять запросы к Базе Данных на подобии SQL (HQL, JPQL)
//                                                                        // LIKE - выводит данные содержащиеся в поиске '%тар' / 'тар%' / '%тар%' (iLIKE - игнорирует регистр)
//                                                                        // CONCAT(str1, 'char', strN) - Возвращает строку, созданную путем объединения всех аргументов.
}