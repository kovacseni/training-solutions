package catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogItem {

    private List<Feature> features = new ArrayList<>();
    private final int price;
    private final String registrationNumber;

    public CatalogItem(String registrationNumber, int price, Feature... feature) {
        this.registrationNumber = registrationNumber;
        this.price = price;

        for (int i = 0; i < feature.length; i++) {
            features.add(feature[i]);
        }
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getPrice() {
        return price;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public int fullLengthAtOneItem() {
        int sum = 0;
        for (Feature f : features) {
            if (f.getClass() == AudioFeatures.class) {
                sum += ((AudioFeatures) f).getLength();
            }
        }
        return sum;
    }

   public List<String> getContributors() {

        List<String> contributorsList = new ArrayList<>();
        List<String> listOfContributors = new ArrayList<>();

        for (Feature f : features) {
            for (String s : f.getContributors()) {
                listOfContributors.add(s);
            }
        }
        for (int i = 0; i < listOfContributors.size(); i++) {
            contributorsList.add(listOfContributors.get(i));
        }
        return contributorsList;
   }

   public List<String> getTitles() {
        List<String> titleList = new ArrayList<>();
        for (Feature f : features) {
            titleList.add(f.getTitle());
        }
        return titleList;
   }

   public boolean hasAudioFeature() {
        boolean hasAudio = false;
        for (Feature f : features) {
            if (f.getClass() == AudioFeatures.class) {
                hasAudio = true;
                break;
            }
        }
        return hasAudio;
   }

   public boolean hasPrintedFeature() {
        boolean hasPrinted = false;
        for (Feature f : features) {
            if (f.getClass() == PrintedFeatures.class) {
                hasPrinted = true;
                break;
            }
        }
        return hasPrinted;
   }

   public int numberOfPagesAtOneItem() {
       int numberOfPages = 0;
       for (Feature f : features) {
           if (f.getClass() == PrintedFeatures.class) {
               numberOfPages = ((PrintedFeatures) f).getNumberOfPages();
           }
       }
       return numberOfPages;
   }
}
