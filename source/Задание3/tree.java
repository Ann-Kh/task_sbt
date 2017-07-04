package khantova.Tree;
import java.util.ArrayList;

public class tree<T> {
	 private final Node<T> isRoot;
	 private ArrayList <Node<T>> tree_nodes ;

	    public tree(T rootData) {
	    	isRoot = new Node<T>(rootData);
	    	tree_nodes=new ArrayList<Node<T>>();
	    	addNode(isRoot);
	    }   
	    
	    public void addNode(Node n){
	    	tree_nodes.add(n);	    	
	    }
	    
	    public Node<T> getRoot(){	    	
	    	return isRoot;
	    }
	    
	    public ArrayList <Node<T>> get_all_nodes(){	    	
	    	return tree_nodes;
	    }	   
	    
	    @Override
		public int hashCode() {
	    	int hash=0;
	    	for(int i=0; i<isRoot.children.size();i++)
	    		hash=hash+(i+1)*5*(isRoot.children.get(i)).branch_length();	//считаем длину всех ветвей
			return hash;
		} 

	    public class Node<T> {
	        private T data;
	        private Node<T> parent;
	        private ArrayList<Node<T>> children;
	        
	        public Node(T data) {
	            this.data = data;
	            this.children = new ArrayList<Node<T>>();
	            this.parent=null;	            
	        }

	        public Node<T> addChild(T child) {
	            Node<T> childNode = new Node<T>(child);
	            childNode.parent = this;
	            this.children.add(childNode);
	            addNode(childNode);
	            return childNode;
	        }
	        
	        public T getdata(){	    	
		    	return data;
		    }
	        
	        public Node<T> get_parent(){	    	
		    	return parent;
		    }
	        
	        public ArrayList <Node<T>> get_children(){	    	
		    	return children;
		    }
	        
	        public int branch_length_down(){ //подсчет длины ветви вниз от ноды		    	
	        	int max_length=0; //максимальная найденная длина ветви
	        	int current_length=0;//текущая найденная длина ветви
	        	if (this.children.size()==0)return 1; //если дошли до конечной ноды
		    	for(int i=0; i<this.children.size();i++){//если есть дочерние ноды
		    		current_length=0;
		    		current_length=1+this.children.get(i).branch_length_down(); // считаем длину вниз от дочерней ноды
		    	    if(current_length>max_length) max_length=current_length;	    	    
		    	}		    	
		    	return max_length;
		    }
	        
	        
            public int branch_length_up(){//подсчет длины ветви вверх от ноды		
		    	int length_up=0;
	        	if(this.parent==null)return 0;	        	
	        		length_up=1+this.parent.branch_length_up();	        	
	        	return length_up;
		    }
	        
            public int branch_length(){//подсчет длины ветви, которой принадлежит нода    	
            	return this.branch_length_down()+this.branch_length_up();            	
            }
            
            public int compare_brunch(Node<T> n){
            	if(this.branch_length()==n.branch_length()) return 0; //если длины ветвей одинаковые
            	if (this.branch_length()>n.branch_length()) return 1;//если длина первой ветви больше
            	return -1;//если длина первой ветви меньше
            	
            }	        
	        
	    }	

}
