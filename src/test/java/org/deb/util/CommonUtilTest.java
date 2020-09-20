/**
 * 
 */
package org.deb.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Debmalya
 *
 */
public class CommonUtilTest {
	
	

	/**
	 * Test method for {@link org.deb.util.CommonUtil#getTitle(java.lang.String)}.
	 */
	@Test
	public void testGetTitle() {
		assertEquals("AajRabriKheteElem.ogg",CommonUtil.getTitle("./src/test/resources/AajRabriKheteElem.ogg"));
	}

	/**
	 * Test method for {@link org.deb.util.CommonUtil#getTitleFromFile(java.lang.String)}.
	 */
	@Test
	public void testGetTitleFromFile() {
		assertEquals("AajRabriKheteElem.ogg",CommonUtil.getTitleFromFile("./src/test/resources/AajRabriKheteElem.ogg"));
	}

}
