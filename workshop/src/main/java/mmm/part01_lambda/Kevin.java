package mmm.part01_lambda;

public class Kevin implements Minion {

    private boolean orderExecuted = false;

    @Override
    public void takeOrder(Order order) {
        System.out.println("Kevin a reçu un ordre");
        orderExecuted = true;
        order.doOrder();
    }

    public boolean hasExecutedOrder() {
        return orderExecuted;
    }

    @Override
    public int getAge() {
        return 10;
    }

    @Override
    public int getEye() {
        return 2;
    }
}
