import junit.framework.TestCase;
import proj2.Sequence;
import org.junit.*;
import static org.junit.Assert.*;
/**
 * JUnit tests for sequence
 */
public class JUnitSequenceTest extends TestCase {
	
	/**
	 * makes a sequence with strings from a given array of strings 
	 * @param sList is an array of strings to be stored in the sequence 
	 * @param index is desired pointer position
	 * @return the sequence
	 */
	private Sequence makeSequence(String[] sList, int index) {
		Sequence s = new Sequence();
		for(int i = 0; i<sList.length; i++) {
			s.addAfter(sList[i]);
		}
		s.start();
		for(int i=0; i<index; i++) {
			s.advance();
		}
		return s;
	}
	
	/**
	 * makes a sequence with strings from a given array of strings  
	 * with a non default capacity
	 * @param sList is an array of strings to be stored in the sequence 
	 * @param index is desired pointer position
	 * @param cap is the desired capacity of the sequence
	 * @return the sequence
	 */
	private Sequence makeSequenceWithCapacity(String[] sList, int index, int cap) {
		Sequence s = new Sequence(cap);
		for(int i = 0; i<sList.length; i++) {
			s.addAfter(sList[i]);
		}
		s.start();
		for(int i=0; i<index; i++) {
			s.advance();
		}
		return s;
	}
	
	
	//@test tests construction of the sequence and the to string of sequence
	public void testConstruction() {
		String [] list = {"A", "B", "C"};
		Sequence seq = makeSequence( list , 0);
		assertEquals("{>A, B, C} (capacity = 10)", seq.toString());
		Sequence seq2 = makeSequenceWithCapacity( list, 0, 5);
		assertEquals("{>A, B, C} (capacity = 5)", seq2.toString());
		String [] list2 = {};
		Sequence seq3 = makeSequence( list2 , 0);
		assertEquals("{} (capacity = 10)", seq3.toString());
		Sequence seq4 = makeSequenceWithCapacity( list2, 0, 5);
		assertEquals("{} (capacity = 5)", seq4.toString());
		String [] list3 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
		Sequence seq5 = makeSequence( list3 , 0);
		assertEquals("{>A, B, C, D, E, F, G, H, I, J} (capacity = 10)", seq5.toString());
	}
	
	//@test tests addBefore method
	public void testAddBefore() {
		String [] list = {};
		Sequence seq = makeSequenceWithCapacity( list , 0, 4);
		seq.addBefore("D");
		assertEquals("{>D} (capacity = 4)", seq.toString());
		seq.addBefore("C");
		assertEquals("{>C, D} (capacity = 4)", seq.toString());
		seq.addBefore("B");
		assertEquals("{>B, C, D} (capacity = 4)", seq.toString());
		seq.addBefore("A");
		assertEquals("{>A, B, C, D} (capacity = 4)", seq.toString());
		seq.addBefore("Z");
		assertEquals("{>Z, A, B, C, D} (capacity = 9)", seq.toString());
	}
	
	//@test tests addAfter method
	public void testAddAfter() {
		String [] list = {};
		Sequence seq = makeSequenceWithCapacity( list , 0, 4);
		seq.addAfter("A");
		assertEquals("{>A} (capacity = 4)", seq.toString());
		seq.addAfter("B");
		assertEquals("{A, >B} (capacity = 4)", seq.toString());
		seq.addAfter("C");
		assertEquals("{A, B, >C} (capacity = 4)", seq.toString());
		seq.addAfter("D");
		assertEquals("{A, B, C, >D} (capacity = 4)", seq.toString());
		seq.addAfter("E");
		assertEquals("{A, B, C, D, >E} (capacity = 9)", seq.toString());
	}
	
	//@test tests isCurrent
	public void testIsCurrent() {
		String [] list = {"A", "B", "C"};
		Sequence seq = makeSequence( list , 0);
		assertEquals(true, seq.isCurrent());
		for(int i = 0; i<3; i++) {
			seq.advance();
		}
		assertEquals(false, seq.isCurrent());		
	}
	
	//@test tests getCapacity
	public void testGetCapacity() {
		String [] list = {"A", "B", "C"};
		Sequence seq = makeSequence( list , 0);
		assertEquals(10, seq.getCapacity());
	}
	
	//@test tests getCurrent
	public void testGetCurrent() {
		String [] list = {"A", "B", "C"};
		Sequence seq = makeSequence( list , 0);
		assertEquals("A", seq.getCurrent());
		seq.advance();
		assertEquals("B", seq.getCurrent());
		seq.advance();
		assertEquals("C", seq.getCurrent());
		seq.advance();
		assertEquals(null, seq.getCurrent());
	}
	
	//@test tests ensureCapacity
	public void testEnsuresCapacity() {
		String [] list = {"A", "B", "C"};
		Sequence seq = makeSequence( list , 0);
		seq.ensureCapacity(11);
		assertEquals(11, seq.getCapacity());
		seq.ensureCapacity(9);
		assertEquals(11, seq.getCapacity());
		assertEquals("{>A, B, C} (capacity = 11)", seq.toString());
	}
	
