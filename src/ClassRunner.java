public class ClassRunner {

    public static void main(String[] args)
    {
        Person boy = new Person("0001", "nolan", "worley", "mr.", 2002);
        Person girl = new Person("0002", "sarah", "haffey", "mrs.", 2001);

        Product cheese = new Product("0001", "cheese", "its smelly", 50);

        System.out.println(boy.GetFullName());
        System.out.println(girl.GetFullName());
        System.out.println(boy.toCSV());
        System.out.println(cheese.toCSVDataRecord());

    }
}
