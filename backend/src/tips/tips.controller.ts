// src/tips/tips.controller.ts
import { Controller, Post, Get, Put, Delete, Body, Param, Req } from '@nestjs/common';
import { TipsService } from './tips.service';
import { CreateTipDto } from './dto/create-tip.dto';
import { UpdateTipDto } from './dto/update-tip.dto';
import { User } from 'src/users/user.entity';
@Controller('tips')
export class TipsController {
    constructor(private readonly tipsService: TipsService) {}

    @Post()
    async create(@Body() createTipDto: CreateTipDto, @Req() request: any) {
        const user: User = request.user; // Assuming user is set in request after authentication
        return this.tipsService.create(createTipDto, user);
    }

    @Get()
    async findAll() {
        return this.tipsService.findAll();
    }

    @Put(':id')
    async update(@Param('id') id: number, @Body() updateTipDto: UpdateTipDto, @Req() request: any) {
        const user: User = request.user;
        return this.tipsService.update(id, updateTipDto);
    }

    @Delete(':id')
    async delete(@Param('id') id: number, @Req() request: any) {
        const user: User = request.user;
        return this.tipsService.delete(id);
    }
}