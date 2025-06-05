package com.ohgiraffers.mapping.section03.compositekey.subsection02.idclass;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_cart")
@IdClass(CartCompositeKey.class)
public class Cart {

    @Id
    @Column(name= "cart_owner")
    private int cartOwner;

    @Id
    @Column(name="added_book")
    private int addedBook;

    @Column(name="quanity")
    private int quanity;

    public Cart() {
    }

    public Cart(int cartOwner, int addedBook, int quanity) {
        this.cartOwner = cartOwner;
        this.addedBook = addedBook;
        this.quanity = quanity;
    }

    public int getCartOwner() {
        return cartOwner;
    }

    public int getAddedBook() {
        return addedBook;
    }

    public int getQuanity() {
        return quanity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartOwner=" + cartOwner +
                ", addedBook=" + addedBook +
                ", quanity=" + quanity +
                '}';
    }
}
