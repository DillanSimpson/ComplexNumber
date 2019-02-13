package P05;

import java.util.Scanner;

public class EX13_17 {

	public static void main(String[] args) {
		//Test Variables
		ComplexNumber test = new ComplexNumber (3,4);
		ComplexNumber test2 = new ComplexNumber (2,3);
		ComplexNumber test3 = new ComplexNumber (1,3);
		ComplexNumber test4 = new ComplexNumber (2,3);
		ComplexNumber test5 = new ComplexNumber ();
		ComplexNumber test6 = new ComplexNumber ();
		ComplexNumber zeroArg = new ComplexNumber ();
		ComplexNumber oneArg = new ComplexNumber (2);
		double inRe;
		double inIm;
		
		//Scanner object
		Scanner input = new Scanner(System.in);
		
		//Constructor Test
		if (zeroArg.comparable(test6) == true){
			System.out.println("Zero Arg Constructor Passed");
		}
		else
			System.out.println("Zero Arg Constructor Failed");
		
		if (oneArg.getRealPart() == 2 && oneArg.getImaginaryPart() == 0){
			System.out.println("One Arg Constructor Passed\n");
		}
		else
			System.out.println("One Arg Constructor Failed");
		
		//Comparable && Clonable tests
		ComplexNumber a = new ComplexNumber();
		ComplexNumber b = new ComplexNumber(3,5);
		
		System.out.println("Complex number A = " + a.toString());
		a = a.cloneable(b);
		System.out.println("Complex number A cloning b = " + a.toString());
		
		if(a.comparable(b) == true) {
			System.out.println("Clone && Compare works");
		}
		
		//Arithmetic Tests +=, -=, /=, *=
		System.out.println("\nComplex Numbers " + test.toString() + " += " + test2.toString() + " = " + test.addition(test2).toString());
		System.out.println("Complex Numbers " + test.toString() + " -= " + test2.toString() + " = " + test.subtraction(test2).toString());
		System.out.println("Complex Numbers " + test3.toString() + " /= " + test4.toString() + " = " + test3.divide(test4).toString());
		System.out.println("Complex Numbers "  + test.toString() + " *= " + test4.toString() + " = " + test.multiply(test4).toString());
		
		//Arithmetic +,-,/,* tests
		System.out.println("Complex Number " + test5.toString() + " set equal to " + test2.toString() + " + " + test.toString() + " = "
		+  test5.addition(test2, test).toString());
		System.out.println("Complex Number " + test5.toString() + " set equal to " + test2.toString() + " - " + test.toString() + " = "
				+  test5.subtraction(test2, test).toString());
		System.out.println("Complex Number " + test5.toString() + " set equal to " + test3.toString() + " / " + test4.toString() + " = "
				+  test5.subtraction(test3, test4).toString());
		System.out.println("Complex Number " + test5.toString() + " set equal to " + test.toString() + " * " + test4.toString() + " = "
				+  test5.subtraction(test3, test4).toString());
	
		//Input Test
		System.out.println("\nEnter a complex number excluding the i");		
		inRe = input.nextDouble();
		inIm = input.nextDouble();
		
		ComplexNumber inFinal = new ComplexNumber(inRe,inIm);
		System.out.println("Enter complex number = " + inFinal);
		System.out.println("Enter another complex number to operate on ");
		inRe = input.nextDouble();
		inIm = input.nextDouble();
		ComplexNumber inFinal2 = new ComplexNumber(inRe,inIm);
		System.out.println("The real part of first complex number is " + inFinal.getRealPart() + " and the imaginary part is " + inFinal.getImaginaryPart());
		System.out.println("The real part of second complex number is " + inFinal2.getRealPart() + " and the imaginary part is " + inFinal2.getImaginaryPart());
		System.out.println("The entered complex numbers " + inFinal.toString() + " + " + inFinal2.toString() + " = " + inFinal.addition(inFinal2).toString());
		System.out.println("The entered complex numbers " + inFinal.toString() + " - " + inFinal2.toString() + " = " + inFinal.subtraction(inFinal2).toString());
		System.out.println("The absolute value of " + inFinal.toString() + " = " + inFinal.abs());
		System.out.println("The absolute value of " + inFinal2.toString() + " = " + inFinal2.abs());
		System.out.println("The entered complex numbers " + inFinal.toString() + " / " + inFinal2.toString() + " = " + inFinal.divide(inFinal2).toString());
		System.out.println("The entered complex numbers " + inFinal.toString() + " * " + inFinal2.toString() + " = " + inFinal.multiply(inFinal2).toString());
		input.close();
	}

}
