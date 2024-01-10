import { Controller, Get, Param } from '@nestjs/common';

@Controller('categories')
export class CategoriesController {

  @Get(':idCategory/products/:idProduct')
  getCategory(@Param('idProduct') idProduct : number,
              @Param('idCategory') idCategory : number){
    return `Product ${idProduct}, Category ${idCategory}`; 
  }
  
}
