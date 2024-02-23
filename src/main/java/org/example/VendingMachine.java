package org.example;

import org.example.exception.CoinNotValidException;
import org.example.exception.NoChangeException;
import org.example.exception.ProductNotAvailableException;

import java.util.*;


public class VendingMachine {
    private Map<String, Product> products;
    private int[] coins;
    private ArrayList<Integer> balance = new ArrayList<>();
    private Product selectedProduct;

    public Boolean getSelected() {
        return selected;
    }

    private Boolean selected= false;
    private int userBalance;

    Scanner sc = new Scanner(System.in);
    public ArrayList<Integer> getBalance() {
        return balance;
    }

    public VendingMachine() {
        products = new HashMap<>();
        products.put("water", new Product("water",5, 10));
        products.put("coca", new Product("coca",7, 10));
        products.put("twix", new Product("twix",10, 10));
        products.put("bueno", new Product("bueno",12, 10));
        coins = new int[]{1, 2, 5, 10};


    }

    public boolean isValidCoin(int coin) {
        for (int validCoin : coins) {
            if (coin == validCoin) {
                return true;
            }
        }
      return false;
    }
    //id
    public Product selectProduct(String productName)throws ProductNotAvailableException {
        if (products.containsKey(productName.toLowerCase())) {
            selected = true;
            selectedProduct=products.get(productName);
            return selectedProduct;
        }

         throw new ProductNotAvailableException("product not available !");


    }

    public void cancelRequest() {
        if (selectedProduct != null) {
                selected = !selected;
                balance.remove(Integer.valueOf(userBalance));
        }
    }

    public String buyProduct(int coin)  {


        int remain=0;
        if (selectedProduct != null) {
                insertCoin(coin);
                if (coin > selectedProduct.getCost()){
                remain= getRemain(coin);
                }
                selected = false;
                return("product is "+selectedProduct.getName()+" and remain is "+ remain);


            }
        throw new RuntimeException("Please select product first");


    }

    public int getRemain(int coin) throws NoChangeException {

            int remainder=coin-selectedProduct.getCost();
            int remainingAmount=remainder;
             Collections.sort(balance,Collections.reverseOrder());
            ArrayList<Integer> change=new ArrayList<>();
            for (int i = 0; i < balance.size(); i++) {
                int currentCoint = balance.get(i);
                if (currentCoint <=remainingAmount) {
                    change.add(currentCoint);
                    remainingAmount -= currentCoint;
                }
                if (remainingAmount == 0){
                    for(int j=0;j< change.size();j++){
                        balance.remove(Integer.valueOf(change.get(j)));
                    }
                    return remainder;
                }
            }
            throw new NoChangeException("Machine does not have change. Please try again");




    }
    public int calculateTotalBalance() {
        int total = 0;
        for (int coin : balance) {
            total += coin;
        }
        return total;
    }
    public void insertCoin(int coin)throws CoinNotValidException {
       if(isValidCoin(coin)){
          balance.add(coin);
          userBalance =coin;

       }
       else{ throw new CoinNotValidException("Coin is not valide!");

       }
    }


}





