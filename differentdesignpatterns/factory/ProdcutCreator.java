package differentdesignpatterns.factory;


interface Product {
    void prepare();

}
class ProductA implements Product{
    @Override
    public void prepare(){
        //prepare productA
        // Product code
    }
}


class ProductB implements Product{
    @Override
    public void prepare(){
        //prepare productB
        // Product code
    }
}
public abstract class ProdcutCreator{
    public Product orderProduct() {
        Product product = createProduct();
        product.prepare();
        return product;
    }

    public abstract Product createProduct();

}

class ProductACreator extends ProdcutCreator{
    public Product createProduct(){
        return new ProductA();
    }

}


class ProductBCreator extends ProdcutCreator{
    public Product createProduct(){
        return new ProductB();
    };
}