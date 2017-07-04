package khantova.figures_model;

public class triangle extends figure{

	private double angle_12,angle_23,angle_31;
	private double side_1,side_2,side_3;
	
	triangle(){
		angle_12=60;
		angle_23=60;
		angle_31=60;
		
		side_1=1;
		side_2=1;
		side_3=1;		
	}
	
	triangle(double s_1,double s_2,double a_12){ //конструктор для двух сторон и угола между ними 
		angle_12=a_12;		
		side_1=s_1;
		side_2=s_2;
		side_3=Math.sqrt(Math.pow(side_1, 2)+Math.pow(side_2, 2)-2*side_1*side_2*Math.cos(Math.toRadians(angle_12)));	
		
		angle_23=(Math.pow(side_3, 2)+Math.pow(side_2, 2)-Math.pow(side_1, 2))/(2*side_3*side_2);
		angle_23=Math.toDegrees(Math.acos((Math.pow(side_3, 2)+Math.pow(side_2, 2)-Math.pow(side_1, 2))/(2*side_3*side_2)));		
		angle_31=180-angle_12-angle_23;		
	}	
	
	public double GetSide_1(){		
		return side_1;
	}
	
	public double GetSide_2(){		
		return side_2;
	}
	
	public double GetSide_3(){		
		return side_3;
	}
	
	public double GetAngle_12(){		
		return angle_12;
	}
	
	public double GetAngle_23(){		
		return angle_23;
	}
	
	public double GetAngle_31(){		
		return angle_31;
	}	
	
	@Override
	double square() {
		double p=perimeter()/2;
		return Math.sqrt(p*(p-side_1)*(p-side_2)*(p-side_3));		
	}

	@Override
	double perimeter() {
		return side_1+side_2+side_3;	
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this)
		    return true;
		
		if(obj == null) //если obj ссылается на null 
		    return false;
		
		 if(!(getClass() == obj.getClass()))//проверяем, что ссылки имеют одинаковый самый тип 
		     return false;
		 else{
			 triangle tmp = (triangle)obj;			
			 if(this.side_1 == tmp.side_1){
				 if( (this.side_2 == tmp.side_2)&(this.angle_12==tmp.angle_12) ||(this.side_2 == tmp.side_3)&(this.angle_12==tmp.angle_31)) 
					 return true; 				 
			 }
			 
			 if(this.side_1 == tmp.side_2){
				 if( (this.side_2 == tmp.side_1)&(this.angle_12==tmp.angle_12) ||(this.side_2 == tmp.side_3)&(this.angle_12==tmp.angle_23)) 
					 return true; 				 
			 }
				 
			 if(this.side_1 == tmp.side_3){
				 if( (this.side_2 == tmp.side_1)&(this.angle_12==tmp.angle_31) ||(this.side_2 == tmp.side_2)&(this.angle_12==tmp.angle_23)) 
					 return true; 				 
			 }
			 
			 return false; 
		 }
	}

	@Override
	public int hashCode() {
		return (int)(1000*side_1+100*side_2+10*angle_12+angle_23);
	}

	

}
