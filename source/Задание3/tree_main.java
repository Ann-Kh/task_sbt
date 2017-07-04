package khantova.Tree;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class tree_main {
	
	tree_main(){		
	}
	
	public class tree_frame extends JFrame{
		JTextArea display= new JTextArea();		
		JTextArea display_tree= new JTextArea();
		tree_frame(){			
		    Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();		
		    setSize(screenSize.width/2+200, screenSize.height/2+200);
		    setLocation(100, 100);
		    setLayout(new BorderLayout());
	        add(display, BorderLayout.CENTER);	    
	        display.setText("");	         	      
			add(display_tree, BorderLayout.NORTH);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
		    setVisible(true);
			
		}
	}

	public static  tree create_tree(){ //создаем дерево
		tree<Integer> MyTree= new tree(1);
		MyTree.getRoot().addChild(2);	
		MyTree.getRoot().addChild(3);		
		(MyTree.get_all_nodes()).get(1).addChild(4);
		(MyTree.get_all_nodes()).get(3).addChild(5);
		(MyTree.get_all_nodes()).get(3).addChild(6);
		(MyTree.get_all_nodes()).get(5).addChild(7);
		(MyTree.get_all_nodes()).get(2).addChild(8);
		 MyTree.getRoot().addChild(9);
		(MyTree.get_all_nodes()).get(8).addChild(10);
		(MyTree.get_all_nodes()).get(9).addChild(11);		
		return MyTree;		
	}
	
	public void do_stuff(){
		tree<Integer> MyTree=create_tree();
		tree_frame frame=new tree_frame();
		
		//выводим дерево		
		frame.display_tree.append("  root node"+(MyTree.getRoot().getdata()));
		for(int i=1; i<MyTree.get_all_nodes().size();i++){
			frame.display_tree.append("\n  node "+(MyTree.get_all_nodes().get(i).getdata()));//печатаем  ноду
			frame.display_tree.append(" parent "+(MyTree.get_all_nodes().get(i).get_parent().getdata())); //печатаем родителя
    	}	

		frame.display.append("\n максимальная длина ветви в дереве = " +(MyTree.getRoot()).branch_length() );		
		frame.display.append("\n длина ветви,которой принадлежит нода 4  = " +((MyTree.get_all_nodes()).get(3)).branch_length() );
		frame.display.append("\n длина ветви,которой принадлежит нода 8  = " +((MyTree.get_all_nodes()).get(7)).branch_length() );
		frame.display.append("\n длина ветви,которой принадлежит нода 11  = " +((MyTree.get_all_nodes()).get(10)).branch_length() );
		
		frame.display.append("\n\n сравнение ветвей ");
		
		frame.display.append("\n сравнение ветви,которой принадлежит нода 3 и  ветви,которой принадлежит нода 10 ");		
		switch( (MyTree.get_all_nodes()).get(2).compare_brunch(  (MyTree.get_all_nodes()).get(9)) ){
		    case 0: frame.display.append("\n ветвь ноды 3 равна ветви ноды 10") ; break;
		    case 1: frame.display.append("\n ветвь ноды 3 больше ветви ноды 10") ; break;
		    case -1: frame.display.append("\n ветвь ноды 3 меньше ветви ноды 10") ; break;		
		}
		
		frame.display.append("\n сравнение ветви,которой принадлежит нода 7 и  ветви,которой принадлежит нода 11");		
		switch( (MyTree.get_all_nodes()).get(6).compare_brunch(  (MyTree.get_all_nodes()).get(10)) ){
		    case 0: frame.display.append("\n ветвь ноды 7 равна ветви ноды 11") ; break;
		    case 1: frame.display.append("\n ветвь ноды 7 больше ветви ноды 11") ; break;
		    case -1: frame.display.append("\n ветвь ноды 7 меньше ветви ноды 11") ; break;		
		}
		
		frame.display.append("\n сравнение ветви,которой принадлежит нода 5 и  ветви,которой принадлежит нода 9");		
		switch( (MyTree.get_all_nodes()).get(4).compare_brunch(  (MyTree.get_all_nodes()).get(8)) ){
		    case 0: frame.display.append("\n ветвь ноды 5 равна ветви ноды 9") ; break;
		    case 1: frame.display.append("\n ветвь ноды 5 больше ветви ноды 9") ; break;
		    case -1: frame.display.append("\n ветвь ноды 5 меньше ветви ноды 9") ; break;		
		}		
		
		frame.display.append("\n\n хэш дерева " +MyTree.hashCode() );
	}
	
	public static void main(String[] args) {	
		tree_main m_t=new tree_main();
		m_t.do_stuff();	
	}

}
