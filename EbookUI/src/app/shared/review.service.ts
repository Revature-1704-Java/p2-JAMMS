import { Injectable } from '@angular/core';
import { Review } from './review';

@Injectable()
export class ReviewService {

  constructor() { }
  
  getReviews(): Review[] {
    return reviews;
  }
  
  getReviewById(reviewId: number) {    
    return reviews.find(r => r.id === reviewId);
  }

}

const reviews = [
  {
    id: 1,
    customerName: 'Customer',
    bookId: 1,
    dateAdded: new Date('2018-01-16'),
    ratingNum: 1,
    review: 'REVIEW_1'
  },
  {
    id: 2,
    customerName: 'Customer',
    bookId: 2,
    dateAdded: new Date('2018-01-16'),
    ratingNum: 2,
    review: 'REVIEW_2'
  }
]
