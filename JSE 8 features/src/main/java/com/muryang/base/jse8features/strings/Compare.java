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

package com.muryang.base.jse8features.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ethan Cha on 22/03/2015.
 */
public class Compare {
    private static final List<Person> people = Arrays.asList(
        new Person("John", 20),
        new Person("Sara", 21),
        new Person("Jane", 22),
        new Person("Greg", 30)
    ) ;

    private static Comparator<Person> compareAgeAscending = (person1, person2) -> person1.ageDifference(person2) ;
    private static Comparator<Person> compareAgeDescending = compareAgeAscending.reversed() ;

    private static Comparator<Person> compareNameAscending = (person1, person2) -> person1.getName().compareTo(person2.getName()) ;
    private static Comparator<Person> compareNameDescending = compareNameAscending.reversed() ;

    public static void main(String[] args) {
        List<Person> ascendingAge = people.stream().sorted((person1, person2) -> person1.ageDifference(person2)).collect(Collectors.toList()) ;
        printPeople(ascendingAge) ;

        System.out.println("") ;
        List<Person> ascendingAge2 = people.stream().sorted(compareAgeAscending).collect(Collectors.toList()) ;
        printPeople(ascendingAge) ;

        System.out.println("") ;
        List<Person> descendingAge = people.stream().sorted(compareAgeDescending).collect(Collectors.toList()) ;
        printPeople(descendingAge) ;

        System.out.println("") ;
        List<Person> ascendingName = people.stream().sorted(compareNameAscending).collect(Collectors.toList()) ;
        printPeople(ascendingName) ;

        System.out.println("") ;
        List<Person> descendingName = people.stream().sorted(compareNameDescending).collect(Collectors.toList()) ;
        printPeople(descendingName) ;

        people.stream().min(Person::ageDifference).ifPresent(youngest -> System.out.println("Youngest :" + youngest));
        people.stream().max(Person::ageDifference).ifPresent(oldest -> System.out.println("Oldest :" + oldest));
    }

    public static void printPeople(List<Person> people) {
        people.stream().forEach(person -> System.out.println(person.toString()));
    }
}
