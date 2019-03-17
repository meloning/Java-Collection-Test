import VectorEx.MyVector;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

/*
TODO:
    기본용량 10
    최소저장공간확보하는 메소드
    add, get, remove
    trimToSize
    clear
    toArray
    isEmpty
    capacity
    size
    배열 복사를 통한 데이터 생성
*/

public class MyVectorTest {

    private MyVector myVector;

    @Before
    public void setup(){
        this.myVector = new MyVector(10);
    }

    @Test
    @Ignore
    public void testMyVectorDefaultValue10() throws Exception{
        MyVector myVector = new MyVector();
        assertThat(myVector.capacity(),is(10));
    }

    @Test
    @Ignore
    public void testMyVectorCustomCapacity() throws Exception{
        MyVector myVector = new MyVector(20);
        assertThat(myVector.capacity(),is(20));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMyVector음수Capacity() throws Exception{
         new MyVector(-1);
    }

    @Test
    public void testMyVectorEnsureCapacity() throws Exception{
        this.myVector.ensureCapacity(11);
        assertThat(this.myVector.capacity(),is(11));
    }

    @Test
    public void testMyVectorAdd() throws Exception{
        this.myVector.add(1);
        assertThat(this.myVector.get(0),is(1));
    }

    @Test
    public void testMyVectorAddInCapacity() throws Exception{
        this.myVector = new MyVector(1);
        this.myVector.add(100);
        this.myVector.add(1000);

        assertThat(this.myVector.get(0),is(100));
        assertThat(this.myVector.get(1),is(1000));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testMyVectorGetException() throws Exception{
        this.myVector.get(-1);
        this.myVector.get(1);
    }

    private void MyVectorValueSizeThree() throws Exception{
        this.myVector.add(100);
        this.myVector.add(1000);
        this.myVector.add("asdf");
    }

    @Test
    public void testMyVectorRemoveParamIndex() throws Exception{
        MyVectorValueSizeThree();

        this.myVector.remove(1);

        assertThat(this.myVector.size(),is(2));
        assertThat(this.myVector.get(1),is(not(1000)));
        assertThat(this.myVector.get(1),is("asdf"));
    }

    @Test
    public void testMyVectorRemoveParamData() throws Exception{
        MyVectorValueSizeThree();
        this.myVector.add(-140);

        this.myVector.remove("asdf");

        assertThat(this.myVector.size(),is(3));
        assertThat(this.myVector.get(2),is(not("asdf")));
        assertThat(this.myVector.get(2),is(-140));
    }

    @Test
    public void testMyVectorTrimToSize() throws Exception{
        MyVectorValueSizeThree();

        this.myVector.trimToSize();

        assertThat(this.myVector.size(),is(this.myVector.capacity()));
    }

    @Test
    public void testMyVectorClear() throws Exception{
        MyVectorValueSizeThree();

        this.myVector.clear();

        assertTrue(this.myVector.isEmpty());
    }

    @Test
    public void testMyVectorToArray() throws Exception{
        MyVectorValueSizeThree();

        Object[] temp = this.myVector.toArray();

        assertThat(temp,is(notNullValue()));
        testMyVectorDeepCopy(temp);
    }

    private void testMyVectorDeepCopy(Object[] temp) throws Exception{
        for(int i=0;i<this.myVector.size();i++){
            assertThat(this.myVector.get(i),is(temp[i]));
        }
    }
}
