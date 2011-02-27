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

import junit.framework.TestCase;


public class ResourceManagerTest extends TestCase{
	ResourceManager rsm;
	
	public void setUp() throws Exception{
		rsm = new ResourceManager();
	}
	
	public void testGetUrlsFilesPackage() throws Exception{
		URL[] urls = rsm.getUrls("package", "test.xml");
		assertTrue(urls.length == 1);
		System.out.println(urls[0]);
	}
	
	
	public void testGetUrlsDirPackage() throws Exception{
		URL[] urls = rsm.getUrls("package", "testdir");
		assertTrue(urls.length == 2);
		for( URL url : urls){
			System.out.println(url);
		}
	}
	
	public void testGetUrlsFilesURl() throws Exception{
		URL[] urls = rsm.getUrls("url", "file:/media/sda4/work/projects/resource-loader/src/test/resources/test.xml");
		assertTrue(urls.length == 1);
		System.out.println(urls[0]);
	}
	
	public void testGetUrlsFilesUrlHttp() throws Exception{
		URL[] urls = rsm.getUrls("url", "http://www.www.com");
		assertTrue(urls.length == 1);
		System.out.println(urls[0]);
	}
	

}
