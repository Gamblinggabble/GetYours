import { Product } from "./Product";
import { Website } from "./Website";

export interface Item {
    item_url: string,
    product?: Product,
    website?: Website,
    initialPrice?: string,
    newPrice: string,
    picture_url?: string,
}
