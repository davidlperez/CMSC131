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
	public void pub1Area() throws Exception, Throwable {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		/* Redirecting standard input and output */
		TestingSupport.redirectStandardInputToFile(INPUT_FOLDER + testName + INPUT_FILE_NAME_EXT);
		ByteArrayOutputStream newOutput = TestingSupport.redirectStandardOutputToByteArrayStream();

		/* Running program */
		Area.main(null);

		/* Restoring standard input and output */
		TestingSupport.restoreStandardIO();

		/* Verifying results */
		assertTrue(TestingSupport.isResultCorrect(testName, newOutput.toString(), true));
	}

	@Test
	public void pub2Divisible() throws Exception, Throwable {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		/* Redirecting standard input and output */
		TestingSupport.redirectStandardInputToFile(INPUT_FOLDER + testName + INPUT_FILE_NAME_EXT);
		ByteArrayOutputStream newOutput = TestingSupport.redirectStandardOutputToByteArrayStream();

		/* Running program */
		Divisible.main(null);

		/* Restoring standard input and output */
		TestingSupport.restoreStandardIO();

		/* Verifying results */
		assertTrue(TestingSupport.isResultCorrect(testName, newOutput.toString(), true));
	}

	@Test
	public void pub3ColorGenerator1() throws Exception, Throwable {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		/* Redirecting standard input and output */
		TestingSupport.redirectStandardInputToFile(INPUT_FOLDER + testName + INPUT_FILE_NAME_EXT);
		ByteArrayOutputStream newOutput = TestingSupport.redirectStandardOutputToByteArrayStream();

		/* Running program */
		ColorGenerator.main(null);

		/* Restoring standard input and output */
		TestingSupport.restoreStandardIO();

		/* Verifying results */
		assertTrue(TestingSupport.isResultCorrect(testName, newOutput.toString(), true));
	}

	@Test
	public void pub4ColorGenerator2() throws Exception, Throwable {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		/* Redirecting standard input and output */
		TestingSupport.redirectStandardInputToFile(INPUT_FOLDER + testName + INPUT_FILE_NAME_EXT);
		ByteArrayOutputStream newOutput = TestingSupport.redirectStandardOutputToByteArrayStream();

		/* Running program */
		ColorGenerator.main(null);

		/* Restoring standard input and output */
		TestingSupport.restoreStandardIO();

		/* Verifying results */
		assertTrue(TestingSupport.isResultCorrect(testName, newOutput.toString(), true));
	}
}