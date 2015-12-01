package com.pointclickcare.automation.lib.listener;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq ;

import static org.powermock.api.mockito.PowerMockito.mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.pointclickcare.automation.lib.utils.connector.TestRailConnector;
import com.pointclickcare.automation.lib.utils.testrun.TestRunUtils;
import com.pointclickcare.automation.lib.constants.TestParameterConstants;
import com.pointclickcare.automation.lib.enums.TestResultStatusEnum;
import com.pointclickcare.automation.lib.listener.TestRailListener;
import com.pointclickcare.automation.lib.models.testresult.TestScenarioResult;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.UnreachableBrowserException;

import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.internal.TestResult;
import org.testng.xml.XmlTest;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ TestRailConnector.class, TestRunUtils.class, TestResultCapture.class })
public class TestRailListenerBlitzTest {
	
	ITestNGMethod method ;
	TestScenarioResult tsr ; 
	TestRailConnector connector ; 
	
	@Before
	public void setup() throws Exception {
		PowerMockito.mockStatic(TestRailConnector.class) ;
		PowerMockito.mockStatic(TestRunUtils.class) ;
		PowerMockito.mockStatic(TestResultCapture.class) ;
		connector = mock(TestRailConnector.class) ;
		
		//////////////////////////////////////////////////////////////////////////
		// construct mocks
		//////////////////////////////////////////////////////////////////////////
		method = mock(ITestNGMethod.class) ;
		tsr = mock(TestScenarioResult.class) ;
		
		//////////////////////////////////////////////////////////////////////////
		// initiate mock object behavior
		//////////////////////////////////////////////////////////////////////////
		// TestResultCapture
		PowerMockito.when(TestResultCapture.class, "createScenarioResult", any(ITestResult.class), eq(TestResultStatusEnum.FAILED)).thenReturn(tsr) ;
		// TestRunUtils
		PowerMockito.doNothing().when(TestRunUtils.class, "takeFailureScreenShot", any(ITestResult.class)) ;
		// TestRailConnector
		doNothing().when(connector).registerResponse(any(com.pointclickcare.automation.lib.models.testresult.TestResult.class), any(TestScenarioResult.class)) ;
		PowerMockito.when(TestRailConnector.getConnector()).thenReturn(connector) ;
	}
	

	@Test
	public void testOnTestSkipped()
	{
		TestRailListener trl = spy(new TestRailListener()) ;
		TestResult tr = mock(TestResult.class);
		IClass clazz = mock(IClass.class) ; 
		
		try {
			when(tr.getTestClass()).thenReturn(clazz) ;
			when(tr.getThrowable()).thenReturn(null) ;
			
			doNothing().when(trl).onTestResult(eq(TestResultStatusEnum.SKIPPED), any(ITestResult.class)) ;
		} catch (Exception e) {
			// exception captured during test run verification
			Assert.assertTrue(e.getMessage(), false) ;
			e.printStackTrace();
		}
		
		trl.onTestSkipped(tr) ;

	}
	
	@Test
	public void testManageTestFailure()
	{
		TestRailListener trl = spy(new TestRailListener()) ;
		TestResult tr = mock(TestResult.class);
		
		try {
			doNothing().when(trl).onTestResult(eq(TestResultStatusEnum.FAILED), any(ITestResult.class)) ;
		} catch (Exception e) {
			// exception captured during test run verification
			Assert.assertTrue(e.getMessage(), false) ;
			e.printStackTrace();
		}
	}

	@Test 
	public void testOnTestResultViaManageTestFailure()
	{
		// creates mock objects
		TestRailListener trl = spy(new TestRailListener()) ;
		TestResult tr = mock(TestResult.class);
		com.pointclickcare.automation.lib.models.testresult.TestResult result = spy(new com.pointclickcare.automation.lib.models.testresult.TestResult()) ;
		
		// mocking operators 
		
		try {
			when(tr.getThrowable()).thenReturn(new Throwable()) ;
			when(tr.getMethod()).thenReturn(method) ;
			
			when(result.getTmsTestId()).thenReturn("TEST_ID") ;
			when(result.getTmsTestRunId()).thenReturn("TEST_RUN_ID") ;
			
			PowerMockito.when(TestResultCapture.class, "createTestResult", any(ITestNGMethod.class)).thenReturn(result) ;
			PowerMockito.when(TestRunUtils.class, "modifyTestResultForReporting", any(result.getClass()), eq(true)).thenReturn(result) ;
			
		} catch (Exception e) { 
			// exception captured during executing PowerMockito operators
			Assert.assertTrue(e.getMessage(), false) ;
			e.printStackTrace();
		}

		trl.manageTestFailure(tr) ;
		
		try {
			verify(trl, times(1)).manageTestFailure(tr) ;
			verify(trl, never()).onTestSkipped(tr) ;
			
			verify(tr, never()).getTestContext();
			verify(connector, times(1)).registerResponse(any(com.pointclickcare.automation.lib.models.testresult.TestResult.class), any(TestScenarioResult.class)) ;
		} catch (Exception e) {
			// exception captured during test run verification
			Assert.assertTrue(e.getMessage(), false) ;
			e.printStackTrace();
		}
		
	}
	
