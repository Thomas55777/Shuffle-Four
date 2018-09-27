package thomasWilliams.ShuffleFour;

public class GridID {
	private float fltLineSpacing;
	private int[] aryGridID;
	private float[] aryGridX;
	private float[] aryGridY;
	private int[][] aryCirclePosition;
	private int[] aryGridColors;
	private int[][] aryGridToWin;

	public GridID(SetLevelState setLevelState, float fltLineSpacing, float fltLeftBound, float fltUpperBound) {
		this.fltLineSpacing = fltLineSpacing;

		aryGridID = new int[setLevelState.getGridSize() * setLevelState.getGridSize()];
		aryGridX = new float[setLevelState.getGridSize() * setLevelState.getGridSize()];
		aryGridY = new float[setLevelState.getGridSize() * setLevelState.getGridSize()];
		aryCirclePosition = new int[setLevelState.getTotalCircles()][2];

		// Set the GridID and X Y coordinates incrementing left to right 
		for (int i = 0; i < aryGridID.length; i++) {
			aryGridID[i] = i;
			aryGridX[i] = fltLeftBound + ((i % setLevelState.getGridSize()) * fltLineSpacing);
			aryGridY[((i % setLevelState.getGridSize()) * setLevelState.getGridSize()) + (i / setLevelState.getGridSize())] = fltUpperBound + ((i % setLevelState.getGridSize()) * fltLineSpacing);
		}
		
		// Calculate the needed color in the needed GridID to win
		int[] aryGridRed = new int[setLevelState.getGridSize() - 2];
		int[] aryGridBlue = new int[setLevelState.getGridSize() - 2];
		int[] aryGridYellow = new int[setLevelState.getGridSize() - 2];
		int[] aryGridGreen = new int[setLevelState.getGridSize() - 2];

		for (int i = 0; i < aryGridRed.length; i++) {
			aryGridRed[i] = (i + 1) * setLevelState.getGridSize();
			aryGridYellow[i] = aryGridRed[i] + setLevelState.getGridSize() - 1;
		}
		for (int i = 0; i < aryGridBlue.length; i++) {
			aryGridBlue[i] = i + 1;
			aryGridGreen[i] = (i + 1) + (setLevelState.getGridSize() * (setLevelState.getGridSize() - 1));
		}
		
		aryGridToWin = new int[4][setLevelState.getGridSize() - 2];
		for (int i = 0; i < setLevelState.getGridSize() - 2; i++) {
			aryGridToWin[0][i] = aryGridRed[i];
			aryGridToWin[1][i] = aryGridBlue[i];
			aryGridToWin[2][i] = aryGridYellow[i];
			aryGridToWin[3][i] = aryGridGreen[i];
		}
	}

	public int getIntWin() {
		int[][] aryGridToWin = getGridToWin(); // [Color][Position]
		int[][] aryCirclePosition = getCirclePosition(); // [GridID][Color]
		for (int i = 0; i < aryGridToWin.length; i++) {

		}

		int intWin = 0;
		for (int[] intPos : aryCirclePosition) {
			// Loop through all the Winning Colors for each Circle and see if they are in the Winning Positions
			if (intPos[1] == 1)
				for (int intRed : aryGridToWin[0]) {
					if (intPos[0] == intRed)
						intWin++;
				}
			else if (intPos[1] == 2)
				for (int intBlue : aryGridToWin[1]) {
					if (intPos[0] == intBlue)
						intWin++;
				}
			else if (intPos[1] == 3)
				for (int intYellow : aryGridToWin[2]) {
					if (intPos[0] == intYellow)
						intWin++;
				}
			else if (intPos[1] == 4)
				for (int intGreen : aryGridToWin[3]) {
					if (intPos[0] == intGreen)
						intWin++;
				}
		}
		return intWin;
	}
	
	public void setCirclePosition(int intCircleID, int intGridID) {
		aryCirclePosition[intCircleID][0] = intGridID;
	}

	public void setCirclePositionColor(int intCircleID, int intColor) {
		aryCirclePosition[intCircleID][1] = intColor;
	}

	public void setGridPositionColor(int[] aryColors){
		aryGridColors = aryColors;
	}

	public int getGridID(float fltTouchX, float fltTouchY) {
		for (int i = 0; i < aryGridID.length; i++) {
			if (fltTouchX >= aryGridX[i] && fltTouchX <= aryGridX[i] + fltLineSpacing)
				if (fltTouchY >= aryGridY[i] && fltTouchY <= aryGridY[i] + fltLineSpacing)
					return aryGridID[i];
		}
		return -1;
	}

	public float getGridX(int ID) {
		return aryGridX[ID];
	}

	public float getGridY(int ID) {
		return aryGridY[ID];
	}

	public int[][] getCirclePosition() {
		return aryCirclePosition;
	}
	public int[] getGridColors(){
		return aryGridColors;
	}
	public int[][] getGridToWin() {
		return aryGridToWin;
	}
}
