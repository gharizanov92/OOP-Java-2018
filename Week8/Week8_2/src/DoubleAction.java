public class DoubleAction implements MyAction {
    @Override
    public void apply(Integer arg) {
        System.out.println(arg * 2);
    }
}
