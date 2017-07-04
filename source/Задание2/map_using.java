package khantova.figures_model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class map_using {
		
	map_using(){		
	};
	
	public class figure_map_frame extends JFrame{
		JTextArea display= new JTextArea();
		
		figure_map_frame(){			
		    Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();		
		    setSize(screenSize.width/2, screenSize.height/2);
		    setLocation(100, 100);
		    setLayout(new BorderLayout());
	        add(display, BorderLayout.CENTER);	    
	        display.setText("");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
	        setVisible(true);	 
		}
	}
	
	protected void do_stuff(){
		figure_map_frame frame= new figure_map_frame();
		
		circle circ_1=new circle();
		frame.display.append(" создали круг1, радиус 1 (конструктор по умолчанию) \n") ;
		circle circ_2=new circle(2);
		frame.display.append(" создали круг2, радиус 2 \n") ;
		quadrate quad_1=new quadrate(3);
		frame.display.append(" создали квадрат1, длина стороны 3 \n") ;
		triangle tr_1=new triangle(2,3,90);
		frame.display.append(" создали треугольник1, длины сторон 2, 3 и угол между ними 90 \n") ;
		triangle tr_2=new triangle(3,2,90);
		frame.display.append(" создали треугольник2, длины сторон 3,2 и угол между ними 90 \n") ;
		
		frame.display.append("\n сравнили треугольник1 и треугольник2:  ") ;
		if (tr_1.equals(tr_2)) frame.display.append("треугольники равны \n") ;
		else frame.display.append(" треугольники не равны \n") ;
		
		frame.display.append(" сравнили квадрат1 и квадрат,со стороной 5:  ") ;
		if (quad_1.equals(new quadrate(5))) frame.display.append(" равно \n") ;
		else frame.display.append(" не равно \n") ;

		
		HashMap<FigureKey,figure> hashmap= new HashMap<FigureKey,figure>();		
		hashmap.put(new FigureKey(circ_1), circ_1);
		hashmap.put(new FigureKey(circ_2), circ_2);
		hashmap.put(new FigureKey(quad_1), quad_1);
		hashmap.put(new FigureKey(tr_1), tr_1);
		frame.display.append("\n создали hashmap и положили круг1,круг2,квадрат1 и треугольник1 \n") ;
		
		frame.display.append(" проверяем hashmap на пустоту: ") ;		
		if (hashmap.isEmpty()) frame.display.append("hashmap пуст \n") ;
		else frame.display.append("hashmap не пуст \n") ;
		
		frame.display.append(" проверка наличия в hashmap круг1: ") ;	
		if (!hashmap.containsValue(circ_2)) frame.display.append(" нет объекта \n") ;
		else frame.display.append("объект есть \n\n") ;		
		
		ArrayList key_list = new ArrayList(hashmap.keySet());		
		figure delete_fig=hashmap.get(key_list.get(0));
		frame.display.append(" удалили фигуру по ключу \n проверяем наличие удаленной фигуры по ключу:  "); 
		hashmap.remove(key_list.get(0));
		if (!hashmap.containsValue(delete_fig)) frame.display.append(" нет объекта \n") ;
		else frame.display.append(" объект есть \n\n") ;
		
		frame.display.append(" выводим фигуры hashmap  \n") ;
		for(int i=0;i<key_list.size();i++){
		    if (hashmap.get(key_list.get(i)) instanceof circle){
		    	frame.display.append(" круг:  ") ;
		    	frame.display.append( " радиус "+Double.toString(((circle) hashmap.get(key_list.get(i))).GetRadius())+"\n" );
			}	
		
		    if (hashmap.get(key_list.get(i)) instanceof quadrate){
		    	frame.display.append(" квадрат: ") ;
		    	frame.display.append(" длина стороны  "+  Double.toString(((quadrate) hashmap.get(key_list.get(i))).GetSide()) +"\n");
		    }	
		    if (hashmap.get(key_list.get(i)) instanceof triangle){
		    	frame.display.append(" треугольник: длины сторон ") ;
		    	frame.display.append(Double.toString(((triangle) hashmap.get(key_list.get(i))).GetSide_1())+"   " );
		    	frame.display.append(Double.toString(((triangle) hashmap.get(key_list.get(i))).GetSide_2())+"   " );
		    	frame.display.append(Double.toString(((triangle) hashmap.get(key_list.get(i))).GetSide_3())+"   " );		    
		    }	
		}			
	}
	
	public static void main(String[] args) {			
		map_using m_u=new map_using();
		m_u.do_stuff();		

	}

}
