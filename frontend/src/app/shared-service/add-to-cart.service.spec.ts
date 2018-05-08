import { TestBed, inject } from '@angular/core/testing';

import { AddToCartService } from './add-to-cart.service';

describe('AddToCartService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AddToCartService]
    });
  });

  it('should be created', inject([AddToCartService], (service: AddToCartService) => {
    expect(service).toBeTruthy();
  }));
});
