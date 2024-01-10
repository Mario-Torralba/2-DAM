import { Controller,Param,Get,Query, Post, Body, Put, Delete } from '@nestjs/common';

@Controller('products')
export class ProductsController {

    @Get('/:idProduct')
  getProduct(@Param('idProduct') idProduct : number){
    return `product ${idProduct}`; 
  }

  @Get()
  getProducts(@Query('limit') limit,
              @Query('offset') offset){
    return `Limit ${limit}, Offset ${offset}`; 
  }

  @Post('ruta')
  create(){
    return {
        message: 'Crear Producto'
    }; 
  }

  @Post('ruta2')
  create2(@Body() product: any){
    return {
        product,
        message: 'Crear Producto'
    }; 
  }

  @Put(':id')
  update(@Param('id') id : number, @Body() product: any){
    return {
        id,
        product
    }; 
  }

  @Delete(':id')
  delete(@Param('id') id : number){
    return {
        id
    }; 
  }

}

