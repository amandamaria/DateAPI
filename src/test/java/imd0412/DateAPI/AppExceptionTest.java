package imd0412.DateAPI;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
@SuppressWarnings("rawtypes")
public class AppExceptionTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private Integer day;
	private Integer month;
	private Integer year;
	private Class exceptionExpected;
	
	@Parameterized.Parameters
    public static Collection dates() {
       return Arrays.asList(new Object[][] {
    	   //Testes arestas
    	   {0, 10, 1990, IllegalArgumentException.class},//Condição 'day < 1' - linha 54      
//    	   {31, 11, 1990, IllegalStateException.class},//Nenhuma das condições 'else' - linha 70
    	   
    	   //Testes eclemma
//    	   {32, 12, 1990, IllegalArgumentException.class},//Condição 'day > 31' - linha 54
//    	   {28, 0, 1990, IllegalArgumentException.class},//Condição 'month < 1' - linha 54 
//    	   {28, 13, 1990, IllegalArgumentException.class},//Condição 'month > 12' - linha 54 	   
//    	   {28, 12, 1800, IllegalArgumentException.class},//Condição 'year < 1812' - linha 54
//    	   {28, 12, 2017, IllegalArgumentException.class},//Condição 'year > 2016' - linha 54
       });
    }
	
	public AppExceptionTest(int day, int month, int year, Class exceptionExpected) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.exceptionExpected = exceptionExpected;
	}
	
	
    @SuppressWarnings("unchecked")
	@Test
	public void testDateUtil() throws IllegalArgumentException, IllegalStateException
    {
    	thrown.expect(exceptionExpected);
    	DateUtil.nextDate(day, month, year);
    }
}
