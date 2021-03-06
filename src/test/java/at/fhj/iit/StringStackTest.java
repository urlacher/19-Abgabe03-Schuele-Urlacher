package at.fhj.iit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringStackTest
{
    public Stack s;
    
    @Before
    public void setup() throws Exception
    {
        s = new StringStack(5); // keep size of 5 !!
    }
    
    /**
     * tests if stack is empty after initialization
     * 
     * use assert
     * - assertTrue to check it's empty
     */
    @Test
    public void testIsEmpty() throws Exception
    {
        assertTrue(s.isEmpty());
    }
    
    /**
     * tests if stack is empty after pushing
     * 
     * use assert
     * - assertFalse to check it's not empty
     */
    @Test
    public void testIsNotEmpty() throws Exception
    {
        s.push("TestString");
        assertFalse(s.isEmpty());
    }

    /**
     * tests push and pop function
     * 
     * do following test
     * - use push, 1 or x times
     * - use pull, as often as you use push
     * - use isEmpty to check that's empty again
     * - assert every content of the stack in the correct ordering
     * @throws Exception 
     */
    @Test
    public void testPushPop() throws Exception
    {
        s.push("String1");
        s.push("String2");
        assertEquals(s.pop(),"String2");
        assertEquals(s.pop(),"String1");
        assertTrue(s.isEmpty());
    }

    /**
     * Feel Free to insert other test cases for the String Stack Implementation !!!
     */


    /**
     * test pushing until maximum size is exceeded
     */
    @Test (expected = IllegalStateException.class)
    public void testMaxSize() throws Exception{
        s.push("Test1");
        s.push("Test2");
        s.push("Test3");
        s.push("Test4");
        s.push("Test5");
        s.push("Test6");
    }

    /**
     * test pop until min size is exceeded
     */
    @Test (expected = IllegalStateException.class)
    public void testMinSize() throws Exception{
        s.pop();
    }

    /**
     * test initial size for new stack -1
     */
    @Test (expected = IllegalArgumentException.class)
    public void testNegativeStackSize() throws Exception{
        StringStack s2 = new StringStack(-1);
        StringStack s3 = new StringStack(Integer.MIN_VALUE);
    }

    /**
     *  test push new String null
     */
    @Test
    public void testStringNull() throws Exception{
        s.push(null);
        assertNull(s.pop());
        assertTrue(s.isEmpty());
    }

}
