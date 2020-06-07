
public class BigImageFeature implements Feature{
	@Override
	public int locate(MyImage image) {
		int ret = 0;
		if(image.image.getHeight() > 100 || image.image.getWidth() > 150) {
			ret = 1;
			}
		return ret;
		}
		
}
