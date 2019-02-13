package P05;

public class ComplexNumber {
	private double re, im;
	
ComplexNumber(double real, double imag){
		re = real;
		im = imag;
	}

ComplexNumber(double real){
	re = real;
	im = 0;
}

ComplexNumber(){
	re = 0;
	im = 0;
}

public double getRealPart() {
	return  re;
}

public double getImaginaryPart() {
	return im;
}

public String toString() {
	String str = "("  + re + "," + im + "i)";
	return str;
}

public ComplexNumber addition(ComplexNumber a) {
	re += a.re;
	im += a.im;
	return this;
}

public ComplexNumber addition(ComplexNumber a, ComplexNumber b) {
	re = a.re + b.re;
	im = a.im + b.im;
	return this;
}

public ComplexNumber subtraction(ComplexNumber a) {
	re -= a.re;
	im -= a.im;
	return this;
}

public ComplexNumber subtraction(ComplexNumber a, ComplexNumber b) {
	re = a.re - b.re;
	im = a.im - b.im;
	return this;
}

public ComplexNumber multiply(ComplexNumber a) {
	re *= a.re;
	im *= a.im;
	return this;
}

public ComplexNumber multiply(ComplexNumber a, ComplexNumber b) {
	re = a.re * b.re;
	im = a.im * b.im;
	return this;
}
public ComplexNumber divide(ComplexNumber a) {
	return new ComplexNumber((re * a.re + re * a.im) / (a.re * a.re + a.im * a.im), 
	(im* a.re - re * a.im) / (a.re * a.re + a.im * a.im));	
}

public ComplexNumber divide(ComplexNumber a, ComplexNumber b) {
	return new ComplexNumber((a.re * b.re + a.re * b.im) / (b.re * b.re + b.im * b.im), 
	(a.im* b.re - a.re * b.im) / (b.re * b.re + b.im * b.im));	
}

public ComplexNumber cloneable(ComplexNumber a) {
	return a;
}

public boolean comparable(ComplexNumber a) {
	if(this.abs() == a.abs()) {
	return true;
	}
	else
	return false;
}

public double abs() {
	double absVal;
	absVal = Math.sqrt(Math.pow(re, 2) +  Math.pow(im, 2));
	return absVal;
}

}
