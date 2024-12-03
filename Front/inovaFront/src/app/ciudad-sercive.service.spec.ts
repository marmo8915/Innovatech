import { TestBed } from '@angular/core/testing';

import { CiudadSerciveService } from './ciudad-sercive.service';

describe('CiudadSerciveService', () => {
  let service: CiudadSerciveService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CiudadSerciveService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
