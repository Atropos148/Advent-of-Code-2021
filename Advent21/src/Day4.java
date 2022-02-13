import java.util.ArrayList;
import java.util.List;

public class Day4 {
	String testDrawNumbers = "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1";
	String testBoards = "22 13 17 11 0,8 2 23 4 24,21 9 14 16 7,6 10 3 18 5,1 12 20 15 19,3 15 0 2 22,9 18 13 17 5,19 8 7 25 23,20 11 10 24 4,14 21 16 12 6,14 21 17 24 4,10 16 15 9 19,18 8 23 26 20,22 11 13 6 5,2 0 12 3 7";

	List<Integer> testDrawNumbersClean = new ArrayList<>();
	List<BingoBoard> boards = new ArrayList<>();

	public void print_boards() {
		String[] numbersToPrint = testDrawNumbers.split(",");
		for (String number: numbersToPrint) {
			testDrawNumbersClean.add(Integer.parseInt(number));
		}

		for (int number: testDrawNumbersClean) {
			System.out.print(number+", ");
		}
		System.out.println();

		prepareBoards();

		for (int number: testDrawNumbersClean) {
			for (BingoBoard board: boards) {
				board.markNumber(number);
			}
		}

		for (BingoBoard board: boards) {
			board.printBoard();
			System.out.println(board.markedNumbers);
			System.out.println("---");
		}
	}

	public void prepareBoards() {
		String[] rawBoardRows = testBoards.split(",");
		int rowCounter = 0;
		BingoBoard currentBoard = null;
		for (String boardRow: rawBoardRows) {
			if (rowCounter == 0) {
				currentBoard = new BingoBoard();
				boards.add(currentBoard);
			}
			currentBoard.addRow(boardRow);
			rowCounter++;
			if(rowCounter == 5) {
				rowCounter = 0;
			}
		}
	}
}
