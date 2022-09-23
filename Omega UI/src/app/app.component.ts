import {ChangeDetectionStrategy, Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from 'rxjs';


@Component({
  changeDetection: ChangeDetectionStrategy.OnPush,
  selector: 'app-root',
  templateUrl: './app.component.html'
})

export class AppComponent implements OnDestroy, OnInit {

  constructor(
 
  ) {
  }

  ngOnInit(): void {
  }

  ngOnDestroy() {
  }

}
