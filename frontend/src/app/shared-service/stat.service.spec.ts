import { TestBed, inject } from '@angular/core/testing';

import { StatService } from './stat.service';

describe('StatService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [StatService]
    });
  });

  it('should be created', inject([StatService], (service: StatService) => {
    expect(service).toBeTruthy();
  }));
});
