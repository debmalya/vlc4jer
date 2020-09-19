/**
 * 
 */
package org.deb;

import java.io.File;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.binding.RuntimeUtil;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

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
		if (args.length > 0) {
			File vlcInstallPath = new File(args[0]);
			
			NativeLibrary.addSearchPath(
	                RuntimeUtil.getLibVlcLibraryName(), vlcInstallPath.getAbsolutePath());
//			Native.register(RuntimeUtil.getLibVlcLibraryName());
//			Native.register(vlcInstallPath.getAbsolutePath());
	        
			// MediaPlayerFactory factory = new MediaPlayerFactory();
			EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
		}else{
			
		}
			
	}

}
