// src/incidents/incidents.controller.ts
import { Controller, Post, Body, Get, Param, Put, Delete, Req } from '@nestjs/common';
import { IncidentsService } from './incidents.service';
import { CreateIncidentDto } from './dto/create-incident.dto';
import { UpdateIncidentDto } from './dto/update-incident.dto';
import { Incident } from './entity/incident.entity';
import { User } from 'src/users/user.entity';
@Controller('incidents')
export class IncidentsController {
  constructor(private readonly incidentsService: IncidentsService) {}

  @Post()
  async create(@Body() createIncidentDto: CreateIncidentDto, @Req() request: any): Promise<Incident> {
    const user: User = request.user; // Assuming user is set in request after authentication
    return this.incidentsService.create(createIncidentDto, user);
  }

  @Get()
  async findAll(): Promise<Incident[]> {
    return this.incidentsService.findAll();
  }

  @Put(':id')
  async update(@Param('id') id: number, @Body() updateIncidentDto: UpdateIncidentDto): Promise<Incident> {
    return this.incidentsService.update(id, updateIncidentDto);
  }

  @Get(':id')
  async findOne(@Param('id') id: number): Promise<Incident> {
    return this.incidentsService.findOne(id);
  }

  @Get('user/:userId')
  async findAllByUser(@Param('userId') userId: number): Promise<Incident[]> {
    return this.incidentsService.findAllByUser(userId);
  }


  @Delete(':id')
  async delete(@Param('id') id: number): Promise<void> {
    return this.incidentsService.delete(id);
  }
}