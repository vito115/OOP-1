package org.skypro.skyshop.article;

import org.skypro.skyshop.Searchable;

import java.util.Comparator;

public final class Article implements Searchable {

    private final String title;
    private final String text;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Article article = (Article) obj;
        return getName().equals(article.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

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
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title;
    }


}
