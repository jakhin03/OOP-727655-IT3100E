import javax.swing.JOptionPane;
import java.lang.Math;

public class EquationSolver{
	private static void firstChoice(String title){
		double a,b;
		JOptionPane.showMessageDialog(null,"The equation is formated to ax + b = 0",title , JOptionPane.INFORMATION_MESSAGE);
		a = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter a: ", title, JOptionPane.INFORMATION_MESSAGE));
		b = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter b: ", title, JOptionPane.INFORMATION_MESSAGE));
		if (a == 0){
			if (b == 0){
				JOptionPane.showMessageDialog(null,"The equation has infinite solutions", title, JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null,"The solution has no solution", title, JOptionPane.INFORMATION_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(null,String.format("Result: %,.2f", -b/a), title, JOptionPane.INFORMATION_MESSAGE);
		}	
	}

	private static void secondChoice(String title){
		double a11, a12, b1, a21, a22, b2;
		JOptionPane.showMessageDialog(null,"The equation is formated to:\na11x + a12y = b1\na21x + a22y = b2",title,JOptionPane.INFORMATION_MESSAGE);
		a11 = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter a11: ", title, JOptionPane.INFORMATION_MESSAGE));
		a12 = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter a12: ", title, JOptionPane.INFORMATION_MESSAGE));
		b1 = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter b1: ", title, JOptionPane.INFORMATION_MESSAGE));
		a21 = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter a21: ", title, JOptionPane.INFORMATION_MESSAGE));
		a22 = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter a22: ", title, JOptionPane.INFORMATION_MESSAGE));
		b2 = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter b2: ", title, JOptionPane.INFORMATION_MESSAGE));

		double det,det1,det2,x,y;
		det = (a11*a22) - (a12*a21);
		det1 = (b1*a22) - (b2*a12);
		det2 = (a11*b2) - (a21*b1);

		if (det == 0){
			if (det1 == det2 || det1 == 0){
				JOptionPane.showMessageDialog(null,String.format("The system of equations has infinite solutions"), title, JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null,String.format("The system of equations has no solutions"), title, JOptionPane.INFORMATION_MESSAGE);
			}
		}else{
			x = (det1/det);
			y = (det2/det);
			JOptionPane.showMessageDialog(null,String.format("The system of equations has 1 solution:\nS = (%,.2f, %,.2f)",x,y), title, JOptionPane.INFORMATION_MESSAGE);
		}


	}

	private static void thirdChoice(String title){
		double a,b,c,discriminant,x1,x2;
		JOptionPane.showMessageDialog(null,"The equation is formated to ax^2 + bx + c = 0 (a != 0)", title, JOptionPane.INFORMATION_MESSAGE);
		a = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter a: ", title, JOptionPane.INFORMATION_MESSAGE));
		b = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter b: ", title, JOptionPane.INFORMATION_MESSAGE));
		c = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter c: ", title, JOptionPane.INFORMATION_MESSAGE));
		discriminant = b*b - 4*a*c;
		if (discriminant == 0){
			JOptionPane.showMessageDialog(null,String.format("The equation has 1 solution:\nx = %,.2f",-b/(2*a)),title, JOptionPane.INFORMATION_MESSAGE);
		}else if (discriminant < 0){
			JOptionPane.showMessageDialog(null,String.format("The equation has no solution."),title, JOptionPane.INFORMATION_MESSAGE);
		}else{
			x1 = (-b+Math.sqrt(discriminant))/(2*a);
			x2 = (-b-Math.sqrt(discriminant))/(2*a);
			JOptionPane.showMessageDialog(null,String.format("The equation has 2 solution:\nx1 = %,.2f\nx2 = %,.2f",x1,x2),title, JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void main(String[] args){
		String[] options = {"1", "2", "3", "4"};
		String title = "Equation Solver";
		String message = "<html><h2>Choose your equation</h2> 1. Linear equation with one variable<br> 2. Linear equation with two variables<br> 3. Second-degree equation with one variable<br> 4. Quit<br>";
		while (true){
		int choice = JOptionPane.showOptionDialog(null, message,
					title,
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

		switch (choice){
		case 0:
			firstChoice(title);
			break;
		case 1:
			secondChoice(title);
			break;
		case 2:
			thirdChoice(title);
			break;
		case 3:
			JOptionPane.showMessageDialog(null,"Goodbye",title,JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
			break;
		default:
			System.out.println("Program error!");
			System.exit(0);
			break;
		}
		
	}
	}
}