package fit24.duy.myapplication;

public class IconModel {
    private String title;
    private int iconResource;

    public IconModel(int iconResource, String title) {
        this.title = title;
        this.iconResource = iconResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIconResource() {
        return iconResource;
    }

    public void setIconResource(int iconResource) {
        this.iconResource = iconResource;
    }
} 