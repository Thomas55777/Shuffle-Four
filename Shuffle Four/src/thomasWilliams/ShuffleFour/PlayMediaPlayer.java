package thomasWilliams.ShuffleFour;

import java.io.IOException;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Handler;

public class PlayMediaPlayer {

	private Context applicationContext;
	private static MediaPlayer mprSound;

	public PlayMediaPlayer(Context applicationContext) {
		this.applicationContext = applicationContext;
	}

	public void playSound(int intResource) {
		try {
			boolean mStartPlaying = true;
			mprSound = null;
			if (mStartPlaying == true) {
				mprSound = new MediaPlayer();

				Uri uri = Uri.parse("android.resource://thomasWilliams.ShuffleFour/" + intResource);
				mprSound.setDataSource(applicationContext, uri);
				mprSound.prepare();
				mprSound.start();
			} else {
				mprSound.release();
				mprSound = null;
			}
			mStartPlaying = !mStartPlaying;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	OnCompletionListener mprLoopListener = new OnCompletionListener() {
		public void onCompletion(MediaPlayer mp) {
			mp.release();
			// I dont know if I want to do this garbage clean
			System.gc();
			// Sleep betweeen loops
			Handler handler = new Handler();
			handler.postDelayed(new Runnable() {
				public void run() {
					if (booMusicOn)
						startLoop(getLoopResource());
				}
			}, 10);
		}
	};
	private int intLoopResource;
	private boolean booMusicOn = true;
	private static MediaPlayer mprSoundLoop;

	public void playMusicLoop(int intResource) {
		// Set the resource
		setLoopResource(intResource);
		startLoop(intResource);
	}

	public void stopMusicLoop() {
		booMusicOn = false;
		try {
			if (mprSoundLoop != null)
				mprSoundLoop.release();
		} catch (Exception ex) {
			System.out.println("@@ Exception while playing: " + ex);
		}
	}

	public boolean isPlaying() {
		if (mprSound == null)
			return false;
		else
			return mprSound.isPlaying();
	}

	private void startLoop(int intResource) {
		try {
			booMusicOn = true;
			mprSoundLoop = new MediaPlayer();

			Uri uri = Uri.parse("android.resource://thomasWilliams.ShuffleFour/" + intResource);
			mprSoundLoop.setDataSource(applicationContext, uri);
			mprSoundLoop.prepare();

			mprSoundLoop.setOnCompletionListener(mprLoopListener);
			mprSoundLoop.start();
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
	}

	private void setLoopResource(int intResource) {
		intLoopResource = intResource;
	}

	private int getLoopResource() {
		return intLoopResource;
	}
}