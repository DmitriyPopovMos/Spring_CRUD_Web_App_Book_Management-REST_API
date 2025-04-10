package org.example.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchRequestDto {

    String column;
    String value;
    Operation operation;

    public enum Operation {
        EQUAL, LIKE, IN, MORE_THAN, LESS_THAN, BETWEEN;
    }
}
