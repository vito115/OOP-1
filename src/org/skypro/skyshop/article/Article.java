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

    public static class ArticleComparator implements Comparator<Article> {

        @Override
        public int compare(Article o1, Article o2) {

            int lengthComparison = Integer.compare(o2.getName().length(), o1.getName().length());

            if (lengthComparison == 0) {
                return o1.getName().compareTo(o2.getName());
            }
            return lengthComparison;
        }
    }
}
