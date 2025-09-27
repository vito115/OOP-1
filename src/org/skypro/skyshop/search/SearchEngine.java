package org.skypro.skyshop.search;

import org.skypro.skyshop.Searchable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {

    private List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }


    public Map<String, Searchable> search(String query) {

        Map<String, Searchable> results = new TreeMap<>();


        for (Searchable searchable : searchables) {

            String term = searchable.getSearchTerm();

            if (term != null && term.contains(query)) {
                results.put(searchable.getName(), searchable);
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

    public Searchable findBestMatch (String search, List<Searchable> items) throws BestResultNotFound{
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
            throw new BestResultNotFound("Не нашлось подходящей статьи для " + search);
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
