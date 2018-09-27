package thomasWilliams.ShuffleFour;

import java.util.ArrayList;
import java.util.List;

import android.R.color;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

import com.pad.android.iappad.AdController;

public class GameView extends SurfaceView {

	// Create the GameView System Variable
	private SurfaceHolder holder;
	private GameMenu gameMenu;
	private boolean booSoundOn;
	private SetLevelState setLevelState;
	private GameLoopThread gameLoopThread;
	private Context applicationContext;

	// Create the GameView Variables
	private Bitmap bmpGameViewRaw;
	private Bitmap bmpGameViewScaled;
	private Bitmap bmpGameDraw;
	private Paint pntGameDrawBitmap = new Paint();
	private long lngLastClick;
	private Paint pntLetterBox = new Paint();
	private Bitmap bmpBackgroundImage;
	private float fltLineSpacing;

	// Create the List and ArrayList Variables
	private List<CircleDraw> lstCircles = new ArrayList<CircleDraw>();
	private List<GridDimensions> lstGridDimensions = new ArrayList<GridDimensions>();
	private List<ScreenDraw> lstScreenDraw = new ArrayList<ScreenDraw>();

	private float fltLeftScreenBound;
	private float fltRightScreenBound;
	private float fltUpperScreenBound;
	private float fltLowerScreenBound;
	private float fltLeftBound;
	private float fltRightBound;
	private float fltUpperBound;
	private float fltLowerBound;
	private Bitmap bmpCircle;
	private float fltImgRadius;
	private int intCircleID;
	private GridID gridID;
	private int[] aryGridColors;
	private boolean booLevelWon = false;
	private ScreenDraw screenDraw;
	private int intMoves = 0;
	private String strBest;
	private PaintClass paintText;
	private int intDialog = 0;
	private TutorialDraw tutorialDraw;

	// Create the Static Variables
	public static int intLetterBoxWidth;
	public static int intLetterBoxHeight;
	public static int intGameDrawWidth;
	public static int intGameDrawHeight;
	public static double dblScaleRatio;

