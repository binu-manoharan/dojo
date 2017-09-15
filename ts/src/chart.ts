import * as nv from 'nvd3';
import * as d3 from 'd3';

export class Charting {
    public constructor() {

    }

    public createPieChart(svg: SVGElement) {
        nv.addGraph(() => {
            var chart = nv.models.pieChart()
                .x(function(d) { return d.label  + " aaaaaaaaaaaaaaaaaa bbbbbbbbbbbbbbbbbbb cccccccccccc dddddddddddddddddddddddd" })
                .y(function(d) { return d.value })
                .valueFormat(d3.format('d'))
                .showLabels(false);
          
            chart.tooltip.contentGenerator(d => `<div>${d.data.label} ${d.data.value}</div>`);
            chart.legend.rightAlign(false);
            chart.legend.padding(20);
            d3.select(svg)
                .datum(this.getPieChartData())
                .transition().duration(350)
                .call(chart);
          
            return chart;
          });
    }

    public createBarChart(svg: SVGElement) {
        nv.addGraph(() => {
            var chart = nv.models.discreteBarChart()
                .x(function (d) { return d.label})    //Specify the data accessors.
                .y(function (d) { return d.value })
                .staggerLabels(true)    //Too many bars and not enough room? Try staggering labels.
                .showValues(true)       //...instead, show the bar value right on top of each bar.
                ;

            d3.select(svg)
                .datum(this.getBarChartData())
                .call(chart);

            nv.utils.windowResize(chart.update);

            return chart;
        });
    }

    private getPieChartData() {
        return [
            {
                "label": "One",
                "value": 29.765957771107
            },
            {
                "label": "Two",
                "value": 0
            },
            {
                "label": "Three",
                "value": 32.807804682612
            },
            {
                "label": "Four",
                "value": 196.45946739256
            },
            {
                "label": "Five",
                "value": 0.19434030906893
            },
            {
                "label": "Six",
                "value": 98.079782601442
            },
            {
                "label": "Seven",
                "value": 13.925743130903
            },
            {
                "label": "Eight",
                "value": 5.1387322875705
            }
        ];
    }
    private getBarChartData() {
        return [
            {
                key: "Cumulative Return",
                values: [
                    {
                        "label": "A Label",
                        "value": -29.765957771107
                    },
                    {
                        "label": "B Label",
                        "value": 0
                    },
                    {
                        "label": "C Label",
                        "value": 32.807804682612
                    },
                    {
                        "label": "D Label",
                        "value": 196.45946739256
                    },
                    {
                        "label": "E Label",
                        "value": 0.19434030906893
                    },
                    {
                        "label": "F Label",
                        "value": -98.079782601442
                    },
                    {
                        "label": "G Label",
                        "value": -13.925743130903
                    },
                    {
                        "label": "H Label",
                        "value": -5.1387322875705
                    }
                ]
            }
        ]
    }
}