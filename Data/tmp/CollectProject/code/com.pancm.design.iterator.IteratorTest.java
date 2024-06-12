public class IteratorTest {
	public static void main(java.lang.String[] args) {
		com.pancm.design.iterator.MyIterable myIterable = new com.pancm.design.iterator.ListContainer();
		myIterable.add("1");
		myIterable.add("zhangsan");
		myIterable.add("2");
		myIterable.add("lisi");
		myIterable.add("3");
		myIterable.add("xuwujing");
		com.pancm.design.iterator.MyIterator myIterator = myIterable.getIterator();
		while (myIterator.hasNext()) {
			java.lang.String str = myIterator.next();
			java.lang.System.out.println(str);
		} 
	}
}