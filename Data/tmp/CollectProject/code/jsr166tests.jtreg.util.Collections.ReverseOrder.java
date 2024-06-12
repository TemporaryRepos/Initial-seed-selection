public class ReverseOrder {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		jsr166tests.jtreg.util.Collections.Foo[] a = new jsr166tests.jtreg.util.Collections.Foo[]{ new jsr166tests.jtreg.util.Collections.Foo(2), new jsr166tests.jtreg.util.Collections.Foo(3), new jsr166tests.jtreg.util.Collections.Foo(1) };
		java.util.List list = java.util.Arrays.asList(a);
		java.util.Collections.sort(list, java.util.Collections.reverseOrder());
		jsr166tests.jtreg.util.Collections.Foo[] golden = new jsr166tests.jtreg.util.Collections.Foo[]{ new jsr166tests.jtreg.util.Collections.Foo(3), new jsr166tests.jtreg.util.Collections.Foo(2), new jsr166tests.jtreg.util.Collections.Foo(1) };
		java.util.List goldenList = java.util.Arrays.asList(golden);
		if (!list.equals(goldenList)) {
			throw new java.lang.Exception(list.toString());
		}
	}
}