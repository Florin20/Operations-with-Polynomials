package bologheanu_florin_30224_tema_1;

public class FCMonomial extends Monomial {
	
	private  int denominator;
	
	FCMonomial(int c, int d, int e){
		super(c, e);
		this.denominator = d;
	}
	
	public int getDenominator(){
		return this.denominator;
	}
	

}
