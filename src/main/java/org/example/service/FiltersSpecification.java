package org.example.service;


import jakarta.persistence.criteria.*;
import org.example.dto.RequestDto;
import org.example.dto.SearchRequestDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service                                                          // @Service - Указывает, что класс содержит бизнес-логику, вычисления или вызовы внешних API
public class FiltersSpecification<T> {

    public Specification<T> getSearchSpecification(SearchRequestDto searchRequestDto) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(searchRequestDto.getColumn()), searchRequestDto.getValue());
            }
        };
    }


    public Specification<T> getSearchSpecification(List<SearchRequestDto> searchRequestDto, RequestDto.GlobalOperator globalOperator) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            for (SearchRequestDto requestDto: searchRequestDto) {

                switch (requestDto.getOperation()) {
                    case EQUAL:
                        Predicate equal = criteriaBuilder.equal(root.get(requestDto.getColumn()), requestDto.getValue());
                        predicates.add(equal);
                        break;

                    case LIKE:
                        Predicate like = criteriaBuilder.like(root.get(requestDto.getColumn()), "%" + requestDto.getValue() + "%");
                        predicates.add(like);
                        break;

                    case IN:
                        String[] split = requestDto.getValue().split(", ");
                        Predicate in = root.get(requestDto.getColumn()).in(Arrays.asList(split));
                        predicates.add(in);
                        break;

                    case LESS_THAN:
                        Predicate lessThan = criteriaBuilder.lessThan(root.get(requestDto.getColumn()), requestDto.getValue());
                        predicates.add(lessThan);
                        break;

                    case MORE_THAN:
                        Predicate greaterThan = criteriaBuilder.greaterThan(root.get(requestDto.getColumn()), requestDto.getValue());
                        predicates.add(greaterThan);
                        break;

                    case BETWEEN:
                        String[] split1 = requestDto.getValue().split(", ");
                        Predicate between = criteriaBuilder.between(root.get(requestDto.getColumn()), split1[0], split1[1]);
                        predicates.add(between);
                        break;

                    default:
                        throw  new IllegalStateException("Unexpected value: " + "");
                }
            }

            if (globalOperator.equals(RequestDto.GlobalOperator.AND)) {
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
            else {
                return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
