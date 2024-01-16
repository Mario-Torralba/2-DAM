import { Injectable } from '@nestjs/common';
import { Product } from 'src/entities/product.entity';


@Injectable()
export class ProductsService {

    private counterId = 1;
    private Product : Product[] = [{
        id:1,
        name: 'Product 1',
        descripcion: 'oeoeoe',
        price: 100,
        stock: 200,
        image: 'Imagen 1'
    }];

    findAll() {
        return this.Product;
    }

    findOne (id:number){
        return this.Product.find((item) => item.id ===id);
    }

    create(products:any){
        this.counterId = this.counterId + 1;
        const newProduct = {
            id: this.counterId,
            ...products,
        };
        this.Product.push(newProduct);
        return newProduct;
    }

    update(id:number, products:any){
        const productFound = this.findOne(id);
    }

    delete(id:number){

        const productFound = this.Product.findIndex((item) => item.id === id);

    }
}
