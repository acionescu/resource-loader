/*******************************************************************************
 * Copyright 2011 Adrian Cristian Ionescu
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package ro.zg.util.loader;

import java.io.InputStream;
import java.net.URL;

public class PackageResourceLoader implements ResourceLoader{
	private String path;
	
	public PackageResourceLoader(String path){
		if(path == null){
			throw new IllegalArgumentException("Specified path cannot be null.");
		}
		this.path = path;
	}

	public URL[] load() {
		URL url = Thread.currentThread().getContextClassLoader().getResource(path);
		return new URL[]{url};
	}
	
	
}
