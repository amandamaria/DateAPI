package imd0412.DateAPI;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AppTest 
{	
	private Integer day;
	private Integer month;
	private Integer year;
	private String expectedResult;
	
    @SuppressWarnings("rawtypes")
	@Parameterized.Parameters
    public static Collection dates() {
       return Arrays.asList(new Object[][] {
    	  //Testes arestas
         { 21, 10, 1990, "22/10/1990"},//Condição 'day >= 1 && day <= 27' - linha 60
         { 31, 10, 1990, "1/11/1990"},//Condição 'has31(month) && month != DECEMBER && day == 31' - linha 63
         { 31, 12, 1990, "1/1/1991"},//Condição 'month == DECEMBER && day == 31' - linha 67
         
         //Testes eclemma
         {30, 01, 1990, "31/1/1990"},//Condição 'has31(month) && day < 31' - linha 60
         {29, 06, 1990, "30/6/1990"},//Condição 'has30(month) && day < 30' - linha 60
         {30, 06, 1990, "1/7/1990"},//Condição 'has30(month) && day < 30' - linha 60
         {28, 02, 2016, "29/2/2016"},//Condição 'isFebruary(month) && isLeapYear(year) && day == 28' - linha 61
         {28, 02, 2000, "29/2/2000"},//Condição 'year % 400 == 0' do método isLeapYear - linha 44
         {28, 02, 2005, "1/3/2005"},//Condição 'year % 4 != 0' do método isLeapYear - linha 42
         {28, 02, 1900, "1/3/1900"},//Condição 'year % 100 == 0' do método isLeapYear - linha 46
         {28, 12, 1900, "29/12/1900"},//Condição 'month == DECEMBER' do método has31 - linha 46
      });
    }
	
	public AppTest(int day, int month, int year, String expectedResult) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.expectedResult = expectedResult;		
	}
	
	
    @Test
	public void testDateUtil()
    {
    	assertEquals(expectedResult, DateUtil.nextDate(day, month, year));
    }
}
