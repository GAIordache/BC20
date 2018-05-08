package bignumbers;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigIntTest {

	public static void main(String[] args) {
		BigInteger bi3 = new BigInteger("26731");
		 
        BigInteger putere = bi3.pow(500);
        System.out.println(putere);
        
        BigDecimal bd = new BigDecimal("3.14");
        bd.setScale(2);
        bd = bd.multiply(new BigDecimal("2.345678"));
        System.out.println(bd);
	}

}
