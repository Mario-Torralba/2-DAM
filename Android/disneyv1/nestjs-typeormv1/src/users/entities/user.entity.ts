import {
  Entity,
  Column,
  PrimaryColumn,
  CreateDateColumn,
  UpdateDateColumn,
  OneToOne,
  JoinColumn,
  PrimaryGeneratedColumn,
  OneToMany,
} from 'typeorm';


import { Customer } from './customer.entity';
import { Favorito } from 'src/peliculas/entities/Favorito';


@Entity()
export class User {
  // @PrimaryColumn()
  @PrimaryGeneratedColumn()
  id: number;


  @Column({ type: 'varchar', length: 255 })
  email: string;


  @Column({ type: 'varchar', length: 255 })
  password: string; // encript


  @Column({ type: 'varchar', length: 100 })
  role: string;


  @CreateDateColumn({
    type: 'timestamptz',
    default: () => 'CURRENT_TIMESTAMP',
  })
  createAt: Date;


  @UpdateDateColumn({
    type: 'timestamptz',
    default: () => 'CURRENT_TIMESTAMP',
  })
  updateAt: Date;


  @OneToOne(() => Customer, (customer) => customer.user, { nullable: true }) // indicaciones de unión, usuarios que no son clientes
  @JoinColumn() // referencia real, en base de datos foreign key.
  customer: Customer;
  //Un user tenga un Customer
  // Resuelva una entidad de tipo Costumer


  @OneToMany(() => Favorito, (favorito) => favorito.user)
  favoritos: Favorito[];
}


