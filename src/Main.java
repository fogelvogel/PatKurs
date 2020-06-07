import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Main {
	public static final int FeatureCount = 4;
	public static final int ImageCount = FirstWindow.QuantityOfImages;
	//public static final int ImageCount = 20;
	public static ImageSet imageSet;
	public static FeatureSet featureSet;
	MyImage tmp = new MyImage();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstWindow window = new FirstWindow();
					window.frame.setVisible(true);
					imageSet = new ImageSet();
					BufferedImage tmp;
					for(int i = 1;i<=Main.ImageCount;i++) {
						tmp = ImageIO.read(new File(Integer.toString(i) +".jpg"));
						imageSet.addItem(tmp );
					}
					featureSet = new FeatureSet();
					featureSet.addItem(new WhiteBackFeature());
					featureSet.addItem(new BigImageFeature());
					featureSet.addItem(new MostlyBlackFeature());
					featureSet.addItem(new AdapterToFeature());
					featureSet.createIterator();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	}


