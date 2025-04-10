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
    @Column(name = "id")                               // @Column(name = "id") - имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    private Long id;

    @Column(name = "vendor_code")                      // @Column(name = "vendor_code") - имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    private String vendorCode;

    @Column(name = "title")                            // @Column(name = "title") - имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    private String title;

    @Column(name = "year")                             // @Column(name = "year") - имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    private String year;

    @Column(name = "brand")                            // @Column(name = "brand") - имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    private String brand;

    @Column(name = "stock")                            // @Column(name = "stock") - имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    private int stock;

    @Column(name = "price")                            // @Column(name = "id") - имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    private Double price;

    @Override
    public String toString() {
        return "\nBook{" +
                "id=" + id +
                ", vendorCode='" + vendorCode + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", brand='" + brand + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}
