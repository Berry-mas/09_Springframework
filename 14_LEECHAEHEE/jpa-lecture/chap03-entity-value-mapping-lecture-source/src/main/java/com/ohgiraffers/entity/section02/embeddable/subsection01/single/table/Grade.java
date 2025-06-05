package com.ohgiraffers.entity.section02.embeddable.subsection01.single.table;

public enum Grade {
    ONE_STAR, TWO_STAR, THREE_STAR, FOUR_STAR, FIVE_STAR;

    public static Grade from(String input) {
        if (input == null) return null;
        try {
            return Grade.valueOf(input);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
