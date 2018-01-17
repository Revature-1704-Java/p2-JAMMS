import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BookService } from './shared/book.service';
import { BookItemComponent } from './book-item/book-item.component';
import { BookModificationComponent } from './book-modification/book-modification.component';
import { ReviewService } from './shared/review.service';
import { ReviewItemComponent } from './review-item/review-item.component';
import { SubmitNewBookComponent } from './submit-new-book/submit-new-book.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    BookItemComponent,
    HomeComponent,
    BookModificationComponent,
    ReviewItemComponent,
    SubmitNewBookComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {path:'', component: HomeComponent},
      {path: 'books/:bookId', component: BookItemComponent}      
    ]),
    FormsModule
  ],
  providers: [BookService, ReviewService],
  bootstrap: [AppComponent]
})
export class AppModule { }
