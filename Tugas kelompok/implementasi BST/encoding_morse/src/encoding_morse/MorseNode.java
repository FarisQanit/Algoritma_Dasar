package encoding_morse;

public class MorseNode {
 
    /** a letter of the alphabet */
    private char letter;
    /** reference to the left child */
    private MorseNode left;
    /** reference to the right child */
    private MorseNode right;
    /** value of letter if empty (not set) */
    public static final char EMPTY = ' ';
 
    /**
     * Default constructor, actual values are set in the MorseCode constructor
     */
    public MorseNode() {
        letter = EMPTY;
        left = null;
        right = null;
    }
 
    /**
     * Gets letter contained in node
     * @return String - letter value
     */
    public char getLetter() {
        return letter;
    }
 
    /**
     * Sets letter in node
     * @param String - letter to set
     */
    public void setLetter(char letter) {
        this.letter = letter;
    }
 
    /**
     * Gets the node refrenced by left
     * @return MorseNode - left
     */
    public MorseNode getLeft() {
        return left;
    }
 
    /**
     * Sets left refrence
     * @param left - refrence to the node to set
     */
    public void setLeft(MorseNode left) {
        this.left = left;
    }
 
    /**
     * Gets the node refrenced by right
     * @return MorseNode - right
     */
    public MorseNode getRight() {
        return right;
    }
 
    /**
     * Sets right refrence
     * @param right - refrence to the node to set
     */
    public void setRight(MorseNode right) {
        this.right = right;
    }
 
}
