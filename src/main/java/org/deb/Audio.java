/**
 * 
 */
package org.deb;

import javax.swing.JFrame;

import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.component.AudioPlayerComponent;

/**
 * @author Debmalya
 *
 */
public class Audio {
//	private final JFrame frame;
	private final AudioPlayerComponent mediaPlayerComponent;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Audio audio = new Audio();
		if (args.length > 0) {
			audio.start(args[0]);
			try {
	            Thread.currentThread().join();
	        }
	        catch(InterruptedException e) {
	        	e.printStackTrace();
	        }
		} else {
			System.err.println("Nothing to play");
		}
		System.out.println("DONE");

	}
	
	private Audio() {
        mediaPlayerComponent = new AudioPlayerComponent();
        mediaPlayerComponent.mediaPlayer().events().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
            @Override
            public void finished(MediaPlayer mediaPlayer) {
                exit(0);
            }

            @Override
            public void error(MediaPlayer mediaPlayer) {
                exit(1);
            }
        });
    }
	
	private void start(String mrl) {
        mediaPlayerComponent.mediaPlayer().media().play(mrl);
    }
	
	private void exit(int result) {
        // It is not allowed to call back into LibVLC from an event handling thread, so submit() is used
        mediaPlayerComponent.mediaPlayer().submit(new Runnable() {
            @Override
            public void run() {
                mediaPlayerComponent.mediaPlayer().release();
                System.exit(result);
            }
        });
    }

}
