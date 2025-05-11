// src/incidents/incidents.service.ts
import { Injectable, NotFoundException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { Incident } from './entity/incident.entity';
import { CreateIncidentDto } from './dto/create-incident.dto';
import { UpdateIncidentDto } from './dto/update-incident.dto';
import { User } from 'src/users/user.entity';

@Injectable()
export class IncidentsService {
  constructor(
    @InjectRepository(Incident)
    private incidentsRepository: Repository<Incident>,
  ) {}

  async create(createIncidentDto: CreateIncidentDto, user: User): Promise<Incident> {
    const incident = this.incidentsRepository.create({ ...createIncidentDto, user });
    return this.incidentsRepository.save(incident);
  }

  async update(id: number, updateIncidentDto: UpdateIncidentDto): Promise<Incident> {
    // Use an options object to find the incident by ID
    const incident = await this.incidentsRepository.findOne({ where: { id } });
    if (!incident) {
        throw new NotFoundException(`Incident with ID ${id} not found`);
    }
    // Update the incident with the new data
    Object.assign(incident, updateIncidentDto);
    return this.incidentsRepository.save(incident);
}

async findOne(id: number): Promise<Incident> {
    const incident = await this.incidentsRepository.findOne({ where: { id } }); // Use options object
    if (!incident) {
        throw new NotFoundException(`Incident with ID ${id} not found`);
    }
    return incident;
}

async findAll(): Promise<Incident[]> {
  return this.incidentsRepository.find();
}

  async findAllByUser(userId: number): Promise<Incident[]> {
    return this.incidentsRepository.find({ where: { user: { id: userId } } });
  }

  async delete(id: number): Promise<void> {
    const result = await this.incidentsRepository.delete(id);
    if (result.affected === 0) {
      throw new NotFoundException(`Incident with ID ${id} not found`);
    }
  }
}