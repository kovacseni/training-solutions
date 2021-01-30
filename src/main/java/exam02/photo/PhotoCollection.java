package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    private List<Photo> photos = new ArrayList<>();

    public List<Photo> getPhotos() {
        return new ArrayList<>(photos);
    }

    public void addPhoto(String... photosToAdd) {
        for (String s : photosToAdd) {
            photos.add(new Photo(s));
        }
    }

    public int numberOfStars() {
        int sumOfStars = 0;
        for (Photo p : photos) {
            sumOfStars += p.getQuality().getStar();
        }
        return sumOfStars;
    }

    public void starPhoto(String name, Quality quality) {
        boolean isPhotoInPhotos = false;
        for (Photo p : photos) {
            if (p.getName().equals(name)) {
                p.setQuality(quality);
                isPhotoInPhotos = true;
            }
        }
        if (!isPhotoInPhotos) {
            throw new PhotoNotFoundException("No such photo!");
        }
    }
}
