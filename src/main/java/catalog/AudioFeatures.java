package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {

    private final List<String> composer;
    private final int length;
    private final List<String> performers;
    private final String title;

    public AudioFeatures(String title, int length, List<String> performers) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("Invalid length");
        }
        if (Validators.isEmpty(performers)) {
            throw new IllegalArgumentException("Performers must be added");
        }

        this.title = title;
        this.length = length;
        this.performers = performers;
        this.composer = new ArrayList<>();
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("Invalid length");
        }
        if (Validators.isEmpty(performers) || Validators.isEmpty(composer)) {
            throw new IllegalArgumentException("Performers/Composer must be added");
        }

        this.title = title;
        this.length = length;
        this.performers = performers;
        this.composer = composer;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();
        for (String s : composer) {
            contributors.add(s);
        }
        for (String s : performers) {
            contributors.add(s);
        }
        return contributors;
    }
}
