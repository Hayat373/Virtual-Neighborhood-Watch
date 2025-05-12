// src/incidents/entity/incident.entity.ts
import { Entity, Column, PrimaryGeneratedColumn, ManyToOne } from 'typeorm';
import { User } from 'src/users/user.entity';
@Entity()
export class Incident {
  @PrimaryGeneratedColumn()
  id: number;

  @Column()
  title: string;

  @Column()
  location: string;

  @Column('text')
  description: string;

  @ManyToOne(() => User, (user) => user.incidents)
  user: User;
}