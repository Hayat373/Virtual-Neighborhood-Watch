import { Controller } from '@nestjs/common';
import { Get } from '@nestjs/common';
import { UsersService } from './users.service';
import { User } from './user.entity'; // Import the User entity
import { UserRole } from './user.entity'; 
import { Delete, Param } from '@nestjs/common';


@Controller('users')
export class UsersController {
  constructor(private readonly usersService: UsersService) {}

  // GET endpoint to retrieve all users
  @Get()
  async findAll(): Promise<User[]> {
    return this.usersService.findAll();
  }

  @Get('admin')
  async getAdmin() {
    return await this.usersService.findByRole(UserRole.ADMIN);
  }
  
  @Delete(':id')
async deleteUser(@Param('id') id: string) {
  return this.usersService.deleteUser(id);
}



}


