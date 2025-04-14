package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity                                                // @Entity - это Java Класс, который отображает информацию определенной таблицы в БД
@Table(name = "books")                                 // @Table(name = "books") - имя таблицы в БД. Показывает к какой именно таблице мы привязываем Класс
@Data                                                  // @Data - автоматически генерирует ГЕТТЕРЫ и СЕТТЕРЫ для всех НЕ финальных полей, МЕТОДЫ equals() и hashCode() и МЕТОД toString().
@AllArgsConstructor                                    // @AllArgsConstructor - заменяет Конструктор со всеми параметрами (библиотека lombok)
@NoArgsConstructor                                     // @NoArgsConstructor - заменяет Конструктор БЕЗ параметров (библиотека lombok)
@Builder
public class Book {

    @Id                                                // @Id - указывает какой столбец таблицы является PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)// @GeneratedValue - автогенерация PRIMARY KEY     // IDENTITY - стратегия, при которой PRIMARY KEY изменяется в соответствии с правилами, прописанными при создании таблицы
    private Long id;

    @Column(name = "vendor_code")                      // @Column(name = "vendor_code") - имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    private String vendorCode;
    private String title;
    private String year;
    private String brand;
    private int stock;
    private Double price;
}
