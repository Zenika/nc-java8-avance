package mmm.part04_annotations_reflexion;

import java.time.LocalDateTime;
import java.util.HashMap;


//TODO multiple master
public class Dave implements Minion {

    private final HashMap<Toys, Integer> toysCounter = new HashMap<>();

    private boolean orderExecuted = false;

    @Override
    public void takeOrder(Order order) {
        System.err.println("Poulet tikka massala ?");
        orderExecuted = true;
        order.doOrder();
    }

    public int giveAToyToAgnes(Toys toy) {
        takeOrder(() -> {
            if(toy == Toys.UNICORN) {
                System.out.println("It's so fluffy !");
            }
            toysCounter.compute(toy, (t, v) -> v == null ? 1 : v + 1);
        });
        return toysCounter.getOrDefault(toy, 0);
    }

    @Override
    public int getAge() {
        return 5;
    }

    public boolean hasExecutedOrder() {
        return orderExecuted;
    }
    
    @Override
    public LocalDateTime getBirthDate() { 
    	return LocalDateTime.of(1984, 11, 17, 0, 0, 0);
    }
}
