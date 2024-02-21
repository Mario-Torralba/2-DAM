import { Module } from '@nestjs/common';
import { PeliculasController } from './controllers/peliculas.controller';
import { PeliculasService } from './services/peliculas.service';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Pelicula } from './entities/Pelicula';
import { Categoria } from './entities/Categoria';
import { Favorito } from './entities/Favorito';

@Module({
  imports: [TypeOrmModule.forFeature([Pelicula, Categoria, Favorito])],
  controllers: [PeliculasController],
  providers: [PeliculasService]
})
export class PeliculasModule {}
