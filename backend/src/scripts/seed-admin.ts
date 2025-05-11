// src/scripts/seed-admin.ts
import { NestFactory } from '@nestjs/core';
import { AppModule } from '../app.module';
import { getRepository } from 'typeorm';
import { User } from '../users/user.entity';
import * as bcrypt from 'bcrypt';
import { UserRole } from '../users/user.entity';

async function bootstrap() {
  const app = await NestFactory.createApplicationContext(AppModule);
  const userRepository = getRepository(User);

  const existingAdmin = await userRepository.findOne({ where: { email: 'admin@example.com' } });
  if (existingAdmin) {
    console.log('Admin already exists.');
    process.exit(0);
  }

  const admin = new User();
  admin.email = 'admin@example.com';
  admin.password = await bcrypt.hash('adminpassword', 10);
  admin.role = UserRole.ADMIN;
  await userRepository.save(admin);
  console.log('Admin user created.');

  await app.close();
}
bootstrap();
