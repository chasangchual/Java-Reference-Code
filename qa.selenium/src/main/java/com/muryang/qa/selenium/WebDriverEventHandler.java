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
 */ckage com.muryang.qa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * Created by Ethan Cha on 15/03/2015.
 */
public class WebDriverEventHandler implements WebDriverEventListener {
    /**
     * Called before {@link org.openqa.selenium.WebDriver#get get(String url)} respectively
     * {@link org.openqa.selenium.WebDriver.Navigation#to navigate().to(String url)}.
     *
     * @param url
     * @param driver
     */
    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("beforeNavigateTo fired !!" ) ;
        System.out.println(url) ;
        System.out.println(driver.getPageSource()) ;
    }

    /**
     * Called after {@link org.openqa.selenium.WebDriver#get get(String url)} respectively
     * {@link org.openqa.selenium.WebDriver.Navigation#to navigate().to(String url)}. Not called, if an
     * exception is thrown.
     *
     * @param url
     * @param driver
     */
    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("afterNavigateTo fired !!" ) ;
        System.out.println(url) ;
        System.out.println(driver.getPageSource()) ;
    }

    /**
     * Called before {@link org.openqa.selenium.WebDriver.Navigation#back navigate().back()}.
     *
     * @param driver
     */
    @Override
    public void beforeNavigateBack(WebDriver driver) {
        System.out.println("beforeNavigateBack fired !!" ) ;
        System.out.println(driver.getPageSource()) ;
    }

    /**
     * Called after {@link org.openqa.selenium.WebDriver.Navigation navigate().back()}. Not called, if an
     * exception is thrown.
     *
     * @param driver
     */
    @Override
    public void afterNavigateBack(WebDriver driver) {
        System.out.println("afterNavigateBack fired !!" ) ;
        System.out.println(driver.getPageSource()) ;
    }

    /**
     * Called before {@link org.openqa.selenium.WebDriver.Navigation#forward navigate().forward()}.
     *
     * @param driver
     */
    @Override
    public void beforeNavigateForward(WebDriver driver) {
        System.out.println("beforeNavigateForward fired !!" ) ;
        System.out.println(driver.getPageSource()) ;
    }

    /**
     * Called after {@link org.openqa.selenium.WebDriver.Navigation#forward navigate().forward()}. Not called,
     * if an exception is thrown.
     *
     * @param driver
     */
    @Override
    public void afterNavigateForward(WebDriver driver) {
        System.out.println("afterNavigateForward fired !!" ) ;
        System.out.println(driver.getPageSource()) ;
    }

    /**
     * Called before {@link org.openqa.selenium.WebDriver#findElement WebDriver.findElement(...)}, or
     * {@link org.openqa.selenium.WebDriver#findElements WebDriver.findElements(...)}, or {@link org.openqa.selenium.WebElement#findElement
     * WebElement.findElement(...)}, or {@link org.openqa.selenium.WebElement#findElement WebElement.findElements(...)}.
     *
     * @param by
     * @param element will be <code>null</code>, if a find method of <code>WebDriver</code> is called.
     * @param driver
     */
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("beforeFindBy fired !!" ) ;
        System.out.println(by.toString()) ;
        System.out.println(element.getTagName()) ;
        System.out.println(driver.getPageSource()) ;
    }

    /**
     * Called after {@link org.openqa.selenium.WebDriver#findElement WebDriver.findElement(...)}, or
     * {@link org.openqa.selenium.WebDriver#findElements WebDriver.findElements(...)}, or {@link org.openqa.selenium.WebElement#findElement
     * WebElement.findElement(...)}, or {@link org.openqa.selenium.WebElement#findElement WebElement.findElements(...)}.
     *
     * @param by
     * @param element will be <code>null</code>, if a find method of <code>WebDriver</code> is called.
     * @param driver
     */
    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("afterFindBy fired !!" ) ;
        System.out.println(by.toString()) ;
        System.out.println(element.getTagName()) ;
        System.out.println(driver.getPageSource()) ;
    }

    /**
     * Called before {@link org.openqa.selenium.WebElement#click WebElement.click()}.
     *
     * @param element
     * @param driver
     */
    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("beforeClickOn fired !!" ) ;
        System.out.println(element.getTagName()) ;
        System.out.println(driver.getPageSource()) ;
    }

    /**
     * Called after {@link org.openqa.selenium.WebElement#click WebElement.click()}. Not called, if an exception is
     * thrown.
     *
     * @param element
     * @param driver
     */
    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("afterClickOn fired !!" ) ;
        System.out.println(element.getTagName()) ;
        System.out.println(driver.getPageSource()) ;
    }

    /**
     * Called before {@link org.openqa.selenium.WebElement#clear WebElement.clear()}, {@link org.openqa.selenium.WebElement#sendKeys
     * WebElement.sendKeys(...)}.
     *
     * @param element
     * @param driver
     */
    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver) {
        System.out.println("beforeChangeValueOf fired !!" ) ;
        System.out.println(element.getTagName()) ;
        System.out.println(driver.getPageSource()) ;
    }

    /**
     * Called after {@link org.openqa.selenium.WebElement#clear WebElement.clear()}, {@link org.openqa.selenium.WebElement#sendKeys
     * WebElement.sendKeys(...)}}. Not called, if an exception is thrown.
     *
     * @param element
     * @param driver
     */
    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver) {
        System.out.println("afterChangeValueOf fired !!" ) ;
        System.out.println(element.getTagName()) ;
        System.out.println(driver.getPageSource()) ;
    }

    /**
     * Called before {@link org.openqa.selenium.remote.RemoteWebDriver#executeScript(String, Object[]) }
     *
     * @param script
     * @param driver
     */
    @Override
    public void beforeScript(String script, WebDriver driver) {
        System.out.println("beforeScript fired !!" ) ;
        System.out.println(script) ;
        System.out.println(driver.getPageSource()) ;
    }

    /**
     * Called after {@link org.openqa.selenium.remote.RemoteWebDriver#executeScript(String, Object[]) }. Not called if an exception is thrown
     *
     * @param script
     * @param driver
     */
    @Override
    public void afterScript(String script, WebDriver driver) {
        System.out.println("afterScript fired !!" ) ;
        System.out.println(script) ;
        System.out.println(driver.getPageSource()) ;
    }

    /**
     * Called whenever an exception would be thrown.
     *
     * @param throwable
     * @param driver
     */
    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        System.out.println("onException fired !!" ) ;
        System.out.println(throwable.getMessage()) ;
        System.out.println(driver.getPageSource()) ;
    }
}
