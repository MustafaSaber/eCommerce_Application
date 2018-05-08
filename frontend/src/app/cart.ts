import { Prod } from './prod';
import { User } from './user';

export class Cart {
    cartID:Number;
    products:Prod[];
    owner:User;
    total_price:Number;
}
