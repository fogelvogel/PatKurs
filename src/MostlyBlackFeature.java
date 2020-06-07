import java.awt.Color;

public class MostlyBlackFeature implements Feature{

	@Override
	public int locate(MyImage image) {
		int ret = 0;
		int w = image.image.getWidth();
		int h = image.image.getHeight();
		int countDarkPixels = 0;
		for (int x = 0; x < w; x++) {
				for (int y = 0; y < h; y++) {
					Color pixel = new Color(image.image.getRGB(x, y));
					int brightness = (int) (pixel.getRed()+pixel.getBlue()+pixel.getGreen())/3;
					if(brightness < 125) {
						countDarkPixels ++;
					}
					else countDarkPixels --;
				}
		}
		if(countDarkPixels >0) ret = 1;
		return ret;
	}

}
