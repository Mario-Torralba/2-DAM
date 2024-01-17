import { Controller,Param,Get,Query, Post, Body, Put, Delete, ParseIntPipe } from '@nestjs/common';
import { CreateProductDto, UpdateProductDto } from 'src/DTO/product.dto';
import { Product } from 'src/entities/product.entity';
import {ProductsService} from 'src/services/products/products.service';

@Controller('products')
export class ProductsController {

  constructor(private productService : ProductsService){}

    @Get('/:idProduct')
  getProduct(@Param('idProduct', ParseIntPipe) idProduct : string){
    // return `product ${idProduct}`; 
    return this.productService.findOne(idProduct);
  }

  @Get()
  getProducts(@Query('limit') limit,
              @Query('offset') offset){
    // return `Limit ${limit}, Offset ${offset}`; 
  }

  @Post('ruta')
  create(@Body() newProduct: CreateProductDto){
    // return {
    //     message: 'Crear Producto'
    // }; 
    return this.productService.create(newProduct)
  }

  @Post('ruta2')
  create2(@Body() product: Product){
    // return {
    //     product,
    //     message: 'Crear Producto'
    // }; 
    return this.productService.create(product)
  }

  @Put(':id')
  update(@Param('id') id : string, @Body() product: UpdateProductDto){
    // return {
    //     id,
    //     product
    // }; 
    return this.productService.update(id,product)
  }

  @Delete(':id')
  delete(@Param('id') id : string){
    // return {
    //     id
    // }; 
  // }
  return this.productService.delete(id);

}

}