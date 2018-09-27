package thomasWilliams.ShuffleFour;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class CircleDraw {
	// direction = 0 up, 1 left, 2 down, 3 right,
	// animation = 3 up, 1 left, 0 down, 2 right
	private int x = 0;
	private int y = 0;
	private GameView gameView;
	private Bitmap bmpBackdrop;
	private GridDimensions gridDimensions;
	private int width;
	private int height;
	private int currentFrame;
	private float fltBitmapRadius;
	private boolean booCreated = true;
	private Paint pntBackdrop = new Paint();
	private float fltCircleRadius;
	private Rect srcSprite;
	private Rect dstSprite;
	private Canvas cvsBackdrop;
	private Bitmap bmpCircle;

	public CircleDraw(GameView gameView, Bitmap bmpBackdrop, float fltBitmapRadius, Bitmap bmpCircle, GridDimensions gridDimensions) {
		this.gameView = gameView;
		this.bmpBackdrop = bmpBackdrop;
		this.fltBitmapRadius = fltBitmapRadius;
		this.bmpCircle = bmpCircle;
		this.gridDimensions = gridDimensions;

		this.width = bmpBackdrop.getWidth();
		this.height = bmpBackdrop.getHeight();

		// Set the Circle Color
		pntBackdrop.setColor(gridDimensions.getColor());

		fltCircleRadius = (float) (fltBitmapRadius * (1 - AppConfig.dblCirclePadding));
		cvsBackdrop = new Canvas(bmpBackdrop);
	}

	private void update() {
		// Set the Circle Dimensions
		x = (int) gridDimensions.getX();
		y = (int) gridDimensions.getY();
		
		// Set the src and dst
		srcSprite = new Rect(0, 0, width, height);
		dstSprite = new Rect(x, y, x + width, y + height);

		currentFrame = ++currentFrame;
	}

	public void onDraw(Canvas canvas) {
		update();

		if (AppConfig.booUseBitmapForCircle)
			canvas.drawBitmap(bmpCircle, srcSprite, dstSprite, null);
		else {
			cvsBackdrop.drawCircle((fltBitmapRadius / 2), (fltBitmapRadius / 2), ((fltCircleRadius) / 2), pntBackdrop);
			canvas.drawBitmap(bmpBackdrop, srcSprite, dstSprite, null);
		}
	}
}
