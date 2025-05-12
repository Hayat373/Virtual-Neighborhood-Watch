import { Test, TestingModule } from '@nestjs/testing';
import { TipsController } from './tips.controller';

describe('TipsController', () => {
  let controller: TipsController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [TipsController],
    }).compile();

    controller = module.get<TipsController>(TipsController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
