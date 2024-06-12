public class BuilderTest {
	public static void main(java.lang.String[] args) {
		com.pancm.design.builder.FoodStore foodStore = new com.pancm.design.builder.FoodStore();
		com.pancm.design.builder.Meal meal = foodStore.createBreakfast(new com.pancm.design.builder.Breakfast());
		com.pancm.design.builder.Meal meal2 = foodStore.createBreakfast(new com.pancm.design.builder.Lunch());
		java.lang.System.out.println((("小明早上吃的是:" + meal.getFood()) + ",喝的饮料是:") + meal.getDrinks());
		java.lang.System.out.println((("小明中午吃的是:" + meal2.getFood()) + ",喝的饮料是:") + meal2.getDrinks());
	}
}