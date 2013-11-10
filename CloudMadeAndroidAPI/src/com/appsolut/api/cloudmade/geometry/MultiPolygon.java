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
package com.appsolut.api.cloudmade.geometry;

import java.util.List;
/**
 * Geometry object that consists of Polygon geometries
 * 
 * @author Mykola Paliyenko
 *
 */
public class MultiPolygon extends Geometry {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2312479491119378623L;
	/**
	 * List of polygons, that make up the multipolygon
	 */
	public final List<Polygon> polygons;

	public MultiPolygon(List<Polygon> polygons) {
		this.polygons = polygons;
	}
	
}
