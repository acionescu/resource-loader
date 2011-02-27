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

import java.net.URL;

public class ResourceManager {
	private AbstractFactory<ResourceLoaderFactory> factories;
	
	public ResourceManager(){
		init();
	}
	
	private void init(){
		//use theese default factories
		factories = new AbstractFactory<ResourceLoaderFactory>();
		factories.registerFactory("package",new PackageResourceLoaderFactory());
		factories.registerFactory("url", new UrlResourceLoaderFactory());
	}
	
	public ResourceLoader getResourceLoader(String resourceType, String path){
		return factories.getFactory(resourceType).createResourceLoader(path);
	}
	
	public URL[] getUrls(String resourceType, String path) throws Exception{
		FileResourceLoader fileResourceLoader = new FileResourceLoader(getResourceLoader(resourceType, path));
		return fileResourceLoader.load();
	}

}
