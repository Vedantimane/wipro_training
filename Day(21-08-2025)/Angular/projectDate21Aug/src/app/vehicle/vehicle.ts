import { ChangeDetectorRef, Component, NgModule } from '@angular/core';
import { VehicleService } from '../vehicle-service';
import { IVehicle } from '../ivehicle';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-vehicle',
  imports: [CommonModule,FormsModule],
  templateUrl: './vehicle.html',
  styleUrl: './vehicle.css'
})
export class Vehicle {

  constructor(private vehicleService: VehicleService, private cdr: ChangeDetectorRef) { }

  vehicles: IVehicle[] = [];
  vehicleEdit: IVehicle = {
    id: '',
    make: '',
    fuelType: '',
    model: '',
    price: 0
  };
  vehicleAdd: IVehicle = {
    id: '',
    make: '',
    fuelType: '',
    model: '',
    price: 0
  };

  ngOnInit() {
    this.vehicleService.getVehicles().subscribe((data: IVehicle[]) => {
      console.log('Data received:', data);
      this.vehicles = data;
      this.cdr.detectChanges();
      console.log('Vehicles fetched successfully:', this.vehicles);
    }, (error) => {
      console.error('Error fetching vehicles:', error);
    });
  }

  edit(vehicleId: string) {
    console.log('Edit vehicle with ID:', vehicleId);
    this.vehicleService.getVehicleById(vehicleId).subscribe((vehicle: IVehicle) => {
      console.log('Vehicle details:', vehicle);
      this.vehicleEdit = vehicle;
      console.log('Vehicle for editing:', this.vehicleEdit);
      this.cdr.detectChanges();
    }, (error) => {
      console.error('Error fetching vehicle by ID:', error);
    });
  }

  update() {
    console.log('Updating vehicle:', this.vehicleEdit);
    this.vehicleService.updateVehicle(this.vehicleEdit).subscribe((updatedVehicle: IVehicle) => {
      console.log('Vehicle updated successfully:', updatedVehicle);
      const index = this.vehicles.findIndex(v => v.id === updatedVehicle.id);
      if (index !== -1) {
        this.vehicles[index] = updatedVehicle;
      }
      this.vehicleEdit = {
        id: '',
        make: '',
        fuelType: '',
        model: '',
        price: 0
      };
      this.cdr.detectChanges();
      this.ngOnInit();
    }, (error) => {
      console.error('Error updating vehicle:', error);
    });
  }

  delete(vehicleId: string) {
    this.vehicleService.deleteVehicleById(vehicleId).subscribe(() => {
      console.log('Vehicle deleted successfully:', vehicleId);
      this.vehicles = this.vehicles.filter(v => v.id !== vehicleId);
      this.cdr.detectChanges();
      this.ngOnInit();
    }, (error) => {
      console.error('Error deleting vehicle:', error);
    });
  }

  save() {
    console.log("Saving vehicle:", this.vehicleAdd);
    this.vehicleService.saveVehicle(this.vehicleAdd).subscribe((newVehicle: IVehicle) => {
      console.log('Vehicle saved successfully:', newVehicle);
      this.vehicles.push(newVehicle);
      this.vehicleAdd = {
        id: '',
        make: '',
        fuelType: '',
        model: '',
        price: 0
      };
      this.cdr.detectChanges();
    }, (error) => {
      console.error('Error saving vehicle:', error);
    });
  }
}