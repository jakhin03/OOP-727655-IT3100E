import javax.swing.JOptionPane;

public class EquationSolver{
	private static void firstChoice(String title){
		double a,b;
		JOptionPane.showMessageDialog(null,"The equation is formated to ax + b = 0");
		a = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter a: ", title, JOptionPane.INFORMATION_MESSAGE));
		b = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter b: ", title, JOptionPane.INFORMATION_MESSAGE));
		if (a == 0){
			if (b == 0){
				JOptionPane.showMessageDialog(null,"The equation has infinite solutions", title, JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null,"The solution has no solution", title, JOptionPane.INFORMATION_MESSAGE);
			}
		}
		JOptionPane.showMessageDialog(null,String.format("Result: %,.2f", -b/a), title, JOptionPane.INFORMATION_MESSAGE);

	}

	private static void secondChoice(String title){
		JOptionPane.showMessageDialog(null,"Hello");
	}

	private static void thirdChoice(String title){
		JOptionPane.showMessageDialog(null,"Hello");
	}

	public static void main(String[] args){
		String[] options = {"1", "2", "3", "4"};
		String title = "Equation Solver";
		String message = "<html><h2>Choose your equation</h2> 1. Linear equation with one variable<br> 2. Linear equation with two variables<br> 3. Second-degree equation with one variable<br> 4. Quit<br>";
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
			break;
		default:
			System.out.println("Program error!");
			break;
		}
		System.exit(0);

	}
}