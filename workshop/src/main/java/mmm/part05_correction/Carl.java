package mmm.part05_correction;

import java.time.LocalDateTime;


@Master("Gru")
@Master(value = "El Macho")
@Master(value = "Dr. Nefario")
public class Carl implements @Evil Minion {

    private boolean orderExecuted = false;

    @Override
    public void takeOrder(Order order) {
        System.out.println("Carl a reçu un ordre");
        orderExecuted = true;
        order.doOrder();
    }

    public boolean hasExecutedOrder() {
        return orderExecuted;
    }

    @Override
    public int getAge() {
        return 3;
    }
    
    @Override
    public LocalDateTime getBirthDate() {
    	return LocalDateTime.of(1996, 10, 9, 0, 0, 0);
    }

}
