package khantova.figures_model;



public abstract class figure {	 
	abstract double square();
    abstract double perimeter();

    @Override
    public abstract boolean equals(Object anObject);
    
    @Override
    public abstract int hashCode(); 
    
}
