package org.skypro.skyshop.search;

import org.skypro.skyshop.Searchable;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }


    public List<Searchable> search(String query) {

        List<Searchable> results = new ArrayList<>();


        for (Searchable searchable : searchables) {

            String term = searchable.getSearchTerm();

            if (term != null && term.contains(query)) {
                results.add(searchable);
            }
        }
        return results.size() > 5 ? results.subList(0, 5) : results;
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
