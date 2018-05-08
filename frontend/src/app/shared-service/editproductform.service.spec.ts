import { TestBed, inject } from '@angular/core/testing';

import { EditproductformService } from './editproductform.service';

describe('EditproductformService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EditproductformService]
    });
  });

  it('should be created', inject([EditproductformService], (service: EditproductformService) => {
    expect(service).toBeTruthy();
  }));
});
