import { Entity, Column, PrimaryGeneratedColumn } from 'typeorm';
import { Incident } from 'src/incidents/entity/incident.entity';
import { Tip } from 'src/tips/entitiy/tip.entitiy';
import { OneToMany } from 'typeorm';

export enum UserRole {
  USER = 'user',
  ADMIN = 'admin',
}
@Entity()
export class User {
  @PrimaryGeneratedColumn()
  id: number;

  @Column({ unique: true })
  email: string;

  @Column({ unique: true })
  username: string;

  @Column()
  password: string;

  @Column() 
  location: string;

  @OneToMany(() => Incident, (incident) => incident.user)
  incidents: Incident[];

  @OneToMany(() => Tip, (tip) => tip.createdBy)
  tips: Tip[];

  

  @Column({ type: 'enum', enum: UserRole, default: UserRole.USER })
role: UserRole;
}


export enum UserLocation {
  SIX_K = '6k',
  FIVE_K = '5k',
  FOUR_K = '4k',
  SEFERE_SELAM = 'sefereselam',
  LDETA = 'ldeta',
  COMMERCE = 'commerce',
}
