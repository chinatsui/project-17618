package me.chinatsui.research.algorithm.exercise.other;

import java.util.Arrays;
import java.util.Stack;

public class InvoiceAmountDPTest {

    /*
     *  货物单价  = [10,2,6]     如果货物条目不可分割，那么定义weight为：单价x数量；value：1。 如果可分割，那么weight：单价；value：1。
     *  数量      = [1,3,2]  =》 weight = [10,2,12]
     *  是否可分割 = [0,1,0]     value = [1,1,1]
     */

    public static void main(String[] args) {

        //Below is what user inputs.
        InvoiceGood[] invoiceGoods = {new InvoiceGood("A", 2, 3, true),
                                      new InvoiceGood("B", 1, 3, true),
                                      new InvoiceGood("C", 1, 3, true),
                                      new InvoiceGood("D", 3, 2, true),
                                      new InvoiceGood("E", 4, 2, true),
                                      new InvoiceGood("F", 4, 2, true)};

        int invoiceMaxAmount = 8;

        // validate if any InvoiceGood which is unable to be segmented is beyound invoiceMaxAmount.
        validate(invoiceMaxAmount, invoiceGoods);

        // -- algorithm start -- //
        System.out.println("Goods: " + Arrays.toString(invoiceGoods));

        int types = invoiceGoods.length;

        int[] weight = weightFrom(invoiceGoods);
        System.out.println("Weight: " + Arrays.toString(weight));

        int[] value = valueFrom(invoiceGoods);
        System.out.println("Value: " + Arrays.toString(value));

        int roadMap[][] = invoiceDp(invoiceMaxAmount, types, weight, value);

        System.out.println();

        System.out.println("Below is dynamic programming road map: ");
        for (int i = 1; i <= types; i++) {
            for (int j = 1; j <= invoiceMaxAmount; j++) {
                System.out.print(roadMap[i][j] + "\t");
                if (j == invoiceMaxAmount) {
                    System.out.println();
                }
            }
        }

        System.out.println();
        int maxValue = roadMap[roadMap.length - 1][roadMap[roadMap.length - 1].length - 1];
        System.out.println("Advised max invoice record number is : " + maxValue);

        Stack<InvoiceGood> invoiceGoodStack = stackFrom(invoiceGoods);

        int maxValueTemp = maxValue;
        int invoiceMaxAmountTemp = invoiceMaxAmount;
        while (!invoiceGoodStack.isEmpty()) {

            System.out.print("Invoice good combination: ");
            int sum = 0;
            while (maxValueTemp > 0 && !invoiceGoodStack.isEmpty()) {
                InvoiceGood invoiceGood = invoiceGoodStack.pop();

                invoiceMaxAmountTemp -= invoiceGood.getWeight();

                if (invoiceMaxAmountTemp < 0) {
                    invoiceGoodStack.push(invoiceGood);
                    break;
                }

                if (invoiceGood.isSegmented()) {
                    System.out.print(invoiceGood.getName() + ":" + invoiceGood.getPrice() + "*" + 1 + "  ");
                    sum += invoiceGood.getPrice() * 1;
                } else {
                    System.out.print(invoiceGood.getName() + ":" + invoiceGood.getPrice() + "*" + invoiceGood.getQuantity() + "  ");
                    sum += invoiceGood.getPrice() * invoiceGood.getQuantity();

                }

                maxValueTemp -= invoiceGood.getValue();
            }

            maxValueTemp = maxValue;
            invoiceMaxAmountTemp = invoiceMaxAmount;
            System.out.println(sum);
        }

    }

    public static void validate(int invoiceMaxAmount, InvoiceGood... invoiceGoods) {
        for (InvoiceGood invoiceGood : invoiceGoods) {
            if (invoiceGood.getPrice() < 0) {
                throw new RuntimeException("Unsupported invoice good: " + invoiceGood.getName() + ", its prices is less than 0");
            }

            if (invoiceGood.getWeight() > invoiceMaxAmount) {
                throw new RuntimeException("Unsupported invoice good: " + invoiceGood.getName()
                        + ", which cannot be segmented, but total prices: " + invoiceGood.getWeight() + " is beyond " + invoiceMaxAmount);
            }
        }
    }

    public static int[] weightFrom(InvoiceGood... invoiceGoods) {
        int weight[] = new int[invoiceGoods.length];

        for (int i = 0; i < invoiceGoods.length; i++) {
            weight[i] = invoiceGoods[i].getWeight();
        }

        return weight;
    }

    public static int[] valueFrom(InvoiceGood... invoiceGoods) {
        int value[] = new int[invoiceGoods.length];

        for (int i = 0; i < invoiceGoods.length; i++) {
            value[i] = invoiceGoods[i].getValue();
        }

        return value;
    }

    public static Stack<InvoiceGood> stackFrom(InvoiceGood... invoiceGoods) {
        Stack<InvoiceGood> stack = new Stack<>();

        for (int i = invoiceGoods.length - 1; i >= 0; i--) {
            InvoiceGood invoiceGood = invoiceGoods[i];
            if (invoiceGood.isSegmented) {
                for (int j = 1; j <= invoiceGood.getQuantity(); j++) {
                    stack.push(invoiceGood);
                }
            } else {
                stack.push(invoiceGood);
            }
        }

        return stack;
    }

    public static int[][] invoiceDp(int maxAmount, int types, int[] weight, int[] value) {
        //current[i][v]表示前i种商品恰好放入一个总金额为maxAmount的发票可以获得的最大价值
        int current[][] = new int[types + 1][maxAmount + 1];

        for (int i = 0; i < types + 1; i++)
            current[i][0] = 0;

        for (int j = 0; j < maxAmount + 1; j++)
            current[0][j] = 0;

        for (int i = 1; i < types + 1; i++) {
            for (int j = 1; j < maxAmount + 1; j++) {
                if (weight[i - 1] <= j) {
                    if (current[i - 1][j] < (current[i - 1][j - weight[i - 1]] + value[i - 1]))
                        current[i][j] = current[i - 1][j - weight[i - 1]] + value[i - 1];
                    else
                        current[i][j] = current[i - 1][j];
                } else {
                    current[i][j] = current[i - 1][j];
                }
            }
        }

        return current;
    }

    private static class InvoiceGood implements Comparable {

        private String name;
        private int price;
        private int quantity;
        private boolean isSegmented;

        public InvoiceGood(String name, int price, int quantity, boolean isSegmented) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.isSegmented = isSegmented;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public boolean isSegmented() {
            return isSegmented;
        }

        public void setSegmented(boolean segmented) {
            isSegmented = segmented;
        }

        public int getWeight() {
            if (isSegmented) {
                return price;
            } else {
                return price * quantity;
            }
        }

        public int getValue() {
            return 1;
        }

        @Override
        public int compareTo(Object o) {
            return this.getValue() - ((InvoiceGood) o).getValue();
        }

        @Override
        public String toString() {
            return name;
        }
    }

}