package com.ohgiraffers.mapping.section03.compositekey.subsection02.idclass;

import java.io.Serializable;

public class CartCompositekey implements Serializable {
    private int cartOwner;
    private int addedBook;

    public CartCompositekey() {
    }

    public CartCompositekey(int cartOwner, int addedBook) {
        this.cartOwner = cartOwner;
        this.addedBook = addedBook;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
