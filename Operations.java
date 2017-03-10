package bologheanu_florin_30224_tema_1;

import java.util.ArrayList;
import java.util.Collections;

public class Operations {
	
	public static Polynomial Addition(Polynomial a, Polynomial b){
		
		Polynomial result = new Polynomial();
		ArrayList <Integer> index = new ArrayList<Integer>();
		int coef;
		boolean found;
		
		for(int i = 0; i < a.getNumElem(); i++){
			found = false;
			for(int j = 0; j < b.getNumElem(); j++){
				if(a.getMonomial(i).getExponent()
					== b.getMonomial(j).getExponent()){
						coef = a.getMonomial(i).getCoefficient()+
							   b.getMonomial(j).getCoefficient();
						result.addElem(new Monomial(coef, a.getMonomial(i).getExponent()));
						found = true;
						index.add(j);
						break;
					}
			}
			if(found == false)
				result.addElem(new Monomial(a.getMonomial(i).getCoefficient(),
						   a.getMonomial(i).getExponent()));
				
		}
		for(int i = 0; i < b.getNumElem(); i++){
			if(index.contains(i))
				continue;
			else
				result.addElem(b.getMonomial(i));
		}
		
		result.sort();
		result.deleteZeros();
		return result;
		
	}
	
	
	public static Polynomial Subtraction(Polynomial a, Polynomial b){
		
		Polynomial result = new Polynomial();
		ArrayList <Integer> index = new ArrayList<Integer>();
		int coef;
		boolean found;
		
		for(int i = 0; i < a.getNumElem(); i++){
			found = false;
			for(int j = 0; j < b.getNumElem(); j++){
				if(a.getMonomial(i).getExponent()
					== b.getMonomial(j).getExponent()){
					    coef = a.getMonomial(i).getCoefficient()-
							   b.getMonomial(j).getCoefficient();
						result.addElem(new Monomial(coef, a.getMonomial(i).getExponent()));
						found = true;
						index.add(j);
						break;
				}
			}
			if(found == false)
				result.addElem(new Monomial(a.getMonomial(i).getCoefficient(),
						   a.getMonomial(i).getExponent()));
				
		}
		for(int i = 0; i < b.getNumElem(); i++){
			if(index.contains(i)){
				continue;
			}
			else{
				result.addElem(new Monomial(-b.getMonomial(i).getCoefficient(), b.getMonomial(i).getExponent()));
			}
		}
		
		result.sort();
		result.deleteZeros();
		return result;
	}
	
	
	
	public static Polynomial Multiplication(Polynomial a, Polynomial b){
		
		Polynomial temp = new Polynomial();
		Polynomial result = new Polynomial();
		ArrayList<Integer> vec = new ArrayList<Integer>();
		Integer var = 0;
		
		for(int i = 0; i < a.getNumElem(); i++){
			for(int j = 0; j < b.getNumElem(); j++){
				temp.addElem(new Monomial(a.getMonomial(i).getCoefficient()*
								b.getMonomial(j).getCoefficient(),
								a.getMonomial(i).getExponent()+
								b.getMonomial(j).getExponent()));
			}
		}
		
		for(int i = 0; i < temp.getNumElem(); i++){
			if(vec.contains(temp.getMonomial(i).getExponent()))
					continue;
			var = temp.getMonomial(i).getCoefficient();
			vec.add(temp.getMonomial(i).getExponent());
			for(int j = i + 1; j < temp.getNumElem(); j++){
				if(temp.getMonomial(i).getExponent() == temp.getMonomial(j).getExponent()){
					var += temp.getMonomial(j).getCoefficient();
				}
			}
			result.addElem(new Monomial(var, temp.getMonomial(i).getExponent()));
			var = 0;
		}
		
		result.sort();
		result.deleteZeros();
		return result;
		
	}
	
	public static Polynomial Division(Polynomial a, Polynomial b){
		
		Polynomial remainder = new Polynomial();
		Polynomial quotient = new Polynomial();
		
		//a.sort();
		//b.sort();
	
		
		quotient.addElem(new Monomial(a.getMonomial(0).getCoefficient()/b.getMonomial(0).getCoefficient(),
				a.getMonomial(0).getExponent()-b.getMonomial(0).getExponent()));
		remainder = Subtraction(a, Multiplication(b, quotient));
		if(remainder.isNull())
			return quotient;		//System.out.println(remainder.getNumElem());
		remainder.deleteZeros();
		remainder.sort();
		
		do{
			quotient.addElem(new Monomial(remainder.getMonomial(0).getCoefficient()/b.getMonomial(0).getCoefficient(),
						     remainder.getMonomial(0).getExponent()-b.getMonomial(0).getExponent()));
			remainder = Subtraction(a, Multiplication(b, quotient));
			if(remainder.isNull())
				return quotient;
			
			remainder.deleteZeros();
			remainder.sort();
		}while(remainder.getMonomial(0).getExponent() >= b.getMonomial(0).getExponent());
		
		return quotient;
		
	}
}
