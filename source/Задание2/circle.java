package khantova.figures_model;

public class circle extends figure {

	private double radius;
	circle(){		
		radius=1;	
	}
	
	circle(double r){		
		radius=r;		
	}
	
	public double GetRadius(){		
		return radius;
	}
	
	@Override
	public double square() {
		return (Math.PI*Math.pow(radius, 2));		
	}

	@Override
	public  double perimeter() {
		return (2*Math.PI*radius);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this)
		    return true;
		
		if(obj == null)//если obj ссылается на null 
		    return false;

		 if(!(getClass() == obj.getClass()))//проверяем, что ссылки имеют одинаковый тип 
		     return false;
		 else{
		     circle tmp = (circle)obj;
		     if(tmp.radius == this.radius)
		         return true;
		     else
		         return false;
		    }		
	}

	@Override
	public int hashCode() {
		return (int)(1000*radius);
	}

	
}


