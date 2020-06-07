
public class FeatureSet implements Set{
	private FeatureIterator iterator;
	private int countFeatures;
public Feature[] allFeatures;
public FeatureSet() {
	allFeatures = new Feature[Main.FeatureCount];
}
public void createIterator() {
	iterator = new FeatureIterator();
}
public Feature giveFeatureToCompare() {
return iterator.next(allFeatures);
}
@Override
public void addItem(Object feature) {
	if(countFeatures<4) allFeatures[countFeatures] = (Feature) feature;
	countFeatures++;
}
}
