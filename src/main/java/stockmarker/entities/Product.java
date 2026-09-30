package stockmarker.entities;

import java.math.BigDecimal;

public class Product {
    private static int counter = 0;
    private int productId = 0;
    private String productName;
    private BigDecimal price;
    private int quantity;

    private Product(){}

    public static Product Create(String name,
                          BigDecimal price,
                          int quantity
    ){

        if(name.isBlank())
            throw new IllegalArgumentException(
                    "The name can not be empty.");

        if(price.compareTo(BigDecimal.ZERO) < 0)
            throw  new IllegalArgumentException(
                    "The price can not be less than zero"
            );

        if (quantity < 0)
            throw new IllegalArgumentException(
                    "The quantity can not be less than zero"
            );


        Product.counter++;
        Product product = new Product();
        product.productId = Product.counter;
        product.productName = name;
        product.quantity = quantity;
        product.price = price;
        return  product;
    }

    public void UpdateStock(int quantity){
        if (quantity <= 0)
            throw new IllegalArgumentException(
                    "The quantity can not be less than zero"
            );
        var oldStock = this.quantity;
        this.quantity = this.quantity + quantity;
        IO.println("The product %s stock have been change from %d to %d".formatted(this.productName, oldStock, this.quantity));

    }

    public void UpdateName(String name){
        if(name.isBlank())
            throw new IllegalArgumentException(
                    "The name can not be empty.");
        var oldName = this.productName;
        this.productName = name;
        IO.println("The product name %s have been change to %s".formatted(oldName, name));
    }

    public void UpdatePrice(BigDecimal price){
        if(price.compareTo(BigDecimal.ZERO) == 0)
            throw  new IllegalArgumentException(
                    "The price can not be less than zero"
            );
    }

    public void UpdatePrice(BigDecimal price, boolean isFree){
         if(isFree){
             var oldPrice = this.price;
             this.price = price;
             IO.println("The %s price have been change from %b to %b".formatted(this.productName, oldPrice, price));
         }
    }

    public void SellProduct(BigDecimal price,
                            int quantity
                            ){
        if (quantity > this.quantity)
             IO.println("The %s is out of stock".formatted(this.productName));

//        if (this.price.compareTo(price)  )

    }

    public int GetProductId(){
        return this.productId;
    }
    public String GetName(){
        return productName;
    }

    public BigDecimal GetPrice(){
        return price;
    }

    public int GetStock(){
        return quantity;
    }
}
