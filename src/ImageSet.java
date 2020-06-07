import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ImageSet implements Set{
private ArrayList <MyImage>  images = new ArrayList();

public MyImage getImage(int i) {
	return images.get(i);
}

public void setImages(ArrayList <MyImage> images) {
	this.images = images;
}
@Override
public void addItem(Object image) {
	MyImage newImage = new MyImage();
	newImage.image = (BufferedImage) image;
	images.add(newImage);
}
}
