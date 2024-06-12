public class FilterTest {
	public static void main(java.lang.String[] args) {
		java.util.List<com.pancm.design.filter.Student> list = new java.util.ArrayList<com.pancm.design.filter.Student>();
		list.add(new com.pancm.design.filter.Student("小明", "male", 1));
		list.add(new com.pancm.design.filter.Student("小红", "female", 2));
		list.add(new com.pancm.design.filter.Student("小刚", "male", 2));
		list.add(new com.pancm.design.filter.Student("小霞", "female", 3));
		list.add(new com.pancm.design.filter.Student("小智", "male", 3));
		list.add(new com.pancm.design.filter.Student("虚无境", "male", 1));
		com.pancm.design.filter.FilterinGrule male = new com.pancm.design.filter.MaleStudents();
		com.pancm.design.filter.FilterinGrule female = new com.pancm.design.filter.FemaleStudents();
		com.pancm.design.filter.FilterinGrule secondGrade = new com.pancm.design.filter.SecondGrade();
		com.pancm.design.filter.FilterinGrule secondGradeMale = new com.pancm.design.filter.And(secondGrade, male);
		com.pancm.design.filter.FilterinGrule secondGradeOrFemale = new com.pancm.design.filter.Or(secondGrade, female);
		java.lang.System.out.println("男生:" + male.filter(list));
		java.lang.System.out.println("女生:" + female.filter(list));
		java.lang.System.out.println("二年级学生:" + secondGrade.filter(list));
		java.lang.System.out.println("二年级男生:" + secondGradeMale.filter(list));
		java.lang.System.out.println("二年级的学生或女生:" + secondGradeOrFemale.filter(list));
	}
}