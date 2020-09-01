package com.codegym.muon_sach.model;

public class Book {

    private int id;
    private String nameBook;
    private int amount;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book(int id, String nameBook, int amount) {
        this.id = id;
        this.nameBook = nameBook;
        this.amount = amount;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
