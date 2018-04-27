import { TestBed, inject } from '@angular/core/testing';

import { BrandserviceService } from './brandservice.service';

describe('BrandserviceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BrandserviceService]
    });
  });

  it('should be created', inject([BrandserviceService], (service: BrandserviceService) => {
    expect(service).toBeTruthy();
  }));
});
