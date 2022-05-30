import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HeroComponent } from './hero/hero.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HeroDetailComponent } from './hero-details/hero-details.component';

const routes: Routes = [
    { path: 'heroes', component: HeroComponent },
    { path: 'dash', component: DashboardComponent },
    { path: '', redirectTo: '/dash', pathMatch: 'full' },
    { path: 'detail/:id', component: HeroDetailComponent },
];

@NgModule( {
    imports: [RouterModule.forRoot( routes )],
    exports: [RouterModule]
} )
export class AppRoutingModule {


}
