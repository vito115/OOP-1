package org.skypro.skyshop;

public interface Searchable {

    String getSearchTerm();

    String getContentType();

    String getName();

    public String toString();

    default String getStringRepresentation() {
        return getName() + " - " + getContentType();
    }
}
