/*
   This file is part of a Bug-Sample.

    Bug-Sample is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    The Bug-Sample is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with the Bug-Sample.  If not, see <http://www.gnu.org/licenses/>.
*/
package net.unckel.SecManUndertowFail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author boris_unckel
 *
 */
public class SampleContainerInitializer implements ServletContainerInitializer {

	private Logger logger = LogManager.getLogManager().getLogger(SampleContainerInitializer.class.getCanonicalName());
	
	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		logger.info("Starting with SampleContainerInitializer onStartup");
		final String resourceName = "/sample/hello.txt";
		InputStream is = ctx.getResourceAsStream(resourceName);
		if(is == null) {
			logger.info("InputStream of " + resourceName + " is null");
		} else {
			logger.info("InputStream of " + resourceName + " found");
			try {
				is.close();
			} catch (IOException e) {
				logger.log(Level.WARNING, "Failed to close InputStream of " +resourceName,e);
			}
		}
		logger.info("Finished SampleContainerInitializer onStartup");
	}

}
