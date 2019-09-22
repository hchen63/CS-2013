import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class test {

	@Test
	public void test() {
		String inString = "abc";
		String strList = "dog god";
		anagramize a = new anagramize();
		a.anagramize(inString, strList);
	}
	
//	@Test
	public void testNon() {
		String strList = "dog dgo odg ogd gdo god";
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("life");
		list.add("fire");
		anagramize a = new anagramize();
		a.nonReFilter(strList);
	}

}
