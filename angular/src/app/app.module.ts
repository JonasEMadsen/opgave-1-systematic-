import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { HeroComponent } from './hero/hero.component';
import { HeroService } from './hero/hero.service';
import { MessageComponent } from './message/message.component';
import { MessageService } from './message/message.service';

import { AppRoutingModule } from './app-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HeroDetailComponent } from './hero-details/hero-details.component';
import { HeroSearchComponent } from './hero-search/hero-search.component';

@NgModule( {
    declarations: [
        AppComponent,
        HeroComponent,
        HeroDetailComponent,
        MessageComponent,
        DashboardComponent,
        HeroSearchComponent,
    ],
    imports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        AppRoutingModule,
        HttpClientModule
    ],
    providers: [ HeroService, MessageService],
    bootstrap: [AppComponent],
    exports: [
              BrowserModule,
              FormsModule,
              ReactiveFormsModule
            ]
} )
export class AppModule { }