	@Test 
	public void testOnTestResultViaManageTestFailureWithNullTMSId()
	{
		// creates mock objects
		TestRailListener trl = spy(new TestRailListener()) ;
		TestResult tr = mock(TestResult.class);
		
		
		com.pointclickcare.automation.lib.models.testresult.TestResult result = spy(new com.pointclickcare.automation.lib.models.testresult.TestResult()) ;
		XmlTest xmlTest = mock(XmlTest.class) ;
		ITestContext testContext = mock(ITestContext.class) ; 
		
		// mocking operators 
		
		try {
			when(tr.getThrowable()).thenReturn(new Throwable()) ;
			when(tr.getMethod()).thenReturn(method) ;
			
			when(result.getTmsTestId()).thenReturn(null) ;
			when(result.getTmsTestRunId()).thenReturn(null) ;
			
			when(testContext.getCurrentXmlTest()).thenReturn(xmlTest) ;
			
			when(xmlTest.getParameter(TestParameterConstants.TEST_RUN_ID)).thenReturn("UNIT_TEST_RUN_ID") ;
			when(xmlTest.getParameter(TestParameterConstants.TEST_ID)).thenReturn("UNIT_TEST_ID") ;
			
			when(tr.getTestContext()).thenReturn(testContext) ;
			
			PowerMockito.when(TestResultCapture.class, "createTestResult", any(ITestNGMethod.class)).thenReturn(result) ;
			PowerMockito.when(TestRunUtils.class, "modifyTestResultForReporting", any(result.getClass()), eq(true)).thenReturn(result) ;
			
		} catch (Exception e) { 
			// exception captured during executing PowerMockito operators
			Assert.assertTrue(e.getMessage(), false) ;
			e.printStackTrace();
		}

		trl.manageTestFailure(tr) ;
		
		try {
			verify(trl, times(1)).manageTestFailure(tr) ;
			verify(trl, never()).onTestSkipped(tr) ;
			
			verify(tr, times(1)).getTestContext();
			verify(connector, times(1)).registerResponse(any(com.pointclickcare.automation.lib.models.testresult.TestResult.class), any(TestScenarioResult.class)) ;
			
			verify(tr, times(1)).getTestContext();
		} catch (Exception e) {
			// exception captured during test run verification
			Assert.assertTrue(e.getMessage(), false) ;
			e.printStackTrace();
		}
	}

	@Test
	public void testOnTestFailureInvokeManageTestFailure()
	{
		TestRailListener trl = spy(new TestRailListener()) ;
		TestResult tr = spy(new TestResult());
		
		when(tr.getThrowable()).thenReturn(new Throwable()) ;
		
		doNothing().when(trl).manageTestFailure(tr) ;
		
		trl.onTestFailure(tr) ;
		
		verify(trl, never()).onTestSkipped(tr) ;
		verify(trl, times(1)).manageTestFailure(tr) ;
	}
	
	@Test
	public void testOnTestFailureSkippedDueToException()
	{
	    TestRailListener trl = spy(new TestRailListener());
	    TestResult tr = spy(new TestResult());

	    // We want to verify its called, but not actually do anything
	    doNothing().when(trl).onTestSkipped(tr);

	    Exception[] exceptions = new Exception[] {
	        new NullPointerException(),
	        new WebDriverException(),
	        new java.net.SocketException(),
	        new UnreachableBrowserException("test"),
	        new org.openqa.selenium.UnsupportedCommandException(),
	        new java.sql.SQLException()
	    };

	    for (Exception e : exceptions)
	    {
	      when(tr.getThrowable()).thenReturn(e);
	      trl.onTestFailure(tr) ;
	    }

	    verify(tr, times(exceptions.length)).setStatus(ITestResult.SKIP);
	    verify(trl, times(exceptions.length)).onTestSkipped(tr);
	}
	
	@Test
	public void testOnTestSuccess()
	{
		TestRailListener trl = spy(new TestRailListener()) ;
		TestResult tr = mock(TestResult.class);
		
		
	}
	
	@Test
	public void testOnConfigurationFailure()
	{
		TestRailListener trl = spy(new TestRailListener()) ;
		TestResult tr = mock(TestResult.class);
		
	}
	
	
}
