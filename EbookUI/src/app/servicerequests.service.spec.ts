import { TestBed, inject } from '@angular/core/testing';

import { ServicerequestsService } from './servicerequests.service';

describe('ServicerequestsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ServicerequestsService]
    });
  });

  it('should be created', inject([ServicerequestsService], (service: ServicerequestsService) => {
    expect(service).toBeTruthy();
  }));
});
