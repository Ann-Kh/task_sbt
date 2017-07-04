package khantova.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;
import khantova.calculator.calc.WrongFormulaExeption;

public class calc_frame extends JFrame {
	JPanel panel = new JPanel();
	JTextField display= new JTextField();  
	JTextField result= new JTextField();   
	JScrollPane scrollPane = new JScrollPane(display);
    JButton buttonStart = new JButton("=");
    
	calc_frame() {		   
		Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();		
	    setSize(screenSize.width/2, 130);
		setLocation(100, 100);
		setLayout(new BorderLayout());
		panel.setLayout(new BorderLayout());
		add(panel,BorderLayout.CENTER);
		panel.add(scrollPane,BorderLayout.CENTER);
		panel.add(result,BorderLayout.SOUTH);	    
	    add(buttonStart,BorderLayout.SOUTH);        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);      
	    
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {            	
            	
            	try{
            		calc Calculator= new calc();
            		result.setText(  Double.toString(Calculator.calculate(display.getText()))); 
            		}
            		catch (WrongFormulaExeption exep) {
            			result.setText( "\n неверно задана формула ");
            		}
            	    catch (EmptyStackException exep) {
        			result.setText( "\n неверно задана формула ");
        		    }    	            	
            }              
        }) ;
    }	
	
    public static void main(String[] args) {
        new calc_frame();
    }
}

