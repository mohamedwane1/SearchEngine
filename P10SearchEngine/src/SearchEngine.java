//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Search Engine
// Files:           WebPageNode.java, SearchEngine.java
// Course:          300, spring, 2018
//
// Author:          Mohamed Wane
// Email:           wane@wisc.edu
// Lecturer's Name: Mouna
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates 
// strangers, etc do.  If you received no outside help from either type of 
// source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.ArrayList;
import java.util.Scanner;

public class SearchEngine {
	
	/**
	 * a web search engine with the structure of a binary search tree.
	 * Allows the user to insert new web pages into the search tree as well as find the amount of  
	 * web pages. Can also put all of the web pages inside of an ArrayList in alphabetical order.
	 */
    private WebPageNode root; // root of the BST-based search engine
    
    public SearchEngine() {
    	root = null;
    }; // creates an empty search engine
	
    /** 
     * checks if there are any nodes in the binary search tree
   	 * @return true if the root is empty and false if there is already a null at the root
   	 * Time complexity: O(1)

   	 */
	public boolean isEmpty() {
		return root == null;
		// returns true if the search engine is empty, false otherwise.

	}
    
	/**
	 *inserts an instance of WebPageNode with the given id and 
	 *weblink into the search engine conforming to the search order property of a BST.
	 *This method throws an exception if the user tries to 
	 *insert an entry with a duplicate id.
	 * @param the id of the web page
	 * @param the link of the web page 
	 * Time complexity: O(N log(N)

   	 */
    public void insert(String id, String webLink) {
    	if (isEmpty()) { //if the tree is empty the node becomes the root of the tree
    		root = new WebPageNode(id, webLink);
    	}
    	else { //otherwise the node is placed in the correct leaf based on its  id
    		insertHelper(id, webLink, root);
    	}
    }
    	
    /**
     * 
     * @param the id
     * @param the link of the web page
     * @param the current node in the binary search tree
     * Time complexity: O(N Log(N))
     */
    private void insertHelper(String id, String webLink, WebPageNode node) {
    	if (id.compareTo(node.getId()) < 0) { //if the id has lower priority than the current node
    		if (node.getLeftChild() == null) { //if the node doesn't have a left child
    			//the new node becomes its left child
    			node.setLeftChild(new WebPageNode(id, webLink));
    		}
    		else { //otherwise,
    			//the method is called on the leftChild
    			insertHelper(id, webLink, node.getLeftChild());
    		}
    	}
    	else if (id.compareTo(node.getId()) > 0) { //if the id has higher priority than the current node
    		if (node.getRightChild() == null) { //if the node doesn't have a right child
    			node.setRightChild(new WebPageNode(id, webLink)); //the new node becomes the right child
    		}
    		else {//otherwise,
    			//the method is called on the right child
    			insertHelper(id, webLink, node.getRightChild());
    		}
    	}
    	else { //if the id is equal to the current node
    		throw new IllegalArgumentException("WARNING! Duplicate entry "  //throw an exception
					+ id + " already present."); // because of duplicate entry
    	}
    }
    
    /**
     *A look-up method that 
     *searches for a webPageNode with the given id in the current
     *search engine and returns 
     * @param the id of the WebPageNode object
     * @return the related weblink if that webPageNode 
     *is present. Otherwise, a Warning message starting with 
     *"No web link found for the web page <id>".
     * Time complexity: O(N log(N))
     */
    public String searchWebPage(String id) {
    	if (isEmpty()) {//if the tree is empty display the warning message
    		return "No web link found for the web page" + id + ".";
    	}
    	else {//otherwise start search at the root
    		return searchHelper(id, root);
    	}
    }
    
    /**
     * 
     * @param the id of the webPage the user is looking for
     * @param the current node in the binary search tree
     * @return the related weblink if that webPageNode 
     *is present. Otherwise, a Warning message starting with 
     *"No web link found for the web page <id>". 
     * Time complexity: O(N log(N))
     */
    private String searchHelper(String id, WebPageNode node) {
    	if (node == null) { //if the node doesn't exist display the warning message
    		return "No web link found for the web page" + id + ".";
    	}
    	else if (id.equals(node.getId())) { //if the node is found, display the weblink
    		return node.getWebLink();
    	}
    	else if (id.compareTo(node.getId()) < 0) { //if the node has less priority than
    		//the current node go down it's left branch
    		return searchHelper(id, node.getLeftChild());
    	}
    	else { //otherwise go down the right branch
    		return searchHelper(id, node.getRightChild());
    	}
    }
    	
