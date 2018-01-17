import { Component, Input } from '@angular/core';
import { Review } from '../shared/review';
@Component({
  selector: 'app-review-item',
  templateUrl: './review-item.component.html',
  styleUrls: ['./review-item.component.css']
})
export class ReviewItemComponent{

  @Input() review: Review;
  constructor() { }

  

}
