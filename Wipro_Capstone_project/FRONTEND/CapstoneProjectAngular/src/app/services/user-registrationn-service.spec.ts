import { TestBed } from '@angular/core/testing';

import { UserRegistrationnService } from './user-registrationn-service';

describe('UserRegistrationnService', () => {
  let service: UserRegistrationnService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserRegistrationnService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
