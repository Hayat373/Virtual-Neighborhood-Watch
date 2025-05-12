import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { UsersModule } from './users/users.module';
import { AuthModule } from './auth/auth.module';
import { User } from './users/user.entity';
import { Incident } from './incidents/entity/incident.entity';
import { Tip } from './tips/entitiy/tip.entitiy';
import { TipsModule } from './tips/tips.module';
import { IncidentsModule } from './incidents/incidents.module';


@Module({
  imports: [
    TypeOrmModule.forRoot({
      type: 'postgres',
      host: 'localhost',
      port: 5432,
      username: 'postgres',
      password: 'zikra',
      database: 'neighbourhoodwatch_database',
      entities: [User, Incident, Tip],
      synchronize: true, // AUTO-create tables in dev (turn off in production)
    }),
    UsersModule,
    AuthModule,
    IncidentsModule,
    TipsModule
  ],
})
export class AppModule {}
