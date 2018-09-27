package thomasWilliams.ShuffleFour;

public class SetLevelParamaters {

	private SetLevelState setLevelState;
	private int intCurrentLevel;
	private int[] aryGirdColorSet;
	private int[] aryCircleColorSet;

	public SetLevelParamaters(SetLevelState setLevelState) {
		this.setLevelState = setLevelState;
		intCurrentLevel = setLevelState.getCurrentLevel();

		aryGirdColorSet = new int[] { AppConfig.intGridColorNoColor, AppConfig.intGridColorRed, AppConfig.intGridColorBlue, AppConfig.intGridColorYellow, AppConfig.intGridColorGreen };
		aryCircleColorSet = new int[] { 0, AppConfig.intCircleColorRed, AppConfig.intCircleColorBlue, AppConfig.intCircleColorYellow, AppConfig.intCircleColorGreen };
	}

	public int[] getGridColorSet() {
		return aryGirdColorSet;
	}

	public int[] getCircleColorSet() {
		return aryCircleColorSet;
	}

	public int[] getGridColors() {
		// NoColor = 0; Red = 1; Blue = 2; Yellow = 3; Green = 4;
		// int[] aryColors = new int[] { 4, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 4, 1, 0, 2, 4, 4, 0, 0, 0, 2, 0, 0, 3, 2, 0, 0, 0, 4, 1, 2, 2, 0, 2, 3 };

		int[] aryColors = null;

		if (setLevelState.getGridSize() == 5)
			if (intCurrentLevel == 0) // For the Tutorial
				aryColors = new int[] { 4, 1, 3, 3, 4, 4, 1, 3, 3, 4, 4, 4, 4, 4, 4, 4, 1, 2, 2, 4, 4, 1, 2, 2, 4 };
			else if (intCurrentLevel == 1)
				aryColors = new int[] { 2, 1, 3, 4, 3, 4, 1, 2, 2, 2, 3, 3, 2, 2, 4, 2, 1, 3, 3, 4, 4, 1, 1, 2, 2 };
			else if (intCurrentLevel == 2)
				aryColors = new int[] { 4, 1, 1, 3, 2, 2, 1, 3, 2, 2, 4, 4, 1, 1, 4, 3, 3, 4, 2, 4, 4, 1, 3, 2, 3 };
			else if (intCurrentLevel == 3)
				aryColors = new int[] { 2, 4, 3, 3, 3, 4, 2, 1, 2, 1, 4, 2, 1, 4, 2, 4, 1, 2, 4, 4, 3, 1, 3, 1, 3 };
			else if (intCurrentLevel == 4)
				aryColors = new int[] { 2, 3, 1, 1, 2, 2, 3, 1, 3, 4, 4, 1, 1, 4, 2, 4, 3, 4, 3, 2, 1, 2, 2, 3, 3 };
			else if (intCurrentLevel == 5)
				aryColors = new int[] { 1, 1, 1, 3, 4, 2, 2, 2, 3, 1, 2, 4, 3, 1, 4, 3, 1, 4, 4, 2, 4, 1, 3, 3, 3 };
			else if (intCurrentLevel == 6)
				aryColors = new int[] { 4, 4, 3, 1, 3, 2, 2, 1, 4, 4, 2, 1, 2, 2, 4, 4, 3, 4, 3, 4, 1, 1, 3, 1, 2 };
			else if (intCurrentLevel == 7)
				aryColors = new int[] { 4, 4, 1, 3, 2, 2, 1, 3, 2, 1, 3, 4, 2, 1, 2, 2, 3, 4, 4, 4, 1, 1, 1, 3, 4 };
			else if (intCurrentLevel == 8)
				aryColors = new int[] { 1, 4, 1, 3, 2, 4, 2, 3, 1, 2, 4, 3, 2, 2, 4, 4, 3, 1, 4, 2, 4, 1, 2, 3, 2 };
			else if (intCurrentLevel == 9)
				aryColors = new int[] { 4, 1, 3, 1, 3, 2, 4, 4, 1, 4, 2, 1, 4, 3, 2, 2, 1, 2, 3, 4, 2, 1, 1, 2, 1 };
			else if (intCurrentLevel == 10)
				aryColors = new int[] { 4, 3, 3, 4, 2, 4, 2, 2, 1, 2, 4, 2, 3, 4, 2, 2, 2, 3, 2, 4, 1, 3, 3, 1, 4 };
			else if (intCurrentLevel == 11)
				aryColors = new int[] { 1, 1, 3, 3, 1, 4, 1, 3, 4, 1, 2, 2, 4, 4, 2, 2, 2, 1, 3, 1, 1, 3, 3, 1, 4 };
			else if (intCurrentLevel == 12)
				aryColors = new int[] { 2, 1, 4, 1, 1, 4, 4, 3, 3, 1, 2, 4, 4, 4, 2, 2, 3, 3, 1, 1, 2, 3, 2, 3, 2 };
			else if (intCurrentLevel == 13)
				aryColors = new int[] { 3, 3, 4, 4, 2, 4, 4, 2, 1, 1, 2, 3, 1, 1, 2, 2, 3, 4, 4, 2, 3, 3, 2, 1, 3 };
			else if (intCurrentLevel == 14)
				aryColors = new int[] { 4, 4, 3, 1, 3, 4, 1, 2, 4, 2, 3, 2, 3, 3, 1, 2, 1, 2, 3, 2, 4, 2, 1, 2, 1 };
			else if (intCurrentLevel == 15)
				aryColors = new int[] { 2, 1, 3, 3, 3, 2, 2, 2, 3, 1, 4, 1, 2, 3, 4, 4, 1, 2, 4, 2, 2, 2, 1, 1, 3 };
			else if (intCurrentLevel == 16)
				aryColors = new int[] { 1, 4, 3, 1, 1, 2, 3, 1, 3, 1, 2, 3, 2, 4, 4, 2, 1, 2, 1, 4, 2, 3, 3, 3, 3 };
			else if (intCurrentLevel == 17)
				aryColors = new int[] { 2, 3, 1, 1, 4, 2, 1, 1, 3, 4, 3, 4, 4, 3, 1, 3, 3, 2, 2, 1, 4, 1, 3, 3, 3 };
			else if (intCurrentLevel == 18)
				aryColors = new int[] { 1, 1, 4, 4, 2, 4, 1, 2, 2, 2, 4, 3, 3, 4, 1, 4, 1, 2, 3, 2, 1, 3, 3, 2, 3 };
			else if (intCurrentLevel == 19)
				aryColors = new int[] { 4, 1, 1, 1, 1, 3, 1, 2, 4, 2, 4, 1, 1, 4, 4, 3, 3, 4, 1, 1, 1, 3, 2, 3, 4 };
			else if (intCurrentLevel == 20)
				aryColors = new int[] { 3, 4, 4, 4, 3, 3, 1, 2, 1, 4, 4, 3, 2, 4, 4, 4, 2, 4, 4, 2, 4, 1, 3, 2, 3 };
			else if (intCurrentLevel == 21)
				aryColors = new int[] { 2, 4, 1, 4, 3, 4, 2, 3, 1, 1, 4, 1, 2, 2, 4, 4, 2, 2, 4, 4, 2, 3, 1, 1, 2 };
			else if (intCurrentLevel == 22)
				aryColors = new int[] { 3, 1, 1, 1, 1, 4, 1, 3, 4, 2, 2, 4, 4, 2, 1, 3, 1, 2, 4, 1, 2, 1, 1, 3, 2 };
			else if (intCurrentLevel == 23)
				aryColors = new int[] { 4, 3, 3, 3, 3, 3, 4, 4, 4, 2, 3, 2, 4, 4, 4, 4, 1, 4, 1, 4, 4, 1, 2, 2, 3 };
			else if (intCurrentLevel == 24)
				aryColors = new int[] { 3, 3, 3, 1, 1, 3, 4, 4, 2, 1, 3, 3, 4, 3, 2, 2, 1, 1, 4, 2, 3, 1, 1, 2, 1 };
			else if (intCurrentLevel == 25)
				aryColors = new int[] { 3, 4, 3, 1, 1, 4, 2, 2, 2, 1, 4, 3, 2, 2, 2, 4, 3, 4, 1, 1, 2, 1, 1, 3, 4 };
			else if (intCurrentLevel == 26)
				aryColors = new int[] { 4, 1, 4, 4, 2, 3, 2, 2, 1, 4, 3, 3, 3, 3, 2, 2, 3, 1, 2, 1, 1, 2, 3, 2, 2 };
			else if (intCurrentLevel == 27)
				aryColors = new int[] { 2, 1, 4, 1, 3, 2, 4, 2, 1, 2, 4, 1, 3, 2, 1, 4, 2, 1, 3, 1, 3, 2, 2, 3, 2 };
			else if (intCurrentLevel == 28)
				aryColors = new int[] { 2, 1, 4, 3, 2, 3, 3, 1, 4, 2, 4, 4, 2, 1, 4, 2, 3, 2, 4, 1, 4, 1, 3, 2, 3 };
			else if (intCurrentLevel == 29)
				aryColors = new int[] { 2, 3, 3, 3, 4, 3, 4, 1, 2, 4, 4, 1, 1, 4, 4, 4, 1, 3, 3, 2, 1, 1, 3, 2, 3 };
			else if (intCurrentLevel == 30)
				aryColors = new int[] { 4, 3, 4, 3, 2, 2, 2, 2, 3, 1, 4, 4, 2, 1, 4, 3, 1, 4, 2, 4, 4, 2, 3, 1, 1 };
			else if (intCurrentLevel == 31)
				aryColors = new int[] { 3, 3, 1, 4, 4, 2, 4, 3, 4, 4, 2, 1, 4, 3, 4, 4, 1, 4, 1, 2, 1, 2, 3, 2, 3 };
			else if (intCurrentLevel == 32)
				aryColors = new int[] { 3, 4, 1, 1, 3, 4, 2, 4, 2, 4, 4, 2, 3, 3, 1, 4, 1, 3, 2, 2, 2, 1, 3, 1, 1 };
			else if (intCurrentLevel == 33)
				aryColors = new int[] { 3, 3, 3, 1, 4, 2, 2, 4, 4, 2, 2, 4, 3, 1, 2, 3, 2, 1, 3, 1, 1, 2, 2, 3, 2 };
			else if (intCurrentLevel == 34)
				aryColors = new int[] { 4, 4, 1, 1, 4, 2, 1, 3, 2, 2, 2, 3, 1, 3, 4, 4, 2, 4, 4, 1, 1, 3, 1, 1, 2 };
			else if (intCurrentLevel == 35)
				aryColors = new int[] { 1, 4, 1, 3, 1, 4, 4, 1, 3, 2, 4, 1, 2, 3, 1, 2, 1, 1, 4, 2, 2, 2, 3, 2, 2 };
			else if (intCurrentLevel == 36)
				aryColors = new int[] { 1, 4, 4, 4, 3, 2, 4, 2, 1, 2, 4, 2, 2, 4, 4, 4, 3, 4, 4, 2, 3, 1, 2, 3, 1 };
			else if (intCurrentLevel == 37)
				aryColors = new int[] { 1, 4, 4, 1, 3, 4, 1, 2, 2, 4, 4, 2, 3, 4, 2, 3, 3, 1, 4, 1, 4, 1, 2, 2, 2 };
			else if (intCurrentLevel == 38)
				aryColors = new int[] { 4, 4, 3, 1, 4, 2, 2, 3, 2, 1, 4, 1, 3, 4, 2, 2, 4, 4, 2, 1, 1, 2, 3, 3, 3 };
			else if (intCurrentLevel == 39)
				aryColors = new int[] { 1, 1, 4, 1, 3, 3, 2, 4, 1, 2, 4, 2, 3, 4, 1, 3, 4, 2, 4, 2, 4, 1, 3, 3, 2 };
			else if (intCurrentLevel == 40)
				aryColors = new int[] { 1, 3, 3, 1, 3, 4, 4, 1, 1, 4, 2, 4, 2, 3, 2, 3, 2, 3, 4, 2, 2, 1, 1, 3, 4 };
			else if (intCurrentLevel == 41)
				aryColors = new int[] { 2, 3, 1, 3, 2, 4, 2, 3, 1, 2, 3, 1, 4, 4, 2, 4, 1, 2, 3, 2, 2, 1, 2, 2, 4 };
			else if (intCurrentLevel == 42)
				aryColors = new int[] { 1, 4, 3, 3, 4, 2, 4, 1, 4, 2, 2, 3, 4, 1, 1, 4, 2, 4, 2, 4, 1, 1, 3, 3, 2 };
			else if (intCurrentLevel == 43)
				aryColors = new int[] { 2, 1, 3, 3, 4, 4, 3, 1, 1, 2, 3, 4, 2, 2, 2, 4, 4, 4, 1, 2, 3, 2, 1, 1, 4 };
			else if (intCurrentLevel == 44)
				aryColors = new int[] { 3, 4, 4, 1, 2, 2, 3, 1, 2, 1, 4, 1, 4, 4, 4, 2, 3, 2, 2, 1, 3, 3, 3, 3, 1 };
			else if (intCurrentLevel == 45)
				aryColors = new int[] { 3, 1, 3, 3, 4, 4, 4, 2, 3, 1, 4, 2, 4, 1, 4, 4, 2, 1, 3, 2, 1, 3, 1, 1, 2 };
			else if (intCurrentLevel == 46)
				aryColors = new int[] { 2, 1, 4, 4, 3, 3, 1, 2, 1, 1, 3, 4, 2, 4, 2, 2, 3, 3, 3, 2, 2, 2, 1, 1, 4 };
			else if (intCurrentLevel == 47)
				aryColors = new int[] { 2, 4, 3, 1, 4, 3, 2, 2, 1, 2, 4, 3, 1, 4, 2, 2, 4, 3, 4, 2, 4, 1, 1, 3, 1 };
			else if (intCurrentLevel == 48)
				aryColors = new int[] { 4, 1, 4, 4, 2, 2, 3, 2, 3, 1, 4, 3, 3, 1, 4, 4, 4, 4, 2, 4, 2, 2, 3, 1, 3 };
			else if (intCurrentLevel == 49)
				aryColors = new int[] { 1, 4, 3, 3, 3, 2, 1, 4, 2, 1, 4, 1, 2, 4, 1, 3, 3, 4, 2, 2, 1, 1, 2, 3, 4 };
			else if (intCurrentLevel == 50)
				aryColors = new int[] { 1, 4, 3, 3, 4, 2, 1, 1, 2, 4, 3, 4, 2, 1, 4, 4, 1, 4, 3, 2, 2, 3, 1, 2, 4 };
			else
				aryColors = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		else if (setLevelState.getGridSize() == 6)
			if (intCurrentLevel == 1)
				aryColors = new int[] { 4, 1, 1, 1, 3, 3, 2, 1, 2, 4, 3, 2, 4, 1, 3, 2, 3, 2, 3, 4, 4, 2, 1, 4, 4, 1, 4, 2, 4, 1, 3, 2, 1, 2, 3, 1 };
			else if (intCurrentLevel == 2)
				aryColors = new int[] { 2, 1, 4, 4, 3, 2, 2, 2, 3, 1, 1, 1, 2, 4, 2, 4, 2, 2, 4, 3, 2, 3, 3, 4, 4, 1, 3, 4, 3, 2, 2, 2, 1, 1, 1, 2 };
			else if (intCurrentLevel == 3)
				aryColors = new int[] { 2, 3, 3, 1, 3, 3, 2, 1, 4, 2, 4, 1, 2, 3, 3, 3, 4, 1, 2, 2, 1, 3, 4, 1, 4, 2, 1, 2, 1, 1, 4, 2, 2, 2, 3, 2 };
			else if (intCurrentLevel == 4)
				aryColors = new int[] { 3, 1, 3, 4, 4, 3, 4, 1, 2, 2, 4, 1, 2, 3, 4, 4, 2, 1, 2, 3, 1, 1, 2, 1, 2, 1, 1, 4, 4, 1, 2, 1, 3, 3, 2, 3 };
			else if (intCurrentLevel == 5)
				aryColors = new int[] { 4, 3, 3, 1, 3, 2, 3, 4, 2, 2, 2, 1, 3, 1, 3, 2, 4, 2, 3, 3, 3, 4, 1, 4, 4, 1, 4, 2, 2, 1, 1, 3, 3, 3, 1, 2 };
			else if (intCurrentLevel == 6)
				aryColors = new int[] { 1, 3, 4, 4, 4, 2, 2, 1, 2, 4, 3, 2, 2, 2, 3, 2, 1, 1, 2, 1, 3, 3, 4, 1, 2, 1, 1, 3, 4, 1, 2, 3, 1, 2, 1, 4 };
			else if (intCurrentLevel == 7)
				aryColors = new int[] { 3, 1, 1, 4, 1, 3, 2, 4, 4, 3, 4, 4, 2, 1, 4, 4, 3, 2, 3, 2, 1, 3, 4, 2, 4, 4, 1, 2, 1, 2, 2, 2, 2, 2, 1, 1 };
			else if (intCurrentLevel == 8)
				aryColors = new int[] { 3, 4, 4, 1, 3, 1, 3, 4, 2, 2, 4, 1, 2, 4, 4, 1, 4, 2, 3, 1, 2, 3, 4, 4, 4, 2, 1, 2, 2, 1, 2, 2, 1, 2, 1, 1 };
			else if (intCurrentLevel == 9)
				aryColors = new int[] { 4, 1, 3, 1, 3, 2, 2, 2, 4, 4, 1, 2, 4, 4, 3, 4, 3, 2, 3, 3, 1, 2, 2, 4, 2, 3, 1, 3, 2, 1, 4, 2, 2, 1, 2, 3 };
			else if (intCurrentLevel == 10)
				aryColors = new int[] { 1, 3, 3, 1, 3, 2, 3, 4, 3, 1, 4, 2, 3, 4, 3, 2, 2, 2, 2, 1, 1, 3, 1, 1, 3, 3, 2, 4, 1, 4, 3, 1, 3, 1, 1, 1 };
			else if (intCurrentLevel == 11)
				aryColors = new int[] { 1, 3, 4, 4, 1, 3, 2, 1, 2, 3, 2, 2, 3, 3, 1, 1, 1, 2, 3, 3, 4, 1, 1, 2, 3, 3, 3, 2, 4, 4, 3, 2, 3, 1, 1, 4 };
			else if (intCurrentLevel == 12)
				aryColors = new int[] { 2, 1, 3, 3, 1, 1, 2, 3, 4, 2, 1, 4, 2, 1, 3, 4, 1, 1, 4, 1, 1, 4, 4, 2, 2, 3, 1, 3, 1, 1, 2, 2, 3, 2, 2, 2 };
			else if (intCurrentLevel == 13)
				aryColors = new int[] { 1, 1, 4, 3, 1, 1, 4, 3, 3, 1, 2, 2, 3, 1, 2, 1, 4, 2, 2, 4, 3, 4, 3, 1, 4, 1, 4, 1, 3, 1, 4, 1, 2, 3, 3, 2 };
			else if (intCurrentLevel == 14)
				aryColors = new int[] { 4, 1, 4, 1, 4, 4, 3, 1, 3, 1, 3, 4, 4, 2, 3, 2, 3, 2, 3, 1, 4, 2, 3, 1, 4, 4, 3, 1, 3, 1, 1, 1, 2, 1, 3, 2 };
			else if (intCurrentLevel == 15)
				aryColors = new int[] { 3, 1, 1, 1, 1, 3, 4, 3, 2, 4, 4, 2, 4, 2, 1, 3, 1, 4, 4, 4, 1, 1, 1, 2, 4, 3, 4, 1, 3, 4, 3, 1, 2, 3, 1, 1 };
			else if (intCurrentLevel == 16)
				aryColors = new int[] { 3, 3, 3, 4, 3, 3, 4, 2, 4, 2, 1, 4, 4, 1, 1, 4, 2, 1, 4, 1, 2, 2, 4, 1, 2, 3, 1, 2, 1, 2, 3, 2, 3, 3, 2, 3 };
			else if (intCurrentLevel == 17)
				aryColors = new int[] { 4, 4, 3, 3, 3, 2, 4, 4, 3, 4, 4, 4, 3, 1, 3, 1, 2, 2, 4, 1, 1, 4, 3, 2, 3, 3, 2, 3, 4, 4, 3, 2, 1, 3, 2, 1 };
			else if (intCurrentLevel == 18)
				aryColors = new int[] { 2, 4, 4, 3, 4, 3, 4, 3, 4, 1, 2, 2, 4, 3, 3, 3, 1, 4, 3, 4, 4, 4, 2, 2, 3, 2, 3, 4, 1, 4, 1, 1, 3, 2, 3, 2 };
			else if (intCurrentLevel == 19)
				aryColors = new int[] { 2, 4, 1, 4, 4, 4, 3, 1, 2, 1, 3, 2, 2, 2, 2, 1, 1, 1, 3, 1, 1, 3, 3, 1, 3, 4, 3, 4, 4, 4, 1, 1, 2, 3, 3, 2 };
			else if (intCurrentLevel == 20)
				aryColors = new int[] { 2, 3, 1, 4, 1, 2, 3, 4, 2, 1, 2, 4, 4, 4, 1, 2, 4, 2, 4, 2, 1, 1, 1, 2, 4, 2, 4, 2, 2, 2, 2, 2, 1, 3, 3, 1 };
			else if (intCurrentLevel == 21)
				aryColors = new int[] { 2, 1, 1, 4, 1, 3, 2, 2, 2, 4, 1, 2, 4, 3, 2, 4, 3, 4, 3, 4, 1, 1, 3, 1, 3, 1, 4, 4, 1, 4, 2, 1, 2, 2, 1, 3 };
			else if (intCurrentLevel == 22)
				aryColors = new int[] { 4, 4, 4, 1, 4, 2, 4, 4, 2, 3, 2, 1, 3, 4, 1, 1, 2, 2, 4, 2, 4, 2, 4, 4, 3, 2, 3, 3, 3, 1, 4, 1, 1, 2, 2, 4 };
			else if (intCurrentLevel == 23)
				aryColors = new int[] { 1, 4, 1, 1, 4, 1, 3, 2, 1, 3, 3, 1, 4, 1, 4, 2, 2, 4, 2, 3, 4, 3, 2, 1, 3, 1, 1, 2, 2, 1, 4, 3, 2, 1, 3, 3 };
			else if (intCurrentLevel == 24)
				aryColors = new int[] { 3, 1, 1, 1, 3, 4, 2, 2, 3, 1, 3, 4, 4, 4, 4, 3, 3, 4, 3, 4, 1, 1, 2, 1, 2, 4, 1, 3, 4, 1, 1, 1, 3, 1, 2, 1 };
			else if (intCurrentLevel == 25)
				aryColors = new int[] { 1, 3, 3, 3, 4, 3, 2, 4, 1, 4, 4, 1, 3, 1, 3, 2, 2, 1, 3, 1, 3, 4, 4, 1, 3, 2, 3, 2, 4, 4, 2, 2, 1, 2, 1, 1 };
			else if (intCurrentLevel == 26)
				aryColors = new int[] { 1, 4, 4, 1, 3, 4, 2, 2, 4, 3, 4, 1, 4, 2, 3, 1, 1, 4, 4, 2, 1, 2, 2, 2, 4, 4, 3, 3, 1, 4, 2, 1, 2, 3, 3, 3 };
			else if (intCurrentLevel == 27)
				aryColors = new int[] { 1, 1, 1, 4, 1, 3, 4, 2, 2, 4, 4, 2, 3, 1, 4, 3, 2, 2, 4, 1, 1, 3, 2, 4, 3, 2, 4, 2, 4, 4, 1, 3, 3, 1, 3, 3 };
			else if (intCurrentLevel == 28)
				aryColors = new int[] { 3, 4, 1, 3, 3, 2, 2, 1, 3, 3, 3, 4, 4, 1, 1, 3, 4, 4, 4, 2, 3, 2, 3, 1, 3, 4, 2, 4, 2, 4, 2, 2, 3, 1, 3, 1 };
			else if (intCurrentLevel == 29)
				aryColors = new int[] { 4, 3, 4, 3, 4, 4, 2, 1, 1, 4, 1, 1, 2, 2, 4, 1, 4, 1, 3, 3, 4, 2, 4, 1, 4, 1, 2, 3, 1, 4, 1, 2, 2, 2, 3, 3 };
			else if (intCurrentLevel == 30)
				aryColors = new int[] { 4, 3, 4, 1, 3, 3, 4, 1, 3, 1, 2, 4, 3, 3, 1, 2, 2, 1, 3, 1, 2, 3, 2, 4, 4, 4, 4, 1, 4, 1, 4, 3, 2, 1, 2, 2 };
			else if (intCurrentLevel == 31)
				aryColors = new int[] { 3, 1, 3, 1, 1, 1, 4, 1, 4, 2, 3, 2, 2, 1, 2, 2, 3, 2, 4, 2, 2, 3, 3, 4, 2, 2, 3, 4, 2, 4, 4, 2, 3, 1, 2, 4 };
			else if (intCurrentLevel == 32)
				aryColors = new int[] { 1, 4, 4, 1, 3, 2, 4, 1, 3, 4, 1, 2, 2, 1, 1, 2, 1, 4, 4, 3, 3, 3, 2, 1, 3, 1, 3, 4, 4, 2, 3, 1, 3, 3, 3, 2 };
			else if (intCurrentLevel == 33)
				aryColors = new int[] { 2, 3, 1, 1, 4, 2, 4, 3, 1, 1, 2, 2, 2, 3, 2, 4, 3, 1, 2, 3, 1, 4, 2, 2, 4, 3, 4, 2, 2, 4, 1, 1, 1, 1, 1, 2 };
			else if (intCurrentLevel == 34)
				aryColors = new int[] { 2, 4, 3, 4, 4, 2, 3, 1, 1, 2, 3, 1, 3, 1, 4, 4, 4, 4, 4, 2, 4, 2, 2, 4, 4, 3, 2, 1, 3, 1, 1, 2, 3, 2, 3, 3 };
			else if (intCurrentLevel == 35)
				aryColors = new int[] { 2, 1, 4, 4, 1, 3, 3, 4, 3, 1, 1, 4, 2, 1, 4, 3, 2, 2, 2, 4, 3, 4, 1, 1, 2, 1, 1, 2, 3, 4, 3, 1, 3, 3, 2, 2 };
			else if (intCurrentLevel == 36)
				aryColors = new int[] { 4, 4, 3, 1, 4, 4, 2, 4, 2, 3, 3, 2, 2, 3, 3, 3, 1, 4, 2, 2, 4, 3, 2, 4, 3, 2, 3, 2, 3, 4, 2, 2, 1, 2, 2, 2 };
			else if (intCurrentLevel == 37)
				aryColors = new int[] { 4, 3, 1, 4, 4, 3, 3, 1, 2, 1, 3, 1, 2, 3, 2, 2, 3, 4, 2, 1, 4, 1, 1, 4, 4, 2, 1, 3, 4, 2, 3, 3, 1, 1, 1, 1 };
			else if (intCurrentLevel == 38)
				aryColors = new int[] { 1, 1, 1, 3, 3, 1, 2, 1, 3, 3, 4, 2, 4, 4, 2, 1, 1, 4, 2, 3, 3, 4, 4, 4, 2, 2, 3, 4, 4, 2, 1, 3, 1, 2, 2, 4 };
			else if (intCurrentLevel == 39)
				aryColors = new int[] { 4, 1, 1, 3, 3, 3, 3, 1, 2, 2, 2, 4, 3, 3, 4, 2, 2, 4, 3, 3, 2, 3, 1, 4, 4, 1, 2, 1, 3, 2, 3, 3, 1, 2, 2, 3 };
			else if (intCurrentLevel == 40)
				aryColors = new int[] { 3, 1, 3, 3, 3, 1, 3, 4, 4, 3, 3, 4, 3, 3, 2, 2, 2, 2, 4, 4, 1, 3, 3, 4, 2, 1, 2, 4, 3, 4, 3, 2, 1, 3, 1, 1 };
			else if (intCurrentLevel == 41)
				aryColors = new int[] { 1, 3, 3, 4, 4, 3, 2, 3, 3, 1, 4, 2, 3, 1, 1, 2, 4, 2, 2, 2, 3, 4, 3, 1, 2, 4, 4, 4, 2, 2, 2, 1, 2, 2, 1, 3 };
			else if (intCurrentLevel == 42)
				aryColors = new int[] { 2, 1, 4, 3, 4, 2, 2, 4, 3, 1, 1, 1, 4, 3, 4, 1, 4, 4, 2, 1, 2, 4, 3, 4, 4, 3, 3, 1, 1, 1, 3, 3, 2, 1, 3, 2 };
			else if (intCurrentLevel == 43)
				aryColors = new int[] { 2, 3, 4, 1, 4, 4, 2, 4, 3, 1, 4, 4, 2, 2, 2, 2, 4, 4, 3, 1, 1, 3, 2, 1, 4, 2, 4, 4, 1, 1, 1, 1, 2, 3, 2, 1 };
			else if (intCurrentLevel == 44)
				aryColors = new int[] { 3, 4, 1, 1, 1, 4, 4, 2, 2, 3, 3, 2, 3, 2, 3, 1, 1, 4, 4, 2, 1, 3, 2, 2, 2, 1, 2, 3, 4, 1, 1, 2, 3, 1, 2, 1 };
			else if (intCurrentLevel == 45)
				aryColors = new int[] { 2, 3, 4, 1, 3, 4, 4, 3, 4, 4, 4, 4, 4, 2, 1, 2, 4, 2, 4, 1, 2, 1, 3, 1, 3, 3, 1, 2, 2, 4, 4, 2, 2, 1, 2, 4 };
			else if (intCurrentLevel == 46)
				aryColors = new int[] { 3, 1, 3, 3, 1, 4, 3, 1, 1, 4, 2, 4, 2, 4, 4, 3, 2, 1, 4, 1, 1, 3, 3, 2, 4, 3, 3, 1, 2, 2, 1, 2, 2, 1, 3, 3 };
			else if (intCurrentLevel == 47)
				aryColors = new int[] { 1, 3, 4, 1, 1, 2, 3, 4, 3, 2, 1, 2, 2, 2, 3, 3, 4, 2, 2, 3, 2, 2, 4, 1, 2, 4, 3, 4, 3, 4, 3, 1, 1, 1, 1, 4 };
			else if (intCurrentLevel == 48)
				aryColors = new int[] { 2, 3, 3, 4, 3, 2, 2, 2, 1, 1, 3, 1, 3, 1, 4, 2, 2, 4, 4, 1, 2, 1, 2, 1, 4, 2, 1, 1, 4, 1, 1, 1, 1, 2, 3, 4 };
			else if (intCurrentLevel == 49)
				aryColors = new int[] { 2, 1, 4, 4, 3, 3, 3, 1, 4, 4, 1, 2, 4, 2, 4, 1, 4, 1, 2, 2, 3, 4, 4, 4, 4, 3, 1, 2, 3, 2, 2, 2, 2, 2, 2, 2 };
			else if (intCurrentLevel == 50)
				aryColors = new int[] { 3, 1, 4, 3, 4, 2, 3, 4, 1, 3, 4, 4, 2, 2, 3, 4, 2, 2, 3, 4, 1, 1, 1, 2, 4, 2, 3, 1, 2, 4, 2, 1, 3, 3, 1, 4 };
			else if (intCurrentLevel == 51)
				aryColors = new int[] { 2, 3, 1, 3, 4, 3, 4, 2, 1, 4, 3, 2, 2, 4, 1, 4, 3, 2, 2, 1, 2, 4, 4, 4, 3, 3, 1, 3, 2, 2, 4, 3, 3, 1, 2, 4 };
			else if (intCurrentLevel == 52)
				aryColors = new int[] { 1, 3, 3, 4, 4, 1, 2, 4, 1, 4, 4, 1, 4, 2, 3, 2, 1, 2, 4, 2, 4, 2, 3, 1, 3, 3, 3, 2, 2, 2, 3, 2, 3, 3, 2, 1 };
			else if (intCurrentLevel == 53)
				aryColors = new int[] { 4, 4, 4, 3, 1, 2, 4, 1, 3, 4, 2, 1, 3, 2, 3, 1, 4, 2, 4, 4, 4, 1, 2, 2, 4, 4, 3, 2, 2, 4, 2, 1, 1, 2, 2, 4 };
			else if (intCurrentLevel == 54)
				aryColors = new int[] { 2, 4, 1, 4, 1, 4, 2, 4, 2, 3, 2, 4, 4, 1, 1, 1, 2, 1, 3, 2, 1, 1, 4, 2, 2, 3, 4, 3, 4, 1, 1, 1, 3, 3, 2, 3 };
			else if (intCurrentLevel == 55)
				aryColors = new int[] { 3, 4, 3, 1, 4, 3, 3, 4, 4, 1, 3, 1, 2, 4, 4, 1, 3, 1, 2, 4, 2, 2, 4, 2, 4, 2, 2, 1, 3, 1, 2, 2, 2, 2, 1, 4 };
			else if (intCurrentLevel == 56)
				aryColors = new int[] { 4, 4, 4, 1, 4, 4, 2, 1, 1, 2, 2, 2, 2, 1, 4, 4, 3, 1, 3, 4, 4, 3, 3, 2, 2, 2, 4, 3, 4, 1, 1, 1, 1, 1, 2, 3 };
			else if (intCurrentLevel == 57)
				aryColors = new int[] { 3, 4, 3, 3, 1, 2, 2, 3, 4, 2, 1, 1, 2, 4, 1, 3, 1, 1, 3, 1, 1, 2, 4, 1, 2, 2, 1, 2, 3, 2, 4, 2, 2, 3, 3, 3 };
			else if (intCurrentLevel == 58)
				aryColors = new int[] { 2, 1, 4, 1, 4, 2, 4, 3, 2, 4, 3, 4, 4, 2, 4, 4, 3, 4, 4, 1, 1, 2, 3, 1, 3, 1, 1, 4, 2, 1, 3, 2, 3, 3, 1, 1 };
			else if (intCurrentLevel == 59)
				aryColors = new int[] { 1, 3, 4, 1, 1, 4, 3, 4, 1, 1, 1, 4, 2, 3, 1, 1, 4, 1, 3, 3, 3, 2, 3, 4, 2, 1, 2, 1, 3, 4, 1, 3, 3, 1, 1, 1 };
			else if (intCurrentLevel == 60)
				aryColors = new int[] { 2, 4, 3, 4, 4, 3, 3, 3, 3, 1, 4, 2, 4, 1, 1, 2, 2, 4, 3, 4, 2, 3, 2, 2, 2, 1, 1, 2, 3, 1, 1, 2, 1, 2, 1, 4 };
			else if (intCurrentLevel == 61)
				aryColors = new int[] { 3, 3, 4, 4, 3, 2, 2, 2, 1, 3, 1, 1, 2, 3, 4, 3, 3, 4, 2, 4, 2, 2, 2, 2, 4, 2, 4, 1, 3, 4, 1, 1, 1, 1, 1, 1 };
			else if (intCurrentLevel == 62)
				aryColors = new int[] { 3, 4, 3, 1, 1, 4, 4, 1, 4, 3, 4, 2, 3, 1, 3, 1, 4, 4, 2, 1, 3, 1, 3, 2, 2, 2, 3, 3, 1, 2, 2, 1, 2, 3, 3, 3 };
			else if (intCurrentLevel == 63)
				aryColors = new int[] { 2, 4, 1, 1, 3, 2, 4, 3, 2, 4, 1, 2, 2, 1, 3, 2, 2, 4, 2, 1, 4, 4, 4, 4, 4, 4, 4, 3, 1, 1, 4, 3, 1, 3, 1, 4 };
			else if (intCurrentLevel == 64)
				aryColors = new int[] { 3, 1, 4, 4, 4, 3, 4, 3, 1, 1, 2, 4, 4, 4, 3, 2, 4, 4, 2, 2, 3, 3, 2, 2, 3, 4, 3, 3, 2, 2, 1, 2, 1, 2, 1, 4 };
			else if (intCurrentLevel == 65)
				aryColors = new int[] { 1, 4, 1, 3, 4, 1, 3, 4, 2, 3, 2, 4, 3, 4, 1, 2, 3, 2, 4, 3, 2, 2, 3, 2, 4, 4, 1, 2, 2, 4, 1, 3, 2, 2, 1, 3 };
			else if (intCurrentLevel == 66)
				aryColors = new int[] { 1, 1, 4, 1, 4, 4, 3, 4, 4, 1, 3, 4, 4, 3, 1, 3, 4, 4, 2, 2, 4, 3, 4, 2, 2, 1, 1, 4, 2, 2, 1, 3, 1, 2, 3, 2 };
			else if (intCurrentLevel == 67)
				aryColors = new int[] { 1, 3, 1, 4, 3, 2, 4, 2, 1, 1, 2, 1, 3, 2, 1, 4, 2, 1, 4, 3, 3, 1, 4, 2, 3, 2, 1, 1, 3, 1, 2, 3, 1, 1, 1, 4 };
			else if (intCurrentLevel == 68)
				aryColors = new int[] { 4, 1, 1, 3, 1, 3, 3, 1, 2, 1, 3, 2, 3, 4, 1, 3, 2, 1, 4, 1, 3, 4, 2, 2, 4, 2, 3, 3, 2, 2, 2, 2, 1, 2, 3, 1 };
			else if (intCurrentLevel == 69)
				aryColors = new int[] { 1, 3, 1, 4, 1, 4, 4, 3, 1, 2, 1, 2, 2, 4, 2, 2, 4, 2, 2, 4, 1, 3, 3, 1, 4, 1, 4, 3, 4, 1, 1, 3, 3, 3, 1, 3 };
			else if (intCurrentLevel == 70)
				aryColors = new int[] { 4, 4, 4, 4, 4, 2, 3, 3, 4, 2, 3, 2, 2, 3, 3, 3, 4, 2, 4, 4, 3, 3, 3, 2, 3, 3, 3, 1, 4, 2, 1, 1, 3, 2, 2, 4 };
			else if (intCurrentLevel == 71)
				aryColors = new int[] { 2, 3, 4, 3, 4, 3, 4, 1, 2, 2, 3, 2, 2, 2, 1, 1, 2, 2, 3, 1, 3, 1, 1, 1, 2, 3, 3, 4, 3, 4, 4, 1, 1, 1, 3, 1 };
			else if (intCurrentLevel == 72)
				aryColors = new int[] { 4, 4, 1, 4, 3, 3, 2, 3, 4, 2, 1, 4, 4, 3, 2, 4, 4, 1, 2, 4, 4, 1, 1, 1, 4, 2, 1, 4, 4, 4, 1, 2, 1, 2, 1, 3 };
			else if (intCurrentLevel == 73)
				aryColors = new int[] { 4, 4, 1, 1, 1, 4, 3, 3, 3, 3, 4, 2, 3, 4, 1, 3, 2, 2, 3, 1, 2, 2, 2, 1, 3, 4, 2, 2, 1, 4, 3, 3, 2, 2, 3, 4 };
			else if (intCurrentLevel == 74)
				aryColors = new int[] { 4, 1, 4, 4, 3, 4, 3, 3, 4, 2, 3, 1, 3, 3, 1, 4, 3, 4, 4, 3, 3, 1, 3, 2, 4, 2, 4, 1, 2, 2, 3, 2, 2, 3, 1, 3 };
			else if (intCurrentLevel == 75)
				aryColors = new int[] { 2, 4, 3, 3, 4, 1, 2, 1, 4, 3, 4, 2, 3, 2, 3, 4, 3, 4, 2, 1, 1, 3, 3, 1, 2, 3, 4, 1, 2, 2, 1, 2, 3, 2, 3, 3 };
			else if (intCurrentLevel == 76)
				aryColors = new int[] { 2, 3, 1, 4, 3, 1, 3, 3, 3, 3, 4, 2, 3, 3, 4, 2, 3, 1, 2, 1, 2, 3, 4, 4, 4, 2, 2, 3, 1, 1, 4, 3, 1, 1, 1, 2 };
			else if (intCurrentLevel == 77)
				aryColors = new int[] { 3, 4, 3, 1, 1, 3, 2, 4, 3, 2, 3, 2, 2, 2, 2, 4, 2, 2, 4, 1, 4, 3, 4, 4, 4, 2, 3, 4, 3, 2, 2, 1, 3, 1, 2, 3 };
			else if (intCurrentLevel == 78)
				aryColors = new int[] { 1, 1, 1, 4, 1, 3, 2, 1, 1, 3, 1, 1, 2, 2, 1, 2, 4, 1, 4, 1, 1, 4, 3, 1, 4, 4, 3, 3, 2, 4, 3, 2, 2, 3, 1, 1 };
			else if (intCurrentLevel == 79)
				aryColors = new int[] { 1, 4, 3, 3, 4, 3, 3, 4, 4, 3, 4, 4, 3, 2, 4, 1, 1, 2, 4, 1, 3, 4, 3, 4, 3, 4, 1, 2, 2, 2, 4, 2, 1, 3, 1, 2 };
			else if (intCurrentLevel == 80)
				aryColors = new int[] { 3, 3, 1, 4, 3, 1, 4, 4, 1, 1, 2, 2, 2, 2, 1, 4, 4, 2, 3, 1, 4, 3, 2, 4, 4, 4, 2, 1, 4, 4, 1, 2, 1, 2, 1, 1 };
			else if (intCurrentLevel == 81)
				aryColors = new int[] { 4, 3, 1, 1, 1, 3, 4, 1, 1, 4, 3, 1, 3, 4, 2, 1, 3, 1, 3, 2, 3, 4, 3, 4, 4, 1, 4, 2, 1, 2, 4, 2, 3, 2, 2, 2 };
			else if (intCurrentLevel == 82)
				aryColors = new int[] { 1, 1, 3, 4, 4, 2, 3, 1, 2, 4, 4, 4, 3, 2, 2, 1, 2, 1, 4, 4, 4, 2, 3, 1, 4, 3, 3, 1, 3, 2, 1, 2, 2, 3, 2, 2 };
			else if (intCurrentLevel == 83)
				aryColors = new int[] { 1, 3, 4, 4, 3, 3, 4, 4, 1, 4, 1, 1, 3, 3, 3, 3, 3, 2, 3, 1, 2, 3, 2, 4, 2, 2, 4, 3, 4, 4, 4, 2, 3, 3, 1, 1 };
			else if (intCurrentLevel == 84)
				aryColors = new int[] { 2, 4, 4, 3, 4, 2, 2, 3, 1, 4, 4, 1, 2, 4, 4, 3, 3, 4, 2, 3, 2, 3, 4, 1, 3, 2, 3, 2, 1, 4, 3, 2, 1, 2, 3, 2 };
			else if (intCurrentLevel == 85)
				aryColors = new int[] { 2, 3, 1, 4, 4, 1, 4, 2, 3, 2, 4, 1, 3, 1, 3, 3, 2, 1, 4, 2, 4, 3, 3, 2, 4, 1, 3, 3, 1, 1, 3, 1, 2, 1, 3, 4 };
			else if (intCurrentLevel == 86)
				aryColors = new int[] { 4, 1, 4, 1, 3, 3, 4, 4, 4, 1, 4, 2, 3, 4, 1, 2, 3, 4, 2, 1, 2, 3, 4, 4, 2, 3, 2, 1, 4, 4, 2, 2, 3, 1, 1, 2 };
			else if (intCurrentLevel == 87)
				aryColors = new int[] { 2, 3, 1, 3, 4, 1, 4, 4, 3, 4, 2, 2, 3, 4, 2, 2, 2, 4, 3, 3, 1, 1, 3, 2, 3, 2, 4, 2, 2, 2, 4, 1, 3, 1, 3, 2 };
			else if (intCurrentLevel == 88)
				aryColors = new int[] { 4, 1, 3, 1, 1, 2, 2, 2, 3, 3, 1, 2, 4, 4, 4, 4, 4, 4, 3, 2, 4, 4, 1, 4, 4, 1, 4, 2, 3, 4, 3, 2, 2, 2, 1, 4 };
			else if (intCurrentLevel == 89)
				aryColors = new int[] { 4, 1, 1, 4, 1, 3, 4, 4, 2, 2, 1, 4, 4, 2, 1, 4, 1, 4, 3, 2, 2, 2, 1, 2, 4, 2, 2, 4, 3, 1, 1, 2, 2, 1, 1, 3 };
			else if (intCurrentLevel == 90)
				aryColors = new int[] { 3, 1, 3, 3, 1, 3, 3, 3, 4, 2, 2, 1, 4, 4, 2, 1, 1, 2, 2, 4, 1, 2, 3, 1, 3, 2, 4, 1, 1, 4, 4, 2, 1, 2, 2, 3 };
			else if (intCurrentLevel == 91)
				aryColors = new int[] { 1, 4, 4, 4, 4, 2, 2, 2, 1, 3, 1, 4, 4, 4, 1, 3, 4, 4, 3, 1, 2, 4, 3, 4, 4, 3, 4, 2, 2, 1, 4, 1, 2, 1, 1, 1 };
			else if (intCurrentLevel == 92)
				aryColors = new int[] { 1, 4, 1, 4, 4, 1, 2, 3, 2, 1, 3, 2, 4, 3, 3, 2, 3, 1, 2, 2, 2, 2, 2, 4, 2, 1, 3, 1, 1, 4, 4, 3, 1, 2, 1, 1 };
			else if (intCurrentLevel == 93)
				aryColors = new int[] { 1, 4, 1, 3, 3, 3, 4, 3, 3, 1, 3, 1, 2, 3, 2, 3, 2, 4, 4, 4, 1, 3, 3, 4, 3, 4, 2, 2, 3, 2, 2, 2, 3, 2, 2, 3 };
			else if (intCurrentLevel == 94)
				aryColors = new int[] { 1, 3, 4, 3, 1, 2, 2, 4, 3, 3, 3, 4, 4, 1, 2, 2, 1, 4, 3, 4, 3, 4, 1, 1, 4, 2, 1, 4, 2, 2, 4, 1, 3, 2, 3, 2 };
			else if (intCurrentLevel == 95)
				aryColors = new int[] { 1, 1, 4, 4, 1, 1, 2, 1, 4, 2, 1, 4, 4, 4, 3, 2, 3, 2, 3, 3, 4, 3, 3, 4, 2, 3, 2, 1, 2, 1, 1, 1, 1, 2, 2, 4 };
			else if (intCurrentLevel == 96)
				aryColors = new int[] { 3, 3, 3, 3, 4, 4, 2, 2, 2, 2, 4, 4, 3, 1, 1, 2, 1, 1, 3, 4, 1, 1, 4, 1, 2, 4, 4, 3, 4, 1, 4, 3, 1, 2, 3, 1 };
			else if (intCurrentLevel == 97)
				aryColors = new int[] { 2, 3, 1, 1, 1, 1, 4, 4, 3, 3, 1, 2, 3, 1, 1, 3, 1, 4, 4, 2, 4, 3, 3, 4, 2, 1, 1, 3, 4, 2, 3, 2, 1, 2, 1, 3 };
			else if (intCurrentLevel == 98)
				aryColors = new int[] { 3, 4, 3, 3, 1, 2, 3, 2, 2, 1, 1, 4, 2, 2, 4, 1, 4, 2, 2, 2, 1, 4, 2, 1, 2, 1, 1, 4, 1, 2, 4, 2, 3, 2, 1, 1 };
			else if (intCurrentLevel == 99)
				aryColors = new int[] { 2, 3, 3, 1, 4, 4, 4, 4, 2, 2, 4, 1, 2, 1, 3, 3, 1, 2, 3, 3, 3, 2, 4, 1, 2, 3, 3, 1, 3, 2, 3, 1, 1, 1, 1, 2 };
			else if (intCurrentLevel == 100)
				aryColors = new int[] { 1, 3, 3, 3, 3, 3, 2, 4, 3, 2, 3, 1, 3, 2, 1, 1, 1, 4, 4, 4, 1, 3, 2, 1, 2, 1, 3, 2, 4, 1, 3, 2, 1, 3, 1, 3 };
			else
				aryColors = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		else if (setLevelState.getGridSize() == 7)
			if (intCurrentLevel == 1)
				aryColors = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		return aryColors;
	}

