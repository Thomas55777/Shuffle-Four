package thomasWilliams.ShuffleFour;


public class GridDimensions {

	private int intColor;
	private float fltX;
	private float fltY;
	private int intCircleID;
	private GridID gridID;
	private float fltLineSpacing;
	private boolean booLevelWon;
	private SetLevelState setLevelState;

	public GridDimensions(GameView gameView, SetLevelState setLevelState, int intCircleID, GridID gridID) {
		this.intCircleID = intCircleID;
		this.fltLineSpacing = gameView.getFltLineSpacing();
		this.gridID = gridID;
		this.setLevelState=setLevelState;
		
		SetLevelParamaters setLevelParamaters = new SetLevelParamaters(setLevelState);
		
		int[] aryCircleColors = setLevelParamaters.getCircleColors();
		intColor = aryCircleColors[intCircleID];
		// Set the Color Properties to Each Circle. This Property will never change throughout the Entire Level and will only get set here.
		gridID.setCirclePositionColor(intCircleID, intColor);

		// Convert the ColorID to the AppConfig Color
		int[] aryColor = setLevelParamaters.getCircleColorSet();
		intColor = aryColor[intColor];

		// Set the beginning Position for the Circle
		int[] aryCirclePos = setLevelParamaters.getCirclePositions();
		fltX = gridID.getGridX(aryCirclePos[intCircleID]);
		fltY = gridID.getGridY(aryCirclePos[intCircleID]);
		SnapToGrid();
	}

	public int getColor() {
		return intColor;
	}

	public float getX() {
		return fltX;
	}

	private float CircleOutOfBounds(float fltNewPoint, int intAryMin, int intAryMax) {
		float fltOverBounds = ((fltLineSpacing / 2) * AppConfig.fltOverlapPct) - 3;

		if (fltNewPoint < FindMovableGrid()[intAryMin] - fltOverBounds)
			fltNewPoint = FindMovableGrid()[intAryMin] - fltOverBounds;
		else if (fltNewPoint > FindMovableGrid()[intAryMax] + fltOverBounds)
			fltNewPoint = FindMovableGrid()[intAryMax] + fltOverBounds;

		return fltNewPoint;
	}

	public void setX(float fltNewX) {
		// Dont let Circle outside Grid
		fltNewX = CircleOutOfBounds(fltNewX, 0, 2);

		// Only move max of LineSpacing
		if (fltNewX > fltX + fltLineSpacing)
			fltNewX = fltX + fltLineSpacing;
		else if (fltNewX < fltX - fltLineSpacing)
			fltNewX = fltX - fltLineSpacing;

		fltX = fltNewX;
	}

	public float getY() {
		return fltY;
	}

	public void setY(float fltNewY) {
		// Dont let Circle outside Grid
		fltNewY = CircleOutOfBounds(fltNewY, 1, 3);

		// Only move max of LineSpacing
		if (fltNewY > fltY + fltLineSpacing)
			fltNewY = fltY + fltLineSpacing;
		else if (fltNewY < fltY - fltLineSpacing)
			fltNewY = fltY - fltLineSpacing;

		fltY = fltNewY;
	}

	public int getID() {
		return intCircleID;
	}

	public boolean getLevelWon() {
		return booLevelWon;
	}

	// This occurs with the onTouch UP event
	public void SnapToGrid() {
		int intGridID = gridID.getGridID(fltX + (fltLineSpacing / 2), fltY + (fltLineSpacing / 2));
		fltX = gridID.getGridX(intGridID);
		fltY = gridID.getGridY(intGridID);

		// Set new Circle Position
		gridID.setCirclePosition(intCircleID, intGridID);

		// ////////////////////////////////////////
		// Check if User has completed the Level //
		// ////////////////////////////////////////
		if (gridID.getIntWin() >= gridID.getCirclePosition().length)
			// WINNER - Do What I need when player Completes the Level
			booLevelWon = true;
	}

	public float[] FindMovableGrid() {
		// Get GridID for the current position of the Circle - Not the position of the Touch
		int intGridID = gridID.getGridID(fltX + (fltLineSpacing / 2), fltY + (fltLineSpacing / 2));

		// Find the Max and Min for X and Y
		float fltMaxX = gridID.getGridX((setLevelState.getGridSize() * setLevelState.getGridSize()) - 1);
		float fltMinX = gridID.getGridX(0);
		float fltMaxY = gridID.getGridY((setLevelState.getGridSize() * setLevelState.getGridSize()) - 1);
		float fltMinY = gridID.getGridY(0);

		// Dont allow Circle to overlap another
		int[][] aryCirclePosition = gridID.getCirclePosition();

		if (FindCirclePosition(aryCirclePosition, intGridID + 1))
			fltMaxX = gridID.getGridX(intGridID);
		if (FindCirclePosition(aryCirclePosition, intGridID - 1))
			fltMinX = gridID.getGridX(intGridID);
		if (FindCirclePosition(aryCirclePosition, intGridID + setLevelState.getGridSize()))
			fltMaxY = gridID.getGridY(intGridID);
		if (FindCirclePosition(aryCirclePosition, intGridID - setLevelState.getGridSize()))
			fltMinY = gridID.getGridY(intGridID);

		// Dont allow Circle to go into Grid of the Same Color
		int[] aryGridColors = gridID.getGridColors();

		if (intGridID <= aryGridColors.length - 2 && aryCirclePosition[intCircleID][1] == aryGridColors[intGridID + 1])
			fltMaxX = gridID.getGridX(intGridID);
		if (intGridID >= 1 && aryCirclePosition[intCircleID][1] == aryGridColors[intGridID - 1])
			fltMinX = gridID.getGridX(intGridID);
		if (intGridID <= aryGridColors.length - setLevelState.getGridSize() - 1 && aryCirclePosition[intCircleID][1] == aryGridColors[intGridID + setLevelState.getGridSize()])
			fltMaxY = gridID.getGridY(intGridID);
		if (intGridID >= setLevelState.getGridSize() && aryCirclePosition[intCircleID][1] == aryGridColors[intGridID - setLevelState.getGridSize()])
			fltMinY = gridID.getGridY(intGridID);

		float[] ary = new float[] { fltMinX, fltMinY, fltMaxX, fltMaxY };
		return ary;
	}

	private boolean FindCirclePosition(int[][] aryCirclePosition, int intFind) {
		// If you Overlap another Circle return true
		for (int[] intPos : aryCirclePosition) {
			if (intFind == intPos[0])
				return true;
		}
		return false;
	}
}
