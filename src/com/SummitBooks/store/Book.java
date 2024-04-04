package com.SummitBooks.store;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private String isbn;

    // Constructor
    public Book(String isbn, String title, String author){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getters and setters
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString(){
        return STR."\{isbn} : \{title} by \{author}";
    }

    @Override
    public int compareTo(Book other){
        return this.title.compareToIgnoreCase(other.title);
    }

}
