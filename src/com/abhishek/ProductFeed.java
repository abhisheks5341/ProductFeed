package com.abhishek;


import java.util.ArrayList;
import java.util.Collections;

public class ProductFeed {

    public static void main(String[] args) {

    }


    public ArrayList<Product> bubbleSort(ArrayList<Product> products)
    {
        int n = products.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (products.get(j).getTimestamp() > products.get(j+1).getTimestamp())
                {
                    Collections.swap( products, j, j+1);
                }
        return products;
    }

    public ArrayList<Product> sortProduct(ArrayList<Product> products) {
        return bubbleSort(products);

    }

    public void createCustomer(int id) {
        Handlers.Customers.createCustomer(id);
    }

    public ArrayList<Product> fetchFeed(int cid) {
        Customer customerObject = Handlers.Customers.getObject(cid);
        return sortProduct(customerObject.fetchFeed());
    }

    public void subscribe(int cid, int sid) {
        Customer customerObject = Handlers.Customers.getObject(cid);
        Seller sellerObject = Handlers.Sellers.getObject(sid);
        customerObject.subscribe(sellerObject);
    }

    public void unsubscribe(int cid, int sid) {
        Customer customerObject = Handlers.Customers.getObject(cid);
        Seller sellerObject = Handlers.Sellers.getObject(sid);
        customerObject.unsubscribe(sellerObject);
    }

    public void deleteSeller(int sid) {
        Handlers.Sellers.deleteSeller(sid);
    }

    public void addProduct(int pid, String name, float price) {
        Handlers.Sellers.addProduct(pid, name, price);
    }

    public void createSeller(int id) {
        Handlers.Sellers.createSeller(id);
    }

    public void deleteProduct(int id) {
        Handlers.Products.delete(id);
    }
}
