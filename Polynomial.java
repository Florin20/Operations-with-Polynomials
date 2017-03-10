package bologheanu_florin_30224_tema_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Polynomial {
	
	private ArrayList<Monomial> polynomial;
	private int elements;
	
	Polynomial(){int a;
		polynomial = new ArrayList<Monomial>();
		elements = 0;
	}
	
	Polynomial(String s){
		
		int x = 0;
		int coef = 0;
		int exp = 0;
		String ss;
		
		this.elements = 0;
		polynomial = new ArrayList<Monomial>();
		
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '+' || s.charAt(i) == '-' || i == s.length() - 1){
				if(i == s.length() - 1)
					ss = s.substring(x, i+1);
				else if(i == 0)
					continue;
				else
					ss = s.substring(x, i);
				if(ss.contains("x")){
					coef = convToInt(ss, 0, ss.indexOf("x"), true);
					if((ss.indexOf("x") + 1) != ss.length()){
						exp = convToInt(ss, ss.indexOf("x") + 2, ss.length(), false);
					}
					else{
						exp = 1;
					}
					polynomial.add(new Monomial(coef, exp));
					x = i;
					elements++;
				}
				else{
					if(ss.length() == 1){
						switch(ss.charAt(0)){
						case '+': break;
						case '-': break;
						default: ss = "+"+ss;
						}
					}
					coef = convToInt(ss, 0, ss.length(), true);
					exp = 0;
					polynomial.add(new Monomial(coef, exp));
					x = i;
					elements++;
				}
			}
				
		}
		/*for(Monomial d: polynomial){
			System.out.println(d.getCoefficient() + " " + d.getExponent());
		}*/
		//this.sort();
	}
		/*this.polynomial = new ArrayList<Monomial>();
		this.elements = 0;
		
		int x = 0; 
		int coef = 0;
		int exp = 0;
		String ss; //substring
		
		for(int i = 0; i < s.length(); i++){
			if((s.charAt(i) == '+' && i != 0)
					|| (s.charAt(i) == '-' && i != 0) 
					|| i == s.length()-1){
					ss = s.substring(x, i);
					if(ss.contains("x")){
						coef = convToInt(ss, 0, ss.indexOf("x"),
							   true);
						if(ss.length() - ss.indexOf("x") > 1){
							exp = convToInt(ss, ss.indexOf("x")+2,
								  ss.length(), false);
						}
						else{
							exp = 1;
						}
						x = i;
						polynomial.add(new Monomial(coef, exp));
						elements++;
					}
					else{
						coef = convToInt(ss, 0, ss.length(), true);
						exp = 0;
						x = i;
						polynomial.add(new Monomial(coef, exp));
						elements++;
					}
				}
			}*/
		
	
	private  int convToInt(String s, int a, int b, boolean coef){
		
		int number = 0;
		char sgn;
		
		if(coef == true && s.charAt(a) != '+' && s.charAt(a) != '-'){
			s = "+" + s;
			b++;
		}
		
		if(coef == true && b - a == 0){
			number = 1;
			return number;
		}
		
		else if(coef == true && b - a == 1){
			sgn = s.charAt(a);
			switch(sgn){
			case '-': return -1;
			default: return 1;
			}
			
		}
		
		switch(s.charAt(a)){
		case '+': sgn = '+';
				  a++;
				  break;		  
		case '-': sgn = '-'; 
				  a++;
				  break;		  
		default: sgn = '+';
				  break;
		}
		
		for(int i = a; i < b; i++){
			number += (s.charAt(i) - 48) * Math.pow(10, b-i-1);	
		}
		
		if(sgn == '-')
			number = 0 - number;
		
		return number;
	}
	
	public String toString(){
		
		String s = new String();
		
		for(Monomial x: polynomial){
			if(x instanceof FCMonomial){
				if(x.getCoefficient() >= 0){
					s+="+";
				}
				if(x.getExponent() == 1){
					s+=x.getCoefficient()  + "x";
				}
				else{
					s+=x.getCoefficient() + "/" + (((FCMonomial)x).getDenominator() + "x^"+x.getExponent());
				}
			}
			
			else{
				if(x.getCoefficient() >= 0){
					s+="+";
				}
				if(x.getExponent() == 0){
					s+=x.getCoefficient();
				}
				else if(x.getExponent() == 1){
					if(x.getCoefficient() == 1){
						s+="x";
					}
					else{
						s+=x.getCoefficient() + "x";
					}
				}
				else{
					if(x.getCoefficient() == 1){
						s+="x^"+x.getExponent();
					}
					else{
						s+=x.getCoefficient()+"x^"+x.getExponent();
					}
				}
			}
		}
			
		return s;
		
	}
	
	public void addElem(Monomial x){
		polynomial.add(x);
		this.elements++;
	}
	
	public int getNumElem(){
		return this.elements;
	}
	
	public Monomial getMonomial(int k){
		return this.polynomial.get(k);
	}
	
	public void sort(){
		Collections.sort(polynomial, new Comparator<Monomial>() {
		    public int compare(Monomial z1, Monomial z2) {
		        if (z1.getExponent() > z2.getExponent())
		            return -1;
		        if (z1.getExponent() < z2.getExponent())
		            return 1;
		        return 0;
		    }
		});
		
	}
	
	public boolean isNull(){
		if(polynomial.isEmpty())
			return true;
		return false;
	}
	
	public void deleteZeros(){
		int counter = 0;;
		Iterator<Monomial> it = this.polynomial.iterator();
		while(it.hasNext()){
			Monomial mon = it.next();
			if(mon.getCoefficient() == 0){
				counter++;
				it.remove();
			}
		}
		this.elements = this.elements - counter;
	}
	
	public Polynomial Differentiation(){
		Polynomial result = new Polynomial();
		//int coef, exp;
		
		for(Monomial a: polynomial){
			if(a.getExponent() == 0){
				continue;
			}
			else{
			result.addElem(new Monomial(a.getExponent() * a.getCoefficient(),
					a.getExponent() - 1));
			}
		}
		return result;
	}
	
	
	public Polynomial Integration(){
		Polynomial result = new Polynomial();
		
		for(Monomial a: polynomial){
			if(a.getExponent() == 0){
				result.addElem(new FCMonomial(a.getCoefficient(), 1, 1));
			}
			else{
				result.addElem(new FCMonomial(a.getCoefficient(), a.getExponent()+1,
							   a.getExponent()+1));
			}
		}
		return result;
	}
	

}
