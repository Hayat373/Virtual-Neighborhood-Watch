// src/tips/tips.service.ts
import { Injectable, NotFoundException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { Tip } from './entitiy/tip.entitiy';
import { CreateTipDto } from './dto/create-tip.dto';
import { UpdateTipDto } from './dto/update-tip.dto';
import { User } from 'src/users/user.entity';
@Injectable()
export class TipsService {
    constructor(
        @InjectRepository(Tip)
        private tipsRepository: Repository<Tip>,
    ) {}

    async create(createTipDto: CreateTipDto, user: User): Promise<Tip> {
        const tip = this.tipsRepository.create({ ...createTipDto, createdBy: user });
        return this.tipsRepository.save(tip);
    }

    async findAll(): Promise<Tip[]> {
        return this.tipsRepository.find({ relations: ['createdBy'] });
    }


    async update(id: number, updateIncidentDto: UpdateTipDto): Promise<Tip> {
        // Use an options object to find the incident by ID
        const incident = await this.tipsRepository.findOne({ where: { id } });
        if (!incident) {
            throw new NotFoundException(`Incident with ID ${id} not found`);
        }
        // Update the incident with the new data
        Object.assign(incident, updateIncidentDto);
        return this.tipsRepository.save(incident);
    }

    // async update(id: number, updateTipDto: UpdateTipDto, user: User): Promise<Tip> {
    //     const tip = await this.tipsRepository.findOne({ where: { id } });
    //     if (!tip) {
    //         throw new NotFoundException(`Tip with ID ${id} not found`);
    //     }
    //     if (tip.createdBy.id !== user.id) {
    //         throw new Error("Only the creator can update this tip");
    //     }
    //     Object.assign(tip, updateTipDto);
    //     return this.tipsRepository.save(tip);
    // }

    // async delete(id: number, user: User): Promise<void> {
    //     const tip = await this.tipsRepository.findOne({ where: { id } });
    //     if (!tip) {
    //         throw new NotFoundException(`Tip with ID ${id} not found`);
    //     }
    //     if (tip.createdBy.id !== user.id) {
    //         throw new Error("Only the creator can delete this tip");
    //     }
    //     await this.tipsRepository.remove(tip);
    // }

    async delete(id: number): Promise<void> {
        const result = await this.tipsRepository.delete(id);
        if (result.affected === 0) {
          throw new NotFoundException(`Tip with ID ${id} not found`);
        }
      }
}