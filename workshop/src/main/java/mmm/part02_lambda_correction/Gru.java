package mmm.part02_lambda_correction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Gru {

    private final Collection<Minion> minions;

    private final AtomicInteger minionsTryingToStealTheMoon = new AtomicInteger(0);

    public Gru(Collection<Minion> minions) {
        this.minions = minions;
    }

    public void stealTheMoon() {
        minions.parallelStream().forEach(m -> m.takeOrder(minionsTryingToStealTheMoon::incrementAndGet));
    }

    public double computeMinionsAverageAge() {
        return minions.parallelStream().mapToInt(Minion::getAge).average().orElseThrow(IllegalStateException::new);
    }

    public boolean hasStealTheMoon() {
        return minionsTryingToStealTheMoon.get() == minions.size();
    }

    public Minion createSuperMinion() {
        return minions.stream().reduce((m1, m2) -> new SuperMinion(m1.getAge() + m2.getAge()
                , m1.getEye() + m2.getEye())).orElse(null);
    }

    public List<Integer> getAgeList() {
        return minions.stream().collect(ArrayList<Integer>::new,(l,m) -> l.add(m.getAge()),Collection::addAll);
    }

    public static class SuperMinion implements Minion {

        private int age;

        private int eye;

        public SuperMinion(int age, int eye) {
            this.age = age;
            this.eye = eye;
        }

        @Override
        public void takeOrder(Order order) {
            order.doOrder();
        }

        @Override
        public boolean hasExecutedOrder() {
            return true;
        }

        @Override
        public int getAge() {
            return age;
        }

        @Override
        public int getEye() {
            return eye;
        }
    }
}
