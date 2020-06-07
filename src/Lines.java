import java.awt.Color;
import java.awt.image.BufferedImage;

public class Lines {

public int GetLines(MyImage image) {
	int lines = 0;
	int w = image.image.getWidth();
	int h = image.image.getHeight();
	//BufferedImage newimage = new BufferedImage(w,h,image.getType());
	
	for (int x = 0; x < w; x++) {
		for (int y = 0; y < h; y++) {
			double sumR = 0, sumG = 0, sumB = 0;
			
			for(int i = -1;i<= 1;i++) {
				for(int j = -1;j<=1;j++) {
					if (i == 0 && j == 0)
						continue;
					
					int shiftX,shiftY;
					if(x+i<0 || x+i>=w) shiftX = -i;
					else shiftX = i;
					if(y+j<0 || y+j >= h) shiftY = -j;
					else shiftY = j;
					Color color = new Color(image.image.getRGB(x + shiftX, y +shiftY));

					sumR += color.getRed();
					sumG += color.getGreen();
					sumB += color.getBlue();
				}
			}
			sumR /= 8;
			sumG /= 8;
			sumB /= 8;
			double sumBr = (sumR+sumB+sumG)/3;
			Color color = new Color(image.image.getRGB(x, y));
			double midBr = (color.getRed()+color.getBlue()+color.getGreen())/3;
			if (Math.abs(sumBr-midBr) > 10)
			lines ++;
		}
	}
	return lines;
}
}
