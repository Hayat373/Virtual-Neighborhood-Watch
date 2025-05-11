import { Injectable, Logger } from '@nestjs/common';
import { UsersService } from '../users/users.service';
import * as bcrypt from 'bcryptjs';
import { JwtService } from '@nestjs/jwt';
import { CreateUserDto } from '../users/dto/create_user.dto';

@Injectable()
export class AuthService {
  private readonly logger = new Logger(AuthService.name);

  constructor(
    private usersService: UsersService,
    private jwtService: JwtService,
  ) {}

  async validateUser(email: string, password: string): Promise<any> {
    const user = await this.usersService.findByEmail(email); // Or `findByEmail`
    if (user && await bcrypt.compare(password, user.password)) {
      const safeUser = {
        email: user.email,
        role: user.role,
      };
  
      console.log('✅ Validated user:', safeUser); // Add this for debugging
  
      return safeUser;
    }
  
    console.log('❌ Invalid credentials for email:', email);
    return null;
  }
  
  

  async login(user: any) {
    console.log('👉 Logging in user:', user); // Check if id, email, role exist
  
    const payload = {
      sub: user.id,      // User ID in 'sub' (subject)
      email: user.email,
      role: user.role,
      
    };
  
    console.log('🔐 JWT Payload:', payload);
  
    const access_token = this.jwtService.sign(payload);
  
    return {
      access_token,
      role: user.role,
      userId: user.id,
    };
  }
  

  async register(createUserDto: CreateUserDto) {
    const hashedPassword = await bcrypt.hash(createUserDto.password, 10);
    const user = await this.usersService.createUser({
      ...createUserDto,
      password: hashedPassword,
    });
    const { password, ...result } = user;
    return result;
  }
}
