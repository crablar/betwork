$(function () {
    console.log($('#container').highcharts);
    $('#container').highcharts({
        title: {
            text: 'Monthly Average Temperature',
            x: -20 //center
        },
        subtitle: {
            text: 'Source: WorldClimate.com',
            x: -20
        },
        xAxis: {
			categories: ["1/8/18/26","1/8/18/27","1/8/18/28","1/8/18/29","1/8/18/30","1/8/18/31","1/8/18/32","1/8/18/33","1/8/18/34","1/8/18/35"],
        },
        yAxis: {
            title: {
                text: 'Temperature (°C)'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '°C'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: 'Tokyo',
			data: [92574564,92574564,92574564,92574564,92574564,92574564,92574564,92574564,92574564,92574564,]
        }]
    });
});
