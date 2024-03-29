import { PartialType } from "@nestjs/mapped-types";
import { IsNotEmpty, IsNumber, IsPositive, IsString, IsUrl } from "class-validator";

export class CreateProductDto{


    @IsString()
    @IsNotEmpty()
    readonly name: string;

    @IsString()
    @IsNotEmpty()
    readonly descripcion: string;

    @IsNumber()
    @IsNotEmpty()
    @IsPositive()
    readonly price: number;

    @IsNumber()
    @IsNotEmpty()
    readonly stock: number;

    @IsUrl()
    @IsNotEmpty()
    readonly image: string;

}

export class UpdateProductDto extends PartialType(CreateProductDto){



}