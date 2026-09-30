package stockmarker.entities;

public  class Inventori {
    private Product []_products = new Product[10];

    public void ListProducts(){

        for (int i = 0; i < _products.length; i++ ) {
            if(_products[i] != null){
                var product = _products[i];
                IO.println(
                        "ProductId: %s\n" +
                                "ProductName: %d\n" +
                                "ProductPrice: %b\n" +
                                "Stock: %d".formatted(
                                        product.GetProductId(),
                                        product.GetName(),
                                        product.GetPrice(),
                                        product.GetStock()
                                )
                );
            }
        }
    }

    public Product FindById(int id){
        if(id > _products.length)
            throw new IndexOutOfBoundsException();

        for (int i =0; i < _products.length; i++)
        {
            if(_products[i] != null && _products[i].GetProductId() == id){
                return _products[i];
            }
        }
        IO.println("Not found");
        return null;
    }


}
