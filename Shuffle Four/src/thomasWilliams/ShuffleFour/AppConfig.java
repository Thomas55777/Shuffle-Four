package thomasWilliams.ShuffleFour;

import android.app.Application;

public class AppConfig extends Application {
	// GameLoopThread
	public static final long FPS = 20;
	// GameMenu
	public static final int intLevelsPerPage = 50;
	public static final float fltMenuTextSize = 22;
	// GameView
	public static final boolean booBackgroundFullScreen = false;
	public static final boolean booDrawInnerBorder = false;
	public static final int intBackgroundBaseColor = 0xFF1A1A2A;
	public static final int intInnerSquareColor = 0x6A666677; //0x88444466
	public static final int intBackgroundColorDark = 0xAA222244;//0xFF111111; //0xAAAAAACC //0xAA8888AA
	public static final int intBackgroundColorLight = 0xFFFFFFFF;//0xFF111111; //0xAAAAAACC //0xAA8888AA
	public static final int intBackgroundColorMedium = 0xAA8888AA;//0xFF111111; //0xAAAAAACC //0xAA8888AA
	public static final int intCircleColorRed = 0xFFFF0000;
	public static final int intCircleColorBlue = 0xFF0000FF;
	public static final int intCircleColorYellow = 0xFFFFFF00;
	public static final int intCircleColorGreen = 0xFF00FF00;
	public static final int intGridColorNoColor = 0x00000000;
	public static final int intGridColorRed = 0x88FF0000;
	public static final int intGridColorBlue = 0x880000FF;
	public static final int intGridColorYellow = 0x88FFFF00;
	public static final int intGridColorGreen = 0x8800FF00;
	public static final int intGridColorWinRed = 0x66FF0000;
	public static final int intGridColorWinBlue = 0x660000FF;
	public static final int intGridColorWinYellow = 0x66FFFF00;
	public static final int intGridColorWinGreen = 0x6600FF00;

	// public static final int intGridSize = 6;
	// public static final int intTotalCircles = (intGridSize - 2) * 4;
	public static final boolean booDrawGalaxyBackground = false;
	public static final double dblCicleRadius = 0.9;
	public static final double dblCirclePadding = 0.4;
	public static final boolean booUseBitmapForCircle = false;
	public static final boolean booDrawGridLine = true;
	public static final int intBlackBoarderAroundCirles = 0;
	public static final double dblGameBoardOffsetFromTop = 0.4;
	public static final double dblGameBoardBorderWidth = 0.03; // 0.07 Percent of screen used for the Boarder Color
	public static final boolean booDrawColorRectanglesOnBoarder = true;
	public static final float fltGameBoardPadding = 10;
	public static final float fltOverlapPct = 0.7f;
	public static final float fltGridColorBorderPct = 0.11f;// 0.11f; // Increase to make GridColor Thicker
	public static final float fltStrokeWidth = 2.2f;
	public static final float fltScreenDrawSize = 8f;
	public static final float fltGameViewTextSize = 18;
	public static final boolean booBackgroundMusic = false;
	public static final int[] aryImgColors = { 0, 0, 0, 0, R.drawable.gridview_66ffaa, R.drawable.gridview_aa66ff, R.drawable.gridview_aaff66, R.drawable.gridview_ff66aa, R.drawable.gridview_ff66aa, R.drawable.gridview_ff66aa };
	public static final int[] aryMenuColors = { 0xFF66AAFF, 0xFFFFAA66, 0, 0, 0xFF66FFAA, 0xFFAA66FF, 0xFFAAFF66, 0XFFFF66AA, 0XFFFF66AA, 0XFFFF66AA };
	public static final boolean booCompleteLevelOnMenuPress = false;
	
	public static final boolean booGameDrawRaw = false;
	public static final boolean booDrawEnemyMissiles = true;
	public static final boolean booMainSpriteInvincible = false;
	public static final int intBeginningLevelCountdown = (int) (FPS * 3); // 3 seconds
	public static final int intMissileRadius = 10; // raw radius; its gets scaled later
	public static final int intMissileFireFrequency = 6;
	public static final int intAspectWidth = 480;
	public static final int intAspectHeight = 800;
	public static final double dblScreenRatio = (double) intAspectWidth / (double) intAspectHeight;
	public static final double dblBoundX = 0.4; // originally 0.3; // To determine the size of the directional cursor and button
	public static final double dblBoundY = dblBoundX * dblScreenRatio;
	public static final int HealthBarHeight = 30;

	// MainSprite
	public static final int intSpriteSpeedX = 9;
	public static final int intSpriteSpeedY = intSpriteSpeedX; // 12;
	public static final double dblSlowFactorSpeedY = 1; // 0.5;
	public static final int intCursorSensitivity = 45; // 20;
	// EnemyDraw
	public static final int intEnemyMissileFireFrequency = 990; // Out of 1000
	public static final int intMissileSpeed = -8; // Scaled later for speed
	public static final int intMaxSpeedX = 4; // Scaled later for speed
	public static final int intEnemySpeedX = 11;
	public static final int intEnemySpeedY = 5;
	// LeadBolt Ads
	public static final String strBanner300x250 = "164302032";
	public static final String strBanner468x60 = "787568120";
	public static final String strBanner640x100 = "257734435";
	public static final String strBanner728x90 = "513474731";
	public static final String strAppWall = "765974746";
	public static final String strPushNotification = "946544753";
	public static final int intSecondsCountDown = 60;
	public static final int intOverlayFrequency = 5;
	public static final boolean booAppWall = true;
	public static final boolean booShowAdvancedOverlay = false;
	public static final boolean booLoadPushNotification = false;
	public static final boolean booLoadBannerAds = false;
	// TapForTap Ads
	// public static final String strTapForTapAppId = "d2e625b0-cb63-012f-fbd6-4040d804a637";
	public static final boolean booLoadTapForTap = false;

	// ScoreLoop
	// private final String strScoreLoopSecret = "aP+D/xfZgUn10TGgSFKbnDmUrGrgW9lsUpZiWCH6h4ltgLJW0wZOcw=="; // SerpentineSpaceShooter

	public void onCreate() {
		// https://developer.scoreloop.com
		// Game ID has to be in the scoreloop.properties file (located in assets)

		// initialize the client using the context and game secret
		// Client.init(this, strScoreLoopSecret, null);
	}
}

// Can also do BillPay where user can pay to
// -Remove Advertisements
// -Speed Up
// -Twin Missiles

// Add friend section in ScoreLoop
// Enemy Paths Programming