package FunctionalProg;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class _ImproveTypeInference {
    public static void main(String[] args) {
        Map<String, List<Trade>> trades= new TreeMap<>();
        trades.put("a",List.of(new Trade("NANO",2.3)));
        trades.put("b",List.of(new Trade("BNB",5.3)));

        System.out.println(trades);

    }
    static class Trade{
        private String title;
        private double price;

        @Override
        public String toString() {
            return "[" +
                    "Title='" + title + '\'' +
                    ", price=" + price +
                    ']';
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public Trade(String title, double price) {
            this.title = title;
            this.price = price;
        }
    }
}
