import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(products: any, term: any): any {
    if (term===undefined) return products;
    
    return products.filter(function(product){
      return product.title.toLowerCase().includes(term.toLowerCase());
    })
  }
  

}
