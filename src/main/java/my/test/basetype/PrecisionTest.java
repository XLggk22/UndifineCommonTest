package my.test.basetype;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * 精度测试
 * @author rbh011
 *
 */
public class PrecisionTest {
	
	/**
	 * 精度测试
	 */
	@Test
	public void testPrecision(){
		long a = 50;
		long c = 0; 
		long b = 90;
		Double rate = (double)a/(double)b; 
		Double rate2 = (double)c/(double)b; 
		
		System.out.println(rate);
		System.out.println(rate2);
		int compareTo = rate.compareTo(rate2);
		System.out.println(rate>rate2);
		System.out.println(compareTo);
		
	}
	
	/**
	 * 精度测试
	 */
	@Test
	public void testPrecision2(){
		BigDecimal a = new BigDecimal("1.1");
		BigDecimal b = new BigDecimal("2.2");
		System.out.println("BigDecimal类型计算结果:"+a.add(b));
		
		double c = 1.1;
		double d = 2.2;
		System.out.println("double类型计算结果:"+ (d + c));
	}

}
