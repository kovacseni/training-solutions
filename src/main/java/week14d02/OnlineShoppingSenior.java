package week14d02;

import java.io.*;
import java.util.*;

public class OnlineShoppingSenior {

    private Map<String, OnlineOrder> orders = new HashMap<>();

    public void loadOrders(Reader reader) {
        try (BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                load(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    private void load(String line) {
        String[] tempTwoParts = line.split(": ");
        String[] firstPart = tempTwoParts[0].split("-");
        String[] secondPart = tempTwoParts[1].split(",");

        List<Product> products = getListOfProducts(secondPart);
        OnlineOrder order = new OnlineOrder(firstPart[0], products);
        orders.put(firstPart[1], order);
    }

    private List<Product> getListOfProducts(String[] secondPart) {
        List<Product> products = new ArrayList<>();
        for (String s : secondPart) {
            int index = s.indexOf("(");
            String name = s.substring(0, index);
            int price = Integer.parseInt(s.substring(index + 1, s.length() - 1));
            products.add(new Product(name, price));
        }
        return products;
    }

    public int getTotalValueOfOneOrder(String orderId) {
        int total = 0;
        for (Product p : orders.get(orderId).getProducts()) {
            total += p.getPrice();
        }
        return total;
    }

    public int getTotalValueByCustomerId(String customerId) {
        int total = 0;
        for (String id : orders.keySet()) {
            if (orders.get(id).getId().equals(customerId)) {
                int sum = getTotalValueOfOneOrder(id);
                total += sum;
            }
        }
        return total;
    }

    public List<Product> sortProductsByOrderId(String orderId, SortingType sortingType) {
        List<Product> sorted = new ArrayList<>(orders.get(orderId).getProducts());
        if (sortingType == SortingType.NAME) {
            sorted.sort(Comparator.comparing(Product::getName));
        } else if (sortingType == SortingType.PRICE) {
            sorted.sort(Comparator.comparing(Product::getPrice));
        }
        return sorted;
    }

    public int getTotalPiecesOfProduct(String name) {
        int total = 0;
        for (OnlineOrder o : orders.values()) {
            total += getPiecesInOneOrder(o, name);
        }
        return total;
    }

    private int getPiecesInOneOrder(OnlineOrder o, String name) {
        int pieces = 0;
        for (Product p : o.getProducts()) {
            if (p.getName().equals(name)) {
                pieces++;
            }
        }
        return pieces;
    }

    public Map<String, Integer> getProductStatistics() {
        Map<String, Integer> statistics = new HashMap<>();
        for (OnlineOrder o : orders.values()) {
            putToMap(o, statistics);
        }
        return statistics;
    }

    private void putToMap(OnlineOrder o, Map<String, Integer> statistics) {
        for (Product p : o.getProducts()) {
            String name = p.getName();
            if (!statistics.containsKey(name)) {
                statistics.put(name, 0);
            }
            statistics.put(name, statistics.get(name) + 1);
        }
    }
}