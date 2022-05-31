import { Component, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


import { Hero } from './hero';
import { HeroService } from './hero.service';

@Component({
  selector: 'app-hero',
  templateUrl: './hero.component.html',
  styleUrls: ['./hero.component.css']
})
export class HeroComponent implements OnInit {
  heroes: Hero[] = [];

  constructor(private heroService: HeroService) { }

  ngOnInit() {
    this.getHeroes();
  }

  getHeroes(): void {
    this.heroService.getHeroes()
      .subscribe(heroes => this.heroes = heroes);
  }

  add(name: string, email: string, city: string): void {
    name = name.trim();
    email = email.trim();
    city = city.trim();
    if (!name) { return; }
    this.heroService.addHero({ name, email, city } as Hero)
      .subscribe(hero => {
        if (hero != null) {
          this.heroes.push(hero);
        }
      });
  }

  delete(hero: Hero): void {
    this.heroes = this.heroes.filter(h => h !== hero);
    this.heroService.deleteHero(hero).subscribe();
  }
}
