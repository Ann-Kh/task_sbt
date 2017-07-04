package khantova.figures_model;

public class FigureKey {	
	private int key;
	
	public int get_key(){
	return key;
	}
	
	FigureKey(figure f){
		key=(int) Math.round(f.square()*1000+Math.random()*100);
	}

}