	public GameView(GameMenu gameMenu, SetLevelState setLevelState, final AdController myControllerGameView) {
		super(gameMenu.getApplicationContext());
		this.setLevelState = setLevelState;
		this.applicationContext = gameMenu.getApplicationContext();
		this.booSoundOn = setLevelState.getSoundOn();
		this.gameMenu = gameMenu;
		gameLoopThread = new GameLoopThread(this);

		holder = getHolder();
		holder.addCallback(new Callback() {

			public void surfaceDestroyed(SurfaceHolder holder) {
			}

			public void surfaceCreated(SurfaceHolder holder) {
				// Load the LeadBolt Ad
				if (AppConfig.booLoadBannerAds && myControllerGameView != null)
					myControllerGameView.loadAd();

				CreateLetterBox();
				if (booSoundOn && AppConfig.booBackgroundMusic)
					CreateBackgroundMusic();

				if (!gameLoopThread.isAlive()) {
					gameLoopThread.setRunning(true);
					// Starts the GameLoopThread run() method
					gameLoopThread.start();
				}

				CreateGameBoard();
				// CreateCircles();
				resetScreen();
			}

			public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
			}
		});
	}

	private void resetScreen() {
		// gameMenu.resetGameView();

		// Create the Paint Class for any Text
		paintText = new PaintClass();

		// Find intBest
		strBest = gameMenu.getBestMoves();

		// reset the Circle Positions
		lstGridDimensions.clear();
		lstCircles.clear();
		lstScreenDraw.clear();
		CreateCircles();
		intMoves = 0;
		booLevelWon = false;
		// Play Sound on when first Drawn
		if (getSoundOn())
			getGameMenu().SoundPoolSound(3);

		// This is the Tutorial
		if (setLevelState.getCurrentLevel() == 0) {
			lstScreenDraw.clear();
			tutorialDraw = new TutorialDraw(fltLineSpacing);
			TutorialPlay();
		}
		// gameMenu.showLevelEndDialog(intMoves);
	}

	public static class RunDialog {

		public static void create(GameMenu gameMenu, String strMessage, int intX, int intY) {
			gameMenu.showDialog(strMessage, intX, intY);
			// android.os.SystemClock.sleep(2000);
		}
	}

	public void TutorialPlay() {
		intDialog++;
		tutorialDraw.TutorialMessages(intDialog, gameMenu, this);
		if (intDialog == 14)
			NavigateForward();
	}

	public void NavigateForward() {
		setLevelState.setGameLevel(setLevelState.getCurrentLevel() + 1);
		resetScreen();
	}

	private void NavigateBack() {
		setLevelState.setGameLevel(setLevelState.getCurrentLevel() - 1);
		resetScreen();
	}

	private void CreateGameBoard() {
		double dblGameBoardCenter = (this.getHeight() * AppConfig.dblGameBoardOffsetFromTop) + intLetterBoxHeight;

		fltLeftScreenBound = intLetterBoxWidth + AppConfig.fltGameBoardPadding;
		fltRightScreenBound = this.getWidth() - fltLeftScreenBound;
		fltUpperScreenBound = (float) (dblGameBoardCenter - (fltRightScreenBound - fltLeftScreenBound) / 2);
		fltLowerScreenBound = (float) (dblGameBoardCenter + (fltRightScreenBound - fltLeftScreenBound) / 2);
		fltLeftBound = (float) ((AppConfig.dblGameBoardBorderWidth * this.getWidth()) + fltLeftScreenBound);
		fltRightBound = this.getWidth() - fltLeftBound;
		fltUpperBound = (float) (dblGameBoardCenter - (fltRightBound - fltLeftBound) / 2);
		fltLowerBound = (float) (dblGameBoardCenter + (fltRightBound - fltLeftBound) / 2);

		fltLineSpacing = (fltRightBound - fltLeftBound) / setLevelState.getGridSize();
		// Center Line Width
		// canvas.drawLine(fltLeftBound, (float) dblGameBoardCenter, fltRightBound, (float) dblGameBoardCenter, pntGameDrawBitmap);
		// Center Line Height
		// canvas.drawLine(this.getWidth() / 2, fltUpperBound, this.getWidth() / 2, fltLowerBound, pntGameDrawBitmap);

		// Set the GridID;
		gridID = new GridID(setLevelState, fltLineSpacing, fltLeftBound, fltUpperBound);
	}

	private void CreateCircles() {
		Config cfgBackdropBitmap = Bitmap.Config.ARGB_8888; // RGB_565
		float fltBitmapRadius = fltLineSpacing;
		Bitmap bmpBackdropCircle = Bitmap.createBitmap((int) fltBitmapRadius, (int) fltBitmapRadius, cfgBackdropBitmap);

		// Draw a boarder around the Circles
		float fltBoarderRadius = (float) (fltBitmapRadius * (1 - AppConfig.dblCirclePadding) + (AppConfig.intBlackBoarderAroundCirles * dblScaleRatio));
		Canvas cvsBlackCircleBoarder = new Canvas(bmpBackdropCircle);

		// Get Circle Color Win Paint
		PaintClass paintColor = new PaintClass();
		cvsBlackCircleBoarder.drawCircle((fltBitmapRadius / 2), (fltBitmapRadius / 2), (fltBoarderRadius / 2), paintColor.getPaint(AppConfig.intGridColorYellow)); // 0xFF000000

		fltImgRadius = (float) (fltBitmapRadius * (1 - AppConfig.dblCirclePadding));

		// This is for the Bitmap Circle which I am not using
		// Bitmap bmpCircleRaw = BitmapFactory.decodeResource(getResources(), R.drawable.circle_blue);
		// Matrix scalePad = new Matrix();
		// float fltScaleFactor = (float) ((fltBitmapRadius * (1 - AppConfig.dblCirclePadding)) / bmpCircleRaw.getWidth());
		// scalePad.postScale(fltScaleFactor, fltScaleFactor);
		// bmpCircle = Bitmap.createBitmap(bmpCircleRaw, 0, 0, bmpCircleRaw.getWidth(), bmpCircleRaw.getHeight(), scalePad, false);
		// bmpCircleRaw.recycle();

		for (int i = 0; i < setLevelState.getTotalCircles(); i++) {
			lstGridDimensions.add(new GridDimensions(this, setLevelState, i, gridID));
			lstCircles.add(new CircleDraw(this, bmpBackdropCircle, fltBitmapRadius, bmpCircle, lstGridDimensions.get(i)));
		}

		// Create the ScreenDraw Class
		Bitmap bmpResetRaw = BitmapFactory.decodeResource(getResources(), R.drawable.refresh_screen_02);
		Bitmap bmpForwardArrowRaw = BitmapFactory.decodeResource(getResources(), R.drawable.forward_arrow);
		Bitmap bmpBackArrorRaw = BitmapFactory.decodeResource(getResources(), R.drawable.back_arrow);

		Matrix scalePad = new Matrix();
		// float fltScaleFactor = (float) ((fltBitmapRadius * (1 - AppConfig.dblCirclePadding)) / bmpResetRaw.getWidth());
		float fltScaleFactor = (this.getWidth() / AppConfig.fltScreenDrawSize) / bmpResetRaw.getWidth();
		scalePad.postScale(fltScaleFactor, fltScaleFactor);

		// Scale the Bitmap with the Matrix
		Bitmap bmpReset = Bitmap.createBitmap(bmpResetRaw, 0, 0, bmpResetRaw.getWidth(), bmpResetRaw.getHeight(), scalePad, false);
		Bitmap bmpForwardArrow = Bitmap.createBitmap(bmpForwardArrowRaw, 0, 0, bmpForwardArrowRaw.getWidth(), bmpForwardArrowRaw.getHeight(), scalePad, false);
		Bitmap bmpBackArror = Bitmap.createBitmap(bmpBackArrorRaw, 0, 0, bmpBackArrorRaw.getWidth(), bmpBackArrorRaw.getHeight(), scalePad, false);

		// Free from memory the Bitmaps
		bmpResetRaw.recycle();
		bmpForwardArrowRaw.recycle();
		bmpBackArrorRaw.recycle();

		// Draw the Bitmaps
		lstScreenDraw.add(screenDraw = new ScreenDraw(this, bmpReset, (this.getWidth() / 2)));
		if (setLevelState.getCurrentLevel() < AppConfig.intLevelsPerPage)
			lstScreenDraw.add(screenDraw = new ScreenDraw(this, bmpForwardArrow, (int) (this.getWidth() * 0.8)));
		else
			lstScreenDraw.add(null);
		if (setLevelState.getCurrentLevel() > 1)
			lstScreenDraw.add(screenDraw = new ScreenDraw(this, bmpBackArror, (int) (this.getWidth() * 0.2)));
		else
			lstScreenDraw.add(null);
	}

	private void CreateBackgroundMusic() {
		PlayMediaPlayer backgroundMusic = new PlayMediaPlayer(applicationContext);
		backgroundMusic.playMusicLoop(R.raw.background_gameplay01);
	}

	private void CreateLetterBox() {
		// Samsung Galaxy S I9000 480x800 5:3
		// Motorola Droid Bionic 540x960 16:9
		// Ideal Screen Ratio = 480/800 = 0.6
		// Calc User Screen Ratio
		// if larger then 0.6 Black Bars Top and Bottom
		// if less then then 0.6 Black Bars Left and Right

		double dblWidth = this.getWidth();
		double dblHeight = this.getHeight();

		double dblUserScreenRatio = dblWidth / dblHeight;

		if (dblUserScreenRatio < AppConfig.dblScreenRatio) {
			intLetterBoxWidth = 0;
			intLetterBoxHeight = (int) ((dblHeight - (dblWidth / AppConfig.dblScreenRatio)) / 2);
		} else if (dblUserScreenRatio > AppConfig.dblScreenRatio) {
			intLetterBoxWidth = (int) ((dblWidth - (dblHeight * AppConfig.dblScreenRatio)) / 2);
			intLetterBoxHeight = 0;
		}

		// Create a 480x800 bitmap and then scale it
		Bitmap bmpBackgroundRaw = Bitmap.createBitmap(AppConfig.intAspectWidth, AppConfig.intAspectHeight, Config.RGB_565); // Config.ARGB_8888 us for transparency
		// Bitmap bmpBackgroundRaw = BitmapFactory.decodeResource(getResources(), R.drawable.background_480x800);
		int imgWidth = bmpBackgroundRaw.getWidth();
		int imgHeight = bmpBackgroundRaw.getHeight();
		int intScaleSizePad = 0;

		// Scale Bitmap to Raw Size
		intScaleSizePad = AppConfig.intAspectHeight;
		float scaleFactorPad = Math.min(((float) intScaleSizePad) / imgWidth, ((float) intScaleSizePad) / imgHeight);
		Matrix scalePad = new Matrix();
		scalePad.postScale(scaleFactorPad, scaleFactorPad);
		bmpGameViewRaw = Bitmap.createBitmap(bmpBackgroundRaw, 0, 0, imgWidth, imgHeight, scalePad, false);

		// Scale to phone size but keep aspect ratio
		if (AppConfig.intAspectWidth > AppConfig.intAspectHeight) {
			intScaleSizePad = this.getWidth() - (intLetterBoxWidth * 2);
		} else {
			intScaleSizePad = this.getHeight() - (intLetterBoxHeight * 2);
		}

		// intScaleSizePad = 540; // width in 480x400
		scaleFactorPad = Math.min(((float) intScaleSizePad) / imgWidth, ((float) intScaleSizePad) / imgHeight);

		scalePad = new Matrix();
		scalePad.postScale(scaleFactorPad, scaleFactorPad);
		bmpGameViewScaled = Bitmap.createBitmap(bmpBackgroundRaw, 0, 0, imgWidth, imgHeight, scalePad, false);
		bmpBackgroundRaw.recycle();
		// /////////////////////////////////////////////////////////////////////////
		// What bmpGameDraw equals is very important as it determines the scaling //
		// /////////////////////////////////////////////////////////////////////////
		if (AppConfig.booGameDrawRaw)
			bmpGameDraw = bmpGameViewRaw;
		else
			bmpGameDraw = bmpGameViewScaled;
		dblScaleRatio = (double) bmpGameDraw.getHeight() / AppConfig.intAspectHeight;
		intGameDrawWidth = bmpGameDraw.getWidth();
		intGameDrawHeight = bmpGameDraw.getHeight();
	}

	private void CreateGameBitmap(Canvas canvas) {
		// Create the GameDraw Background to hold the View
		pntGameDrawBitmap.setColor(0x440000FF);
		canvas.drawRect(0 + intLetterBoxWidth, intLetterBoxHeight, bmpGameDraw.getWidth() + intLetterBoxWidth, bmpGameDraw.getHeight() + intLetterBoxHeight, pntGameDrawBitmap);

		// Create the middle Line
		pntGameDrawBitmap.setColor(0x44000000);
		canvas.drawRect(0 + intLetterBoxWidth, ((bmpGameDraw.getHeight()) / 2) + intLetterBoxHeight - 3, bmpGameDraw.getWidth() + intLetterBoxWidth, ((bmpGameDraw.getHeight() / 2) + intLetterBoxHeight) + 3, pntGameDrawBitmap);

		// Create the corners
		pntGameDrawBitmap.setStrokeWidth(5);
		canvas.drawLine(0 + intLetterBoxWidth, (float) ((bmpGameDraw.getHeight() * (1 - AppConfig.dblBoundY)) + intLetterBoxHeight), (float) ((bmpGameDraw.getWidth() * AppConfig.dblBoundX) + intLetterBoxWidth), bmpGameDraw.getHeight() + intLetterBoxHeight, pntGameDrawBitmap);
		canvas.drawLine(0 + intLetterBoxWidth, (float) ((bmpGameDraw.getHeight() * AppConfig.dblBoundY) + intLetterBoxHeight), (float) ((bmpGameDraw.getWidth() * AppConfig.dblBoundX) + intLetterBoxWidth), 0 + intLetterBoxHeight, pntGameDrawBitmap);
		canvas.drawLine((float) ((bmpGameDraw.getWidth() * (1 - AppConfig.dblBoundX)) + intLetterBoxWidth), 0 + intLetterBoxHeight, (float) (bmpGameDraw.getWidth() + intLetterBoxWidth), (float) ((bmpGameDraw.getHeight() * AppConfig.dblBoundY) + intLetterBoxHeight), pntGameDrawBitmap);
		canvas.drawLine((float) (bmpGameDraw.getWidth() + intLetterBoxWidth), (float) ((bmpGameDraw.getHeight() * (1 - AppConfig.dblBoundY)) + intLetterBoxHeight), (float) ((bmpGameDraw.getWidth() * (1 - AppConfig.dblBoundX)) + intLetterBoxWidth), bmpGameDraw.getHeight() + intLetterBoxHeight, pntGameDrawBitmap);
	}

	private void DrawGameBoard(Canvas canvas) {
		// Create the GridColorSet
		SetLevelParamaters gridColors = new SetLevelParamaters(setLevelState);
		int[] aryGridColorSet = gridColors.getGridColorSet();

		// Draw a Black Screen
		pntGameDrawBitmap.setColor(AppConfig.intBackgroundBaseColor); // Black //FF111111
		canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), pntGameDrawBitmap);

		// Draw the color rectangle across the Grid Only
