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

import java.util.Hashtable;
import java.util.Map;

public class AbstractFactory<F> {
	private Map<String,F> factories = new Hashtable<String,F>();
	
	public F getFactory(String key){
		return factories.get(key);
	}
	
	public void registerFactory(String key, F factory){
		factories.put(key, factory);
	}
	
	public void unregisterFactory(String key){
		factories.remove(key);
	}

	public Map<String, F> getFactories() {
		return factories;
	}

	public void setFactories(Map<String, F> factories) {
		this.factories = factories;
	}
	
	
}
