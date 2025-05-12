// src/tips/entity/tip.entity.ts
import { Entity, PrimaryGeneratedColumn, Column, ManyToOne } from 'typeorm';
import { User } from 'src/users/user.entity';

@Entity()
export class Tip {
    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    description: string;

    @ManyToOne(() => User, (user) => user.tips)
    createdBy: User; // Relation to the User who created the Tip
}