//		int intColorTheme = 0xFFFFFFFF;
		pntGameDrawBitmap.setColor(AppConfig.intBackgroundColorLight); // Black //FF111111

		// Draw a Theme Color Rectangle across the GameBoard
		if (AppConfig.booBackgroundFullScreen)
			canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), pntGameDrawBitmap);
		else
			// canvas.drawRect(0 + intLetterBoxWidth, intLetterBoxHeight, bmpGameDraw.getWidth() + intLetterBoxWidth, bmpGameDraw.getHeight() + intLetterBoxHeight, pntGameDrawBitmap);
			canvas.drawRect(fltLeftBound, fltUpperBound, fltRightBound, fltLowerBound, pntGameDrawBitmap);

		// Draw the Color Rectangles on the Boarder
		if (AppConfig.booDrawColorRectanglesOnBoarder) {
			PaintClass paintBoarder = new PaintClass();
			// Draw a black boarder around the side colors
			int intBorderColor = 0xDD444455;
			canvas.drawRect(fltLeftScreenBound, fltUpperScreenBound, fltLeftBound, fltLowerScreenBound, paintBoarder.getPaint(intBorderColor));
			canvas.drawRect(fltLeftScreenBound, fltUpperScreenBound, fltRightScreenBound, fltUpperBound, paintBoarder.getPaint(intBorderColor));
			canvas.drawRect(fltRightBound, fltUpperScreenBound, fltRightScreenBound, fltLowerScreenBound, paintBoarder.getPaint(intBorderColor));
			canvas.drawRect(fltLeftScreenBound, fltLowerBound, fltRightScreenBound, fltLowerScreenBound, paintBoarder.getPaint(intBorderColor));

			// Draw the side colors
			canvas.drawRect(fltLeftScreenBound, fltUpperBound + fltLineSpacing, fltLeftScreenBound + (fltLeftBound - fltLeftScreenBound), fltLowerBound - fltLineSpacing, paintBoarder.getPaint(aryGridColorSet[1]));
			canvas.drawRect(fltRightBound, fltUpperBound + fltLineSpacing, fltRightScreenBound, fltLowerBound - fltLineSpacing, paintBoarder.getPaint(aryGridColorSet[3]));
			canvas.drawRect(fltLeftBound + fltLineSpacing, fltUpperScreenBound, fltRightBound - fltLineSpacing, fltUpperBound, paintBoarder.getPaint(aryGridColorSet[2]));
			canvas.drawRect(fltLeftBound + fltLineSpacing, fltLowerScreenBound, fltRightBound - fltLineSpacing, fltLowerBound, paintBoarder.getPaint(aryGridColorSet[4]));
		}

		// Create the Color Squares in the Grid
		aryGridColors = gridColors.getGridColors();

		int[] aryGridColorsConvert = new int[aryGridColors.length];
		// Convert the Raw Grid Pattern into Drawable Colors
		for (int i = 0; i < aryGridColorsConvert.length; i++) {
			aryGridColorsConvert[i] = aryGridColorSet[aryGridColors[i]];
		}

		// Draw the Grid Color Pattern
		PaintClass paintColor = new PaintClass();
		for (int i = 0; i < aryGridColorsConvert.length; i++) {
			canvas.drawRect(gridID.getGridX(i), gridID.getGridY(i), gridID.getGridX(i) + fltLineSpacing, gridID.getGridY(i) + fltLineSpacing, paintColor.getPaint(aryGridColorsConvert[i]));
		}

		// Fill the Winning GridID with the same color
		int[] aryGridColorWin = new int[] { 0, AppConfig.intGridColorWinRed, AppConfig.intGridColorWinBlue, AppConfig.intGridColorWinYellow, AppConfig.intGridColorWinGreen };
		float fltMarginReduction = (float) (fltLineSpacing - (AppConfig.dblGameBoardBorderWidth * this.getWidth()));
		int[][] aryGridWin = gridID.getGridToWin();
		// Make the middle of the Color Grid Black
		float fltMargin = fltLineSpacing * gameMenu.getGridColorThickness();
		for (int i = 0; i < setLevelState.getGridSize() * setLevelState.getGridSize(); i++) {
			// Draw the Black
			canvas.drawRect(gridID.getGridX(i) + fltMargin, gridID.getGridY(i) + fltMargin, gridID.getGridX(i) + fltLineSpacing - fltMargin, gridID.getGridY(i) + fltLineSpacing - fltMargin, paintColor.getPaint(AppConfig.intInnerSquareColor));
			// Draw the Dark Background Win Colors
			if (AppConfig.booDrawInnerBorder) {
				int j = 1;
				for (int intGridWin : aryGridWin[j - 1])
					if (i == intGridWin)
						canvas.drawRect(gridID.getGridX(i) + fltMargin, gridID.getGridY(i) + fltMargin, gridID.getGridX(i) + fltLineSpacing - fltMarginReduction, gridID.getGridY(i) + fltLineSpacing - fltMargin, paintColor.getPaint(aryGridColorWin[j]));
				j++;
				for (int intGridWin : aryGridWin[j - 1])
					if (i == intGridWin)
						canvas.drawRect(gridID.getGridX(i) + fltMargin, gridID.getGridY(i) + fltMargin, gridID.getGridX(i) + fltLineSpacing - fltMargin, gridID.getGridY(i) + fltLineSpacing - fltMarginReduction, paintColor.getPaint(aryGridColorWin[j]));
				j++;
				for (int intGridWin : aryGridWin[j - 1])
					if (i == intGridWin)
						canvas.drawRect(gridID.getGridX(i) + fltMarginReduction, gridID.getGridY(i) + fltMargin, gridID.getGridX(i) + fltLineSpacing - fltMargin, gridID.getGridY(i) + fltLineSpacing - fltMargin, paintColor.getPaint(aryGridColorWin[j]));
				j++;
				for (int intGridWin : aryGridWin[j - 1])
					if (i == intGridWin)
						canvas.drawRect(gridID.getGridX(i) + fltMargin, gridID.getGridY(i) + fltMarginReduction, gridID.getGridX(i) + fltLineSpacing - fltMargin, gridID.getGridY(i) + fltLineSpacing - fltMargin, paintColor.getPaint(aryGridColorWin[j]));
			}
		}
		// int j = 1;
		// for (int[] intGridID : gridID.getGridToWin()) {
		// for (int i : intGridID)
		// canvas.drawRect(gridID.getGridX(i) + (fltLineSpacing - fltMargin), gridID.getGridY(i) + fltMargin, gridID.getGridX(i) + (fltLineSpacing - fltMarginReduction), gridID.getGridY(i) + fltLineSpacing - fltMargin, paintColor.getPaint(aryGridColorWin[j]));
		// j++;
		// }

		// for (int i : aryGridWin[0])
		// canvas.drawRect(gridID.getGridX(i), gridID.getGridY(i), gridID.getGridX(i) + fltLineSpacing - fltMarginReduction, gridID.getGridY(i) + fltLineSpacing, paintColor.getPaint(aryGridColorWin[j]));
		// j++;
		// for (int i : aryGridWin[1])
		// canvas.drawRect(gridID.getGridX(i), gridID.getGridY(i), gridID.getGridX(i) + fltLineSpacing, gridID.getGridY(i) + fltLineSpacing - fltMarginReduction, paintColor.getPaint(aryGridColorWin[j]));
		// j++;
		// for (int i : aryGridWin[2])
		// canvas.drawRect(gridID.getGridX(i) + fltMarginReduction, gridID.getGridY(i), gridID.getGridX(i) + fltLineSpacing, gridID.getGridY(i) + fltLineSpacing, paintColor.getPaint(aryGridColorWin[j]));
		// j++;
		// for (int i : aryGridWin[3])
		// canvas.drawRect(gridID.getGridX(i), gridID.getGridY(i) + fltMarginReduction, gridID.getGridX(i) + fltLineSpacing, gridID.getGridY(i) + fltLineSpacing, paintColor.getPaint(aryGridColorWin[j]));

		// Draw the Grid Lines
		// pntGameDrawBitmap.setStrokeWidth(3);
		// pntGameDrawBitmap.setColor(0xFF666666); // 0x44FFFFFF
		pntGameDrawBitmap.setStrokeWidth((float) (AppConfig.fltStrokeWidth * dblScaleRatio));
		pntGameDrawBitmap.setColor(0xFF666666); // 0x44FFFFFF //0x88FFFFFF
		if (AppConfig.booDrawGridLine)
			for (int i = 0; i <= setLevelState.getGridSize(); i++) {
				canvas.drawLine(fltLeftBound - 1, fltUpperBound + (fltLineSpacing * i), fltRightBound + 1, fltUpperBound + (fltLineSpacing * i), pntGameDrawBitmap); // Horizontal
				canvas.drawLine(fltLeftBound + (fltLineSpacing * i), fltUpperBound - 1, fltLeftBound + (fltLineSpacing * i), fltLowerBound + 1, pntGameDrawBitmap); // Vertical
			}

		// Draw the Boarder Lines around the Screen
		canvas.drawLine(fltLeftScreenBound, fltUpperScreenBound - 1, fltLeftScreenBound, fltLowerScreenBound + 1, pntGameDrawBitmap);
		canvas.drawLine(fltRightScreenBound, fltUpperScreenBound - 1, fltRightScreenBound, fltLowerScreenBound + 1, pntGameDrawBitmap);
		canvas.drawLine(fltLeftScreenBound - 1, fltUpperScreenBound, fltRightScreenBound + 1, fltUpperScreenBound, pntGameDrawBitmap);
		canvas.drawLine(fltLeftScreenBound - 1, fltLowerScreenBound, fltRightScreenBound + 1, fltLowerScreenBound, pntGameDrawBitmap);
	}

	@Override
	public boolean onTouchEvent(MotionEvent TouchEvent) {
		final int intTouchEventAction = TouchEvent.getAction();
		float fltTouchX = TouchEvent.getX();
		float fltTouchY = TouchEvent.getY();

		if (true) {
			synchronized (getHolder()) {
				switch (intTouchEventAction & MotionEvent.ACTION_MASK) {
				case MotionEvent.ACTION_DOWN: {

					// Press Reset Button
					for (int i = 0; i < lstScreenDraw.size(); i++) {
						ScreenDraw NavigateButtons = lstScreenDraw.get(i);

						if (NavigateButtons != null && i == 0)
							if (fltTouchX >= NavigateButtons.getX() && fltTouchX <= NavigateButtons.getX() + NavigateButtons.getWidth())
								if (fltTouchY >= NavigateButtons.getY() && fltTouchY <= NavigateButtons.getY() + NavigateButtons.getWidth())
									resetScreen();
						if (NavigateButtons != null && i == 1)
							if (fltTouchX >= NavigateButtons.getX() && fltTouchX <= NavigateButtons.getX() + NavigateButtons.getWidth())
								if (fltTouchY >= NavigateButtons.getY() && fltTouchY <= NavigateButtons.getY() + NavigateButtons.getWidth())
									NavigateForward();
						if (NavigateButtons != null && i == 2)
							if (fltTouchX >= NavigateButtons.getX() && fltTouchX <= NavigateButtons.getX() + NavigateButtons.getWidth())
								if (fltTouchY >= NavigateButtons.getY() && fltTouchY <= NavigateButtons.getY() + NavigateButtons.getWidth())
									NavigateBack();
					}

					intCircleID = -1;

					// Find which grid coordinate is being touched
					int intGridID = gridID.getGridID(fltTouchX, fltTouchY);

					if (intGridID >= 0) {
						// for (GridDimensions CircleDimensions : lstGridDimensions) {
						for (int i = lstGridDimensions.size() - 1; i >= 0; i--) {
							GridDimensions CircleDimensions = lstGridDimensions.get(i);
							// get the center for the ball
							float fltCenterX = CircleDimensions.getX() + (fltLineSpacing / 2);
							float fltCenterY = CircleDimensions.getY() + (fltLineSpacing / 2);

							// Calculate if the Any Circles are within the intGridID
							if (fltCenterX >= gridID.getGridX(intGridID) && fltCenterX <= gridID.getGridX(intGridID) + fltLineSpacing && fltCenterY >= gridID.getGridY(intGridID) && fltCenterY <= gridID.getGridY(intGridID) + fltLineSpacing) {
								intCircleID = CircleDimensions.getID();

								// Set the Raw Grid Color Pattern into GridID
								gridID.setGridPositionColor(aryGridColors);

								// Set the Active Circle to a Grid Position of -1
								gridID.setCirclePosition(intCircleID, -1);

								// Play Sound on when Circle Picked Up
								if (getSoundOn())
									getGameMenu().SoundPoolSound(1);

								break;
							}
						}
						break;
					}
				}

				case MotionEvent.ACTION_MOVE: {
					// Move the Circle with the Touch Event
					if (intCircleID >= 0) {
						lstGridDimensions.get(intCircleID).setX(fltTouchX - (fltLineSpacing / 2));
						lstGridDimensions.get(intCircleID).setY(fltTouchY - (fltLineSpacing / 2));
					}
					break;
				}

				case MotionEvent.ACTION_UP: {
					// Snap Circle to Grid
					if (intCircleID >= 0) {
						// Increment Move Counter
						if (!booLevelWon)
							intMoves++;

						// Check if user has won the Level
						lstGridDimensions.get(intCircleID).SnapToGrid();
						if (lstGridDimensions.get(intCircleID).getLevelWon())
							booLevelWon = true;

						// Play Sound on when Circle Dropped
						if (getSoundOn())
							getGameMenu().SoundPoolSound(2);

						// Show Dialogue to Complete the Level
						if (booLevelWon && gridID.getIntWin() == setLevelState.getTotalCircles())
							gameMenu.showLevelEndDialog(intMoves).show();
					}
					break;
				}

				case MotionEvent.ACTION_CANCEL: {
					break;
				}

				case MotionEvent.ACTION_POINTER_UP: {
					break;
				}
				case MotionEvent.ACTION_POINTER_DOWN: {
					break;
				}
				}
				// redraw the canvas
				// invalidate();
			}
		}
		return true;
	}

	public GameMenu getGameMenu() {
		return gameMenu;
	}

	public boolean getSoundOn() {
		return booSoundOn;
	}

	public float getFltLineSpacing() {
		return fltLineSpacing;
	}

	public float[] getBounds() {
		float[] ary = { fltLeftBound, fltUpperBound, fltRightBound, fltLowerBound };
		return ary;
	}

	public float[] getOutterBounds() {
		float[] ary = { fltLeftScreenBound, fltUpperScreenBound, fltRightScreenBound, fltLowerScreenBound };
		return ary;
	}

	@SuppressLint("WrongCall")
	@Override
	protected void onDraw(Canvas canvas) {
		// canvas.drawColor(0x44FFFFFF); // OR //canvas.drawColor(Color.BLACK);
		canvas.drawColor(0xFFFFFFFF); // white
		// Create Lower Bitmap to render a scalable view
		CreateGameBitmap(canvas);
		// Draw Black Bars to LetterBox Scaling
		pntLetterBox.setColor(0x44000000); // OR //Color.rgb(0,0,0);
		pntLetterBox.setStrokeWidth(0);
		// Top and Bottom Bars
		if (intLetterBoxHeight != 0) {
			canvas.drawRect(0, 0, this.getWidth(), intLetterBoxHeight, pntLetterBox);
			canvas.drawRect(0, this.getHeight() - intLetterBoxHeight, this.getWidth(), this.getHeight(), pntLetterBox);
		}
		// Left and Right Bars
		else if (intLetterBoxWidth != 0) {
			canvas.drawRect(0, 0, intLetterBoxWidth, this.getHeight(), pntLetterBox);
			canvas.drawRect(this.getWidth() - intLetterBoxWidth, 0, this.getWidth(), this.getHeight(), pntLetterBox);
		}

		// Create GameBoard
		DrawGameBoard(canvas);

		// Draw Background Galaxy Image
		if (AppConfig.booDrawGalaxyBackground)
			canvas.drawBitmap(bmpBackgroundImage, 0, 0, null);

		// Draw the Circles on the Grid
		for (CircleDraw SpawnCircles : lstCircles) {
			SpawnCircles.onDraw(canvas);
		}

		// Draw the Screen Buttons
		for (ScreenDraw NavigateButtons : lstScreenDraw) {
			if (NavigateButtons != null)
				NavigateButtons.onDraw(canvas);
		}

		try {
			// canvas.drawText("WINNER", 10, 60, paintText.getPaintText(0xFFFFFFFF, 30, false, Align.LEFT, Typeface.MONOSPACE));
			// canvas.drawText(Integer.toString(bmpCircle.getWidth()) + " || " + Float.toString(fltImgRadius), 10, 60, paintText.getPaintText(0xFFFFFFFF, 30, false, Align.LEFT, Typeface.MONOSPACE));
			// canvas.drawText(Integer.toString(intCircleID) + " [" + Integer.toString(gridID.getCirclePosition()[intCircleID][0]) + " | " + Integer.toString(gridID.getCirclePosition()[intCircleID][1]) + "]", 10, 60, paintText.getPaintText(0xFFFFFFFF, 30, false, Align.LEFT, Typeface.MONOSPACE));
			float fltTextSize = (float) (AppConfig.fltGameViewTextSize * dblScaleRatio);
			float fltMargin = fltTextSize / 2;
			canvas.drawText("Level: " + setLevelState.getCurrentLevel(), AppConfig.fltGameBoardPadding, fltUpperScreenBound - fltTextSize - fltTextSize - fltMargin, paintText.getPaintText(0xAAFFFFFF, fltTextSize, true, Align.LEFT, Typeface.MONOSPACE));
			canvas.drawText("Moves: " + intMoves, AppConfig.fltGameBoardPadding, fltUpperScreenBound - fltTextSize, paintText.getPaintText(0xAAFFFFFF, fltTextSize, false, Align.LEFT, Typeface.MONOSPACE));

			canvas.drawText("Best: " + strBest, this.getWidth() - AppConfig.fltGameBoardPadding, fltUpperScreenBound - fltTextSize - fltTextSize - fltMargin, paintText.getPaintText(0xAAFFFFFF, fltTextSize, false, Align.RIGHT, Typeface.MONOSPACE));
			canvas.drawText("Complete: " + Math.round(((float) gridID.getIntWin() / (float) setLevelState.getTotalCircles()) * 100) + "%", this.getWidth() - AppConfig.fltGameBoardPadding, fltUpperScreenBound - fltTextSize, paintText.getPaintText(0xAAFFFFFF, fltTextSize, false, Align.RIGHT, Typeface.MONOSPACE));
		} catch (Exception ex) {
		}

		// Run the Tutorial
		if (setLevelState.getCurrentLevel() == 0) {
			tutorialDraw.onDraw(gridID, aryGridColors, intDialog, lstGridDimensions);
		}
	}
}
