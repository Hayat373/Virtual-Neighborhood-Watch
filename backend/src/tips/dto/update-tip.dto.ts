import { IsNotEmpty } from 'class-validator';

export class UpdateTipDto {
    @IsNotEmpty()
    description: string;
}