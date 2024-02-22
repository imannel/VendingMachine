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
    private Boolean selected= false;

    Scanner sc = new Scanner(System.in);
    public ArrayList<Integer> getBalance() {
        return balance;
    }

    public VendingMachine() {
        products = new HashMap<>();
        products.put("water", new Product(5, 10));
        products.put("coca", new Product(7, 10));
        products.put("twix", new Product(10, 10));
        products.put("bueno", new Product(12, 10));

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

    public Product selectProduct(Product product)throws ProductNotAvailableException {
        String productName= product.getName();
        if (products.containsKey(productName.toLowerCase())) {
            selected = true;
            return product;
        }

         throw new ProductNotAvailableException("product not available !");


    }

    public void cancelRequest() {
        if (selectedProduct != null) {
            System.out.println("Are u sure! Y/N");
            String resp = sc.nextLine();
            if (resp.equals("y") || resp.equals("yes")) {
                selected = !selected;
            }
        } else {
            System.out.println("Vous n'avez selectionné aucun produit");

        }
    }

    public void buyProduct(int coin) throws CoinNotValidException,NoChangeException {


        if (selectedProduct != null) {
                insertCoin(coin);
                if (coin > selectedProduct.getCost()){
                getRemain(coin);
                }

                System.out.println("Payment accepted. Please take your product: " + selectedProduct.getName());
                selected = false;
            }
          else
        {
            System.out.println("Please select a product first.");
        }

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
       }
       else{ throw new CoinNotValidException("Coin is not valide!");

       }
    }


}





