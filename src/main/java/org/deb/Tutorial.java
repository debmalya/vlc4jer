/**
 * 
 */
package org.deb;

import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

/**
 * @author Debmalya
 *
 */
public class Tutorial {
	/**
	 * First argument is the path to libvlc.dll
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MediaPlayerFactory factory = new MediaPlayerFactory();
		EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
		System.out.println("DONE");
		
	}

}
