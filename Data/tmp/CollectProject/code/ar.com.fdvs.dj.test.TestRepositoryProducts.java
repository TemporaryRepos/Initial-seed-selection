public class TestRepositoryProducts {
	public static java.util.List<ar.com.fdvs.dj.test.domain.Product> getDummyCollection() {
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat();
		dateFormat.applyPattern("dd/MM/yyyy");
		java.util.List<ar.com.fdvs.dj.test.domain.Product> col = new java.util.ArrayList<ar.com.fdvs.dj.test.domain.Product>();
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("1"), "book", "Harry Potter 7", "Florida", "Main Street", new java.lang.Long("2500"), new java.lang.Float("10000")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("1"), "book", "Harry Potter 7", "Florida", "Railway Station", new java.lang.Long("1400"), new java.lang.Float("2831.32")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("1"), "book", "Harry Potter 7", "Florida", "Baseball Stadium", new java.lang.Long("4000"), new java.lang.Float("38347")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("1"), "book", "Harry Potter 7", "Florida", "Shopping Center", new java.lang.Long("3000"), new java.lang.Float("9482.4")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("1"), "book", "Harry Potter 7", "New York", "Main Street", new java.lang.Long("2500"), new java.lang.Float("27475.5")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("1"), "book", "Harry Potter 7", "New York", "Railway Station", new java.lang.Long("1400"), new java.lang.Float("3322")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("1"), "book", "Harry Potter 7", "New York", "Baseball Stadium", new java.lang.Long("4000"), new java.lang.Float("78482")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("1"), "book", "Harry Potter 7", "New York", "Shopping Center", new java.lang.Long("3000"), new java.lang.Float("5831.32")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("2"), "book", "The Sum of All Fears", "New York", "Main Street", new java.lang.Long("1500"), new java.lang.Float("8329.2")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("2"), "book", "The Sum of All Fears", "New York", "Railway Station", new java.lang.Long("2500"), new java.lang.Float("27475.5")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("3"), "book", "The Pelican Brief,", "New York", "Main Street", new java.lang.Long("2500"), new java.lang.Float("38347")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("3"), "book", "The Pelican Brief,", "New York", "Railway Station", new java.lang.Long("1400"), new java.lang.Float("9482.4")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("3"), "book", "The Pelican Brief,", "New York", "Baseball Stadium", new java.lang.Long("1500"), new java.lang.Float("8329.2")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("3"), "book", "The Pelican Brief,", "New York", "Shopping Center", new java.lang.Long("2500"), new java.lang.Float("27475.5")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("3"), "book", "The Pelican Brief,", "Washington", "Main Street", new java.lang.Long("1400"), new java.lang.Float("3322")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("3"), "book", "The Pelican Brief,", "Washington", "Railway Station", new java.lang.Long("4000"), new java.lang.Float("78482")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("3"), "book", "The Pelican Brief,", "Washington", "Baseball Stadium", new java.lang.Long("3000"), new java.lang.Float("5831.32")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("3"), "book", "The Pelican Brief,", "Washington", "Shopping Center", new java.lang.Long("4000"), new java.lang.Float("78482")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("3"), "book", "The Pelican Brief,", "Arizona", "Main Street", new java.lang.Long("3000"), new java.lang.Float("2831.32")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("3"), "book", "The Pelican Brief,", "Arizona", "Railway Station", new java.lang.Long("1500"), new java.lang.Float("38347")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("3"), "book", "The Pelican Brief,", "Arizona", "Shopping Center", new java.lang.Long("1400"), new java.lang.Float("8329.2")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("4"), "dvd", "Titanic", "Florida", "Main Street", new java.lang.Long("4000"), new java.lang.Float("27475.5")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("4"), "dvd", "Titanic", "Florida", "Railway Station", new java.lang.Long("3000"), new java.lang.Float("3322")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("4"), "dvd", "Titanic", "Florida", "Baseball Stadium", new java.lang.Long("1500"), new java.lang.Float("78482")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("4"), "dvd", "Titanic", "Florida", "Shopping Center", new java.lang.Long("2500"), new java.lang.Float("5831.32")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("4"), "dvd", "Titanic", "New York", "Main Street", new java.lang.Long("1400"), new java.lang.Float("78482")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("4"), "dvd", "Titanic", "New York", "Railway Station", new java.lang.Long("1500"), new java.lang.Float("2831.32")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("4"), "dvd", "Titanic", "New York", "Baseball Stadium", new java.lang.Long("2500"), new java.lang.Float("38347")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("4"), "dvd", "Titanic", "New York", "Shopping Center", new java.lang.Long("1400"), new java.lang.Float("9482.4")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("4"), "dvd", "Titanic", "Washington", "Main Street", new java.lang.Long("4000"), new java.lang.Float("8329.2")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("4"), "dvd", "Titanic", "Washington", "Railway Station", new java.lang.Long("3000"), new java.lang.Float("27475.5")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("4"), "dvd", "Titanic", "Washington", "Baseball Stadium", new java.lang.Long("4000"), new java.lang.Float("3322")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("4"), "dvd", "Titanic", "Washington", "Shopping Center", new java.lang.Long("3000"), new java.lang.Float("78482")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("4"), "dvd", "Titanic", "Arizona", "Main Street", new java.lang.Long("1500"), new java.lang.Float("5831.32")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("4"), "dvd", "Titanic", "Arizona", "Railway Station", new java.lang.Long("8400"), new java.lang.Float("3322")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("4"), "dvd", "Titanic", "Arizona", "Shopping Center", new java.lang.Long("4000"), new java.lang.Float("5831.32")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("5"), "dvd", "Back To the Future", "New York", "Main Street", new java.lang.Long("1500"), new java.lang.Float("8329.2")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("6"), "dvd", "Monsters Inc", "New York", "Railway Station", new java.lang.Long("1400"), new java.lang.Float("78482")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("6"), "dvd", "Monsters Inc", "New York", "Baseball Stadium", new java.lang.Long("4000"), new java.lang.Float("2831.32")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("6"), "dvd", "Monsters Inc", "New York", "Shopping Center", new java.lang.Long("3000"), new java.lang.Float("38347")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("6"), "dvd", "Monsters Inc", "Washington", "Main Street", new java.lang.Long("4000"), new java.lang.Float("9482.4")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("6"), "dvd", "Monsters Inc", "Washington", "Railway Station", new java.lang.Long("3000"), new java.lang.Float("8329.2")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("7"), "magazine", "Sports Illustrated", "New York", "Main Street", new java.lang.Long("1400"), new java.lang.Float("3322")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("7"), "magazine", "Sports Illustrated", "New York", "Railway Station", new java.lang.Long("4000"), new java.lang.Float("78482")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("7"), "magazine", "Sports Illustrated", "New York", "Baseball Stadium", new java.lang.Long("3000"), new java.lang.Float("5831.32")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("10"), "food", "snickers", "New York", "Main Street", new java.lang.Long("1400"), new java.lang.Float("3322")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("10"), "food", "snickers", "New York", "Railway Station", new java.lang.Long("1500"), new java.lang.Float("78482")));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("10"), "food", "snickers", "New York", "Baseball Stadium", new java.lang.Long("2500"), new java.lang.Float("5831.32")));
		return col;
	}

	public static java.util.List getDummyCollectionSmall() {
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat();
		dateFormat.applyPattern("dd/MM/yyyy");
		java.util.List col = new java.util.ArrayList();
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("1"), "book", "Harry Potter 7", "Florida", "Main Street", new java.lang.Long("250"), new java.lang.Float("10000"), true));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("1"), "book", "Harry Potter 7", "Florida", "Railway Station", new java.lang.Long("400"), new java.lang.Float("2831.32"), true));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("1"), "book", "Harry Potter 7", "Florida", "Baseball Stadium", new java.lang.Long("440"), null, false));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("1"), "book", "Harry Potter 7", "Florida", "Shopping Center", new java.lang.Long("300"), new java.lang.Float("9482.4"), false));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("1"), "book", "Harry Potter 7", "New York", "Main Street", new java.lang.Long("500"), new java.lang.Float("27475.5"), true));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("1"), "book", "Harry Potter 7", "New York", "Railway Station", new java.lang.Long("640"), new java.lang.Float("3322"), true));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("1"), "book", "Harry Potter 7", "New York", "Baseball Stadium", new java.lang.Long("100"), new java.lang.Float("78482"), false));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("1"), "book", "Harry Potter 7", "New York", "Shopping Center", new java.lang.Long("70"), new java.lang.Float("5831.32"), false));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("3"), "book", "The Pelican Brief,", "Washington", "Main Street", null, new java.lang.Float("3322"), true));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("3"), "book", "The Pelican Brief,", "Washington", "Railway Station", new java.lang.Long("98"), new java.lang.Float("78482"), true));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("3"), "book", "The Pelican Brief,", "Washington", "Baseball Stadium", new java.lang.Long("613"), new java.lang.Float("5831.32"), false));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("3"), "book", "The Pelican Brief,", "Washington", "Shopping Center", new java.lang.Long("87"), null, false));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("3"), "book", "The Pelican Brief,", "Arizona", "Main Street", new java.lang.Long("250"), new java.lang.Float("2831.32"), true));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("3"), "book", "The Pelican Brief,", "Arizona", "Railway Station", new java.lang.Long("550"), new java.lang.Float("38347"), false));
		return col;
	}

	public static java.util.List getDummyCollectionSmallVariation1() {
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat();
		dateFormat.applyPattern("dd/MM/yyyy");
		java.util.List col = new java.util.ArrayList();
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("1"), "book", "Harry Potter 7", "Florida", "Main Street", new java.lang.Long("250"), new java.lang.Float("10000"), true));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("2"), "dvd", "Harry Potter 7", "Florida", "Railway Station", new java.lang.Long("400"), new java.lang.Float("2831.32"), true));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("3"), "magazine", "Harry Potter 7", "Florida", "Baseball Stadium", new java.lang.Long("440"), null, false));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("4"), "book", "Harry Potter 7", "Florida", "Shopping Center", new java.lang.Long("300"), new java.lang.Float("9482.4"), false));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("5"), "dvd", "Harry Potter 7", "New York", "Main Street", new java.lang.Long("500"), new java.lang.Float("27475.5"), true));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("6"), "magazine", "Harry Potter 7", "New York", "Railway Station", new java.lang.Long("640"), new java.lang.Float("3322"), true));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("7"), "book", "Harry Potter 7", "New York", "Baseball Stadium", new java.lang.Long("100"), new java.lang.Float("78482"), false));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("8"), "dvd", "Harry Potter 7", "New York", "Shopping Center", new java.lang.Long("70"), new java.lang.Float("5831.32"), false));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("9"), "magazine", "The Pelican Brief,", "Washington", "Main Street", null, new java.lang.Float("3322"), true));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("10"), "book", "The Pelican Brief,", "Washington", "Railway Station", new java.lang.Long("98"), new java.lang.Float("78482"), true));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("11"), "dvd", "The Pelican Brief,", "Washington", "Baseball Stadium", new java.lang.Long("613"), new java.lang.Float("5831.32"), false));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("12"), "magazine", "The Pelican Brief,", "Washington", "Shopping Center", new java.lang.Long("87"), null, false));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("13"), "book", "The Pelican Brief,", "Arizona", "Main Street", new java.lang.Long("250"), new java.lang.Float("2831.32"), true));
		col.add(new ar.com.fdvs.dj.test.domain.Product(new java.lang.Long("14"), "dvd", "The Pelican Brief,", "Arizona", "Railway Station", new java.lang.Long("550"), new java.lang.Float("38347"), false));
		return col;
	}

	public static java.util.List getDummyCollectionSorted1() {
		java.util.List list = ar.com.fdvs.dj.test.TestRepositoryProducts.getDummyCollection();
		return ar.com.fdvs.dj.util.SortUtils.sortCollection(list, new java.lang.String[]{ "state", "branch", "item" });
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(ar.com.fdvs.dj.test.TestRepositoryProducts.getDummyCollectionSorted1());
	}
}