package khantova.figures_model;

public class quadrate extends figure {

	private double side_length;
	
	quadrate(){
		side_length=1;
	}
	
	quadrate(double length){
		side_length=length;
	}
	
	public double GetSide(){		
		return side_length;
	}
	
	@Override
	public double square() {
		return Math.pow(side_length, 2);	
	}

	@Override
	public double perimeter() {
		return side_length*4;		
	}	

	@Override
	public boolean equals(Object obj) {
		if(obj == this)
		    return true;
		
		if(obj == null)//если obj ссылается на null 
		    return false;
		
		if(!(getClass() == obj.getClass()))//проверяем, что ссылки имеют одинаковый самый тип 
		     return false;
		else{
			 quadrate tmp = (quadrate)obj;
		     if(tmp.side_length == this.side_length)
		         return true;
		     else
		         return false;
		    }
	}

	@Override
	public int hashCode() {
		return (int)(1000*side_length);
	}

}
