import { Controller, Post, Body } from '@nestjs/common';
import { AuthService } from './auth.service';
import { CreateUserDto } from '../users/dto/create_user.dto'; // Adjust the path as necessary
import { Logger } from '@nestjs/common';
import { LoginDto } from './dto/login.dto'; // Adjust the path as necessary

@Controller('auth')
export class AuthController {
  constructor(private authService: AuthService) {}
  private readonly logger = new Logger(AuthController.name); // Declare and initialize logger


  @Post('login')
  async login(@Body() loginDto: LoginDto) {
    // Log the incoming request
    this.logger.log(`Login attempt with email: ${loginDto.email}`);
    this.logger.debug(`Request Payload: ${JSON.stringify(loginDto)}`);
    console.log('Received login request:', loginDto);

    const user = await this.authService.validateUser(loginDto.email, loginDto.password);

    if (!user) {
      this.logger.warn(`Login failed for email: ${loginDto.email}`);
      return { message: 'Invalid credentials' };
    }

    const response = await this.authService.login(user);

    this.logger.debug(`Response sent: ${JSON.stringify(response)}`);

    return response;
  }

  @Post('register')
  async register(@Body() body: CreateUserDto) { console.log(body);// Use CreateUserDto here
    return this.authService.register(body);
  }
}