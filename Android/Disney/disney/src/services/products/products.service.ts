
import { Injectable, NotFoundException } from '@nestjs/common';
import { CreateProductDto, UpdateProductDto } from 'src/DTO/product.dto';
import { Product } from 'src/entities/product.entity';
import { ProductMocks } from 'src/mocks/product.mocks';


@Injectable()
export class ProductsService {

    private counterId = 0;
    private Product : Product[] = ProductMocks;

    findAll() {
        return this.Product;
    }

    findOne (id:string){
        // return this.Product.find((item) => item.id === id);
        const producto = this.Product.find((item)=>item.id === id)

        if(producto){
            return producto;
        }else{
            throw new NotFoundException(`Product ${id} not found`);
        }
    }

    create(products:CreateProductDto){
        this.counterId = this.counterId + 1;
        const newProduct = {
            id: this.counterId + "",
            ...products,
        };
        this.Product.push(newProduct);
        return newProduct;
    }

    update(id:string, newUpdate:UpdateProductDto){

        const productFound = this.findOne(id);
        let message = '';

        if(productFound){
          
            const index = this.Product.findIndex((item)=>
                item.id === id
            );

            this.Prosdeduct[index] = {
                ...newUpdate
            }
            message = 'Product updated';
        }else{
            message = 'Product not found';
        }

        return message;
    }

    delete(id:string){

        const productFound = this.Product.findIndex((item) => item.id === id);

    }
}
