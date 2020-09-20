/**
 * 
 */
package org.deb.listeners;

import uk.co.caprica.vlcj.media.Media;
import uk.co.caprica.vlcj.media.MediaEventListener;
import uk.co.caprica.vlcj.media.MediaParsedStatus;
import uk.co.caprica.vlcj.media.MediaRef;
import uk.co.caprica.vlcj.media.Meta;
import uk.co.caprica.vlcj.media.Picture;
import uk.co.caprica.vlcj.player.base.State;

/**
 * @author Debmalya
 *
 */
public class CustomMediaEventListener implements MediaEventListener{

	/* (non-Javadoc)
	 * @see uk.co.caprica.vlcj.media.MediaEventListener#mediaMetaChanged(uk.co.caprica.vlcj.media.Media, uk.co.caprica.vlcj.media.Meta)
	 */
	@Override
	public void mediaMetaChanged(Media media, Meta metaType) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see uk.co.caprica.vlcj.media.MediaEventListener#mediaSubItemAdded(uk.co.caprica.vlcj.media.Media, uk.co.caprica.vlcj.media.MediaRef)
	 */
	@Override
	public void mediaSubItemAdded(Media media, MediaRef newChild) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see uk.co.caprica.vlcj.media.MediaEventListener#mediaDurationChanged(uk.co.caprica.vlcj.media.Media, long)
	 */
	@Override
	public void mediaDurationChanged(Media media, long newDuration) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see uk.co.caprica.vlcj.media.MediaEventListener#mediaParsedChanged(uk.co.caprica.vlcj.media.Media, uk.co.caprica.vlcj.media.MediaParsedStatus)
	 */
	@Override
	public void mediaParsedChanged(Media media, MediaParsedStatus newStatus) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see uk.co.caprica.vlcj.media.MediaEventListener#mediaFreed(uk.co.caprica.vlcj.media.Media, uk.co.caprica.vlcj.media.MediaRef)
	 */
	@Override
	public void mediaFreed(Media media, MediaRef mediaFreed) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see uk.co.caprica.vlcj.media.MediaEventListener#mediaStateChanged(uk.co.caprica.vlcj.media.Media, uk.co.caprica.vlcj.player.base.State)
	 */
	@Override
	public void mediaStateChanged(Media media, State newState) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see uk.co.caprica.vlcj.media.MediaEventListener#mediaSubItemTreeAdded(uk.co.caprica.vlcj.media.Media, uk.co.caprica.vlcj.media.MediaRef)
	 */
	@Override
	public void mediaSubItemTreeAdded(Media media, MediaRef item) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see uk.co.caprica.vlcj.media.MediaEventListener#mediaThumbnailGenerated(uk.co.caprica.vlcj.media.Media, uk.co.caprica.vlcj.media.Picture)
	 */
	@Override
	public void mediaThumbnailGenerated(Media media, Picture picture) {
		// TODO Auto-generated method stub
		
	}

}
