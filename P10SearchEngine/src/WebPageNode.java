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

public class WebPageNode{
 
	/**
	 *Holds the id, webLink, leftChild, and rightChild values of a  node on a web page binary search tree 
	 */
    private final String id; 		// The id of the web page
	private final String webLink;   // The web link of the web page
    private WebPageNode leftChild;  // The leftChild of the the current WebPageNode
    private WebPageNode rightChild; // The rightChild of the the current WebPageNode

    //constructor
    public WebPageNode(String id, String webLink) {
    	this.id = id;
    	this.webLink = webLink;
    	
    } 
    
    /** 
   	 * @return the left child of the web page node
   	 * Time complexity: O(1)
   	 */
	public WebPageNode getLeftChild() {
		return leftChild;
	}
	
	/** 
	 * @param the left child node of the current web page node
	 * Time complexity: O(1)
   	 */
	public void setLeftChild(WebPageNode leftChild) {
		this.leftChild = leftChild;
	}
	
	/** 
   	 * @return the right child of the web page node
   	 * Time complexity: O(1)
   	 */
	public WebPageNode getRightChild() {
		return rightChild;
	}
	
	/** 
   	 * @param the desired right child of the web page node
   	 * Time complexity: O(1)
   	 */
	public void setRightChild(WebPageNode rightChild) {
		this.rightChild = rightChild;
	}
	
	/** 
   	 * @return the id of the WebPageNode object
   	 * Time complexity: O(1)
   	 */
	public String getId() {
		return id;
	}
	
	/** 
   	 * @return the link of the WebPageNode object
   	 * Time complexity: O(1)
   	 */
	public String getWebLink() {
		return webLink;
	}
}