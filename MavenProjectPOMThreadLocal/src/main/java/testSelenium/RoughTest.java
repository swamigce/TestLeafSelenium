package testSelenium;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RoughTest {

	public static void main(String[] args) {
		

System.out.println(System.currentTimeMillis());
String s = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now());
System.out.println(s);

	}

}
