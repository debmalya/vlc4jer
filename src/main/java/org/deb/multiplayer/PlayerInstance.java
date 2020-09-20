/**
 * 
 */
package org.deb.multiplayer;

import java.awt.Canvas;
import java.awt.Color;

import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

/**
 * @author Debmalya
 *
 */
public class PlayerInstance extends MediaPlayerEventAdapter {
	private final EmbeddedMediaPlayer mediaPlayer;
	private final Canvas videoSurface;
	
	public PlayerInstance(EmbeddedMediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
        this.videoSurface = new Canvas();
        this.videoSurface.setBackground(Color.black);

        mediaPlayer.events().addMediaPlayerEventListener(this);
    }
	
	public EmbeddedMediaPlayer mediaPlayer() {
        return mediaPlayer;
    }
	
	public Canvas videoSurface() {
        return videoSurface;
    }

}
