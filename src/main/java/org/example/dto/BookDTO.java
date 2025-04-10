package org.example.dto;

import lombok.Data;


@Data                                                              // @Data - автоматически генерирует ГЕТТЕРЫ и СЕТТЕРЫ для всех НЕ финальных полей, МЕТОДЫ equals() и hashCode() и МЕТОД toString().
public class BookDTO {

    private Long id;
    private String vendorCode;
    private String title;
    private String year;
    private String brand;
    private int stock;
    private Double price;
}
