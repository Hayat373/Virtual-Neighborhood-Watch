
import { IsNotEmpty } from 'class-validator';

export class CreateIncidentDto {
  @IsNotEmpty()
  title: string;

  @IsNotEmpty()
  location: string;

  @IsNotEmpty()
  description: string;
}