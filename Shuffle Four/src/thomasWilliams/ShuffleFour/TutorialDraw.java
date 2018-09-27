package thomasWilliams.ShuffleFour;

import java.util.List;

import android.view.View;

import thomasWilliams.ShuffleFour.GameView.RunDialog;

public class TutorialDraw {
	private float fltSpeed;

	public TutorialDraw(float fltLineSpacing) {
		fltSpeed = fltLineSpacing / 10;
	}

	public void TutorialMessages(int intDialog, GameMenu gameMenu, GameView gameView) {
//		gameView.setVisibility(View.INVISIBLE);
		if (intDialog == 1)
			gameMenu.showDialog("Welcome to the Tutorial!", 0, gameView.getHeight() / 4);
		else if (intDialog == 2)
			gameMenu.showDialog("The Object of Shuffle Four is to line up each of the Circles to their corresponding colors on each side of the square board.", 0, gameView.getHeight() / 4);
		else if (intDialog == 3)
			gameMenu.showDialog("Notice the the colors on each side of the Game Board.", 0, gameView.getHeight());
		else if (intDialog == 4)
			gameMenu.showDialog("RED - Left<br />BLUE - Top<br />YELLOW - Right<br />GREEN - Bottom", 0, gameView.getHeight());
		else if (intDialog == 5) {
			// gameMenu.showDialog("Lets First move the YELLOW circles into the correct position", 0, this.getHeight());
			RunDialog.create(gameMenu, "Lets First move the YELLOW circles into the correct position", 0, gameView.getHeight());
		} else if (intDialog == 6) {
			android.os.SystemClock.sleep(2000);
			gameMenu.showDialog("Now lets move the GREEN circles into the correct position", 0, gameView.getHeight());
			
		} else if (intDialog == 7) {
			android.os.SystemClock.sleep(2000);
			gameMenu.showDialog("Now lets try to move the RED circles into the correct position", 0, gameView.getHeight());
		} else if (intDialog == 8) {
			android.os.SystemClock.sleep(2000);
			gameMenu.showDialog("You can see that We cannot move the Red Circle through a Red Square.<br /><br />In this game you cannot move a circle through a square of the same color", 0, gameView.getHeight());
		} else if (intDialog == 9)
			gameMenu.showDialog("Let solve this by moving the blue circles into position and then the red circles", 0, gameView.getHeight());
		else if (intDialog == 10) {
			android.os.SystemClock.sleep(2500);
			gameMenu.showDialog("Now lets finish the puzzle by moving the Red Circles.", 0, gameView.getHeight());
		} else if (intDialog == 11) {
			android.os.SystemClock.sleep(2500);
			gameMenu.showDialog("Some People find it easier to see the colors if the squares are filled in.<br /><br />To toggle between squares filled you can press the Menu button", 0, gameView.getHeight());
		} else if (intDialog == 12) {
			android.os.SystemClock.sleep(200);
			gameMenu.ToggleGridColorThicker();
			gameMenu.showDialog("Press the Menu button again to toggle back", 0, gameView.getHeight());
		} else if (intDialog == 13) {
			android.os.SystemClock.sleep(200);
			gameMenu.ToggleGridColorThicker();
			gameMenu.showDialog("Now it is your Turn to give it a try!<br /><br />Press Next to go to Level 1", 0, gameView.getHeight());
		} else if (intDialog == 14) {
//			gameMenu.LoadLevel(0);
		}
	}

