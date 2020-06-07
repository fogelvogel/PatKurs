
public class FeatureIterator implements Iterator{
private int currentFeatureIterating;
	@Override
	public boolean hasNext() {
		if(currentFeatureIterating>= Main.FeatureCount) return false;
		return true;
	}

	public int getCurrentFeature() {
		return currentFeatureIterating;
	}

	public void setCurrentFeature(int currentFeature) {
		this.currentFeatureIterating = currentFeature;
	}

	@Override
	public Feature next(Feature[] array) {
		if(hasNext()) {
			currentFeatureIterating ++;
			return array[currentFeatureIterating -1];
			
		}
		return null;
	}

	//тут можно сделать если перегрузить операцию
	
	/*@Override
	public void remove(Feature f, Feature[] array) {
		for(int i = 0; i< Main.featureCount; i++) {
			if(number<i) array[i-1] = array[i];
		} 
	}*/

	@Override
	public void remove(int number, Feature[] array) {
		for(int i = 0; i< Main.FeatureCount; i++) {
			if(number<i) array[i-1] = array[i];
		} 
		
	}

}
