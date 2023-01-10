import { TestBed } from '@angular/core/testing';

import { CleoServiceService } from './cleo-service.service';

describe('CleoServiceService', () => {
  let service: CleoServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CleoServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
