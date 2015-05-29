/*  Simmigon Flagg CSc 3410 4/22/2015
 * (1) The Purpose of the Program:
 * 		
 * The main purpose of this program is to be able to build and 
 * use a Binary Search Tree to sort 50 randomly-generated numbers 
 * by the help of a Linked list. The 50 random integers serves as the Infix
 * 		that needed to be sorted in a least to greatest order.
 * 			
 * (2) Solution/Algorithm
1.	Declare and initialize a Random number Object
2.	Declare and initialize a BSTree Object
3.	Declare and initialize a ArrayList Object
4.	Start a for loop the iterates from 0 to 50
5.	Add 50 random numbers to the arraylist
6.	Start a for loop the iterates from 0 to 50
7.	Print out the arraylist of integers.
8.	Add Nodes to the Binary Search Tree
9.	Call infix method with the root node as it parameter
10.	If the current node is not null infix left the print infix right
11.	Use the add a node method
12. 	Declare and initialize a new Node
13.	if root equal null assign new node to root else assign root to Node 
        object current Node Declare a Node Object parent. Start a while loop 
        and set the condition to true While true parent equal current node 
        if the key is less than the current node’s key Set the current node 
        equal to the current node left. If the current node equal null the 
        new node set the new node to the parent left return else current node
        equal the current node right. If the current node equal null set the 
        parent node on the right equal is to the new node returns

 * (3) Data Structures
 * 			
 *     - Linked list A custom Linked list was used for the main program to build the Binary Search Tree.
 *     - ArrayList was used to store the 50 randomly-generated integers.         
 * (4) Description
 * There will be 50 integers that are going to be randomly-generated 
 *      (range: 1-99) every time the program is ran.An output of sorted numbers from least to greatest will be printed tothe screen  
 */
package bstree;

import java.util.*;

public class BSTree {

    public static void main(String[] args) {
        
        Random rnumbers = new Random();
        BSTree binarytree = new BSTree();

        ArrayList<Integer> randomListOfNumber = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            randomListOfNumber.add(rnumbers.nextInt(99) + 1);
        }
        System.out.print("Unsorted random numbers:");
        for (int i = 0; i < 50; i++) {
            if (i % 10 == 0) {
                System.out.print("\n");
            }
            System.out.print(randomListOfNumber.get(i)+" ");
            binarytree.addNode(randomListOfNumber.get(i));
            
        }
        System.out.println("\nInfix:");
        binarytree.infix(binarytree.root);
        
    }    
    Node root;
    /**
     * Method: addNode() 
     * Pre-Condition: Takes on parameter of integer type
     * Post-Condition: Returns void
     */
    public void addNode(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
        } else {
            Node currNode = root;
            Node parent;
            while (true) {
                parent = currNode;
                if (key < currNode.key) {
                    currNode = currNode.left;
                    if (currNode == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    currNode = currNode.right;
                    if (currNode == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * Method: infix() 
     * Pre-Condition: Takes on parameter of Node type
     * Post-Condition: the data are sorted in infix traversal. 
     *                Returns void
     */
    public void infix(Node currNode) {
        if (currNode != null) {
            infix(currNode.left);
            System.out.println(currNode);
            infix(currNode.right);
        }
    }

    class Node {
        /**
         * Declare node object 
         * Declare integer datatype
         */
        Node left, right;
        int key;
        //Constructor
        public Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }

        /**
         * Method: toString() 
         * Pre-Condition:  Override the toString in the Object Class
         * Post-Condition: Returns a string value of sorted integer items.
         */
        public String toString() {

            String number = String.valueOf(key);
            return " " + number ;
        }

    }
}
