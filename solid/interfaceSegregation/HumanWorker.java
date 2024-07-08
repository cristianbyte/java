public class HumanWorker implements Workable, Eatable{
    @Override
    public void eat() {
        System.out.println("Human working...");
    }

    @Override
    public void work() {
        System.out.println("Human eating...");
    }
}
