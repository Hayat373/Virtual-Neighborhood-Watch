
import { IsOptional, IsNotEmpty } from 'class-validator';

export class UpdateIncidentDto {
  @IsOptional()
  @IsNotEmpty()
  title?: string;

  @IsOptional()
  @IsNotEmpty()
  location?: string;

  @IsOptional()
  @IsNotEmpty()
  description?: string;
}