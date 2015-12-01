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

package com.designpatterns.creational.builder.pizza;

/**
 * 
 * We've all at some point encountered a class with a list of constructors where each addition adds a new option parameter:
 * 
 * Pizza(int size) { ... }        
 * Pizza(int size, boolean cheese) { ... }    
 * Pizza(int size, boolean cheese, boolean pepperoni) { ... }    
 * Pizza(int size, boolean cheese, boolean pepperoni, boolean bacon) { ... }
 *
 * This is called the Telescoping Constructor Pattern. 
 * The problem with this pattern is that once constructors are 4 or 5 parameters long it becomes difficult to remember the required order of the parameters as well as what particular constructor you might want in a given situation.
 * One alternative you have to the Telescoping Constructor Pattern is the JavaBean Pattern where you call a constructor with the mandatory parameters and then call any optional setters after:
 * 
 * Pizza pizza = new Pizza(12);
 * 
 * pizza.setCheese(true);
 * pizza.setPepperoni(true);
 * pizza.setBacon(true);
 * 
 * The problem here is that because the object is created over several calls it may be in an inconsistent state partway through its construction. 
 * This also requires a lot of extra effort to ensure thread safety.
 * 
 * @author chasc
 *
 */
public class Pizza {
	private int size ; 
	private boolean cheese = false ; 
	private boolean pepperoni = false  ; 
	private boolean bacon = false  ; 
	
	public static class Builder {
		private int size ; 
		private boolean cheese = false ; 
		private boolean pepperoni = false  ; 
		private boolean bacon = false  ; 
		
		public Builder(int size) {
			this.size = size ;
		}
		
		public Builder cheese(boolean cheese) {
			this.cheese = cheese ;
			return this ;
		}
		
		public Builder cheese() {
			return cheese(true) ;
		}
		
		public Builder pepperrony(boolean pepperoni) {
			this.pepperoni = pepperoni ;
			return this ;
		}
		
		public Builder pepperrony() {
			return pepperrony(true) ;
		}
		
		public Builder bacon(boolean bacon) {
			this.bacon = bacon ;
			return this ;
		}
		
		public Builder bacon() {
			return bacon(true) ;
		}
		
		public Pizza build() {
			return new Pizza(this) ;
		}
	}
	
	public Pizza(Builder builder) {
		this.size = builder.size ;
		this.cheese = builder.cheese ;
		this.pepperoni = builder.pepperoni ;
		this.bacon = builder.bacon ;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder() ; 
		
		sb.append("Size : " + this.size + " inche, ") ;
		sb.append("Ingredient : ") ;
		sb.append(cheese ? "Cheese " : "") ;
		sb.append(pepperoni ? "Pepperoni " : "") ;
		sb.append(bacon ? "Bacon " : "") ;
		
		return sb.toString();
	}
	
	
}
