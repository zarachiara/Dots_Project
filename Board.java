import java.awt.Point;
import java.util.ArrayList;

public class Board {
	
	@SuppressWarnings("serial")
    public class CantRemoveException extends Exception {
    	public CantRemoveException() {
    		super();
    	}
    	
    	public CantRemoveException (String message) {
    		super(message);
    	}
	}

	// Our representation of the board, where myBoard[0][0] represents 
    // the bottom left dot.
    private Dot[][] myBoard;
    // Total number of moves allowed for a single game session.
    private static int movesAllowed = 5;

    // DO NOT MODIFY
    public static final int MINSIZE = 4;
    public static final int MAXSIZE = 10;
    
    public int movesLeft = movesAllowed;
    public int movesMade;
    public int[] recentx = new int[3]; //values of recent dots x value, oldest to newest
    public int[] recenty = new int[3]; //values of recent dots y value, oldest to newest
    public int selected;
    

    /**
     * Sets up the board's data and starts up the GUI. N is side length of the
     * board. (Number of dots per side) N will default to 0 if a non-integer is
     * entered as an argument. If there are no arguments, N will default to 10;
     */
    public static void main(String[] args) {
        int n = 0;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            n = 0;
        } catch (IndexOutOfBoundsException e) {
            // This line is run if no command line arguments are given.
            // If you wish to modify this line to test, remember to change it back to 
            // n = 10;
            n = 10;
        }
        GUI.initGUI(n);
    }

    /*
        CONSTRUCTORS
    */

    /**
     * When the New Game button is clicked, a new randomized board is constructed.
     * Sets up the board with input SIZE, such that the board's side length is SIZE.
     * Note: The Board is always a square, so SIZE is both the length and the width.
     * Generate a random board such that each entry in board is a random color. 
     * (represented by an int). Should print and error and System.exit if the size 
     * is not within the MINSIZE and MAXSIZE. This constructor will only be called 
     * once per game session. Initialize any variables if needed here.
     */
    public Board(int size) {
    	// YOUR CODE HERE
    	if (size >= MINSIZE && size <= MAXSIZE) {
    		myBoard = new Dot[size][size];
    		for(int i = 0; i < size; i++)
    		{
    		    for(int j = 0; j < size; j++)
    		     {
    		       myBoard[i][j] = new Dot();
    		     }
    		}
    	} else {
    		System.err.println("Input is not within size constraints");
    		System.exit(1);
    	}
    }
    
    /**
     * This constructor takes in a 2D int array of colors and generates a preset board
     * with each dot matching the color of the corresponding entry in the int[][] 
     * arguement. This constructor can be used for predetermined tests.
     * You may assume that the input is valid (between MINSIZE and MAXSIZE etc.) 
     * since this is for your own testing.
     */
    public Board(int[][] preset) {
    	// YOUR CODE HERE
    	myBoard = new Dot[preset.length][preset[0].length];
    }
    
    /**
     * Returns the array representation of the board. (Data is used by GUI).
     */
    public Dot[][] getBoard() {
    	return myBoard;
    }

    /**
     * Returns the number of moves allowed per game. This value should not
     * change during a game session.
     */
    public static int getMovesAllowed() {
        // YOUR CODE HERE
        return movesAllowed;
        }

    /**
     * Change the number of moves allowed per game. This method can be used for 
     * testing.
     */
    public static void setMovesAllowed(int n) {
        // YOUR CODE HERE
    	movesAllowed = n;
    }

    /** Returns the number of moves left. */
    public int getMovesLeft() {
        // YOUR CODE HERE
    	movesLeft -= movesMade;
    	return movesLeft;
    }

    /**
     * Return whether or not it is possible to make a Move. (ie, there exists
     * two adjacent dots of the same color.) If false, the GUI will report a
     * game over.
     */
    public boolean canMakeMove() {
    	// YOUR CODE HERE
    	for (int x = 0; x < myBoard.length; x++) {
    		for (int y = 0; y < myBoard.length; y++) {
    			if (myBoard[x][y].getColor() == myBoard[x+1][y].getColor()){
    				return true; //horizontal 
    			} else if (myBoard[x][y].getColor() == myBoard[x][y+1].getColor()){
    				return true; // vertical 
    			}
    		}
    	}
        return false;
    }

    /**
     * Returns if the board is in a state of game over. The game is over if there
     * are no possible moves left or if the player has used up the maximum
     * allowed moves.
     */
    public boolean isGameOver() {
    	// YOUR CODE HERE
    	if (this.getMovesLeft() == 0 || this.canMakeMove() == false) {
    		return true;
    	}
        return false;
    }

    
    /**
     * Returns whether or not you are allowed to select a dot at X, Y at the
     * moment. Remember, if the game is over, you cannot select any dots.
     */
    public boolean canSelect(int x, int y) {
        // YOUR CODE HERE
    	if (isGameOver()) { // If the game is over, then no dots can be selected.
    		return false;
    	} else {
            if (selected == 0) // if not selected and game is not over
    		  return true;
            }
            else if 
            {


            }
    	}
    	
    	Dot selectedDot = myBoard[x][y];
    	Dot recentDot = myBoard[recentx[2]][recenty[2]];
    	
    	for (int i = 0; i < 2; i++) {
    		if (recentx[i] == x && recenty[i] == y) {
    			if (x == 0 && y == 0 && selected < 3) {
    				return true;
    		}
    			return false;
			}
    	}
    	
    	if ((x == recentx[2] + 1 || x == recentx[2] - 1) && y == recenty[2]) {
    		if (selectedDot.getColor() == recentDot.getColor()) {
    			return true;
    		} else {
    			return false;
    		}
    	} else if ((y == recenty[2] + 1 || y == recenty[2] - 1) && x ==recentx[2]) {
    		if (selectedDot.getColor() == recentDot.getColor()) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    	return false;
	}
     
    /**
     * Is called when a dot located at myBoard[X][Y] is selected on the GUI.
     */
    public void selectDot(int x, int y) {
        // YOUR CODE HERE
    	if (canSelect(x, y)) {
    		for (int i = 0; i < 2; i++){
    			recentx[i] = recentx[i + 1];
    			recenty[i] = recenty[i + 1];
    		}
    		recentx[2] = x;
    		recenty[2] = y;
    		selected++;
    	}
    	System.out.println(selected);
    }

    /**
     * Checks if you are allowed to deselect the chosen point.
     * Assumes at least one point has been selected already.
     * You can only deselect the most recent point you have selected.
     * (You can select 3 dots and deselect them in reverse order.)
     */
    public boolean canDeselect(int x, int y) {
    	// YOURE CODE HERE
    	if (canSelect(x,y) == false) {
    		if (x == recentx[2] && y == recenty[2]) {
    			return true;
    		}
    	}
    	return false;
    }
    	
    /**Is called when a dot located at myBoard[X][Y] is deselected on the GUI. */
    public void deselectDot(int x, int y) {
        // YOUR CODE HERE
    	if (canDeselect(x, y)) {
    		for (int i = 2; i > 0; i--){
    			recentx[i] = recentx[i - 1];
    			recenty[i] = recenty[i - 1];
    		}
    		selected--;
    	}
    	System.out.println(selected);
    }

    /**Returns the number of currently selected dots */
    public int numberSelected() {
    	// YOUR CODE HERE
    	return selected;
    }

    
    /**
     * Is called when the "Remove" button is clicked. Puts all selected dots in
     * a "removed" state. If no dots should be removed, throw a CantRemoveException. 
     * You must also create your own Exception Class named CantRemoveException.
     * If selected dots form a closed shape, remove all dots on the board that have
     * the same color as the selected dots.
     */
    public void removeSelectedDots() throws CantRemoveException {
    	// YOUR CODE HERE
    	if (isClosedShape() == true) {
    		
    	}
//    	try {
//    		
//    	} catch (CantRemoveException e) {
//    		
//    	}
    	
    	
    	movesMade++;
    }

    /**
     * Puts the dot at X, Y in a removed state. Later all dots above a
     * removed dot will drop.
     */
    public void removeSingleDot(int x, int y) {
        // OPTIONAL
    }

    /**
     * Return whether or not the selected dots form a closed shape. Refer to
     * diagram for what a closed shape looks like.
     */
    public boolean isClosedShape() {
    	// YOUR CODE HERE
    	return false;
    }

    /**
     * Removes all dots of the same color of the dots on the currently selected
     * dots. Assume it is confirmed that a closed shape has been formed from the
     * selected dots.
     */
    public void removeSameColor() {
    	// OPTIONAL
    }

    /**
     * Once the dots are removed. Rearrange the board to simulate the dropping of
     * all of the dots above the removed dots. Refer to diagram in the spec for clarity.
     * After dropping the dots, there should exist some "bad" dots at the top. 
     * (These are the blank dots on the 4-stage diagram.)
     * fillRemovedDots will be called immediately after this by the GUI so that random 
     * dots replace these bad dots with new ones that have a randomly generated color.
     */
    public void dropRemainingDots() {
    	// YOUR CODE HERE
    }

    /**
     * After removing all dots that were meant to be removed, replace any
     * removed dot with a new dot of a random color.
     */
    public void fillRemovedDots() {
        // YOUR CODE HERE
    }

    /**
     * Return the current score, which is called by the GUI when it needs to
     * update the display of the score. Remember to update the score in your 
     * other methods.
     */
    public int getScore() {
    	// YOUR CODE HERE
        return 0;
    }

    /**
     * Search the board for a sequence of 4 consecutive points which form a
     * square such that out of all possible 2x2 squares, selecting this one 
     * yields the most points.
     */
    public ArrayList<Point> findBestSquare() {
        // YOUR CODE HERE
        return null;
    }

    /**Prints the the board any way you like for testing purposes. */
    public void printBoard() {
        // OPTIONAL
    }

    public void printBoard(String msg) {
    	System.out.println(msg);
    	printBoard();
    }
}
