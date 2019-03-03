package com.sourceallies.demos.library.domain;

public class Genre {
    private String name;
    private Long bookCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBookCount(Long bookCount) {
        this.bookCount = bookCount;
    }

    public Long getBookCount() {
        return bookCount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Genre{");
        sb.append("name='").append(name).append('\'');
        sb.append(", bookCount=").append(bookCount);
        sb.append('}');
        return sb.toString();
    }
}
