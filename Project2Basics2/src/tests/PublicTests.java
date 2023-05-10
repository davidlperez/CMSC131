package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import programs.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PublicTests {
	private static String INPUT_FOLDER = "inputs/";
	private static String INPUT_FILE_NAME_EXT = "Input.txt";

	@Test
	public void pub1Convert1() throws Exception, Throwable {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		/* Redirecting standard input and output */
		TestingSupport.redirectStandardInputToFile(INPUT_FOLDER + testName + INPUT_FILE_NAME_EXT);
		ByteArrayOutputStream newOutput = TestingSupport.redirectStandardOutputToByteArrayStream();

		/* Running program */
		Convert.main(null);

		/* Restoring standard input and output */
		TestingSupport.restoreStandardIO();

		/* Verifying results */
		assertTrue(TestingSupport.isResultCorrect(testName, newOutput.toString(), true));
	}

	@Test
	public void pub2Convert2() throws Exception, Throwable {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		/* Redirecting standard input and output */
		TestingSupport.redirectStandardInputToFile(INPUT_FOLDER + testName + INPUT_FILE_NAME_EXT);
		ByteArrayOutputStream newOutput = TestingSupport.redirectStandardOutputToByteArrayStream();

		/* Running program */
		Convert.main(null);

		/* Restoring standard input and output */
		TestingSupport.restoreStandardIO();

		/* Verifying results */
		assertTrue(TestingSupport.isResultCorrect(testName, newOutput.toString(), true));
	}

	@Test
	public void pub3ThrowDie1() throws Exception, Throwable {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		/* Redirecting standard input and output */
		TestingSupport.redirectStandardInputToFile(INPUT_FOLDER + testName + INPUT_FILE_NAME_EXT);
		ByteArrayOutputStream newOutput = TestingSupport.redirectStandardOutputToByteArrayStream();

		/* Running program */
		ThrowDie.main(null);

		/* Restoring standard input and output */
		TestingSupport.restoreStandardIO();

		/* Verifying results */
		assertTrue(TestingSupport.isResultCorrect(testName, newOutput.toString(), true));
	}

	@Test
	public void pub4Access1() throws Exception, Throwable {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		/* Redirecting standard input and output */
		TestingSupport.redirectStandardInputToFile(INPUT_FOLDER + testName + INPUT_FILE_NAME_EXT);
		ByteArrayOutputStream newOutput = TestingSupport.redirectStandardOutputToByteArrayStream();

		/* Running program */
		Access.main(null);

		/* Restoring standard input and output */
		TestingSupport.restoreStandardIO();

		/* Verifying results */
		assertTrue(TestingSupport.isResultCorrect(testName, newOutput.toString(), true));
	}

	@Test
	public void pub5Access2() throws Exception, Throwable {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		/* Redirecting standard input and output */
		TestingSupport.redirectStandardInputToFile(INPUT_FOLDER + testName + INPUT_FILE_NAME_EXT);
		ByteArrayOutputStream newOutput = TestingSupport.redirectStandardOutputToByteArrayStream();

		/* Running program */
		Access.main(null);

		/* Restoring standard input and output */
		TestingSupport.restoreStandardIO();

		/* Verifying results */
		assertTrue(TestingSupport.isResultCorrect(testName, newOutput.toString(), true));
	}

	@Test
	public void pub6Access3() throws Exception, Throwable {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		/* Redirecting standard input and output */
		TestingSupport.redirectStandardInputToFile(INPUT_FOLDER + testName + INPUT_FILE_NAME_EXT);
		ByteArrayOutputStream newOutput = TestingSupport.redirectStandardOutputToByteArrayStream();

		/* Running program */
		Access.main(null);

		/* Restoring standard input and output */
		TestingSupport.restoreStandardIO();

		/* Verifying results */
		assertTrue(TestingSupport.isResultCorrect(testName, newOutput.toString(), true));
	}
}