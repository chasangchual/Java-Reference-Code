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

package com.muryang.xml.parser.demo.dom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.muryang.xml.parser.demo.Employee;
import com.muryang.xml.parser.demo.Parser;

public class DOMParserDemo implements Parser{

	public void print(String xmlPath) {
		
		DocumentBuilderFactory facotry = DocumentBuilderFactory.newInstance() ;
		DocumentBuilder builder;
		try {
			builder = facotry.newDocumentBuilder();
			Document document = builder.parse(ClassLoader.getSystemResourceAsStream(xmlPath)) ;
			NodeList nodeList = document.getDocumentElement().getChildNodes() ;
			
			for(int i = 0 ; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i) ;
				if(node instanceof Element) {
					String id = node.getAttributes().getNamedItem("id").getNodeValue() ;
					Employee employee = new Employee(id) ; 
					
					NodeList fields = node.getChildNodes() ;
					for(int j = 0 ; j < fields.getLength(); j++) {
						Node field = fields.item(j) ;
						if(field instanceof Element) {
							String name = field.getNodeName() ;
							switch(name.toUpperCase()) {
							case "FIRSTNAME" :
								employee.setFirstName(field.getLastChild().getTextContent().trim());
								break ;
							case "LASTNAME" :
								employee.setLastName(field.getLastChild().getTextContent().trim());
								break ;
							case "LOCATION" :
								employee.setLocation(field.getLastChild().getTextContent().trim());
								break ;
							}
						}
					}
					
					// System.out.println(employee.toString());
				}
			}
		} catch (ParserConfigurationException e) {
		} catch (SAXException e) {
		} catch (IOException e) {
		}
		
	}
	

	public void print(InputStream inStream) {
		
		DocumentBuilderFactory facotry = DocumentBuilderFactory.newInstance() ;
		DocumentBuilder builder;
		try {
			builder = facotry.newDocumentBuilder();
			Document document = builder.parse(inStream) ;
			NodeList nodeList = document.getDocumentElement().getChildNodes() ;
			
			for(int i = 0 ; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i) ;
				if(node instanceof Element) {
					String id = node.getAttributes().getNamedItem("id").getNodeValue() ;
					Employee employee = new Employee(id) ; 
					
					NodeList fields = node.getChildNodes() ;
					for(int j = 0 ; j < fields.getLength(); j++) {
						Node field = fields.item(j) ;
						if(field instanceof Element) {
							String name = field.getNodeName() ;
							switch(name.toUpperCase()) {
							case "FIRSTNAME" :
								employee.setFirstName(field.getLastChild().getTextContent().trim());
								break ;
							case "LASTNAME" :
								employee.setLastName(field.getLastChild().getTextContent().trim());
								break ;
							case "LOCATION" :
								employee.setLocation(field.getLastChild().getTextContent().trim());
								break ;
							}
						}
					}
					
					// System.out.println(employee.toString());
				}
			}
		} catch (ParserConfigurationException e) {
		} catch (SAXException e) {
		} catch (IOException e) {
		}
		
	}	
	
	public static void main(String[] args) throws FileNotFoundException {
		DOMParserDemo domParser = new DOMParserDemo() ;
		List<Double> results = new ArrayList<Double>() ;
		File file = new File("c:/temp/example.xml") ;		
		for(int runs = 0 ; runs < 10; runs ++) {
			Long now = System.currentTimeMillis() ;
			
			for(int i = 0 ; i < 100; i++) {
				domParser.print(new FileInputStream(file));
			}
			
			results.add((System.currentTimeMillis() - now) / 100.0) ;
		}
		
		for(Double value: results) {
			System.out.println(value);
		}		
	}		
}
