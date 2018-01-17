export interface Review
{
  id: number;
  customerName: string;
  bookId: number;
  dateAdded: Date;
  ratingNum: number;
  review: string;
}