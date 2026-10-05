package stockmarker.entities;
import stockmaster.records.PairResult;

import java.math.BigDecimal;
import java.util.Scanner;

public  class Inventori {
    private Product []_products = new Product[10];
    private int _slots = 0;
    public void AddProduct(){
        Scanner sc = new Scanner(System.in);
        IO.println("Nombre del producto: ");
        String name = sc.nextLine();
        IO.println("Precio del producto: ");
        BigDecimal price = sc.nextBigDecimal();
        IO.println("Cantidad: ");
        int stock = sc.nextInt();

        if(_slots >= 10){
            IO.println("Capacidad maxima alcanzada");
        }
        var result = isExist(name);
        if (result.product() != null){
            IO.println("El producto ya existe, Actualizando el inventario");
            _products[result.indice()].UpdateStock((result.product().GetStock() + stock));
            return;
        }

        _products[_slots] = Product.Create(name, price, stock);
        _slots++;

    }

    private PairResult isExist(String name){
        if (_slots == 0)
            return new  PairResult(null, 0);
        for (int i = 0; i < _products.length; i++){
            if(_products[i] != null &&  _products[i].GetName().equals(name)){
                return new PairResult(_products[i], i);
            }
        }
        return new PairResult(null, 0);
    }

    public void ListProducts(){

        for (int i = 0; i < _products.length; i++ ) {
            if(_products[i] != null){
                var product = _products[i];
                IO.println("----------------------------------");
                IO.println(
                        "ProductId: %d\nProductName: %s\nProductPrice: %.2f \nStock: %d".formatted(
                                        product.GetProductId(),
                                        product.GetName(),
                                        product.GetPrice(),
                                        product.GetStock()
                                )
                );
                IO.println("----------------------------------");
            }
        }
    }

    public PairResult FindById(int id){
        if(id <= 0)
            throw new IllegalArgumentException();

        for (int i =0; i < _products.length; i++)
        {
            if(_products[i] != null && _products[i].GetProductId() == id){
                return new PairResult(_products[i], i);
            }
        }
        IO.println("Not found");
        return new PairResult(null, 0);
    }

    public void UpdateProduct(int id){
        var product = FindById(id).product();
        Scanner sc = new Scanner(System.in);

        if(product != null){
            IO.println("Nombre del producto %s presione enter para no actualizar: "
                    .formatted(product.GetName()));
            String name = sc.nextLine();
            if (!name.isEmpty())
                product.UpdateName(name);

            IO.println("Precio del producto %b presione enter para no actualizar: "
                    .formatted(product.GetPrice()));
            BigDecimal price = sc.nextBigDecimal();
            if (price.compareTo(BigDecimal.ZERO) == 0)
                product.UpdatePrice(price.add(product.GetPrice()));

            IO.println("Stock del producto %d presione enter para no actualizar: "
                    .formatted(product.GetStock()));
            int stock = sc.nextInt();
            if (stock != 0)
                product.UpdateStock(stock);

        }
    }

    public void DeleteProduct(int id){
        var result = FindById(id);
        var product = result.product();
        int indice = result.indice();
        if(product != null){
            _products[indice] = null;
            for (int i = 0; i < _products.length; i++){
                for (int j = indice; i < _products.length - 1; i++){
                    _products[i] = _products[i + 1];
                }
            }
        }else{
            IO.println("Not found");
        }

    }

}
