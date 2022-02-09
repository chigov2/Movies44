package techmarket.uno.movies44;

import android.widget.ImageView;

public class PosterSmall {
    private ImageView imageViewPoster;

    public ImageView getImageViewPoster() {
        return imageViewPoster;
    }

    public void setImageViewPoster(ImageView imageViewPoster) {
        this.imageViewPoster = imageViewPoster;
    }

    public PosterSmall(ImageView imageViewPoster) {
        this.imageViewPoster = imageViewPoster;
    }

    public PosterSmall() {
    }
    //класс Pojo - ниотчего не наследуется, содержит геттере, сеттеры, конструкторы
}