	public int[] getCirclePositions() {
		int[] aryCirclePos = new int[setLevelState.getTotalCircles()];
		if (setLevelState.getGridSize() == 5)
			if (intCurrentLevel == 0)
				aryCirclePos = new int[] { 0, 4, 6, 12, 8, 11, 13, 16, 17, 18, 20, 24 };
			else if (intCurrentLevel == 1)
				aryCirclePos = new int[] { 0, 1, 3, 4, 5, 8, 11, 12, 13, 15, 17, 20 };
			else if (intCurrentLevel == 2)
				aryCirclePos = new int[] { 0, 1, 2, 3, 4, 6, 13, 15, 16, 19, 22, 24 };
			else if (intCurrentLevel == 3)
				aryCirclePos = new int[] { 1, 4, 5, 7, 9, 11, 12, 13, 14, 19, 20, 24 };
			else if (intCurrentLevel == 4)
				aryCirclePos = new int[] { 0, 1, 4, 6, 7, 11, 12, 13, 16, 18, 21, 23 };
			else if (intCurrentLevel == 5)
				aryCirclePos = new int[] { 0, 2, 3, 7, 9, 10, 13, 15, 16, 17, 22, 23 };
			else if (intCurrentLevel == 6)
				aryCirclePos = new int[] { 0, 1, 2, 3, 8, 10, 11, 16, 17, 20, 22, 24 };
			else if (intCurrentLevel == 7)
				aryCirclePos = new int[] { 2, 7, 10, 11, 12, 13, 14, 15, 17, 18, 23, 24 };
			else if (intCurrentLevel == 8)
				aryCirclePos = new int[] { 0, 1, 2, 3, 7, 12, 13, 17, 19, 20, 22, 23 };
			else if (intCurrentLevel == 9)
				aryCirclePos = new int[] { 1, 3, 4, 7, 8, 11, 15, 17, 19, 21, 22, 24 };
			else if (intCurrentLevel == 10)
				aryCirclePos = new int[] { 0, 2, 3, 4, 5, 9, 10, 11, 13, 22, 23, 24 };
			else if (intCurrentLevel == 11)
				aryCirclePos = new int[] { 1, 4, 5, 6, 7, 8, 10, 13, 14, 16, 17, 21 };
			else if (intCurrentLevel == 12)
				aryCirclePos = new int[] { 3, 5, 6, 7, 11, 12, 13, 15, 17, 18, 20, 21 };
			else if (intCurrentLevel == 13)
				aryCirclePos = new int[] { 1, 2, 4, 8, 10, 11, 13, 15, 17, 18, 23, 24 };
			else if (intCurrentLevel == 14)
				aryCirclePos = new int[] { 1, 3, 4, 5, 6, 7, 9, 10, 17, 18, 20, 23 };
			else if (intCurrentLevel == 15)
				aryCirclePos = new int[] { 1, 3, 7, 8, 9, 12, 13, 14, 16, 18, 19, 23 };
			else if (intCurrentLevel == 16)
				aryCirclePos = new int[] { 0, 1, 4, 5, 6, 8, 11, 12, 15, 19, 21, 22 };
			else if (intCurrentLevel == 17)
				aryCirclePos = new int[] { 0, 1, 2, 4, 6, 7, 9, 12, 14, 16, 22, 23 };
			else if (intCurrentLevel == 18)
				aryCirclePos = new int[] { 2, 6, 8, 10, 12, 13, 14, 16, 17, 18, 19, 20 };
			else if (intCurrentLevel == 19)
				aryCirclePos = new int[] { 0, 2, 6, 7, 10, 15, 16, 17, 18, 19, 21, 23 };
			else if (intCurrentLevel == 20)
				aryCirclePos = new int[] { 0, 1, 5, 6, 7, 10, 12, 16, 17, 19, 21, 22 };
			else if (intCurrentLevel == 21)
				aryCirclePos = new int[] { 1, 2, 3, 9, 12, 13, 14, 17, 18, 20, 22, 23 };
			else if (intCurrentLevel == 22)
				aryCirclePos = new int[] { 1, 4, 6, 7, 9, 11, 13, 18, 19, 20, 21, 24 };
			else if (intCurrentLevel == 23)
				aryCirclePos = new int[] { 2, 7, 8, 9, 10, 12, 15, 18, 19, 20, 21, 24 };
			else if (intCurrentLevel == 24)
				aryCirclePos = new int[] { 0, 1, 4, 5, 6, 7, 12, 13, 16, 18, 20, 22 };
			else if (intCurrentLevel == 25)
				aryCirclePos = new int[] { 0, 3, 6, 7, 11, 12, 13, 15, 16, 17, 18, 23 };
			else if (intCurrentLevel == 26)
				aryCirclePos = new int[] { 0, 1, 2, 4, 6, 7, 9, 12, 14, 16, 22, 23 };
			else if (intCurrentLevel == 27)
				aryCirclePos = new int[] { 2, 6, 8, 10, 12, 13, 14, 16, 17, 18, 19, 20 };
			else if (intCurrentLevel == 28)
				aryCirclePos = new int[] { 0, 2, 6, 7, 10, 15, 16, 17, 18, 19, 21, 23 };
			else if (intCurrentLevel == 29)
				aryCirclePos = new int[] { 0, 1, 5, 6, 7, 10, 12, 16, 17, 19, 21, 22 };
			else if (intCurrentLevel == 30)
				aryCirclePos = new int[] { 3, 6, 8, 10, 11, 16, 17, 18, 19, 20, 21, 24 };
			else if (intCurrentLevel == 31)
				aryCirclePos = new int[] { 0, 1, 2, 4, 7, 8, 9, 11, 12, 15, 16, 24 };
			else if (intCurrentLevel == 32)
				aryCirclePos = new int[] { 0, 1, 5, 6, 8, 11, 13, 14, 20, 21, 22, 23 };
			else if (intCurrentLevel == 33)
				aryCirclePos = new int[] { 0, 2, 5, 6, 8, 12, 14, 17, 21, 22, 23, 24 };
			else if (intCurrentLevel == 34)
				aryCirclePos = new int[] { 0, 1, 3, 6, 7, 8, 9, 12, 16, 18, 19, 24 };
			else if (intCurrentLevel == 35)
				aryCirclePos = new int[] { 0, 4, 8, 9, 10, 11, 12, 14, 19, 22, 23, 24 };
			else if (intCurrentLevel == 36)
				aryCirclePos = new int[] { 1, 2, 3, 9, 12, 13, 14, 17, 18, 20, 22, 23 };
			else if (intCurrentLevel == 37)
				aryCirclePos = new int[] { 1, 4, 6, 7, 9, 11, 13, 18, 19, 20, 21, 24 };
			else if (intCurrentLevel == 38)
				aryCirclePos = new int[] { 2, 5, 6, 9, 10, 12, 17, 20, 21, 22, 23, 24 };
			else if (intCurrentLevel == 39)
				aryCirclePos = new int[] { 0, 1, 2, 4, 7, 10, 15, 16, 17, 18, 19, 23 };
			else if (intCurrentLevel == 40)
				aryCirclePos = new int[] { 1, 2, 3, 5, 8, 9, 10, 12, 16, 17, 21, 23 };
			else if (intCurrentLevel == 41)
				aryCirclePos = new int[] { 3, 8, 9, 10, 11, 12, 13, 14, 16, 20, 21, 22 };
			else if (intCurrentLevel == 42)
				aryCirclePos = new int[] { 2, 7, 8, 9, 10, 12, 15, 18, 19, 20, 21, 24 };
			else if (intCurrentLevel == 43)
				aryCirclePos = new int[] { 1, 4, 5, 7, 8, 9, 11, 15, 16, 17, 23, 24 };
			else if (intCurrentLevel == 44)
				aryCirclePos = new int[] { 3, 4, 5, 8, 13, 17, 18, 19, 20, 21, 22, 23 };
			else if (intCurrentLevel == 45)
				aryCirclePos = new int[] { 0, 1, 4, 5, 6, 7, 12, 13, 16, 18, 20, 22 };
			else if (intCurrentLevel == 46)
				aryCirclePos = new int[] { 2, 3, 4, 5, 7, 8, 12, 16, 17, 19, 20, 22 };
			else if (intCurrentLevel == 47)
				aryCirclePos = new int[] { 4, 5, 6, 7, 9, 12, 13, 16, 18, 19, 20, 23 };
			else if (intCurrentLevel == 48)
				aryCirclePos = new int[] { 0, 3, 6, 7, 11, 12, 13, 15, 16, 17, 18, 23 };
			else if (intCurrentLevel == 49)
				aryCirclePos = new int[] { 0, 1, 5, 8, 9, 12, 14, 15, 16, 18, 20, 22 };
			else if (intCurrentLevel == 50)
				aryCirclePos = new int[] { 1, 3, 4, 6, 7, 9, 15, 17, 19, 20, 22, 24 };
			else
				aryCirclePos = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		else if (setLevelState.getGridSize() == 6)
			if (intCurrentLevel == 1)
				aryCirclePos = new int[] { 0, 7, 8, 10, 11, 14, 16, 17, 19, 20, 23, 24, 25, 29, 33, 35 };
			else if (intCurrentLevel == 2)
				aryCirclePos = new int[] { 1, 4, 5, 7, 9, 11, 17, 19, 20, 21, 22, 23, 25, 28, 32, 33 };
			else if (intCurrentLevel == 3)
				aryCirclePos = new int[] { 1, 3, 4, 6, 7, 11, 13, 14, 16, 18, 20, 23, 25, 26, 28, 31 };
			else if (intCurrentLevel == 4)
				aryCirclePos = new int[] { 7, 10, 11, 12, 14, 16, 19, 21, 23, 26, 27, 28, 30, 31, 32, 34 };
			else if (intCurrentLevel == 5)
				aryCirclePos = new int[] { 1, 7, 8, 10, 12, 13, 14, 18, 19, 20, 22, 25, 26, 28, 31, 35 };
			else if (intCurrentLevel == 6)
				aryCirclePos = new int[] { 5, 7, 8, 9, 10, 13, 14, 15, 16, 18, 19, 20, 27, 29, 30, 31 };
			else if (intCurrentLevel == 7)
				aryCirclePos = new int[] { 0, 6, 8, 12, 15, 18, 19, 21, 22, 23, 25, 26, 29, 31, 32, 35 };
			else if (intCurrentLevel == 8)
				aryCirclePos = new int[] { 0, 7, 8, 10, 11, 14, 16, 17, 19, 20, 23, 24, 25, 29, 33, 35 };
			else if (intCurrentLevel == 9)
				aryCirclePos = new int[] { 2, 3, 4, 7, 8, 10, 11, 12, 13, 14, 17, 18, 20, 28, 30, 32 };
			else if (intCurrentLevel == 10)
				aryCirclePos = new int[] { 1, 5, 7, 11, 13, 15, 18, 20, 23, 24, 25, 26, 27, 30, 33, 34 };
			else if (intCurrentLevel == 11)
				aryCirclePos = new int[] { 1, 2, 5, 11, 12, 14, 15, 16, 17, 19, 20, 22, 25, 27, 34, 35 };
			else if (intCurrentLevel == 12)
				aryCirclePos = new int[] { 0, 5, 6, 7, 9, 10, 13, 15, 16, 19, 22, 25, 27, 30, 31, 35 };
			else if (intCurrentLevel == 13)
				aryCirclePos = new int[] { 0, 5, 6, 9, 11, 13, 15, 16, 17, 19, 20, 25, 26, 28, 30, 33 };
			else if (intCurrentLevel == 14)
				aryCirclePos = new int[] { 0, 2, 7, 9, 11, 12, 18, 19, 20, 21, 22, 25, 26, 30, 31, 34 };
			else if (intCurrentLevel == 15)
				aryCirclePos = new int[] { 1, 2, 3, 7, 10, 14, 15, 17, 18, 19, 20, 21, 23, 26, 31, 34 };
			else if (intCurrentLevel == 16)
				aryCirclePos = new int[] { 0, 1, 3, 5, 6, 11, 12, 13, 19, 22, 23, 25, 27, 30, 33, 35 };
			else if (intCurrentLevel == 17)
				aryCirclePos = new int[] { 0, 5, 6, 7, 9, 13, 16, 17, 19, 21, 22, 23, 27, 28, 34, 35 };
			else if (intCurrentLevel == 18)
				aryCirclePos = new int[] { 2, 3, 4, 5, 8, 10, 12, 14, 19, 22, 24, 25, 26, 27, 31, 35 };
			else if (intCurrentLevel == 19)
				aryCirclePos = new int[] { 1, 5, 6, 10, 11, 13, 14, 15, 17, 19, 21, 22, 25, 28, 29, 32 };
			else if (intCurrentLevel == 20)
				aryCirclePos = new int[] { 1, 3, 5, 6, 7, 9, 10, 12, 13, 16, 17, 20, 25, 29, 30, 35 };
			else if (intCurrentLevel == 21)
				aryCirclePos = new int[] { 0, 2, 3, 4, 5, 9, 10, 12, 13, 15, 18, 19, 20, 22, 26, 30 };
			else if (intCurrentLevel == 22)
				aryCirclePos = new int[] { 3, 5, 6, 9, 10, 13, 14, 16, 18, 19, 20, 22, 25, 26, 34, 35 };
			else if (intCurrentLevel == 23)
				aryCirclePos = new int[] { 2, 3, 4, 6, 8, 9, 13, 17, 18, 20, 21, 25, 28, 30, 33, 34 };
			else if (intCurrentLevel == 24)
				aryCirclePos = new int[] { 0, 1, 2, 3, 5, 9, 13, 17, 19, 20, 27, 29, 30, 33, 34, 35 };
			else if (intCurrentLevel == 25)
				aryCirclePos = new int[] { 0, 1, 4, 5, 10, 17, 19, 20, 22, 24, 25, 27, 28, 32, 33, 34 };
			else if (intCurrentLevel == 26)
				aryCirclePos = new int[] { 0, 4, 9, 13, 14, 16, 17, 18, 21, 22, 23, 27, 29, 30, 33, 34 };
			else if (intCurrentLevel == 27)
				aryCirclePos = new int[] { 0, 1, 3, 4, 6, 9, 10, 12, 14, 17, 18, 19, 20, 24, 25, 33 };
			else if (intCurrentLevel == 28)
				aryCirclePos = new int[] { 1, 2, 3, 4, 6, 7, 8, 11, 13, 16, 17, 24, 26, 27, 29, 35 };
			else if (intCurrentLevel == 29)
				aryCirclePos = new int[] { 0, 4, 6, 7, 9, 10, 11, 12, 15, 19, 20, 25, 27, 30, 32, 35 };
			else if (intCurrentLevel == 30)
				aryCirclePos = new int[] { 0, 1, 4, 5, 6, 11, 12, 14, 16, 19, 20, 22, 26, 33, 34, 35 };
			else if (intCurrentLevel == 31)
				aryCirclePos = new int[] { 0, 6, 8, 9, 10, 11, 13, 14, 20, 21, 22, 24, 25, 26, 29, 30 };
			else if (intCurrentLevel == 32)
				aryCirclePos = new int[] { 0, 2, 5, 7, 9, 11, 12, 14, 16, 20, 22, 23, 24, 28, 31, 34 };
			else if (intCurrentLevel == 33)
				aryCirclePos = new int[] { 1, 2, 4, 5, 9, 11, 12, 15, 17, 19, 23, 24, 25, 26, 33, 34 };
			else if (intCurrentLevel == 34)
				aryCirclePos = new int[] { 0, 1, 2, 3, 5, 6, 12, 13, 16, 20, 21, 22, 27, 28, 34, 35 };
			else if (intCurrentLevel == 35)
				aryCirclePos = new int[] { 1, 2, 5, 8, 9, 12, 13, 16, 20, 22, 25, 26, 28, 29, 30, 34 };
			else if (intCurrentLevel == 36)
				aryCirclePos = new int[] { 1, 3, 4, 14, 18, 20, 21, 22, 23, 24, 25, 28, 29, 30, 32, 34 };
			else if (intCurrentLevel == 37)
				aryCirclePos = new int[] { 0, 2, 3, 4, 8, 9, 11, 12, 14, 19, 22, 27, 29, 30, 31, 35 };
			else if (intCurrentLevel == 38)
				aryCirclePos = new int[] { 0, 5, 6, 8, 13, 14, 15, 16, 17, 18, 21, 23, 24, 26, 30, 33 };
			else if (intCurrentLevel == 39)
				aryCirclePos = new int[] { 2, 3, 4, 5, 8, 11, 12, 18, 21, 22, 23, 28, 29, 31, 32, 33 };
			else if (intCurrentLevel == 40)
				aryCirclePos = new int[] { 1, 4, 5, 6, 9, 10, 13, 17, 19, 21, 27, 29, 30, 32, 33, 34 };
			else if (intCurrentLevel == 41)
				aryCirclePos = new int[] { 0, 1, 2, 6, 9, 10, 13, 15, 16, 18, 19, 21, 22, 23, 31, 32 };
			else if (intCurrentLevel == 42)
				aryCirclePos = new int[] { 0, 1, 4, 5, 9, 10, 13, 15, 19, 21, 25, 26, 28, 30, 33, 35 };
			else if (intCurrentLevel == 43)
				aryCirclePos = new int[] { 1, 3, 6, 8, 10, 15, 18, 19, 20, 22, 23, 24, 29, 30, 32, 34 };
			else if (intCurrentLevel == 44)
				aryCirclePos = new int[] { 1, 5, 7, 8, 10, 11, 12, 13, 14, 15, 17, 19, 26, 31, 32, 33 };
			else if (intCurrentLevel == 45)
				aryCirclePos = new int[] { 0, 3, 5, 9, 16, 19, 20, 21, 23, 24, 25, 27, 29, 30, 32, 34 };
			else if (intCurrentLevel == 46)
				aryCirclePos = new int[] { 0, 5, 7, 8, 10, 14, 15, 17, 20, 21, 22, 25, 26, 28, 32, 35 };
			else if (intCurrentLevel == 47)
				aryCirclePos = new int[] { 1, 2, 5, 7, 9, 12, 14, 16, 17, 18, 19, 22, 23, 25, 30, 32 };
			else if (intCurrentLevel == 48)
				aryCirclePos = new int[] { 1, 4, 5, 6, 7, 8, 12, 14, 15, 16, 17, 19, 23, 30, 31, 35 };
			else if (intCurrentLevel == 49)
				aryCirclePos = new int[] { 2, 6, 7, 8, 9, 13, 21, 22, 25, 26, 27, 30, 31, 33, 34, 35 };
			else if (intCurrentLevel == 50)
				aryCirclePos = new int[] { 0, 3, 5, 7, 8, 11, 13, 14, 15, 19, 23, 25, 28, 29, 31, 34 };
			else if (intCurrentLevel == 51)
				aryCirclePos = new int[] { 2, 4, 6, 7, 9, 12, 13, 16, 18, 21, 22, 24, 25, 29, 33, 34 };
			else if (intCurrentLevel == 52)
				aryCirclePos = new int[] { 0, 2, 3, 8, 9, 10, 12, 13, 17, 20, 21, 22, 24, 26, 33, 34 };
			else if (intCurrentLevel == 53)
				aryCirclePos = new int[] { 2, 3, 5, 9, 10, 11, 14, 16, 19, 20, 21, 22, 27, 29, 30, 31 };
			else if (intCurrentLevel == 54)
				aryCirclePos = new int[] { 1, 7, 10, 12, 13, 15, 16, 17, 19, 24, 25, 26, 27, 30, 32, 34 };
			else if (intCurrentLevel == 55)
				aryCirclePos = new int[] { 1, 2, 4, 9, 13, 15, 16, 22, 23, 24, 25, 28, 32, 33, 34, 35 };
			else if (intCurrentLevel == 56)
				aryCirclePos = new int[] { 2, 3, 4, 5, 7, 9, 11, 12, 16, 17, 21, 23, 26, 28, 29, 30 };
			else if (intCurrentLevel == 57)
				aryCirclePos = new int[] { 0, 8, 9, 10, 11, 14, 19, 22, 23, 25, 26, 28, 31, 32, 33, 34 };
			else if (intCurrentLevel == 58)
				aryCirclePos = new int[] { 0, 6, 10, 11, 12, 13, 14, 18, 19, 22, 24, 25, 27, 32, 33, 35 };
			else if (intCurrentLevel == 59)
				aryCirclePos = new int[] { 0, 2, 3, 5, 6, 7, 8, 11, 12, 15, 20, 23, 26, 27, 29, 30 };
			else if (intCurrentLevel == 60)
				aryCirclePos = new int[] { 0, 3, 4, 8, 10, 16, 17, 20, 21, 23, 24, 29, 30, 33, 34, 35 };
			else if (intCurrentLevel == 61)
				aryCirclePos = new int[] { 2, 6, 7, 8, 9, 10, 13, 14, 15, 19, 20, 24, 25, 29, 33, 35 };
			else if (intCurrentLevel == 62)
				aryCirclePos = new int[] { 9, 10, 13, 14, 15, 18, 20, 21, 22, 25, 27, 29, 31, 32, 33, 34 };
			else if (intCurrentLevel == 63)
				aryCirclePos = new int[] { 1, 2, 6, 7, 8, 9, 10, 11, 18, 19, 20, 26, 31, 33, 34, 35 };
			else if (intCurrentLevel == 64)
				aryCirclePos = new int[] { 1, 2, 4, 11, 15, 18, 19, 21, 23, 26, 27, 28, 31, 33, 34, 35 };
			else if (intCurrentLevel == 65)
				aryCirclePos = new int[] { 0, 1, 2, 6, 7, 8, 14, 15, 16, 24, 26, 27, 28, 29, 33, 34 };
			else if (intCurrentLevel == 66)
				aryCirclePos = new int[] { 0, 4, 6, 7, 8, 10, 12, 15, 17, 18, 23, 24, 28, 31, 32, 34 };
			else if (intCurrentLevel == 67)
				aryCirclePos = new int[] { 0, 1, 2, 3, 7, 10, 11, 14, 22, 23, 25, 26, 28, 29, 31, 34 };
			else if (intCurrentLevel == 68)
				aryCirclePos = new int[] { 0, 1, 5, 8, 12, 14, 15, 16, 17, 20, 26, 27, 28, 29, 30, 32 };
			else if (intCurrentLevel == 69)
				aryCirclePos = new int[] { 6, 7, 8, 9, 10, 13, 14, 23, 25, 26, 28, 29, 30, 31, 32, 33 };
			else if (intCurrentLevel == 70)
				aryCirclePos = new int[] { 0, 2, 3, 4, 6, 8, 10, 12, 17, 20, 22, 27, 28, 29, 30, 34 };
			else if (intCurrentLevel == 71)
				aryCirclePos = new int[] { 0, 1, 4, 5, 7, 8, 13, 15, 18, 22, 23, 25, 26, 27, 29, 30 };
			else if (intCurrentLevel == 72)
				aryCirclePos = new int[] { 0, 1, 2, 7, 10, 12, 13, 15, 16, 18, 19, 21, 24, 31, 33, 35 };
			else if (intCurrentLevel == 73)
				aryCirclePos = new int[] { 1, 2, 3, 6, 7, 10, 14, 19, 20, 24, 29, 30, 31, 32, 34, 35 };
			else if (intCurrentLevel == 74)
				aryCirclePos = new int[] { 4, 6, 7, 8, 9, 12, 15, 17, 21, 27, 29, 31, 32, 33, 34, 35 };
			else if (intCurrentLevel == 75)
				aryCirclePos = new int[] { 0, 1, 2, 4, 6, 7, 9, 12, 14, 18, 20, 21, 23, 26, 27, 30 };
			else if (intCurrentLevel == 76)
				aryCirclePos = new int[] { 2, 3, 4, 5, 6, 10, 12, 15, 18, 22, 25, 26, 27, 28, 34, 35 };
			else if (intCurrentLevel == 77)
				aryCirclePos = new int[] { 0, 1, 2, 4, 5, 6, 7, 13, 17, 19, 25, 30, 32, 33, 34, 35 };
			else if (intCurrentLevel == 78)
				aryCirclePos = new int[] { 2, 4, 7, 12, 15, 17, 19, 21, 22, 24, 25, 29, 31, 32, 33, 34 };
			else if (intCurrentLevel == 79)
				aryCirclePos = new int[] { 3, 6, 7, 8, 9, 11, 13, 14, 16, 22, 23, 25, 26, 30, 31, 35 };
			else if (intCurrentLevel == 80)
				aryCirclePos = new int[] { 4, 6, 8, 9, 10, 11, 12, 14, 21, 22, 23, 26, 27, 28, 32, 35 };
			else if (intCurrentLevel == 81)
				aryCirclePos = new int[] { 1, 2, 5, 6, 8, 13, 14, 16, 17, 19, 20, 23, 25, 30, 32, 33 };
			else if (intCurrentLevel == 82)
				aryCirclePos = new int[] { 0, 1, 8, 13, 18, 19, 21, 24, 25, 26, 27, 28, 30, 33, 34, 35 };
			else if (intCurrentLevel == 83)
				aryCirclePos = new int[] { 1, 2, 3, 5, 12, 14, 15, 17, 18, 20, 28, 29, 30, 31, 32, 34 };
			else if (intCurrentLevel == 84)
				aryCirclePos = new int[] { 0, 3, 6, 8, 9, 10, 11, 12, 14, 15, 20, 24, 27, 28, 33, 35 };
			else if (intCurrentLevel == 85)
				aryCirclePos = new int[] { 1, 2, 5, 9, 10, 13, 14, 16, 17, 20, 25, 26, 27, 32, 33, 35 };
			else if (intCurrentLevel == 86)
				aryCirclePos = new int[] { 0, 3, 7, 8, 9, 12, 13, 14, 16, 18, 19, 21, 22, 23, 26, 35 };
			else if (intCurrentLevel == 87)
				aryCirclePos = new int[] { 0, 1, 3, 5, 6, 8, 9, 12, 13, 15, 16, 17, 23, 30, 34, 35 };
			else if (intCurrentLevel == 88)
				aryCirclePos = new int[] { 0, 1, 2, 6, 7, 9, 14, 15, 17, 21, 22, 23, 26, 31, 32, 35 };
			else if (intCurrentLevel == 89)
				aryCirclePos = new int[] { 1, 3, 4, 6, 7, 9, 13, 17, 18, 20, 23, 24, 25, 26, 27, 29 };
			else if (intCurrentLevel == 90)
				aryCirclePos = new int[] { 0, 3, 4, 5, 7, 10, 11, 15, 20, 23, 24, 26, 28, 29, 33, 34 };
			else if (intCurrentLevel == 91)
				aryCirclePos = new int[] { 0, 2, 8, 10, 14, 15, 16, 17, 18, 21, 22, 23, 25, 27, 30, 31 };
			else if (intCurrentLevel == 92)
				aryCirclePos = new int[] { 0, 1, 3, 4, 5, 11, 14, 15, 16, 17, 22, 25, 27, 30, 32, 35 };
			else if (intCurrentLevel == 93)
				aryCirclePos = new int[] { 0, 2, 3, 7, 10, 11, 13, 16, 21, 22, 25, 27, 28, 31, 32, 34 };
			else if (intCurrentLevel == 94)
				aryCirclePos = new int[] { 0, 2, 3, 4, 6, 7, 12, 15, 18, 22, 23, 24, 31, 33, 34, 35 };
			else if (intCurrentLevel == 95)
				aryCirclePos = new int[] { 0, 2, 7, 8, 9, 11, 14, 18, 20, 21, 22, 23, 25, 26, 32, 33 };
			else if (intCurrentLevel == 96)
				aryCirclePos = new int[] { 1, 2, 4, 5, 6, 7, 9, 11, 13, 15, 19, 20, 21, 26, 30, 32 };
			else if (intCurrentLevel == 97)
				aryCirclePos = new int[] { 1, 2, 3, 9, 11, 13, 16, 18, 20, 21, 22, 23, 24, 25, 33, 35 };
			else if (intCurrentLevel == 98)
				aryCirclePos = new int[] { 0, 2, 3, 5, 7, 9, 10, 12, 14, 18, 24, 25, 26, 27, 30, 32 };
			else if (intCurrentLevel == 99)
				aryCirclePos = new int[] { 2, 4, 5, 10, 11, 12, 13, 14, 15, 16, 17, 23, 27, 29, 33, 35 };
			else if (intCurrentLevel == 100)
				aryCirclePos = new int[] { 1, 4, 8, 11, 12, 13, 14, 16, 18, 19, 20, 22, 29, 30, 31, 33 };
			else
				aryCirclePos = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		else if (setLevelState.getGridSize() == 7)
			if (intCurrentLevel == 1)
				aryCirclePos = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24 };
		// This will line all the circles up in the Middle for 6x6 Grid
		/*
		 * if (setLevelState.getGridSize() == 6) { for (int i = 0; i < aryCirclePos.length; i++) { int intRow = (i / (setLevelState.getGridSize() - 2)) + 1; int intCounter = i % (setLevelState.getGridSize() - 2);
		 * 
		 * aryCirclePos[i] = (intRow * setLevelState.getGridSize()) + intCounter + 1; } }
		 */
		return aryCirclePos;
	}

	public int[] getCircleColors() {
		// NoColor = 0; Red = 1; Blue = 2; Yellow = 3; Green = 4;
		int[] aryCircleColors = null;

		// 7,9,10,23,25

		if (setLevelState.getGridSize() == 5)
			if (intCurrentLevel == 0)
				aryCircleColors = new int[] { 1, 3, 2, 1, 2, 2, 3, 4, 4, 4, 1, 3 };
			else if (intCurrentLevel == 1)
				aryCircleColors = new int[] { 1, 3, 3, 4, 2, 3, 1, 1, 4, 4, 2, 2 };
			else if (intCurrentLevel == 2)
				aryCircleColors = new int[] { 2, 4, 3, 4, 3, 2, 3, 4, 1, 1, 1, 2 };
			else if (intCurrentLevel == 3)
				aryCircleColors = new int[] { 3, 2, 2, 3, 2, 3, 4, 1, 4, 1, 1, 4 };
			else if (intCurrentLevel == 4)
				aryCircleColors = new int[] { 3, 4, 4, 2, 3, 3, 4, 2, 2, 1, 1, 1 };
			else if (intCurrentLevel == 5)
				aryCircleColors = new int[] { 2, 3, 1, 1, 4, 3, 4, 4, 3, 2, 1, 2 };
			else if (intCurrentLevel == 6)
				aryCircleColors = new int[] { 2, 3, 4, 4, 2, 3, 4, 1, 1, 3, 2, 1 };
			else if (intCurrentLevel == 7)
				aryCircleColors = new int[] { 3, 1, 2, 2, 4, 4, 4, 3, 1, 2, 1, 3 };
			else if (intCurrentLevel == 8)
				aryCircleColors = new int[] { 2, 3, 3, 1, 2, 3, 4, 4, 4, 1, 1, 2 };
			else if (intCurrentLevel == 9)
				aryCircleColors = new int[] { 4, 3, 1, 1, 3, 4, 3, 1, 2, 2, 2, 4 };
			else if (intCurrentLevel == 10)
				aryCircleColors = new int[] { 2, 4, 1, 3, 2, 4, 3, 4, 2, 1, 3, 1 };
			else if (intCurrentLevel == 11)
				aryCircleColors = new int[] { 4, 2, 2, 3, 1, 1, 4, 3, 4, 3, 2, 1 };
			else if (intCurrentLevel == 12)
				aryCircleColors = new int[] { 4, 2, 1, 2, 1, 3, 2, 3, 4, 3, 4, 1 };
			else if (intCurrentLevel == 13)
				aryCircleColors = new int[] { 1, 1, 4, 3, 3, 1, 2, 4, 2, 2, 3, 4 };
			else if (intCurrentLevel == 14)
				aryCircleColors = new int[] { 3, 3, 1, 3, 2, 4, 4, 2, 4, 2, 1, 1 };
			else if (intCurrentLevel == 15)
				aryCircleColors = new int[] { 3, 1, 4, 2, 4, 1, 1, 2, 3, 2, 4, 3 };
			else if (intCurrentLevel == 16)
				aryCircleColors = new int[] { 2, 1, 3, 3, 4, 2, 4, 4, 3, 1, 1, 2 };
			else if (intCurrentLevel == 17)
				aryCircleColors = new int[] { 3, 4, 3, 1, 3, 4, 2, 1, 4, 2, 2, 1 };
			else if (intCurrentLevel == 18)
				aryCircleColors = new int[] { 1, 3, 4, 3, 2, 1, 2, 3, 4, 1, 4, 2 };
			else if (intCurrentLevel == 19)
				aryCircleColors = new int[] { 1, 3, 4, 3, 2, 4, 1, 3, 2, 4, 2, 1 };
			else if (intCurrentLevel == 20)
				aryCircleColors = new int[] { 1, 1, 2, 3, 3, 2, 4, 4, 2, 4, 3, 1 };
			else if (intCurrentLevel == 21)
				aryCircleColors = new int[] { 1, 3, 3, 4, 4, 1, 2, 1, 2, 4, 3, 2 };
			else if (intCurrentLevel == 22)
				aryCircleColors = new int[] { 3, 4, 3, 4, 1, 3, 1, 2, 2, 1, 2, 4 };
			else if (intCurrentLevel == 23)
				aryCircleColors = new int[] { 1, 3, 3, 1, 4, 1, 2, 4, 2, 3, 2, 4 };
			else if (intCurrentLevel == 24)
				aryCircleColors = new int[] { 1, 4, 3, 2, 1, 3, 1, 4, 3, 2, 4, 2 };
			else if (intCurrentLevel == 25)
				aryCircleColors = new int[] { 2, 3, 4, 4, 2, 1, 3, 3, 1, 1, 4, 2 };
			else if (intCurrentLevel == 26)
				aryCircleColors = new int[] { 3, 4, 3, 1, 3, 4, 2, 1, 4, 2, 2, 1 };
			else if (intCurrentLevel == 27)
				aryCircleColors = new int[] { 1, 3, 4, 3, 2, 1, 2, 3, 4, 1, 4, 2 };
			else if (intCurrentLevel == 28)
				aryCircleColors = new int[] { 1, 3, 4, 3, 2, 4, 1, 3, 2, 4, 2, 1 };
			else if (intCurrentLevel == 29)
				aryCircleColors = new int[] { 1, 1, 2, 3, 3, 2, 4, 4, 2, 4, 3, 1 };
			else if (intCurrentLevel == 30)
				aryCircleColors = new int[] { 4, 4, 2, 3, 1, 4, 3, 1, 1, 2, 3, 2 };
			else if (intCurrentLevel == 31)
				aryCircleColors = new int[] { 1, 4, 3, 2, 4, 1, 2, 2, 3, 3, 4, 1 };
			else if (intCurrentLevel == 32)
				aryCircleColors = new int[] { 2, 3, 2, 1, 4, 3, 1, 4, 4, 3, 1, 2 };
			else if (intCurrentLevel == 33)
				aryCircleColors = new int[] { 2, 4, 3, 4, 1, 2, 4, 2, 3, 3, 1, 1 };
			else if (intCurrentLevel == 34)
				aryCircleColors = new int[] { 1, 3, 3, 4, 2, 1, 4, 2, 3, 1, 2, 4 };
			else if (intCurrentLevel == 35)
				aryCircleColors = new int[] { 3, 4, 1, 1, 2, 3, 3, 2, 4, 2, 1, 4 };
			else if (intCurrentLevel == 36)
				aryCircleColors = new int[] { 1, 3, 3, 4, 4, 1, 2, 1, 2, 4, 3, 2 };
			else if (intCurrentLevel == 37)
				aryCircleColors = new int[] { 3, 4, 3, 4, 1, 3, 1, 2, 2, 1, 2, 4 };
			else if (intCurrentLevel == 38)
				aryCircleColors = new int[] { 4, 4, 1, 4, 3, 2, 3, 3, 1, 2, 1, 2 };
			else if (intCurrentLevel == 39)
				aryCircleColors = new int[] { 4, 4, 3, 4, 2, 3, 2, 3, 1, 1, 1, 2 };
			else if (intCurrentLevel == 40)
				aryCircleColors = new int[] { 1, 1, 4, 3, 4, 2, 3, 4, 3, 2, 2, 1 };
			else if (intCurrentLevel == 41)
				aryCircleColors = new int[] { 1, 4, 1, 2, 4, 2, 2, 4, 3, 1, 3, 3 };
			else if (intCurrentLevel == 42)
				aryCircleColors = new int[] { 1, 3, 3, 1, 4, 1, 2, 4, 2, 3, 2, 4 };
			else if (intCurrentLevel == 43)
				aryCircleColors = new int[] { 4, 1, 2, 4, 2, 4, 3, 3, 1, 2, 3, 1 };
			else if (intCurrentLevel == 44)
				aryCircleColors = new int[] { 4, 3, 4, 1, 3, 3, 1, 4, 2, 2, 2, 1 };
			else if (intCurrentLevel == 45)
				aryCircleColors = new int[] { 1, 4, 3, 2, 1, 3, 1, 4, 3, 2, 4, 2 };
			else if (intCurrentLevel == 46)
				aryCircleColors = new int[] { 1, 3, 2, 2, 4, 3, 4, 1, 1, 4, 3, 2 };
			else if (intCurrentLevel == 47)
				aryCircleColors = new int[] { 3, 2, 4, 4, 1, 3, 3, 1, 1, 4, 2, 2 };
			else if (intCurrentLevel == 48)
				aryCircleColors = new int[] { 2, 3, 4, 4, 2, 1, 3, 3, 1, 1, 4, 2 };
			else if (intCurrentLevel == 49)
				aryCircleColors = new int[] { 3, 3, 4, 1, 4, 3, 2, 2, 1, 4, 2, 1 };
			else if (intCurrentLevel == 50)
				aryCircleColors = new int[] { 1, 4, 2, 2, 3, 1, 2, 3, 4, 4, 3, 1 };
			else
				aryCircleColors = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		else if (setLevelState.getGridSize() == 6)
			if (intCurrentLevel == 1)
				aryCircleColors = new int[] { 1, 3, 3, 1, 4, 2, 1, 4, 2, 3, 1, 2, 4, 4, 3, 2 };
			else if (intCurrentLevel == 2)
				aryCircleColors = new int[] { 4, 1, 4, 3, 3, 4, 4, 1, 3, 1, 2, 1, 3, 2, 2, 2 };
			else if (intCurrentLevel == 3)
				aryCircleColors = new int[] { 1, 3, 4, 4, 2, 4, 1, 4, 3, 3, 2, 2, 1, 2, 3, 1 };
			else if (intCurrentLevel == 4)
				aryCircleColors = new int[] { 3, 1, 2, 4, 3, 1, 4, 2, 4, 3, 2, 2, 4, 3, 1, 1 };
			else if (intCurrentLevel == 5)
				aryCircleColors = new int[] { 1, 3, 4, 4, 4, 2, 2, 2, 4, 2, 3, 3, 1, 1, 1, 3 };
			else if (intCurrentLevel == 6)
				aryCircleColors = new int[] { 3, 2, 3, 1, 1, 4, 4, 1, 2, 3, 4, 1, 4, 2, 3, 2 };
			else if (intCurrentLevel == 7)
				aryCircleColors = new int[] { 4, 4, 1, 3, 3, 4, 1, 2, 3, 1, 2, 2, 4, 3, 1, 2 };
			else if (intCurrentLevel == 8)
				aryCircleColors = new int[] { 1, 3, 3, 1, 4, 2, 1, 4, 2, 3, 1, 2, 4, 4, 3, 2 };
			else if (intCurrentLevel == 9)
				aryCircleColors = new int[] { 4, 3, 1, 4, 3, 3, 1, 2, 2, 2, 4, 2, 4, 3, 1, 1 };
			else if (intCurrentLevel == 10)
				aryCircleColors = new int[] { 1, 1, 3, 4, 2, 3, 3, 2, 2, 4, 4, 4, 1, 1, 2, 3 };
			else if (intCurrentLevel == 11)
				aryCircleColors = new int[] { 4, 3, 2, 4, 4, 3, 4, 2, 1, 1, 3, 2, 1, 3, 2, 1 };
			else if (intCurrentLevel == 12)
				aryCircleColors = new int[] { 1, 4, 3, 1, 3, 2, 3, 2, 4, 2, 1, 4, 2, 4, 3, 1 };
			else if (intCurrentLevel == 13)
				aryCircleColors = new int[] { 4, 2, 2, 3, 1, 3, 4, 3, 1, 1, 2, 4, 1, 4, 3, 2 };
			else if (intCurrentLevel == 14)
				aryCircleColors = new int[] { 1, 3, 4, 2, 1, 3, 4, 2, 1, 3, 4, 1, 2, 4, 3, 2 };
			else if (intCurrentLevel == 15)
				aryCircleColors = new int[] { 4, 4, 3, 1, 1, 4, 4, 1, 3, 2, 3, 2, 1, 2, 2, 3 };
			else if (intCurrentLevel == 16)
				aryCircleColors = new int[] { 2, 4, 3, 1, 3, 2, 2, 4, 3, 3, 2, 4, 4, 1, 1, 1 };
			else if (intCurrentLevel == 17)
				aryCircleColors = new int[] { 1, 3, 2, 2, 3, 4, 1, 1, 2, 3, 4, 4, 4, 1, 3, 2 };
			else if (intCurrentLevel == 18)
				aryCircleColors = new int[] { 3, 4, 3, 1, 1, 4, 2, 4, 2, 1, 2, 1, 4, 2, 3, 3 };
			else if (intCurrentLevel == 19)
				aryCircleColors = new int[] { 1, 3, 4, 2, 4, 4, 3, 3, 2, 3, 4, 1, 1, 2, 2, 1 };
			else if (intCurrentLevel == 20)
				aryCircleColors = new int[] { 1, 3, 1, 4, 2, 3, 3, 2, 1, 2, 1, 4, 4, 4, 3, 2 };
			else if (intCurrentLevel == 21)
				aryCircleColors = new int[] { 3, 4, 1, 3, 4, 2, 4, 3, 1, 1, 2, 3, 2, 1, 2, 4 };
			else if (intCurrentLevel == 22)
				aryCircleColors = new int[] { 3, 1, 2, 4, 1, 3, 4, 3, 2, 4, 1, 2, 4, 1, 3, 2 };
			else if (intCurrentLevel == 23)
				aryCircleColors = new int[] { 3, 3, 1, 4, 4, 1, 2, 1, 4, 1, 2, 3, 4, 2, 3, 2 };
			else if (intCurrentLevel == 24)
				aryCircleColors = new int[] { 2, 3, 4, 3, 1, 3, 1, 1, 1, 2, 4, 2, 4, 2, 3, 4 };
			else if (intCurrentLevel == 25)
				aryCircleColors = new int[] { 2, 1, 1, 4, 2, 4, 4, 1, 3, 4, 3, 3, 1, 2, 3, 2 };
			else if (intCurrentLevel == 26)
				aryCircleColors = new int[] { 4, 4, 4, 3, 2, 3, 1, 2, 3, 4, 1, 2, 1, 3, 1, 2 };
			else if (intCurrentLevel == 27)
				aryCircleColors = new int[] { 3, 3, 1, 4, 2, 3, 1, 4, 2, 1, 2, 3, 4, 4, 1, 2 };
			else if (intCurrentLevel == 28)
				aryCircleColors = new int[] { 1, 4, 1, 4, 3, 3, 2, 1, 3, 3, 2, 4, 4, 2, 1, 2 };
			else if (intCurrentLevel == 29)
				aryCircleColors = new int[] { 2, 1, 4, 4, 1, 2, 2, 3, 3, 4, 1, 2, 4, 3, 3, 1 };
			else if (intCurrentLevel == 30)
				aryCircleColors = new int[] { 2, 4, 1, 2, 2, 1, 2, 4, 3, 4, 1, 4, 3, 3, 3, 1 };
			else if (intCurrentLevel == 31)
				aryCircleColors = new int[] { 2, 3, 2, 4, 1, 1, 2, 3, 4, 1, 4, 3, 3, 4, 2, 1 };
			else if (intCurrentLevel == 32)
				aryCircleColors = new int[] { 3, 1, 4, 3, 1, 4, 3, 4, 2, 1, 4, 2, 2, 3, 2, 1 };
			else if (intCurrentLevel == 33)
				aryCircleColors = new int[] { 1, 4, 1, 3, 4, 1, 3, 3, 4, 2, 4, 2, 1, 3, 2, 2 };
			else if (intCurrentLevel == 34)
				aryCircleColors = new int[] { 3, 3, 4, 1, 3, 2, 2, 4, 2, 2, 4, 3, 4, 1, 1, 1 };
			else if (intCurrentLevel == 35)
				aryCircleColors = new int[] { 3, 3, 1, 2, 2, 3, 2, 4, 1, 2, 4, 4, 4, 1, 1, 3 };
			else if (intCurrentLevel == 36)
				aryCircleColors = new int[] { 3, 4, 3, 2, 4, 3, 1, 4, 1, 4, 1, 2, 2, 1, 2, 3 };
			else if (intCurrentLevel == 37)
				aryCircleColors = new int[] { 1, 3, 3, 1, 3, 2, 4, 4, 3, 4, 4, 2, 1, 1, 2, 2 };
			else if (intCurrentLevel == 38)
				aryCircleColors = new int[] { 2, 3, 3, 1, 2, 4, 4, 2, 1, 4, 3, 1, 4, 1, 2, 3 };
			else if (intCurrentLevel == 39)
				aryCircleColors = new int[] { 3, 4, 1, 1, 3, 1, 4, 4, 4, 3, 2, 2, 1, 2, 2, 3 };
			else if (intCurrentLevel == 40)
				aryCircleColors = new int[] { 3, 4, 3, 2, 4, 1, 2, 1, 3, 4, 1, 2, 4, 3, 1, 2 };
			else if (intCurrentLevel == 41)
				aryCircleColors = new int[] { 4, 1, 4, 4, 2, 3, 2, 4, 1, 3, 3, 1, 1, 2, 2, 3 };
			else if (intCurrentLevel == 42)
				aryCircleColors = new int[] { 1, 3, 3, 1, 2, 2, 4, 2, 3, 1, 2, 4, 4, 1, 3, 4 };
			else if (intCurrentLevel == 43)
				aryCircleColors = new int[] { 1, 4, 4, 1, 1, 3, 4, 2, 2, 1, 4, 3, 2, 2, 3, 3 };
			else if (intCurrentLevel == 44)
				aryCircleColors = new int[] { 1, 3, 3, 4, 1, 4, 2, 1, 2, 4, 2, 4, 3, 1, 2, 3 };
			else if (intCurrentLevel == 45)
				aryCircleColors = new int[] { 4, 3, 1, 2, 2, 3, 4, 3, 4, 2, 4, 1, 2, 3, 1, 1 };
			else if (intCurrentLevel == 46)
				aryCircleColors = new int[] { 1, 3, 3, 3, 4, 3, 1, 2, 4, 4, 2, 2, 2, 4, 1, 1 };
			else if (intCurrentLevel == 47)
				aryCircleColors = new int[] { 1, 1, 3, 2, 4, 4, 4, 3, 4, 3, 2, 3, 2, 1, 1, 2 };
			else if (intCurrentLevel == 48)
				aryCircleColors = new int[] { 1, 4, 4, 3, 3, 3, 4, 2, 4, 1, 1, 2, 2, 3, 2, 1 };
			else if (intCurrentLevel == 49)
				aryCircleColors = new int[] { 3, 4, 3, 2, 2, 4, 1, 2, 1, 2, 1, 4, 3, 3, 1, 4 };
			else if (intCurrentLevel == 50)
				aryCircleColors = new int[] { 4, 4, 3, 1, 2, 1, 3, 2, 3, 3, 4, 1, 4, 1, 2, 2 };
			else if (intCurrentLevel == 51)
				aryCircleColors = new int[] { 3, 1, 2, 3, 2, 4, 1, 4, 4, 2, 3, 2, 4, 1, 3, 1 };
			else if (intCurrentLevel == 52)
				aryCircleColors = new int[] { 3, 4, 1, 4, 2, 3, 3, 3, 4, 1, 4, 1, 2, 2, 2, 1 };
			else if (intCurrentLevel == 53)
				aryCircleColors = new int[] { 1, 1, 3, 1, 1, 4, 4, 3, 2, 2, 2, 3, 4, 2, 4, 3 };
			else if (intCurrentLevel == 54)
				aryCircleColors = new int[] { 1, 1, 4, 2, 3, 3, 3, 4, 4, 3, 2, 2, 1, 4, 2, 1 };
			else if (intCurrentLevel == 55)
				aryCircleColors = new int[] { 1, 4, 3, 4, 1, 4, 4, 3, 1, 2, 3, 2, 1, 3, 2, 2 };
			else if (intCurrentLevel == 56)
				aryCircleColors = new int[] { 1, 4, 1, 1, 2, 3, 1, 4, 2, 2, 2, 4, 3, 3, 4, 3 };
			else if (intCurrentLevel == 57)
				aryCircleColors = new int[] { 2, 2, 1, 2, 4, 4, 3, 3, 4, 4, 3, 2, 1, 3, 1, 1 };
			else if (intCurrentLevel == 58)
				aryCircleColors = new int[] { 4, 3, 1, 2, 2, 4, 3, 3, 2, 1, 4, 4, 1, 2, 1, 3 };
			else if (intCurrentLevel == 59)
				aryCircleColors = new int[] { 2, 3, 3, 1, 4, 1, 4, 1, 3, 4, 2, 2, 3, 4, 1, 2 };
			else if (intCurrentLevel == 60)
				aryCircleColors = new int[] { 4, 3, 1, 4, 2, 3, 1, 1, 2, 1, 4, 4, 2, 3, 2, 3 };
			else if (intCurrentLevel == 61)
				aryCircleColors = new int[] { 3, 4, 3, 4, 1, 4, 1, 2, 1, 2, 1, 3, 4, 2, 3, 2 };
			else if (intCurrentLevel == 62)
				aryCircleColors = new int[] { 1, 3, 2, 4, 2, 3, 2, 4, 4, 3, 4, 1, 3, 1, 2, 1 };
			else if (intCurrentLevel == 63)
				aryCircleColors = new int[] { 3, 4, 3, 4, 4, 1, 4, 1, 3, 2, 2, 1, 2, 2, 3, 1 };
			else if (intCurrentLevel == 64)
				aryCircleColors = new int[] { 4, 3, 3, 1, 1, 3, 4, 2, 4, 2, 1, 4, 1, 3, 2, 2 };
			else if (intCurrentLevel == 65)
				aryCircleColors = new int[] { 3, 1, 4, 4, 3, 3, 4, 3, 2, 2, 4, 1, 1, 2, 1, 2 };
			else if (intCurrentLevel == 66)
				aryCircleColors = new int[] { 4, 3, 2, 1, 2, 1, 3, 1, 2, 4, 4, 3, 4, 1, 3, 2 };
			else if (intCurrentLevel == 67)
				aryCircleColors = new int[] { 2, 4, 4, 3, 1, 1, 2, 3, 2, 4, 3, 3, 1, 4, 1, 2 };
			else if (intCurrentLevel == 68)
				aryCircleColors = new int[] { 1, 4, 4, 3, 4, 3, 2, 4, 2, 1, 2, 2, 1, 1, 3, 3 };
			else if (intCurrentLevel == 69)
				aryCircleColors = new int[] { 3, 1, 3, 4, 3, 3, 4, 2, 2, 1, 2, 4, 4, 2, 1, 1 };
			else if (intCurrentLevel == 70)
				aryCircleColors = new int[] { 2, 1, 1, 3, 4, 2, 2, 3, 4, 1, 1, 2, 3, 4, 4, 3 };
			else if (intCurrentLevel == 71)
				aryCircleColors = new int[] { 1, 1, 3, 4, 3, 3, 1, 2, 2, 4, 4, 2, 4, 2, 1, 3 };
			else if (intCurrentLevel == 72)
				aryCircleColors = new int[] { 1, 1, 3, 2, 4, 3, 4, 1, 2, 4, 2, 2, 3, 1, 3, 4 };
			else if (intCurrentLevel == 73)
				aryCircleColors = new int[] { 1, 3, 3, 4, 4, 2, 4, 2, 3, 4, 1, 2, 2, 3, 1, 1 };
			else if (intCurrentLevel == 74)
				aryCircleColors = new int[] { 4, 4, 1, 2, 3, 4, 1, 1, 2, 3, 4, 3, 1, 2, 3, 2 };
			else if (intCurrentLevel == 75)
				aryCircleColors = new int[] { 1, 1, 4, 3, 3, 2, 1, 2, 2, 3, 4, 1, 4, 3, 2, 4 };
			else if (intCurrentLevel == 76)
				aryCircleColors = new int[] { 3, 3, 1, 2, 2, 1, 2, 4, 4, 3, 1, 4, 2, 4, 3, 1 };
			else if (intCurrentLevel == 77)
				aryCircleColors = new int[] { 2, 1, 4, 3, 2, 4, 3, 4, 1, 2, 4, 1, 1, 3, 3, 2 };
			else if (intCurrentLevel == 78)
				aryCircleColors = new int[] { 4, 4, 4, 4, 1, 2, 3, 3, 2, 3, 3, 1, 1, 1, 2, 2 };
			else if (intCurrentLevel == 79)
				aryCircleColors = new int[] { 4, 4, 1, 1, 4, 1, 3, 2, 3, 1, 2, 2, 3, 2, 3, 4 };
			else if (intCurrentLevel == 80)
				aryCircleColors = new int[] { 1, 2, 4, 4, 4, 1, 3, 2, 1, 4, 2, 3, 3, 1, 2, 3 };
			else if (intCurrentLevel == 81)
				aryCircleColors = new int[] { 4, 3, 1, 3, 4, 2, 3, 4, 2, 1, 2, 1, 4, 3, 2, 1 };
			else if (intCurrentLevel == 82)
				aryCircleColors = new int[] { 4, 3, 1, 4, 2, 3, 4, 3, 2, 1, 4, 1, 2, 2, 1, 3 };
			else if (intCurrentLevel == 83)
				aryCircleColors = new int[] { 4, 3, 1, 1, 4, 2, 4, 4, 2, 1, 3, 1, 3, 3, 2, 2 };
			else if (intCurrentLevel == 84)
				aryCircleColors = new int[] { 1, 1, 4, 4, 3, 2, 4, 3, 1, 2, 4, 2, 3, 2, 1, 3 };
			else if (intCurrentLevel == 85)
				aryCircleColors = new int[] { 4, 4, 3, 3, 2, 3, 4, 1, 2, 2, 2, 4, 1, 1, 3, 1 };
			else if (intCurrentLevel == 86)
				aryCircleColors = new int[] { 2, 3, 2, 1, 2, 4, 3, 3, 1, 4, 2, 4, 1, 1, 4, 3 };
			else if (intCurrentLevel == 87)
				aryCircleColors = new int[] { 4, 4, 1, 3, 3, 2, 3, 2, 2, 1, 3, 2, 4, 1, 1, 4 };
			else if (intCurrentLevel == 88)
				aryCircleColors = new int[] { 1, 4, 4, 4, 4, 2, 2, 3, 1, 3, 2, 1, 2, 3, 1, 3 };
			else if (intCurrentLevel == 89)
				aryCircleColors = new int[] { 3, 1, 3, 2, 3, 1, 4, 2, 4, 1, 4, 3, 4, 1, 2, 2 };
			else if (intCurrentLevel == 90)
				aryCircleColors = new int[] { 1, 4, 3, 4, 2, 3, 2, 4, 3, 4, 2, 2, 3, 1, 1, 1 };
			else if (intCurrentLevel == 91)
				aryCircleColors = new int[] { 3, 1, 3, 3, 3, 4, 2, 2, 4, 1, 4, 1, 4, 1, 2, 2 };
			else if (intCurrentLevel == 92)
				aryCircleColors = new int[] { 4, 1, 1, 3, 3, 4, 1, 4, 2, 2, 1, 3, 2, 3, 2, 4 };
			else if (intCurrentLevel == 93)
				aryCircleColors = new int[] { 4, 3, 4, 2, 2, 4, 2, 4, 2, 1, 3, 3, 1, 3, 1, 1 };
			else if (intCurrentLevel == 94)
				aryCircleColors = new int[] { 2, 1, 1, 4, 4, 1, 2, 3, 4, 4, 2, 3, 3, 1, 2, 3 };
			else if (intCurrentLevel == 95)
				aryCircleColors = new int[] { 3, 1, 2, 3, 1, 1, 1, 2, 3, 4, 4, 2, 4, 4, 2, 3 };
			else if (intCurrentLevel == 96)
				aryCircleColors = new int[] { 4, 4, 1, 3, 3, 1, 4, 2, 2, 4, 1, 2, 3, 1, 3, 2 };
			else if (intCurrentLevel == 97)
				aryCircleColors = new int[] { 1, 3, 3, 1, 4, 3, 2, 2, 1, 4, 4, 2, 3, 2, 1, 4 };
			else if (intCurrentLevel == 98)
				aryCircleColors = new int[] { 2, 1, 1, 4, 4, 4, 3, 4, 2, 3, 3, 2, 3, 1, 1, 2 };
			else if (intCurrentLevel == 99)
				aryCircleColors = new int[] { 4, 3, 1, 1, 2, 3, 4, 2, 2, 4, 1, 2, 3, 1, 3, 4 };
			else if (intCurrentLevel == 100)
				aryCircleColors = new int[] { 4, 4, 1, 2, 4, 1, 2, 2, 3, 3, 3, 3, 4, 2, 1, 1 };
			else
				aryCircleColors = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		else if (setLevelState.getGridSize() == 7)
			if (intCurrentLevel == 1)
				aryCircleColors = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		return aryCircleColors;
	}
}