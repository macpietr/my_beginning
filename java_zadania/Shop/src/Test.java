public class Test {
    public static void main(String[] args) {
        Part part1 = new Part(1,11,"januszex","model1");
        Tire tire1 = new Tire(2,22,"januszpol","sliki",21);
        Part part2 = new Part(3,33,"andrzejowow","srart");

        part1.printInfo();
        part2.printInfo();
        tire1.prinInfo();
    }
}
