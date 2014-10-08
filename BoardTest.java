import static org.junit.Assert.*;
import org.junit.Test;

public class BoardTest {

	@Test
	public void TestgetMovesAllowed() {
		Board a = new Board(5);
		assertTrue(a.getMovesAllowed()==5);
		
		Board b = new Board(6);
		assertFalse(a.getMovesAllowed() == 6); 
		
		Board c = new Board(6);
		assertTrue(a.getMovesAllowed() == 5); 
	}
	
	@Test
	public void TestsetMovesAllowed() 
	{
		Board d = new Board(6);
		d.setMovesAllowed(7);
		assertTrue(d.getMovesAllowed() == 7); 	
	}
	
	@Test
	public void TestgetMovesLeft()
	{
		// when no moves have been made
		Board e = new Board(5); 
		assertTrue(e.getMovesLeft() == 7); // is this right? 
		System.out.println(e.movesMade);
		System.out.println(e.movesLeft);
		System.out.println(e.getMovesAllowed());
		//removeSelectedDots -- modify once removeSelectedDots has been implemented

	}
	public void TestcanMakeMove()
	{
		Board a = new Board[5][5];
		a[0][0] = 1;
		a[0][1] = 2;
		a[0][2] = 3;
		a[0][3] = 4; 
		a[0][4] = 5; 

		a[1][0] = 5; 
		a[1][1] = 4; 
		a[1][2] = 3; 
		a[1][3] = 2; 
		a[1][4] = 1; 

		a[2][0] = 1; 
		a[2][1] = 2; 
		a[2][2] = 3; 
		a[2][3] = 4; 
		a[2][4] = 5; 

		a[3][0] = 5;
		a[3][1] = 4; 
		a[3][2] = 3; 
		a[3][3] = 2; 
		a[3][4] = 1;

		a[4][0] = 1;
		a[4][1] = 2; 
		a[4][2] = 3; 
		a[4][3] = 4; 
		a[4][4] = 5;

 		AssertTrue(a.canMakeMove() == false); 

 		Board b = new Board[4][4];
		a[0][0] = 1;
		a[0][1] = 2;
		a[0][2] = 3;
		a[0][3] = 4; 
		a[0][4] = 5;

		a[1][0] = 1; 
		a[1][1] = 2; 
		a[1][2] = 3; 
		a[1][3] = 4; 
		a[1][4] = 5; 

		a[2][0] = 5; 
		a[2][1] = 4; 
		a[2][2] = 3; 
		a[2][3] = 2; 
		a[2][4] = 1; 

		a[3][0] = 5;
		a[3][1] = 4; 
		a[3][2] = 3; 
		a[3][3] = 2; 
		a[3][4] = 1;
	
 		AssertTrue(a.canMakeMove() == true); 
		
	}
	
	public void isGameOver()
	{
		Board a = new Dot[5][5]; 
		
		a[0][0] = 1;
		a[0][1] = 2;
		a[0][2] = 3;
		a[0][3] = 4; 
		a[0][4] = 5; 

		a[1][0] = 5; 
		a[1][1] = 4; 
		a[1][2] = 3; 
		a[1][3] = 2; 
		a[1][4] = 1; 

		a[2][0] = 1; 
		a[2][1] = 2; 
		a[2][2] = 3; 
		a[2][3] = 4; 
		a[2][4] = 5; 

		a[3][0] = 5;
		a[3][1] = 4; 
		a[3][2] = 3; 
		a[3][3] = 2; 
		a[3][4] = 1;

		a[4][0] = 1;
		a[4][1] = 2; 
		a[4][2] = 3; 
		a[4][3] = 4; 
		a[4][4] = 5;

		a.getMovesLeft(); 
		a.canMakeMove();


	}
	
	
	
	
}