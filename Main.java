package bologheanu_florin_30224_tema_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.sun.glass.events.MouseEvent;

public class Main {

	public static void main(String[] args) {
		
		JFrame window;
		JButton add, subtract, diff, integrate, mul, div;
		JTextField p1, p2;
		JRadioButton x, y;
		JPanel panel;
		ButtonGroup group;
		
		window = new Window();
		panel = new JPanel();
		x = new JRadioButton();
		y = new JRadioButton();
		add = new JButton("Add");
		subtract = new JButton("Subtract");
		diff = new JButton("Differentiate");
		integrate = new JButton("Integrate");
		mul = new JButton("Multiply");
		div = new JButton("Divide");
		group = new ButtonGroup();
		
		x.setSelected(true);
		
		p1 = new JTextField("Write a polynomial here...");
		p1.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				p1.setText("");
			}

			public void focusLost(FocusEvent arg0) {
			}
		});
		
		p2 = new JTextField("Write a polynomial here...");
		p2.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				p2.setText("");
			}

			public void focusLost(FocusEvent arg0) {
			}
		});
		
	
		group.add(x);
		group.add(y);
		
		panel.setLayout(null);
		
		panel.add(p1);
		p1.setBounds(30, 30, 500, 30);
		p1.setVisible(true);
		

		
		panel.add(p2);
		p2.setBounds(30, 80, 500, 30);
		p2.setVisible(true);
		
		panel.add(x);;
		x.setBounds(540, 30, 20, 20);
		x.setVisible(true);
		
		panel.add(y);
		y.setBounds(540, 80, 20, 20);
		y.setVisible(true);
		
		panel.add(add);
		add.setBounds(30, 120, 250, 30);
		add.setVisible(true);
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Polynomial p = new Polynomial(p1.getText());
				Polynomial q = new Polynomial(p2.getText());
				JOptionPane.showMessageDialog(null, Operations.Addition(p, q).toString(),
											 "Result", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		panel.add(subtract);
		subtract.setBounds(290, 120, 250, 30);
		subtract.setVisible(true);
		subtract.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Polynomial p = new Polynomial(p1.getText());
				Polynomial q = new Polynomial(p2.getText());
				JOptionPane.showMessageDialog(null, Operations.Subtraction(p, q).toString(),
											"Result", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		panel.add(mul);
		mul.setBounds(30, 160, 250, 30);
		mul.setVisible(true);
		mul.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Polynomial p = new Polynomial(p1.getText());
				Polynomial q = new Polynomial(p2.getText());
				JOptionPane.showMessageDialog(null, Operations.Multiplication(p, q).toString(),
											"Result", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		panel.add(div);
		div.setBounds(290, 160, 250, 30);
		div.setVisible(true);
		div.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Polynomial p = new Polynomial(p1.getText());
				Polynomial q = new Polynomial(p2.getText());
				JOptionPane.showMessageDialog(null, Operations.Division(p, q).toString(),
											"Result", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		panel.add(diff);
		diff.setBounds(30, 200, 250, 30);
		diff.setVisible(true);
		diff.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(x.isSelected() == true){
					Polynomial p = new Polynomial(p1.getText());
					JOptionPane.showMessageDialog(null, p.Differentiation().toString(),
							"Result", JOptionPane.INFORMATION_MESSAGE);
					
				}
				else{
					Polynomial q = new Polynomial(p2.getText());
					JOptionPane.showMessageDialog(null, q.Differentiation().toString(),
							"Result", JOptionPane.INFORMATION_MESSAGE);
				}
					
			}
		});
		
		panel.add(integrate);
		integrate.setBounds(290, 200, 250, 30);
		integrate.setVisible(true);
		integrate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(x.isSelected() == true){
					Polynomial p = new Polynomial(p1.getText());
					JOptionPane.showMessageDialog(null, p.Integration().toString(),
							"Result", JOptionPane.INFORMATION_MESSAGE);
					
				}
				else{
					Polynomial q = new Polynomial(p2.getText());
					JOptionPane.showMessageDialog(null, q.Integration().toString(),
							"Result", JOptionPane.INFORMATION_MESSAGE);
				}
					
			}
		});
		
		
		
		panel.setVisible(true);
		window.add(panel);
		window.setVisible(true); 

	}

}
