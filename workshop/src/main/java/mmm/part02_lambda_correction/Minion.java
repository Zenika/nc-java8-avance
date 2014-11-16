package mmm.part02_lambda_correction;

public interface Minion {

    void takeOrder(Order order);

    boolean hasExecutedOrder();

    int getAge();
    int getEye();

    default void seeBanana(){
        System.out.println("BA-NA-NAAAAA !!");
    }

}
