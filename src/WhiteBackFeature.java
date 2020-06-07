import java.awt.Color;
import java.awt.Image;

public class WhiteBackFeature implements Feature{

	@Override
	public int locate(MyImage image) {
		int ret = 1;
		//for (int x = 0; x < w; x++)
		//	for (int y = 0; y < h; y++) {
		Color pixel = new Color(image.image.getRGB(0, 0));
		int brightness = (int) (pixel.getRed()+pixel.getBlue()+pixel.getGreen())/3;
		if(brightness < 10) ret = 0;
		pixel = new Color(image.image.getRGB( image.image.getWidth()-1, 0));
		if(brightness < 10) ret = 0;
		pixel = new Color(image.image.getRGB(0, image.image.getHeight()-1));
		if(brightness < 10) ret = 0;
		pixel = new Color(image.image.getRGB( image.image.getWidth()-1, image.image.getHeight()-1));
		return ret;
	}

}
