 import java.util.Scanner;
 import java.util.*;
 
/**
 * Write a description of class Morse here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Morse
{
    
    
    public static void main(String[] args)
    {            
        Scanner scan = new Scanner(System.in);
        /* Creating object of BT */
        //BinaryTree<T> bt = new BinaryTree<T>(); 
        /*  Perform tree operations  */
        System.out.println("Binary Tree Test\n");  
        
        char ch; 
        int choice;
        
        do    
        {
            System.out.println("\nBinary Tree Operations\n");
            System.out.println("1. encode ");
            System.out.println("2. decode");
            System.out.println("3. quit");
            
            choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter text to encode");
               // bt.insert( scan.nextLine() ); 
                System.out.println("Enter integer element to search");
                break;                          
            case 2 : 
                System.out.println("Enter integer element to search");
                //System.out.println("Search result : "+ bt.search( scan.nextInt() ));
                break;                                          
            case 3 : 
              //  System.out.println("Nodes = "+ bt.size());
                break;     
                      
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /*  Display tree   
            System.out.print("\nPost order : ");
            bt.postorder();
            System.out.print("\nPre order : ");
            bt.preorder();
            System.out.print("\nIn order : ");
            bt.inorder();*/
 
                                    
        } while (choice == 3);               
    }
    
    
}
