import { IsString, IsEmail, IsEnum, IsNotEmpty } from 'class-validator';
import { UserRole, UserLocation } from '../user.entity'; // or from '../user.enums'

export class CreateUserDto {
  @IsString()
  @IsNotEmpty()
  username: string;

  @IsEmail()
  @IsNotEmpty()
  email: string;

  @IsString()
  @IsNotEmpty()
  password: string;

  @IsEnum(UserLocation)
  @IsNotEmpty()
  location: UserLocation;

  @IsEnum(UserRole)
  @IsNotEmpty()
  role: UserRole;
}
