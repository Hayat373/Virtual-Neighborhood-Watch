// src/tips/tips.module.ts
import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { TipsService } from './tips.service';
import { TipsController } from './tips.controller';
import { Tip } from './entitiy/tip.entitiy';

@Module({
    imports: [TypeOrmModule.forFeature([Tip])],
    controllers: [TipsController],
    providers: [TipsService],
})
export class TipsModule {}