package put.io.testing.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FailureorErrorTest {
    @Test
    public void test1() {
         assertEquals(0,1);
    }
    @Test
    public void test2() {
        throw new IndexOutOfBoundsException("Exception message");
    }
    @Test
    public void test3() {
        try {
            throw new IndexOutOfBoundsException("Exception message"); //?
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}