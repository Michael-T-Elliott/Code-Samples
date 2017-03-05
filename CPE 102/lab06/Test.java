
public class Test
{
	public static void main(String[] args)
	{

		System.out.println("Testing toString statements...");

		Animal Anim1 = new Animal(2);
		Animal Anim2 = new Animal(4);
		Animal Anim3 = new Animal(6);
		System.out.println(Anim1.toString());
		System.out.println(Anim2.toString());
		System.out.println(Anim3.toString());

		String Michael = "Michael";
		String Nathan = "Nathan";
		String Steven = "Steven";

		Person Pers1 = new Person(Michael, 2);
		Person Pers2 = new Person(Nathan, 2);
		Person Pers3 = new Person(Steven, 1);
		System.out.println(Pers1.toString());
		System.out.println(Pers2.toString());
		System.out.println(Pers3.toString());

		Student Stud1 = new Student(Michael, 2, 3.0);
		Student Stud2 = new Student(Nathan, 2, 3.1);
		Student Stud3 = new Student(Steven, 1, 3.33);
		System.out.println(Stud1.toString());
		System.out.println(Stud2.toString());
		System.out.println(Stud3.toString());

		System.out.println("Testing object equality");

		Animal Anim4 = new Animal(4);
		Person Pers4 = new Person(Michael, 2);
		Student Stud4 = new Student(Michael, 2, 3.0);

		System.out.println("animal = same animal " + Anim4.equals(Anim2));
		System.out.println("animal = person " + Anim4.equals(Pers1));

		System.out.println("person = same person " + Pers4.equals(Pers1));
		System.out.println("person = Student " + Pers4.equals(Stud1));

		System.out.println("Student = same Student "+ Stud4.equals(Stud1));
		System.out.println("person = animal " + Stud2.equals(Anim3));
	}
}