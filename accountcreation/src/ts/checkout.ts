import { Product, products } from './products';
import * as Rx from 'rxjs/Rx';

interface CheckoutData {
    product: Product;
    quantity: number;
    total: number;
}

export class CheckoutPage {
    public static setupCheckoutPage(renderTo: HTMLDivElement) {
        const allCheckoutData: CheckoutItem[] =[];
        for (const product of products) {
            const checkoutData = {
                product: product,
                quantity: 0,
                total: 0
            };

            allCheckoutData.push(new CheckoutItem(checkoutData));
        }

        const checkout = new Checkout(allCheckoutData);

        renderTo.appendChild(checkout.generateCheckoutContentDOM());
    }
}

class Checkout {
    private total: number;

    private documentFragment: DocumentFragment;

    public constructor(private checkoutItems: CheckoutItem[] = []) {
        this.total = 0;
        this.documentFragment = document.createDocumentFragment();
    }

    public addItemForCheckout(checkoutItem: CheckoutItem) {
        this.checkoutItems.push(checkoutItem);
    }

    public generateCheckoutContentDOM(): DocumentFragment {
        
        for (const checkoutItem of this.checkoutItems) {
            this.documentFragment.appendChild(checkoutItem.generateProductCheckoutDOM());
        }

        return this.documentFragment;
    }

    
}

class CheckoutItem {
    // <div class="product-checkout">
    //     <div>Potato</div>
    //     <div>1</div>
    //     <div class="price">
    //         <div>£</div>
    //         <div>10</div>
    //     </div>
    //     <div class="checkout-action">
    //         <div class="button is-primary reduce-product-qty is-small">-</div>
    //         <div class="button is-primary increase-product-qty is-small">+</div>
    //     </div>
    //     <div class="price">
    //         <div>£</div>
    //         <div>10</div>
    //     </div>
    // </div>

    public constructor(private checkoutData: CheckoutData) {}

    public generateProductCheckoutDOM(): HTMLDivElement {
        const productCheckout = document.createElement('div');
        productCheckout.classList.add('product-checkout');
        
        const productName = document.createElement('div');
        productName.classList.add('product-name')
        productName.innerText = this.checkoutData.product.name;

        const productQty = document.createElement('div');
        productQty.classList.add('qty');
        productQty.innerText = this.checkoutData.quantity.toString();

        const unitPriceDiv = document.createElement('div');
        unitPriceDiv.classList.add('price');
        const uom = document.createElement('div');
        uom.innerText = '£';
        const unitPrice = document.createElement('div');
        unitPrice.innerText = this.checkoutData.product.unitprice.toString();

        unitPriceDiv.appendChild(uom);
        unitPriceDiv.appendChild(unitPrice);

        const totalPriceDiv = document.createElement('div');
        totalPriceDiv.classList.add('total');
        const totalPrice = document.createElement('div');
        totalPrice.innerText = this.checkoutData.total.toString();
        const uom2 = document.createElement('div');
        uom2.innerText = '£';

        totalPriceDiv.appendChild(uom2);
        totalPriceDiv.appendChild(totalPrice);
        totalPriceDiv.classList.add('price');
        
        const checkoutActions = document.createElement('div');
        checkoutActions.classList.add('checkout-action');

        const reduce = document.createElement('div');
        reduce.classList.add('button', 'is-primary', 'reduce-product-qty', 'is-small');
        reduce.innerText = '-';
        Rx.Observable.fromEvent(reduce, 'click')
            .subscribe(() => {
                this.checkoutData.total = this.checkoutData.total - this.checkoutData.product.unitprice
                totalPrice.innerText = this.checkoutData.total.toString();
                this.updateCheckoutTotal(this.checkoutData.product.unitprice);
            });

        const increase = document.createElement('div');
        increase.classList.add('button', 'is-primary', 'increase-product-qty', 'is-small');
        increase.innerText = '+';
        Rx.Observable.fromEvent(increase, 'click')
            .subscribe(() => { 
                this.checkoutData.total = this.checkoutData.total + this.checkoutData.product.unitprice
                totalPrice.innerText = this.checkoutData.total.toString();
                this.updateCheckoutTotal(this.checkoutData.product.unitprice);
            });
        checkoutActions.appendChild(reduce);
        checkoutActions.appendChild(increase);

        productCheckout.appendChild(productName);
        productCheckout.appendChild(productQty);
        productCheckout.appendChild(unitPriceDiv);
        productCheckout.appendChild(checkoutActions);
        productCheckout.appendChild(totalPriceDiv);

        return productCheckout;
    }
    
    private updateCheckoutTotal(price: number) {
        const totalDiv = document.getElementById('checkout-total');
        const total = parseInt(totalDiv.innerText);

        totalDiv.innerText = (total + price).toString();
    }
}