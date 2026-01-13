package Entities;

import ValueObjects.Image.ImageExt;
import ValueObjects.Image.ImageFilename;
import ValueObjects.Image.ImageId;
import ValueObjects.Image.ImageUrl;
import java.util.Objects;

public class Image {
    private final ImageId id;
    private ImageUrl url;
    private ImageFilename filename;
    private ImageExt ext;
    private String description;

    private Image(ImageId id, ImageUrl url, ImageFilename filename, ImageExt ext, String description) {
        if(id == null) throw new IllegalArgumentException("El id de la imagen no puede ser nulo");
        if(url == null) throw new IllegalArgumentException("La url de la imagen no puede ser nulo");
        if(filename == null) throw new IllegalArgumentException("El filename de la imagen no puede ser nulo");
        if(ext == null) throw new IllegalArgumentException("La extensión de la imagen no puede ser nulo");

        this.id = id;
        this.url = url;
        this.filename = filename;
        this.ext = ext;
        this.description = description;
    }

    public static Image create(ImageId id, ImageUrl url, ImageFilename filename, ImageExt ext, String description){
        return new Image(id, url, filename, ext, description);
    }

    public static Image restore(ImageId id, ImageUrl url, ImageFilename filename, ImageExt ext, String description){
        return new Image(id, url, filename, ext, description);
    }

    public void edit(ImageUrl url, ImageFilename filename, ImageExt ext, String description) {
        if(url == null) throw new IllegalArgumentException("La url de la imagen no puede ser nulo");
        if(filename == null) throw new IllegalArgumentException("El filename de la imagen no puede ser nulo");
        if(ext == null) throw new IllegalArgumentException("La extensión de la imagen no puede ser nulo");

        this.url = url;
        this.filename = filename;
        this.ext = ext;
        this.description = description;
    }

    public ImageId getId() {
        return id;
    }

    public ImageUrl getUrl() {
        return url;
    }

    public ImageFilename getFilename() {
        return filename;
    }

    public ImageExt getExt() {
        return ext;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(id, image.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
