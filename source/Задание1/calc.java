package khantova.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.EmptyStackException;
import java.util.Stack;

public class calc {	
	private String formula;
	private final String available_operators="[-+*/()]";
	
	calc(){
		setformula("");	
	}
	
	protected String getformula(){		
		return formula;	
	}
	
	protected void setformula(String str){		
		formula=str;			
	}		
	
	class WrongFormulaExeption extends Exception{
		public WrongFormulaExeption() {		
		}
    }
	
	protected void create_formula(String f_string) throws WrongFormulaExeption{	//проверка наличия в формуле неверных символов
	
		StringBuffer strBuffer = new StringBuffer(f_string.replaceAll(" ", "")); //удаляем пробелы
		if(strBuffer.length()==0) { //если строка не задана
			setformula("0"); 
			return;
		}	
		
		//поиск неверных символов
		Pattern pattern = Pattern.compile("[^0-9&&[^.]&&"+available_operators.charAt(0)+"^"+available_operators.substring(1)+"]");
	    Matcher matcher = pattern.matcher(strBuffer); 	     	    
	    if(matcher.find()) 		    	
	    	throw new WrongFormulaExeption(); 

	    //замена - и + в начале строки и (- и (+ на 0+,0-, (0- и (0+. Для правильного вычисления
	    if(strBuffer.charAt(0)=='-'||strBuffer.charAt(0)=='+') strBuffer.insert(0,"0"); 	    
	    Pattern pattern2 = Pattern.compile("\\([-+]");
	    Matcher matcher2 = pattern2.matcher(strBuffer); 		
	    while(matcher2.find())    
		    	strBuffer.insert(matcher2.start()+1,"0");  

		setformula(strBuffer.toString());		
	}
	
    protected byte GetPriority(String s){ //приоритет операторов
        switch (s){
            case "(": return 0;
            case ")": return 1;
            case "+": return 20;
            case "-": return 20;
            case "*": return 40;
            case "/": return 40;
            default: return 127;
        }
    }

    protected void count(Stack <String> stack, Stack<Double> output){ // действие согласно оператору 
	    double result=0;       
 	    double a = output.pop();	
	    switch (stack.pop()) {        
            case "+":  result = output.pop()+ a; break;
            case "-":   result = output.pop() - a; break;
            case "*":   result = output.pop() * a; break;
            case "/":  result = output.pop() / a; break;
            default: result=a; break; //если в скобках находилось только одно число
        }
 	    output.push(result);	 
    }
    
    protected void processing_end_bracket(Stack <String> stack, Stack<Double> output){	//обработка открывающей скобки                 
        while (!stack.peek().equals("(") ) //Выписываем все операторы до открывающей скобки 	
            count(stack, output);        	 
        stack.pop(); // убираем ( из стека	
    }
    
    protected void processing_operator( String operator,Stack <String> stack, Stack<Double> output ){ // обработка оператора
        //пока стек не пуст и приоритет нашего оператора меньше или равен приоритету оператора на вершине стека
        while ( (!stack.empty())&& (GetPriority(operator) <= GetPriority(stack.peek())) ) {     
        	count(stack, output);    	//считаем результат согласно последнему оператору из стека
        }
        stack.push(operator); // добавляем оператор на вершину стека   
    }
    
	protected double calculate(String  f_string) throws WrongFormulaExeption,EmptyStackException{	
		create_formula(f_string);
	    Stack<Double> output= new Stack<>();
	    Stack<String> stack = new Stack<>();	 	
	    Pattern pattern = Pattern.compile(available_operators);
	    Matcher matcher = pattern.matcher(formula); 	     
	    int previous_operator_ind=-1,current_operator_ind=-1;
	    
	    while(matcher.find()) {     //пока есть операторы в строке
	        previous_operator_ind=current_operator_ind;
	    	current_operator_ind= matcher.start(); //находим индeкс оператора	    	
	    	if((current_operator_ind-previous_operator_ind)>1){//если между двумя операторами находится число,записываем его в выход	    	       
	    	    output.push( Double.parseDouble( formula.substring(previous_operator_ind+1, current_operator_ind)));   	    	 
	    	}	    	 
	    	//обрабатываем оператор	
	    	switch(String.valueOf(formula.charAt(current_operator_ind))){
	    	    case "(":  
	    	    	stack.push(String.valueOf(formula.charAt(current_operator_ind))); //Записываем её в стек 
	    	    	break;
	            case ")":  
	            	processing_end_bracket( stack,  output);	
	            	break;	         
	            default:  
	            	processing_operator( String.valueOf(formula.charAt(current_operator_ind)),stack,  output );  
	            	break; 	    		    	
	    	}  
	    }
	     
	    if(current_operator_ind!= formula.length()-1){ // если есть не обработанное число
	        output.push( Double.parseDouble( formula.substring(current_operator_ind+1))); //записываем его в выход	        
	    }
	   // выкидываем из стека все оставшиеся операторы 
	    while (!stack.empty()){
	        count(stack, output);    
	 	}
	    
	    return output.pop();
	}
}
