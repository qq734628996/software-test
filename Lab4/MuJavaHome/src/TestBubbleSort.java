import org.junit.Assert;
import org.junit.Test;

public class TestBubbleSort {
	@Test
	public void BubbleSort() {
		int target[]={1,2,3,4,5,6};
		int test[]={3,2,1,6,5,4};
		int c[]=BubbleSort.BubbleSort(test);
		Assert.assertArrayEquals(target, c);
	}
}