/*
 * Copyright (C) 2009 CloudMade.
 * Copyright (C) 2011 APP-SOLUT (ported to android by APP-SOLUT)
 *
 * Licensed under the GNU Lesser General Public License, Version 3.0;
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.appsolut.api.cloudmade.geocoding;

/**
 * Raised when object was not found by geocoding service
 * 
 * @author Mykola Paliyenko
 *
 */
public class ObjectNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -644946044920880928L;

	public ObjectNotFoundException(String message) {
		super(message);
	}

}

 