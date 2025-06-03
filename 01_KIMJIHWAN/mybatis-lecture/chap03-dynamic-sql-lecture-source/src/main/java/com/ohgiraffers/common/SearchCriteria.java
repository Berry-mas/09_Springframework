package com.ohgiraffers.common;


/*
이 클래스는 JPA Criteria API와 함께 사용되며, 이를 통해 SQL의 WHERE 절을 동적으로
 생성할 수 있습니다. 또한, Predicate을 활용하여 여러 조건을 조합
 */
public class SearchCriteria {
    private String condition;
    private String value;

    public SearchCriteria() {
    }

    public SearchCriteria(String condition, String value) {
        this.condition = condition;
        this.value = value;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "condition='" + condition + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
