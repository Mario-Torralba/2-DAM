import { Injectable } from '@nestjs/common';
import { Pelicula } from '../entities/Pelicula';
import { Repository } from 'typeorm';
import { InjectRepository } from '@nestjs/typeorm';


@Injectable()
export class PeliculasService {
  constructor(
    @InjectRepository(Pelicula)
    private peliculasRepository: Repository<Pelicula>,
  ) {}


  async findAll(): Promise<Pelicula[]> {
    console.log('Llegando A LISTAR TODOS');
    return this.peliculasRepository.find(); // Utiliza el método find() sin argumentos para obtener todas las entidades
  }
  // Nuevo método para filtrar películas por categoría
  async findByCategoria(categoriaId: number): Promise<Pelicula[]> {
    return this.peliculasRepository
      .createQueryBuilder('pelicula')
      .innerJoinAndSelect('pelicula.categorias', 'categoria')
      .where('categoria.id = :categoriaId', { categoriaId })
      .getMany();
  }
}

