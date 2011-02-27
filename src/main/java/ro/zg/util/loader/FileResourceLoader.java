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

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileResourceLoader implements ResourceLoader{
	private ResourceLoader innerResourceLoader;
	
	public FileResourceLoader(ResourceLoader resourceLoader){
		innerResourceLoader = resourceLoader;
	}
	

	public URL[] load() throws Exception {
		URL[] urls = innerResourceLoader.load();
		URL url = urls[0];
		
		if(url.getProtocol().equals("file")){
			File f = new File(url.getPath());
			
			if(f.isDirectory()){
				List<URL> listOfURls = new ArrayList<URL>();
				File[] subfiles = f.listFiles();
				for(File subfile : subfiles){
					if(!subfile.isDirectory()){
						listOfURls.add(subfile.toURI().toURL());
					}
				}
				return listOfURls.toArray(new URL[0]);
			}
		}
		return urls;
	}

}
