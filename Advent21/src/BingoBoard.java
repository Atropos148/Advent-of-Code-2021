import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class BingoBoard {
	private int rowsCounter = 0;
	List<int[]> rows = new ArrayList<>();
	public List<Point> markedNumbers = new ArrayList<>();
	private List<Integer> markedNumberList = new ArrayList<>();

	public void addRow(String row) {
		if (rowsCounter < 5) {
			rowsCounter++;
			String[] rowNumbers = row.split(" ");
			int[] cleanRowNumbers = new int[5];
			for (int i=0; i < cleanRowNumbers.length; i++) {
				cleanRowNumbers[i] = Integer.parseInt(rowNumbers[i]);
			}
			rows.add(cleanRowNumbers);
		} else {
			System.out.println("Board already has 5 rows");
		}
	}

	public void printBoard() {
		for (int[] row: rows) {
			for (int number: row){
				System.out.print(number+" ");
			}
			System.out.println();
		}
	}

	public void markNumber(int number) {
		for (int y = 0; y<rows.size(); y++) {
			for (int x=0; x<rows.get(y).length; x++){
				if (rows.get(y)[x] == number){
					markedNumbers.add(new Point(x,y));
					markedNumberList.add(number);
				}
			}
		}
	}
}
