package my.test.opteate;

import java.util.BitSet;

public class BitSetTest {

	
	public static void main(String[] args) {
		BitSet bs = new BitSet(63);
		System.out.println("bs size:"+bs.size());
		
		bs.set(1);
		bs.set(3,true);
		bs.set(4,true);
		bs.set(65,true);
		bs.clear(4);
		
		System.out.println(bs);
		System.out.println("bs size:"+bs.size());
		System.out.println("bs get index 1:"+bs.get(1));
	}
}
