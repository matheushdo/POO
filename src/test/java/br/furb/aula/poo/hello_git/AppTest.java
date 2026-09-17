package br.furb.aula.poo.hello_git;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class AppTest {

	@Test
	void test() {
		PrintStream originalOut = System.out;
	    ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(bos));

	    // action
	    App.main(null);

	    // assertion
	    assertEquals("hello git!\n", bos.toString().toLowerCase(), "A mensagem apresentada esta incorreta");

	    // undo the binding in System
	    System.setOut(originalOut);
	}

}
