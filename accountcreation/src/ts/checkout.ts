import { Product, products } from './products';
import Rx from 'rxjs/Rx';

interface CheckoutData {
    product: Product;
    quantity: number;
    total: number;
}

class Checkout {
    public constructor() {

    }
}

class CheckoutItemDOM {
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
    public static generateProductCheckoutDOM(checkoutData: CheckoutData) {
        const productCheckout = document.createElement('div');
        productCheckout.classList.add('product-checkout');
        
        const productName = document.createElement('div');
        productName.innerText = checkoutData.product.name;

        const productQty = document.createElement('div');
        productQty.innerText = checkoutData.quantity.toString();

        const unitPriceDiv = document.createElement('div');
        const uom = document.createElement('div');
        uom.innerText = '£';
        const unitPrice = document.createElement('div');
        unitPrice.innerText = checkoutData.product.unitprice.toString();

        unitPriceDiv.appendChild(uom);
        unitPriceDiv.appendChild(unitPriceDiv);
        unitPriceDiv.classList.add('price');

        const totalPriceDiv = document.createElement('div');
        const totalPrice = document.createElement('div');
        totalPrice.innerText = checkoutData.total.toString();

        totalPriceDiv.appendChild(uom);
        totalPriceDiv.appendChild(totalPriceDiv);
        totalPriceDiv.classList.add('price');
        
        const checkoutActions = document.createElement('div');
        checkoutActions.classList.add('checkout-action');

        const reduce = document.createElement('div');
        reduce.classList.add('button', 'is-primary', 'reduce-product-qty', 'is-small');
        const increase = document.createElement('div');
        increase.classList.add('button', 'is-primary', 'increase-product-qty', 'is-small');
        checkoutActions.appendChild(reduce);
        checkoutActions.appendChild(increase);

        productCheckout.appendChild(productName);
        productCheckout.appendChild(productQty);
        productCheckout.appendChild(unitPriceDiv);
        productCheckout.appendChild(checkoutActions);
        productCheckout.appendChild(totalPrice);
    }
}