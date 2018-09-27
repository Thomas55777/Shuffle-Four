package thomasWilliams.ShuffleFour;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class ScreenDraw {
	private int x = 0;
	private int y = 0;
	private GameView gameView;
	private Rect srcSprite;
	private Rect dstSprite;
	private int currentFrame;
	private boolean booCreated = true;
	private int width;
	private int height;
	private Bitmap bmp;
	private int intX;

	public ScreenDraw(GameView gameView, Bitmap bmp, int intX) {
		this.gameView = gameView;

		this.width = bmp.getWidth();
		this.height = bmp.getHeight();
		this.bmp = bmp;
		this.intX = intX;
	}

	private void update() {
		// Set the Circle Dimensions
		x = intX - (width / 2);
		y = (int) (gameView.getOutterBounds()[3] + (gameView.getFltLineSpacing()) / 3);

		// Set the src and dst
		srcSprite = new Rect(0, 0, width, height);
		dstSprite = new Rect(x, y, x + width, y + height);

		currentFrame = ++currentFrame;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public void onDraw(Canvas canvas) {
		update();

		canvas.drawBitmap(bmp, srcSprite, dstSprite, null);
	}
}
