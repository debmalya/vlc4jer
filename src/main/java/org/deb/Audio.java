/**
 * 
 */
package org.deb;

import org.deb.components.CustomeEmbeddedPlayer;

import uk.co.caprica.vlcj.player.component.AudioPlayerComponent;

/**
 * @author Debmalya
 *
 */
public class Audio {
	private final AudioPlayerComponent mediaPlayerComponent;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Audio audio = new Audio();
		if (args.length > 0) {
			audio.mediaPlayerComponent.mediaPlayer().media().play(args[0]);
		} else {
			System.err.println("Nothing to play");
		}
		System.out.println("DONE");

	}
	
	private Audio() {
        mediaPlayerComponent = new AudioPlayerComponent();
//        mediaPlayerComponent.mediaPlayer().events().addMediaPlayerEventListener(new CustomeEmbeddedPlayer());
    }

}
