import { Author } from './author';

export interface Book
{
  id: number;
  title: string;
  author: Author;
  description: string;
  publishedDate: Date;
  listPrice: number;
  discount: number;
}