	public void onDraw(GridID gridID, int[] aryGridColors, int intDialog, List<GridDimensions> lstGridDimensions) {

		// Set the Raw Grid Color Pattern into GridID
		gridID.setGridPositionColor(aryGridColors);

		float fltX;
		float fltY;

		if (intDialog == 6) {

			fltX = lstGridDimensions.get(6).getX();
			lstGridDimensions.get(6).setX(fltX + fltSpeed);
			if (fltX + fltSpeed > gridID.getGridX(14)) {
				lstGridDimensions.get(6).SnapToGrid();

				fltY = lstGridDimensions.get(11).getY();
				lstGridDimensions.get(11).setY(fltY - fltSpeed);

				if (fltY - fltSpeed < gridID.getGridY(19)) {
					lstGridDimensions.get(11).SnapToGrid();

					fltY = lstGridDimensions.get(1).getY();
					lstGridDimensions.get(1).setY(fltY + fltSpeed);

					if (fltY + fltSpeed > gridID.getGridY(9)) {
						lstGridDimensions.get(1).SnapToGrid();

					}
				}
			}
		} else if (intDialog == 7) {
			fltY = lstGridDimensions.get(7).getY();
			lstGridDimensions.get(7).setY(fltY + fltSpeed);
			if (fltY + fltSpeed > gridID.getGridY(21)) {
				lstGridDimensions.get(7).SnapToGrid();

				fltY = lstGridDimensions.get(8).getY();
				lstGridDimensions.get(8).setY(fltY + fltSpeed);

				if (fltY + fltSpeed > gridID.getGridY(22)) {
					lstGridDimensions.get(8).SnapToGrid();

					fltY = lstGridDimensions.get(9).getY();
					lstGridDimensions.get(9).setY(fltY + fltSpeed);

					if (fltY + fltSpeed > gridID.getGridY(23)) {
						lstGridDimensions.get(9).SnapToGrid();

					}
				}
			}
		} else if (intDialog == 8) {
			fltY = lstGridDimensions.get(3).getY();
			lstGridDimensions.get(3).setY(fltY + fltSpeed);
			if (fltY + fltSpeed > gridID.getGridY(17)) {
				lstGridDimensions.get(3).SnapToGrid();

				fltX = lstGridDimensions.get(3).getX();
				lstGridDimensions.get(3).SnapToGrid();
				lstGridDimensions.get(3).setX(fltX - (fltSpeed * 2));
			}
		} else if (intDialog == 10) {
			lstGridDimensions.get(3).SnapToGrid();

			fltY = lstGridDimensions.get(2).getY();
			lstGridDimensions.get(2).setY(fltY - fltSpeed);
			if (fltY - fltSpeed < gridID.getGridY(1)) {
				lstGridDimensions.get(2).SnapToGrid();

				fltY = lstGridDimensions.get(4).getY();
				lstGridDimensions.get(4).setY(fltY - fltSpeed);

				if (fltY - fltSpeed < gridID.getGridY(3)) {
					lstGridDimensions.get(4).SnapToGrid();

					fltX = lstGridDimensions.get(5).getX();
					lstGridDimensions.get(5).setX(fltX + fltSpeed);

					if (fltX + fltSpeed > gridID.getGridX(12)) {
						lstGridDimensions.get(5).setX(gridID.getGridX(12));

						fltY = lstGridDimensions.get(5).getY();
						lstGridDimensions.get(5).setY(fltY - fltSpeed);

						if (fltY - fltSpeed < gridID.getGridY(2)) {
							lstGridDimensions.get(5).SnapToGrid();
						}
					}
				}
			}
		} else if (intDialog == 11) {
			fltY = lstGridDimensions.get(3).getY();
			lstGridDimensions.get(3).setY(fltY - fltSpeed);
			if (fltY - fltSpeed < gridID.getGridY(12)) {
				lstGridDimensions.get(3).setY(gridID.getGridY(12));

				fltX = lstGridDimensions.get(3).getX();
				lstGridDimensions.get(3).setX(fltX - fltSpeed);

				if (fltX - fltSpeed < gridID.getGridX(10)) {
					lstGridDimensions.get(3).SnapToGrid();

					fltY = lstGridDimensions.get(0).getY();
					lstGridDimensions.get(0).setY(fltY + fltSpeed);

					if (fltY + fltSpeed > gridID.getGridY(5)) {
						lstGridDimensions.get(0).SnapToGrid();

						fltY = lstGridDimensions.get(10).getY();
						lstGridDimensions.get(10).setY(fltY - fltSpeed);

						if (fltY - fltSpeed < gridID.getGridY(15))
							lstGridDimensions.get(10).SnapToGrid();
					}
				}
			}
		}
	}
}
