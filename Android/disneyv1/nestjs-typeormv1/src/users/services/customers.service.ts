import { Injectable, NotFoundException } from '@nestjs/common';

import { Customer } from '../entities/customer.entity';
import { CreateCustomerDto, UpdateCustomerDto } from '../dtos/customer.dto';
import { Repository } from 'typeorm';
import { InjectRepository } from '@nestjs/typeorm';

@Injectable()
export class CustomersService {
  constructor(
    @InjectRepository(Customer) private customerRepository: Repository<Customer>,
  ) {}
  private counterId = 1;
  private customers: Customer[] = [
    // {
    //   id: 1,
    //   name: 'Nicolas',
    //   lastName: 'Molina',
    //   phone: '3111111212',
    // },
  ];

  findAll() {
    return this.customerRepository.find();
  }

  async findOne(id: number) {
    // const customer = this.customers.find((item) => item.id === id);
    // if (!customer) {
    //   throw new NotFoundException(`Customer #${id} not found`);
    // }
    // return customer;
    const customer = await this.customerRepository.findOne({ id });
    if (!customer) {
      throw new NotFoundException(`Customer #${id} not found`);
    }
    return customer;
  }

  create(data: CreateCustomerDto) {
    // this.counterId = this.counterId + 1;
    // const newCustomer = {
    //   id: this.counterId,
    //   ...data,
    // };
    // this.customers.push(newCustomer);
    // return newCustomer;
    // return null;

    const newCustomer = this.customerRepository.create(data);
    return this.customerRepository.save(newCustomer);
  }

  async update(id: number, changes: UpdateCustomerDto) {
    // const customer = this.findOne(id);
    // const index = this.customers.findIndex((item) => item.id === id);
    // this.customers[index] = {
    //   ...customer,
    //   ...changes,
    // };
    // return this.customers[index];
    // return null;
    const customer = await this.findOne(id);
    this.customerRepository.merge(customer, changes);
    return this.customerRepository.save(customer);

  }

  remove(id: number) {
    // const index = this.customers.findIndex((item) => item.id === id);
    // if (index === -1) {
    //   throw new NotFoundException(`Customer #${id} not found`);
    // }
    // this.customers.splice(index, 1);
    // return true;
    return this.customerRepository.delete(id);

  }
}
