package com.ohgiraffers.mapping.section03.compositekey.subsection02.idclass;

import jakarta.persistence.*;

public class CartDTO {

    private int cartOwnerMemberNo;

    private int addedBookNo;

    private int quanity;

    public CartDTO(int cartOwnerMemberNo, int addedBookNo, int quanity) {
        this.cartOwnerMemberNo = cartOwnerMemberNo;
        this.addedBookNo = addedBookNo;
        this.quanity = quanity;
    }

    public int getCartOwnerMemberNo() {
        return cartOwnerMemberNo;
    }

    public int getAddedBookNo() {
        return addedBookNo;
    }

    public int getQuanity() {
        return quanity;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "cartOwnerMemberNo=" + cartOwnerMemberNo +
                ", addedBookNo=" + addedBookNo +
                ", quanity=" + quanity +
                '}';
    }
}
