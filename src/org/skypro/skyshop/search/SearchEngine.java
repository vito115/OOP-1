package org.skypro.skyshop.search;

import org.skypro.skyshop.Searchable;

public class SearchEngine {

    private Searchable[] searchables;
    private int size;

    public SearchEngine() {
        this.searchables = new Searchable[5];
        this.size = 0;
    }

    public Searchable[] search(String query) {

        Searchable[] results = new Searchable[5];
        int count = 0;

        for (Searchable searchable : searchables) {

            String term = searchable.getSearchTerm();

            if (term.contains(query)) {
                results[count] = searchable;
                count++;
            }
            if (count == 5) {
                break;
            }
        }
        return results;
    }

    public void add(Searchable searchable) {

        if (size == searchables.length) {
            return;
        }
        searchables[size] = searchable;
        size++;
        }
}
