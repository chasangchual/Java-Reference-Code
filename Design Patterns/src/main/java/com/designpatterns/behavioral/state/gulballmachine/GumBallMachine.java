/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 *  Copyright (c) 2010 Oracle and/or its affiliates. All rights reserved.
 *
 *  The contents of this file are subject to the terms of either the GNU
 *  General Public License Version 2 only ("GPL") or the Common Development
 *  and Distribution License("CDDL") (collectively, the "License").  You
 *  may not use this file except in compliance with the License.  You can
 *  obtain a copy of the License at
 *  https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 *  or packager/legal/LICENSE.txt.  See the License for the specific
 *  language governing permissions and limitations under the License.
 *
 *  When distributing the software, include this License Header Notice in each
 *  file and include the License file at packager/legal/LICENSE.txt.
 *
 *  GPL Classpath Exception:
 *  Oracle designates this particular file as subject to the "Classpath"
 *  exception as provided by Oracle in the GPL Version 2 section of the License
 *  file that accompanied this code.
 *
 *  Modifications:
 *  If applicable, add the following below the License Header, with the fields
 *  enclosed by brackets [] replaced by your own identifying information:
 *  "Portions Copyright [year] [name of copyright owner]"
 *
 *  Contributor(s):
 *  If you wish your version of this file to be governed by only the CDDL or
 *  only the GPL Version 2, indicate your decision by adding "[Contributor]
 *  elects to include this software in this distribution under the [CDDL or GPL
 *  Version 2] license."  If you don't indicate a single choice of license, a
 *  recipient has the option to distribute your version of this file under
 *  either the CDDL, the GPL Version 2 or to extend the choice of license to
 *  its licensees as provided above.  However, if you add GPL Version 2 code
 *  and therefore, elected the GPL Version 2 license, then the option applies
 *  only if the new code is made subject to such option by the copyright
 *  holder.
 *
 *
 *  This file incorporates work covered by the following copyright and
 *  permission notice:
 *
 *  Copyright 2010 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.designpatterns.behavioral.state.gulballmachine;

public class GumBallMachine {
	private GumBallMachineAbstractState state = new GumBallMachineOutOfGumballsState(this);
	
	private int quarterCount = 0 ; 
	private int gumballCount = 0 ; 
	
