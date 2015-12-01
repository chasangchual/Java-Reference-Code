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

package com.muryang.testng.samples.parameterizedtest.withdataprovider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestParameterDataProvider {

    @Test(dataProvider = "provideNumbersInArray")
    public void test1(int number, int expected) {
    	System.out.println("number : " + String.valueOf(number) + " , expected : " + String.valueOf(expected)) ; 
    	assertEquals(number + 10, expected);
    }

    @DataProvider(name = "provideNumbersInArray")
    public Object[][] provideDataInArray() {

            return new Object[][] { 
                    {  10, 20 }, 
                    { 100, 110 }, 
                    { 200, 210 } 
            };
    }
    
    @Test(dataProvider = "provideNumbersInIterator")
    public void test2(int number, int expected) {
    	System.out.println("number : " + String.valueOf(number) + " , expected : " + String.valueOf(expected)) ; 
    	assertEquals(number + 10, expected);
    }

    @DataProvider(name = "provideNumbersInIterator")
    public Iterator<Object[]> provideDataInIterator() {
    	Collection<Object[]> provider = new ArrayList<Object[]>();
    	
    	provider.add(new Object[]{ 210,   220 }) ;
    	provider.add(new Object[]{ 2100, 2110 }) ;
    	provider.add(new Object[]{ 2200, 2210 }) ;
    	
    	return provider.iterator() ;
    }    

    @Test(dataProvider = "provideNumberMapInIterator")
    public void test3(Map<Integer, Integer[]>params) {
    	for(Integer key : params.keySet()) {
    		Object[] values = params.get(key) ;
    		assert(values.length >= 2) ;
    		int number = (Integer) values[0] ;
    		int expected = (Integer) values[1] ;
    		
        	System.out.println("number : " + String.valueOf(number) + " , expected : " + String.valueOf(expected)) ; 
        	assertEquals(number + 10, expected);
    	}
    }
    
    @DataProvider(name = "provideNumberMapInIterator")
    public Object[][] provideDataMapInArray() {
    	Map<Integer, Integer[]> params = new HashMap<Integer, Integer[]>() ;
    	
    	params.put(1, new Integer[] {310, 320}) ;
    	params.put(2, new Integer[] {320, 330}) ;
    	params.put(3, new Integer[] {330, 340}) ;
    	params.put(4, new Integer[] {340, 350}) ;
    	
    	return new Object[][] { { params } };

    }
    
    @Test(dataProvider = "provideNumbersInIterator2")
    public void test4(int number, int expected) {
    	System.out.println("number : " + String.valueOf(number) + " , expected : " + String.valueOf(expected)) ; 
    	assertEquals(number + 10, expected);
    }

    @Test(dataProvider = "provideNumbersInIterator2")
    public void test5(int number, int expected) {
    	System.out.println("number : " + String.valueOf(number) + " , expected : " + String.valueOf(expected)) ; 
    	assertEquals(number + 10, expected);
    }
    
    @DataProvider(name = "provideNumbersInIterator2")
    public Iterator<Object[]> provideDataInIterator2(Method method) {
    	Collection<Object[]> provider = new ArrayList<Object[]>();
    	
    	if(method.getName().equals("test4")) {
        	provider.add(new Object[]{ 610,   620 }) ;
        	provider.add(new Object[]{ 6100, 6110 }) ;
        	provider.add(new Object[]{ 6200, 6210 }) ;
    	} else {
        	provider.add(new Object[]{ 710,   720 }) ;
        	provider.add(new Object[]{ 7100, 7110 }) ;
        	provider.add(new Object[]{ 7200, 7210 }) ;
    	}
    	
    	return provider.iterator() ;
    }    
    
    @Test(dataProvider = "provideNumbersInIterator3", groups="groupA")
    public void test6(int number, int expected) {
    	System.out.println("number : " + String.valueOf(number) + " , expected : " + String.valueOf(expected)) ; 
    	assertEquals(number + 10, expected);
    }
    
    @Test(dataProvider = "provideNumbersInIterator3", groups="groupA")
    public void test7(int number, int expected) {
    	System.out.println("number : " + String.valueOf(number) + " , expected : " + String.valueOf(expected)) ; 
    	assertEquals(number + 10, expected);
    }
    
    @Test(dataProvider = "provideNumbersInIterator3", groups="groupB")
    public void test8(int number, int expected) {
    	System.out.println("number : " + String.valueOf(number) + " , expected : " + String.valueOf(expected)) ; 
    	assertEquals(number + 10, expected);
    }
    
    @Test(dataProvider = "provideNumbersInIterator3", groups="groupB")
    public void test9(int number, int expected) {
    	System.out.println("number : " + String.valueOf(number) + " , expected : " + String.valueOf(expected)) ; 
    	assertEquals(number + 10, expected);
    }
    
    @DataProvider(name = "provideNumbersInIterator3")
    public Iterator<Object[]> provideDataInIterator3(ITestContext  context) {
    	Collection<Object[]> provider = new ArrayList<Object[]>();
    	
    	for(int i = 0 ; i < context.getIncludedGroups().length; i++) {
    		System.out.println(context.getIncludedGroups()[i]) ;
    	}
    	
    	for(int i = 0 ; i < context.getAllTestMethods().length; i++) {
    		System.out.println(context.getAllTestMethods()[i].getMethodName()) ;
    	}
    	
    	for(String attribute : context.getAttributeNames()) {
    		System.out.println(context.getAttribute(attribute));
    	}
    	
    	System.out.println(context.getName()) ;
    	
    	return provider.iterator() ;
    }    
}
