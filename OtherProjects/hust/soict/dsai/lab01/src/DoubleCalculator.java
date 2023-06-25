import javax.swing.JOptionPane;

public class DoubleCalculator{
	public static void main(String[] args){
		String strNum1, strNum2, message;
		double num1, num2, sum, diff, product, quotient;

		strNum1 = JOptionPane.showInputDialog(null,
			"Please input the first number",
			"Input the first number",
			JOptionPane.INFORMATION_MESSAGE);
		strNum2 = JOptionPane.showInputDialog(null,
			"Please input the second number",
			"Input the second number",
			JOptionPane.INFORMATION_MESSAGE);

		num1 = Double.parseDouble(strNum1);
		num2 = Double.parseDouble(strNum2);

		sum = num1 + num2;
		diff = num1 - num2;
		product = num1 * num2;
		quotient = num1 / num2;

		message = String.format("<html><p>The answers would be formatted in 2 decimal places.<br>Sum: %,.2f<br>Difference: %,.2f<br>Product: %,.2f<br>Quotient: %,.2f</p></html>",sum,diff,product,quotient);

		JOptionPane.showMessageDialog(null, message, "Caculator",JOptionPane.INFORMATION_MESSAGE);
		System.exti(0);
	}
}