	public void insertQuarter() {
		quarterCount ++ ;
		try {
			String before = state.getStateDesc() ;

			state = state.insertQuarter() ;
			
			String after = state.getStateDesc() ;
			
			stateChange(before, after) ; 
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage()) ;
		}
	}
	
	public void ejectQuarter() {
		quarterCount = 0 ;
		try {
			String before = state.getStateDesc() ;
			state = state.ejectQuarter() ;
			String after = state.getStateDesc() ;
			
			stateChange(before, after) ; 
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage()) ;
		}
	}
	
	public void turnCrank() {
		try {
			String before = state.getStateDesc() ;
			state = state.turnCrank() ;
			String after = state.getStateDesc() ;
			
			stateChange(before, after) ;
			
			dispense() ;
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage()) ;
		}
	}
	
	public void dispense() {
		gumballCount -- ; 
		quarterCount -= 2 ;
		try {
			String before = state.getStateDesc() ;
			state = state.dispense() ;
			String after = state.getStateDesc() ;
			
			stateChange(before, after) ; 
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage()) ;
		}
	}

	public void fill(int gulballFillCount) {
		gumballCount += gulballFillCount ;
		try {
			String before = state.getStateDesc() ;
			state = state.fill() ;
			String after = state.getStateDesc() ;
			
			stateChange(before, after) ; 
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage()) ;
		}
	}	
	
	public GumBallMachineAbstractState getState() {
		return state;
	}

	public int getQuarterCount() {
		return quarterCount;
	}

	public int getGumballCount() {
		return gumballCount;
	}
	
	public void stateChange(String before, String after) {
		System.out.println("State Changed [Before : " + before + "] -> [After : " + after + "]") ;
	}
	
	public void display() {
		System.out.println("[Gumball : " + String.valueOf(gumballCount)	+ "] [Quarter : " + String.valueOf(quarterCount) + "] " + state.getStateDesc() + "\n") ;
	}
	
	public static void main(String[] args) {
		GumBallMachine machine = new GumBallMachine() ; 
		machine.display() ;
		
		machine.fill(3) ; machine.display() ;
		
		machine.insertQuarter() ; machine.display() ;
		machine.insertQuarter() ; machine.display() ;
		machine.turnCrank() ; machine.display() ;
		
		machine.insertQuarter() ; machine.display() ;
		machine.turnCrank() ; machine.display() ;
		machine.insertQuarter() ; machine.display() ;
		machine.turnCrank() ; machine.display() ;
		
		machine.insertQuarter() ; machine.display() ;
		machine.insertQuarter() ; machine.display() ;
		machine.turnCrank() ; machine.display() ;
		
		machine.turnCrank() ; machine.display() ;
		machine.fill(2) ; 
		
		machine.insertQuarter() ; machine.display() ;
		machine.insertQuarter() ; machine.display() ;
		machine.turnCrank() ; machine.display() ;
		
		/**
		[Gumball : 0] [Quarter : 0] Out of Gumballs state

		State Changed [Before : Out of Gumballs state] -> [After : No Quarter state]
		[Gumball : 3] [Quarter : 0] No Quarter state

		State Changed [Before : No Quarter state] -> [After : No Quarter state]
		[Gumball : 3] [Quarter : 1] No Quarter state

		State Changed [Before : No Quarter state] -> [After : Has Enough Quaters state]
		[Gumball : 3] [Quarter : 2] Has Enough Quaters state

		State Changed [Before : Has Enough Quaters state] -> [After : Gumball Just Sold state]
		State Changed [Before : Gumball Just Sold state] -> [After : No Quarter state]
		[Gumball : 2] [Quarter : 0] No Quarter state

		State Changed [Before : No Quarter state] -> [After : No Quarter state]
		[Gumball : 2] [Quarter : 1] No Quarter state

		Can not turn the crank when the gumball machine state is No Quarter state.
		[Gumball : 2] [Quarter : 1] No Quarter state

		State Changed [Before : No Quarter state] -> [After : Has Enough Quaters state]
		[Gumball : 2] [Quarter : 2] Has Enough Quaters state

		State Changed [Before : Has Enough Quaters state] -> [After : Gumball Just Sold state]
		State Changed [Before : Gumball Just Sold state] -> [After : No Quarter state]
		[Gumball : 1] [Quarter : 0] No Quarter state

		State Changed [Before : No Quarter state] -> [After : No Quarter state]
		[Gumball : 1] [Quarter : 1] No Quarter state

		State Changed [Before : No Quarter state] -> [After : Has Enough Quaters state]
		[Gumball : 1] [Quarter : 2] Has Enough Quaters state

		State Changed [Before : Has Enough Quaters state] -> [After : Gumball Just Sold state]
		State Changed [Before : Gumball Just Sold state] -> [After : Out of Gumballs state]
		[Gumball : 0] [Quarter : 0] Out of Gumballs state

		Can not turn the crank when the gumball machine state is Out of Gumballs state.
		[Gumball : 0] [Quarter : 0] Out of Gumballs state

		State Changed [Before : Out of Gumballs state] -> [After : No Quarter state]
		State Changed [Before : No Quarter state] -> [After : No Quarter state]
		[Gumball : 2] [Quarter : 1] No Quarter state

		State Changed [Before : No Quarter state] -> [After : Has Enough Quaters state]
		[Gumball : 2] [Quarter : 2] Has Enough Quaters state

		State Changed [Before : Has Enough Quaters state] -> [After : Gumball Just Sold state]
		State Changed [Before : Gumball Just Sold state] -> [After : No Quarter state]
		[Gumball : 1] [Quarter : 0] No Quarter state
		**/
	}
}
