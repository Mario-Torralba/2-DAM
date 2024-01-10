import { Controller, Get, Param, Query } from '@nestjs/common';
import { AppService } from './app.service';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  getHello(): string {
    return "Mi primer Webservice por GET"
    //return this.appService.getHello();
  }

  @Get('nuevo')
  getMiPrimerGet1(): string {
    return "Mi primer GET"
  }

  @Get('ruta')
  getMiPrimerGet2(): string {
    return "Mi segundo GET"
  }

  


}