    /**
     * counts up all of the nodes in the binary tree
     * @return the number of nodes in the tree
     * Time complexity: O(N log(N))
     */
    public int getWebPageCount() {
    	ArrayList<String> webPages = new ArrayList<String>();//creates an empty arrayList that
    														//will store all of the nodes in the tree
    	int count = 0; //creates an Integer that will store the amount of nodes in the tree
    	if (isEmpty()) {//if the tree is empty, return 0
    		return count;
    	}
    	else { //otherwise, traverse the tree and return the size of the arrayList 
    		traverseTree(root, webPages);
    		count = webPages.size();
    		return count;
    	}
    }
    
    /**
     * @return an ArrayList 
     * of String that stores all the id fields of the webPageNodes
     * present in the current search engine, sorted in alphabetical 
     * order from left to right.
     * Time complexity: O(N log(N))
     */
    public ArrayList<String> getAllWebPages(){
    	ArrayList<String> webPages = new ArrayList<String>(); //creates an empty arrayList that will
    														//store all of the nodes in alphabetical order
    	if (isEmpty()) { //if tree is empty
    		return webPages; //returns null;
    	}
    	else {//otherwise traverse the tree and return the arrayList
    		traverseTree(root, webPages);
    		return webPages; 
    	}
    }
    
    /**
     * traverses the tree "in order" and adds nodes from lowest to greatest to
     * the arrayList
     * @param the current node in the tree
     * @param the arrayList that will store all of the nodes
     * Time complexity O(N log(N))
     */
    private void traverseTree(WebPageNode node, ArrayList<String> webPages) {
    	if (node.getLeftChild() != null && !webPages.contains(node.getLeftChild())) {
    		//if the node has a left child that has not yet been visited, visit the left child
    		traverseTree(node.getLeftChild(), webPages);
    	}
    	if (!webPages.contains(node)) { //otherwise, if the current node has not yet been visited, 
    		//add it to the arrayList
    		webPages.add(node.getId());
    	}
    	
    	if (node.getRightChild() != null && !webPages.contains(node.getRightChild())) {//otherwise,
    		//if the node has a rightChild that has not yet been visited, visit the right child
    		traverseTree(node.getRightChild(), webPages);
    	}
    	return; //once you've reached a leaf or visited all of the node's children, 
    	//return to the previous node
    }
    
    /**
	 * @param args
	 */
	public static void main(String[] args) {
		SearchEngine engine = new SearchEngine(); //creates a new object of SearchEngine
		Scanner sc = new  Scanner(System.in); //creates a new scanner which we will use for user input
		String input = ""; //will store the user input
		 while (!input.equals("q")) { //will the user hasn't entered "q" to end the programm
			System.out.println();
			System.out.println("=========================== Search Engine ============================");
			System.out.println("1. Enter 'i <id> <webLink>' to insert a web page in the search engine");
			System.out.println("2. Enter 's <id>' to search a web link in the search engine");
			System.out.println("3. Enter 'p' to print all the web page ids in the search engine");
			System.out.println("4. Enter 'c' to get the count of all web pages in the search engine");
			System.out.println("5. Enter 'q' to quit the program");
			System.out.println("======================================================================");
			System.out.println("");
			System.out.print("Please enter your command:");
			input = sc.next().toLowerCase(); //the next input is taken in as the command 
			if (input.equals("i")) { //if user entered i
				String id = sc.next(); //the next input is taken as the id
				String webLink = sc.next();//the one after that is taken as the webLink
				engine.insert(id, webLink); //the new WebPageNode is added to the BST
			}
			else if (input.equals("s")) { //if the user entered s
				String id = sc.next(); //the next input is taken as the  id
				if (id.equals("")) {//if blank id was entered display warning message
					System.out.println("WARNING: Invalid syntax for search operation: Id link can't be blank!");
				}
				else { //otherwise, display "<id> - <webLink>"
					System.out.println(id + " - " + engine.searchWebPage(id));
				}
			}
			else if (input.equals("p")) { //if the user entered p
				System.out.println(engine.getAllWebPages().toString().replace("[", "").replace("]", ""));
				//print the ArrayList without starting and ending brackets
			}
			else if (input.equals("c")) { //if the  user entered c
				System.out.println(engine.getWebPageCount());
				//print the amount of elements in the tree
			}
			else if (input.equals("q")) { //if the user entered q
				break;
				//break out of the loop
			}
			else { //if any other input is entered display warning message
				System.out.println("WARNING: Unrecognized command.");
			}
		}
	}

}
