import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { User } from './user.entity'; // Adjust the path as necessary
import { CreateUserDto } from './dto/create_user.dto';
import { UserRole } from './user.entity'; 


@Injectable()
export class UsersService {
  constructor(
    @InjectRepository(User)
    private usersRepository: Repository<User>,
  ) {}

  async findAll(): Promise<User[]> {
    return this.usersRepository.find();
  }

  async getAllUsers(): Promise<User[]> {
    return this.usersRepository.find();
  }

  async findByEmail(email: string): Promise<User | null> {
    return this.usersRepository.findOne({ where: { email } });
  }
  
  async findByUsername(username: string): Promise<User | null> {
    return this.usersRepository.findOne({ where: { username } });
  }
  async findByLocation(location: string): Promise<User[]> {
    return this.usersRepository.find({ where: { location } });
  }
  

  async createUser(createUserDto: CreateUserDto): Promise<User> {
    const user = this.usersRepository.create(createUserDto); // Create a user entity from the DTO
    return this.usersRepository.save(user); // Save the user in the database and return the full entity
  }


  async findByRole(role: UserRole) {
    return this.usersRepository.find({ where: { role } });
  }

  async deleteUser(id: string): Promise<void> {
    const user = await this.usersRepository.findOne({ where: { id: parseInt(id) } });
    if (!user) {
      throw new Error('User not found');
    }
    await this.usersRepository.remove(user);  // Delete the user from the DB
  }
  
}
