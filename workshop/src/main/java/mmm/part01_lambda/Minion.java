package mmm.part01_lambda;

public interface Minion {

    void takeOrder(Order order);

    boolean hasExecutedOrder();

    int getAge();
    int getEye();

    default void seeBanana(){
        System.out.println("BA-NA-NAAAAA !!");
    }

}
