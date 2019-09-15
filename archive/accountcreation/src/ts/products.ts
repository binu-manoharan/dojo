export interface Product {
    name: string;
    unitprice: number;
}

export const products: Product[] = [
    { name: 'Apple', unitprice: 10 },
    { name: 'Banana', unitprice: 5 },
    { name: 'Peach', unitprice: 15 },
    { name: 'Orange', unitprice: 25 },
    { name: 'Mango', unitprice: 20 }
];