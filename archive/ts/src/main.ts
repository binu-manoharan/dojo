import { sayHello } from './greet';
import { Charting } from './chart';

function $1(id: string): HTMLElement {
    return document.getElementById(id);
} 

function showHello(divName: string, name: string) {
    const element = $1(divName);
    element.innerText = sayHello(name);

    const chartMessage = $1('charting-msg');
    chartMessage.innerText = 'A chart';


    const charting = new Charting();
    const chartSvg = document.createElementNS('http://www.w3.org/2000/svg', 'svg');
    charting.createPieChart(chartSvg);

    const chart = $1('chart') as HTMLElement;
    chart.appendChild(chartSvg);
}

showHello('greeting', 'NVD3');