package org.skypro.skyshop.Article;

import org.skypro.skyshop.Searchable;

public final class Article implements Searchable {

    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return title + "\n" + text;
    }

    @Override
    public String getSearchTerm() {
        return text;
    }

    @Override
    public String getContentType() {
        return "Article";
    }

    @Override
    public String getName() {
        return title;
    }
}
