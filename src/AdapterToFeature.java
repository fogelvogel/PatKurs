
public class AdapterToFeature implements Feature{
private Lines IndependentObject = new Lines();
public int locate(MyImage image) {
	return IndependentObject.GetLines(image);
}
}
