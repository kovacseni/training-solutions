package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem item) {
        catalogItems.add(item);
    }

    public void deleteItemByRegistrationNumber(String regNumber) {
        for (int i = 0; i < catalogItems.size(); i++) {
            if (catalogItems.get(i).getRegistrationNumber().equals(regNumber)) {
                catalogItems.remove(catalogItems.get(i));
            }
        }
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> printedItemsList = new ArrayList<>();
        for (CatalogItem c : catalogItems) {
            if (c.hasPrintedFeature()) {
                printedItemsList.add(c);
            }
        }
        return printedItemsList;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> audioItemsList = new ArrayList<>();
        for (CatalogItem c : catalogItems) {
            if (c.hasAudioFeature()) {
                audioItemsList.add(c);
            }
        }
        return audioItemsList;
    }

    public int getAllPageNumber() {
        int sum = 0;
        for (CatalogItem c : getPrintedLibraryItems()) {
            sum += c.numberOfPagesAtOneItem();
        }
        return sum;
    }

    public int getFullLength() {
        int sum = 0;
        for (CatalogItem c : getAudioLibraryItems()) {
            sum += c.fullLengthAtOneItem();
        }
        return sum;
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> resultList = new ArrayList<>();
        for (CatalogItem c : catalogItems) {
           if (searchCriteria.hasTitle()) {
               for (String s : c.getTitles()) {
                   if (searchCriteria.getTitle().equals(s)) {
                       resultList.add(c);
                   }
               }
           } else if (!searchCriteria.hasTitle() && searchCriteria.hasContributor()) {
               for (String s : c.getContributors()) {
                   if (searchCriteria.getContributor().equals(s)) {
                       resultList.add(c);
                   }
               }
           }
        }
        return resultList;
    }

    public double averagePageNumberOver(int numberOfPages) {
        if (numberOfPages <= 0) {
            throw new IllegalArgumentException("Page number must be positive");
        }

        List<Integer> numberOfPagesList = new ArrayList<>();
        for (CatalogItem c : getPrintedLibraryItems()) {
            if (c.numberOfPagesAtOneItem() > numberOfPages) {
                numberOfPagesList.add(c.numberOfPagesAtOneItem());
            }
        }

        if (numberOfPagesList.size() == 0) {
            throw new IllegalArgumentException("No page");
        }

        int sum = 0;
        for (Integer i : numberOfPagesList) {
            sum += i;
        }
        return (sum / numberOfPagesList.size());
    }
}
