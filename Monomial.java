package bologheanu_florin_30224_tema_1;

public class Monomial {
	
	private int coefficient;
	private int exponent;
	
	Monomial(int x, int e){
		
		this.coefficient = x;
		this.exponent = e;
		
	}
	
	public int getCoefficient(){
		return this.coefficient;
	}
	
	public int getExponent(){
		return this.exponent;
	}
	
	public void setCoefficient(int c){
		this.coefficient = c;
	}
	
	public void setExponent(int e){
		this.exponent = e;
	}
	
}
