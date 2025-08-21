import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IVehicle } from './ivehicle';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {
  constructor(private http:HttpClient){}

  getVehicles():Observable<IVehicle[]>{
    return this.http.get<IVehicle[]>('http://localhost:3000/vehicles');
  }

  getVehicleById(vehicleid:string):Observable<IVehicle>{
 return this.http.get<IVehicle>('http://localhost:3000/vehicles/'+vehicleid);
  }

  updateVehicle(vehicle:IVehicle): Observable<IVehicle>{
    return this.http.put<IVehicle>(`http://localhost:3000/vehicles/${vehicle.id}`,vehicle);

  }

 deleteVehicleById(vehicleId: string): Observable<void> {
  return this.http.delete<void>(`http://localhost:3000/vehicles/${vehicleId}`);
}

saveVehicle(vehicle:IVehicle):Observable<IVehicle>{
  let vehicleSave :Partial<IVehicle>={
    // "make": "Toyota",
    // "fuelType": "Petrol",
    // "model": "Corolla",
    // "price": 15000,
    // "id": "aa9e"
    make:vehicle.make,
    fuelType:vehicle.fuelType,
    model:vehicle.model,
    price:vehicle.price

  }
  return this.http.post<IVehicle>('http://localhost:3000/vehicles',vehicleSave);
}
  
}
