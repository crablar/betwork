var arr;

$.getJSON("/sample_chart_data.json", function(json) {
    arr = json;
    for (var i = 0; i < arr.length; i++) {
        var chart = arr[i];
        for(var j = 1; j < chart.values.length; j++){
            chart.values[j] -= chart.values[j - 1];
        }
        chart.values[0] = 0;
        console.log(chart.subjectName);
        $(function () {
            new Highcharts.Chart({
                chart: {
                    renderTo: chart["subjectName"] + 'Chart'
                },
                title: {
                    text: chart.subjectName,
                    x: -20 //center
                },
                subtitle: {
                    text: 'Source: Facebook.com',
                    x: -20
                },
                xAxis: {
                    categories: chart.timestamps,
                },
                yAxis: {
                    title: {
                        text: chart.valueType
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    valueSuffix: ' likes'
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle',
                    borderWidth: 0
                },
                series: [{
                    name: chart.subjectName,
                    data: chart.values
                }]
            });
        });
    }

}); 
