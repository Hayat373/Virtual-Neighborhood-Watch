
import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { IncidentsController } from './incidents.controller';
import { IncidentsService } from './incidents.service';
import { Incident } from './entity/incident.entity';

@Module({
  imports: [TypeOrmModule.forFeature([Incident])],
  controllers: [IncidentsController],
  providers: [IncidentsService],
})
export class IncidentsModule {}