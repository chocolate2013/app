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
package com.appsolut.api.cloudmade.routing;

import java.io.Serializable;
import java.util.ArrayList;

public class RouteSummary implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3017403887321194053L;
	public final double totalDistance;
	public final double totalTime;
	public final String startPoint;
	public final String endPoint;
	public final ArrayList<TransitPoint> transitPoints;
	
	public RouteSummary(double totalDistance, double totalTime,
			String startPoint, String endPoint,
			ArrayList<TransitPoint> transitPoints) {
		super();
		this.totalDistance = totalDistance;
		this.totalTime = totalTime;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.transitPoints = transitPoints;
	}
	

}
