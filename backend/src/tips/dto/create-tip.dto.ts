
import { IsNotEmpty } from 'class-validator';

export class CreateTipDto {
    @IsNotEmpty()
    description: string;
}