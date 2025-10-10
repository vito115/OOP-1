package org.skypro.skyshop.search;

import org.skypro.skyshop.Searchable;
import org.skypro.skyshop.article.SearchableNameComparator;

import java.util.*;

public class SearchEngine {

    private Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public Set<Searchable> search(String query) {

        Set<Searchable> results = new TreeSet<>(new SearchableNameComparator());


        for (Searchable searchable : searchables) {

            String term = searchable.getSearchTerm();

            if (term != null && term.contains(query)) {
                results.add(searchable);
                System.out.println("Добавлено в результаты: " + searchable.getName());
            }
        }
        return results;
    }


    public void add(Searchable searchable) {

        if (searchable != null) {
            searchables.add(searchable);
        }
    }

    public Searchable findBestMatch (String search, Set<Searchable> items) throws BestResultNotFoundException{
        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (Searchable item : items) {
            if (item != null) {
                String term = item.getSearchTerm();
                int occurrences = countOccurrences(term, search);

                if (occurrences > maxOccurrences) {
                    maxOccurrences = occurrences;
                    bestMatch = item;
                }
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFoundException("Не нашлось подходящей статьи для " + search);
        }
        return bestMatch;
    }

    private int countOccurrences(String term, String search) {
        int occurrences = 0;
        int index = term.indexOf(search);

        while (index != -1) {
            occurrences++;
            index = term.indexOf(search, index + search.length());
        }
        return occurrences;
    }
}