	//@test tests addAll
	public void testAddAll() {
		String [] listE = {};
		Sequence seqE1 = makeSequence( listE, 0);
		Sequence seqE2 = makeSequence( listE, 0);
		seqE1.addAll(seqE2);
		assertEquals("{} (capacity = 10)", seqE1.toString());
		assertEquals(0, seqE1.size());
		String [] list = {"A", "B", "C"};
		Sequence seq = makeSequence( list , 0);
		seq.addAll(seqE1);
		assertEquals("{>A, B, C} (capacity = 10)", seq.toString());
		assertEquals(3, seq.size());
		seqE1.addAll(seq);
		assertEquals("{>A, B, C} (capacity = 10)", seq.toString());
		String [] list2 = {"A", "B"};
		Sequence seq2 = makeSequence( list2 , 0);
		seq.addAll(seq2);
		assertEquals("{>A, B, C, A, B} (capacity = 10)", seq.toString());
		assertEquals(5, seq.size());
		Sequence seq3 = makeSequenceWithCapacity(list, 0, 3);
		seq3.addAll(seq2);
		assertEquals("{>A, B, C, A, B} (capacity = 5)", seq3.toString());
	}
	
	//@test test clone
	public void testClone() {
		String [] list = {"A", "B", "C"};
		Sequence seq = makeSequence( list , 0);
		Sequence seqClone = seq.clone();
		assertEquals(seq.toString(), seqClone.toString());
		seqClone.removeCurrent();
		assertEquals("{>A, B, C} (capacity = 10)", seq.toString());
		seq.removeCurrent();
		seq.removeCurrent();
		assertEquals("{>B, C} (capacity = 10)", seqClone.toString());
	}
	
	//@test test removeCurrent
	public void testRemoveCurrent() {
		String [] list = {};
		Sequence seq = makeSequence(list , 0);
		seq.removeCurrent();
		assertEquals("{} (capacity = 10)", seq.toString());
		String [] list2 = {"A", "B", "C"};
		Sequence seq2 = makeSequence(list2, 3);
		seq2.removeCurrent();
		assertEquals("{A, B, C} (capacity = 10)", seq2.toString());
		seq2.addAfter("D");
		seq2.start();
		seq2.removeCurrent();
		assertEquals("{>B, C, D} (capacity = 10)", seq2.toString());
		seq2.advance();
		seq2.removeCurrent();
		assertEquals("{B, >D} (capacity = 10)", seq2.toString());
		seq2.removeCurrent();
		assertEquals("{B} (capacity = 10)", seq2.toString());
	}
	
	//@test test trimToSize
	public void testTrimToSize() {
		String [] list = {"A", "B", "C"};
		Sequence seq = makeSequence(list , 0);
		seq.trimToSize();
		assertEquals("{>A, B, C} (capacity = 3)", seq.toString());
		seq.trimToSize();
		assertEquals("{>A, B, C} (capacity = 3)", seq.toString());
		String [] listE = {};
		Sequence seqE = makeSequence(listE, 0);
		seqE.trimToSize();
		assertEquals("{} (capacity = 0)", seqE.toString());
	}
	
	//@test test equals
	public void testEquals() {
		String [] list = {"A", "B", "C"};
		Sequence seq = makeSequence(list , 0);
		Sequence seq2 = makeSequenceWithCapacity(list , 0, 4);
		assertEquals(true, seq.getCapacity()!=seq2.getCapacity());
		assertEquals(true, seq.equals(seq2));
		assertEquals(true, seq2.equals(seq));
		String [] listE = {};
		Sequence seqE1 = makeSequence( listE, 0);
		Sequence seqE2 = makeSequence( listE, 0);
		assertEquals(true, seqE1.equals(seqE2));
		assertEquals(false, seq.equals(seqE2));
		assertEquals(true, seq.equals(seq));
		seq2.advance();
		assertEquals(false, seq.equals(seq2));	
		seq.advance();
		seq.advance();
		seq.advance();
		seq2.advance();
		seq2.advance();
		assertEquals(true, seq.equals(seq2));
	}
	
	//@test test isEmpty
	public void testIsEmpty() {
		String [] list = {"A", "B", "C"};
		Sequence seq = makeSequence(list , 0);
		assertEquals(false, seq.isEmpty());
		String [] listE = {};
		Sequence seqE = makeSequence(listE, 0);
		assertEquals(true, seqE.isEmpty());
	}
	
	//@test clear
	public void testClear() {
		String [] list = {"A", "B", "C"};
		Sequence seq = makeSequence(list , 0);
		seq.clear();
		assertEquals(true, seq.isEmpty());
		assertEquals(false, seq.isCurrent());
	}
	
}
